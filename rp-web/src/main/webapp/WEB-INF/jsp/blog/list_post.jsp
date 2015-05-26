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
				<table id="postJqGrid"></table>
				<div id="postJqGridPager"></div>
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