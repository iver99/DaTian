package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Carrierinfo;

public interface CompanyDao {
	
	public List getAllCompany(int Display,int PageNow);
	public List getSelectedCompany(String hql,int Display,int PageNow);
	
	public Carrierinfo getCarrierInfo(String id);
}
