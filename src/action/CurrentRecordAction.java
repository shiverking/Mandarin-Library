package action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @version ����ʱ�䣺2019��10��6�� ����3:37:56
 * 
 */
public class CurrentRecordAction extends BaseAction<CurrentRecord, CurrentRecordService> {
	private Reader tempReader;// ��¼��ǰ���ߵ���Ϣ
	private List<CurrentRecord> currentRecords;// ��¼�ڽ��鼮��ԤԼ�鼮����Ϣ
	private CurrentRecord currentRecord;
	private Book book;
	private PageBean<Book> bookPage;
	private List<Boolean> reservation;

//�����Ǿ���ʹ�õĹ��ܺ���

//ȡ�ö��ߵ�ǰ���ĵ��鼮��ԤԼ���鼮��¼
	public String getCurrentRecord() {
		currentRecords = this.getService().getCurrentRecordsbyReader(tempReader);
		return SUCCESS;
	}

	public String addRecord() throws Exception {
		this.currentRecord = new CurrentRecord();
		System.out.println(tempReader.getReaderID());
		currentRecord.setReaderID(this.getTempReader().getReaderID());
		currentRecord.setBookID(this.getBook().getBookID());
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

//�����Ǹ������Ե�get��set����
	public Reader getTempReader() {
		return tempReader;
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
