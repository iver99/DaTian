package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.SettlementDao;
@Repository
public class SettlementDaoImpl implements SettlementDao{
	@Resource
	HibernateTemplate ht;
	
	@Override
	public List getUserOrder(String userId) {
		// TODO Auto-generated method stub
		return ht.find("from SettlementCarrierView where carrierId='"+userId+"'");
	}
	
}
