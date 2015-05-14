<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/import-css.jspf"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>
<link type="text/css" href="${ctx}/static/comp/jquery/css/jquery-ui-1.10.3.custom.css?4" rel="stylesheet"/>
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
	<div id="select">
        <div class="select-main">
              <form action="" method="post" class="form-inline" style="">
       			<fieldset>
                	<ol>
                         <li> 
                         <input type="text"  id="lccCode" name="lccCode" class="form-control input-sm" placeholder="缓存name"/>
                         </li>
                          <li> 
                         <input type="text"  id="lccCode" name="lccCode" class="form-control input-sm" placeholder="缓存name"/>
                         </li>
                          <li> 
                         <input type="text"  id="lccCode" name="lccCode" class="form-control input-sm" placeholder="缓存name"/>
                         </li>
                        <li> <button type="button" onclick="searchLcc();" class="btn btn-primary btn-sm">查询</button></li>
                    </ol>
                </fieldset>
              </form>
        </div>
    </div>
		<div class="row">
			<div class="col-lg-11 col-md-12 col-sm-12" style="font-size: 7px!important;">
				<table id="jqGrid"></table>
				<div id="jqGridPager"></div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jsp/common/import-js.jspf"%>
	<script type="text/javascript">
		require([ 'module/sys/cache' ], function() {
		});
	</script>
</body>
</html>