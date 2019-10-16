package service;

import java.util.List;


import model.CurrentRecord;
import model.Reader;
import util.PageBean;

/**
 * @author
 * @version 创建时间：2019年10月6日 下午3:37:01
 * 
 */
public class CurrentRecordServiceImpl extends BaseService<CurrentRecord> implements CurrentRecordService {

	@Override
	public List<CurrentRecord> getAllCurrentRecords() {
		return this.getDao().findAll();

	}

	@Override
	public List<CurrentRecord> getAllCurrentRecords(String cond) {

		return this.getDao().findAll(cond);
	}

	@Override
	public List<CurrentRecord> getCurrentRecordsbyReader(Reader reader) {

		return this.getDao().findBy("ReaderID", reader.getReaderID(), "BorrowingDate desc");
	}

	@Override
	public CurrentRecord getCurrentRecordByid(int id) {

		return this.getDao().get(id);
	}

	@Override
	public void saveCurrentRecord(CurrentRecord currentRecord) {

		this.getDao().save(currentRecord);
	}

	@Override
	public void mergeCurrentRecord(CurrentRecord currentRecord) {
		this.mergeCurrentRecord(currentRecord);

	}


}
