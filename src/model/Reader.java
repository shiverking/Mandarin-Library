package model;

public class Reader {
	private int ReaderID;
	private String ReaderName;
	private String Password;
	private String Email;
	private int Money=300;
	private String PhoneNumber;
	public Reader() {
	}

	public Reader(int readerID, String readerName, String password, String email, int money, String phoneNumber) {
		// super();
		ReaderID = readerID;
		ReaderName = readerName;
		Password = password;
		Email = email;
		PhoneNumber = phoneNumber;
	}

	public int getReaderID() {
		return ReaderID;
	}

	public void setReaderID(int readerID) {
		ReaderID = readerID;
	}

	public String getReaderName() {
		return ReaderName;
	}

	public void setReaderName(String readerName) {
		ReaderName = readerName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getMoney() {
		return Money;
	}

	public void setMoney(int money) {
		Money = money;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}



}
