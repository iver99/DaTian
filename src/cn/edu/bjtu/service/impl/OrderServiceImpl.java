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
		
		return orderDao.getAllSendOrderInfo(userId);
	}

	@Override
	public List getAllRecieveOrderInfo(String userId) {
		
		return orderDao.getAllRecieveOrderInfo(userId);
	}

	@Override
	public OrderCarrierView getSendOrderDetail(String id) {
		
		return orderDao.getSendOrderDetail(id);
	}

	@Override
	public Orderform getRecieveOrderDetail(String id) {
		
		return orderDao.getRecieveOrderDetail(id);
	}

	@Override
	public List getCargoTrack(String orderNum, String carNum) {
		
		return orderDao.getCargoTrack(orderNum, carNum);
	}


	@Override
	public Orderform getOrderByOrderNum(String orderNum) {
		return orderDao.getOrderByOrderNum(orderNum);
	}

	@Override
	public OrderCarrierView getOrderByOrderId(String orderId) {
		
		return orderDao.getOrderByOrderId(orderId);
	}

	@Override
	public boolean acceptOrder(String orderId) {
		
		return orderDao.acceptOrder(orderId);
	}

	@Override
	/**
	 * 返回预期运费
	 */
	public float getExpectedMoney(String orderId) {
		
		return orderDao.getExpectedMoney(orderId);
	}

	@Override
	public boolean signBill(String orderId, float actualPrice,
			String explainReason,String path,String fileName) {
		
		
		return orderDao.signBill(orderId, actualPrice, explainReason,path,fileName);
	}

	@Override
	public Orderform getOrderInfo(String orderId) {
		
		return orderDao.getOrderInfo(orderId);
	}

	@Override
	public boolean confirmCargo(String orderId) {
		
		return orderDao.confirmCargo(orderId);
	}

	@Override
	public boolean cancel(String cancelReason, String orderId) {
		
		return orderDao.cancel(cancelReason, orderId);
	}

	/*@Override
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

	}*/
	

	@Override
	public boolean DoGetOrderWaitToConfirmUpdate(String orderId,
			float actualPrice, String explainReason,String path,String fileName) {
		
		return orderDao.signBill(orderId, actualPrice, explainReason,path,fileName);
	}

	/**
	 * 更新订单
	 */
	@Override
	public boolean updateOrder(HttpSession session, OrderBean orderBean) {
//		String userId=(String)session.getAttribute(Constant.USER_ID);
		Orderform orderInstance=orderDao.get(Orderform.class,orderBean.getId());

		orderInstance.setClientName(orderBean.getClientName());
		orderInstance.setIsLinkToClientWayBill(orderBean.getIsLinkToClientWayBill());
		orderInstance.setClientWayBillNum(orderBean.getClientWayBillNum());
		orderInstance.setContractId(orderBean.getContractId());
		orderInstance.setHasCarrierContract(orderBean.getHasCarrierContract());
		
		orderInstance.setGoodsName(orderBean.getGoodsName());
		orderInstance.setGoodsVolume(orderBean.getGoodsVolume());
		orderInstance.setGoodsWeight(orderBean.getGoodsWeight());
		orderInstance.setDeclaredPrice(orderBean.getDeclaredPrice());
		orderInstance.setInsurance(orderBean.getInsurance());
		orderInstance.setExpectedPrice(orderBean.getExpectedPrice());
		
		orderInstance.setDeliveryAddr(orderBean.getDeliveryAddr());
		orderInstance.setDeliveryName(orderBean.getDeliveryName());
		orderInstance.setDeliveryPhone(orderBean.getDeliveryPhone());
		orderInstance.setRecieverAddr(orderBean.getRecieverAddr());
		orderInstance.setRecieverName(orderBean.getRecieverName());
		orderInstance.setRecieverPhone(orderBean.getRecieverPhone());
		
		orderInstance.setRemarks(orderBean.getRemarks());
		
		orderDao.update(orderInstance);
		
		return true;
		
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
		orderInstance.setSettlementState("未生成");
		
		orderDao.save(orderInstance);
		
		return true;
	}

	/**
	 * 返回用户待受理订单数
	 */
	@Override
	public Long getUserWaitToAcceptNum(HttpSession session) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Orderform t "+whereSql(session,params)+" and t.state='待受理'";
		Long count= orderDao.count(hql, params);
		return count==null?0L:count;
		
	}

	/**
	 * 返回用户待接收订单数
	 */
	@Override
	public Long getUserWaitToReceiveNum(HttpSession session) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Orderform t "+whereSql(session,params)+" and t.state='待收货'";
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
		String hql="select count(*) from Orderform t "+whereSql(session,params)+" and  t.state='已完成'";
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
