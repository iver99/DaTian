package cn.edu.bjtu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.AddressDao;
import cn.edu.bjtu.vo.Address;


@Repository
/**
 * 子账户dao层实现
 *
 */
public class AddressDaoImpl extends BaseDaoImpl<Address> implements AddressDao{

	
	@Override
	public List getAddress(String userId) {
		
		return this.find("from Address where clientId='"+userId+"'");
	}
	
	@Override
	public Address getAddressDetail(String id){
		return this.get(Address.class, id);
	}
	
	
}
