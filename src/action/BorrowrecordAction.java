package action;

import java.util.ArrayList;
import java.util.List;

import model.Borrowrecord;

import service.BorrowrecordService;

/**
* @author 
* @version ����ʱ�䣺2019��9��24�� ����2:12:54
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
