package service;
import java.util.List;

import model.Book;
import model.Payrecord;

public class PayrecordServiceImpl extends BaseService<Payrecord>implements PayrecordService {

	public void savePayrecord(Payrecord model) {
		// TODO Auto-generated method stub
		this.getDao().save(model);
	}
	public int numOfReader() {
		int num = this.getDao().numOfReader();
		return num;
	}
	public List<Payrecord> getAll() {
		List<Payrecord> payrecord = this.getDao().findAll();
		return payrecord;
	}
	public int getNumOfDeposit(String date1,String date2) {
		int num = this.getDao().findAllCanByDate("Deposit", date1, date2);
		return num;
	}
	public int getSumOfFine(String date1,String date2) {
		int num = this.getDao().findAllCanByDate("Fine", date1, date2);
		return num;
	}
}