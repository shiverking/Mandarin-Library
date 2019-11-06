package service;

import java.util.List;
import model.*;
import util.PageBean;

public class DeleterecordServiceImpl extends BaseService<Deleterecord> implements DeleterecordService {


	public void saveDeleterecord(Deleterecord model) {
		// TODO Auto-generated method stub
		this.getDao().save(model);
	}


}
