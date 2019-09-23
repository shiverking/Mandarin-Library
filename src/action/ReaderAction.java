package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Reader;
import service.ReaderService;

/**
 * @author
 * @version ����ʱ�䣺2019��9��24�� ����12:17:41
 * 
 */
public class ReaderAction extends BaseAction<Reader, ReaderService> {
	private Reader temReader;
	private String searchContent;
	private List<Reader> readers;

	public String search() {
		if (this.searchContent == null) {
			return NONE;
		} else {
			return "isBook";
		}
	}

}