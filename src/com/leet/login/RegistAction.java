package com.leet.login;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.leet.db.DBUtil;
import com.leet.person.UserDao;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport{
	private String username;
	private String password;
	private String confirm_pwd;
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
	public String getConfirm_pwd() {
		return confirm_pwd;
	}
	public void setConfirm_pwd(String confirm_pwd) {
		this.confirm_pwd = confirm_pwd;
	}
	@Override
	public String execute() throws Exception {
	// TODO Auto-generated method stub
		UserDao userDao=new UserDao();
//		String name="leet";
//		String pass="123456";
//		userDao.addUser(name,pass);
		//判断用户是否已经存在于数据库中
		userDao.addUser(username, password);
		return SUCCESS;
	}
	@Override
	public void validate() {
		UserDao userDao=new UserDao();
		try {
			if(userDao.isExistsUser(username)){
				this.addFieldError("errorshow","用户已存在！");
			}
			if(username.length()==0){
				this.addFieldError("errorshow","用户名不能为空！");
			}
			if(password.length()==0){
				this.addFieldError("errorshow","密码不能为空！");
			}else if(!password.equals(confirm_pwd)){
				this.addFieldError("errorshow", "密码不一致！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
