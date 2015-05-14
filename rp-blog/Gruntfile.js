module.exports = function(grunt) {
	grunt
			.initConfig({
				pkg : grunt.file.readJSON('package.json'),
				cssmin : {
					compress : {
						files : {
							'src/main/webapp/WEB-INF/static/css/style.min.css' : [
									"src/main/webapp/WEB-INF/static/comp/font-awesome-4.3.0/css/font-awesome.css",
									"src/main/webapp/WEB-INF/static/css/style.css" ]
						}
					}
				},
				uglify : {
					build : {
						src : '<%=pkg.shCore %>/shCore.js',//引用package.json中定义的变量
						dest : '<%=pkg.shCore %>/shCore.min.js'
					}
				}
			});

	grunt.loadNpmTasks('grunt-contrib-cssmin');
	// grunt cssmin --debug 目前我只会打包css 打包requirejs还需要时间

	// 加载提供"uglify"任务的插件
	grunt.loadNpmTasks('grunt-contrib-uglify');
	// 默认任务 grunt
	grunt.registerTask('default', [ 'uglify' ]);
}
