package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Cityline;

public interface CitylineDao extends BaseDao<Cityline> {
	
	public List getAllCityline(int Display,int PageNow);
	public Cityline getCitylineInfo(String citylineid);
	public List getCompanyCityline(String carrierId);
	public List getSelectedCityline(String hql,int Display,int PageNow);
	public List getAllCitylineWithoutPage();
	
}
