package com.mchan.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.activity.domain.Activity;

/**
 * @author soe san
 *
 */
@Service("activityService")
@Transactional(propagation = Propagation.REQUIRED)
public class ActivityServiceImpl implements ActivityService{

	@SuppressWarnings("javadoc")
	@Autowired
	private ActivityService activityService;

	public void insert(Object obj) {
		activityService.insert(obj);

	}

	public void update(Object obj) {
		activityService.update(obj);

	}

	public void delete(Long id) {
		activityService.delete(id);

	}

	public Activity getById(Long id) {
		return activityService.getById(id);
	}

	public List<Activity> listAll() {
		return activityService.listAll();
	}

	public List<Activity> search(String searchValue) {
		return activityService.search(searchValue);
	}

}
