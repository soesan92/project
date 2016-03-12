package com.mchan.video.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.video.domain.Video;
import com.mchan.video.service.VideoService;

/**
 * @author soe san
 *
 */
@Transactional(propagation = Propagation.MANDATORY, readOnly = false)
@Repository
public class VideoRepository implements VideoService{

	/**
	 * to select all video
	 */
	public static final String SELECT_ALL_VIDEO = "FROM Video ORDER BY videoTitle";

	/**
	 * session SessionFactory
	 */
	@Autowired
	SessionFactory session;
	public void insert(Object obj) {
		try {
			session.getCurrentSession().save(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Object obj) {
		try {
			session.getCurrentSession().update(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Long id) {
		try {
			session.getCurrentSession().delete(getById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Video getById(Long id) {
		Video activity = null;
		try {

			// get video by ID
			activity = (Video) session.getCurrentSession().get(Video.class,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activity;
	}

	@SuppressWarnings("unchecked")
	public List<Video> listAll() {
		List<Video> objList = null;
		try{

			// list all book
			objList = session.getCurrentSession().createQuery(SELECT_ALL_VIDEO).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objList;
	}

	@SuppressWarnings("unchecked")
	public List<Video> search(String searchValue) {
		List<Video> objList = null;
		try{

			//Find BOOK by BOOK'S NAME or Create Date etc...
			objList = session.getCurrentSession().createQuery("FROM Video WHERE VIDEO_TITLE LIKE '%"
					+searchValue+"%' OR CREATE_DATE LIKE '%"
					+searchValue+"%' OR UPDATE_DATE LIKE '%"
					+searchValue+"%' OR CREATOR_NAME LIKE '%"
					+searchValue+"%' ORDER BY videoTitle").list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objList;
	}

}
