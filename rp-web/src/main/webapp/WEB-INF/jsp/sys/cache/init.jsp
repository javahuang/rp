<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/import-css.jspf"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>

<!-- end jqGrid -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script type="text/javascript">
	var contextPath = '${ctx}';
</script>
</head>
<body>
<div class="container">
<div class="row">
                    <div class="col-lg-12 col-sm-12">
                        <table id="jqGrid01"></table>
                        <div id="jqGridPager01"></div>
                    </div>
</div>
</div>
	<%@include file="/WEB-INF/jsp/common/import-js.jspf"%>
	<script type="text/javascript">
	require(['module/sys/cache'], function(){
	});
	</script>
</body>
</html>