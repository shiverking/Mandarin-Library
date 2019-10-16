package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.Book;
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
		List<Borrowrecord> records = this.getDao().findAll();
		return records;
	}

	public List<Borrowrecord> getAllBorrowrecords(String cond) {
		// TODO Auto-generated method stub
		return this.getDao().findAll(cond);
	}

	public List<Borrowrecord> getBorrowrecordsbyReader(Reader reader) {
		// TODO Auto-generated method stub
		return this.getDao().findBy("ReaderID", reader.getReaderID(), "BorrowingDate desc");
	}

	public List<Borrowrecord> getBorrowrecordsbyReaders(List<Reader> readers) {
		// TODO Auto-generated method stub
		List<Borrowrecord> borrowrecords = new ArrayList<Borrowrecord>();
		for (Reader r : readers) {
			borrowrecords.addAll(getBorrowrecordsbyReader(r));
		}
		return borrowrecords;
	}

	public List<Borrowrecord> getBorrowrecordsbyReaderId(int readerId) {
		// TODO Auto-generated method stub
		return this.getDao().findBy("ReaderID", readerId, "BorrowingDate desc");
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
	public PageBean<Borrowrecord> findPageBean(Reader reader, Integer pageNum,Boolean isReturn) {
		// TODO ��ҳ��ѯ
		int Num = 1;
		if (pageNum != null) {
			Num = pageNum;
		}
		int totalRecords = this.getDao().findTotalNumbyTwoProperty("ReaderID", "isReturn", reader.getReaderID(), isReturn);

		PageBean<Borrowrecord> page = new PageBean<Borrowrecord>(totalRecords, Num);
		page.setDataList(this.getDao().findPageByTwoProperty("ReaderID", "isReturn", reader.getReaderID(), isReturn,
				"BorrowingDate desc", page.getStartIndex(), page.getPageSize()));
		return page;
	}

	public int getFine(int id) {
		List<Borrowrecord> borrowrecords = this.getDao().getByTwoProperty("ReaderID", "isPayfine", id, false);
		int fine = 0;
		for (Iterator iterator = borrowrecords.iterator(); iterator.hasNext();) {
			Borrowrecord borrowrecord = (Borrowrecord) iterator.next();
			fine += borrowrecord.getFine();
		}
		return fine;
	}

	public List<Borrowrecord> borrowBook(List<Reader> readers, List<Book> books) {
		// 初始化参�?
		Reader reader = readers.get(0);
		Book book = books.get(0);
		long returnPeriod = book.getReturnPeriod();
		long currentTime = System.currentTimeMillis();
		Date date = new Date();
		System.out.println(returnPeriod * 24 * 60 * 60 * 1000);
		Date returnDate = new Date(currentTime + returnPeriod * 24 * 60 * 60 * 1000);
		// 对borrowrecord数据操作
		Borrowrecord borrowrecord = new Borrowrecord();
		borrowrecord.setBookID(book.getBookID());
		borrowrecord.setReaderID(reader.getReaderID());
		borrowrecord.setFine(0);
		borrowrecord.setIsPayfine(false);
		borrowrecord.setBorrowingDate(date);
		borrowrecord.setReturnDate(returnDate);
		borrowrecord.setIsReturn(false);
		this.getDao().save(borrowrecord);
		List<Borrowrecord> borrowrecords = new ArrayList<Borrowrecord>();
		borrowrecords.add(borrowrecord);
		return borrowrecords;
	}

	public List<Borrowrecord> setReturnBorrowrecordByBook(int id) {
		// Warning this method only use to return a book!
		// If you want to find BorrowRecord By BookID please use another method
		if (!this.getDao().findBy("BookID", id, "BorrowingDate desc").isEmpty()) {
			Borrowrecord borrowrecord = new Borrowrecord();
			System.out.println("BookID is :"+id);
			List<Borrowrecord> borrowrecords = this.getDao().findBy("BookID", id, "BorrowingDate desc");
			for (Iterator<Borrowrecord> iterator = borrowrecords.iterator(); iterator.hasNext();) {
				borrowrecord = (Borrowrecord) iterator.next();
				//if (!iterator.hasNext()) {
					if (!borrowrecord.getIsReturn()) {
						System.out.println("BookID isReturn :"+!borrowrecord.getIsReturn());
						borrowrecord.setIsReturn(true);
						Date returnDate = new Date();
						borrowrecord.setReturnDate(returnDate);
						borrowrecord.setIsPayfine(true);
						this.getDao().merge(borrowrecord);
					//} else {
					//	return null;
					//}
				}
			}
			borrowrecords = new ArrayList<Borrowrecord>();
			borrowrecords.add(borrowrecord);
			return borrowrecords;
		} else {
			return null;
		}

	}

	public boolean findReaderCanBorrow(Reader reader) {
		Borrowrecord borrowrecord = new Borrowrecord();
		System.out.println("findReaderCanBorrow");
		int id = reader.getReaderID();
		System.out.println(id);
		List<Borrowrecord> borrowrecords = this.getDao().getByTwoProperty("ReaderID", "isReturn", id, false);
		if (!borrowrecords.isEmpty()) {
			System.out.println("borrowrecords isNotEmpty");
			int counter = 0;
			for (Iterator<Borrowrecord> iterator = borrowrecords.iterator(); iterator.hasNext();) {
				borrowrecord = (Borrowrecord) iterator.next();
				System.out.println("counter:"+counter);
				counter++;
			}
			if(counter < 3){
				return true;
			}else{
				System.out.println("UserBorrow 3 books");
				return false;
			}	
		} else {
			System.out.println("BorrowRecord is empty");
			return true;
		}
	}

}
