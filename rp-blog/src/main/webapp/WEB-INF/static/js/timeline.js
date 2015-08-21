define(function(require,exports){
	//时光机初始化操作
	exports.init=function(){
		require("timeline");
		timelineinit();
		initJqcloud();
		initTaginput();
	}
	var $=require("jquery");
	var cookie=require("cookie");
	var jqcloud=require("jqcloud");
	var bootstrap=require("bootatrap");
	var tagsinput=require("tagsinput");
	var typeahead=require("typeahead");
	//时光机初始化
	function timelineinit(){
		$.timeliner({
			startOpen:['#19550828', '#19630828'],
		});
		$.timeliner({
			timelineContainer: '#timeline-js',
			timelineSectionMarker: '.milestone',
			oneOpen: true,
			startState: 'open',
			expandAllText: '+ Show All',
			collapseAllText: '- Hide All'
		});
	}
	
	//标签云初始化
	function initJqcloud(){
		$("#tag-cloud-words span").remove();//移除cloud下面的span
		$.getJSON(ctx+"/getTags",function(data){
			$("#tag-cloud-words").jQCloud(data,{addtag:addtag});
		})
		
	}
	//对jqcloud-1.0.4源码稍作修改,添加了点击函数
	function addtag(){
		var tagid=$(this).attr("tagid"),tagname=$(this).text(),elt = $('#taginput'),items=elt.tagsinput('items');
		elt.tagsinput('add', { "value": tagid , "text": tagname  , "continent": 'item'+items.length});
		refreshTimeline();
	}
	//标签云初始化
	function initTaginput(){
		//标签 bootstrap-tagsinput
		var elt = $('#taginput');
		elt.tagsinput({
		  tagClass: function(item) {
		    switch (item.continent) {
		      case 'item1' : return 'label label-primary';
		      case 'item2'  : return 'label label-danger label-important';
		      case 'item0' : return 'label label-success';
		      case 'item4' : return 'label label-default';
		      case 'item3' : return 'label label-warning';
		      case 'item5'    : return 'label label-info';
		    }
		  },
		  itemValue: 'value',
		  itemText: 'text',
		  maxTags:6//最多允许6个标签
		});
		
		elt.on('itemAdded', function(event) {//添加事件
			  // event.item: contains the item
			});
		elt.on('itemRemoved', function(event) {//删除事件
			refreshTimeline();
			});
		
	}
	
		// Scroll to top animation on click
	  	$("#scrolltop").click(function(){
	    	$('html, body').animate({scrollTop:0}, 500); 
	    	return false;
	  	});
	  	
	  	//搜索
	  	$(".fa-search").click(function(e){//搜索
			e.stopPropagation();
			$("#search").find("input").css({"display":"inline","width":"1px"});//使用show的话默认display:block 会换行
			$("#search").find("input").animate({
				width: "200px"
			},500,function(){
				$("#search").find("input").unbind("keypress");//每次动画都会绑定一次键盘点击事件...
				$("#search").find("input").focus().keypress(function(e){
					if(e.which==13){
						$("#search").find("input").css("display","none");
						var searchStr=$("#search").find("input").val();
						if(searchStr!=null&&searchStr.trim()!=''){
							//搜索字符串以$user 开头
							if(searchStr.indexOf("$user")!=-1){//将user添加到cookie
								var dateObj=new Date();
								dateObj.setTime(dateObj.getTime());
								dateObj.setTime(dateObj.getTime()+30*24*60*60*1000);//默认将搜索内容保持一个月
								$.cookie("user",searchStr,{expires:dateObj,path:"/"});
								initJqcloud();//初始化标签云
							}else if(searchStr.indexOf("$password")!=-1){//查看密码对应的文章
								var dateObj=new Date();
								dateObj.setTime(dateObj.getTime());
								dateObj.setTime(dateObj.getTime()+24*60*1000);//默认将搜索内容保持一天
								$.cookie("pwd",searchStr,{expires:dateObj,path:"/"});
							}else if(searchStr.indexOf("$all")!=-1){//清除所有cookie
								var dateObj=new Date();
								$.removeCookie("user",{expires:dateObj,path:"/"});//删除user标签
								$.removeCookie("pwd",{expires:dateObj,path:"/"});//删除pwd标签
								$.removeCookie("search",{expires:dateObj,path:"/"});//删除search标签
								initJqcloud();//初始化标签云
							}else{//执行搜索操作
								var dateObj=new Date();
								dateObj.setTime(dateObj.getTime()+5*60*1000);//默认将搜索内容保持五分钟
								$.cookie("search",searchStr,{expires:dateObj,path:"/"});
							}
							refreshTimeline();//刷新时间线
						}else{
							return;
						}
						
					}
				})
			})
		});
		$("#search").find("input").click(function(e){
			e.stopPropagation();
		})
		$(".logo-link").click(function(e){
			e.stopPropagation();
			var dateObj=new Date();
			dateObj.setTime(dateObj.getTime());
			$.removeCookie("search",{expires:dateObj,path:"/"});
			$.removeCookie("tag",{expires:dateObj,path:"/"});
			window.location.reload();
		})
		$("body").click(function(e){
			$("#search").find("input").css({"display":"none","width":"1px"});
		})
		/**
		 * 将标签和搜索内容都放入cookie里面,默认保持五分钟
		 * 当点击logo时,将cookie清除
		 */
		function refreshTimeline(){//刷新时间轴
			var elt = $('#taginput'),tags=elt.val();
			$.post(ctx+"/timelineSearch",{tags:tags},function(html){
				$(".timeline-wrapper").remove();
				$("#clear").after(html);
				//因为timeline doom没有销毁,绑定的事件和data都会存在  当刷新时,会触发多次事件,绑定的数据也会导致折叠/展开不能正常
				$("#timeline").removeData("started");
				$("#timeline").unbind("click");
				timelineinit();
				//console.log($("#togglebutton").hasClass("expanded"))
			});
	}
})