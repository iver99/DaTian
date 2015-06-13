package cn.edu.bjtu.util;

import java.util.ArrayList;
import java.util.List;

/**
 * JSON工具包
 * @author RussWest0
 * @date   2015年6月13日 下午5:22:13
 */
public class DataModel {
	
	private Long total = 0L;
	private List rows = new ArrayList();
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	

}
