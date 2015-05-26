define(function(require,exports){
	
	require("jqueryplugin/jquery.form");
	var postId=$("#postId").val();
	if(postId){
		$.getJSON(contextPath+"/blog/getBlogContent?id="+postId,function(data){
			UE.getEditor('editor').setContent(data.postContent);
		});
	}
	
	//blog.jsp
	$('#edit_form').on('submit', function(e) {
	    e.preventDefault(); // prevent native submit
	    var postContent=UE.getEditor('editor').getContent(),
	    postContentFiltered=UE.getEditor('editor').getContentTxt();
	    $(this).ajaxSubmit({
	    	data:{postContent:postContent,postContentFiltered:postContentFiltered},
	    	success:function(data){
	    		if(data.state=='SUCCESS'){
	    			//保存成功后
	    			alert("添加成功");
	    			//关闭当前页面
	    			parent.layout.removeTab();
	    		}
	    		else
	    			alert('注册失败!');
			}
	    })
	});
	
	//list_post.jsp 博客列表
	require("jqgrid");
	require("common");
	//文章jqgrid初始化url
	var url=contextPath+"/blog";
	$("#postJqGrid").jqGrid({
		url : url+"/postGridInit",
	    datatype: "json",
	    height: "75%",
	    autowidth:true,
	    rowNum: 15,
	    rowList: [10,20,30],
	    colNames:['文章ID','作者', '标题','添加时间','修改时间','是否包含图片','是否包含代码','是否加密','状态','评论数'],
	    colModel:[
	        {name:'id',key:true, width:60, sortable:false},
	        {name:'postAuthorName', width:50, align:"center",sortable:false},
	        {name:'postTitle', width:150, sortable:false},
	        {name:'postDate', width:120, align:"center", sortable:false,formatter:priorityFullDateFormatter},
	        {name:'postModified', width:120, align:"center", sortable:false,formatter:priorityFullDateFormatter},        
	        {name:'hasPic', width:80,align:"center", sortable:false},
	        {name:'hasCode', width:80, align:"center", sortable:false},
	        {name:'postPassword', width:80, align:"center", sortable:false},
	        {name:'postStatus', width:80, align:"center", sortable:false},
	        {name:'commentCount', width:80, align:"center", sortable:false}
	    ],
	    pager: "#postJqGridPager",
	    viewrecords: true,
	    caption: '文章管理--<font color="red">publish(已发表)interrupt(中断)invalid(无效)</font>',
	    emptyrecords : "没有可显示记录",
	    hidegrid:false,
	    viewrecords:true,
	    recordpos:'left',
	    altRows: true,
		jsonReader : {
			root : "rows", 
			page : "page", 
			total : "total", 
			records : "records",
			repeatitems : false, 
			cell : "cell"
		}
	});
	$("#postJqGrid").jqGrid('navGrid', '#postJqGridPager', {
		edit : false,
		add : false,
		del : false,
		search : false,
		position : 'right'
	}).navButtonAdd('#postJqGridPager',{caption:"文章编辑",buttonicon:"ui-icon-pencil",onClickButton: function(){editPost()},position:"last"});
	//var layout=require("js/layout");//页面布局
	function editPost(){//文章编辑
		var selRowId=$("#postJqGrid").getGridParam("selrow"),rowData = $("#postJqGrid").jqGrid('getRowData',selRowId);
		if(selRowId==null){
			alert('选中一行再进行编辑');
			return;
		}
		var editUrl=url+"/blogEdit?id="+selRowId;
		//添加一个文章编辑sheet
		//panelIdOrIndex, title, url, forceRefresh, callback
		parent.layout.activeTab(null,rowData.postTitle,editUrl,true,null);
	}
	
	//list_tag.jsp 博客标签管理界面
	$("#tagJqGrid").jqGrid({
		url : url+"/tagGridInit",
	    datatype: "json",
	    height: "75%",
	    autowidth:true,
	    rowNum: 15,
	    rowList: [10,20,30],
	    colNames:['标签ID','标签名', '权重','所属人'],
	    colModel:[
	        {name:'id',key:true, sortable:false, align:"center"},
	        {name:'value', align:"center",sortable:false},
	        {name:'weight', sortable:false, align:"center"},
	        {name:'userName',sortable:false, align:"center"}
	    ],
	    pager: "#tagJqGridPager",
	    viewrecords: true,
	    caption: '文章管理--<font color="red">权重关系到在主页标签云上显示的大小</font>',
	    emptyrecords : "没有可显示记录",
	    hidegrid:false,
	    viewrecords:true,
	    recordpos:'left',
	    altRows: true,
		jsonReader : {
			root : "rows", 
			page : "page", 
			total : "total", 
			records : "records",
			repeatitems : false, 
			cell : "cell"
		}
	});
	$("#tagJqGrid").jqGrid('navGrid', '#tagJqGridPager', {
		edit : false,
		add : false,
		del : false,
		search : false,
		position : 'right'
	}).navButtonAdd('#tagJqGridPager',{caption:"添加",buttonicon:"ui-icon-plus",onClickButton: function(){addTag()},position:"last"})
	.navButtonAdd('#tagJqGridPager',{caption:"编辑",buttonicon:"ui-icon-pencil",onClickButton: function(){editTag()},position:"last"})
	.navButtonAdd('#tagJqGridPager',{caption:"删除",buttonicon:"ui-icon-trash",onClickButton: function(){delTag()},position:"last"});
	require("jquery-avgrund");
	
	$('.ui-icon-plus').parent().avgrund({
		width: 600,
		height: 500,
		holderClass: 'custom',
		showClose: true,
		showCloseText: '关闭',
		onBlurContainer: '.container',
		onUnload: function (elem) {
			//刷新jqgrid
			$("#tagJqGrid").trigger("reloadGrid");
		},
		template: function (element) {
			var returnHtml='';
			$.ajax({
				  url: url+"/tagForm?time="+new Date().getTime(),
				  async:false,
				  success: function(data){
					  returnHtml=data;
				  }
			});
			return returnHtml;
	    }
	});
	
	function addTag(){
		// Dialog Button
		        $('#modal-button').dialog('open');
	}
	
})