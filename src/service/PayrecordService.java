package service;
import java.util.List;

import model.*;

public interface PayrecordService {

	void savePayrecord(Payrecord model);
	int numOfReader();
	List<Payrecord> getAll();
}
