package service;

import java.util.List;


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

public Borrowrecord getBorrowrecordByid(int id);

public void saveBorrowrecord(Borrowrecord borrowrecord);
public void mergeBorrowrecord(Borrowrecord borrowrecord);

//TODO:��ҳ��ѯ
public PageBean<Borrowrecord> findPageBean(Reader reader,Integer pageNum);
}
