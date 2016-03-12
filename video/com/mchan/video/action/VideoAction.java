package com.mchan.video.action;

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

import com.mchan.util.DateFormatter;
import com.mchan.util.Formats;
import com.mchan.util.Validate;
import com.mchan.video.domain.Video;
import com.mchan.video.repository.VideoRepository;
import com.mchan.video.service.VideoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author soe san
 *
 */
@Results({	@Result(name = "INSERT", location = "/priv_video/insert.jsp"),
	@Result(name = "UPDATE", location = "/priv_video/update.jsp")
})
public class VideoAction extends ActionSupport implements ServletRequestAware{

	/*-*******************************************************************************
	 *                            INSTANCE VARIABLES                                 *
	 *********************************************************************************/

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7716715629350280742L;

	/**
	 * session SessionFactory
	 */
	@Autowired
	SessionFactory session;

	/**
	 * videoService VideoService
	 */
	@Autowired
	VideoService videoService = new VideoRepository();

	/**
	 * Instance date object
	 */
	Date currentDate = new Date();

	/**
	 * Create book's instance object
	 */
	Video video = new Video();

	/**
	 * video List<Video>
	 */
	List<Video> videoList = new ArrayList<>();

	/*-*******************************************************************************
	 *                           GETTER AND SETTER METHODS                           *
	 *********************************************************************************/

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public List<Video> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<Video> videoList) {
		this.videoList = videoList;
	}

	/*-*******************************************************************************
	 *******************************ACTION PROCESSING*********************************
	 *********************************************************************************/

	/**
	 * @return String
	 */
	@Action(value = "saveVideoAction")
	public String insert() {
		try {

			//load property file to get Message value
			new Validate().loadPropertyFile();

			video.setCreateDate(DateFormatter.format(currentDate, Formats.DD_MMM_YYYY_HH_MM_ss_a));
			videoService.insert(video);

			//Display the Register successful message
			this.addActionMessage(getText(Validate.prop.getProperty("REG_SUCC")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}finally{

			// to list all video
			videoList = videoService.listAll();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "updVideoAction")
	public String update(){
		try{

			//load property file to get Message value
			new Validate().loadPropertyFile();

			video.setUpdateDate(DateFormatter.format(currentDate, Formats.DD_MMM_YYYY_HH_MM_ss_a));
			videoService.update(video);

			//Display the Update successful message
			this.addActionMessage(getText(Validate.prop.getProperty("UPD_SUCC")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}finally{

			// to list all video
			videoList = videoService.listAll();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "delVideoAction")
	public String delete(){
		try{

			//load property file to get Message value
			new Validate().loadPropertyFile();

			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			videoService.delete(Long.parseLong(request.getParameter("id")));

			//Display the Delete successful message
			this.addActionMessage(getText(Validate.prop.getProperty("DEL_SUCC")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}finally{

			// to list all Book
			videoList = videoService.listAll();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 * @throws IOException
	 */
	@Action(value = "searchVideo")
	public String search() throws IOException{

		//load property file to get Message value
		new Validate().loadPropertyFile();

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		videoList = videoService.search(request.getParameter("searchValue"));

		if(videoList.size() <= 0){

			//Display the error message if no search result
			this.addActionError(getText(Validate.prop.getProperty("NOT_FUD")));
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "getVideoId")
	public String getModifyId(){
		try{
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			video = videoService.getById(Long.parseLong(request.getParameter("id")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "UPDATE";
	}

	/**
	 * @return String
	 */
	@Action(value = "video_Init_Display")
	public String list(){
		videoList = videoService.listAll();
		return "INSERT";
	}
}
