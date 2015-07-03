package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Driverinfo;

import com.alibaba.fastjson.JSONArray;

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
	
	/**
	 * 我的信息-司机信息
	 * @Title: getUserDriverResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午4:13:11
	 */
	public JSONArray getUserDriverResource(HttpSession session,PageUtil pageUtil);
	
	/**
	 * 我的信息-司机信息-总记录条数
	 * @Title: getUserDriverResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午4:16:24
	 */
	public Integer getUserDriverResourceTotalRows(HttpSession session);

}
