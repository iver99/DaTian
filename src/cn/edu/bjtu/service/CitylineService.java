package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.search.CityLineSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Cityline;

import com.alibaba.fastjson.JSONArray;

public interface CitylineService {
	public List getAllCityline(int Display,int PageNow);
	public List getSelectedCityline(String resourceRate, String serviceIndustry, String creditRate, int Display,int PageNow);
	public int getTotalRows(String resourceRate, String serviceIndustry, String creditRate);
	
	public Cityline getCitylineInfo(String citylineid);
	public List getCompanyCityline(String carrierId);
	public boolean insertCityLine(String name,String cityName,String VIPService,
			float refPrice,String remarks,String carrierId, String VIPDetail,
			String path,String fileName);
	public boolean updateLine(String id, String citylineName, String cityName, String VIPService,
			String VIPDetail,float refPrice, String remarks, String carrierId,
			String path,String fileName);
	public boolean deleteCityline(String id);
	public List getAllCitylineWithoutPage();
	
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
	
}
