package com.leet.manage;

public class ManageProject {
	private String contract_id;
	private String project_id;
	private String username;
	public String getContract_id() {
		return contract_id;
	}
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ManageProject(String contract_id, String project_id, String username) {
		this.contract_id = contract_id;
		this.project_id = project_id;
		this.username = username;
	}
	public ManageProject(){
		
	}
	
	
}
