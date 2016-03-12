package com.mchan.doner.action;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.mchan.doner.domain.Doner;
import com.mchan.doner.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author soe san
 *
 */
public class ShowImageAction extends ActionSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * userService UserService
	 */
	@Autowired
	private UserService userService;

	/**
	 * itemImage byte[]
	 */
	private static byte[] itemImage;

	/**
	 * get the donator's image and display processing
	 */
	@Action(value = "showImage")
	public void show() {
		// Session session = new
		// Configuration().configure().buildSessionFactory().openSession();
		try {

			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest req = ServletActionContext.getRequest();
			response.reset();
			response.setContentType("multipart/form-data");

			Doner doner = userService.getDonor(new Long(req.getParameter("id")));

			itemImage = doner.getDonerImage().getBytes(1,(int) doner.getDonerImage().length());

			OutputStream out = response.getOutputStream();
			out.write(itemImage);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
