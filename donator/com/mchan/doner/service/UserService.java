package com.mchan.doner.service;

import java.util.List;

import com.mchan.doner.domain.Doner;

/**
 * @author soe san
 *
 */
public interface UserService {

	@SuppressWarnings("javadoc")
	public void insert(Doner donor);

	@SuppressWarnings("javadoc")
	public void update(Doner donor);

	@SuppressWarnings("javadoc")
	public void delete(Long donorId);

	@SuppressWarnings("javadoc")
	public Doner getDonor(Long donorId);

	@SuppressWarnings("javadoc")
	public List<Object> findAll();

	@SuppressWarnings("javadoc")
	public List<Object> search(String searchValue);

}
