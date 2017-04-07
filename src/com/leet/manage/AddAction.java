package com.leet.manage;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.leet.company.Company;
import com.leet.company.CompanyDao;
import com.leet.person.User;
import com.leet.project.Project;
import com.leet.project.ProjectDao;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport  implements Action,ServletResponseAware{
		private String project_id;
		private String project_name;
		private String project_property;
		private String project_type;
		private Double project_cost;
		private String project_state;
		private Date project_start_time;
		private Date project_finish_time;
		private Double project_rest_cost;
		private String contract_id;
		private String username;
		private String company_id;
		private String company_name;
		private String company_property;
		private String contact_name;
		private String contact_number;
		private String contact_email;
		private String company_id_two;
		private String company_name_two;
		private String company_property_two;
		private String contact_name_two;
		private String contact_number_two;
		private String contact_email_two;
		private HttpServletResponse response;
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
		public void setProject_start_time(Date project_start_time) {
			this.project_start_time = project_start_time;
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
		public String getContract_id() {
			return contract_id;
		}
		public void setContract_id(String contract_id) {
			this.contract_id = contract_id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
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
		public String getCompany_id_two() {
			return company_id_two;
		}
		public void setCompany_id_two(String company_id_two) {
			this.company_id_two = company_id_two;
		}
		public String getCompany_name_two() {
			return company_name_two;
		}
		public void setCompany_name_two(String company_name_two) {
			this.company_name_two = company_name_two;
		}
		public String getCompany_property_two() {
			return company_property_two;
		}
		public void setCompany_property_two(String company_property_two) {
			this.company_property_two = company_property_two;
		}
		public String getContact_name_two() {
			return contact_name_two;
		}
		public void setContact_name_two(String contact_name_two) {
			this.contact_name_two = contact_name_two;
		}
		public String getContact_number_two() {
			return contact_number_two;
		}
		public void setContact_number_two(String contact_number_two) {
			this.contact_number_two = contact_number_two;
		}
		public String getContact_email_two() {
			return contact_email_two;
		}
		public void setContact_email_two(String contact_email_two) {
			this.contact_email_two = contact_email_two;
		}
		
		public HttpServletResponse getResponse() {
			return response;
		}
		public void setResponse(HttpServletResponse response) {
			this.response = response;
		}
		@Override
		public String execute() throws Exception {
//			System.out.println("AddAction [project_id=" + project_id + ", project_name="
//					+ project_name + ", project_property=" + project_property
//					+ ", project_type=" + project_type + ", project_cost="
//					+ project_cost + ", project_state=" + project_state
//					+ ", project_start_time=" + project_start_time
//					+ ", project_finish_time=" + project_finish_time
//					+ ", project_rest_cost=" + project_rest_cost
//					+ ", contract_id=" + contract_id + ", username=" + username
//					+ ", company_id=" + company_id + ", company_name="
//					+ company_name + ", company_property=" + company_property
//					+ ", contact_name=" + contact_name + ", contact_number="
//					+ contact_number + ", contact_email=" + contact_email + "]");
			HttpServletRequest request=ServletActionContext.getRequest();
			Cookie[] cookies=request.getCookies();
			String user=null;
			for(Cookie cookie : cookies){
				if(URLDecoder.decode(cookie.getName(), "UTF-8").equals("username")){
					 user=URLDecoder.decode(cookie.getValue(), "UTF-8");
					 break;
				}
			}
			System.out.println("用户名为"+user);
			//System.out.println(user);
			//System.out.println(this.getUsername());
			Project pro=new Project(project_id,project_name,
					project_property, project_type, project_cost,
					project_state, project_start_time,
					 project_finish_time, project_rest_cost);
			ProjectDao proDao=new ProjectDao();
//			System.out.println(this.getProject_id()+","+project_name+","+
//					project_property+","+project_type+","+ project_cost+","+
//					project_state+","+ project_start_time+","+
//					 project_finish_time+","+ project_rest_cost);
			proDao.addProject(pro);
			Company com=new Company( company_id, company_name,
					company_property, contact_name,
					contact_number,  contact_email, project_id);
			CompanyDao comDao=new CompanyDao();
			comDao.addCompany(com);
			ActionContext ctx=ActionContext.getContext();
			if(!(company_id_two.length() == 0 || company_id_two == null)&&!(company_name_two.length() == 0 || company_name_two == null)
					&&!(contact_name_two.length() == 0 || contact_name_two == null)&&!(contact_number_two.length() == 0 || contact_number_two == null)
					&&!(contact_email_two.length() == 0 || contact_email_two== null)){
				Company com_two=new Company(company_id_two, company_name_two,
						company_property_two, contact_name_two,
						contact_number_two,  contact_email, project_id);		
				Cookie c=new Cookie(contract_id,"2");
				c.setMaxAge(60*60);
				response.addCookie(c);
				comDao.addCompany(com_two);
			}else{
				Cookie c=new Cookie(contract_id,"1");
				c.setMaxAge(60*60);
				response.addCookie(c);
			}
			ManageProject manpro=new ManageProject(contract_id, project_id, user);
			ManageProjectDao manpd=new ManageProjectDao();
			manpd.addManage(manpro);
			return SUCCESS;
		}

	@Override
	public void validate() {
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m_two=p.matcher(contact_number_two);
		Matcher m = p.matcher(contact_number);
		String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern pEmail = Pattern.compile(check);
		Matcher mEmail = pEmail.matcher(contact_email);
		Matcher mEmail_two=pEmail.matcher(contact_email_two);
		ProjectDao pDao = new ProjectDao();
		CompanyDao cDao = new CompanyDao();
		ManageProjectDao mpDao = new ManageProjectDao();
		try {
			if (pDao.queryProject(project_id) != null) {
				this.addFieldError("error", "项目已存在！");
			}else  if (mpDao.queryManage(contract_id) != null) {
				this.addFieldError("error", "合同已经存在！");
			}else if (cDao.queryCompany(company_id) != null) {
				this.addFieldError("error", "单位编号已存在！");
			}else if (project_id.length() == 0 || project_id == null) {
				this.addFieldError("error", "项目编号不能为空！");
			} else if (project_name.length() == 0 || project_name == null) {
				this.addFieldError("error", "项目名不能为空！");
			} else if (project_state.length() == 0 || project_state == null) {
				this.addFieldError("error", "项目状态不能为空！");
			} else if (contract_id.length() == 0 || contract_id == null) {
				this.addFieldError("error", "合同编号不能为空！");
			} else if (company_id.length() == 0 || company_id == null) {
				this.addFieldError("error", "单位编号不能为空！");
			} else if (company_name.length() == 0 || company_name == null) {
				this.addFieldError("error", "单位名不能为空！");
			} else if (contact_name.length() == 0 || contact_name == null) {
				this.addFieldError("error", "联系人不能为空！");
			} else if (contact_number.length() == 0 || contact_number == null) {
				this.addFieldError("error", "电话号码不能为空！");
			} else if (!m.matches()) {
				this.addFieldError("error", "请输入11位正确的电话号码！");
			} else if (contact_email.length() == 0 || contact_email == null) {
				this.addFieldError("error", "电子邮箱不能为空！");
			} else if (!mEmail.matches()) {
				this.addFieldError("error", "电子邮箱格式错误！");
			}else if(project_finish_time.before(project_start_time)){
				this.addFieldError("error", "项目结束日期应在开始日期之后！");
			}else if(!(company_id_two.length() == 0 || company_id_two == null)&&!(company_name_two.length() == 0 || company_name_two == null)
					&&!(contact_name_two.length() == 0 || contact_name_two == null)&&!(contact_number_two.length() == 0 || contact_number_two == null)
					&&!(contact_email_two.length() == 0 || contact_email_two== null)){
				if(!m_two.matches()){
					this.addFieldError("error", "请输入11位正确的电话号码！");
				}else if(!mEmail_two.matches()){
					this.addFieldError("error", "电子邮箱格式错误！");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		@Override
		public void setServletResponse(HttpServletResponse response) {
			// TODO Auto-generated method stub
			this.response=response;
		}
}
