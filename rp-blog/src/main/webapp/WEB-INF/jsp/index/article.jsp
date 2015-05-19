<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>
<article id="post-6" class="post published animated fadeInUp"
	style="-webkit-animation-duration: 0.6s; -webkit-animation-timing-function: ease-in-out;">
	<h2 class="post-title">${article.postTitle }</h2>
	<div class="metadata">
		<ul class="list-inline clearfix">
			<li class="meta-date"><i class="fa fa-calendar"><span><rp:prettyTime date="${article.postDate }"></rp:prettyTime></span></i></li>
			<li class="meta-author"><i class="fa fa-user"></i><span><a
					style="font-size: 12px;" href="#" title="鹏"><rp:cache attrName="username" key="${article.postAuthor}" cacheName="userCache"></rp:cache></a></span></li>
			<li class="meta-comments"><i class="fa fa-comments-o"><span><a
						href="javascript:void(0)">查看评论</a></span></i></li>
		</ul>
	</div>
	<div id="post-content" class="post-content" >
		${article.postContent }
	</div>
</article>
