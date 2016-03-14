package com.mchan.staff.service;

import java.util.List;

import com.mchan.staff.domain.Staff;
import com.mchan.util.MchanService;

/**
 * @author soe san
 *
 */
public interface StaffService extends MchanService{

	/**
	 * @param id
	 * @return Staff
	 */
	public Staff getById(Long id);

	/**
	 * @return List<Staff>
	 */
	public List<Staff> listAll();

	/**
	 * @param searchValue
	 * @return List<Staff>
	 */
	public List<Staff> search(String searchValue);
}
