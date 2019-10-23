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

	// �����Ǿ���ʹ�õĹ��ܺ���

	// ȡ�ö��ߵ�ǰ���ĵ��鼮��ԤԼ���鼮��¼
	public String getCurrentRecord() {
		currentRecords = this.getService().getCurrentRecordsbyReader(tempReader);
		return SUCCESS;
	}

	// �����Ǹ������Ե�get��set����
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

