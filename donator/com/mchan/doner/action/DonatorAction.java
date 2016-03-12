package com.mchan.doner.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mchan.doner.domain.Doner;
import com.mchan.doner.repository.UserRepositoryImpl;
import com.mchan.doner.service.UserService;
import com.mchan.util.DateFormatter;
import com.mchan.util.Formats;
import com.mchan.util.Validate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author soe san
 *
 */
@Results({
	@Result(name = "INSERT", location = "/priv_doner/insert.jsp"),
	@Result(name = "UPDATE", location = "/priv_doner/update.jsp"),
	@Result(name = "DETAIL", location = "/priv_doner/detail.jsp"),
})
@InterceptorRefs({
	@InterceptorRef(value = "fileUpload", params = { "maximumSize",
			"2097152", "allowedTypes",
	"image/jpeg,image/jpg,image/bmp,image/gif,image/png" }),
	@InterceptorRef("basicStack") })
@ServletSecurity(@HttpConstraint(rolesAllowed = { "admin" }))
@Controller
public class DonatorAction extends ActionSupport implements ServletRequestAware{

	/*-*******************************************************************************
	 *                            INSTANCE VARIABLES                                 *
	 *********************************************************************************/

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instance date object
	 */
	Date currentDate = new Date();

	/**
	 * donor Doner
	 */
	private Doner donor = new Doner();

	/**
	 * userService UserService
	 */
	@Autowired
	UserService userService = new UserRepositoryImpl();

	/**
	 * sessionFactory private
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * donerImage File
	 */
	private File donerImage;

	/**
	 * objList List<Object>
	 */
	private List<Object> objList = new ArrayList<>();


	/*-*******************************************************************************
	 *                           GETTER AND SETTER METHODS                           *
	 *********************************************************************************/

	/**
	 * @return donerImage File
	 */
	public File getDonerImage() {
		return donerImage;
	}

	/**
	 * @param donerImage File
	 */
	public void setDonerImage(File donerImage) {
		this.donerImage = donerImage;
	}

	/**
	 * @return donor Donor
	 */
	public Doner getDoner() {
		return donor;
	}

	/**
	 * @param doner Doner
	 */
	public void setDoner(Doner doner) {
		this.donor = doner;
	}

	/**
	 * Display all list
	 * @return List
	 */
	public List<Object> getDonorList() {
		return objList;
	}

	/*-********************************************************************************
	 *******************************ACTION PROCESSING**********************************
	 **********************************************************************************/

	/**
	 * @return String<br>
	 *         METHOD NAME : doDonerAction()<br>
	 *         <h1>Detail information</h1>
	 *         <p>
	 *         if Admin addd or update their photo and some information<br>
	 *         this method will be execute<br>
	 */
	@Action(value = "doDonorAction")
	//			, interceptorRefs = {@InterceptorRef("defaultStack"), @InterceptorRef("tokenSession") }
	//	, results = { @Result(name = "DONER", location = "/priv_doner/insert.jsp") })
	public String doDonerAction(){
		try{

			//load property file to get Message value
			new Validate().loadPropertyFile();

			try{
				byte[] bFile = new byte[(int) donerImage.length()];
				FileInputStream fileInputStream = new FileInputStream(donerImage);

				fileInputStream.read(bFile);
				fileInputStream.close();
				LobCreator lc = Hibernate.getLobCreator(sessionFactory.openSession());
				donor.setDonerImage(lc.createBlob(bFile));
			}catch(Exception e){
				addActionError(e.getMessage());
			}

			donor.setCreateDate(DateFormatter.format(currentDate, Formats.SYSTEM));
			if (donor.getDonateAmount() == null) {

				// Display the error message , if donateAmount is null
				this.addActionError(getText(Validate.prop.getProperty("INVALID")));
			}else if(!Validate.isValidEmailAddress(donor.getEmail())){

				//Display the error message if e-mail is invalid
				this.addActionError(getText(Validate.prop.getProperty("EML0001")));
			}else {

				userService.insert(donor);

				//Display the Register successful message
				this.addActionMessage(getText(Validate.prop.getProperty("REG_SUCC")));
			}
		}catch(Exception e){
			addActionError(e.getMessage());
			e.printStackTrace();
		}finally{

			//to list all donator
			objList = userService.findAll();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "updateAction")
	public String update(){
		try{

			//load property file to get Message value
			new Validate().loadPropertyFile();

			try{
				byte[] bFile = new byte[(int) donerImage.length()];

				FileInputStream fileInputStream = new FileInputStream(donerImage);

				fileInputStream.read(bFile);
				fileInputStream.close();
				LobCreator lc = Hibernate.getLobCreator(sessionFactory.openSession());

				donor.setDonerImage(lc.createBlob(bFile));
			}catch(Exception e){
				addActionError(e.getMessage());
			}
			donor.setUpdateDate(DateFormatter.format(currentDate,Formats.SYSTEM));

			if (donor.getDonateAmount() == null) {

				// Display the error message , if donateAmount is null or String
				this.addActionError(getText(Validate.prop.getProperty("INVALID")));
			}else if(!Validate.isValidEmailAddress(donor.getEmail())){

				//Display the error message if e-mail is invalid
				this.addActionError(getText(Validate.prop.getProperty("EML0001")));
			}else {

				userService.update(donor);

				//Display the Update successful message
				this.addActionMessage(getText(Validate.prop.getProperty("UPD_SUCC")));
				return "INSERT";
			}

		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}finally{

			//to display donator list again
			objList = userService.findAll();
		}
		return "UPDATE";
	}

	/**
	 * get id to modify donator information and return to admin page
	 * @return String
	 */
	@Action(value = "getId"
			, results = { @Result(name = "UPD_PAGE", location = "/priv_doner/update.jsp") })
	public String getId() {
		try{
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			donor = userService.getDonor(Long.parseLong(request.getParameter("id")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "UPD_PAGE";
	}

	/**
	 * Do deletion procession
	 * @return String
	 */
	@Action(value = "deleteAction")
	public String delete() {
		try{

			//load property file to get Message value
			new Validate().loadPropertyFile();

			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			userService.delete(Long.parseLong(request.getParameter("id")));

			//Display the Delete successful message
			this.addActionMessage(getText(Validate.prop.getProperty("DEL_SUCC")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}finally{

			//to display donator list again
			objList = userService.findAll();
		}
		return "INSERT";
	}

	/**
	 * Do search procession
	 * @return String
	 * @throws IOException
	 */
	@Action(value = "searchAction")
	public String search() throws IOException{

		//load property file to get Message value
		new Validate().loadPropertyFile();

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		objList = userService.search(request.getParameter("searchValue"));

		if(objList.size() <= 0){

			//Display the error message if no search result
			this.addActionError(getText(Validate.prop.getProperty("NOT_FUD")));
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "detailPage")
	public String detail() {
		try{
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			donor = userService.getDonor(Long.parseLong(request.getParameter("id")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "DETAIL";
	}

	/**
	 * @return String
	 */
	@Action(value = "donor_Init_Display")
	public String list(){
		objList = userService.findAll();
		return "INSERT";
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
	}
}
