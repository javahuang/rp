define(['jquery','jqgrid'],function($){
	//jqgrid初始化url
	var url=contextPath+"/sys/cache/gridinit";
	$("#jqGrid").jqGrid({
		url : url,
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
	    caption: "系统缓存管理",
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
			cell : "cell", 
			id : "patientId"
		}
	});
	$("#jqGrid").jqGrid('navGrid', '#jqGridPager', {
		edit : false,
		add : false,
		del : false,
		search : true,
		position : 'right'
	}).navButtonAdd('#jqGridPager',{caption:"新增",buttonicon:"ui-icon-plus",onClickButton: function(){toAdd()},position:"last"})
		.navButtonAdd('#jqGridPager',{caption:"编辑",buttonicon:"ui-icon-pencil",onClickButton: function(){toModify()},position:"last"});

})