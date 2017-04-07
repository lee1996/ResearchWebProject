package com.leet.login;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.leet.db.DBUtil;
import com.leet.person.UserDao;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport  implements Action,ServletResponseAware{
		private String username;
		private String password;
		private HttpServletResponse response;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public HttpServletResponse getResponse() {
			return response;
		}
		public void setResponse(HttpServletResponse response) {
			this.response = response;
		}
		@Override
		public String execute() throws Exception {
		// TODO Auto-generated method stub
		//	UserDao userDao=new UserDao();
//			int id=userDao.isExists(username, password);
//			if(id!=0){
//				return SUCCESS;
//			}
//			return ERROR;
			System.out.println(username);
			ActionContext ctx=ActionContext.getContext();
			Cookie c=new Cookie(URLEncoder.encode("username", "UTF-8"),URLEncoder.encode(username, "UTF-8"));	 
			c.setMaxAge(60*60);
			response.addCookie(c);
			return SUCCESS;
		}
		@Override
		public void validate() {
			UserDao userDao=new UserDao();
			try {
				if(username.length()==0){
					this.addFieldError("loginerror","用户名不能为空！");
				}else if(userDao.queryUser(username,password) == null){
					if(username.length()==0&&password.length()!=0){
						this.addFieldError("loginerror","用户名不能为空！");
					}else
					if(password.length()==0&&username.length()!=0){
						this.addFieldError("loginerror","密码不能为空！");
					}else
						this.addFieldError("loginerror","用户不存在或者密码错误！");
				}else if(password.length()==0){
					this.addFieldError("loginerror","密码不能为空！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		@Override
		public void setServletResponse(HttpServletResponse response) {
			// TODO Auto-generated method stub
			this.response=response;
		}
		
}
