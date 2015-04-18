package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

public interface OrderService {
	
	public List getAllSendOrderInfo(String userId);
	public List getAllRecieveOrderInfo(String userId);
	public OrderCarrierView getSendOrderDetail(String id);
	public Orderform getRecieveOrderDetail(String id);
	public boolean insertOrder(String goodsName,
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
			String contractId,
			String remarks);
	public List getOrderIdByOrderNum(String orderNum);
	
	public OrderCarrierView getOrderByOrderId(String orderId);
	
	public boolean acceptOrder(String orderId);
	
	public float getExpectedMoney(String orderId);
	
	public boolean signBill(String orderId,float actualPrice,String explainReason);
	
	public Orderform getOrderInfo(String orderId);
	
	public boolean confirmCargo(String orderId);
	
	public boolean cancel(String cancelReason, String orderId);
	
	public boolean updateOrder(String orderid, String clientName,
			String hasCarrierContract, String contractId, 
			String goodsName,float goodsWeight,float goodsVolume,
			float declaredPrice,float insurance, float expectedPrice,
			String deliveryName,String deliveryPhone,String deliveryAddr,
			String recieverName,String recieverPhone,String recieverAddr,
			String remarks);
	public boolean DoGetOrderWaitToConfirmUpdate(String orderId,float actualPrice,String explainReason);
	
	public boolean createNewOrder(String userId,String hasCarrierContract,String senderInfo,String receiverInfo,
			String remarks,String goodsName,float goodsVolume,float goodsWeight,float expectedPrice,
			float declaredPrice,float insurance,String contractId,String carrierId);
	
	
}
