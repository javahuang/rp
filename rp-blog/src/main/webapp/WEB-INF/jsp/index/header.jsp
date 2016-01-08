<%@ page trimDirectiveWhitespaces="true" %> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>
<!DOCTYPE html>
<html lang="cn" dir="ltr" class="no-js">
<head>
<meta charset="utf-8">
<link rel="dns-prefetch" href="http://hrps.me/">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="pinterest" content="nopin">
<title>大大大大大黄</title>
<meta name="description" content="Thoughts, stories and ideas.">
<meta name="HandheldFriendly" content="True">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="${ctx }/static/images/dahuang.png">
<meta name="author" content="">
<meta name="robots" content="index, follow">
<link rel="canonical" href="http://hrps.me/">
<meta name="generator" content="Ghost 0.5">
<%@include file="/WEB-INF/jsp/common/import-css.jspf"%>
<%@include file="/WEB-INF/jsp/common/import-codehight.jspf"%>
<script type="text/javascript">var ctx='${ctx}';</script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?ce8035f0c3530ebb28b00e8b913353a1";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
function showOrHideProgress(width){
	var currWidth=parseInt(document.getElementsByClassName("pace-progress")[0].style.width.replace(/%/,""));
	var s=setInterval(function(){currWidth++;document.getElementsByClassName("pace-progress")[0].style.width=currWidth+"%";if(currWidth==100)document.getElementsByClassName("pace-inactive")[0].style.display="none";if(currWidth==width)clearInterval(s);
	}, 5);
}
</script>