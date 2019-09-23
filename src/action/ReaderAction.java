package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Reader;
import service.ReaderService;

/**
 * @author
 * @version 创建时间：2019年9月24日 上午12:17:41
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