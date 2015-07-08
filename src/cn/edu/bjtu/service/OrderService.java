package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.OrderBean;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

import com.alibaba.fastjson.JSONArray;

public interface OrderService {
	@Deprecated
	public List getAllSendOrderInfo(String userId);
	@Deprecated
	public List getAllRecieveOrderInfo(String userId);

	public OrderCarrierView getSendOrderDetail(String id);

	public Orderform getRecieveOrderDetail(String id);

	public Orderform getOrderByOrderNum(String orderNum);

	public OrderCarrierView getOrderByOrderId(String orderId);

	public boolean acceptOrder(String orderId);

	public float getExpectedMoney(String orderId);

	public boolean signBill(String orderId, float actualPrice,
			String explainReason,String path,String fileName);

	public Orderform getOrderInfo(String orderId);

	public boolean confirmCargo(String orderId);

	public boolean cancel(String cancelReason, String orderId);
	/*@Deprecated
	public boolean updateOrder(String orderid, String clientName,
			String hasCarrierContract, String contractId, String goodsName,
			float goodsWeight, float goodsVolume, float declaredPrice,
			float insurance, float expectedPrice, String deliveryName,
			String deliveryPhone, String deliveryAddr, String recieverName,
			String recieverPhone, String recieverAddr, String remarks);
*/
	public boolean DoGetOrderWaitToConfirmUpdate(String orderId,
			float actualPrice, String explainReason,String path,String fileName);
	
/*	@Deprecated
	public boolean createNewOrder(String userId, String hasCarrierContract,
			String deliveryName, String receiverName, String deliveryPhone,
			String receiverPhone, String deliveryAddr, String receiverAddr,
			String remarks, String goodsName, float goodsVolume,
			float goodsWeight, float expectedPrice, float declaredPrice,
			float insurance, String contractId, String carrierId,
			String isLinkToClientWayBill,String clientWayBillNum, 
			String resourceName, String resourceType,String companyName,String clientName);*/

	public List getCargoTrack(String orderNum, String carNum);
	
	/**
	 * 返回用户待受理订单数
	 * @param session
	 * @return
	 */
	public Long getUserWaitToAcceptNum(HttpSession session);
	
	/**
	 * 返回用户待收货订单数
	 * @param session
	 * @return
	 */
	public Long getUserWaitToReceiveNum(HttpSession session);
	
	/**
	 * 返回用户待结算数目 
	 * @param session
	 * @return
	 */
	public Long getUserWaitToSettleNum(HttpSession session);
	
	/**
	 * 返回用户已完成订单数
	 * @param session
	 * @return
	 */
	public Long finishedNum(HttpSession session);
	
	/**
	 * 新建订单
	 * @param session
	 * @param orderBean
	 * @return
	 */
	public boolean createOrder(HttpSession session,OrderBean orderBean);
	
	/**
	 * 更新订单
	 * @param session
	 * @param orderBean
	 * @return
	 */
	public boolean updateOrder(HttpSession session,OrderBean orderBean);
	
	/**
	 * 我提交的订单-总记录数
	 * @param session
	 * @return
	 */
	public Integer getUserSendOrderTotalRows(HttpSession session);
	
	/**
	 *  我提叫的订单
	 * @param session
	 * @return
	 */
	public JSONArray getUserSendOrder(HttpSession session);

	/**
	 * 我收到的订单
	 * @param session
	 * @return
	 */
	public JSONArray getUserRecieveOrder(HttpSession session);
	
	/**
	 * 我收到的订单-总记录是
	 * @param session
	 * @return
	 */
	public Integer getUserRecieveOrderTotalRows(HttpSession session);

}
