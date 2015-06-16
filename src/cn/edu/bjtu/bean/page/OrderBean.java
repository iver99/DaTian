package cn.edu.bjtu.bean.page;
/**
 * 订单pagebean
 * @author RussWest0
 * @date   2015年6月12日 下午8:42:48
 */
public class OrderBean {

	/**
	 * 创建新订单
	 * @param clientName
	 * @param hasCarrierContract
	 * @param senderInfo
	 * @param receiverInfo
	 * @param remarks
	 * @param goodsName
	 * @param goodsWeight
	 * @param goodsVolume
	 * @param declaredPrice
	 * @param expectedPrice
	 * @param insurance
	 * @param contractId
	 * @param request
	 * @param response
	 * @return
	 */
	private String clientName;
	private String hasCarrierContract;
	private String senderInfo;
	private String receiverInfo;
	private String remarks;
	private String goodsName;
	private Float goodsWeight;
	private Float goodsVolume;
	private Float declaredPrice;
	private Float expectedPrice;
	private Float insurance;
	private String contractId;
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
	public String getSenderInfo() {
		return senderInfo;
	}
	public void setSenderInfo(String senderInfo) {
		this.senderInfo = senderInfo;
	}
	public String getReceiverInfo() {
		return receiverInfo;
	}
	public void setReceiverInfo(String receiverInfo) {
		this.receiverInfo = receiverInfo;
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
