package util;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import dao.BookDao;
import dao.CurrentRecordDao;
import model.Book;
import model.CurrentRecord;

/**
 * @author
 * @version ����ʱ�䣺2019��10��3�� ����7:31:29
 * 
 */

import dao.BookDao;
import dao.BorrowrecordDao;
import dao.CurrentRecordDao;
import dao.ReaderDao;
import model.Book;
import model.Borrowrecord;
import model.CurrentRecord;
import model.Reader;

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
				Remind();
			}
			ei++;
			todayDate = new Date();
			try {
				Thread.sleep(60000);
				System.out.println(todayDate.toString() + this.getName());
				autoCancel();
			} catch (InterruptedException e) {
				System.err.println("try��������");
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

	public void autoCancel() {

		List<CurrentRecord> currentRecords = currentRecordDao.findAll();

		// ��������
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
					bb.setIsBorrowed(false);
					bookDao.merge(bb);
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
