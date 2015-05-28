package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Driverinfo;

public interface CarDao extends BaseDao<Carinfo>{
	
	public List getAllCar(int Display,int PageNow);
	public List getAllLocation();
	public Carinfo getCarInfo(String carid);
	
	public List getCompanyCar(String carrierId);
	
	public List getSelectedCar(String hql,int Display,int PageNow);
	
	
}
