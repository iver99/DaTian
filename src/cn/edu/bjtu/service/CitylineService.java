package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.search.CityLineSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Cityline;

import com.alibaba.fastjson.JSONArray;

public interface CitylineService {
	@Deprecated
	public List getSelectedCityline(String resourceRate, String serviceIndustry, String creditRate, int Display,int PageNow);
	@Deprecated
	public int getTotalRows(String resourceRate, String serviceIndustry, String creditRate);
	
	public Cityline getCitylineInfo(String citylineid);
	@Deprecated
	public List getCompanyCityline(String carrierId);
	public boolean insertCityLine(String name,String cityName,String VIPService,
			float refPrice,String remarks,String carrierId, String VIPDetail,
			String path,String fileName);
	@Deprecated
	public boolean updateLine(String id, String citylineName, String cityName, String VIPService,
			String VIPDetail,float refPrice, String remarks, String carrierId,
			String path,String fileName);
	public boolean deleteCityline(String id);
	
	/**
	 * 资源栏获取筛选城市配送
	 * @param citiLineBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedLineNew(CityLineSearchBean citiLineBean,PageUtil pageUtil,HttpSession session);	

	/**
	 * 返回城市配送筛选总条数
	 * @param citylineBean
	 * @return
	 */
	public Integer getSelectedCityLineTotalRows(CityLineSearchBean citylineBean);
	
	/**
	 * 我的信息-城市配送-总记录数 
	 * @Title: getUserCitylineResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午9:56:06
	 */
	public Integer getUserCitylineResourceTotalRows(HttpSession session);
	
	/**
	 * 我的信息-城市配送
	 * @Title: getUserCitylineResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午9:57:01
	 */
	public JSONArray getUserCitylineResource(HttpSession session,PageUtil pageUtil);
		
	
}
