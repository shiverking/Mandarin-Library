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

/**
 * @author
 * @version 锟斤拷锟斤拷时锟戒：2019锟斤拷10锟斤拷3锟斤拷 锟斤拷锟斤拷7:31:29
 * 
 */

public class BackThread extends Thread {

	private static SessionFactory factory;
	Date todayDate;

	public void run() {
		while (!this.isInterrupted()) {
			todayDate = new Date();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

			}
			System.out.println(todayDate.toString() + this.getName());
		}

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {

			throw new ExceptionInInitializerError(e);
		}

		
		//鏂板缓Dao瀵硅薄
		BorrowrecordDao borrowrecordDao = new BorrowrecordDao();
		ReaderDao readerDao = new ReaderDao();
		BookDao bookDao = new BookDao();

		readerDao.setSessionFactory(factory);
		borrowrecordDao.setSessionFactory(factory);
		bookDao.setSessionFactory(factory);
		
		//鏋勫缓borrowrecord瀹瑰櫒
		List<Borrowrecord> borrowrecords = borrowrecordDao.findAll();
		
		//閬嶅巻瀹瑰櫒锛屽鎵惧皢瑕佸埌鏈熺殑鍊熼槄璁板綍
		for (Borrowrecord borrowrecord : borrowrecords) {
			//澹版槑鐢靛瓙閭欢鍦板潃銆佽鑰呭鍚嶃�佷功鍚嶇瓑鍙橀噺浠ュ畬鍠勭數瀛愰偖浠跺唴瀹�
			String email = "";
			String readerName = "";
			String bookName = "";

			//鑾峰彇readerID鍜宐ookID锛屾潵鍦ㄦ暟鎹簱涓煡璇㈢浉搴斿璞�
			int readerID = borrowrecord.getReaderID();
			int bookID = borrowrecord.getBookID();

			Date returnDate = borrowrecord.getReturnDate();
			Date date = new Date();

			int days = (int) ((returnDate.getTime() - date.getTime()) / (24 * 3600 * 1000));
			System.out.println(days);
			
			//濡傛灉瑙勫畾褰掕繕鏃堕棿涓庡綋鍓嶆椂闂寸浉宸袱澶╁強浠ュ唴锛岃幏寰楄鑰呭拰涔︾睄淇℃伅鍚庯紝鍙戦�佺數瀛愰偖浠�
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
