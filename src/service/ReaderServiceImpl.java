package service;

import model.Reader;

/**
* @author 
* @version 创建时间：2019年9月24日 上午12:23:00
* 
*/
public class ReaderServiceImpl extends BaseService<Reader>implements ReaderService {
	public Reader verify(String ReaderName,String Password) {
		Reader reader = this.getDao().getSingle("ReaderName",ReaderName);
		if (reader == null) {
			return null;
		}
		if (reader.getPassword().equals(Password)) {
			return reader;
		}
		return null;
	}
}
