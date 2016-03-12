package com.mchan.doner.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.util.SubsetIteratorFilter.Decider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mchan.activity.domain.Activity;
import com.mchan.activity.repository.ActivityRepository;
import com.mchan.activity.service.ActivityService;
import com.mchan.book.domain.Book;
import com.mchan.book.repository.BookRepository;
import com.mchan.book.service.BookService;
import com.mchan.doner.repository.UserRepositoryImpl;
import com.mchan.doner.service.UserService;
import com.mchan.staff.domain.Staff;
import com.mchan.staff.repository.StaffRepository;
import com.mchan.staff.service.StaffService;
import com.mchan.video.domain.Video;
import com.mchan.video.repository.VideoRepository;
import com.mchan.video.service.VideoService;

/**
 * @author soe san
 *
 */
@Results({ @Result(name = "HOME_PAGE", location = "/home.jsp") })
@InterceptorRefs({@InterceptorRef("basicStack") })
@Controller
public class LoadingProjectAction{

	/*-*******************************************************************************
	 *                               OBJECT CREATION                                 *
	 *********************************************************************************/

	/**
	 * userService UserService
	 */
	@Autowired
	UserService userService = new UserRepositoryImpl();

	/**
	 * staffService StaffService
	 */
	@Autowired
	StaffService staffService = new StaffRepository();

	/**
	 * activityService ActivityService
	 */
	@Autowired
	ActivityService activityService = new ActivityRepository();

	/**
	 * videoService VideoService
	 */
	@Autowired
	VideoService videoService = new VideoRepository();

	/**
	 * bookService BookService
	 */
	@Autowired
	BookService bookService = new BookRepository();

	/*-*******************************************************************************
	 *                                 LIST OBJECT                                   *
	 *********************************************************************************/

	/**
	 * objList List<Object>
	 */
	List<Object> objList = new ArrayList<>();

	/**
	 * staff List<Staff>
	 */
	List<Staff> staffList = new ArrayList<>();

	/**
	 * activity List<Activity>
	 */
	List<Activity> activityList = new ArrayList<>();

	/**
	 * video List<Video>
	 */
	List<Video> videoList = new ArrayList<>();

	/**
	 * book List<Book>
	 */
	List<Book> bookList = new ArrayList<>();

	/*-*******************************************************************************
	 *                           GETTER AND SETTER METHODS                           *
	 *********************************************************************************/

	/**
	 * Display all list
	 * @return List
	 */
	public List<Staff> getStaffList() {
		return staffList;
	}

	/**
	 * @return List<Object>
	 */
	public List<Object> getDonorList() {
		return objList;
	}

	/**
	 * @return List<Activity>
	 */
	public List<Activity> getActivityList() {
		return activityList;
	}

	/**
	 * @return List<Video>
	 */
	public List<Video> getVideoList() {
		return videoList;
	}

	/**
	 * @return List<Book>
	 */
	public List<Book> getBookList() {
		return bookList;
	}

	/**
	 *
	 * @return String<br>
	 *         METHOD NAME : populate( ) <h1>Detail information</h1> this method
	 *         act like an initialization...<br>
	 *         if user execute the application this method will be execute
	 *         first.
	 */
	@Action(value = "populate")
	public String populate() {

		objList = userService.findAll();
		staffList = staffService.listAll();


		return "HOME_PAGE";

	}

	@Action(value = "populate")
	public String populate1(){
		populate();
		activityList = activityService.listAll();
		videoList = videoService.listAll();

		bookList = bookService.listAll();
		return "HOME_PAGE";
	}

	/************************************************************************************
	 *                                     Decider                                      *
	 ************************************************************************************/

	@SuppressWarnings("javadoc")
	public Decider getAdvisorsDecider() {
		return new Decider() {
			public boolean decide(Object element) throws Exception {
				Staff staff= (Staff) element;
				return staff.getRole().equals("Advisors");
			}
		};
	}



	@SuppressWarnings("javadoc")
	public Decider getBoardMemberDecider() {
		return new Decider() {
			public boolean decide(Object element) throws Exception {
				Staff staff= (Staff) element;
				return staff.getRole().equals("Board Member");
			}
		};
	}



	@SuppressWarnings("javadoc")
	public Decider getOtherDecider() {
		return new Decider() {
			public boolean decide(Object element) throws Exception {
				Staff staff= (Staff) element;
				return staff.getRole().equals("Other");
			}
		};
	}



	@SuppressWarnings("javadoc")
	public Decider getStaffDecider() {
		return new Decider() {
			public boolean decide(Object element) throws Exception {
				Staff staff= (Staff) element;
				return staff.getRole().equals("Staff");
			}
		};
	}
}
