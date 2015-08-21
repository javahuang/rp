<%--缓存--%>
<%@ tag import="com.huang.rp.common.cache.CacheUtils" %>
<%@ attribute name="cacheName" type="java.lang.String" required="true" description="cache名字"%>
<%@ attribute name="key" type="java.lang.Object" required="true" description="cache key"%>
<%@ attribute name="attrName" type="java.lang.String" required="true" description="cache value的属性名称"%>
<%@ attribute name="className" type="java.lang.Class" required="false" description="cache value对象类型"%>
<%=CacheUtils.getCacheValueAttribute(cacheName,key,attrName,className)%>