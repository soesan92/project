package com.mchan.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.staff.domain.Staff;

/**
 * @author soe san
 *
 */

@Service("staffService")
@Transactional(propagation = Propagation.REQUIRED)
public class StaffServiceImpl implements StaffService{

	/**
	 * staffService StaffService
	 */
	@Autowired
	private StaffService staffService;

	@Transactional
	public void insert(Object staff) {
		staffService.insert(staff);

	}

	@Transactional
	public void update(Object staff) {
		staffService.update(staff);

	}

	public void delete(Long id) {
		staffService.delete(id);

	}

	@Transactional
	public List<Staff> listAll() {
		return staffService.listAll();
	}

	@Transactional
	public List<Staff> search(String searchValue) {
		return staffService.search(searchValue);
	}

	@Transactional
	public Staff getById(Long id) {
		return staffService.getById(id);
	}
}
