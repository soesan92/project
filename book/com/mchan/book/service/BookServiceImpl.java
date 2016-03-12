package com.mchan.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.book.domain.Book;
/**
 * @author soe san
 *
 */
@Service("bookService")
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService{

	@SuppressWarnings("javadoc")
	@Autowired
	private BookService bookService;

	public void insert(Object obj) {
		bookService.insert(obj);

	}

	public void update(Object obj) {
		bookService.update(obj);

	}

	public void delete(Long id) {
		bookService.delete(id);

	}

	public Book getById(Long id) {
		return bookService.getById(id);
	}

	public List<Book> listAll() {
		return bookService.listAll();
	}

	public List<Book> search(String searchValue) {
		return bookService.search(searchValue);
	}

}
