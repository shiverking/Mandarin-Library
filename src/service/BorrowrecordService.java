package service;

import java.util.List;


import model.Borrowrecord;
import model.Reader;
import util.PageBean;

/**
* @author 
* @version 创建时间：2019年9月24日 上午2:15:53
* 
*/
public interface BorrowrecordService {
public List<Borrowrecord> getAllBorrowrecords() ;
public List<Borrowrecord> getAllBorrowrecords(String cond) ;
public List<Borrowrecord> getBorrowrecordsbyReader(Reader reader);

public Borrowrecord getBorrowrecordByid(int id);

public void saveBorrowrecord(Borrowrecord borrowrecord);
public void mergeBorrowrecord(Borrowrecord borrowrecord);

//TODO:分页查询
public PageBean<Borrowrecord> getPageBean(Reader reader,Integer pageNum,boolean isreturn);
//通过id获取未支付的罚金
public int getFine(int id);
}
