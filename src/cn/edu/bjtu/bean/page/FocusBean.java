package cn.edu.bjtu.bean.page;

import java.util.Date;
/**
 * 关注page bean
 * @ClassName: FocusBean 
 * @author chendonghao 
 * @date 2015年7月6日 下午12:36:42
 */
public class FocusBean {
	private String id;
	private String clientId;
	private String focusType;
	private String resourceId;//资源的id，对应vo类的focusId
	private String status;//关注的状态
	private String startPlace;//干线
	private String endPlace;//干线
	private String lineName;//干线名称
	private String carrierId;
	private String companyName;//公司名字
	private Date relDate;
	private String name;//城市配送的name,或者仓库 name，或者货物名
	private String carNum;//车牌
	
	
	
	private String search_content;//供搜索使用 
	
	
	
	public String getSearch_content() {
		return search_content;
	}
	public void setSearch_content(String search_content) {
		this.search_content = search_content;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getFocusType() {
		return focusType;
	}
	public void setFocusType(String focusType) {
		this.focusType = focusType;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getEndPlace() {
		return endPlace;
	}
	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getRelDate() {
		return relDate;
	}
	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	
	
	
}
