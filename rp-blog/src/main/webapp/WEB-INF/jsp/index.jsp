<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/index/header.jsp"%>
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
						style="overflow: hidden; outline: none; border-right-color: rgb(238, 238, 238);"tabindex="5001">
					<%@include file="/WEB-INF/jsp/index/postlist.jsp"%>
					<rp:page page="1" />
					</div>
				</div>
				
			</div>
			<div id="m-post"
				class="col-xs-12 col-sm-8 col-sm-offset-4 col-md-8 col-md-offset-4 col-lg-8 col-lg-offset-4">
				<div class="row">
					<div id="m-post-article" class="col-lg-11 col-md-11 col-sm-12 m-post-container"
						data-body-class="home-template" style="height: auto;overflow: hidden;">
						<%@include file="/WEB-INF/jsp/index/article.jsp"%>
						<%@include file="/WEB-INF/jsp/index/comment.jsp"%>
						<p class="clearfix">
							<span class="pull-right go-top" id="xx"><i
								class="fa fa-arrow-circle-o-up"></i>返回顶部</span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@include file="/WEB-INF/jsp/common/import-js.jspf"%>
<script type="text/javascript">
require.config({
	baseUrl:'${ctx}/static',//默认是加载requirejs页面的位置
	paths:{
		'app':'js/application',
		'jquery':'js/jquery-1.10.1.min',//后面不能带后缀
		'nicescroll':'comp/nicescroll/jquery.nicescroll.min'
	},
	waitSeconds: 15,
	map:{
	    '*':{
	         'css':'js/css',
	         'constant':'js/constant'
			}
	},
	shim : {
        //'app': ['css! css/test.css']
    }
})
require(['app'],function(app){
	app.init();
})
</script>
</body>
</html>