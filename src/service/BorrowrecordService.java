package service;

import java.util.List;

import model.Book;
import model.Borrowrecord;
import model.Reader;
import util.PageBean;

/**
* @author 
* @version ����ʱ�䣺2019��9��24�� ����2:15:53
* 
*/
public interface BorrowrecordService {
public List<Borrowrecord> getAllBorrowrecords() ;
public List<Borrowrecord> getAllBorrowrecords(String cond) ;
public List<Borrowrecord> getBorrowrecordsbyReader(Reader reader);
public List<Borrowrecord> getBorrowrecordsbyReaderId(int readerId);

public Borrowrecord getBorrowrecordByid(int id);

public void saveBorrowrecord(Borrowrecord borrowrecord);
public void mergeBorrowrecord(Borrowrecord borrowrecord);

//TODO:��ҳ��ѯ
public PageBean<Borrowrecord> findPageBean(Reader reader,Integer pageNum);
//ͨ��id��ȡδ֧���ķ���
public int getFine(int id);
public List<Borrowrecord> getBorrowrecordsbyReaders(List<Reader> readers);
public List<Borrowrecord> borrowBook(List<Reader> readers, List<Book> books);
public List<Borrowrecord> setReturnBorrowrecordByBook(int i);
public boolean findReaderCanBorrow(Reader reader);
public int findCanBorrow(Reader reader);
}