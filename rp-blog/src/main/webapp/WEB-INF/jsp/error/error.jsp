<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<%@ page import="java.io.*" %>
<%@ page import="org.slf4j.*" %>
<%
Logger log=LoggerFactory.getLogger("ERROR");
log.error(exception.getMessage());
exception.printStackTrace();
%>
<html>   
  <head>   
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>   
    <title>Life better,Do more</title>   
    <style type="text/css">
    	span{
    		position: fixed;
    		top: 40%;
    		right: 20%;
    		font-weight: bold;
    		color: red;
    	}
    </style>
  </head>   
  <body>   
  	<span>没有权限!<br>
  	搜索$user username -p password查看所有加密的博客<br>
  	搜索$password password查看用此密码加密的博客<br>
  	搜索$all 查看所有未加密博客
  	</span>
    <iframe width="600px" scrolling="no" height="520px" frameborder="0" noresize="noresize" src="javascript:'&lt;!doctype html&gt;\n&lt;html&gt;\n\t&lt;head&gt;\n\t\t&lt;title&gt;JS1k, 1k demo submission [1022]&lt;/title&gt;\n\t\t&lt;meta charset=&quot;utf-8&quot; /&gt;\n\t&lt;/head&gt;\n\t&lt;body&gt;\n\t\t&lt;canvas id=&quot;c&quot;&gt;&lt;/canvas&gt;\n\t\t&lt;script&gt;\n\t\t\tvar b = document.body;\n\t\t\tvar c = document.getElementsByTagName(\'canvas\')[0];\n\t\t\tvar a = c.getContext(\'2d\');\n\t\t\tdocument.body.clientWidth; // fix bug in webkit: http://qfox.nl/weblog/218\n\t\t&lt;/script&gt;\n\t\t&lt;script&gt;\n// start of submission //\nwith(m=Math)C=cos,S=sin,P=pow,R=random;c.width=c.height=f=500;h=-250;function p(a,b,c){if(c&gt;60)return[S(a*7)*(13+5/(.2+P(b*4,4)))-S(b)*50,b*f+50,625+C(a*7)*(13+5/(.2+P(b*4,4)))+b*400,a*1-b/2,a];A=a*2-1;B=b*2-1;if(A*A+B*B&lt;1){if(c&gt;37){n=(j=c&amp;1)%3F6:4;o=.5/(a+.01)+C(b*125)*3-a*300;w=b*h;return[o*C(n)+w*S(n)+j*610-390,o*S(n)-w*C(n)+550-j*350,1180+C(B+A)*99-j*300,.4-a*.1+P(1-B*B,-h*6)*.15-a*b*.4+C(a+b)/5+P(C((o*(a+1)+(B&gt;0%3Fw:-w))/25),30)*.1*(1-B*B),o/1e3+.7-o*w*3e-6]}if(c&gt;32){c=c*1.16-.15;o=a*45-20;w=b*b*h;z=o*S(c)+w*C(c)+620;return[o*C(c)-w*S(c),28+C(B*.5)*99-b*b*b*60-z/2-h,z,(b*b*.3+P((1-(A*A)),7)*.15+.3)*b,b*.7]}o=A*(2-b)*(80-c*2);w=99-C(A)*120-C(b)*(-h-c*4.9)+C(P(1-b,7))*50+c*2;z=o*S(c)+w*C(c)+700;return[o*C(c)-w*S(c),B*99-C(P(b, 7))*50-c/3-z/1.35+450,z,(1-b/1.2)*.9+a*.1, P((1-b),20)/4+.05]}}setInterval(\'for(i=0;i&lt;1e4;i++)if(s=p(R(),R(),i%2546/.74)){z=s[2];x=~~(s[0]*f/z-h);y=~~(s[1]*f/z-h);if(!m[q=y*f+x]|m[q]&gt;z)m[q]=z,a.fillStyle=&quot;rgb(&quot;+~(s[3]*h)+&quot;,&quot;+~(s[4]*h)+&quot;,&quot;+~(s[3]*s[3]*-80)+&quot;)&quot;,a.fillRect(x,y,1,1)}\',0)\n// end of submission //\n\t\t&lt;/script&gt;\n\t&lt;/body&gt;\n&lt;/html&gt;'"></iframe>
  </body>   
</html>