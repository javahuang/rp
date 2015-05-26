require.config({
	baseUrl:'.',//默认是加载requirejs页面的位置
	paths:{
		'app':'src/application',
		'jquery':'src/jquery-1.10.1.min',//后面不能带后缀
		'nicescroll':'src/jquery.nicescroll.min',
		'cookie':'src/jquery.cookie'
	},
	waitSeconds: 15,
	shim : {
		cookie:{
			 deps: ['jquery'],
		},
		timeline:{
			 deps: ['jquery'],
		}
    }
}) 
