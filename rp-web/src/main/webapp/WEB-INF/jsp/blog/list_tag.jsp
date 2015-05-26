<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- end jqGrid -->
<html>
<head>
<%@include file="/WEB-INF/jsp/common/import-css.jspf"%>
<link type="text/css" href="${ctx}/static/comp/jquery-avgrund/style/avgrund.css?7" rel="stylesheet">
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script type="text/javascript">
	var contextPath = '${ctx}';
</script>
</head>
<body>
 <div id="modal-button" title="Dialog Multi button" hidden>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
	<div class="container">
	<div id="select">
        <div class="select-main">
              <form action="" method="post" class="form-inline" style="">
       			<fieldset>
                	<ol>
                         <li> 
                         <input type="text"  id="keyword" name="keyword" class="form-control input-sm" placeholder="文章关键词"/>
                         </li>
                        <li> <button type="button" onclick="" class="btn btn-primary btn-sm">查询</button></li>
                    </ol>
                </fieldset>
              </form>
        </div>
    </div>
		<div class="row">
			<div class="col-lg-11 col-md-12 col-sm-12" style="font-size: 7px!important;">
				<table id="tagJqGrid"></table>
				<div id="tagJqGridPager"></div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jsp/common/import-js.jspf"%>
	<script type="text/javascript">
		require([ 'module/blog/blog' ], function() {
		});
	</script>
</body>
</html>