/*
 * Pusher chat
 * facebook like chat jQuery plugin using Pusher API 
 * version: 1.0   
 * Author & support : zied.hosni.mail@gmail.com 
 * © 2012 html5-ninja.com
 * for more info please visit http://html5-ninja.com
 *
 *此插件是我在原作者基础上做了大量的修改，直接使用WebSocket原生api https://msdn.microsoft.com/zh-cn/library/Hh673567(v=VS.85).aspx
 *
*/
(function( $ ){

    $.fn.pusherChat = function(options ) {
        //options
        var settings = $.extend( {
        	'url':'ws://hrps.me:10086/websocket',//默认的WebSocket的url
            'serverPath' : null, // required : path to server
            'onFriendConnect' : undefined, // event : trigger whene friend connect & return his ID
            'onFriendLogOut' : undefined, // event : trigger whene friend log out & return his ID
            'onSubscription' : undefined // return  members object
        }, options);
        //将原始的pusher替换成html5自带的websocket
        var socket;
        if(!window.WebSocket){
        	window.WebSocket=window.MozWebSocket;
        }
        var currUserId=$("#userid").val();
        if(currUserId==""){
        	alert("请登录!");
        	showWindow('loginer');
    		center("loginer");
    		return;
        }
        	
        if(window.WebSocket){
        	socket = new WebSocket(settings.url);
        	socket.onmessage = function(event) {
        		onReceiveData(event);
        	};
        	socket.onopen = function(event) {
        		var obj={type:3,user:{id:currUserId}};
        		socket.send(JSON.stringify(obj));
        		onReceiveData(event);
        	  };
        	socket.onclose = function(event) {
        	  };
        }else{
        	alert("你的浏览器版本太低,请升级！")
        }
        //处理服务器返回的数据
        function onReceiveData(event){
        	//console.log(event.data);
        	try{
        		var data=$.parseJSON(event.data);
    		}catch(e){
    		}
        	if(data==null)
        		return;
        	if(data.type==1){//更新在线人员列表
        		memberUpdate(data.users);
        	}else if(data.type==2){//收到消息
        		msgReceive(data.msg);
        	}
        }
        //更新在线用户
        function memberUpdate(user){
        	$('#pusherChat #members-list').html('');
        	var offlineUser = onlineUser ='',count=0;
        	$.each(user,function(i,u){//u.status {'on':'在线','off':'离线'}
        		var img="assets/"+(u.id.toString().substr(-1,1))+".jpg";
        		onlineUser +='<a href="#'+u.id+'" class="on"><img src="'+img+'"/> <span>'+u.name+'</span><input type="hidden" value="'+u.channelid+'"></input></a>';
        		$('#id_'+u.id).removeClass('off').removeClass('on').addClass('on');
        		count++;
        	})
        	$('#pusherChat #members-list').append(onlineUser);    
        	$("#count").html(count);
        }
        //收到消息	
        function msgReceive(data){
        	 console.dir(data)
        	 var obj = $('a[href=#'+data.from+']');
        	 //<a href="#244" class="on"><img src="assets/cobain.jpg"> <span>Kurt Cobain</span></a>
             createChatBox(obj);
             var name = $('#id_'+data.from).find('h2').find('.userName').html();
             $('#id_'+data.from+' .msgTxt').append('<p class="friend"><b>'+name+'</b><br/>'+ data.msg+'</p>');       
             $('#id_'+data.from).addClass('recive').removeClass('writing');
             $('#id_'+data.from+' .logMsg').scrollTop($('#id_'+data.from+' .logMsg')[0].scrollHeight);      
             if ($('title').text().search('New message - ')==-1)
                 $('title').prepend('New message - ');
             $.playSound('sounds/new');
        }
        //发送消息
        $(".pusherChatBox textarea").live('keypress',function(event) {    
            var from = $(this).parents('form');
            if ( event.which == 13 ) {                
                $(this).next().next().next().val('false');
                var to=$(this).next().next().val().replace('#', '');
                msgSent(from.serialize());
                $('#id_'+to+' .msgTxt').append('<p class="you"><b>You</b><br/>'+  $(this).val()+'</p>');
                $('#id_'+to+' .logMsg').scrollTop($('#id_'+to+' .logMsg')[0].scrollHeight);      
               // $('#id_'+to+' .logMsg').scrollTop($('#id_'+data.to+' .logMsg')[0].scrollHeight);
                event.preventDefault();
                $(this).val('');
                $(this).focus();         
            }else if (!$(this).val() || ($(this).next().next().next().val()=='null' && $(this).val())){               
                $(this).next().next().next().val('true');
                msgSent(from.serialize());
            }
        });  
        function msgSent(msg){
        	console.log(msg)
        	if (socket.readyState == WebSocket.OPEN) {
        	    socket.send(msg);
        	} else {
        	    alert("The socket is not open.");
        	}
        }
        var pageTitle = $('title').html(); // just to update page title whene message is triggered
        
        // trigger whene user stop typing 
        $('.pusherChatBox textarea').live('focusout',function(){
            if($(this).next().next().next().val()=='true'){
                var from = $(this).parents('form');
                $(this).next().next().next().val('null');
                msgSent(from.serialize());
            }
        });
        
        /*-----------------------------------------------------------*
         * slide up & down friends list & chat boxes
         *-----------------------------------------------------------*/  
        $('#pusherChat #expand,.pusherChatBox .expand').live('click',function(){
            var obj = $(this);    
            obj.parent().find('.scroll,.slider').slideToggle('1', function() {
                if ($(this).is(':visible')){
                    obj.find('.close').show();
                    obj.find('.open').hide();
                }else {
                    obj.find('.close').hide();
                    obj.find('.open').show();
                }
            });    
            return false
        });

        // close chat box
        $('#pusherChat .closeBox').live('click',function(){
            $(this).parents('.pusherChatBox').hide();
            updateBoxPosition();
            return false;
        });
        
        // trigger click on friend & create chat box
        $('#pusherChat #members-list a').live('click',function(){
            var obj=$(this);
            var id = obj.attr('href').replace('#', '');
            if(id==currUserId)
            	return;
            createChatBox(obj);
            return false;
        });
        
        // some action whene click on chat box
        $('.pusherChatBox').live('click',function(){
            var newMessage = false;
            $(this).removeClass('recive');
            $('.pusherChatBox').each(function(){
                if ($(this).hasClass('recive')){
                    newMessage = true;
                    return false; 
                }       
            });  
            if (newMessage == false)
                $('title').text(pageTitle);
        });
        
        /*-----------------------------------------------------------*
         * create a chat box from the html template 
         *-----------------------------------------------------------*/        
        function createChatBox(obj){
            var name = obj.find('span').html();  
            var img = obj.find('img').attr('src');  
            var channelid = obj.find('input').val();  
            var id = obj.attr('href').replace('#', 'id_');                     
            var off = clone ='';
            if (obj.hasClass('off')) off='off';
    
            if (!$('#'+id).html()){                 
                $('#templateChatBox .pusherChatBox h2 .userName').html(name);               
                $('#templateChatBox .pusherChatBox h2 img').attr('src',img);
                $('.chatBoxslide').prepend($('#templateChatBox .pusherChatBox').clone().attr('id',id));            
            }
            else if (!$('#'+id).is(':visible') ){
                clone = $('#'+id).clone();
                $('#'+id).remove();
                if(!$('.chatBoxslide .pusherChatBox:visible:first').html())
                    $('.chatBoxslide').prepend(clone.show());     
                else
                    $(clone.show()).insertBefore('.chatBoxslide .pusherChatBox:visible:first');
            }
            if (settings.profilePage){
                $.getJSON(settings.friendsList, function(data) { 
                    var profileUrl = data[obj.attr('href').replace('#', '')][2];
                    $('#'+id+' h2 a').attr('href',profileUrl);
                });
            }  
            $('#'+id+' textarea').focus();
            $('#'+id+' .from').val(currUserId);
            $('#'+id+' .to').val(obj.attr('href'));
            $('#'+id+' .channelid').val(channelid);//由channelId来得到唯一目标标识
            $('#'+id).addClass(off);
            updateBoxPosition();
            return false
        }

        /*-----------------------------------------------------------*
         * reorganize the chat box position on adding or removing
         *-----------------------------------------------------------*/  
        function updateBoxPosition(){
            var right=0;
            var slideLeft = false;
            $('.chatBoxslide .pusherChatBox:visible').each(function(){
                $(this).css({
                    'right':right
                });
        
                right += $(this).width()+20;
        
                $('.chatBoxslide').css({
                    'width':right
                });
        
                if ($(this).offset().left- 20<0){
                    $(this).addClass('overFlow');
                    slideLeft = true;
                }
                else
                    $(this).removeClass('overFlow');
    
    
            });          
            if(slideLeft) $('#slideLeft').show();
            else $('#slideLeft').hide();
    
            if($('.overFlowHide').html()) $('#slideRight').show();
            else $('#slideRight').hide();
        }

      
        $('#slideLeft').live('click',function(){
            $('.chatBoxslide .pusherChatBox:visible:first').addClass('overFlowHide');
            $('.chatBoxslide .pusherChatBox.overFlow').removeClass('overFlow');
            updateBoxPosition();
        });

        $('#slideRight').live('click',function(){
            $('.chatBoxslide .pusherChatBox.overFlowHide:last').removeClass('overFlowHide');
            updateBoxPosition();
        });
     
        
        /*-----------------------------------------------------------*
         * some css tricks
         *-----------------------------------------------------------*/ 
        $('#pusherChat .scroll').css({
            'max-height':$(window).height()-50
        })               

        $('#pusherChat .chatBoxWrap').css({
            'width':$(window).width() -  $('#membersContent').width()-30 
        })           

        $(window).resize(function(){
            $('#pusherChat .scroll').css({
                'max-height':$(window).height()-50
            });
    
            $('#pusherChat .chatBoxWrap').css({
                'width':$(window).width() -  $('#membersContent').width() -30
            }) 
            updateBoxPosition();
        });
        
    };
    
    
})( jQuery );

