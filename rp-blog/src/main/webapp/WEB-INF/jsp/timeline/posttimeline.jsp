<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>
<div id="timeline" class="timeline-container">
	<input type="text" id="taginput" />
	<button id="togglebutton" class="timeline-toggle expanded">-折叠</button>
	<br class="clear" id="clear">
	<%@include file="/WEB-INF/jsp/timeline/posttimeline-wrapper.jsp"%>
	<br class="clear">
</div>