package com.mchan.activity.action;

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

import com.mchan.activity.domain.Activity;
import com.mchan.activity.repository.ActivityRepository;
import com.mchan.activity.service.ActivityService;
import com.mchan.util.DateFormatter;
import com.mchan.util.Formats;
import com.mchan.util.Validate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author soe san
 *
 */
@Results({	@Result(name = "INSERT", location = "/priv_activity/insert.jsp"),
	@Result(name = "UPDATE", location = "/priv_activity/update.jsp")
})
public class ActivityAction extends ActionSupport implements ServletRequestAware{

	/*-*******************************************************************************
	 *                            INSTANCE VARIABLES                                 *
	 *********************************************************************************/

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2386917827972862234L;

	/**
	 * session SessionFactory
	 */
	@Autowired
	SessionFactory session;

	/**
	 * activityService ActivityService
	 */
	@Autowired
	ActivityService activityService = new ActivityRepository();

	/**
	 * Instance date object
	 */
	Date currentDate = new Date();

	/**
	 * Create activity's instance object
	 */
	Activity activity = new Activity();

	/**
	 * activity List<Object>
	 */
	List<Activity> activityList = new ArrayList<>();

	/*-*******************************************************************************
	 *                           GETTER AND SETTER METHODS                           *
	 *********************************************************************************/

	/**
	 * @return Activity
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * @param activity
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	/**
	 * @return Activity
	 */
	public List<Activity> getActivityList() {
		return activityList;
	}

	/**
	 * @param activityList
	 */
	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

	/*-*******************************************************************************
	 *******************************ACTION PROCESSING*********************************
	 *********************************************************************************/

	/**
	 * @return String
	 */
	@Action(value = "saveActivityAction")
	public String insert() {
		try {

			//load property file to get Message value
			new Validate().loadPropertyFile();

			activity.setCreateDate(DateFormatter.format(currentDate, Formats.DD_MMM_YYYY_HH_MM_ss_a));
			activityService.insert(activity);

			//Display the Register successful message
			this.addActionMessage(getText(Validate.prop.getProperty("REG_SUCC")));
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			// to list all activity
			activityList = activityService.listAll();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "updActivityAction")
	public String update(){
		try{

			//load property file to get Message value
			new Validate().loadPropertyFile();

			activity.setUpdateDate(DateFormatter.format(currentDate, Formats.DD_MMM_YYYY_HH_MM_ss_a));
			activityService.update(activity);

			//Display the Update successful message
			this.addActionMessage(getText(Validate.prop.getProperty("UPD_SUCC")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}finally{

			// to list all activity
			activityList = activityService.listAll();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "delActivityAction")
	public String delete(){
		try{

			//load property file to get Message value
			new Validate().loadPropertyFile();

			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			activityService.delete(Long.parseLong(request.getParameter("id")));

			//Display the Delete successful message
			this.addActionMessage(getText(Validate.prop.getProperty("DEL_SUCC")));
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			// to list all activity
			activityList = activityService.listAll();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 * @throws IOException
	 */
	@Action(value = "searchActivity")
	public String search() throws IOException{

		//load property file to get Message value
		new Validate().loadPropertyFile();

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		activityList = activityService.search(request.getParameter("searchValue"));

		if(activityList.size() <= 0){

			//Display the error message if no search result
			this.addActionError(getText(Validate.prop.getProperty("NOT_FUD")));
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "getActivityId")
	public String getModifyId(){
		try{
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			activity = activityService.getById(Long.parseLong(request.getParameter("id")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "UPDATE";
	}

	/**
	 * @return String
	 */
	@Action(value = "activity_Init_Display")
	public String list(){
		activityList = activityService.listAll();
		return "INSERT";
	}



	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
	}



}
