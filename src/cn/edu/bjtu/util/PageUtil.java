package cn.edu.bjtu.util;

import java.util.List;

/**
 * 分页相关类
 * @author RussWest0
 * @date   2015年5月27日 下午11:20:07
 */
public class PageUtil {
	//public static final int NUMBERS_PER_PAGE = 10;
	
	
	private int display;//每页数目
	private int totalRows;//总记录数
	private int totalPages;//总页数
	private int currentPage;//当前页
	private int startIndex;//记录开始
	private int lastIndex;//记录结束
	
	
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
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
	
	
	
}
