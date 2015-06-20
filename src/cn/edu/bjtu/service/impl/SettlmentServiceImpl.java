package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.dao.SettlementDao;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.SettlementService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.Settlement;
@Service("settlementServiceImpl")
@Transactional
public class SettlmentServiceImpl implements SettlementService{
	@Resource
	HQLTool hqltool;
	@Resource
	SettlementDao settlementDao;
	/**
	 * 获取用户的订单
	 */
	@Override
	public List getUserSettlementList(String userId) {
		//已完成的订单才能结算
		String hql="from SettlementCarrierView t where t.clientId=:clientId "
				+ " and t.state='已完成'";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		return settlementDao.find(hql, params);
	}
	/**
	 * 获取生成对账单的订单
	 */
	@Override
	public List getOrderStatement(String orderNum) {
		// TODO Auto-generated method stub
		return settlementDao.getOrderStatement(orderNum);
	}
	@Override
	public List getFindSettlement(String carrierId, String name, int display, int pageNow) {
		// TODO Auto-generated method stub
		String sql="from SettlementCarrierView where carrierId='"+carrierId+"' and ";
		if(name.equals("承运方名称或承运方合同编号")){
			//查找时不考虑合同名字
			name = "";
		}
		//没有时间限制
		sql+=" (companyName like '%"+name+"%' or contractId like '%"+name+"%')";
		return settlementDao.getFindSettlement(sql, display, pageNow);
	}
	/*@Override
	public int getFindSettlementTotalRows(String carrierId, String name, int display, int pageNow) {
		// TODO Auto-generated method stub
		String sql="from SettlementCarrierView where carrierId='"+carrierId+"' and ";
		if(name.equals("承运方名称或承运方合同编号")){
			//查找时不考虑合同名字
			name = "";
		}
		//没有时间限制
		sql+=" (companyName like '%"+name+"%' or contractId like '%"+name+"%')";
		return hqltool.getTotalRows(sql);// 这里的HQLTool实例千万不能自己new出来，用@Resource
	}*/
	
	
	

}
