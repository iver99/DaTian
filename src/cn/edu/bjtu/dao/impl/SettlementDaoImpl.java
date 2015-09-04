package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.SettlementDao;

import cn.edu.bjtu.vo.SettlementCarrierView;
@Repository
public class SettlementDaoImpl extends BaseDaoImpl<SettlementCarrierView> implements SettlementDao{
	
	@Override
	public List getOrderStatement(String orderNum) {
		
		return this.find("from SettlementCarrierView where orderNum='"+orderNum+"'");
	}



	
}
