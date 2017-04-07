package com.leet.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.leet.db.DBUtil;

public class ManageProjectDao {
	
	public void addManage(ManageProject manpro) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="insert into project_manage values(?,?,?);";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1, manpro.getContract_id());
		pre.setString(2, manpro.getUsername());
		pre.setString(3,manpro.getProject_id());
		pre.execute();
	}
	
	public void delManage(String con_id) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="delete from project_manage where contract_id=?;";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1, con_id);
		pre.execute();
	}
	
	public ManageProject queryManage(String con_id) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="select * from project_manage where contract_id=?;";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1,con_id);
		ManageProject manpro=new ManageProject();
		ResultSet result=pre.executeQuery();
		if(!result.next()){
			return null;
		}else{
		manpro.setContract_id(con_id);
		manpro.setProject_id(result.getString("project_id"));
		manpro.setUsername(result.getString("username"));
		return manpro;
		}
	}
	
	public void updateManage(ManageProject manpro) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="update project_manage set  project_id=? where contract_id=?;";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1, manpro.getProject_id());
		pre.setString(2,manpro.getContract_id());
		pre.execute();
	}
	
	public List<ManageProject> queryAll(String username) throws Exception{
		Connection conn=DBUtil.getConnection();
		List<ManageProject> list=new ArrayList<ManageProject>();
		String sql="select contract_id,project_id  from project_manage where username=?;";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1,username);
		ResultSet result=pre.executeQuery();
		ManageProject manpro=null;
		while(result.next()){
			manpro=new ManageProject();
			manpro.setContract_id(result.getString("contract_id"));
			manpro.setProject_id(result.getString("project_id"));
			list.add(manpro);
		}
		return list;
	}

}
