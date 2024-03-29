package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Book;
import model.Borrowrecord;
import model.Reader;
import service.BorrowrecordService;
import util.PageBean;

/**
 * @author
 * @version 创建时间：2019年9月24日 上午2:12:54
 * 
 */
public class BorrowrecordAction extends BaseAction<Borrowrecord, BorrowrecordService> {
	private List<Borrowrecord> borrowrecords;//可能被删除
	private Reader tempReader;
	private List<Book> books;//可能被删除
	private Integer pageNum;
	private PageBean<Borrowrecord> borrowPage;
	private Integer totalFine;

	public String getBorrowrecordByReader() {

		borrowrecords = this.getService().getBorrowrecordsbyReader(tempReader);
		return SUCCESS;
	}

	public String getAllBorrowrecord() {

		this.borrowrecords = this.getService().getAllBorrowrecords();

		return SUCCESS;
	}

	public String getReaderFine() {
		totalFine=this.getService().getFine(tempReader.getReaderID());//TODO:增加了开销，后期可能修改算法
		return SUCCESS;
	}
	public String getBorrowPageByReader() {
		// TODO:分页查询
		borrowPage = this.getService().getPageBean(tempReader, pageNum ,false);
		if(totalFine==null)return "getfine";
		return SUCCESS;
	}
	
	public String getReturnPageByReader() {
		// TODO:分页查询
		borrowPage = this.getService().getPageBean(tempReader, pageNum ,true);
		if(totalFine==null)return "getfine";
		return SUCCESS;
	}

	public PageBean<Borrowrecord> getBorrowPage() {
		return borrowPage;
	}

	public void setBorrowPage(PageBean<Borrowrecord> borrowPage) {
		this.borrowPage = borrowPage;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Borrowrecord> getBorrowrecords() {
		return borrowrecords;
	}

	public void setBorrowrecords(List<Borrowrecord> borrowrecords) {
		this.borrowrecords = borrowrecords;
	}

	public Reader getTempReader() {
		return tempReader;
	}

	public void setTempReader(Reader tempReader) {
		this.tempReader = tempReader;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getTotalFine() {
		return totalFine;
	}

	public void setTotalFine(Integer totalFine) {
		this.totalFine = totalFine;
	}


}
