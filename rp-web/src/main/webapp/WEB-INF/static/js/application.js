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
//	require("j-u-b/jquery-ui");
	var layout=require("js/layout");//页面布局
	//将layout对象注册到全局变量,供子模块使用
	window.layout=layout;
	require("module/index/login");//登录页面
	
});