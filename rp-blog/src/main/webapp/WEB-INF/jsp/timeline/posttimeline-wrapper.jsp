<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>

<c:forEach items="${timeline}" var="yyyymmline">
	<div class="timeline-wrapper">
		<h2 class="timeline-time">
			<span><c:out value="${yyyymmline.key}" /></span>
		</h2>
		<dl class="timeline-series">
			<c:forEach items="${yyyymmline.value}" var="ddline">
				<dt id="${ddline.key }" class="timeline-event">
					<a>${ddline.key }</a>
				</dt>
				<dd class="timeline-event-content" id="${ddline.key }EX">
					<c:forEach items="${ddline.value}" var="post">
						<h3>
							<i class="fa fa-calendar"></i>&nbsp;
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${post.postDate }"></fmt:formatDate>
							<a href="${ctx }/article/${post.postName}" target="_blank"
								style="text-decoration: none !important;"><span
								style="text-decoration: none !important;">${post.postTitle }</span></a>
						</h3>
						<p>${post.postExcerpt }</p>
					</c:forEach>
					<br class="clear">
				</dd>
			</c:forEach>
		</dl>
	</div>
</c:forEach>
