package com.leet.project;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.leet.db.DBUtil;

public class ProjectDao {
		public void addProject(Project project) throws Exception{
			Connection conn=DBUtil.getConnection();
			String sql="insert into project_info values(?,?,?,?,?,?,?,?,?);";
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1,project.getProject_id());
			pre.setString(2,project.getProject_name());
			pre.setString(3,project.getProject_property());
			pre.setString(4,project.getProject_type());
			pre.setDouble(5,project.getProject_cost());
			pre.setString(6,project.getProject_state());
			java.sql.Date sqlstart=new java.sql.Date(project.getProject_start_time().getTime());
			java.sql.Date sqlfinish=new java.sql.Date(project.getProject_finish_time().getTime());
			pre.setDate(7,  sqlstart);
			pre.setDate(8, sqlfinish);
			pre.setDouble(9, project.getProject_rest_cost());
			pre.execute();
		}
		
		public void delProject(String pro_id) throws Exception{
			Connection conn=DBUtil.getConnection();
			String sql="delete from project_info where project_id=?;";
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1, pro_id);
			pre.execute();
		}
		
		public void updateProject(Project project) throws Exception{
			Connection conn=DBUtil.getConnection();
			String sql="update project_info set project_name=?,project_property=?,project_type=?,project_cost=?,"
					+ "project_state=?,project_start_time=?,project_finish_time=?,project_rest_cost=? where project_id=?";
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1,project.getProject_name());
			pre.setString(2,project.getProject_property());
			pre.setString(3,project.getProject_type());
			pre.setDouble(4,project.getProject_cost());
			pre.setString(5,project.getProject_state());
			java.sql.Date sqlstart=new java.sql.Date(project.getProject_start_time().getTime());
			java.sql.Date sqlfinish=new java.sql.Date(project.getProject_finish_time().getTime());
			pre.setDate(6,  sqlstart);
			pre.setDate(7, sqlfinish);
			pre.setDouble(8,project.getProject_rest_cost());
			pre.setString(9,project.getProject_id());
			pre.execute();
		}
		
		public Project queryProject(String pro_id) throws Exception{
			Connection conn=DBUtil.getConnection();
			String sql="select * from project_info where project_id=?;";
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1, pro_id);
			ResultSet result=pre.executeQuery();
			if(!result.next())
				return null;
			else{
			Project project=new Project();
			project.setProject_id(pro_id);
			project.setProject_name(result.getString("project_name"));
			project.setProject_property(result.getString("project_property"));
			project.setProject_type(result.getString("project_type"));
			project.setProject_cost(result.getDouble("project_cost"));
			project.setProject_state(result.getString("project_state"));
			project.setProject_start_time(result.getDate("project_start_time"));
			project.setProject_finish_time(result.getDate("project_finish_time"));
			project.setProject_rest_cost(result.getDouble("project_rest_cost"));
			return project;
			}
		}
		
		public boolean isExistProject(String pro_id) throws Exception{
			Connection conn=DBUtil.getConnection();
			String sql="select * from project_info where project_id=?;";
			PreparedStatement pre;
				pre = conn.prepareStatement(sql);
				pre.setString(1, pro_id);
				ResultSet result=pre.executeQuery(sql);
				if(result.next()){
					return false;
				}else{
					return true;
				}
		}
		
		
}
