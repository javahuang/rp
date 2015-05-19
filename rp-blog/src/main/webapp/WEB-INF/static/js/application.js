/**
 * blog js 依赖jquery
 */
/*分页*/
define(function(require,exports){
	//初始化操作
	exports.init=function(){
		eventInit();
		nicescrollInit();
	}
	var $=require("jquery");
	var cookie=require("cookie");
	//点击事件初始化
	function eventInit(){
		$(".pagination_statistics").remove();//解决页面初始化时dom元素pagination_statistics未擦除导致第一次滚动计数错误bug
		$(".post-title a").click(function(){//文章标题
			var id=this.id,postName=$(this).data("postname");
			if(postName!='')
				window.location=postName;
			else
				window.location=id;
		})
		$(".meta-tags").click(function(){//标签
			var tagId=$(this).data("id");
			$("#page-number").attr("data-tagid",tagId);
			var dateObj=new Date();
			dateObj.setTime(dateObj.getTime()+5*60*1000);//默认将搜索内容保持五分钟
			$.cookie("tag",tagId,{expires:dateObj,path:"/"});
			refreshPostList();
		})
		$(".meta-heart").click(function(){//喜欢我
			if($(this).find("i").hasClass("fa-heart")){
				alert('爱过~');
				return;
			}
			$(this).html('<i class="fa fa-heart" style="color:red"></i>');
		});
		
		// Scroll to top animation on click
	  	$("#scrolltop").click(function(){
	    	$('html, body').animate({scrollTop:0}, 500); 
	    	return false;
	  	});
	  	$("#post-6 .meta-comments").click(function(){
	  		var scrollTop=$('html, body').height();
	    	$('html, body').animate({scrollTop:scrollTop}, 500); 
	    	return false;
	  	});
	  	
		$(".fa-search").click(function(e){//搜索
			e.stopPropagation();
			$("#search").find("input").css({"display":"inline","width":"1px"});//使用show的话默认display:block 会换行
			$("#search").find("input").animate({
				width: "200px"
			},500,function(){
				$("#search").find("input").unbind("keypress");//每次动画都会绑定一次键盘点击事件...
				$("#search").find("input").focus().keypress(function(e){
					if(e.which==13){
						$("#search").find("input").css("display","none");
						var postData={},searchStr=$("#search").find("input").val();
						if(searchStr!=null&&searchStr.trim()!=''){
							postData.searchStr=searchStr;
							var dateObj=new Date();
							dateObj.setTime(dateObj.getTime()+5*60*1000);//默认将搜索内容保持五分钟
							$.cookie("search",searchStr,{expires:dateObj,path:"/"});
							refreshPostList(postData);
						}else{
							return;
						}
						
					}
				})
			})
		});
		$("#search").find("input").click(function(e){
			e.stopPropagation();
		})
		$(".logo-link").click(function(e){
			e.stopPropagation();
			var dateObj=new Date();
			dateObj.setTime(dateObj.getTime());//默认将搜索内容保持五分钟
			$.removeCookie("search",{expires:dateObj,path:"/"});
			$.removeCookie("tag",{expires:dateObj,path:"/"});
			window.location.reload();
		})
		$("body").click(function(e){
			$("#search").find("input").css({"display":"none","width":"1px"});
		})
		/**
		 * 将标签和搜索内容都放入cookie里面,默认保持五分钟
		 * 当点击logo时,将cookie清除
		 */
		function refreshPostList(){//刷新导航栏  
			$.post(ctx+"/postList",function(html){
				$("#m-post-list article").remove();
				$(".pagination").before(html);
				var getRows=parseInt($("#get-rows").val());//获取的行数
				$(".pagination .page-number").text("共 "+getRows+" 条");
				eventInit();
			});
		}
	}
	
	
	//滚动条初始化
	function nicescrollInit(){
		require('nicescroll');
		$("#m-post-list").niceScroll({cursorborder:"1px solid #fff",cursorcolor:"#333"});//cursorfixedheight:'70px'
		//滚动条滚动事件
		$("#m-post-list").scroll(function(e){
			var scrollHeight=this.scrollHeight,scrollTop=this.scrollTop,offsetHeight=this.offsetHeight;
			if(scrollHeight-offsetHeight-scrollTop==0){
				$(".pagination .page-number").fadeOut("slow",function(){
					$(".pagination i").show();
					var page=parseInt($("#page-number").attr("data-page")),//页码
					rows=parseInt($("#page-number").attr("data-rows")),//行数
					total=parseInt($("#page-number").attr("data-total")),//总共
					tagId=$("#page-number").attr("data-tagid");//标签
					if(page*rows==total){
						$.post(ctx+"/postList",{page:page+1,rows:rows,tagId:tagId},function(data){
							$(".pagination").before(data);
							$(".pagination i").hide();
							console.dir($("#get-rows"))
							var getRows=parseInt($("#get-rows").val());//获取的行数
							$("#page-number").attr("data-page",page+1);
							console.log(total+" "+getRows);
							total=total+parseInt(getRows);
							$("#page-number").attr("data-total",total);
							$(".pagination .page-number").text("共 "+total+" 条");
							$(".pagination .page-number").slideToggle();
							$(".pagination_statistics").remove();
						})
					}else{
						$(".pagination .page-number").show();
						$(".pagination i").hide();
					}
				});
			}
			eventInit();
		})
	}
	
});