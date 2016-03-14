package com.mchan.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.user.domain.User;

/**
 * @author soe san
 *
 */
@Service("userServices")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServicesImpl implements UserServices{

	/**
	 * userService UserServices
	 */
	@Autowired
	private UserServices userService;

	@Transactional
	public void insert(User user) {
		userService.insert(user);
	}

	@Transactional
	public void update(User user) {
		userService.update(user);
	}

	@Transactional
	public void delete(Long id) {
		userService.delete(id);
	}

	@Transactional
	public List<User> listUser() {
		return userService.listUser();
	}

	@Transactional
	public User getUserById(Long userId) {
		return userService.getUserById(userId);
	}

	@Transactional
	public List<User> search(String searchValue) {
		return userService.search(searchValue);
	}
}
