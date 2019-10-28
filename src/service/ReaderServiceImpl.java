package service;

import java.util.ArrayList;
import java.util.List;

import model.Borrowrecord;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;

import dao.ReaderDao;
import model.Reader;
import util.Email;
import util.Email_2;
import util.PageBean;

/**
 * @author
 * @version ����ʱ�䣺2019��9��24�� ����12:23:00
 * 
 */
public class ReaderServiceImpl extends BaseService<Reader> implements ReaderService {

	public Reader verify(String phoneNumber, String Password) {
		Reader reader = this.getDao().getSingle("PhoneNumber", phoneNumber);
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
		if (reader.getPassword() == "") {
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
		if (email == null) {
			return false;
		}
		String password = "";
		List<Reader> readers = this.getDao().findBy("Email", email);
		if (readers.size() == 0) {
			return false;
		} else {
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

	@Override
	public void deleteReader(Reader reader) {
		// TODO Auto-generated method stub
		this.getDao().delete(reader);
	}

	@Override
	public Reader getReaderbyEmail(String email) {
		return this.getDao().getSingle("Email", email);
	}

	@Override
	public PageBean<Reader> getPageBean(Integer pageNum) {
		// TODO Auto-generated method stubpublic PageBean<Borrowrecord> getPageBean(Reader reader, Integer pageNum,boolean isreturn) {
		// TODO 分页查询
		int Num = 1;
		if (pageNum != null) {
			Num = pageNum;
		}
		List<String> pls=new ArrayList<String>();
		List<String> vlsList=new ArrayList<String>();
		pls.add("ReaderName");
		vlsList.add("");
		int totalRecords = this.getDao().findTotalNum(pls, vlsList, 0, 0);
		PageBean<Reader> page = new PageBean<Reader>(totalRecords, Num,5);
		page.setDataList(this.getDao().findPage(pls, vlsList, null, 0, 0, 0, page.getStartIndex(), page.getPageSize()));
		return page;

	}
}
