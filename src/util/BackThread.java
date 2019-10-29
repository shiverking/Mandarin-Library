package util;

import java.util.Date;
import java.util.List;
import java.util.Timer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.BorrowrecordDao;
import dao.CurrentRecordDao;
import dao.ReaderDao;
import model.Borrowrecord;
import model.CurrentRecord;
import model.Reader;
import dao.BookDao;
import model.Book;

/**
 * @author
 * @version 创建时间：2019年10月3日 下午7:31:29
 * 
 */

public class BackThread extends Thread {

	private static SessionFactory factory;
	private CurrentRecordDao currentRecordDao;
	private BookDao bookDao;
	private BorrowrecordDao borrowrecordDao;
	private ReaderDao readerDao;
	Date todayDate;

	public void run() {

		try {
			factory = new Configuration().configure().buildSessionFactory();
			currentRecordDao = new CurrentRecordDao();
			bookDao = new BookDao();
			readerDao = new ReaderDao();
			borrowrecordDao = new BorrowrecordDao();
			currentRecordDao.setSessionFactory(factory);
			bookDao.setSessionFactory(factory);
			readerDao.setSessionFactory(factory);
			borrowrecordDao.setSessionFactory(factory);
		} catch (Exception e) {

			throw new ExceptionInInitializerError(e);
		}

		int ei = 0;
		int eh = 0;
		while (!this.isInterrupted()) {
			if (eh == 0 && ei == 0) {
				refrushFine();
				Remind();
			}
			ei++;
			todayDate = new Date();
			try {
				Thread.sleep(60000);
				System.out.println(todayDate.toString() + this.getName());
				autoCancel();
				
			} catch (InterruptedException e) {
				System.err.println("try出问题了");
			}
			if (ei == 60) {
				eh++;
				ei = 0;
			}
			if (eh == 24) {
				eh = 0;
			}

		}
	}

	public void refrushFine() {

		List<Borrowrecord> borrowrecords = borrowrecordDao.findBy("isReturn", false);
		Date now = new Date();
		/**
		 * @author
		 * @description 通过线程对罚金进行实时更新
		 * 
		 */
		for (int i = 0; i < borrowrecords.size(); i++) {
			Date ReturnDate = borrowrecords.get(i).getReturnDate();
			/**
			 * @author
			 * @description 书未归还时对时间差的计算
			 * 
			 */
			long l = now.getTime() - ReturnDate.getTime();
			long day = l / (24 * 60 * 60 * 1000);// 计算逾期天数
			/**
			 * @author
			 * @description 书归还时对时间差的计算
			 * 
			 */
			int Fine = borrowrecords.get(i).getFine();
			int bookID = borrowrecords.get(i).getBookID();
			int FineValue = (bookDao.get(bookID)).getFineValue();

			if (day > 0) {
				Fine = (int) (day * FineValue);
				borrowrecords.get(i).setFine(Fine);
				borrowrecordDao.merge(borrowrecords.get(i));
			}
		}
	}

	public void autoCancel() {

		List<CurrentRecord> currentRecords = currentRecordDao.findAll();

		// 遍历查找
		for (CurrentRecord currentRecord : currentRecords) {
			int bookID = currentRecord.getBookID();
			int currentRecordID = currentRecord.getCurrentRecordID();
			Date borrowingDate = currentRecord.getBorrowingDate();
			Date date = new Date();
			int h = (int) ((date.getTime() - borrowingDate.getTime()) / (3600 * 1000));
			if (h >= 2) {
				List<CurrentRecord> currentRecords2 = currentRecordDao.findBy("CurrentRecordID", currentRecordID);
				for (CurrentRecord c : currentRecords2) {
					currentRecordID = c.getCurrentRecordID();
					bookID = c.getBookID();
				}
				try {
					Book bb = bookDao.get(bookID);
					if (bb != null) {
						bb.setIsBorrowed(false);
						bookDao.merge(bb);
					}
					currentRecordDao.delete(currentRecordID);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void Remind() {

		List<Borrowrecord> borrowrecords = borrowrecordDao.findBy("isReturn", false);

		for (Borrowrecord borrowrecord : borrowrecords) {

			String email = "";
			String readerName = "";
			String bookName = "";

			int readerID = borrowrecord.getReaderID();
			int bookID = borrowrecord.getBookID();

			Date returnDate = borrowrecord.getReturnDate();
			Date date = new Date();

			int days = (int) ((returnDate.getTime() - date.getTime()) / (24 * 3600 * 1000));
			System.out.println(days);

			if (days <= 2) {
				List<Reader> readers = readerDao.findBy("ReaderID", readerID);
				for (Reader reader : readers) {
					email = reader.getEmail();
					readerName = reader.getReaderName();
				}

				List<Book> books = bookDao.findBy("BookID", bookID);
				for (Book book : books) {
					bookName = book.getBookName();
				}

				try {
					Email e = new Email(email);
					e.sendEmail(readerName, bookName);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
