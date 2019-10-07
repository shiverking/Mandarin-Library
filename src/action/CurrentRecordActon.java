package action;

import java.util.List;

import model.CurrentRecord;
import model.Reader;
import service.CurrentRecordService;

/**
 * @author
 * @version ����ʱ�䣺2019��10��6�� ����3:37:56
 * 
 */
public class CurrentRecordActon extends BaseAction<CurrentRecord, CurrentRecordService> {
	private Reader tempReader;// ��¼��ǰ���ߵ���Ϣ

	private List<CurrentRecord> currentRecords;// ��¼�ڽ��鼮��ԤԼ�鼮����Ϣ

//�����Ǿ���ʹ�õĹ��ܺ���

//ȡ�ö��ߵ�ǰ���ĵ��鼮��ԤԼ���鼮��¼
	public String getCurrentPage() {
		currentRecords = this.getService().getCurrentRecordsbyReader(tempReader);
		return SUCCESS;
	}

//�����Ǹ������Ե�get��set����
	public Reader getTempReader() {
		return tempReader;
	}

	public void setTempReader(Reader tempReader) {
		this.tempReader = tempReader;
	}

	public List<CurrentRecord> getCurrentRecords() {
		return currentRecords;
	}

	public void setCurrentRecords(List<CurrentRecord> currentRecords) {
		this.currentRecords = currentRecords;
	}


}
