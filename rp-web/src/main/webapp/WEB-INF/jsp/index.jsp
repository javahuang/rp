<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/index/header.jsp"%>
<body>
	<div class="tabs-bar tabs-fix-top">
        <span class="icon-chevron-left" style="display: none;"></span>
        <div class="ul-wrapper">
            <ul>
                <li>
                    <a href="#tabs-0">欢迎使用</a>
                    <span class="menu" role="presentation" style="display:inline-block;width: 14px;height: 14px"></span>
                    <br>
                    <span class="menu icon-refresh" role="presentation" title="刷新"></span>
                </li>
            </ul>
            
        </div>
        <span class="icon-chevron-right" style="display: none;"></span>
        <div id="tabs-0" data-index="0" data-url="/es/admin/welcome"></div>
    </div>
    <shiro:guest>
    	<%@include file="/WEB-INF/jsp/login.jsp"%>
    </shiro:guest>
    <div class="bs-example" style="z-index:999;position: absolute;  top: 0;right:40px;">
    <ul class="nav nav-pills" role="tablist">
      <li role="presentation" class="active"><a href="#">欢迎哟,<shiro:principal property="userName"/>!</a></li>
      <li role="presentation" class="dropdown">
        <a id="drop4" href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
          	操作
          <span class="caret"></span>
        </a>
        <ul id="menu1" class="dropdown-menu" role="menu" aria-labelledby="drop4">
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">个人资料</a></li>
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">修改密码</a></li>
          <li role="presentation" class="divider"></li>
          <li role="presentation"><a role="menuitem" tabindex="-1" href="${ctx }/logout">注销</a></li>
        </ul>
      </li>
    </ul> <!-- /pills -->
  </div> <!-- /example -->
    <div class="ui-layout-north" style="height: 40px!important;">
    </div>
    <iframe id="iframe-tabs-0" tabs="true" class="ui-layout-center" style="top:40px!important;"
            frameborder="0" scrolling="auto" src=""></iframe>
	<!--<div class="ui-layout-south">South</div>  -->
	<div class="ui-layout-west" >
		<div id="menu">
			<div>
				<h3>
					<a href="#">博客管理</a>
				</h3>
				<div class="submenu">
					<ul>
						<li><a href="${ctx }/blog">文章编辑</a></li>
					</ul>
					<ul>
						<li><a href="#">统计</a>
							<ul>
								<li><a href="/test2">访问量</a></li>
							</ul></li>
					</ul>
				</div>
				<h3>
					<a href="#">测试2</a>
				</h3>
				<div class="submenu">
					<ul>
						<li><a href="/test2">测试21</a></li>
					</ul>
				</div>
			</div>
				</div>
			</div>
	<%@include file="/WEB-INF/jsp/common/import-js.jspf"%>
	<script type="text/javascript">
		require([ 'app' ], function(app) {
			app.init();
		})
	</script>
</body>
</html>