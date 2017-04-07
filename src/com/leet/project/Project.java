package com.leet.project;

import java.util.Date;

public class Project {
		private String project_id;
		private String project_name;
		private String project_property;
		private String project_type;
		private Double project_cost;
		private String project_state;
		private Date project_start_time;
		private Date project_finish_time;
		private Double project_rest_cost;
		public String getProject_id() {
			return project_id;
		}
		public void setProject_id(String project_id) {
			this.project_id = project_id;
		}
		public String getProject_name() {
			return project_name;
		}
		public void setProject_name(String project_name) {
			this.project_name = project_name;
		}
		public String getProject_property() {
			return project_property;
		}
		public void setProject_property(String project_property) {
			this.project_property = project_property;
		}
		public String getProject_type() {
			return project_type;
		}
		public void setProject_type(String project_type) {
			this.project_type = project_type;
		}
		public Double getProject_cost() {
			return project_cost;
		}
		public void setProject_cost(Double project_cost) {
			this.project_cost = project_cost;
		}
		public String getProject_state() {
			return project_state;
		}
		public void setProject_state(String project_state) {
			this.project_state = project_state;
		}
		public Date getProject_start_time() {
			return project_start_time;
		}
		public void setProject_start_time(Date dstart) {
			this.project_start_time = dstart;
		}
		public Date getProject_finish_time() {
			return project_finish_time;
		}
		public void setProject_finish_time(Date project_finish_time) {
			this.project_finish_time = project_finish_time;
		}
		public Double getProject_rest_cost() {
			return project_rest_cost;
		}
		public void setProject_rest_cost(Double project_rest_cost) {
			this.project_rest_cost = project_rest_cost;
		}
		public Project(String project_id, String project_name,
				String project_property, String project_type, Double project_cost,
				String project_state, Date project_start_time,
				Date project_finish_time, Double project_rest_cost) {
			this.project_id = project_id;
			this.project_name = project_name;
			this.project_property = project_property;
			this.project_type = project_type;
			this.project_cost = project_cost;
			this.project_state = project_state;
			this.project_start_time = project_start_time;
			this.project_finish_time =  project_finish_time;
			this.project_rest_cost = project_rest_cost;
		}
		public Project(){
			
		}
		
}
