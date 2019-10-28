package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import model.*;
import service.DeleterecordService;
import service.PayrecordService;
import util.PageBean;
import com.opensymphony.xwork2.ActionContext;
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
	private Date readerDate;
	private Date date1;
	private Date date2;
	
	public Date getDate2() {
		return date2;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public Date getReaderDate() {
		return readerDate;
	}
	public void setReaderDate(Date readerDate) {
		this.readerDate = readerDate;
	}
	public String addPayrecord() throws Exception {
		int payrecordID = this.getModel().getPayrecordID();
		String type = "Deposit";//保证金
		int amount = 300;
		this.getModel().setPayrecordID(payrecordID);
		this.getModel().setDate(this.readerDate);
		this.getModel().setType(type);
		this.getModel().setAmount(amount);
		this.getService().savePayrecord(this.getModel());
		return SUCCESS;
	}
	public String  addPayrecordFine() throws Exception {
		int payrecordID2 = this.getModel().getPayrecordID();
		Date date2 = new Date();
		String type2 = "Fine";//罚款
		int amount2 = this.totalFine;
		this.getModel().setPayrecordID(payrecordID2);
		this.getModel().setDate(date2);
		this.getModel().setType(type2);
		this.getModel().setAmount(amount2);
		this.getService().savePayrecord(this.getModel());
		return SUCCESS;
	}
	public String displayPayrecords() {
		int allOfDeposit = 0;
		int allOfFine = 0;
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		String date11 = df.format(this.date1);
		String date22 = df.format(this.date2);
		System.out.print("*****date****"+date11+"***"+date22);
		allOfDeposit = this.getService().getNumOfDeposit(date11,date22);
		allOfFine = this.getService().getSumOfFine(date11,date22);
		String allOfDeposit1 = allOfDeposit+"";
		String allOfFine1 = allOfFine+"";
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("Deposit",allOfDeposit1);
		session.setAttribute("Fine",allOfFine1);
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
