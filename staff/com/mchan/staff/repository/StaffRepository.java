package com.mchan.staff.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.staff.domain.Staff;
import com.mchan.staff.service.StaffService;

/**
 * @author soe san
 *
 */
@Transactional(propagation = Propagation.MANDATORY, readOnly = false)
@Repository
public class StaffRepository implements StaffService{

	/**
	 * to select all staff form STAFF table
	 */
	public static final String SELECT_ALL_STAFF = "FROM Staff";

	/**
	 * session SessionFactory
	 */
	@Autowired
	SessionFactory session;

	@Transactional
	public void insert(Object staff) {
		try {
			session.getCurrentSession().save(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void update(Object staff) {
		try {
			session.getCurrentSession().update(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void delete(Long id) {
		session.getCurrentSession().delete(getById(id));
	}

	@Transactional
	public Staff getById(Long id) {
		Staff doner = null;
		try {

			// get staff by ID
			doner = (Staff) session.getCurrentSession().get(Staff.class,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doner;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Staff> listAll() {
		List<Staff> objList = null;
		try{

			// list all staff
			objList = session.getCurrentSession().createQuery(SELECT_ALL_STAFF).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objList;
	}

	@SuppressWarnings("unchecked")
	public List<Staff> search(String searchValue) {
		List<Staff> objList = null;
		try{

			//Find donoter by name
			objList = session.getCurrentSession().createQuery("FROM Staff WHERE staff_name LIKE '%"
					+searchValue+"%' OR email LIKE '%"
					+searchValue+"%'OR role LIKE '%"
					+searchValue+"%'OR department LIKE '%"
					+searchValue+"%' ORDER BY name").list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objList;
	}



}
