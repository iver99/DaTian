package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Driverinfo;

public interface CarDao {
	
	public List getAllCar(int Display,int PageNow);
	public Carinfo getCarInfo(String carid);
	public List getAllDriver();
	public Driverinfo getDriverInfo(String driverId);
	public List getCompanyCar(String carrierId);
	public List getAllDriverName(String carrierId);
	public String getDriverIdByName(String driverName);
	public List getCompanyDriver(String carrier);
	public List getSelectedCar(String hql,int Display,int PageNow);
	public List getCarteam(String carrierId);
	public Carteam getCarteamInfo(String id);
	
}
