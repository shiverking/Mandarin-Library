package service;

import java.util.List;


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

		this.saveCurrentRecord(currentRecord);
	}

	public void mergeCurrentRecord(CurrentRecord currentRecord) {
		this.mergeCurrentRecord(currentRecord);

	}


}
