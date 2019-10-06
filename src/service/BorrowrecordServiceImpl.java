package service;

import java.util.List;

import model.Borrowrecord;
import model.Reader;
import util.PageBean;

/**
 * @author
 * @version 创建时间：2019年9月24日 上午2:16:23
 * 
 */
public class BorrowrecordServiceImpl extends BaseService<Borrowrecord> implements BorrowrecordService {

	@Override
	public List<Borrowrecord> getAllBorrowrecords() {
		// TODO Auto-generated method stub

		return this.getDao().findAll();
	}

	@Override
	public List<Borrowrecord> getAllBorrowrecords(String cond) {
		// TODO Auto-generated method stub
		return this.getDao().findAll(cond);
	}

	@Override
	public List<Borrowrecord> getBorrowrecordsbyReader(Reader reader) {
		// TODO Auto-generated method stub
		return this.getDao().findBy("ReaderID", reader.getReaderID(), "BorrowingDate desc");
	}

	@Override
	public Borrowrecord getBorrowrecordByid(int id) {
		// TODO Auto-generated method stub
		return this.getDao().get(id);
	}

	@Override
	public void saveBorrowrecord(Borrowrecord borrowrecord) {
		this.getDao().save(borrowrecord);
		// TODO Auto-generated method stub

	}

	@Override
	public void mergeBorrowrecord(Borrowrecord borrowrecord) {
		// TODO Auto-generated method stub
		this.getDao().merge(borrowrecord);
	}

	@Override
	public PageBean<Borrowrecord> findPageBean(Reader reader, Integer pageNum) {
		// TODO 分页查询
		int Num = 1;
		if (pageNum != null) {
			Num = pageNum;
		}
		int totalRecords = this.getDao().findTotalNum("ReaderID", reader.getReaderID());

		PageBean<Borrowrecord> page = new PageBean<Borrowrecord>(totalRecords, Num);
		page.setDataList(this.getDao().findPageByQuery("ReaderID", reader.getReaderID(), "BorrowingDate desc",
				page.getStartIndex(), page.getPageSize()));
		return page;
	}

}
