package service;

import java.util.List;


import model.CurrentRecord;
import model.Reader;
import util.PageBean;

/**
* @author 
* @version 创建时间：2019年10月6日 下午3:35:28
* 
*/
public interface CurrentRecordService {
	public List<CurrentRecord> getAllCurrentRecords() ;
	public List<CurrentRecord> getAllCurrentRecords(String cond) ;
	public List<CurrentRecord> getCurrentRecordsbyReader(Reader reader);

	public CurrentRecord getCurrentRecordByid(int id);

	public void saveCurrentRecord(CurrentRecord currentRecord);
	public void mergeCurrentRecord(CurrentRecord currentRecord);

	
}
