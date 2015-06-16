package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Carrierinfo;

public interface CompanyDao extends BaseDao<Carrierinfo>{
	
	@Deprecated
	public List getAllCompany(int Display,int PageNow);
	@Deprecated
	public List getSelectedCompany(String hql,int Display,int PageNow);
	
	public Carrierinfo getCarrierInfo(String id);
	
	public List getLinetransportByCarrierId(String id);
	public List getCitylineByCarrierId(String id);
	public List getwarehouseByCarrierId(String id);
	@Deprecated
	public List getAllCompanyWithoutPage();
}
