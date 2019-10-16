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
 * @version ï¿½ï¿½ï¿½ï¿½Ê±ï¿½ä£º2019ï¿½ï¿½9ï¿½ï¿½24ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½2:12:54
 * 
 */
public class BorrowrecordAction extends BaseAction<Borrowrecord, BorrowrecordService> {
	private List<Borrowrecord> borrowrecords;// ï¿½ï¿½ï¿½Ü±ï¿½É¾ï¿½ï¿½
	private Reader tempReader;
	private List<Book> books;// ï¿½ï¿½ï¿½Ü±ï¿½É¾ï¿½ï¿½
	private Integer pageNum;
	private PageBean<Borrowrecord> borrowPage;
	private Integer totalFine;
	private List<Reader> readers;
	private String errorMessage;

	public String getReaderFine() {
		totalFine = this.getService().getFine(tempReader.getReaderID());// TODO:Ôö¼ÓÁË¿ªÏú£¬ºóÆÚ¿ÉÄÜÐÞ¸ÄËã·¨
		return SUCCESS;
	}
	public String borrowBook() {

		if(this.readers == null){
			this.setErrorMessage("ReaderNotFoundError: method(BorrowrecordAction.borrowBook) this.reader is null");
			System.out.println(this.getErrorMessage());
		}else if(this.books == null){
			this.setErrorMessage("BookNotFoundError: method(BorrowrecordAction.borrowBook) this.Book is null");
			System.out.println(this.getErrorMessage());
		}else{
			borrowrecords = this.getService().borrowBook(readers, books);
		}
		return SUCCESS;
		
	}
	public String setReturnBorrowrecordbyBook(){
		if(this.books.get(0)!=null){
			System.out.println(this.books.get(0).getBookID());
			borrowrecords = this.getService().setReturnBorrowrecordByBook(this.books.get(0).getBookID());
			if(borrowrecords!=null){
				return SUCCESS;
			}else{
				this.setErrorMessage("BorrowrecordNotFoundError: Can't Find the Borrowrecord");
				System.out.println(this.getErrorMessage());
				return ERROR;
			}
		}else{
			this.setErrorMessage("BorrowrecordNotFoundError: Can't Find the book");
			System.out.println(this.getErrorMessage());
			return ERROR;
		}		
	}

	public String getBorrowrecordByReaders() {

		borrowrecords = this.getService().getBorrowrecordsbyReaders(readers);
		return SUCCESS;
	}

	public String getAllBorrowrecord() {

		this.borrowrecords = this.getService().getAllBorrowrecords();
		return SUCCESS;
	}

	public String getBorrowrecordByReaderId() {
		borrowrecords = this.getService().getBorrowrecordsbyReaderId(this.getModel().getReaderID());
		return SUCCESS;
	}

	public String getReaderFine() {
		totalFine = this.getService().getFine(tempReader.getReaderID());// TODO:ï¿½ï¿½ï¿½ï¿½ï¿½Ë¿ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ú¿ï¿½ï¿½ï¿½ï¿½Þ¸ï¿½ï¿½ã·¨
		return SUCCESS;
	}

	public String getBorrowPageByReader() {
		// TODO:ï¿½ï¿½Ò³ï¿½ï¿½Ñ¯
		this.setErrorMessage(null);
		borrowPage = this.getService().findPageBean(tempReader, pageNum);
		this.borrowrecords = borrowPage.getDataList();
		if (totalFine == null)
			return "getfine";
		if(this.getErrorMessage()==null){
			return SUCCESS;
		}else{
			System.out.println(this.getErrorMessage());
			return ERROR;
		}
	}
	
	public String findReaderCanBorrow(){
		if(this.getService().findReaderCanBorrow(this.readers.get(0))){
			return SUCCESS;
		}else{
			this.setErrorMessage("ReaderCan'tBorrowError: This Reader has already Borrow 3 books! Reader id:" + this.readers.get(0).getReaderID());
			return ERROR;
		}
	}
	
	public String showError(){
		return SUCCESS;
	}
	public String getBorrowPageByReader() {
		// TODO:·ÖÒ³²éÑ¯
		borrowPage = this.getService().findPageBean(tempReader, pageNum, false);
		if (totalFine == null)
			return "getfine";
		return SUCCESS;
	}

	public String getReturnPageByReader() {
		// TODO:·ÖÒ³²éÑ¯
		borrowPage = this.getService().findPageBean(tempReader, pageNum, true);
		if (totalFine == null)
			return "getfine";
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
	public List<Reader> getReaders() {
		return readers;
	}

	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}
	
	public void setErrorMessager(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessager() {
		return errorMessage;
	}
}
