package com.mchan.doner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.doner.domain.Doner;

/**
 * @author soe san
 *
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@SuppressWarnings("javadoc")
	@Autowired
	private UserService userService;

	@Transactional
	public void insert(Doner donor) {
		userService.insert(donor);

	}

	@Transactional
	public void update(Doner donor) {
		userService.update(donor);

	}

	@Transactional
	public void delete(Long donorId) {
		userService.delete(donorId);

	}

	@Transactional
	public Doner getDonor(Long donorId) {
		return userService.getDonor(donorId);
	}

	@Transactional
	public List<Object> findAll() {
		return userService.findAll();
	}

	public List<Object> search(String searchValue) {
		return userService.search(searchValue);
	}

}
