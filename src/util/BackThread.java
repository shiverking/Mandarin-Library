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
import service.BookService;

/**
 * @author
 * @version ����ʱ�䣺2019��10��3�� ����7:31:29
 * 
 */
public class BackThread extends Thread {
	Date todayDate;

	private static SessionFactory factory;
	private static Date Update;
	private static boolean flag = false;
	private static int counter;

	public void run() {
		
		int a;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {

			throw new ExceptionInInitializerError(e);
		}

		while (!this.isInterrupted()) {
			todayDate = new Date();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Counter: " + counter);
			if (Update == null) {
				counter = 0;
				Update = todayDate;
				flag = true;
			}else{
				long u = todayDate.getTime()-Update.getTime();
				long day = u / (24 * 60 * 60 * 1000);
				long hour = (u / (60 * 60 * 1000) - day * 24);
				long min = ((u / (60 * 1000)) - day * 24 * 60 - hour * 60);
				long s = (u / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
				if(day >= 1){
					flag = true;
				}
			}
			if (flag) {
				counter++;
				Update = todayDate;
				flag = false;
				BorrowrecordDao borrowrecordDao = new BorrowrecordDao();
				BookDao bookDao = new BookDao();
				bookDao.setSessionFactory(factory);
				borrowrecordDao.setSessionFactory(factory);
				List<Borrowrecord> borrowrecords = borrowrecordDao.findAll();

				Date now = new Date();
				/**
				 * @author
				 * @description ͨ���̶߳Է������ʵʱ����
				 * 
				 */
				for (int i = 0; i < borrowrecords.size(); i++) {
					Date ReturnDate = borrowrecords.get(i).getReturnDate();
					Date BorrowingDate = borrowrecords.get(i).getBorrowingDate();
					/**
					 * @author
					 * @description ��δ�黹ʱ��ʱ���ļ���
					 * 
					 */
					long l1 = now.getTime() - BorrowingDate.getTime();
					long day1 = l1 / (24 * 60 * 60 * 1000);
					long hour1 = (l1 / (60 * 60 * 1000) - day1 * 24);
					long min1 = ((l1 / (60 * 1000)) - day1 * 24 * 60 - hour1 * 60);
					long s1 = (11 / 1000 - day1 * 24 * 60 * 60 - hour1 * 60 * 60 - min1 * 60);
					/**
					 * @author
					 * @description ��黹ʱ��ʱ���ļ���
					 * 
					 */
					long l2 = ReturnDate.getTime() - BorrowingDate.getTime();
					long day2 = l2 / (24 * 60 * 60 * 1000);
					long hour2 = (l2 / (60 * 60 * 1000) - day2 * 24);
					long min2 = ((l2 / (60 * 1000)) - day2 * 24 * 60 - hour2 * 60);
					long s2 = (1 / 1000 - day2 * 24 * 60 * 60 - hour2 * 60 * 60 - min2 * 60);
					boolean isReturn = borrowrecords.get(i).getIsReturn();
					int Fine = borrowrecords.get(i).getFine();
					int bookID = borrowrecords.get(i).getBookID();
					int FineValue = (bookDao.get(bookID)).getFineValue();
					long RunTime = day1 - day2;// RunTimeΪ���δ�黹�鼮��ʱ����
					System.out.println("bookID: " + bookID);
					System.out.println("FineValue: " + FineValue);
					if (isReturn == false) {
						if (RunTime > 0) {
							Fine = (int) (RunTime * FineValue);
							borrowrecords.get(i).setFine(Fine);
							borrowrecordDao.merge(borrowrecords.get(i));
						}
					} else {
						//else��֧��Ϊborrowrecord�����ѻ��鼮�ķ���ֵ����Ϊ����󷣽𲻻�ı䣬�ù��ܷ��뻹�������
						//Fine = (int) (day2 * FineValue);
						//borrowrecords.get(i).setFine(Fine);
						//borrowrecordDao.merge(borrowrecords.get(i));
					}
				}
			}
		}
	}
}
