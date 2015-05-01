package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Address;


public interface AddressDao {
	public List getAddress(String userId);
	public Address getAddressDetail(String id);
	public boolean deleteAddress(String id);
}
