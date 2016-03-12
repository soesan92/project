package com.mchan.book.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mchan.book.domain.Book;
import com.mchan.book.repository.BookRepository;
import com.mchan.book.service.BookService;
import com.mchan.util.DateFormatter;
import com.mchan.util.Formats;
import com.mchan.util.Validate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author soe san
 *
 */
@Results({	@Result(name = "INSERT", location = "/priv_book/insert.jsp"),
	@Result(name = "UPDATE", location = "/priv_book/update.jsp")
})
public class BookAction extends ActionSupport implements ServletRequestAware{

	/*-*******************************************************************************
	 *                            INSTANCE VARIABLES                                 *
	 *********************************************************************************/

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4567265692784136627L;

	/**
	 * session SessionFactory
	 */
	@Autowired
	SessionFactory session;

	/**
	 * bookService BookService
	 */
	@Autowired
	BookService bookService = new BookRepository();

	/**
	 * Instance date object
	 */
	Date currentDate = new Date();

	/**
	 * Create book's instance object
	 */
	Book book = new Book();

	/**
	 * book List<Book>
	 */
	List<Book> bookList = new ArrayList<>();

	/*-*******************************************************************************
	 *                           GETTER AND SETTER METHODS                           *
	 *********************************************************************************/

	/**
	 * @return Book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return List<Book>
	 */
	public List<Book> getBookList() {
		return bookList;
	}

	/**
	 * @param bookList
	 */
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	/*-*******************************************************************************
	 *******************************ACTION PROCESSING*********************************
	 *********************************************************************************/

	/**
	 * @return String
	 */
	@Action(value = "saveBookAction")
	public String insert() {
		try {

			//load property file to get Message value
			new Validate().loadPropertyFile();

			book.setCreateDate(DateFormatter.format(currentDate, Formats.DD_MMM_YYYY_HH_MM_ss_a));
			bookService.insert(book);

			//Display the Register successful message
			this.addActionMessage(getText(Validate.prop.getProperty("REG_SUCC")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}finally{

			// to list all book
			bookList = bookService.listAll();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "updBookAction")
	public String update(){
		try{

			//load property file to get Message value
			new Validate().loadPropertyFile();

			book.setUpdateDate(DateFormatter.format(currentDate, Formats.DD_MMM_YYYY_HH_MM_ss_a));
			bookService.update(book);

			//Display the Update successful message
			this.addActionMessage(getText(Validate.prop.getProperty("UPD_SUCC")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}finally{

			// to list all book
			bookList = bookService.listAll();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "delBookAction")
	public String delete(){
		try{

			//load property file to get Message value
			new Validate().loadPropertyFile();

			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			bookService.delete(Long.parseLong(request.getParameter("id")));

			//Display the Delete successful message
			this.addActionMessage(getText(Validate.prop.getProperty("DEL_SUCC")));
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			// to list all Book
			bookList = bookService.listAll();
		}
		return "INSERT";
	}

	/**
	 * @return String
	 * @throws IOException
	 */
	@Action(value = "searchBook")
	public String search() throws IOException{

		//load property file to get Message value
		new Validate().loadPropertyFile();

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		bookList = bookService.search(request.getParameter("searchValue"));

		if(bookList.size() <= 0){

			//Display the error message if no search result
			this.addActionError(getText(Validate.prop.getProperty("NOT_FUD")));
		}
		return "INSERT";
	}

	/**
	 * @return String
	 */
	@Action(value = "getBookId")
	public String getModifyId(){
		try{
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			book = bookService.getById(Long.parseLong(request.getParameter("id")));
		}catch(Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "UPDATE";
	}

	/**
	 * @return String
	 */
	@Action(value = "book_Init_Display")
	public String list(){
		bookList = bookService.listAll();
		return "INSERT";
	}



	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}


}
