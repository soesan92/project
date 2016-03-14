package com.mchan.doner.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.doner.domain.Doner;
import com.mchan.doner.service.UserService;

/**
 * @author soe san
 *
 */
@Transactional(propagation = Propagation.MANDATORY, readOnly = false)
@Repository
public class UserRepositoryImpl implements UserService {

	/**
	 * to select all donator form DONER table
	 */
	public static final String SELECT_ALL_DONATOR = "FROM Doner ORDER BY donateAmount DESC";

	/**
	 * session SessionFactory
	 */
	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Object> findAll() {
		List<Object> objList = null;
		try{

			// find all donator and display as a list
			objList = session.getCurrentSession().createQuery(SELECT_ALL_DONATOR).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objList;
	}

	@Transactional
	public void insert(Doner doner) {
		session.getCurrentSession().save(doner);
	}


	@Transactional
	public Doner getDonor(Long donorId) {
		Doner doner = null;
		try {

			// get Donator by ID
			doner = (Doner) session.getCurrentSession().get(Doner.class,donorId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doner;
	}

	@Transactional
	public void update(Doner donor) {
		session.getCurrentSession().update(donor);
	}

	@Transactional
	public void delete(Long donorId) {
		session.getCurrentSession().delete(getDonor(donorId));
	}

	@SuppressWarnings("unchecked")
	public List<Object> search(String searchValue) {
		List<Object> objList = null;
		try{

			//if user search by donate amount there will be occur NumberFormatException
			Integer donateAmount = Integer.valueOf(searchValue);
			objList = session.getCurrentSession().createQuery("from Doner WHERE donate_amount="+donateAmount+" ORDER BY donateAmount DESC").list();

		}catch(NumberFormatException e){

			//Find donoter by name
			objList = session.getCurrentSession().createQuery("from Doner WHERE doner_name LIKE '%"+searchValue+"%' OR email LIKE '%"+searchValue+"%' ORDER BY donerName DESC").list();
		}
		return objList;
	}

}
