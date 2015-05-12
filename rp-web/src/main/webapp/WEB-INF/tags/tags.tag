<%@ tag pageEncoding="UTF-8" description="标签"%>
<%@ tag import="java.util.*"%>
<%@ tag import="com.huang.rp.common.cache.CacheUtils"%>
<%@ tag import="com.huang.rp.common.Constants"%>
<%@ tag import="com.huang.rp.common.cache.domain.SysParameter"%>
<!-- 文章关联的标签{tagId:tagName,tagId:tagName}格式 -->
<div class="edit-tags form-inline">
	<%
	List tagsList=(List)CacheUtils.getCacheValue(Constants.CACHE_SYS_PARAMETER, Constants.SYS_PARAMETER_TAGS,null);
	Iterator<SysParameter> tag=tagsList.iterator();
	while(tag.hasNext()){
		SysParameter sp=tag.next();
		%>
		<label class="checkbox-inline"> <input type="checkbox"
		id="tag<%=sp.getCode()%>" name="tags" value="<%=sp.getCode()%>"><%=sp.getValue() %>
		</label>
	<%	
	}
	%>
</div>