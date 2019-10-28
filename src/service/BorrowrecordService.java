package service;

import java.util.List;

import model.Book;
import model.Borrowrecord;
import model.Reader;
import util.PageBean;

/**
* @author 
* @version ï¿½ï¿½ï¿½ï¿½Ê±ï¿½ä£º2019ï¿½ï¿½9ï¿½ï¿½24ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½2:15:53
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

//TODO:·ÖÒ³²éÑ¯
public PageBean<Borrowrecord> getPageBean(Reader reader,Integer pageNum,boolean isreturn);
//Í¨¹ýid»ñÈ¡Î´Ö§¸¶µÄ·£½ð
public int getFine(int id);
public List<Borrowrecord> getBorrowrecordsbyReaders(List<Reader> readers);
public List<Borrowrecord> borrowBook(List<Reader> readers, List<Book> books);
public List<Borrowrecord> setReturnBorrowrecordByBook(int i);
public boolean findReaderCanBorrow(Reader reader);
public int findCanBorrow(Reader reader);
public boolean checkReader(Reader reader) ;;
}