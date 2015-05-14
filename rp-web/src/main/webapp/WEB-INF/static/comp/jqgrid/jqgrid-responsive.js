/******************************************************jqGrid START**************************************************/
mediawidth = 0;
function jqgridResponsive(gridId,groupFlag,groupHeaders){
    $(window).resize(function(){
    	if( $("#screenWidth").width() != mediawidth){
    		mediawidth =  $("#screenWidth").width();
    		if(true == groupFlag){
    			$("#"+gridId).jqGrid('destroyGroupHeader');  
    			$("#"+gridId).setGridWidth(mediawidth );    
                $("#"+gridId).jqGrid('setGroupHeaders', { 
        			useColSpanStyle: true, 
        			groupHeaders:groupHeaders 
        		});  
    		}
    		else{
//                var arrtd = $("table[id*='grid']");//获取id中包含'grid'的table集合 
//                for (var i = 0; i < arrtd.length; i++) { 
//                }
    			$("#"+gridId).setGridWidth(mediawidth);  
    		}
    	}    
      });
}

function formToJson(formId){				
	var o = {};				
    var fields = $(formId).serializeArray();
    //去掉值为空的对象
    $.each(fields, function(i, field){
    	var VL= (field.value=="") ? null : field.value;
    	var nm = field.name;
    	if (o[nm]) {
            if (!o[nm].push) {//不是数组时
            	o[nm] = [ o[nm] ];
            	if(VL) o[nm].push(VL);
            }else{
            	if(VL) o[nm].push(VL);
            }
    	}else{
    		if(VL) o[nm] = VL;             
        }
    });
    //把对象里的数组-》字符串
    $.each(o, function(n, v){
    	if(v!=null && v.push)  o[n] = v.toString();
    });
    return o;	
}

//清空postData
function cleanPostData(postData){
	$.each(postData, function (k, v) {
        delete postData[k];
    });

}

/**
 * jgGrid插件封装。请在ready事件内调用。封装函数会提供一些默认配置，但options可以覆盖。
 * @param elementId 
 * @param options jqGrid的标准参数。
 */
function smartJgrid(elementId,options){
	$(function(){
		var defaultOpts={
				datatype : 'json',
				mtype : 'post',
				rowNum : 15,
				rowList : [15, 30, 50 ],
				height : '100%',
				autowidth : true,
				altRows : true,//隔行变色--斑马线
				viewrecords : true, //1 - 10　共 15 条
				recordpos : 'left', //viewrecords显示在左边
				emptyrecords : "没有可显示记录",
				sortorder : "asc",				
				loadonce : false,//非本地化数据
				jsonReader : {
					root : "rows",
					page : "page",
					total : "total",
					records : "records",
					repeatitems : false,
					cell : "cell",
					id : "id"
				}
				//caption:'表头',
				//hidegrid : false,
				//multiselect:true,//是否多选
				//shrinkToFit : false,//自动扩展,设置false,列太长则出现滚动条（可以在colModel中设置frozen:true）
				//editurl:"",
				
		}
		
		
		$.extend(defaultOpts,options);
		
		$("#"+elementId).jqGrid(defaultOpts);
		
		jqgridResponsive(elementId,false);
		
		
	});
}


 
/**
 * 自动刷新jqgrid
 * @param id
 * @param time
 */
function autoRefreshGrid(id,time){
	setTimeout(function(){
		$("#"+id).trigger("reloadGrid");
	},time);
}

/**
 * jqgrid效果化表格
 * @param id
 */
function  boingTable(grid){
	$(grid+"_subgrid" ).css({ "border-right-style": "none"}) ;
	$("span[class*='ui-icon-minus']").hide().parent().parent().unbind("click");
	$("span[class*='ui-icon-carat-1-sw']").hide();
	$(grid).children('tbody').children('tr').css({ "border-style": "none"}) ;
	$(grid).children('tbody').children('tr').children('td').css({ "border-style": "none"}) ;
}

/**
 * jqgrid追加行
 * @param id
 * @param time
 */
function  addTableRows(grid, url){
	var allData = {};
	var postData = $(grid).jqGrid("getGridParam", "postData");			
	var pages = Number($(grid).jqGrid("getGridParam", "page"));
	var records = $(grid).jqGrid("getGridParam", "records");

	var totlePage = Math.ceil(records / postData.rows) ;
	if(postData.page < totlePage){
		postData.page = pages + 1;
	}
	
	 $(grid).jqGrid('setGridParam',{page: pages });
	  $.ajax({
			url: url ,
			type: "get",
			dataType: 'json',
			async: false,
			data: postData,	  			
			success:function(data){
				var oldRecords = $(grid).jqGrid("getGridParam", "records");
				if(data.records > oldRecords){
					$(grid).jqGrid('setGridParam',{treeANode: -1} );//刷新,设置treeANode(-1),能追加
					//刷新所有的数据
					allData = refreshAllData(grid);					
				}else{
					
					$(grid).jqGrid('setGridParam',{treeANode: 0} );//追加,设置treeANode非(-1),才能追加
					$(grid)[0].addJSONData(data);
					allData = data;
				}				
		  	}
		});
	 return allData; 
}

function  refreshAllData(grid ){
	var param={};
	var postData = $(grid).jqGrid("getGridParam", "postData");
	$.each(postData, function(name, value){
		param[name] = value;
	});
	
	param.rows = postData.rows * postData.page;
	param.page = 1;
	
	var allData={};
	 $.ajax({
			url: $(grid).jqGrid("getGridParam", "url") ,
			type: "get",
			dataType: 'json',
			async: false,
			data: param,	  			
			success:function(data){
				$(grid).jqGrid("setGridParam", {rowNum: param.rows, page:1 });
				$(grid)[0].addJSONData(data);				
				allData= data;				

				$(grid).jqGrid("setGridParam", {rowNum: postData.rows, page:postData.page });
		  		}
		});
	 
	 return allData;
}

/******************************************************jqGrid END*********************************/