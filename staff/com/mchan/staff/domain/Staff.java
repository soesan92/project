package com.mchan.staff.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author apple soe san
 *
 */
public class Staff implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id Long
	 */
	private Long id;

	/**
	 * name String
	 */
	private String name;

	/**
	 * email String
	 */
	private String email;

	/**
	 * phone String
	 */
	private String phone;

	/**
	 * department String
	 */
	private String department;

	/**
	 * role String
	 */
	private String role;

	/**
	 * emtryDate Date
	 */
	private Date entryDate;

	/**
	 * nrc_no String
	 */
	private String nrc_no;

	/**
	 * description String
	 */
	private String description;

	/**
	 * password String
	 */
	private String password;

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
	public Staff() {
		super();
	}

	/**
	 * @param name
	 * @param email
	 * @param phone
	 * @param department
	 * @param role
	 * @param entryDate
	 * @param nrc_no
	 * @param description
	 * @param password
	 * @param createDate
	 * @param updateDate
	 */
	public Staff(String name, String email, String phone, String department,
			String role, Date entryDate, String nrc_no, String description,
			String password, String createDate, String updateDate) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.role = role;
		this.entryDate = entryDate;
		this.nrc_no = nrc_no;
		this.description = description;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	/**
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return String
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return String
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return Date
	 */
	public Date getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return String
	 */
	public String getNrc_no() {
		return nrc_no;
	}

	/**
	 * @param nrc_no
	 */
	public void setNrc_no(String nrc_no) {
		this.nrc_no = nrc_no;
	}

	/**
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return String
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return String
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((entryDate == null) ? 0 : entryDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nrc_no == null) ? 0 : nrc_no.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result
				+ ((updateDate == null) ? 0 : updateDate.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (entryDate == null) {
			if (other.entryDate != null)
				return false;
		} else if (!entryDate.equals(other.entryDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nrc_no == null) {
			if (other.nrc_no != null)
				return false;
		} else if (!nrc_no.equals(other.nrc_no))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		return true;
	}

	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", department=" + department + ", role="
				+ role + ", entryDate=" + entryDate + ", nrc_no=" + nrc_no
				+ ", description=" + description + ", password=" + password
				+ ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}
}
