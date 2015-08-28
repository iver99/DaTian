package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.bean.search.CityLineSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Cityline;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;

public interface CitylineService {
	
	public Cityline getCitylineInfo(String citylineid);
	public boolean insertNewCityline(Cityline cityline,
			HttpServletRequest request, MultipartFile file);
	public boolean updateNewCityline(Cityline cityline,HttpServletRequest request,MultipartFile file);
	
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
	
	/**
	 * 获取用户城市配送资源
	 * @param carrierId
	 * @return
	 */
	public String getCompanyCitylineResource(String carrierId);
		
	
}
