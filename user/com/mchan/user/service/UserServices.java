package com.mchan.user.service;

import java.util.List;

import com.mchan.user.domain.User;

/**
 * @author soe san
 *
 */
public interface UserServices {
	@SuppressWarnings("javadoc")
	public void insert(User user);

	@SuppressWarnings("javadoc")
	public void update(User user);

	@SuppressWarnings("javadoc")
	public void delete(Long id);

	@SuppressWarnings("javadoc")
	public List<User> listUser();

	@SuppressWarnings("javadoc")
	public User getUserById(Long userId);

	@SuppressWarnings("javadoc")
	public List<User> search(String searchValue);
}
