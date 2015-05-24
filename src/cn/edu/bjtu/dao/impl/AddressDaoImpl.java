package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.AddressDao;
import cn.edu.bjtu.vo.Address;


@Repository
/**
 * 子账户dao层实现
 *
 */
public class AddressDaoImpl extends BaseDaoImpl<Address> implements AddressDao{

	@Resource
	HibernateTemplate ht;
	/*@Resource
	BaseDao baseDao;*/
	/*@Autowired
	AddressDao addressDao;*/
	
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
		//baseDao.delete(address);
		this.delete(address);
		return true;
	}
}
