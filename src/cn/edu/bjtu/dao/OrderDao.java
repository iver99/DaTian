package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

public interface OrderDao {
	
	public List getAllSendOrderInfo(String userId);
	public List getAllRecieveOrderInfo(String userId);
	public OrderCarrierView getSendOrderDetail(String id);
	public Orderform getRecieveOrderDetail(String id);
	public List getOrderIdByOrderNum(String orderNum);
	
	public OrderCarrierView getOrderByOrderId(String orderId);
	
	public boolean acceptOrder(String orderId);
	
	public float getExpectedMoney(String orderId);
	
	public boolean signBill(String orderId,float actualPrice,String explainReason);
	
	public Orderform getOrderInfo(String orderId);
	
	public boolean confirmCargo(String orderId);
}
