<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>
<c:forEach items="${postList }" var="p" varStatus="">
<article id="m-list-post-6"
	class="post published animated fadeInLeft<c:if test="${p.id==article.id }"> current-selected-post</c:if>"
	style="-webkit-animation-duration: 0.4s; -webkit-animation-timing-function: ease-in-out;">
	<div class="post-wrap">
		<h2 class="post-title">
			<a id="${p.id }" data-postname="${p.postName }">${p.postTitle }</a>
		</h2>
		<div class="post-content hidden-xs">
			<p>${p.postExcerpt }</p>
		</div>
		<div class="post-metadata hidden-xs">
			<div class="metadata">
				<ul class="list-inline clearfix">
					<li class="meta-date"><i class="fa fa-calendar" title="创建时间"><span><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${p.postDate }"></fmt:formatDate></span></i></li>
					<li class="meta-author"><i class="fa fa-user"></i><span><a
							style="font-size: 12px;" href="#" title="${p.postAuthor }"><rp:cache attrName="username" key="${p.postAuthor}" cacheName="userCache"></rp:cache></a></span></li>
					<li class="meta-comments"><i class="fa fa-comments-o"><span><a
								href="#">查看评论</a></span></i></li>
					<li class="meta-heart" title="喜欢我"><i class="fa fa-heart-o"></i></li>
				</ul>
				<rp:tags tags="${p.tags}"></rp:tags>
			</div>
		</div>
	</div>
</article>
</c:forEach>

<span class="pagination_statistics">
<!-- 分页统计信息 -->
<input type="hidden" id="get-rows" value=${fn:length(postList) }>
</span>
