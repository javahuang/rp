/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package me.hrps.rp.preview.chat.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * Generates the demo HTML page which is served at http://localhost:8080/
 */
public final class WebSocketServerIndexPage {

    private static final String NEWLINE = "\r\n";

    public static ByteBuf getContent(String webSocketLocation) {
        return Unpooled.copiedBuffer(
                "<html><head><title>Web Socket Test</title></head>" + NEWLINE +
                "<body>" + NEWLINE +
                "<script type=\"text/javascript\">" + NEWLINE +
                "var socket;" + NEWLINE +
                "if (!window.WebSocket) {" + NEWLINE +
                "  window.WebSocket = window.MozWebSocket;" + NEWLINE +
                '}' + NEWLINE +
                "if (window.WebSocket) {" + NEWLINE +
                "  socket = new WebSocket(\"" + webSocketLocation + "\");" + NEWLINE +
                "  socket.onmessage = function(event) {" + NEWLINE +
                "    var ta = document.getElementById('responseText');" + NEWLINE +
                "    ta.value = ta.value + '\\n' + event.data" + NEWLINE +
                "  };" + NEWLINE +
                "  socket.onopen = function(event) {" + NEWLINE +
                "    var ta = document.getElementById('responseText');" + NEWLINE +
                "    ta.value = \"Web Socket opened!\";" + NEWLINE +
                "  };" + NEWLINE +
                "  socket.onclose = function(event) {" + NEWLINE +
                "    var ta = document.getElementById('responseText');" + NEWLINE +
                "    ta.value = ta.value + \"Web Socket closed\"; " + NEWLINE +
                "  };" + NEWLINE +
                "} else {" + NEWLINE +
                "  alert(\"Your browser does not support Web Socket.\");" + NEWLINE +
                '}' + NEWLINE +
                NEWLINE +
                "function send(message) {" + NEWLINE +
                "  if (!window.WebSocket) { return; }" + NEWLINE +
                "  if (socket.readyState == WebSocket.OPEN) {" + NEWLINE +
                "    socket.send(message);" + NEWLINE +
                "  } else {" + NEWLINE +
                "    alert(\"The socket is not open.\");" + NEWLINE +
                "  }" + NEWLINE +
                '}' + NEWLINE +
                "</script>" + NEWLINE +
                "<form onsubmit=\"return false;\">" + NEWLINE +
                "<input type=\"text\" name=\"message\" value=\"Hello, World!\"/>" +
                "<input type=\"button\" value=\"Send Web Socket Data\"" + NEWLINE +
                "       onclick=\"send(this.form.message.value)\" />" + NEWLINE +
                "<h3>Output</h3>" + NEWLINE +
                "<textarea id=\"responseText\" style=\"width:500px;height:300px;\"></textarea>" + NEWLINE +
                "</form>" + NEWLINE +
                "</body>" + NEWLINE +
                "</html>" + NEWLINE, CharsetUtil.US_ASCII);
    }
    //http://www.css88.com/tool/html2js/
    public static ByteBuf getContent2(String webSocketLocation) {
    	return Unpooled.copiedBuffer(
    			"<!DOCTYPE html>"+NEWLINE +
    					"<html>"+NEWLINE +
    					"    <head>"+NEWLINE +
    					"        <title>Pusher Chat  - live demo</title>"+NEWLINE +
    					"        <link href=\"css/chat-style.css\" rel=\"stylesheet\">"+NEWLINE +
    					"        <script src=\"http://js.pusher.com/1.12/pusher.min.js\" type=\"text/javascript\"></script> "+NEWLINE +
    					"        <script src=\"http://code.jquery.com/jquery-1.8.2.min.js\" type=\"text/javascript\"></script>"+NEWLINE +
    					"        <script src=\"js/jquery.pusherchat.js\" type=\"text/javascript\"></script>"+NEWLINE +
    					"        <script src=\"js/jquery.playSound.js\" type=\"text/javascript\"></script>"+NEWLINE +
    					"        "+NEWLINE +
    					"        <style>"+NEWLINE +
    					"            /* demo style */"+NEWLINE +
    					"            body{color: #333;font-family:arial, verdana, sans-serif;}"+NEWLINE +
    					"            small{color:#ccc ; font-size: 14px}"+NEWLINE +
    					"            .account a{ color :#333; background: #eee; border: 1px solid #ccc;padding: 5px; border-radius: 5px;display: inline-block;}"+NEWLINE +
    					"            pre{line-height: 11px;font-size: 11px;background: #fafafa;border: 1px solid #ccc; padding: 10px}"+NEWLINE +
    					"            .hide{font-size: 19px ;color:red ; font-weight: bold;display: none}"+NEWLINE +
    					"            .connexion {font-size: 19px ;color:green ; font-weight: bold;}"+NEWLINE +
    					"        </style>"+NEWLINE +
    					"    </head>"+NEWLINE +
    					"    <body>"+NEWLINE +
    					"    	<!-- ע�� -->"+
    					"        <!--***************************************************** pusher chat html *******************************************************-->"+NEWLINE +
    					"        <div id=\"pusherChat\">"+NEWLINE +
    					"            <div id=\"membersContent\">                "+NEWLINE +
    					"                <span id=\"expand\"><span class=\"close\">&#x25BC;</span><span class=\"open\">&#x25B2;</span></span>"+NEWLINE +
    					"                <h2><span id=\"count\">0</span> online</h2>"+NEWLINE +
    					"                <div class=\"scroll\">"+NEWLINE +
    					"                    <div id=\"members-list\"></div>"+NEWLINE +
    					"                </div>"+NEWLINE +
    					"            </div>"+NEWLINE +
    					"            <!-- chat box template -->"+NEWLINE +
    					"            <div id=\"templateChatBox\">"+NEWLINE +
    					"                <div class=\"pusherChatBox\">"+NEWLINE +
    					"                    <span class=\"state\">"+NEWLINE +
    					"                        <span class=\"pencil\">"+NEWLINE +
    					"                            <img src=\"assets/pencil.gif\" />"+NEWLINE +
    					"                        </span>"+NEWLINE +
    					"                        <span class=\"quote\">"+NEWLINE +
    					"                            <img src=\"assets/quote.gif\" />"+NEWLINE +
    					"                        </span>"+NEWLINE +
    					"                    </span>"+NEWLINE +
    					"                    <span class=\"expand\"><span class=\"close\">&#x25BC;</span><span class=\"open\">&#x25B2;</span></span>"+NEWLINE +
    					"                    <span class=\"closeBox\">x</span>"+NEWLINE +
    					"                    <h2><a href=\"#\" title=\"go to profile\"><img src=\"\" class=\"imgFriend\" /></a> <span class=\"userName\"></span></h2>"+
    					"                    <div class=\"slider\">"+NEWLINE +
    					"                        <div class=\"logMsg\">"+NEWLINE +
    					"                            <div class=\"msgTxt\">"+NEWLINE +
    					"                            </div>"+NEWLINE +
    					"                        </div>"+NEWLINE +
    					"                        <form method=\"post\" name=\"#123\">"+NEWLINE +
    					"                            <textarea  name=\"msg\" rows=\"3\" ></textarea>"+NEWLINE +
    					"                            <input type=\"hidden\" name=\"from\" class=\"from\" />"+NEWLINE +
    					"                            <input type=\"hidden\" name=\"to\"  class=\"to\"/>"+NEWLINE +
    					"                            <input type=\"hidden\" name=\"typing\"  class=\"typing\" value=\"false\"/>"+
    					"                        </form>"+NEWLINE +
    					"                    </div>"+NEWLINE +
    					"                </div>"+NEWLINE +
    					"            </div>"+NEWLINE +
    					"            <!-- chat box template end -->"+
    					"            <div class=\"chatBoxWrap\">"+
    					"                <div class=\"chatBoxslide\"></div>"+
    					"                <span id=\"slideLeft\"> <img src=\"assets/quote.gif\" />&#x25C0;</span> "+
    					"                <span id=\"slideRight\">&#x25B6; <img src=\"assets/quote.gif\" /></span>"+
    					"            </div>"+
    					"        </div>"+
    					"        <!--***************************************************** end pusher chat html *******************************************************-->"+
    					"        <hr/>"+
    					"       "+
    					"        <script type=\"text/javascript\">"+
    					"            /*"+
    					"             * this part is only for demo you don\'t need this"+
    					"             */"+
    					"            function getUrlVars() {"+
    					"                var vars = {};"+
    					"                var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {"+
    					"                    vars[key] = value;"+
    					"                });"+
    					"                return vars;"+
    					"            }"+
    					"            var id = getUrlVars()[\'user_id\'];"+
    					"            var name = getUrlVars()[\'name\'];"+
    					"            if (id==\"undefined\") {"+
    					"                id=\"\"; "+
    					"            } else $(\'#user_\'+id).hide();"+
    					"            if (name==\"undefined\") name=\"\";"+
    					"            if (!id) $(\'#pusherChat\').remove();"+
    					"            if (name)"+
    					"                $(\'.connexion\').html(\'You are connected as \'+name.replace(\'%20\',\' \'));"+
    					"            /*"+
    					"             * this part is only for demo you don\'t need this"+
    					"             */"+
    					"        </script>"+
    					"        <script>"+
    					"        $(document).ready(function(){"+
    					"            function showWindow(){"+
    					"                var htm=\"<div id=\'register\' style=\'position:fixed; height:200px; width:400px; background:#CCC;\'><em id=\'close\' style=\'font-size:30px; float:right; margin-right:20px;\'>��</em><h3 style=\'color:#FFF; text-align:center;\'>ע��</h3><p style=\'text-align:center;\'><input type=\'text\' id=\'username\' placeholder=\'�û���\'  /></p><p style=\'text-align:center;\'><input type=\'password\' id=\'userpass\' placeholder=\'����\' /><em id=\'strength\'></em></p><p id=\'regist\' style=\'margin:40px auto 0 auto;height:30px;width:180px;background:#09C;color:#FFF;font-size:18px;text-align:center;line-height:30px;border-radius: 6px;cursor:pointer\'>ע��</p></div>\";"+
    					"                $(\"body\").append(htm);"+
    					"                return false;"+
    					"                }"+
    					"            function removeWindow(){"+
    					"                $(\"#register\").fadeOut(function(){"+
    					"                    $(\"#register\").remove();"+
    					"                    });"+
    					"                return false;"+
    					"                }"+
    					"            function center(id){"+
    					"                var h=$(window).height();"+
    					"                var w=$(window).width();"+
    					"                var fh=$(\"#\"+id).height();"+
    					"                var fw=$(\"#\"+id).width();"+
    					"                $(\"#\"+id).css({"+
    					"                    \"top\":(h-fh)/2,"+
    					"                    \"left\":(w-fw)/2"+
    					"                    });"+
    					"            }"+
    					"            $(window).resize(function(){"+
    					"            center(\"register\");"+
    					"            });"+
    					"		"+
    					"            showWindow();"+
    					"            center(\"register\");"+
    					"            $(\"#close\").click(function(){"+
    					"               // removeWindow();"+
    					"               alert(\"��ע�ᣡ\");"+
    					"            });"+
    					"            $(\"#regist\").click(function(){"+
    					"            	var name=$(\"#username\").val(),pwd=$(\"#userpass\").val();"+
    					"            	if(name==\"\"||pwd==\"\"){"+
    					"            		alert(\"�û���������벻��Ϊ��!\")"+
    					"            	}else{"+
    					"            		//ajax��ͬԴ���Բ����?����������  http://stackoverflow.com/questions/9310112/why-am-i-seeing-an-origin-is-not-allowed-by-access-control-allow-origin-error"+
    					"            		$.post(\"http://localhost:9080\",{name:name,pwd:pwd},function(data){"+
    					"            			console.log(1)"+
    					"            		})"+
    					"            	}"+
    					"            })"+
    					"            "+
    					"        });"+
    					"            $.fn.pusherChat({"+
    					"                \'pusherKey\':\'GET YOUR KEY FROM http://pusher.com\',"+
    					"                \'authPath\':\'server/pusher_auth.php?user_id=\'+id+\'&name=\'+name,"+
    					"                \'friendsList\' : \'ajax/friends-list.json\',"+
    					"                \'serverPath\' : \'server/server.php\',"+
    					"                \'profilePage\':true,"+
    					"                \'onFriendConnect\': function(member){"+
    					"                    if (member.id) $(\'#user_\'+member.id).hide();  "+
    					"                    if (!$(\'.account a:visible\').html()) $(\'.hide\').show();"+
    					"                },"+
    					"                \'onFriendLogOut\': function(member){"+
    					"                    if (member.id) $(\'#user_\'+member.id).show();  "+
    					"                    if ($(\'.account a:visible\').html()) $(\'.hide\').hide();"+
    					"                },"+
    					"                \'onSubscription\':function(members){"+
    					"                    if ($(\'.account a:visible\').html()) $(\'.hide\').hide();"+
    					"                    $.each(members._members_map, function(val){"+
    					"                        $(\'#user_\'+val).hide();"+
    					"                    });            "+
    					"                }"+
    					"            });"+
    					"        </script>"+NEWLINE +
    					"    </body>"+NEWLINE +
    					"</html>"
    			, CharsetUtil.US_ASCII);
    			
    			
    }
    private WebSocketServerIndexPage() {
        // Unused
    }
}
