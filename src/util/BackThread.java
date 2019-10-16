package util;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dao.BookDao;
import dao.CurrentRecordDao;
import model.Book;
import model.CurrentRecord;

/**
 * @author
 * @version 创建时间：2019年10月3日 下午7:31:29
 * 
 */
public class BackThread extends Thread {
	Date todayDate;
	private static SessionFactory factory;

	public void run() {
		while (!this.isInterrupted()) {
			todayDate = new Date();
			try {
				Thread.sleep(1000 * 60);
				autoCancel();
			} catch (InterruptedException e) {
			}
			System.out.println(todayDate.toString() + this.getName());
		}
	}

	public void autoCancel() {
		try {
			Configuration cfg = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties())
					.buildServiceRegistry();

			factory = cfg.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
		// Dao
		CurrentRecordDao currentRecordDao = new CurrentRecordDao();
		BookDao bookDao = new BookDao();

		currentRecordDao.setSessionFactory(factory);
		bookDao.setSessionFactory(factory);

		// 容器
		List<CurrentRecord> currentRecords = currentRecordDao.findAll();

		// 遍历查找
		for (CurrentRecord currentRecord : currentRecords) {
			int bookID = currentRecord.getBookID();
			int currentRecordID = currentRecord.getCurrentRecordID();
			Date borrowingDate = currentRecord.getBorrowingDate();
			Date date = new Date();

			int h = (int) ((date.getTime() - borrowingDate.getTime()) / (2 * 3600 * 1000));

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
}
