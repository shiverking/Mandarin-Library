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
<<<<<<< HEAD
	public Reader verify(String Email, String Password);
=======

>>>>>>> wjy

	public List<Reader> getReaderByName(String Name);

	public List<Reader> getAllReader();

	public Reader getReaderById(int id);
	public void register(Reader reader);
	public Reader getReaderByBorrowrecord(Borrowrecord borrowrecord);

	public int getReaderNum();

<<<<<<< HEAD
=======
	public Reader verify(String phoneNumber, String Password);
	public void mergeReader(Reader reader);
	public boolean forgetReaderPassword(String email);
>>>>>>> wjy
}
