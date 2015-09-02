package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.SettlementDao;

import cn.edu.bjtu.vo.SettlementCarrierView;
@Repository
public class SettlementDaoImpl extends BaseDaoImpl<SettlementCarrierView> implements SettlementDao{
	@Resource
	HibernateTemplate ht;
	
	@Override
	public List getOrderStatement(String orderNum) {
		
		return ht.find("from SettlementCarrierView where orderNum='"+orderNum+"'");
	}



	
}
