package com.mchan.video.domain;

import java.io.Serializable;

/**
 * @author soe san
 *
 */
public class Video implements Serializable {
	private Long id;
	private String videoId;
	private String videoTitle;
	private String creatorName;
	private String description;
	private String createDate;
	private String updateDate;

	public Video() {
		super();
	}

	public Video(Long id, String videoId, String videoTitle,
			String creatorName, String description, String createDate,
			String updateDate) {
		super();
		this.id = id;
		this.videoId = videoId;
		this.videoTitle = videoTitle;
		this.creatorName = creatorName;
		this.description = description;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String toString() {
		return "Video [id=" + id + ", videoId=" + videoId + ", videoTitle="
				+ videoTitle + ", creatorName=" + creatorName
				+ ", description=" + description + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}
