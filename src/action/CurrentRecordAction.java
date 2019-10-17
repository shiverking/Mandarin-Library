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
 * @version 创建时间：2019年10月6日 下午3:37:56
 * 
 */
public class CurrentRecordAction extends BaseAction<CurrentRecord, CurrentRecordService> {
	private Reader tempReader;// 记录当前读者的信息
	private List<CurrentRecord> currentRecords;// 记录在借书籍和预约书籍的信息
	private CurrentRecord currentRecord;
	private Book book;

//以下是具体使用的功能函数

//取得读者当前借阅的书籍和预约的书籍记录
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
//往下是各种属性的get和set方法
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
