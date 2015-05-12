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
			$.post(ctx+"/postList",{tagId:tagId},function(data){
				$("#m-post-list article").remove();
				$(".pagination").before(data);
				var getRows=parseInt($("#get-rows").val());//获取的行数
				$(".pagination .page-number").text("共 "+getRows+" 条");
				eventInit();
			});
		})
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