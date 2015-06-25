package cn.edu.bjtu.vo;

import java.util.Date;

import org.springframework.stereotype.Component;
/**
 * settlement vo
 * @author RussWest0
 * @date   2015年6月20日 下午12:50:56
 */
@Component
public class Settlement {
	private String id;
	private String orderNum;
	private String userId;
	private String username;
	private Date createTime;
	private String orderId;//add by RussWest0 at 2015年6月25日,下午9:37:50 
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
