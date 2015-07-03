package cn.edu.bjtu.bean.page;

import java.util.Date;

/**
 * 干线资源page bean 
 * @author RussWest0
 * @date   2015年7月2日 下午9:35:10
 */
public class LinetransportBean {
	private String id;
	private String startPlace;
	private String endPlace;
	private int onWayTime;
	private Float refPrice;
	private Date relDate;
	private String carrierId;
	private String detailPrice;
	private String remarks;
	private String type;
	private String lineName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getOnWayTime() {
		return onWayTime;
	}
	public void setOnWayTime(int onWayTime) {
		this.onWayTime = onWayTime;
	}
	public Float getRefPrice() {
		return refPrice;
	}
	public void setRefPrice(Float refPrice) {
		this.refPrice = refPrice;
	}
	public Date getRelDate() {
		return relDate;
	}
	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getDetailPrice() {
		return detailPrice;
	}
	public void setDetailPrice(String detailPrice) {
		this.detailPrice = detailPrice;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	
	
}
