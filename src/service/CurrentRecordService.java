package service;

import java.util.List;

import model.Book;
import model.CurrentRecord;
import model.Reader;
import util.PageBean;

/**
* @author 
* @version ����ʱ�䣺2019��10��6�� ����3:35:28
* 
*/
public interface CurrentRecordService {
	public List<CurrentRecord> getAllCurrentRecords() ;
	public List<CurrentRecord> getAllCurrentRecords(String cond) ;
	public List<CurrentRecord> getCurrentRecordsbyReader(Reader reader);

	public CurrentRecord getCurrentRecordByid(int id);

	public void saveCurrentRecord(CurrentRecord currentRecord);
	public void mergeCurrentRecord(CurrentRecord currentRecord);
	public boolean isOrder(Book book, Reader reader);
	public boolean isOrder(Book book);
	public CurrentRecord getCurrentRecordbyBookbyReader(Book book, Reader reader);
	public CurrentRecord getCurrentRecordbyBook(Book book);
	public void deleteCurrentRecordbyID(int id);

	
}