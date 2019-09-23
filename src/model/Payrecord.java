package model;
import java.util.Date;
public class Payrecord {
	private int PayrecordID;
	private Date Date;
	private String Type;
	private int Amount;
	
	public Payrecord() {
		
	}
	public Payrecord(Integer id,Date date, String type, int amount) {
		//super();
		this.PayrecordID=id;
		Date = date;
		Type = type;
		Amount = amount;
	}
	public int getPayrecordID() {
		return PayrecordID;
	}
	public void setPayrecordID(int id) {
		this.PayrecordID=id;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
}
