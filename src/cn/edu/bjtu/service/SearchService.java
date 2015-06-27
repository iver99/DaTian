package cn.edu.bjtu.service;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.util.PageUtil;

import com.alibaba.fastjson.JSONArray;

/**
 * 搜索相关
 * @author RussWest0
 *
 */
public interface SearchService {
	
	/**
	 * 在城市名中搜索干线资源结果
	 * @param cityName
	 * @return
	 */
	public JSONArray getLineResourceByCityName(String cityName,PageUtil pageUtil,HttpSession session);
	/**
	 * 根据名称搜索城市配送结果
	 * @param name
	 * @return
	 */
	public JSONArray getCitylineResourceByName(String name,PageUtil pageUtil,HttpSession session);
	/**
	 * 根据货物名搜索获取结果
	 * @param name
	 * @return
	 */
	public JSONArray getGoodsResourceByName(String name,PageUtil pageUtil,HttpSession session);
	/**
	 * 根据公司名搜索获取结果
	 * @param name
	 * @return
	 */
	public JSONArray getCompanyResourceByCompanyName(String companyName,PageUtil pageUtil,HttpSession session);
	/**
	 * 根据车辆牌照名搜索获取结果
	 * @param name
	 * @return
	 */
	public JSONArray getCarResourceByCarNum(String carNum,PageUtil pageUtil,HttpSession session);
	/**
	 * 根据仓库名搜索获取结果
	 * @param name
	 * @return
	 */
	public JSONArray getWarehouseResourceByName(String name,PageUtil pageUtil,HttpSession session);
}
