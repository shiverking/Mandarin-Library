package service;

import java.util.List;

import model.Book;
import model.CurrentRecord;
import model.Reader;
import util.PageBean;

/**
 * @author
 * @version ����ʱ�䣺2019��10��6�� ����3:37:01
 * 
 */
public class CurrentRecordServiceImpl extends BaseService<CurrentRecord> implements CurrentRecordService {

	public List<CurrentRecord> getAllCurrentRecords() {
		return this.getDao().findAll();

	}

	public List<CurrentRecord> getAllCurrentRecords(String cond) {

		return this.getDao().findAll(cond);
	}

	public List<CurrentRecord> getCurrentRecordsbyReader(Reader reader) {

		return this.getDao().findBy("ReaderID", reader.getReaderID(), "BorrowingDate desc");
	}

	public CurrentRecord getCurrentRecordByid(int id) {

		return this.getDao().get(id);
	}

	public void saveCurrentRecord(CurrentRecord currentRecord) {

		this.getDao().save(currentRecord);
	}

	public void mergeCurrentRecord(CurrentRecord currentRecord) {
		this.getDao().merge(currentRecord);
	}
	

	public boolean isOrder(Book book, Reader reader) {
		if(this.getCurrentRecordbyBookbyReader(book, reader)!=null)
			return true;
		else
			return false;
	}

	public boolean isOrder(Book book) {
		if(this.getCurrentRecordbyBook(book)!=null)
			return true;
		else
			return false;
	}

	public CurrentRecord getCurrentRecordbyBook(Book book) {

		List<CurrentRecord> CurrentRecords = this.getDao().findBy("BookID", book.getBookID());
		if(!CurrentRecords.isEmpty()){
			return CurrentRecords.get(0);
		}else{
			return null;
		}

		
	}

	public CurrentRecord getCurrentRecordbyBookbyReader(Book book, Reader reader) {
		
		List<CurrentRecord> CurrentRecords = this.getDao().getByTwoProperty("BookID", "ReaderID", book.getBookID(), reader.getReaderID());
		if(!CurrentRecords.isEmpty()){
			return CurrentRecords.get(0);
		}else{
			return null;
		}

	}

	public void deleteCurrentRecordbyID(int id) {
		
		this.getDao().deleteByLS(id);
		
	}



	@Override
	public List<CurrentRecord> getCurrentRecordByBook(Book book) {
		// TODO Auto-generated method stub
		return this.getDao().findBy("BookID", book.getBookID());
		
	}

}

