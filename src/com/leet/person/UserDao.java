package com.leet.person;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.leet.db.DBUtil;

public class UserDao {
	public void addUser(String name,String password) throws Exception{
		Connection conn= DBUtil.getConnection();
		String sql="insert into user (username,password) values (?,?);";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1, name);
		pre.setString(2,password);
		pre.execute();
	}
	public void delUser(){
		
	}
	public String queryUser(String name,String pass) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql=" select * from user where username=? and password=? ;";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1, name);
		pre.setString(2,pass);
		ResultSet result=pre.executeQuery();
		if(result.next()){
			return name;
		}else{
			return null;
		}
	}
	public void updateUser(){
		
	}
	public String isExists(String username,String pwd) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql=" select username from user where username=? and password=?;";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1,username);
		pre.setString(2,pwd);
		ResultSet result=pre.executeQuery();
		String str=result.getString("username");
		return str;
	}
	public boolean isExistsUser(String username) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql=" select username from user where username=?;";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1,username);
		ResultSet result=pre.executeQuery();
		if(result.next()){
			return true;
		}else{
			return false;
		}
	}
	
}
