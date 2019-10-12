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
 * @version ����ʱ�䣺2019��10��3�� ����7:31:29
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

		//新建Dao对象
		BorrowrecordDao borrowrecordDao = new BorrowrecordDao();
		ReaderDao readerDao = new ReaderDao();
		BookDao bookDao = new BookDao();

		readerDao.setSessionFactory(factory);
		borrowrecordDao.setSessionFactory(factory);
		bookDao.setSessionFactory(factory);
		
		//构建borrowrecord容器
		List<Borrowrecord> borrowrecords = borrowrecordDao.findAll();
		
		//遍历容器，寻找将要到期的借阅记录
		for (Borrowrecord borrowrecord : borrowrecords) {
			//声明电子邮件地址、读者姓名、书名等变量以完善电子邮件内容
			String email = "";
			String readerName = "";
			String bookName = "";

			//获取readerID和bookID，来在数据库中查询相应对象
			int readerID = borrowrecord.getReaderID();
			int bookID = borrowrecord.getBookID();

			Date returnDate = borrowrecord.getReturnDate();
			Date date = new Date();

			int days = (int) ((returnDate.getTime() - date.getTime()) / (24 * 3600 * 1000));
			System.out.println(days);
			
			//如果规定归还时间与当前时间相差两天及以内，获得读者和书籍信息后，发送电子邮件
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
