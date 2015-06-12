package cn.edu.bjtu.bean.search;

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
	
	private String fromPlace;//对应始发城市，可能与startPlace重复，先保留

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
