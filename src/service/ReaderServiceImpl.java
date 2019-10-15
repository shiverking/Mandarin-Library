package service;

import java.util.List;

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
	private static SessionFactory factory;
	
	public Reader verify(String Email, String Password) {
		Reader reader = this.getDao().getSingle("Email", Email);
		if (reader == null) {
			return null;
		}
		if (reader.getPassword().equals(Password)) {
			return reader;
		}
		return null;
	}

	public void mergeReader(Reader reader) {
		// TODO Auto-generated method stub
		this.getDao().merge(reader);
	}

	public boolean forgetReaderPassword(String email) {
		System.out.println(email);
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
}
