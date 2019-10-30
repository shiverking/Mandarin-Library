package service;

import java.util.List;
import model.*;
import util.PageBean;

public class DeleterecordServiceImpl extends BaseService<Deleterecord> implements DeleterecordService {


	public void saveDeleterecord(Deleterecord model) {
		// TODO Auto-generated method stub
		this.getDao().save(model);
	}
	public List<Deleterecord> getDeleteRecord() {
		List<Deleterecord> DeleteRecord = this.getDao().findAll();
		return DeleteRecord;
	}

}
