package util;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.BookDao;
import dao.BorrowrecordDao;
import dao.ReaderDao;
import model.Book;
import model.Borrowrecord;
import model.Reader;



public class BackThread extends Thread {

	private static SessionFactory factory;
	Date todayDate;

	public void run() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {

			throw new ExceptionInInitializerError(e);
		}
		int i = 0;
		while (!this.isInterrupted()) {
			i++;
			todayDate=new Date();
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				
			}
			System.out.println(todayDate.toString()+this.getName());
//			if (i == 86400) {
//				email();
//				i = 0;
//			}
		}
		
	}
	
	public void email() {
	
		
		BorrowrecordDao borrowrecordDao = new BorrowrecordDao();
		ReaderDao readerDao = new ReaderDao();
		BookDao bookDao = new BookDao();
	
		readerDao.setSessionFactory(factory);
		borrowrecordDao.setSessionFactory(factory);
		bookDao.setSessionFactory(factory);
	
		
		List<Borrowrecord> borrowrecords = borrowrecordDao.findBy("isReturn",false);
	
		
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
