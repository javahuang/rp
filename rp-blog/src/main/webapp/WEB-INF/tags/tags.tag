<%@ tag import="com.huang.rp.common.utils.PrettyTimeUtils"%>
<%@ tag import="java.util.Arrays"%>
<%@ tag pageEncoding="UTF-8"%>
<!-- 文章关联的标签{tagId:tagName,tagId:tagName}格式 -->
<%@ attribute name="tags" type="java.lang.String" required="true"
	description="标签"%>
<ul class="list-inline clearfix">
	<%
		if (tags != null && !"".equals(tags)) {
	%>
	<li class="meta-tags" title="标签"><i class="fa fa-tags"></i></li>
	<%
		String[] tagArray = tags.split(",");
			for (int i = 0; i < tagArray.length; i++) {
				String[] tag = tagArray[i].split(":");
				String tagId = tag[0];
				String tagName = tag[1];
	%>
	<li class="meta-tags" data-id="<%=tagId%>"><span><%=tagName%></span></li>
	<%
		}
		}
	%>
</ul>