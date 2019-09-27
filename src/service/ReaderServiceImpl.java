package service;

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
}
