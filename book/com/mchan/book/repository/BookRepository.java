package com.mchan.book.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchan.book.domain.Book;
import com.mchan.book.service.BookService;
/**
 * @author soe san
 *
 */
@Transactional(propagation = Propagation.MANDATORY, readOnly = false)
@Repository
public class BookRepository implements BookService{

	/**
	 * to select all BOOK
	 */
	public static final String SELECT_ALL_BOOK = "FROM Book ORDER BY bookTitle";

	/**
	 * session SessionFactory
	 */
	@Autowired
	SessionFactory session;

	@Transactional
	public void insert(Object obj) {
		try {
			session.getCurrentSession().save(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Object obj) {
		try {
			session.getCurrentSession().update(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Long id) {
		try {
			session.getCurrentSession().delete(getById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Book getById(Long id) {
		Book activity = null;
		try {

			// get book by ID
			activity = (Book) session.getCurrentSession().get(Book.class,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activity;
	}

	@SuppressWarnings("unchecked")
	public List<Book> listAll() {
		List<Book> objList = null;
		try{

			// list all book
			objList = session.getCurrentSession().createQuery(SELECT_ALL_BOOK).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objList;
	}

	@SuppressWarnings("unchecked")
	public List<Book> search(String searchValue) {
		List<Book> objList = null;
		try{

			//Find BOOK by BOOK'S NAME or Create Date etc...
			objList = session.getCurrentSession().createQuery("FROM Book WHERE BOOK_TITLE LIKE '%"
					+searchValue+"%' OR CREATE_DATE LIKE '%"
					+searchValue+"%' OR UPDATE_DATE LIKE '%"
					+searchValue+"%' OR CREATOR_NAME LIKE '%"
					+searchValue+"%' ORDER BY bookTitle").list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objList;
	}
}
