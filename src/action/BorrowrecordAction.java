package action;

import java.util.ArrayList;
import java.util.List;

import model.Borrowrecord;

import service.BorrowrecordService;

/**
* @author 
* @version 创建时间：2019年9月24日 上午2:12:54
* 
*/
public class BorrowrecordAction extends BaseAction<Borrowrecord, BorrowrecordService>{
private List<Borrowrecord> borrowrecords=new ArrayList<Borrowrecord>();

public List<Borrowrecord> getBorrowrecords() {
	return borrowrecords;
}

public void setBorrowrecords(List<Borrowrecord> borrowrecords) {
	this.borrowrecords = borrowrecords;
}


}
