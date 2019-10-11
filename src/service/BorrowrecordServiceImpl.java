package service;

import java.util.Iterator;
import java.util.List;

import model.Borrowrecord;
import model.Reader;
import util.PageBean;

/**
 * @author
 * @version ����ʱ�䣺2019��9��24�� ����2:16:23
 * 
 */
public class BorrowrecordServiceImpl extends BaseService<Borrowrecord> implements BorrowrecordService {

	public List<Borrowrecord> getAllBorrowrecords() {
		// TODO Auto-generated method stub

		return this.getDao().findAll();
	}

	public List<Borrowrecord> getAllBorrowrecords(String cond) {
		// TODO Auto-generated method stub
		return this.getDao().findAll(cond);
	}

	public List<Borrowrecord> getBorrowrecordsbyReader(Reader reader) {
		// TODO Auto-generated method stub
		return this.getDao().findBy("ReaderID", reader.getReaderID(), "BorrowingDate desc");
	}

	public Borrowrecord getBorrowrecordByid(int id) {
		// TODO Auto-generated method stub
		return this.getDao().get(id);
	}

	public void saveBorrowrecord(Borrowrecord borrowrecord) {
		this.getDao().save(borrowrecord);
		// TODO Auto-generated method stub

	}

	public void mergeBorrowrecord(Borrowrecord borrowrecord) {
		// TODO Auto-generated method stub
		this.getDao().merge(borrowrecord);
	}

	public PageBean<Borrowrecord> findPageBean(Reader reader, Integer pageNum) {
		// TODO ��ҳ��ѯ
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
