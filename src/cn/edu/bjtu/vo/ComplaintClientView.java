package cn.edu.bjtu.vo;


import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ComplaintClientView implements java.io.Serializable {

	private String id;
	private String type;
	private String theme;
	private String content;
	private Date relDate;
	private String state;
	private String orderId;
	private String relatedMaterial;
	private String feedback;
	private String clientId;
	private String carrierId;
	private String realName;

	public ComplaintClientView() {
	}

	public ComplaintClientView(String id) {
		this.id = id;
	}

	public ComplaintClientView(String id, String type, String theme, String content,
			Date relDate, String state, String orderId, String relatedMaterial,
			String feedback, String clientId, String carrierId, String realName) {
		this.id = id;
		this.type = type;
		this.theme = theme;
		this.content = content;
		this.relDate = relDate;
		this.state = state;
		this.orderId = orderId;
		this.relatedMaterial = relatedMaterial;
		this.feedback = feedback;
		this.clientId = clientId;
		this.carrierId = carrierId;
		this.realName = realName;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRelDate() {
		return this.relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getRelatedMaterial() {
		return this.relatedMaterial;
	}

	public void setRelatedMaterial(String relatedMaterial) {
		this.relatedMaterial = relatedMaterial;
	}

	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getCarrierId() {
		return this.carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
}
