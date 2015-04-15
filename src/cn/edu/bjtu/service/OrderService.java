package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

public interface OrderService {
	
	public List getAllSendOrderInfo(String userId);
	public List getAllRecieveOrderInfo(String userId);
	public OrderCarrierView getSendOrderDetail(String id);
	public Orderform getRecieveOrderDetail(String id);
	/*public boolean insertOrder(String goodsName,
			String contactWaybill,
			String deliveryAddr,
			String recieverAddr,
			String deliveryName,
			String deliveryPhone,
			String recieverName,
			String recieverPhone,
			float goodsWeight,
			float goodsVolume,
			float expectedPrice,
			float insurance,
			float freight,
			String contractNum,
			String remarks);*/
	public List getOrderIdByOrderNum(String orderNum);
	
	public OrderCarrierView getOrderByOrderId(String orderId);
	
	public boolean acceptOrder(String orderId);
	
	public float getExpectedMoney(String orderId);
	
	public boolean signBill(String orderId,float actualPrice,String explainReason);
	
	public Orderform getOrderInfo(String orderId);
	
	public boolean confirmCargo(String orderId);
}
