package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.OrderBean;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

/**
 * 
 * @author RussWest0
 *
 */
@Transactional
@Repository
public class OrderServiceImpl implements OrderService {

	@Resource
	OrderDao orderDao;
	@Resource
	Orderform orderform;

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
	public List getCargoTrack(String orderNum, String carNum) {
		// TODO Auto-generated method stub
		return orderDao.getCargoTrack(orderNum, carNum);
	}


	@Override
	public Orderform getOrderByOrderNum(String orderNum) {
		return orderDao.getOrderByOrderNum(orderNum);
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
			String explainReason,String path,String fileName) {
		// TODO Auto-generated method stub
		
		return orderDao.signBill(orderId, actualPrice, explainReason,path,fileName);
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
	@Deprecated
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
		orderDao.update(orderform);
		return true;

	}

	@Override
	public boolean DoGetOrderWaitToConfirmUpdate(String orderId,
			float actualPrice, String explainReason,String path,String fileName) {
		// TODO Auto-generated method stub
		return orderDao.signBill(orderId, actualPrice, explainReason,path,fileName);
	}

	@Override
	public boolean createNewOrder(String userId, String hasCarrierContract,
			String deliveryName, String receiverName, String deliveryPhone,
			String receiverPhone, String deliveryAddr, String receiverAddr,
			String remarks, String goodsName, float goodsVolume,
			float goodsWeight, float expectedPrice, float declaredPrice,
			float insurance, String contractId, String carrierId,
			String isLinkToClientWayBill, String clientWayBillNum,
			String resourceName, String resourceType, String companyName,String clientName) {
		// TODO Auto-generated method stub
		String[] temp = { "无", " " };// 默认情况
		clientWayBillNum="";
		if (isLinkToClientWayBill.contains(",")) {//没有关联客户账单，进来的字符串是"无," 
			temp = isLinkToClientWayBill.split(",");
			if (temp.length == 2) {//有关联客户运单
				clientWayBillNum = temp[1];
			}
		} 

		return orderDao.createNewOrder(userId, hasCarrierContract, remarks,
				goodsName, goodsVolume, goodsWeight, expectedPrice,
				declaredPrice, insurance, contractId, deliveryName,
				deliveryPhone, deliveryAddr, receiverName, receiverPhone,
				receiverAddr, carrierId, temp[0], clientWayBillNum, resourceName,
				resourceType,companyName,clientName);

	}
	
	
	/**
	 * 新建订单
	 */
	@Override
	public boolean createOrder(HttpSession session, OrderBean orderBean) {

		String userId=(String)session.getAttribute(Constant.USER_ID);
		Orderform orderInstance=new Orderform();
		BeanUtils.copyProperties(orderBean, orderInstance);
		orderInstance.setId(IdCreator.createOrderId());
		orderInstance.setOrderNum(IdCreator.createOrderNum());
		orderInstance.setState("待受理");
		orderInstance.setSubmitTime(new Date());
		orderInstance.setClientId(userId);
		
		orderDao.save(orderInstance);
		
		return true;
	}

	/**
	 * 返回用户待受理订单数
	 */
	@Override
	public Long getUserWaitToAcceptNum(HttpSession session) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Orderform t "+whereSql(session,params)+" and t.state='待受理'";
		Long count= orderDao.count(hql, params);
		return count==null?0L:count;
		
	}

	/**
	 * 返回用户待接收订单数
	 */
	@Override
	public Long getUserWaitToReceiveNum(HttpSession session) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Orderform t "+whereSql(session,params)+" and t.state='待收货'";
		Long count =orderDao.count(hql, params);
		return count==null?0L:count;
	}

	/**
	 * 返回用户待结算订单数
	 */
	@Override
	public Long getUserWaitToSettleNum(HttpSession session) {
		/*String hql="from Orderform t where t.state=''";
		Map<String,Object> params=new HashMap<String,Object>();
		return orderDao.count(hql+whereSql(session,params), params);*/
		return 0L;
	}

	/**
	 * 返回用户已完成订单数
	 */
	@Override
	public Long finishedNum(HttpSession session) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Orderform t "+whereSql(session,params)+" and  t.state='已完成'";
		Long count =orderDao.count(hql, params);
		return count==null?0L:count;
	}
	
	/**
	 * where sql 
	 * @param session
	 * @param params
	 * @return
	 */
	private String whereSql(HttpSession session,Map<String,Object> params){
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String wheresql=" where 1=1 ";
		if(userKind==2){//个人用户
			wheresql+=" and t.clientId=:clientId ";
			params.put("clientId", userId);
		}else if(userKind==3){//企业用户
			wheresql+=" and t.carrierId=:carrierId ";
			params.put("carrierId", userId);
		}
		
		return wheresql;
		
	}
	
	

}
