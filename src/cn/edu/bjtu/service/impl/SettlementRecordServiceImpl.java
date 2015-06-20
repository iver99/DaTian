package cn.edu.bjtu.service.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.dao.SettlementRecordDao;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.SettlementRecordService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.Settlement;
@Service
@Transactional
public class SettlementRecordServiceImpl implements SettlementRecordService{
	
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDao orderDao;
	@Autowired
	SettlementRecordDao settlementRecordDao;
	/**
	 * 修改订单状态为已结算，并记录生成人
	 */
	@Override
	public boolean finishSettlement(String orderNum, HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String username=(String)session.getAttribute(Constant.USER_NAME);
		Orderform order=orderService.getOrderByOrderNum(orderNum);
		
		order.setSettlementState("已生成");
		Settlement settlement=new Settlement();
		settlement.setId(IdCreator.createSettlementId());
		settlement.setOrderNum(orderNum);
		settlement.setUserId(userId);
		settlement.setCreateTime(new Date());
		settlement.setUsername(username);
		settlementRecordDao.save(settlement);//保存生成对账单记录
		orderDao.update(order);
		
		return true;
		
	}
}
