package com.leet.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.leet.db.DBUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class CompanyDao{
	private HttpServletResponse response;
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void addCompany(Company company) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="insert into research_company values(?,?,?,?,?,?,?);";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1,company.getCompany_id());
		pre.setString(2, company.getCompany_name());
		pre.setString(3, company.getCompany_property());
		pre.setString(4, company.getContact_name());
		pre.setString(5, company.getContact_number());
		pre.setString(6, company.getContact_email());
		pre.setString(7, company.getProject_id());
		pre.execute();
	}
	
	public void delCompany(String com_id) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="delete from research_company where company_id=?;";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1, com_id);
		pre.execute();
	}
	
	public Company queryCompany(String com_id) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="select * from research_company where company_id=?;";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1, com_id);
		ResultSet result=pre.executeQuery();
		if(!result.next()){
			return null;
		}else{
		Company company=new Company();
		company.setCompany_id(com_id);
		company.setCompany_name(result.getString("company_name"));
		company.setCompany_property(result.getString("company_property"));
		company.setContact_name(result.getString("contact_name"));
		company.setContact_number(result.getString("contact_number"));
		company.setContact_email(result.getString("contact_email"));
		company.setProject_id(result.getString("project_id"));
		return company;
		}
	}
	
	public void updateCompany(Company company) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="update research_company set company_name=?,company_property=?,contact_name=?,contact_number=?,"
				+ "contact_email=?,project_id=?  where company_id=?;";
		PreparedStatement pre=conn.prepareStatement(sql);
		pre.setString(1, company.getCompany_name());
		pre.setString(2, company.getCompany_property());
		pre.setString(3, company.getContact_name());
		pre.setString(4, company.getContact_number());
		pre.setString(5, company.getContact_email());
		pre.setString(6, company.getProject_id());
		pre.setString(7,company.getCompany_id());
		pre.execute();
	}
	
	public Company queryProject(String pro_id) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from research_company where project_id=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, pro_id);
		ResultSet result = pre.executeQuery();
		Company com = new Company();
		if(!result.next()){
			System.out.println("result为空！");
			return null;
		}
		else{
		com.setCompany_id(result.getString("company_id"));
		com.setCompany_name(result.getString("company_name"));
		com.setCompany_property(result.getString("company_property"));
		com.setContact_email(result.getString("contact_email"));
		com.setContact_name(result.getString("contact_name"));
		com.setContact_number(result.getString("contact_number"));
		com.setProject_id(pro_id);
		return com;
		}
	}
	
	public List<Company> queryProjectAll(String pro_id) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = "select * from research_company where project_id=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, pro_id);
		ResultSet result = pre.executeQuery();
		List<Company> list=new ArrayList<Company>();
		Company com;
		int count=0;
		while(result.next()){
			count++;
			com=new Company();
			com.setCompany_id(result.getString("company_id"));
			com.setCompany_name(result.getString("company_name"));
			com.setCompany_property(result.getString("company_property"));
			com.setContact_email(result.getString("contact_email"));
			com.setContact_name(result.getString("contact_name"));
			com.setContact_number(result.getString("contact_number"));
			com.setProject_id(pro_id);
			list.add(com);
		}
		String com_count=String.valueOf(count);
		return list;
	}
	
	public int CountCompany(String pro_id) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = "select * from research_company where project_id=?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, pro_id);
		ResultSet result = pre.executeQuery();
		int count=1;
		while(result.next()){
			count++;
		}
		return count;
	}

}
