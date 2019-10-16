package service;

import java.util.List;

import model.Borrowrecord;
import model.Reader;

/**
* @author 
* @version ����ʱ�䣺2019��9��24�� ����12:23:00
* 
*/
public class ReaderServiceImpl extends BaseService<Reader>implements ReaderService {
	public Reader verify(String Email,String Password) {
		Reader reader = this.getDao().getSingle("Email",Email);
		if (reader == null) {
			return null;
		}
		if (reader.getPassword().equals(Password)) {
			return reader;
		}
		return null;
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

}
