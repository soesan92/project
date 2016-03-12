package com.mchan.activity.service;

import java.util.List;

import com.mchan.activity.domain.Activity;
import com.mchan.util.MchanService;

/**
 * @author soe san
 *
 */
public interface ActivityService extends MchanService{
	/**
	 * @param id
	 * @return Activity
	 */
	public Activity getById(Long id);

	/**
	 * @return List<Activity>
	 */
	public List<Activity> listAll();

	/**
	 * @param searchValue
	 * @return List<Activity>
	 */
	public List<Activity> search(String searchValue);
}
