package com.mchan.util;


/**
 * @author soe san
 *
 */
public interface MchanService {

	/**
	 * @param obj
	 */
	public void insert(Object obj);

	/**
	 * @param obj
	 */
	public void update(Object obj);

	/**
	 * @param id
	 */
	public void delete(Long id);
}
