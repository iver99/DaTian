package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.search.CarSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;

import com.alibaba.fastjson.JSONArray;

public interface CarService {
	@Deprecated
	public List getSelectedCar(String carLocation, String carBase, String carLength, String carWeight, int Display,int PageNow);
	@Deprecated
	public int getTotalRows(String carLocation, String carBase, String carLength, String carWeight);
	
	public Carinfo getCarInfo(String carid);


	public List getCompanyCar(String carrierId);


	public boolean insertCar(String carNum, String carTeam,
			String locationType, String terminalId, String carBase, String carBrand,
			String carType, String carUse, double carLength, double carWidth,
			double carHeight, double carWeight, String driverId,
			String purchaseTime, String storage, String startPlace,
			String endPlace, String stopPlace, String carrierId);

	

	public boolean updateCar(String id, String carNum, String carTeam, String locType, 
			String terminalId, String carType, String carBase, String carBrand, String carUse,
			double carLength, double carWidth, double carHeight, double carWeight, String carPurTime,
			String storage,String driverId, String startPlace,String endPlace,
			String stopPlace,String carrierId);
	
	
	public boolean deleteCar(String id);
	
	/**
	 * 获取资源栏筛选car
	 * @param carbean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedCarNew(CarSearchBean carbean,PageUtil pageUtil,HttpSession session);
	
	/**
	 * 获取资源栏-车辆筛选记录总条数
	 * @param carBean
	 * @return
	 */
	public Integer getSelectedCarTotalRows(CarSearchBean carBean);
	
	/**
	 * 获取公司车队姓名列表
	 * @Title: getCompanyCarteamList 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年6月29日 下午5:35:42
	 */
	public List<Carteam> getCompanyCarteamList(HttpSession session);
	
	/**
	 * 我的信息-车辆信息-总记录条数
	 * @Title: getUserCarResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午11:12:59
	 */
	public Integer getUserCarResourceTotalRows(HttpSession session);
	
	/**
	 * 我的信息-车辆信息
	 * @Title: getUserCarResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午11:13:42
	 */
	public JSONArray getUserCarResource(HttpSession session,PageUtil pageUtil);
	
	
	
}
