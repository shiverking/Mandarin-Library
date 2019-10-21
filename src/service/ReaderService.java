package service;

/**
* @author 
* @version ����ʱ�䣺2019��9��24�� ����12:19:42
* 
*/
import model.Reader;

public interface ReaderService {
	public Reader verify(String phoneNumber, String Password);
	public void mergeReader(Reader reader);
	public boolean forgetReaderPassword(String email);
}
