package com.leet.company;

public class Company {
	private String company_id;
	private String company_name;
	private String company_property;
	private String contact_name;
	private String contact_number;
	private String contact_email;
	private String project_id;
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_property() {
		return company_property;
	}
	public void setCompany_property(String company_property) {
		this.company_property = company_property;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public Company(String company_id, String company_name,
			String company_property, String contact_name,
			String contact_number, String contact_email, String project_id) {
		this.company_id = company_id;
		this.company_name = company_name;
		this.company_property = company_property;
		this.contact_name = contact_name;
		this.contact_number = contact_number;
		this.contact_email = contact_email;
		this.project_id = project_id;
	}
	public Company(){
	}
	
}
