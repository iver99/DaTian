package cn.edu.bjtu.bean.page;

import java.util.Date;

/**
 * 订单pagebean
 * @author RussWest0
 * @date   2015年6月12日 下午8:42:48
 */
public class OrderBean {

	private String id;
	private String orderNum;
	private String carrierId;
	//基本信息
	private String clientName;//所属客户
	private String hasCarrierContract;//是否承运方合同
	private String contractId;//承运方合同
	private String isLinkToClientWayBill;//是否关联客户运单
	private String clientWayBillNum;//客户运单号
	private String resourceName;//资源名称
	private String companyName;//承运方名称
	private String resourceType;//资源类型
	
	//add by RussWest0 at 2015年7月8日,下午4:55:33 
	private Date submitTime;
	private String settlementState;
	private Float actualPrice;
	private String clientId;
	private String state;
	
	//备注
	private String remarks;
	
	//货物信息
	private String goodsName;
	private Float goodsWeight;
	private Float goodsVolume;
	private Float declaredPrice;
	private Float expectedPrice;
	private Float insurance;
	//收发货人信息
	private String deliveryAddr;
	private String deliveryName;
	private String deliveryPhone;
	private String recieverAddr;
	private String recieverName;
	private String recieverPhone;
	
	//add by RussWest0 at 2015年6月19日,下午10:46:58 
	// 从货物栏下订单会用到
	private String goodsId;
	private String responseId;
	
	//用于确定是否保存信息为常用地址
	private String reciever_info;
	private String sender_info;
	
	
	
	/**
	 * @return the reciever_info
	 */
	public String getReciever_info() {
		return reciever_info;
	}
	/**
	 * @param reciever_info the reciever_info to set
	 */
	public void setReciever_info(String reciever_info) {
		this.reciever_info = reciever_info;
	}
	/**
	 * @return the sender_info
	 */
	public String getSender_info() {
		return sender_info;
	}
	/**
	 * @param sender_info the sender_info to set
	 */
	public void setSender_info(String sender_info) {
		this.sender_info = sender_info;
	}
	public Date getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	public String getSettlementState() {
		return settlementState;
	}
	public void setSettlementState(String settlementState) {
		this.settlementState = settlementState;
	}
	public Float getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(Float actualPrice) {
		this.actualPrice = actualPrice;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getResponseId() {
		return responseId;
	}
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getIsLinkToClientWayBill() {
		return isLinkToClientWayBill;
	}
	public void setIsLinkToClientWayBill(String isLinkToClientWayBill) {
		this.isLinkToClientWayBill = isLinkToClientWayBill;
	}
	public String getClientWayBillNum() {
		return clientWayBillNum;
	}
	public void setClientWayBillNum(String clientWayBillNum) {
		this.clientWayBillNum = clientWayBillNum;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getHasCarrierContract() {
		return hasCarrierContract;
	}
	public void setHasCarrierContract(String hasCarrierContract) {
		this.hasCarrierContract = hasCarrierContract;
	}
	
	public String getDeliveryAddr() {
		return deliveryAddr;
	}
	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getDeliveryPhone() {
		return deliveryPhone;
	}
	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}
	public String getRecieverAddr() {
		return recieverAddr;
	}
	public void setRecieverAddr(String recieverAddr) {
		this.recieverAddr = recieverAddr;
	}
	public String getRecieverName() {
		return recieverName;
	}
	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
	}
	public String getRecieverPhone() {
		return recieverPhone;
	}
	public void setRecieverPhone(String recieverPhone) {
		this.recieverPhone = recieverPhone;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Float getGoodsWeight() {
		return goodsWeight;
	}
	public void setGoodsWeight(Float goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
	public Float getGoodsVolume() {
		return goodsVolume;
	}
	public void setGoodsVolume(Float goodsVolume) {
		this.goodsVolume = goodsVolume;
	}
	public Float getDeclaredPrice() {
		return declaredPrice;
	}
	public void setDeclaredPrice(Float declaredPrice) {
		this.declaredPrice = declaredPrice;
	}
	public Float getExpectedPrice() {
		return expectedPrice;
	}
	public void setExpectedPrice(Float expectedPrice) {
		this.expectedPrice = expectedPrice;
	}
	public Float getInsurance() {
		return insurance;
	}
	public void setInsurance(Float insurance) {
		this.insurance = insurance;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	
}
