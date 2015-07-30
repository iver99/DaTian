package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.AddressDao;
import cn.edu.bjtu.service.AddressService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Address;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Transactional
@Service
/**
 * 子账户服务层实现 
 * 
 *
 */
public class AddressServiceImpl implements AddressService{
	
	@Resource
	HibernateTemplate ht;
	/*@Resource 
	BaseDao baseDao;*/
	@Autowired
	AddressDao addressDao;
	@Resource 
	Address address;
	
	@Override
	/**
	 * 获取地址列表
	 */
	public List getAddress(String userId) {
		
		
		return addressDao.getAddress(userId);
	}
	
	
	@Override
	public Address getAddressDetail(String id){
		
		return addressDao.getAddressDetail(id);
	}
	
	
	@Override
	public boolean deleteAddress(String id){
		return addressDao.deleteAddress(id);
	}
	
	@Override
	/**
	 * 表内address与address对象重名，参数address重命名
	 */
	public boolean insertAddress(String name, String paramaddress, String phone, String clientId){
		
		address.setId(IdCreator.createAddressId());
		address.setName(name);
		address.setAddress(paramaddress);
		address.setPhone(phone);
		address.setRelDate(new Date());
		address.setClientId(clientId);
		 addressDao.save(address);
		 return true;
	}
	
	@Override
	public boolean updateAddress(String id, String name, String paramaddress, String phone){
	
		address = addressDao.getAddressDetail(id);// 根据id查找

		address.setAddress(paramaddress);
		address.setName(name);
		address.setPhone(phone);
		addressDao.update(address);
		return true;
	}
	
	/**
	 * 添加用户常用地址
	 */
	@Override
	public void addUserAddress(HttpSession session,Address address) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		address.setClientId(userId);
		address.setFrequency(0);
		address.setId(IdCreator.createAddressId());
		address.setRelDate(new Date());
		
		addressDao.save(address);
		
	}


	/**
	 * 下订单时获取用于的藏用地址列表
	 */
	@Override
	public JSONArray getUserFrequentAddress(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Address t where t.clientId=:clientId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		List<Address> addressList=addressDao.find(hql, params);
		
		JSONArray jsonArray=new JSONArray();
		for(Address address: addressList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(address);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	
	/**
	 * 获取发货地址
	 */
	@Override
	public String getAddress(HttpSession session, PageUtil pageUtil,Address address) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Address t where t.clientId=:clientId and t.kind=:kind ";//1为发货地址,2为收货地址
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		params.put("kind", address.getKind());
		
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Address> addressList=addressDao.find(hql, params, page, display);
		
		JSONArray jsonArray=new JSONArray();
		for(Address addr:addressList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(addr);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray.toString();
	}

	/**
	 * 常用发货地址-总记录数
	 */
	@Override
	public Integer getAddressTotalRows(HttpSession session,Address address) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count (*) from Address t where t.clientId=:clientId and t.kind=:kind ";//1为发货地址,2为收货地址
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		params.put("kind", address.getKind());
		
		Long count =addressDao.count(hql, params);
		
		return count.intValue();
	}
	
}
