package cn.edu.bjtu.bean.search;

import java.util.Date;

/**
 * 干线资搜索bean
 * @author RussWest0
 * @date   2015年6月9日 下午10:49:10
 */
public class LinetransportSearchBean {

	private String startPlace;//起止城市
	private String endPlace;//起止城市
	private String transportType;//运输类型
	private String refPrice;//参考报价
	private String id;//干线id
	private String fromPlace;//对应始发城市，可能与startPlace重复，先保留
	private Date relDate;
	private String status;//关注状态
	private String companyName;//公司名称
	private Integer onWayTime;//时长 
	private String lineName;//资源名称
	private String carrierId;//承运方id
	/* "select t1.id,"
		+ "t1.carrierId,"
		+ "t1.lineName,"
		+ "t1.startPlace,"
		+ "t1.endPlace,"
		+ "t1.refPrice,"
		+ "t1.relDate,"
		+ "t1.type,"
		+ "t1.onWayTime,"
		+ "t3.status "
		+ " from line_carrier_view t1 "*/
	
	
	
	public String getStartPlace() {
		return startPlace;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRelDate() {
		return relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	

	public Integer getOnWayTime() {
		return onWayTime;
	}

	public void setOnWayTime(Integer onWayTime) {
		this.onWayTime = onWayTime;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
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

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getRefPrice() {
		return refPrice;
	}

	public void setRefPrice(String refPrice) {
		this.refPrice = refPrice;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	
	
	
}
