package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Borrowrecord;
import model.Reader;
import service.BorrowrecordService;

/**
* @author 
* @version 创建时间：2019年9月24日 上午2:12:54
* 
*/
public class BorrowrecordAction extends BaseAction<Borrowrecord, BorrowrecordService>{
private List<Borrowrecord> borrowrecords=new ArrayList<Borrowrecord>();
private Reader tmpReader;

public String getAllBorrowrecord() {
	this.borrowrecords=this.getService().getAllBorrowrecords();
	System.out.println("开始迭代输出");
	for (Iterator iterator = borrowrecords.iterator(); iterator.hasNext();) {
		Borrowrecord borrowrecord =(Borrowrecord)iterator.next();
		System.out.print(borrowrecord.getRecordID()+" ");
		if (borrowrecord.getFine()>0) {
			System.out.print(borrowrecord.getFine());
		}
		System.out.print(borrowrecord.getBorrowingDate()+" ");
		System.out.println(borrowrecord.getReaderID());
	}
	return SUCCESS;
}
public String getBorrowrecordByReader() {
	borrowrecords=this.getService().getBorrowrecordsbyReader(tmpReader);
	return SUCCESS;
}
public void setTmpReader(Reader reader) {
	this.tmpReader=reader;
}
public List<Borrowrecord> getBorrowrecords() {
	return borrowrecords;
}

public void setBorrowrecords(List<Borrowrecord> borrowrecords) {
	this.borrowrecords = borrowrecords;
}


}
