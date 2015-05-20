<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/index/header.jsp"%>
<link rel="stylesheet" href="${ctx }/static/comp/timeline/css/demo.css" type="text/css" media="screen">
<link rel="stylesheet" href="${ctx }/static/comp/timeline/css/timeliner.css" type="text/css" media="screen">
<link rel="stylesheet" href="${ctx }/static/comp/jqcloud/jqcloud.css" type="text/css" media="screen">
<link rel="stylesheet" href="${ctx }/static/comp/bootstrap-tagsinput/bootstrap-tagsinput.css" type="text/css" media="screen">
</head>
<body class="home-template  pace-done">
	<div class="pace  pace-inactive">
		<div class="pace-activity"></div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div id="m-nav" class="col-xs-12 col-sm-4 col-md-4 col-lg-4 affix">
				<div class="row m-nav-container">
					<div class="col-sm-3 col-md-4 animated fadeIn" id="m-sidebar"
						style="overflow: hidden; outline: none;" tabindex="5000">
						<%@include file="/WEB-INF/jsp/index/sidebar.jsp"%>
						<div class="sidebar-bg"></div>
					</div>
					<div id="m-post-list" class="col-xs-12 col-sm-9 col-md-8"
						style="overflow: hidden; outline: none; "tabindex="5001">
						<%@include file="/WEB-INF/jsp/timeline/tagcloud.jsp"%>
					</div>
				</div>
				
			</div>
			<div id="m-post"
				class="col-xs-12 col-sm-8 col-sm-offset-4 col-md-8 col-md-offset-4 col-lg-8 col-lg-offset-4">
				<div class="row">
					<div id="m-post-article" class="col-lg-11 col-md-11 col-sm-12 m-post-container"
						data-body-class="home-template" style="height: auto;overflow: hidden;">
						<%@include file="/WEB-INF/jsp/timeline/posttimeline.jsp"%>
						<p class="clearfix">
							<span class="pull-right go-top" id="scrolltop"><i
								class="fa fa-arrow-circle-o-up"></i>返回顶部</span>
						</p>
					</div>
					<div id="m-post-search" class="col-lg-1 col-md-1  m-post-container">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="search" class="search form-inline" style="" >
	<span title="搜索~($user username选择对应用户标签)($user all查看所有)">
	<input class="form-control input-sm" type="text" placeholder="" >
	<i class="fa fa-search"></i>
	</span>
	</div>
<%@include file="/WEB-INF/jsp/common/import-js.jspf"%>
<script type="text/javascript">
require.config({
	baseUrl:'${ctx}/static',//默认是加载requirejs页面的位置
	paths:{
		'app':'js/application',
		'jquery':'js/jquery-1.10.1.min',//后面不能带后缀
		'nicescroll':'comp/nicescroll/jquery.nicescroll.min',
		'cookie':'js/jquery.cookie',
		'timeline':'comp/timeline/js/timeliner',
		'jqcloud':'comp/jqcloud/jqcloud-1.0.4',
		'tm':'js/timeline',
		'bootatrap':'comp/bootstrap/js/bootstrap',
		'tagsinput':'comp/bootstrap-tagsinput/bootstrap-tagsinput',
		'typeahead':'comp/bootstrap-tagsinput/typeahead.bundle.min'
	},
	waitSeconds: 15,
	map:{
	    '*':{
	         'css':'js/css',
	         'constant':'js/constant'
			}
	},
	shim : {
		cookie:{
			deps: ['jquery']
		},
		timeline:{
			deps: ['jquery']
		},
		jqcloud:{
			deps: ['jquery']
		},
		bootatrap:{
			deps: ['jquery']
		},
		tagsinput:{
			deps: ['jquery']
		},
		typeahead:{
			deps: ['jquery']
		}
		
        //'app': ['css! css/test.css']
    }
})
require(['tm'],function(app){
	app.init();
})
</script>
</body>
</html>