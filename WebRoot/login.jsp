<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">
	.loginbox{
	width:400px;
	height:400px;
	/*border:2px solid #f00;*/
	margin:13% auto;
	
	}
	.inputbox{
	width:300px;
	height:55px;
	margin-left: 60px;
	font-size:20px;
	background:rgba(45,45,45,.15);
	border-radius:12px;
	color:#fff;
	 -moz-box-shadow:0 0 10px #000;
     -webkit-box-shadow:0 0 10px #000;
     box-shadow:0 0 10px #000;
     outline:none;
	}
::-webkit-input-placeholder { /* WebKit browsers */
	color: #fff;
}

:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
	color: #fff;
}

::-moz-placeholder { /* Mozilla Firefox 19+ */
	color: #fff;
}

:-ms-input-placeholder { /* Internet Explorer 10+ */
	color: #fff;
}
	.btn{
	width:100px;
	height:50px;
	margin-left: 60px;
	font-size:20px;
	text-align:center;
	line-height:50px;
	}
	a:visited{
	color:#fff;
	}
	</style>
  </head>
  
  <body style="background:url('five.jpg') no-repeat  100%;">
  <form method="post"  action="login" >
  <div class="loginbox">
  <p style="font-family:'微软雅黑';font-size:30;text-align:center;color:white">科研项目管理中心</p>
	<input  class="inputbox"  type="text" name="username"  placeholder="请输入您的用户名" ><br><br>
	<input class="inputbox" type="password" name="password"   placeholder="请输入您的密码"><br><br>
	<div class="btn" style="float:left;"><input type="submit"  style="width:100px;
	height:50px;background:transparent;font-size:20px;border-radius:12px;color:#fff;text-align:center;" value="登录" ></div>
	<div style="float:right;margin-right:35px;">
	<a href="regist.jsp" style="text-decoration:none;">
	<input type="button"  style="width:100px;
	height:50px;background:transparent;font-size:20px;color:#fff;border-radius:12px;text-align:center;" value="注册"  ></a>
	</div>
	<br>
	<div style="clear:both;">
	<span style="font-size:17px;color:white;"><s:fielderror name="loginerror"/></span>
	</div>
	<div>
  </div> 

  </form>
  
  </body>
</html>
