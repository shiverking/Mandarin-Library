package service;

import java.util.Iterator;
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
	public PageBean<Borrowrecord> getPageBean(Reader reader, Integer pageNum,boolean isreturn) {
		// TODO 分页查询
		int Num = 1;
		if (pageNum != null) {
			Num = pageNum;
		}
		int totalRecords = this.getDao().findTotalNumbyTwoProperty("ReaderID", "isReturn", reader.getReaderID(), isreturn);

		PageBean<Borrowrecord> page = new PageBean<Borrowrecord>(totalRecords, Num,5);
		page.setDataList(this.getDao().getPageByTwoProperty("ReaderID", "isReturn", reader.getReaderID(), isreturn,
				"BorrowingDate desc", page.getStartIndex(), page.getPageSize()));
		return page;
	}

	@Override
	public int getFine(int id) {
		List<Borrowrecord> borrowrecords=this.getDao().getByTwoProperty("ReaderID", "isPayfine", id,false);
		int fine=0;
		for (Iterator iterator = borrowrecords.iterator(); iterator.hasNext();) {
			Borrowrecord borrowrecord = (Borrowrecord) iterator.next();
			fine+=borrowrecord.getFine();
		}
		return fine;
	}

}
