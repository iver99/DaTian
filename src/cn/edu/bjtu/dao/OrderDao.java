package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

public interface OrderDao extends BaseDao<Orderform> {
	
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
	
	public boolean cancel(String cancelReason,String orderId);
	
	public boolean DoGetOrderWaitToConfirmUpdate(String orderId,float actualPrice,String explainReason);

	public boolean createNewOrder(String userId,String hasCarrierContract,String remarks,
			String goodsName,float goodsVolume,float goodsWeight,float expectedPrice,
			float declaredPrice,float insurance,String contractId,String deliveryName,
			String deliveryPhone,String deliveryAddr,String receiverName,String receiverPhone,
			String receiverAddr,String carrierId);
	
	
	
}
