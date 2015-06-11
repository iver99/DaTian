package cn.edu.bjtu.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Response {
	
	private String id;
	private String phone;
	private String committer;
	private String clientId;
	private String carrierId;
	private String goodsId;
	private String remarks;
	private String relatedMaterial;
	private Date relDate;
	
	// add by RussWest0 at 2015年6月4日,下午9:48:49 
	private String status;
	
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRelDate() {
		return relDate;
	}
	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	public String getRelatedMaterial() {
		return relatedMaterial;
	}
	public void setRelatedMaterial(String relatedMaterial) {
		this.relatedMaterial = relatedMaterial;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCommitter() {
		return committer;
	}
	public void setCommitter(String committer) {
		this.committer = committer;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

}
