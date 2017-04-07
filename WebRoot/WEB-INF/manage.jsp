<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.leet.manage.*"  import ="java.net.URLDecoder" 
import= "java.net.URLEncoder" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理项目</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%
	String username=(String)request.getParameter("username");
	application.setAttribute("username", username);
	%>
	<style type="text/css">
	.top{
	width:100%;
	height:80px;
	background-color:#bfbfbf;
	font-size:45px;
	color:#fff;
	font-family:黑体;
	line-height:80px;
	}
	#add{
	float:right;
	padding-right:5%;
	padding-top:13px;;
	}
	.show{
	width:670px;
	margin-left:20%;
	margin-top:20px;
	border-collapse:collapse;
	font-size:20px;
	}
	</style>
	
  </head>
  <%
	Cookie[] cookies=request.getCookies();
  	String user=null;
	for(Cookie cookie : cookies){
		if(URLDecoder.decode(cookie.getName(), "UTF-8").equals("username")){
			 user=URLDecoder.decode(cookie.getValue(), "UTF-8");
			 break;
		}
	}
  	List<ManageProject> list=new ArrayList<ManageProject>();
 	 ManageProjectDao mpd=new ManageProjectDao();
 	 list=mpd.queryAll(user);
  	int count=0;
  %>
  <script type="text/javascript">
  function show(contract_id){
	  window.location.href='detail.jsp?'+contract_id
  }
  </script>
  <body onload="opener.location.reload()">
    <div class="top">
    <div style="float:left;padding-left:5%;">
    科研项目管理 
    </div>
    <form method="post" action="for_add">
    <div  id="add" >
    	<input type="submit" style="background:transparent;border-radius:10px;background-image: url('add.png');width:55px;height:60px;" value="" title="添加项目">
   		<!--  <img alt="pic" src="add.png" title="添加项目" >-->
    </div>
    </form>
    </div>
    <div>用户：<%=user%></div>
    <table class="show" border="1" style="font-family:'宋体'">
    <tr>
    <td>序号</td>
    <td>项目编号</td>
    <td>合同编号</td>
    <td>详情</td>
    </tr>
    <%
    for(ManageProject mp : list){
    	count++;
    %>
    	<tr>
    	<td><%=count %></td>
    	<td><%=mp.getProject_id() %></td>
    	<td><%=mp.getContract_id() %></td>
    	<td><a href="javascript:" onclick="show('<%=mp.getContract_id()%>')">详情</a></td>
    	</tr>
 <% 
    }
    %>
    </table>
  </body>
</html>
