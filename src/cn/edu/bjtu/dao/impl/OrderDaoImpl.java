package cn.edu.bjtu.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.OrderCarrierViewDao;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

@Repository
public class OrderDaoImpl extends BaseDaoImpl<Orderform> implements OrderDao {

	@Autowired
	OrderCarrierViewDao orderCarrierViewDao;
	
	@Override
	public OrderCarrierView getSendOrderDetail(String id) {
		
		return orderCarrierViewDao.get(OrderCarrierView.class, id);
	}

	@Override
	public Orderform getRecieveOrderDetail(String id) {
		
		return this.get(Orderform.class, id);
	}
	

	@Override
	/**
	 * 通过订单编号获取某订单id
	 */
	public Orderform getOrderByOrderNum(String orderNum) {
		
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("orderNum", orderNum);
		return this.get("from Orderform where orderNum=:orderNum",params);
	}

	@Override
	public OrderCarrierView getOrderByOrderId(String orderId) {
		
		return orderCarrierViewDao.get(OrderCarrierView.class, orderId);
	}

	@Override
	/**
	 * 承运方修改订单状态为待收货
	 */
	public boolean acceptOrder(String orderId) {
		
		Orderform order = this.get(Orderform.class, orderId);
		order.setState("待收货");// 修改状态

		this.update(order);
		return true;

	}

	@Override
	public float getExpectedMoney(String orderId) {
		
		List list = this.find("select expectedPrice from Orderform where id='" + orderId + "'");
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
	 * 返回订单的信息
	 */
	public Orderform getOrderInfo(String orderId) {
		
		return this.get(Orderform.class, orderId);
	}

	@Override
	/**
	 * 确认收货操作
	 */
	public boolean confirmCargo(String orderId) {
		
		Orderform order=this.get(Orderform.class, orderId);
		order.setState("待评价");
		
		this.update(order);
		return true;
	}
	
	@Override
	/**
	 * 取消订单操作
	 */
	public boolean cancel(String cancelReason, String orderId) {
		
		Orderform order=this.get(Orderform.class, orderId);
		order.setCancelReason(cancelReason);
		order.setState("已取消");
		
		this.update(order);
		return true;
	}
	
	@Override
	/**
	 * 承运方更新待确认订单
	 */
	public boolean DoGetOrderWaitToConfirmUpdate(String orderId,float actualPrice,String explainReason) {
		
		Orderform order = this.get(Orderform.class, orderId);
		order.setActualPrice(actualPrice);
		order.setExplainReason(explainReason);
		this.update(order);
		return true;
	}

	@Override
	public boolean createNewOrder(String userId, String hasCarrierContract,
			String remarks, String goodsName, float goodsVolume,
			float goodsWeight, float expectedPrice, float declaredPrice,
			float insurance, String contractId, String deliveryName,
			String deliveryPhone, String deliveryAddr, String receiverName,
			String receiverPhone, String receiverAddr, String carrierId,
			String isLinkToClientWayBill, String clientWayBillNum,
			String resourceName, String resourceType, String companyName,String clientName) {
		
		Orderform order=new Orderform();
		order.setClientId(userId);
		order.setHasCarrierContract(hasCarrierContract);
		order.setRemarks(remarks);
		order.setGoodsName(goodsName);
		order.setGoodsVolume(goodsVolume);
		order.setGoodsWeight(goodsWeight);
		order.setExpectedPrice(expectedPrice);
		order.setDeclaredPrice(declaredPrice);
		order.setInsurance(insurance);
		order.setContractId(contractId);
		order.setDeliveryAddr(deliveryAddr);
		order.setDeliveryName(deliveryName);
		order.setDeliveryPhone(deliveryPhone);
		order.setRecieverAddr(receiverAddr);
		order.setRecieverName(receiverName);
		order.setRecieverPhone(receiverPhone);
		// add by RussWest0 at 2015年6月1日,上午12:46:08 
		order.setIsLinkToClientWayBill(isLinkToClientWayBill);
		order.setClientWayBillNum(clientWayBillNum);
		order.setResourceName(resourceName);
		order.setResourceType(resourceType);
		
		
		order.setSubmitTime(new Date());
		order.setId(IdCreator.createOrderId());
		order.setOrderNum(IdCreator.createOrderNum());
		order.setCarrierId(carrierId);
		order.setSettlementState("未生成");// add by RussWest0 at 2015年6月4日,下午8:40:27 
		order.setClientName(clientName);
		//order.setResourceType(resourceType);
		order.setState("待受理");//订单状态
		order.setCompanyName(companyName);
		
		this.save(order);
		return true;
		
	}
	

	
}
