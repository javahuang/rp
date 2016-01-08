<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/import-css.jspf"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<script type="text/javascript">
	var contextPath='${ctx}';
	window.UEDITOR_HOME_URL = contextPath+"/static/comp/ueditor/";
	</script>
    <script type="text/javascript" charset="utf-8" src="${ctx }/static/comp/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx }/static/comp/ueditor/ueditor.all.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${ctx }/static/comp/ueditor/lang/zh-cn/zh-cn.js"></script>
    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<form action="${ctx}/blog/edit.json" method="post" id="edit_form">
<div id="edit-content">
<div id="edit-title" class="form-group form-inline ">
    <label for="postTitle"><b>标题:</b></label>
    <input type="text" class="form-control input-lg" id="postTitle" name="postTitle" placeholder="输入标题" value="${post.postTitle}">
    <label for="postName"><b>副标题:</b></label>
    <input type="text" class="form-control input-lg" id="postName" name="postName" placeholder="输入副标题(文章链接 字母/数字/横线)" value="${post.postName }">
    <input type="hidden" value="${post.id }" name="id" id="postId">
</div>
    <script id="editor" type="text/plain" style="width:1024px;height:500px;margin-top: 30px;"></script>
<div id="menu-collapse">
<div>
<h3><a href="http://www.baidu.com">个人分类</a></h3>
<rp:tags/>
</div>
<div>
<h3><a href="#">高级选项</a></h3>
	<div>
	<div class="form-group form-inline">
    <label for="postPassword">阅读密码:</label>
    <input type="text" class="form-control" id="postPassword" name="postPassword" placeholder="设置阅读密码">
  </div>
  </div>
</div>
</div>
<div>
<button type="button" class="btn btn-warning edit-save-temp">暂存</button>
<button type="submit" class="btn btn-success edit-save">保存</button>
</div>
</div>
</form>
<script type="text/javascript">
//实例化编辑器
//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
var ue = UE.getEditor('editor');
</script>
<%@include file="/WEB-INF/jsp/common/import-js.jspf"%>
<script type="text/javascript">
require(["jquery-ui",'bootstrap','module/blog/blog'], function(){
	//http://getfishtank.ca/blog/how-to-use-bootstrap-3-with-requirejs
    // DOM ready
    $(function(){
    	$("#menu-collapse").accordion({
    	    header: "h3"
    	});
    });
   
});
</script>
</body>
</html>