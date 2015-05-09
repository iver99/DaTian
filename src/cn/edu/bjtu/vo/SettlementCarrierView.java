package cn.edu.bjtu.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
/**
 * 结算功能视图vo
 * @author RussWest0
 *
 */
public class SettlementCarrierView {
	
	private String orderNum;
	private String clientName;
	private String contractId;
	private Date submitTime;
	private String settlementState;
	private float actualPrice;
	private float expectedPrice;
	private String carrierId;
	
	private String id;
	private String companyName;
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
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
	public float getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(float actualPrice) {
		this.actualPrice = actualPrice;
	}
	public float getExpectedPrice() {
		return expectedPrice;
	}
	public void setExpectedPrice(float expectedPrice) {
		this.expectedPrice = expectedPrice;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
