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

		this.saveCurrentRecord(currentRecord);
	}

	@Override
	public void mergeCurrentRecord(CurrentRecord currentRecord) {
		this.mergeCurrentRecord(currentRecord);

	}

	@Override
	public PageBean<CurrentRecord> findPageBean(Reader reader, Integer pageNum) {
		int Num = 1;
		if (pageNum != null) {
			Num = pageNum;
		}
		int totalRecords = this.getDao().findTotalNum("ReaderID", reader.getReaderID());
		PageBean<CurrentRecord> page = new PageBean<CurrentRecord>(totalRecords, Num);
		page.setDataList(this.getDao().findPageByQuery("ReaderID", reader.getReaderID(), "BorrowingDate desc",
				page.getStartIndex(), page.getPageSize()));
		return page;
	}

}
