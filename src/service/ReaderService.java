package service;

import java.util.List;

import model.Borrowrecord;
/**
* @author 
* @version ����ʱ�䣺2019��9��24�� ����12:19:42
* 
*/
import model.Reader;
import util.PageBean;

public interface ReaderService {


	public List<Reader> getReaderByName(String Name);

	public List<Reader> getAllReader();

	public Reader getReaderById(int id);
	public void register(Reader reader);
	public Reader getReaderByBorrowrecord(Borrowrecord borrowrecord);
	public Reader getReaderbyPhone(String pString);
	public Reader getReaderbyEmail(String email);
	public int getReaderNum();

	public Reader verify(String phoneNumber, String Password);
	public void mergeReader(Reader reader);
	public void deleteReader(Reader reader); 
	public boolean forgetReaderPassword(String email);
	public PageBean<Reader> getPageBean(Integer pageNum);
	public List<Reader> show();
}
