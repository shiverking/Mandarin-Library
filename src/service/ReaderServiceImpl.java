package service;

import java.util.List;

import model.Borrowrecord;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;

import dao.ReaderDao;
import model.Reader;
import util.Email;
import util.Email_2;

/**
 * @author
 * @version ����ʱ�䣺2019��9��24�� ����12:23:00
 * 
 */
public class ReaderServiceImpl extends BaseService<Reader> implements ReaderService {
	
	public Reader verify(String phoneNumber, String Password) {
		Reader reader = this.getDao().getSingle("PhoneNumber",phoneNumber);
		if (reader == null) {
			return null;
		}
		if (reader.getPassword().equals(Password)) {
			return reader;
		}
		return null;
	}
	public int getReaderNum() {
		int num = this.getDao().numOfReader();
		return num;
	}
	public List<Reader> getReaderByName(String Name) {
		// TODO Auto-generated method stub
		return this.getDao().findBy("ReaderName", Name, "ReaderID desc");
	}

	public List<Reader> getAllReader() {
		// TODO Auto-generated method stub
		return this.getDao().findAll("ReaderID desc");
	}

	public Reader getReaderById(int id) {
		// TODO Auto-generated method stub
		return this.getDao().get(id);
	}

	public Reader getReaderByBorrowrecord(Borrowrecord borrowrecord) {
		// TODO Auto-generated method stub
		int id = borrowrecord.getReaderID();
		return this.getReaderById(id);
	}
	
	public void register(Reader reader) {
		// TODO Auto-generated method stub
		if(reader.getPassword()=="") {
			reader.setPassword("00010001");
		}
		this.getDao().save(reader);
	}


	public void mergeReader(Reader reader) {
		// TODO Auto-generated method stub
		this.getDao().merge(reader);
	}

	public boolean forgetReaderPassword(String email) {
		/* System.out.println(email); */
		if(email == null) {
			return false;
		}
		String password = "";
		List<Reader> readers = this.getDao().findBy("Email", email);
		if (readers.size() == 0) {
			return false;
		}
		else {
			for (Reader reader : readers) {
				password = reader.getPassword();
			}
			try {
				Email_2 e = new Email_2(email);
				e.sendEmail(password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	}
	@Override
	public Reader getReaderbyPhone(String pString) {
	return this.getDao().getSingle("PhoneNumber", pString);

	}
}
