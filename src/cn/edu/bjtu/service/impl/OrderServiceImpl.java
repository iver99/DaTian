package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

/**
 * 
 * @author RussWest0
 *
 */
@Repository
public class OrderServiceImpl implements OrderService {

	@Resource
	OrderDao orderDao;
	@Resource
	Orderform orderform;
	@Resource
	BaseDao baseDao;

	@Override
	public List getAllSendOrderInfo(String userId) {
		// TODO Auto-generated method stub
		return orderDao.getAllSendOrderInfo(userId);
	}

	@Override
	public List getAllRecieveOrderInfo(String userId) {
		// TODO Auto-generated method stub
		return orderDao.getAllRecieveOrderInfo(userId);
	}

	@Override
	public OrderCarrierView getSendOrderDetail(String id) {
		// TODO Auto-generated method stub
		return orderDao.getSendOrderDetail(id);
	}

	@Override
	public Orderform getRecieveOrderDetail(String id) {
		// TODO Auto-generated method stub
		return orderDao.getRecieveOrderDetail(id);
	}

	@Override
	public boolean insertOrder(String goodsName, String contactWaybill,
			String deliveryAddr, String recieverAddr, String deliveryName,
			String deliveryPhone, String recieverName, String recieverPhone,
			float goodsWeight, float goodsVolume, float expectedPrice,
			float insurance, float freight, String contractId, String remarks) {
		// TODO Auto-generated method stub
		System.out.println("insertOrder");
		orderform.setId(IdCreator.createlineTransportId());
		orderform.setGoodsName(goodsName);
		// orderform.setContactWaybill(contactWaybill);
		orderform.setDeliveryAddr(deliveryAddr);
		orderform.setRecieverAddr(recieverAddr);
		orderform.setDeliveryName(deliveryName);
		orderform.setDeliveryPhone(deliveryPhone);
		orderform.setRecieverName(recieverName);
		orderform.setRecieverPhone(recieverPhone);
		orderform.setGoodsWeight(goodsWeight);
		orderform.setGoodsVolume(goodsVolume);
		orderform.setExpectedPrice(expectedPrice);
		orderform.setInsurance(insurance);
		// orderform.setFreight(freight);
		orderform.setContractId(contractId);
		orderform.setRemarks(remarks);

		return baseDao.save(orderform);// 保存实体

	}

	@Override
	public List getOrderIdByOrderNum(String orderNum) {
		// TODO Auto-generated method stub
		return orderDao.getOrderIdByOrderNum(orderNum);
	}

	@Override
	public OrderCarrierView getOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByOrderId(orderId);
	}

	@Override
	public boolean acceptOrder(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.acceptOrder(orderId);
	}

	@Override
	/**
	 * 返回预期运费
	 */
	public float getExpectedMoney(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.getExpectedMoney(orderId);
	}

	@Override
	public boolean signBill(String orderId, float actualPrice,
			String explainReason) {
		// TODO Auto-generated method stub
		return orderDao.signBill(orderId, actualPrice, explainReason);
	}

	@Override
	public Orderform getOrderInfo(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrderInfo(orderId);
	}

	@Override
	public boolean confirmCargo(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.confirmCargo(orderId);
	}

	@Override
	public boolean cancel(String cancelReason, String orderId) {
		// TODO Auto-generated method stub
		return orderDao.cancel(cancelReason, orderId);
	}

	@Override
	public boolean updateOrder(String orderid, String clientName,
			String hasCarrierContract, String contractId, String goodsName,
			float goodsWeight, float goodsVolume, float declaredPrice,
			float insurance, float expectedPrice, String deliveryName,
			String deliveryPhone, String deliveryAddr, String recieverName,
			String recieverPhone, String recieverAddr, String remarks) {
		orderform = getOrderInfo(orderid);
		orderform.setClientName(clientName);
		orderform.setHasCarrierContract(hasCarrierContract);
		orderform.setContractId(contractId);
		orderform.setGoodsName(goodsName);
		orderform.setGoodsWeight(goodsWeight);
		orderform.setGoodsVolume(goodsVolume);
		orderform.setDeclaredPrice(declaredPrice);
		orderform.setInsurance(insurance);
		orderform.setExpectedPrice(expectedPrice);
		orderform.setDeliveryName(deliveryName);
		orderform.setDeliveryPhone(deliveryPhone);
		orderform.setDeliveryAddr(deliveryAddr);
		orderform.setRecieverName(recieverName);
		orderform.setRecieverPhone(recieverPhone);
		orderform.setRecieverAddr(recieverAddr);
		orderform.setRemarks(remarks);
		return baseDao.update(orderform);

	}

	@Override
	public boolean DoGetOrderWaitToConfirmUpdate(String orderId,
			float actualPrice, String explainReason) {
		// TODO Auto-generated method stub
		return orderDao.signBill(orderId, actualPrice, explainReason);
	}

	@Override
	public boolean createNewOrder(String userId, String hasCarrierContract,
			String senderInfo, String receiverInfo, String remarks,
			String goodsName, float goodsVolume, float goodsWeight,
			float expectedPrice, float declaredPrice, float insurance,
			String contractId,String carrierId) {
		// TODO Auto-generated method stub
		// 解析字符串
		String[] se = senderInfo.split("/");
		String[] re = receiverInfo.split("/");
		String deliveryName = se[0];
		String deliveryPhone = se[1];
		String deliveryAddr = se[2];
		String receiverName = re[0];
		String receiverPhone = re[1];
		String receiverAddr = re[2];

		return orderDao.createNewOrder(userId, hasCarrierContract, remarks, goodsName,
				goodsVolume, goodsWeight, expectedPrice, declaredPrice,
				insurance, contractId, deliveryName, deliveryPhone,
				deliveryAddr, receiverName, receiverPhone, receiverAddr,carrierId);

	}

}
