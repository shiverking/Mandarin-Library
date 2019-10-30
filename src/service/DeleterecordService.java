package service;

import java.util.List;


import model.*;
import util.PageBean;

/**
* @author 
* @version ����ʱ�䣺2019��10��6�� ����3:35:28
* 
*/
public interface DeleterecordService {

	void saveDeleterecord(Deleterecord model);
	public List<Deleterecord> getDeleteRecord();
}
