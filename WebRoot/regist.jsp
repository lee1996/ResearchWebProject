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
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
.registbox {
	width: 400px;
	height: 400px;
	/*border:2px solid #f00;*/
	margin: 10% auto;
}

.inputbox {
	width: 300px;
	height: 55px;
	margin-left: 60px;
	font-size: 20px;
	border-radius: 12px;
	background:rgba(45,45,45,.15);
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

.btn {
	width: 300px;
	height: 50px;
	background-color: #f00;
	margin-left: 60px;
	font-size: 20px;
	color: #fff;
	text-align: center;
	line-height: 50px;
}
</style>
<script type="text/javascript">
function show(){
alert('注册成功！');
}
</script>
  </head>
  
 <body  style="background:url('eight.jpg') no-repeat  100%;">
	<form action="regist" method="post">
	<div class="registbox">
	 <p style="font-family:'微软雅黑';font-size:30px;text-align:center;color:white">注册新用户</p>
	 <input  class="inputbox"  type="text" name="username"  placeholder="请输入您的用户名"><br><br>
	<input class="inputbox" type="password" name="password"   placeholder="请输入您的密码"><br><br>	
	 <input class="inputbox" type="password" name="confirm_pwd"   placeholder="请再次输入您的密码"><br><br>
	<div style="text-align:center;padding-left:20px;">
	<input type="submit"  style="width:300px;
	height:50px;background:transparent;border-radius:12px;font-size:20px;color:#fff;text-align:center;" value="注册"  ></div>
	<span style="color:white;"><s:fielderror  name="errorshow" /></span>
	</div>
	
	</form>
  </body>
</html>
