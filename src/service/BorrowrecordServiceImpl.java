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
 * @version 闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归弮鍫曟晸閹存帪绱�2019闁跨喐鏋婚幏锟�9闁跨喐鏋婚幏锟�24闁跨喐鏋婚幏锟� 闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�2:16:23
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

	public PageBean<Borrowrecord> getPageBean(Reader reader, Integer pageNum,boolean isreturn) {
		// TODO 閸掑棝銆夐弻銉嚄
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

	public int getFine(int id) {
		List<Borrowrecord> borrowrecords=this.getDao().getByTwoProperty("ReaderID", "isPayfine", id,false);
		int fine=0;
		for (Iterator iterator = borrowrecords.iterator(); iterator.hasNext();) {
			Borrowrecord borrowrecord = (Borrowrecord) iterator.next();
			fine+=borrowrecord.getFine();
		}
		return fine;
	}

	public List<Borrowrecord> borrowBook(List<Reader> readers, List<Book> books) {
		// 闁告帗绻傞～鎰板礌閺嵮冩闁轰緤鎷�
		Book book;
		long returnPeriod;
		Date returnDate;
		List<Borrowrecord> borrowrecords = new ArrayList<Borrowrecord>();
		Reader reader = readers.get(0);
		long currentTime = System.currentTimeMillis();
		Date date = new Date();
		for (Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
		book = iterator.next();
		returnPeriod = book.getReturnPeriod();
		returnDate = new Date(currentTime + returnPeriod * 24 * 60 * 60 * 1000);
		// 閻庣數顒rrowrecord闁轰胶澧楀畵渚�骞欏鍕▕
		Borrowrecord borrowrecord = new Borrowrecord();
		borrowrecord.setBookID(book.getBookID());
		borrowrecord.setReaderID(reader.getReaderID());
		borrowrecord.setFine(0);
		borrowrecord.setIsPayfine(false);
		borrowrecord.setBorrowingDate(date);
		borrowrecord.setReturnDate(returnDate);
		borrowrecord.setIsReturn(false);
		this.getDao().save(borrowrecord);
		borrowrecords.add(borrowrecord);
		}
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

	public int findCanBorrow(Reader reader) {
		System.out.println("findCanBorrow");
		int id = reader.getReaderID();
		System.out.println(id);
		List<Borrowrecord> borrowrecords = this.getDao().getByTwoProperty("ReaderID", "isReturn", id, false);
		if (!borrowrecords.isEmpty()) {
			System.out.println("borrowrecords isNotEmpty");
			int counter = 0;
			for (Iterator<Borrowrecord> iterator = borrowrecords.iterator(); iterator.hasNext();) {
				iterator.next();
				System.out.println("counter:"+counter);
				counter++;
			}
			if(counter < 3){
				return counter;
			}else{
				System.out.println("UserBorrow 3 books");
				return counter;
			}	
		} else {
			System.out.println("BorrowRecord is empty");
			return 0;
		}
	}

	public boolean checkReader(Reader reader) {
		// TODO Auto-generated method stub
		List<Borrowrecord> borrowrecords=this.getDao().getByTwoProperty("ReaderID", "isPayfine", reader.getReaderID(), false);
		if (borrowrecords!=null&&borrowrecords.size()>0) {//若读者有未付钱的书籍，返回真
		return true;	
		}
		return false;
	}


}

