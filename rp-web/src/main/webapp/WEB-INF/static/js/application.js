/**
 * cms js 依赖jquery
 */
/* 分页 */
define(function(require, exports) {
	// 初始化操作
	exports.init = function() {
		//initLayout();
	}
	require("jquery");
	require("bootstrap");
	require("j-u-b/jquery-ui");
	require("js/layout");//页面布局
	require("index/login");//登录页面
	
});