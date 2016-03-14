package com.mchan.activity.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.activity.domain.Activity;
import com.mchan.activity.service.ActivityService;

/**
 * @author soe san
 *
 */
@Transactional(propagation = Propagation.MANDATORY, readOnly = false)
@Repository
public class ActivityRepository implements ActivityService{

	/**
	 * to select all Activity
	 */
	public static final String SELECT_ALL_ACTIVITY = "FROM Activity ORDER BY createDate";

	/**
	 * session SessionFactory
	 */
	@Autowired
	SessionFactory session;

	@Transactional
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

	public Activity getById(Long id) {
		Activity activity = null;
		try {

			// get activity's by ID
			activity = (Activity) session.getCurrentSession().get(Activity.class,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activity;
	}

	@SuppressWarnings("unchecked")
	public List<Activity> listAll() {
		List<Activity> objList = null;
		try{

			// list all activity
			objList = session.getCurrentSession().createQuery(SELECT_ALL_ACTIVITY).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objList;
	}

	@SuppressWarnings("unchecked")
	public List<Activity> search(String searchValue) {
		List<Activity> objList = null;
		try{

			//Find Activity by postID or Create Date or creator's name etc...
			objList = session.getCurrentSession().createQuery("FROM Activity WHERE POST_ID LIKE '%"
					+searchValue+"%' OR CREATE_DATE LIKE '%"
					+searchValue+"%' OR UPDATE_DATE LIKE '%"
					+searchValue+"%' OR CREATOR_NAME LIKE '%"
					+searchValue+"%' ORDER BY id").list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objList;
	}

}
