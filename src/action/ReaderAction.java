package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Reader;
import service.ReaderService;

public class ReaderAction extends BaseAction<Reader, ReaderService> {
	private Reader tempReader;
	private String searchContent;
	private List<Reader> readers;
	


public Reader getTempReader() {
	return tempReader;
}

public void setTempReader(Reader tempReader) {
	this.tempReader = tempReader;
}

}