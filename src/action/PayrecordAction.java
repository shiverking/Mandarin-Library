package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import model.*;
import service.DeleterecordService;
import service.PayrecordService;
import util.PageBean;

/**
 * @author
 * @version 
 * 
 */
public class PayrecordAction extends BaseAction<Payrecord, PayrecordService> {

	private Reader tempReader;
	private Payrecord payrecord;
	private List<Payrecord> payrecords;// 可能被删除
	private Integer pageNum;
	private int readerNum;
	private Integer totalFine;
	
	public String addPayrecord() throws Exception {
		int payrecordID = this.getModel().getPayrecordID();
		Date date = new Date();
		String type = "Deposit";//保证金
		System.out.print("*************"+readerNum);
		int num1 = this.readerNum;
		int amount = num1*300;
		this.getModel().setPayrecordID(payrecordID);
		this.getModel().setDate(date);
		this.getModel().setType(type);
		this.getModel().setAmount(amount);
		this.getService().savePayrecord(this.getModel());
		System.out.print("***********//////////////**********************"+readerNum);
		int payrecordID2 = this.getModel().getPayrecordID();
		Date date2 = new Date();
		String type2 = "Fine";//罚款
		int amount2 = this.totalFine;
		this.getModel().setPayrecordID(payrecordID2);
		this.getModel().setDate(date2);
		this.getModel().setType(type2);
		this.getModel().setAmount(amount2);
		this.getService().savePayrecord(this.getModel());
		System.out.print("******fine*******"+totalFine);
		return SUCCESS;
	}
	public String displayPayrecords() {
		this.payrecords = this.getService().getAll();
		return SUCCESS;
	}
	public List<Payrecord> getPayrecords() {
		return payrecords;
	}
	public void setPayrecords(List<Payrecord> payrecords) {
		this.payrecords = payrecords;
	}
	public Payrecord getPayrecord() {
		return payrecord;
	}
	public void setPayrecord(Payrecord payrecord) {
		this.payrecord = payrecord;
	}
	public int getReaderNum() {
		return readerNum;
	}
	public void setReaderNum(int readerNum) {
		this.readerNum = readerNum;
	}
	public int getTotalFine() {
		return totalFine;
	}
	public void setTotalFine(int totalFine) {
		this.totalFine = totalFine;
	}
}
