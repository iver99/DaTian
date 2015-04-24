package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Address;


public interface AddressService {

	public List getAddress(String userId);
	public Address getAddressDetail(String id);
	public boolean deleteAddress(String id);
	
	//表内address与address对象重名，参数address重命名
	public boolean insertAddress(String name, String paramaddress, String phone, String clientId);
	
	public boolean updateAddress(String id, String name, String paramaddress, String phone);
}
