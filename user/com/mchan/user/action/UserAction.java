package com.mchan.user.action;

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
import org.springframework.stereotype.Controller;

import com.mchan.user.domain.User;
import com.mchan.user.repository.UserServiceRepository;
import com.mchan.user.service.UserServices;
import com.mchan.util.Validate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author soe san
 *
 */
@Results({	@Result(name = "HOME", location = "/home.jsp")})
@Controller
public class UserAction extends ActionSupport implements ServletRequestAware{

	/*-*******************************************************************************
	 *                            INSTANCE VARIABLES                                 *
	 *********************************************************************************/
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3853195868212032439L;

	/**
	 * Instance date object
	 */
	Date currentDate = new Date();

	/**
	 * Create user instance object
	 */
	User user = new User();

	/**
	 * sessionFactory private
	 */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * userDAO UserDao
	 */
	@Autowired
	UserServices userServices = new UserServiceRepository();

	/**
	 * objList List<Object>
	 */
	List<User> userList = new ArrayList<>();

	/*-*******************************************************************************
	 *                           GETTER AND SETTER METHODS                           *
	 *********************************************************************************/

	/**
	 * @return user User
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user User
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}


	/*-*******************************************************************************
	 *******************************ACTION PROCESSING*********************************
	 *********************************************************************************/

	/**
	 * Save or Update user action.
	 *
	 * @return String
	 * @throws IOException
	 */
	@Action(value = "saveUserAction")
	public String insert() throws IOException {

		//load property file to get Message value
		new Validate().loadPropertyFile();

		if(user.getUserName().equals("")){
			this.addActionError(getText(Validate.prop.getProperty("NM_REQ0001")));
		}

		else if(user.getEmail().equals("")){
			this.addActionError(getText(Validate.prop.getProperty("EM_REQ0002")));
		}

		else if(user.getPassword().equals("")){
			this.addActionError(getText(Validate.prop.getProperty("PW_REQ0001")));
		}

		else if(user.getConfPassword().equals("")){
			this.addActionError(getText(Validate.prop.getProperty("PW_REQ0002")));
		}

		else if(!user.getPassword().equals(user.getConfPassword())){
			this.addActionError(getText(Validate.prop.getProperty("PW_NMH0003")));
		}

		else if(!Validate.isValidEmailAddress(user.getEmail())){

			//Display the error message if e-mail is invalid
			this.addActionError(getText(Validate.prop.getProperty("EML0001")));
		}else{

			userServices.insert(user);

			//Display the successful message
			this.addActionMessage(getText(Validate.prop.getProperty("REG_SUCC")));
		}
		return "HOME";
	}

	/**
	 * To list all users.
	 *
	 * @return String
	 */
	public String list() {
		userList = userServices.listUser();
		return SUCCESS;
	}

	/**
	 * To delete a user.
	 *
	 * @return String
	 */
	public String delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		userServices.delete(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	/**
	 * To list a single user by Id.
	 *
	 * @return String
	 */
	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		user = userServices.getUserById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
	}
}
