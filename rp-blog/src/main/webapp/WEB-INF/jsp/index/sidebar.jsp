<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="sidebar-container">
	<div class="logo-box">
		<a  class="logo-link" title="Thoughts, stories and ideas.">大黄</a>
		<p class="logo-desc">Thoughts, stories and ideas.</p>
	</div>
	<ul class="site-nav-box row">
		<li class="col-md-12 col-xs-4"><a href="${ctx }/article/welcome" class="current_nav">首页</a></li>
		<li class="col-md-12 col-xs-4"><a href="${ctx }/timeline">时光机</a></li>
		<li class="col-md-12 col-xs-4"><a href="${ctx }/article/aboutme">关于</a></li>
		<li class="col-md-12 col-xs-4"><a target="_blank"
			href="mailto:javahrp@gmail.com">联系</a></li>
	</ul>
	<hr class="site-nav-diver">
	<ul class="sidebar-social-list">
		<li class="icon-dribbble"><a href="https://github.com/javahuang" target="_blank"><i
				class="fa fa-github"></i></a></li>
		<li class="icon-twitter"><a href="http://www.weibo.com/dota88" target="_blank"><i class="fa fa-weibo"></i></a></li>
		<li class="icon-regist"><a href="http://hrps.me/rp" target="_blank"><i class="fa fa-user"></i></a></li>
	</ul>
	<%@include file="/WEB-INF/jsp/index/footer.jsp"%>
</div>