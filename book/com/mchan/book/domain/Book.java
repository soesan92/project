package com.mchan.book.domain;

import java.io.Serializable;

/**
 * @author soe san
 *
 */
public class Book implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2556656929577349824L;

	/**
	 * id Long
	 */
	private Long id;

	/**
	 * bookId String
	 */
	private String bookId;

	/**
	 * bookTitle String
	 */
	private String bookTitle;

	/**
	 * creatorName String
	 */
	private String creatorName;

	/**
	 * description String
	 */
	private String description;

	/**
	 * sellingSite String
	 */
	private String sellingSite;

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
	public Book() {
		super();
	}


	/**
	 * @param id
	 * @param bookId
	 * @param bookTitle
	 * @param creatorName
	 * @param description
	 * @param sellingSite
	 * @param createDate
	 * @param updateDate
	 */
	public Book(Long id, String bookId, String bookTitle, String creatorName,
			String description,String sellingSite, String createDate, String updateDate) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.creatorName = creatorName;
		this.description = description;
		this.sellingSite = sellingSite;
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
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return String
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * @param bookTitle
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
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
	public String getSellingSite() {
		return sellingSite;
	}

	/**
	 * @param sellingSite
	 */
	public void setSellingSite(String sellingSite) {
		this.sellingSite = sellingSite;
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
		return "Book [id=" + id + ", bookId=" + bookId + ", bookTitle="
				+ bookTitle + ", creatorName=" + creatorName + ", description="
				+ description + ", sellingSite=" + sellingSite
				+ ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}

}
