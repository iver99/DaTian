package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.SettlementDao;
import cn.edu.bjtu.util.HQLTool;
@Repository
public class SettlementDaoImpl implements SettlementDao{
	@Resource
	HibernateTemplate ht;
	@Resource
	HQLTool hqltool;
	@Override
	public List getUserOrder(String userId) {
		// TODO Auto-generated method stub
		return ht.find("from SettlementCarrierView where carrierId='"+userId+"'");
	}

	@Override
	public List getFindSettlement(String sql, int display, int pageNow) {
		// TODO Auto-generated method stub
		int page = pageNow;
		int pageSize = display;
		
		return hqltool.getQueryList(sql, page, pageSize);//Dao层分页函数提取到此方法
	}


	
}
