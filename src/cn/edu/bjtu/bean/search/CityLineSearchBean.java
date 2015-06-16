package cn.edu.bjtu.bean.search;

import java.util.Date;

/**
 * 资源栏城市配送筛选pagebean
 * @author RussWest0
 * @date   2015年6月13日 下午1:34:38
 */
public class CityLineSearchBean {

	private String id;
	private String cityName;//城市名称
	private String refPrice;
	private String companyName;
	private String VIPService;//增值服务
	private Integer creditRate;//信用等级
	private Date relDate;
	private String status;//关注状态
	private String name;//资源名称
	private String carrierId;//承运方id
	
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getRefPrice() {
		return refPrice;
	}
	public void setRefPrice(String refPrice) {
		this.refPrice = refPrice;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getVIPService() {
		return VIPService;
	}
	public void setVIPService(String vIPService) {
		VIPService = vIPService;
	}
	
	public Integer getCreditRate() {
		return creditRate;
	}
	public void setCreditRate(Integer creditRate) {
		this.creditRate = creditRate;
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
	
	
}
