package com.mchan.user.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.user.domain.User;
import com.mchan.user.service.UserServices;

/**
 * @author soe san
 *
 */
@Transactional(propagation = Propagation.MANDATORY, readOnly = false)
@Repository
public class UserServiceRepository implements UserServices{

	/**
	 * session SessionFactory
	 */
	@Autowired
	SessionFactory session;

	@Transactional
	public void insert(User user) {
		try {
			session.getCurrentSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void update(User user) {
		try {
			session.getCurrentSession().update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void delete(Long userId) {
		try {
			session.getCurrentSession().delete(getUserById(userId));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Used to list all user
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> listUser() {
		List<User> user = null;
		try {

			//to list all User
			user = session.getCurrentSession().createQuery("from User").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Transactional
	public User getUserById(Long userId) {
		User user = null;
		try {

			// get user by ID
			user = (User) session.getCurrentSession().get(User.class,userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Transactional
	public List<User> search(String searchValue) {
		// TODO Auto-generated method stub
		return null;
	}
}
