<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import=" java.util.Date" 
import=" com.leet.company.Company" 
import=" com.leet.company.CompanyDao"  
import="  com.leet.manage.ManageProject"  
import =" com.leet.manage.ManageProjectDao"  
import =" com.leet.project.Project"  
import =" com.leet.project.ProjectDao" 
import ="java.net.URLDecoder" 
import= "java.net.URLEncoder"
import ="java.net.URLDecoder" 
import= "java.net.URLEncoder"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>详细信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
.addbox {
	width: 1000px;
	font-size: 19px;
	margin-left: 10%;
	line-height: 200%;
}
.title{
width:100%;
height:100px;
font-family:'微软雅黑';
font-size:38px;
color:#fff;
text-align:center;
background-color:#bfbfbf;
line-height:100px;
}
</style>
 <%
	Cookie[] cookies=request.getCookies();
  	String user=null;
	for(Cookie cookie : cookies){
		if(URLDecoder.decode(cookie.getName(), "UTF-8").equals("username")){
			 user=URLDecoder.decode(cookie.getValue(), "UTF-8");
			 break;
		}
	}
%>
<%
	String con_id = request.getQueryString();
	ManageProjectDao mpd=new ManageProjectDao();
	ManageProject mp=mpd.queryManage(con_id);
	String pro_id=mp.getProject_id();
	String username=mp.getUsername();
	ProjectDao pd=new ProjectDao();
	Project pro=pd.queryProject(pro_id);
	String pro_name=pro.getProject_name();
	String pro_property=pro.getProject_property();
	String pro_type=pro.getProject_type();
	double pro_cost=pro.getProject_cost();
	String pro_state=pro.getProject_state();
	Date pro_start_time=pro.getProject_start_time();
	Date pro_finish_time=pro.getProject_finish_time();
	double pro_rest_cost=pro.getProject_rest_cost();
	CompanyDao cd=new CompanyDao();
	List<Company> list=cd.queryProjectAll(pro_id);
	int countCompany=cd.CountCompany(pro_id);
	int len=list.size();
	String com_id="",com_name="",com_property="",con_name="",con_number="",con_email="";
	if(len==2){
		com_id=list.get(1).getCompany_id();
		com_name=list.get(1).getCompany_name();
		com_property=list.get(1).getCompany_property();
		con_name=list.get(1).getContact_name();
		con_number=list.get(1).getContact_number();
		con_email=list.get(1).getContact_email();
	}	
	session.setAttribute("com_count", len);
	session.setAttribute("con_id", con_id);
	session.setAttribute("pro_id", pro_id);
	session.setAttribute("com_id",com_id);
	String con_id_len=String.valueOf(len);
	Cookie cookie=new Cookie(con_id, con_id_len);
	response.addCookie(cookie);
	%>
<script type="text/javascript">
	window.onload = function() {
		var c_name = location.search.substring(1, location.search.length);
		if (document.cookie.length > 0) {
			c_start = document.cookie.indexOf(c_name + "=")
			if (c_start != -1) {
				c_start = c_start + c_name.length + 1
				c_end = document.cookie.indexOf(";", c_start)
				if (c_end == -1)
					c_end = document.cookie.length
				var com_count= unescape(document.cookie.substring(c_start, c_end));
				if(com_count=="2"){
					var div = document.getElementById("research_two");
					div.style.display = 'block';
				}
			}
		}
		/*var name = "com_count";
		var arr, reg = new RegExp("(^|)" + name + "=([^;]*)(;|$)");
		if (arr = document.cookie.match(reg)) {
			var com_count = unescape(arr[2]);
			if (com_count == "2") {
				var div = document.getElementById("research_two");
				div.style.display = 'block';
			}
		}*/
	}
	//已经将每个合同编号作为cookie的key，在javascript中获取query参数值，即可获取cookie的value
</script>

</head>
<body>
	
	<div class="title">
	科研项目详情
	</div>
	<img alt="air" src="air.png" style="padding-left:6%;">&nbsp;
	<span style="font-size:28px;">项目信息</span>
	<br>
	<br>
	<form  method="post"  action="delProject"  class="addbox">
		<div style="float:left;">
		<table  style="line-height:200%;">
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username" 
				style="width:250px;height:30px;font-size:17px"  value=<%=user%> disabled="disabled"></td>
		</tr>
		<tr>
			<td>项目编号：</td>
			<td><input type="text" name="project_id"
				style="width:250px;height:30px;font-size:17px" disabled="disabled" value=<%out.print(pro.getProject_id());%> ></td>
		</tr>
		<tr>
			<td>项目名称：</td>
			<td><input type="text" name="project_name"
				style="width:250px;height:30px;font-size:17px"  disabled="disabled" value=<%out.print(pro.getProject_name());%>></td>
		</tr>
		<tr>
			<td>项目性质：</td>
			<td><input type="text" name=“project_property”
				style="width:250px;height:30px;font-size:17px" value=<%out.print(pro.getProject_property()); %> disabled="disabled"></td>
			</tr>
			<!--  -->
			<tr>
			 <td>项目类型：</td>
			 <td><input type="text" name=“project_type”
				style="width:250px;height:30px;font-size:17px" value=<%out.print(pro.getProject_type()); %> disabled="disabled"> </td>
			</tr>
			<!--  <-->
			<tr>
			<td>项目总费用：</td>
			<td><input type="text" name="project_cost"
				style="width:250px;height:30px;font-size:17px" value=<%out.print(pro.getProject_cost());%> disabled="disabled">单位：千元</td>
			</tr>
				</table>
		</div>
		<div style="float:right;">
		<table  style="line-height:200%;">
		<tr>
			<td>项目状态：</td>
			<td><input  type="text" name="project_state"
				style="width:250px;height:30px;font-size:17px" value=<%out.print(pro.getProject_state());%> disabled="disabled"></td>
		</tr>
		<tr>
			<td>开始日期：</td>
			<td><input type="text" name="project_start_time"  id="start_time"
				style="width:250px;height:30px;font-size:17px"  onfocus="WdatePicker();"  disabled="disabled" value=<%out.print(pro.getProject_start_time());%>></td>
		</tr>
		<tr>
			<td>结题日期：</td>
			<td><input type="datetime" name="project_finish_time"
				style="width:250px;height:30px;font-size:17px" onclick="WdatePicker();" disabled="disabled"  value=<%out.print(pro.getProject_finish_time());%>></td>
		</tr>
		<tr>
			<td>费用余额：</td>
			<td><input 
				type="text" name="project_rest_cost"
				style="width:250px;height:30px;font-size:17px"  disabled="disabled" value=<%out.print(pro.getProject_rest_cost());%>></td>
		</tr>
		<tr>
				<td>合同编号：</td>
				<td><input type="text" name="contract_id"
				style="width:250px;height:30px;font-size:17px" disabled="disabled" value=<%out.print(con_id);%>></td>
		</tr>
		</table>
		</div>
		<div style="clear: both;">
			<img alt="air" src="air.png" style="margin-left:-6%;">&nbsp;<span
				style="font-size:28px;" >科研单位</span><br>
		</div>
		<div id="research">
			<div style="float:left;">
			<table style="line-height:200%;">
			<tr>
				<td>单位编号：</td>
				<td><input type="text" name="company_id"
					style="width:250px;height:30px;font-size:17px" value=<%out.print(list.get(0).getCompany_id());%> disabled="disabled"></td>
			</tr>
			<tr>
				<td>单位名称：</td>
				<td><input  type="text" name="company_name"
					style="width:250px;height:30px;font-size:17px" value=<%out.print(list.get(0).getCompany_name());%> disabled="disabled"></td>
			</tr>
			<tr>
				<td>单位性质： </td>
				<td><input type="text" name=“company_property”
				style="width:250px;height:30px;font-size:17px" value=<%out.print(list.get(0).getCompany_property()); %> disabled="disabled"> </td>
			</tr>
			<!--  -->
				</table>
				<br><br>
			</div>
			<div style="float:right;">
			<table style="line-height:200%;">
				<tr>
				<td>联系人：</td>
				<td><input type="text" name="contact_name"
					style="width:250px;height:30px;font-size:17px" value=<%out.print(list.get(0).getContact_name());%> disabled="disabled"></td>
				</tr>
				<tr>
				<td>电话号码：</td>
				<td><input type="text" name="contact_number"
					style="width:250px;height:30px;font-size:17px" value=<%out.print(list.get(0).getContact_number());%> disabled="disabled"></td>
				</tr>
				<tr>
				<td>电子信箱：</td>
				<td><input type="text" name="contact_email"
					style="width:250px;height:30px;font-size:17px" value=<%out.print(list.get(0).getContact_email());%> disabled="disabled"></td>
				</tr>
					</table><br><br>	
			</div>
		</div>
		<div id="research_two" style="display:none;">
			<div style="float:left;">
			<table style="line-height:200%;">
			<tr>
				<td>单位编号：</td>
				<td><input type="text" name="company_id_two"
					style="width:250px;height:30px;font-size:17px" 
					value=<% out.print(com_id);%> disabled="disabled"></td>
			</tr>
			<tr>
				<td>单位名称：</td>
				<td><input  type="text" name="company_name_two"
					style="width:250px;height:30px;font-size:17px" value=<%out.print(com_name);%> disabled="disabled"></td>
			</tr>
			<tr>
				<td>单位性质： </td>
				<td><input type="text" name=“company_property_two”
				style="width:250px;height:30px;font-size:17px" value=<%out.print(com_property); %> disabled="disabled"> </td>
			</tr>
			<!--  -->
				</table>
				<br><br>
			</div>
			<div style="float:right;">
			<table style="line-height:200%;">
				<tr>
				<td>联系人：</td>
				<td><input type="text" name="contact_name_two"
					style="width:250px;height:30px;font-size:17px" value=<%out.print(con_name);%> disabled="disabled"></td>
				</tr>
				<tr>
				<td>电话号码：</td>
				<td><input type="text" name="contact_number_two"
					style="width:250px;height:30px;font-size:17px" value=<%out.print(con_number);%> disabled="disabled"></td>
				</tr>
				<tr>
				<td>电子信箱：</td>
				<td><input type="text" name="contact_email_two"
					style="width:250px;height:30px;font-size:17px" value=<%out.print(con_email);%> disabled="disabled"></td>
				</tr>
					</table><br><br>	
			</div>
		</div>
		<div style="clear:both;" ></div>
		<s:fielderror name="error"></s:fielderror>
		<!--  <input type="submit" style="background:transparent;color:#000;font-size:25px;margin:auto;width:100px;height:50px;" value="保存">-->
		<input type="submit" style="background:transparent;color:#000;font-size:25px;margin:auto;width:100px;height:50px;" value="删除">
	</form>
</body>
</html>
