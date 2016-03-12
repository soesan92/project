package com.mchan.user.domain;

import java.io.Serializable;

/**
 * @author soe san
 *
 */
public class User implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4779791654857601731L;

	/**
	 * id long
	 */
	private long id;

	/**
	 * userName String
	 */
	private String userName;

	/**
	 * email String
	 */
	private String email;

	/**
	 * password String
	 */
	private String password;

	/**
	 * confPassword String
	 */
	private String confPassword;

	/**
	 * role Short
	 */
	private Short role;

	/**
	 * createDate String
	 */
	private String createDate;

	/**
	 * updateDate String
	 */
	private String updateDate;

	/**
	 * Default Constructor
	 */
	public User() {
		super();
	}

	/**
	 * @param userName String
	 * @param email String
	 * @param password String
	 * @param role int
	 * @param createDate Date
	 * @param updateDate Date
	 */
	public User(String userName, String email, String password, Short role,
			String createDate, String updateDate) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	/**
	 * @return id long
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id long
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return userName String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName String
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return email String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return password String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return confPassword String
	 */
	public String getConfPassword() {
		return confPassword;
	}

	/**
	 * @param confPassword String
	 */
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}

	/**
	 * @return role Short
	 */
	public Short getRole() {
		return role;
	}

	/**
	 * @param role Short
	 */
	public void setRole(Short role) {
		this.role = role;
	}

	/**
	 * @return createDate String
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate String
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return updateDate String
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate String
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}
