package cn.edu.bjtu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.DriverDao;
import cn.edu.bjtu.vo.Driverinfo;
@Repository
public class DriverDaoImpl extends BaseDaoImpl<Driverinfo> implements DriverDao{
	@Override
	/**
	 * 返回所有司机信息
	 */
	public List getAllDriver() {
		
		return this.find("from Driverinfo");
	}

	@Override
	public Driverinfo getDriverInfo(String driverId) {
		
		return this.get(Driverinfo.class,driverId);
	}
	@Override
	/**
	 * 获取某公司的所有司机姓名 
	 */
	public List getAllDriverName(String carrierId) {
		
		return this.find("select driverName from Driverinfo where carrierId='"+carrierId+"'");
	}

	@Override
	/**
	 * 获取某公司的所有司机信息 
	 */
	public List getAllDriver(String carrierId) {
		
		
		return this.find("from Driverinfo where carrierId='"+carrierId+"'");
	}
	

	@Override
	public String getDriverIdByName(String driverName) {
		
		return "";
	}

	@Override
	/**
	 * 返回公司司机
	 */
	public List getCompanyDriver(String carrier) {
		
		return this.find("from Driverinfo where carrierId='"+carrier+"'");
	}

}
