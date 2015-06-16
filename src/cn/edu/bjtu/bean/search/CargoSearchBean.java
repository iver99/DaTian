package cn.edu.bjtu.bean.search;

import java.util.Date;

/**
 * 货物筛选pagebean
 * @author RussWest0
 * @date   2015年6月14日 下午11:07:43
 */
public class CargoSearchBean {
	private String id;//货物id
	
	private String startPlace;
	private String endPlace;
	private String weight;//重量
	private String transportType;//运输类型
	private String transportReq;//对应页面上的车型要求在此字段进行模糊查询，高栏，厢式，平板
	
	private String name;//货物名称
	private Date relDate;
	private Date limitDate;
	
	private String status;//关注状态

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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getTransportReq() {
		return transportReq;
	}

	public void setTransportReq(String transportReq) {
		this.transportReq = transportReq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRelDate() {
		return relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
