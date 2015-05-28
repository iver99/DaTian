package cn.edu.bjtu.util;

import java.util.List;

/**
 * 分页相关类
 * @author RussWest0
 * @date   2015年5月27日 下午11:20:07
 */
public class PageUtil {
	//public static final int NUMBERS_PER_PAGE = 10;
	private int numPerPage;//每页数目
	private int totalRows;//总记录数
	private int totalPages;//总页数
	private int currentPage;//当前页
	private int startIndex;//记录开始
	private int lastIndex;//记录结束
	private List resultList;//返回结果list
	
	
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getLastIndex() {
		return lastIndex;
	}
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	public List getResultList() {
		return resultList;
	}
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
	
	
	
}
