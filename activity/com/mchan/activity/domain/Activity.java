package com.mchan.activity.domain;

import java.io.Serializable;


/**
 * @author soe san
 *
 */
public class Activity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4911578768427148711L;

	/**
	 * id Long
	 */
	private Long id;

	/**
	 * postId String
	 */
	private String postId;

	/**
	 * creatorName String
	 */
	private String creatorName;

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
	 * default Constructor
	 */
	public Activity() {
		super();
	}

	/**
	 * @param id
	 * @param postId
	 * @param creatorName
	 * @param description
	 * @param createDate
	 * @param updateDate
	 */
	public Activity(Long id, String postId, String creatorName,
			String description, String createDate, String updateDate) {
		super();
		this.id = id;
		this.postId = postId;
		this.creatorName = creatorName;
		this.description = description;
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
	public String getPostId() {
		return postId;
	}

	/**
	 * @param postId
	 */
	public void setPostId(String postId) {
		this.postId = postId;
	}

	/**
	 * @return String
	 */
	public String getCreatorName() {
		return creatorName;
	}

	/**
	 * @param creatorName
	 */
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
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

	public String toString() {
		return "Activity [id=" + id + ", postId=" + postId + ", creatorName="
				+ creatorName + ", description=" + description
				+ ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}


}
