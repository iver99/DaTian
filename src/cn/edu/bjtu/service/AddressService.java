package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Address;

import com.alibaba.fastjson.JSONArray;


public interface AddressService {

	public List getAddress(String userId);
	public Address getAddressDetail(String id);
	public boolean deleteAddress(String id);
	/**
	 * 新增常用地址
	 * @param session
	 * @param address
	 * @return
	 */
	public boolean insertAddress(HttpSession session,Address address);
	/**
	 * 更新常用地址
	 * @param session
	 * @param address
	 * @return
	 */
	public boolean updateAddress(HttpSession session,Address address);
	
	/**
	 * 添加用户常用地址
	 * @param session
	 * @param address
	 */
	public void addUserAddress(HttpSession session,Address address);
	
	/**
	 * 下订单时获取用户的常用地址列表
	 * @param session
	 * @return
	 */
	public JSONArray getUserFrequentAddress(HttpSession session);
	
	/**
	 * 常用发货地址
	 * @Title: getSendAddress 
	 * @Description: TODO 
	 * @param: @param session
	 * @param: @param pageUtil
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月29日 上午11:31:25
	 */
	public String getAddress(HttpSession session,PageUtil pageUtil,Address address);
	
	/**
	 * 常用发货地址-总记录数
	 * @Title: getSendAddressTotalRows 
	 * @Description: TODO 
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月29日 上午11:32:18
	 */
	public Integer getAddressTotalRows(HttpSession session,Address address);
}
