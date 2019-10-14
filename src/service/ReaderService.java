package service;

import java.util.List;

import model.Borrowrecord;
/**
* @author 
* @version ����ʱ�䣺2019��9��24�� ����12:19:42
* 
*/
import model.Reader;

public interface ReaderService {
	public Reader verify(String Email, String Password);

	public List<Reader> getReaderByName(String Name);

	public List<Reader> getAllReader();

	public Reader getReaderById(int id);

	public Reader getReaderByBorrowrecord(Borrowrecord borrowrecord);

}
