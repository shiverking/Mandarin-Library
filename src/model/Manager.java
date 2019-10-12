package model;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.persister.*;

import dao.BaseDaoImpl;
import dao.BorrowrecordDao;
import dao.CurrentRecordDao;
import dao.ReaderDao;


/**
 * @author
 * @version ����ʱ�䣺2019��9��22�� ����11:33:14
 * 
 */
public class Manager {
	private static SessionFactory factory;

	public static void main(String[] args) {
		int a;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {

			throw new ExceptionInInitializerError(e);
		}
		Reader reader=new Reader(1,"mmhh","1213","123",12,"123");
		ReaderDao readerDao=new ReaderDao();
		BorrowrecordDao borrowrecordDao = new BorrowrecordDao();
		readerDao.setSessionFactory(factory);
		CurrentRecordDao currentRecordDao=new CurrentRecordDao();
		currentRecordDao.setSessionFactory(factory);
		borrowrecordDao.setSessionFactory(factory);
	
		List<Borrowrecord> borrowrecords = borrowrecordDao.findAll();
List<CurrentRecord> currentRecords=currentRecordDao.findAll();

		borrowrecords.get(0).setBorrowingDate(currentRecords.get(0).getBorrowingDate());
		borrowrecordDao.merge(borrowrecords.get(0));
	}

}
