package util;

import java.io.Serializable;
import java.util.List;

import model.Book;

/**
 * @author
 * @version ����ʱ�䣺2019��10��1�� ����4:49:56
 * @param <T>
 * 
 */
public class PageBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int pageSize = 8; // ÿҳ��ʾ��������¼
	private int currentPage; // ��ǰ�ڼ�ҳ����
	private int startIndex;// ��ʼ������
	private int totalRecord; // һ����������¼
	private int totalPage; // һ������ҳ��¼

	private int prePageNum;// ��һҳ
	private int nextPageNum;// ��һҳ
	private List<T> dataList; // Ҫ��ʾ������
	private int beginPageNum;
	private int endPageNum;

	public PageBean(int totalRecords, int current) {
		totalRecord = totalRecords;
		this.currentPage = current;
		startIndex = (current - 1) * pageSize;
		totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;

		if (totalPage < 7) {
			beginPageNum = 1;
			endPageNum = totalPage;
		} else {
			beginPageNum = currentPage - 3;
			endPageNum = currentPage + 3;
			if (beginPageNum < 1) {
				beginPageNum = 1;
				endPageNum = beginPageNum + 6;
			}
			if (endPageNum > totalPage) {
				endPageNum = totalPage;
				beginPageNum = endPageNum - 6;
			}

		}
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPrePageNum() {
		prePageNum = currentPage - 1;
		if (prePageNum < 1) {
			prePageNum = 1;
		}
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public int getNextPageNum() {
		nextPageNum = currentPage + 1;
		if (nextPageNum > totalPage) {
			nextPageNum = totalPage;
		}
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBeginPageNum() {
		return beginPageNum;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}

}
