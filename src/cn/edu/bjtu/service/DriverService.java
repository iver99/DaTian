package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Driverinfo;

public interface DriverService {
	public List getAllDriver();

	public Driverinfo getDriverInfo(String driverId);
	
	public Driverinfo getDriverByCarId(String carId);

	public List getAllDriverName(String carrierId);
	public List getAllDriver(String carrierId);
	
	public String getDriverIdByName(String driverName);

	public boolean insertDriver(String name, String sex, String licenceRate,
			String phone, String IDCard, String licenceNum, String licenceTime,
			String carrierId,String path,String fileName);
	
	public List getCompanyDriver(String carrierId);
	public boolean updateDriver(String id, String name, String sex,String IDCard, String licenceNum,
			String licenceRate, String licenceTime,	String phone, String carrierId,String path,String fileName);

	public boolean deleteDriver(String id);
}
