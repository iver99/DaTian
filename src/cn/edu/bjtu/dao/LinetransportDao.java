package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Linetransport;

public interface LinetransportDao extends BaseDao<Linetransport>{

	public List getAllLinetransport(int Display,int PageNow);

	public Linetransport getLinetransportInfo(String linetransportid);

	public List getCompanyLine(String carrierId,int Display,int PageNow);
	
	public List getSelectedLine(String hql,int Display,int PageNow);
	@Deprecated
	public int getCompanyTotalRows(String carrierId);

	
}
