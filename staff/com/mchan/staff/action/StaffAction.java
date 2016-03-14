package com.mchan.staff.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mchan.staff.domain.Staff;
import com.mchan.staff.repository.StaffRepository;
import com.mchan.staff.service.StaffService;
import com.mchan.util.DateFormatter;
import com.mchan.util.Formats;
import com.mchan.util.Validate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author soe san
 *
 */
@Results({	@Result(name = "INSERT", location = "/priv_staff/insert.jsp"),
	@Result(name = "UPDATE", location = "/priv_staff/update.jsp"),
	@Result(name = "DETAIL", location = "/priv_staff/detail.jsp")
})

public class StaffAction extends ActionSupport implements ServletRequestAware{

	/*-*******************************************************************************
	 *                            INSTANCE VARIABLES                                 *
	 *********************************************************************************/

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2503102669713870345L;

	/**
	 * session SessionFactory
	 */
	@Autowired
	SessionFactory session;

	/**
	 * staffService StaffService
	 */
	@Autowired
	StaffService staffService = new StaffRepository();

	/**
	 * Instance date object
	 */
	Date currentDate = new Date();

	/**
	 * Create user instance object
	 */
	Staff staff = new Staff();

	/**
	 * staff List<Object>
	 */
	List<Staff> staffList = new ArrayList<>();

	/*-*******************************************************************************
	 *                           GETTER AND SETTER METHODS                           *
	 *********************************************************************************/

	/**
	 * @return List<Staff>
	 */
	public List<Staff> getStaffList() {
		return staffList;
	}

	/**
	 * @param staffList
	 */
	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	/**
	 * @return Staff
	 */
	public Staff getStaff() {
		return staff;
	}

	/**
	 * @param staff
	 */
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	/*-*******************************************************************************
	 *******************************ACTION PROCESSING*********************************
	 *********************************************************************************/

	/**
	 * @return String
	 */
	@Action(value = "saveStaffAction")
	public String insert() {
		try {

			//load property file to get Message value
			new Validate().loadPropertyFile();

			staff.setCreateDate(DateFormatter.format(currentDate, Formats.SYSTEM));
			String email = staff.getEmail();
			if (Validate.isValidEmailAddress(email)) {
				staffService.insert(staff);

				// Display the successful message
				this.addActionMessage(getText(Validate.prop.getProperty("REG_SUCC")));
			} else {

				// Display the error message if e-mail is invalid
				this.addActionError(getText(Validate.prop.getProperty("EML0001")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		} finally {

			// to list all staff
			staffList = staffService.listAll();
		}

		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "updStaffAction")
	public String update(){
		try{

			//load property file to get Message value
			new Validate().loadPropertyFile();

			staff.setUpdateDate(DateFormatter.format(currentDate, Formats.SYSTEM));
			String email = staff.getEmail();
			if (!Validate.isValidEmailAddress(email)) {

				// Display the error message if e-mail is invalid
				this.addActionError(getText(Validate.prop.getProperty("EML0001")));
			} else {

				staffService.update(staff);

				// Display the successful message
				this.addActionMessage(getText(Validate.prop.getProperty("REG_SUCC")));
				return "INSERT";
			}
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}finally{

			// to list all staff
			staffList = staffService.listAll();
		}
		return "UPDATE";
	}

	/**
	 * @return String
	 */
	@Action(value = "delStaffAction")
	public String delete(){
		try{

			//load property file to get Message value
			new Validate().loadPropertyFile();

			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			staffService.delete(Long.parseLong(request.getParameter("id")));

			//Display the Delete successful message
			this.addActionMessage(getText(Validate.prop.getProperty("DEL_SUCC")));
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			//to list all staff
			staffList = staffService.listAll();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 * @throws IOException
	 */
	@Action(value = "searchStaff")
	public String search() throws IOException{

		//load property file to get Message value
		new Validate().loadPropertyFile();

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		staffList = staffService.search(request.getParameter("searchValue"));

		if(staffList.size() <= 0){

			//Display the error message if no search result
			this.addActionError(getText(Validate.prop.getProperty("NOT_FUD")));
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "getModifyId")
	public String getModifyId(){
		try{
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			staff = staffService.getById(Long.parseLong(request.getParameter("id")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "UPDATE";
	}

	/**
	 * @return String
	 */
	@Action(value = "detailStaffAction")
	public String detail(){
		try{
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			staff = staffService.getById(Long.parseLong(request.getParameter("id")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "staff_Init_Display")
	public String list(){
		staffList = staffService.listAll();
		return "INSERT";
	}


	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}
}
