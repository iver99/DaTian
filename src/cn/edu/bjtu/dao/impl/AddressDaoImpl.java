package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.AddressDao;
import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.vo.Address;


@Repository
/**
 * 子账户dao层实现
 *
 */
public class AddressDaoImpl implements AddressDao{

	@Resource
	HibernateTemplate ht;
	@Resource
	BaseDao baseDao;
	
	@Override
	public List getAddress(String userId) {
		// TODO Auto-generated method stub
		return ht.find("from Address where clientId='"+userId+"'");
	}
	
	@Override
	public Address getAddressDetail(String id){
		return ht.get(Address.class, id);
	}
	
	
	@Override
	public boolean deleteAddress(String id){
		
		Address address = ht.get(Address.class, id);
		return baseDao.delete(address);
	}
}
