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
	@Autowired
	OrderDao orderDao;
	/**
	 * 获取用户的订单
	 */
	@Override
	@Deprecated
	public List getUserSettlementList(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		//已完成的订单才能结算
		String hql="from SettlementCarrierView t where t.state='已完成' ";
		Map<String,Object> params=new HashMap<String,Object>();
		if(userKind==2){//个人用户
			hql+=" and t.clientId=:clientId ";
			params.put("clientId", userId);
		}else if(userKind==3){//企业用户
			hql+=" and t.carrierId=:carrierId ";
			params.put("carrierId", userId);
		}
		return settlementDao.find(hql, params);
	}
	/**
	 * 获取生成对账单的订单
	 */
	@Override
	public List getOrderStatement(String orderNum) {
		
		return settlementDao.getOrderStatement(orderNum);
	}
	@Override
	public List getFindSettlement(String carrierId, String name, int display, int pageNow) {
		
		String sql="from SettlementCarrierView where carrierId='"+carrierId+"' and ";
		if(name.equals("承运方名称或承运方合同编号")){
			//查找时不考虑合同名字
			name = "";
		}
		//没有时间限制
		sql+=" (companyName like '%"+name+"%' or contractId like '%"+name+"%')";
		return settlementDao.getFindSettlement(sql, display, pageNow);
	}
	/**
	 * 返回用户已结算金额/待结算金额  flag=0已结算/flag=1待结算
	 */
	@Override
	public Float getUserSettlementMoney(HttpSession session,int flag) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql ="from Orderform t where t.settlementState=:settlementState "
				+ "and t.clientId=:clientId";
		Map<String,Object> params=new HashMap<String,Object>();
		if(flag==0){
			params.put("settlementState", "已生成");
		}else{//flag=1
			hql+=" and t.state='已完成'";
			params.put("settlementState", "未生成");
		}
		params.put("clientId", userId);
		List<Orderform> orderList=orderDao.find(hql, params);
		float totalMoney=0F;
		if(orderList!=null && orderList.size()>0){
			for(Orderform o:orderList){
				if(o.getActualPrice()!=null){
					
					totalMoney+=o.getActualPrice();//结算金额按实际运费算
				}
			}
		}
		
		return totalMoney;
	}

}
