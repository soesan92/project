package com.mchan.book.service;

import java.util.List;

import com.mchan.book.domain.Book;
import com.mchan.util.MchanService;

/**
 * @author soe san
 *
 */
public interface BookService extends MchanService{
	/**
	 * @param id
	 * @return Book
	 */
	public Book getById(Long id);

	/**
	 * @return List<Book>
	 */
	public List<Book> listAll();

	/**
	 * @param searchValue
	 * @return List<Book>
	 */
	public List<Book> search(String searchValue);

}
