package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Driverinfo;

public interface CarService {

	public List getAllCar(int Display,int PageNow);
	public List getSelectedCar(String carLocation, String carBase, String carLength, String carWeight, int Display,int PageNow);
	public int getTotalRows(String carLocation, String carBase, String carLength, String carWeight);
	
	public Carinfo getCarInfo(String carid);

	public List getAllDriver();

	public Driverinfo getDriverInfo(String driverId);

	public List getCompanyCar(String carrierId);

	public Driverinfo getDriverByCarId(String carId);

	public List getAllDriverName(String carrierId);
	public List getAllDriver(String carrierId);
	public boolean insertCar(String carNum, String carTeam,
			String locationType, String carBase, String carBrand,
			String carType, String carUse, double carLength, double carWidth,
			double carHeight, double carWeight, String driverId,
			String purchaseTime, String storage, String startPlace,
			String endPlace, String carrierId);

	public String getDriverIdByName(String driverName);

	public boolean insertDriver(String name, String sex, String licenceRate,
			String phone, String IDCard, String licenceNum, String licenceTime,
			String carrierId,String path,String fileName);
	
	public List getCompanyDriver(String carrierId);

	public boolean updateCar(String id, String carNum, String carTeam, String locType, 
			String GPSText, String carType, String carBase, String carBrand, String carUse,
			double carLength, double carWidth, double carHeight, double carWeight, String carPurTime,
			String storage,String driverId, String startPlace,String endPlace,
			String stopPlace,String carrierId);
	
	public boolean updateDriver(String id, String name, String sex,String IDCard, String licenceNum,
			String licenceRate, String licenceTime,	String phone, String carrierId,String path,String fileName);
	
	public boolean deleteCar(String id);
	public boolean deleteDriver(String id);
	
	public List getCarteam(String carrierId);
	public Carteam getCarteamInfo(String id);
	public boolean insertCarteam(String teamName,String carCount,String chief,String phone,
			String explaination,String carrierId);
	public boolean deleteCarteam(String id);
	public boolean updateCarteam(String id,String teamName,String carCount,String chief,String phone,
			String explaination);
	
}
