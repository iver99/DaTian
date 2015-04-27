package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Linetransport;

public interface LinetransportDao {

	public List getAllLinetransport(int Display,int PageNow);

	public Linetransport getLinetransportInfo(String linetransportid);

	public List getCompanyLine(String carrierId,int Display,int PageNow);
	
	public List getSelectedLine(String hql,int Display,int PageNow);
	
	public int getCompanyTotalRows(String carrierId);
	
	
}
