define(['jquery','jqgrid'],function($){
	//jqgrid初始化url
	var url=contextPath+"/sys/cache";
	$("#jqGrid").jqGrid({
		url : url+"/gridInit",
	    datatype: "json",
	    height: "75%",
	    autowidth:true,
	    rowNum: 15,
	    rowList: [10,20,30],
	    colNames:['名称','命中次数', '丢失次数', '缓存数','内存缓存数','硬盘缓存数'],
	    colModel:[
	        {name:'cacheName',key:true, width:60, sortable:false},
	        {name:'memoryHits', width:90,sortable:false},
	        {name:'memortMisses', width:100, sortable:false},
	        {name:'size', width:80, align:"center", sortable:false},
	        {name:'memoryStoreSize', width:80, align:"center", sortable:false},        
	        {name:'diskStoreSize', width:80,align:"center", sortable:false}   
	    ],
	    pager: "#jqGridPager",
	    viewrecords: true,
	    caption: '系统缓存管理--<font color="red">点击刷新单个缓存</font>',
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
	$("#jqGrid").jqGrid('navGrid', '#jqGridPager', {
		edit : false,
		add : false,
		del : false,
		search : false,
		position : 'right'
	}).navButtonAdd('#jqGridPager',{caption:"刷新缓存",buttonicon:"ui-icon-refresh",onClickButton: function(){refreshCache()},position:"last"});
	
	function refreshCache(){//刷新缓存
		var cacheName = $("#jqGrid").jqGrid('getGridParam','selrow');
		$.post(url+"/refreshCache",{cacheName:cacheName},function(data){
			alert(data);
		})
	}
})