package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Resource
	private HibernateTemplate ht;

	@Resource
	private BaseDao baseDao;

	@Override
	/**
	 * 返回所有城市信息
	 */
	public List getAllSendOrderInfo(String userId) {
		// TODO Auto-generated method stub
		// System.out.println("dao-userid+"+userId);
		return ht.find("from OrderCarrierView where clientId='" + userId + "'");

	}

	@Override
	public List getAllRecieveOrderInfo(String userId) {
		// TODO Auto-generated method stub
		return ht
				.find("from OrderCarrierView where carrierId='" + userId + "'");
	}

	@Override
	public OrderCarrierView getSendOrderDetail(String id) {
		// TODO Auto-generated method stub
		return ht.get(OrderCarrierView.class, id);
	}

	

	@Override
	public Orderform getRecieveOrderDetail(String id) {
		// TODO Auto-generated method stub
		return ht.get(Orderform.class, id);
	}

	@Override
	/**
	 * 通过订单编号获取某订单id
	 */
	public List getOrderIdByOrderNum(String orderNum) {
		// TODO Auto-generated method stub
		return ht.find("select id from Orderform where orderNum='" + orderNum
				+ "'");
	}

	@Override
	public OrderCarrierView getOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return ht.get(OrderCarrierView.class, orderId);
	}

	@Override
	/**
	 * 承运方修改订单状态为待收货
	 */
	public boolean acceptOrder(String orderId) {
		// TODO Auto-generated method stub
		Orderform order = (Orderform) ht.get(Orderform.class, orderId);
		//System.out.println("orderEntity+" + order);
		order.setState("待收货");// 修改状态

		return baseDao.update(order);

	}

	@Override
	public float getExpectedMoney(String orderId) {
		// TODO Auto-generated method stub
		List list = ht.find("select expectedPrice from Orderform where id='" + orderId + "'");
		if (list != null)
		{
			//Orderform order=(Float)list.get(0);
			return ((Float)list.get(0)).floatValue();
		}
		else
			return 0.0f;
	}

	@Override
	/**
	 * 承运方修改订单状态为待确认
	 */
	public boolean signBill(String orderId,float actualPrice,String explainReason) {
		// TODO Auto-generated method stub
		Orderform order = (Orderform) ht.get(Orderform.class, orderId);
		order.setState("待确认");//修改 订单状态
		order.setActualPrice(actualPrice);
		order.setExplainReason(explainReason);
		return baseDao.update(order);
	}

	@Override
	/**
	 * 返回订单的信息
	 */
	public Orderform getOrderInfo(String orderId) {
		// TODO Auto-generated method stub
		return (Orderform) ht.get(Orderform.class, orderId);
	}

	@Override
	/**
	 * 确认收货操作
	 */
	public boolean confirmCargo(String orderId) {
		// TODO Auto-generated method stub
		Orderform order=ht.get(Orderform.class, orderId);
		order.setState("待评价");
		
		return baseDao.update(order);
	}
	
	
	

}
