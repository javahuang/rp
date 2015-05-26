module.exports = function(grunt) {
	grunt.initConfig({
				tt : grunt.file.readJSON('package.json'),
				pkg: grunt.file.readJSON('gruntCfg.json'),
				cssmin : {
					compress : {
						files : {//或者使用src/dest的配置方式
							'src/main/webapp/WEB-INF/static/css/style.min.css' : [
									"src/main/webapp/WEB-INF/static/comp/font-awesome-4.3.0/css/font-awesome.css",
									"src/main/webapp/WEB-INF/static/css/style.css" ]
						}
					}
				},
				uglify : {
					build : {
						src : 'test/test3.js',//引用package.json中定义的变量
						dest : 'test/test3.min.js'
					},
					 my_target1: {
					      files: {
					        'test/test1.min.js': ['test/test1.js']
					      }
					    },
					    my_target2: {
						      files: {
						        'test/test2.min.js': ['test/test2.js']
						      }
						    }
				},
				imagemin:{
			        dynamic:{
			                files:[{
			                        expand: true,
			                        cwd:    'images/',
			                        src:    ['**/*.{png,JPG,gif}'],//注意图片后缀，大小写敏感
			                        dest:   'images/build/'
			                }]
			        }
			},
			watch: {
				  js: {
				    files: ['test/*.js'],
				    tasks: ['uglify'],
				    options: {
				    	debounceDelay: 2250,
				    	event: ['added', 'deleted','changed'],
				    	spawn: false//比如我修改了test。js 然后自动生成了min.js，相当于修改了min.js，会接着触发该事件 设置为false不会触发
				    },
				  },
				},
			requirejs:{//rcfg
				compile: {
			        options: {
			          baseUrl: 'rp-blog/src/main/webapp/WEB-INF/static/grunt',
			          paths: {
			        	"cookie":"src/jquery.cookie",
			        	"app":"src/application",
			      		"jquery":"src/jquery-1.10.1.min",
			      		"nicescroll":"src/jquery.nicescroll.min"
			      		
			          },
			        //页面加载之前首先得加载require.js,name的作用就是将name对应的值打包后放在最前面
			          name:'src/require',
			          include: [
			            "app",
			            "jquery",
			            "nicescroll",
			            "cookie"
			          ],
			          //out的路径不能使用baseUrl,相对于当前gruntfile.js的相对路径
			          out: "dest/libs.js"
			        }
			      }
			}
			});
	
	grunt.loadNpmTasks('grunt-contrib-cssmin');
	// grunt cssmin --debug 目前我只会打包css 打包requirejs还需要时间

	// 加载提供"uglify"任务的插件
	grunt.loadNpmTasks('grunt-contrib-uglify');
	
	//grunt imagemin
	grunt.loadNpmTasks('grunt-contrib-imagemin');
	//grunt watch
	grunt.loadNpmTasks('grunt-contrib-watch');
	//grunt 
	grunt.loadNpmTasks('grunt-contrib-requirejs');
	// 默认任务 grunt
	grunt.registerTask('default', [ 'uglify' ]);
	
	grunt.loadNpmTasks('grunt-contrib-requirejs');
	//为了介绍自定义任务搞了一个这个
	grunt.registerTask('build', 'require', function () {
	    //任务列表
	    var tasks = ['requirejs'];
	    
	    //设置requireJs的信息
	    var taskCfg = grunt.file.readJSON('gruntCfg.json');
	    var options = taskCfg.requirejs.main.options,
	    	baseUrl=options.baseUrl,
	        platformCfg = options.web,
	        includes = platformCfg.include,
	        paths = baseUrl+options.paths;
	    //源码文件
	    var srcDir = 'src';
	    //目标文件
	    var destDir = 'dest';
	    //设置参数
	    grunt.config.set('config', {
	      srcDir: baseUrl+'/src',
	      destDir: destDir+'dest'
	    });
	    var pos = -1;
	    var requireTask = taskCfg.requirejs;
	    options.name=options.name;
	    options.path = paths;
	    options.out = baseUrl+platformCfg.out;
	    options.include = includes;
	    //运行任务
	    grunt.task.run(tasks);
	    grunt.config.set("requirejs", requireTask);
	  });
}
