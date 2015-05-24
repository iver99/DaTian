package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Driverinfo;
/**
 * 司机相关Dao
 * @author RussWest0
 * @date   2015年5月24日 上午10:09:02
 */
public interface DriverDao extends BaseDao<Driverinfo>{
	public List getAllDriver();
	public Driverinfo getDriverInfo(String driverId);
	public List getAllDriverName(String carrierId);
	public List getAllDriver(String carrierId);
	public String getDriverIdByName(String driverName);
	public List getCompanyDriver(String carrier);
}
