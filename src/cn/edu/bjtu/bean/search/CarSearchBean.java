package cn.edu.bjtu.bean.search;

import java.util.Date;

/**
 * car筛选pagebean
 * @author RussWest0
 * @date   2015年6月13日 下午3:19:27
 */
public class CarSearchBean {
	private String id;
	private String carrierId;
	private String companyName;
	private String carState; //车辆当前状态
	private String carLocation;//车辆当前位置
	private Date relDate;
	private String carNum;
	private String startPlace;
	private String endPlace;
	private String carBase;
	private Float carLength;
	private Float carWeight;
		
	private String status;//关注状态

	
	
	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getCarState() {
		return carState;
	}

	public void setCarState(String carState) {
		this.carState = carState;
	}

	public String getCarLocation() {
		return carLocation;
	}

	public void setCarLocation(String carLocation) {
		this.carLocation = carLocation;
	}

	public Date getRelDate() {
		return relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCarBase() {
		return carBase;
	}

	public void setCarBase(String carBase) {
		this.carBase = carBase;
	}

	public Float getCarLength() {
		return carLength;
	}

	public void setCarLength(Float carLength) {
		this.carLength = carLength;
	}

	public Float getCarWeight() {
		return carWeight;
	}

	public void setCarWeight(Float carWeight) {
		this.carWeight = carWeight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
