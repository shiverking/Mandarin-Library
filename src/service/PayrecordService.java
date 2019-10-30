package service;
import java.util.List;

import model.*;

public interface PayrecordService {

	void savePayrecord(Payrecord model);
	int numOfReader();
	List<Payrecord> getAll();
	int getNumOfDeposit(String date1,String date2);
	int getSumOfFine(String date1,String date2);
}
