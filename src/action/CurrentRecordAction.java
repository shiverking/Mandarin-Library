package action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

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
	private Reader tempReader;// ��¼��ǰ���ߵ���Ϣ
	private List<CurrentRecord> currentRecords;// ��¼�ڽ��鼮��ԤԼ�鼮����Ϣ
	private CurrentRecord currentRecord;
	private Book book;

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
		currentRecord.setBorrowingDate(this.getModel().getBorrowingDate());
		this.getService().saveCurrentRecord(currentRecord);
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



}
