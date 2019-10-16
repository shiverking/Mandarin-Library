package action;

import java.util.List;

import model.Book;
import model.CurrentRecord;
import model.Reader;
import service.CurrentRecordService;

/**
 * @author
 * @version ����ʱ�䣺2019��10��6�� ����3:37:56
 * 
 */
public class CurrentRecordAction extends BaseAction<CurrentRecord, CurrentRecordService> {
	private static CurrentRecord currentRecord;
	private Reader tempReader;// ��¼��ǰ���ߵ���Ϣ

	private List<CurrentRecord> currentRecords;// ��¼�ڽ��鼮��ԤԼ�鼮����Ϣ
	private List<Book> books;
	private List<Reader> readers;

//�����Ǿ���ʹ�õĹ��ܺ���

//ȡ�ö��ߵ�ǰ���ĵ��鼮��ԤԼ���鼮��¼
	public String getCurrentRecord() {
		currentRecords = this.getService().getCurrentRecordsbyReader(tempReader);
		return SUCCESS;
	}

//�����Ǹ������Ե�get��set����
	public Reader getTempReader() {
		return tempReader;
	}

	public String findBookIsOrder(){
		if(this.getService().isOrder(this.books.get(0), this.readers.get(0))) {
			System.out.println("this book is ordered by this reader");
			currentRecord = this.getService().getCurrentRecordbyBookbyReader(this.books.get(0), this.readers.get(0));
			this.getService().deleteCurrentRecordbyID(currentRecord.getCurrentRecordID());
			return SUCCESS;
		}else if(this.getService().isOrder(this.books.get(0))){
			System.out.println("this book is ordered by other reader");
			this.errorMessage="BookCannotBorrowedError:this Book has been Ordered--Book id:" + this.books.get(0).getBookID();
			System.out.println(this.errorMessage);
			return ERROR;
		}
		System.out.println("this book is not ordered by any reader");
		return SUCCESS;
		
	}
	
	public void setTempReader(Reader tempReader) {
		this.tempReader = tempReader;
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
	}
	
	



}
