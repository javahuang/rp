<%--
 分页格式
目前采取不分页 鼠标向下滚动分页
--%>
<%@tag pageEncoding="UTF-8" description="分页"%>
<%@ attribute name="page" type="java.lang.Integer"
	required="true" description="分页"%>
<%@ attribute name="pageSize" type="java.lang.Integer" required="false"
	description="每页大小"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>

<nav class="pagination" role="navigation" style="display: block;">
	<span id="page-number" class="page-number" data-page=1 data-rows=10 data-total=10 data-tagid="">共 ${fn:length(postList) }条 </span>
	<i class="fa fa-spinner fa-spin-hover"></i>
</nav>

