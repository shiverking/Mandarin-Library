package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Book;
import model.CurrentRecord;
import model.Reader;
import service.CurrentRecordService;
import util.PageBean;

/**
 * @author
 * @version ï¿½ï¿½ï¿½ï¿½Ê±ï¿½ä£º2019ï¿½ï¿½10ï¿½ï¿½6ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½3:37:56
 * 
 */
public class CurrentRecordAction extends BaseAction<CurrentRecord, CurrentRecordService> {
	private Reader tempReader;// ¼ÇÂ¼µ±Ç°¶ÁÕßµÄÐÅÏ¢
	private List<CurrentRecord> currentRecords;// ¼ÇÂ¼ÔÚ½èÊé¼®ºÍÔ¤Ô¼Êé¼®µÄÐÅÏ¢
	private CurrentRecord currentRecord;
	private Book book;
	private PageBean<Book> bookPage;
	private List<Boolean> reservation;

	// ï¿½ï¿½ï¿½ï¿½ï¿½Ç¾ï¿½ï¿½ï¿½Ê¹ï¿½ÃµÄ¹ï¿½ï¿½Üºï¿½ï¿½ï¿½

	// È¡ï¿½Ã¶ï¿½ï¿½ßµï¿½Ç°ï¿½ï¿½ï¿½Äµï¿½ï¿½é¼®ï¿½ï¿½Ô¤Ô¼ï¿½ï¿½ï¿½é¼®ï¿½ï¿½Â¼
	public String getCurrentRecord() {
		currentRecords = this.getService().getCurrentRecordsbyReader(tempReader);
		return SUCCESS;
	}

	public String addRecord() throws Exception {
		this.currentRecord = new CurrentRecord();
		System.out.println(tempReader.getReaderID());
		currentRecord.setReaderID(this.getTempReader().getReaderID());
		currentRecord.setBookID(this.getBook().getBookID());
		currentRecord.setBorrowingDate(this.getModel().getBorrowingDate());
		this.getService().saveCurrentRecord(currentRecord);
		return SUCCESS;
	}

	public String isReservation() {
		reservation = new ArrayList<Boolean>();
		for (int i = 0; i < bookPage.getDataList().size(); i++) {
			if (this.getService().getCurrentRecordByBook(bookPage.getDataList().get(i)).isEmpty()) {
				reservation.add(false);
			} else {
				reservation.add(true);
			}
		}
		
		return SUCCESS;
	}

//ÍùÏÂÊÇ¸÷ÖÖÊôÐÔµÄgetºÍset·½·¨
	public Reader getTempReader() {
		return tempReader;
	}

	public String findBookIsOrder() {
		CurrentRecord currentRecord1 = null, currentRecord2 = null, currentRecord3 = null;
		if (this.getService().isOrder(this.books.get(0), this.readers.get(0))) {
			System.out.println("this book1 is ordered by this reader");
			currentRecord1 = this.getService().getCurrentRecordbyBookbyReader(this.books.get(0), this.readers.get(0));
		} else if (this.getService().isOrder(this.books.get(0))) {
			System.out.println("this book is ordered by other reader");
			this.errorMessage = "BookCannotBorrowedError:this Book has been Ordered--Book id:"
					+ this.books.get(0).getBookID();
			System.out.println(this.errorMessage);
			return ERROR;
		}
		if (this.books.size()>=2&&this.books.get(1) != null) {
			System.out.println("this book2 is not null");
			if (this.getService().isOrder(this.books.get(1), this.readers.get(0))) {
				System.out.println("this book2 is ordered by this reader");
				currentRecord2 = this.getService().getCurrentRecordbyBookbyReader(this.books.get(1),
						this.readers.get(0));
			}else if (this.getService().isOrder(this.books.get(1))) {
				System.out.println("this book2 is ordered by other reader");
				this.errorMessage = "BookCannotBorrowedError:this Book has been Ordered--Book id2:"
						+ this.books.get(1).getBookID();
				System.out.println(this.errorMessage);
				return ERROR;
			}
		}
		if (this.books.size()>=3&&this.books.get(2) != null) {
			System.out.println("this book3 is not null");
			if (this.getService().isOrder(this.books.get(2), this.readers.get(0))) {
				System.out.println("this book3 is ordered by this reader");
				currentRecord3 = this.getService().getCurrentRecordbyBookbyReader(this.books.get(2),
						this.readers.get(0));
			}else if (this.getService().isOrder(this.books.get(2))) {
				System.out.println("this book3 is ordered by other reader");
				this.errorMessage = "BookCannotBorrowedError:this Book has been Ordered--Book id3:"
						+ this.books.get(2).getBookID();
				System.out.println(this.errorMessage);
				return ERROR;
			}
		}
		if(currentRecord1!=null)
			this.getService().deleteCurrentRecordbyID(currentRecord1.getCurrentRecordID());
		if(currentRecord2!=null)
			this.getService().deleteCurrentRecordbyID(currentRecord2.getCurrentRecordID());
		if(currentRecord3!=null)
			this.getService().deleteCurrentRecordbyID(currentRecord3.getCurrentRecordID());
		System.out.println("this book is not ordered by any reader");
		return SUCCESS;

	}

	public void setTempReader(Reader tempReader) {
		this.tempReader = tempReader;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<CurrentRecord> getCurrentRecords() {
		return currentRecords;
	}

	public void setCurrentRecords(List<CurrentRecord> currentRecords) {
		this.currentRecords = currentRecords;
	}

	public List<Reader> getReaders() {
		return readers;
	}

	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	/**
	 * @param currentRecord the currentRecord to set
	 */
	public void setCurrentRecord(CurrentRecord currentRecord) {
		this.currentRecord = currentRecord;
	}

	public PageBean<Book> getBookPage() {
		return bookPage;
	}

	public void setBookPage(PageBean<Book> bookPage) {
		this.bookPage = bookPage;
	}

	public List<Boolean> getReservation() {
		return reservation;
	}

	public void setReservation(List<Boolean> reservation) {
		this.reservation = reservation;
	}

}

