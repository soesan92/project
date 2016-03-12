package com.mchan.doner.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

/**
 * @author soe san
 *
 */
public class Doner implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id long
	 */
	private long id;

	/**
	 * donerImage Blob
	 */
	private Blob donerImage;

	/**
	 * donateAmount double
	 */
	private BigDecimal donateAmount;

	/**
	 * donerName String
	 */
	private String donerName;

	/**
	 * email String
	 */
	private String email;

	/**
	 * phone String
	 */
	private String phone;

	/**
	 * dob Date
	 */
	private Date dob;

	/**
	 * description String
	 */
	private String description;

	/**
	 * createDate String
	 */
	private String createDate;

	/**
	 * updateDate String
	 */
	private String updateDate;

	/**
	 * Default constructor
	 */
	public Doner() {
		super();
	}

	/**
	 * @param donerImage Blob
	 * @param donateAmount double
	 * @param donerName String
	 * @param email String
	 * @param phone String
	 * @param dob Date
	 * @param description String
	 * @param createDate String
	 * @param updateDate String
	 */
	public Doner(Blob donerImage, BigDecimal donateAmount, String donerName,
			String email, String phone, Date dob, String description,
			String createDate, String updateDate) {
		super();
		this.donerImage = donerImage;
		this.donateAmount = donateAmount;
		this.donerName = donerName;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.description = description;
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
	 * @return donerImage Blob
	 */
	public Blob getDonerImage() {
		return donerImage;
	}

	/**
	 * @param donerImage Blob
	 */
	public void setDonerImage(Blob donerImage) {
		this.donerImage = donerImage;
	}

	/**
	 * @return donateAmount double
	 */
	public BigDecimal getDonateAmount() {
		return donateAmount;
	}

	/**
	 * @param donateAmount double
	 */
	public void setDonateAmount(BigDecimal donateAmount) {
		this.donateAmount = donateAmount;
	}

	/**
	 * @return donerName String
	 */
	public String getDonerName() {
		return donerName;
	}

	/**
	 * @param donerName String
	 */
	public void setDonerName(String donerName) {
		this.donerName = donerName;
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
	 * @return phone String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone String
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return dob Date
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob Date
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return description String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description String
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return String
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
	 * @return String
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

	public String toString() {
		return "Doner [id=" + id + ", donerImage=" + donerImage
				+ ", donateAmount=" + donateAmount + ", donerName=" + donerName
				+ ", email=" + email + ", phone=" + phone + ", dob=" + dob
				+ ", description=" + description + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}


}
