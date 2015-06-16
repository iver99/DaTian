package cn.edu.bjtu.bean.search;

import java.util.Date;

/**
 * 公司筛选pagebean
 * @author RussWest0
 * @date   2015年6月15日 下午8:23:37
 */
public class CompanySearchBean {
	private String id;
	//以下两个字段用于筛选页城市的模糊查询
	private String companyName;
	private String companyAddr;
	
	private String resourceRate;
	private String serviceIndustry;
	private String creditRate;
	private String companyKind;
	private Date relDate;
	
	private String city;//对应页面上筛选条件的城市
	private String serviceKind;//业务种类,对应资源栏页面上对应的业务种类
	
	private String status;//关注状态

	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddr() {
		return companyAddr;
	}

	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}

	public String getResourceRate() {
		return resourceRate;
	}

	public void setResourceRate(String resourceRate) {
		this.resourceRate = resourceRate;
	}

	public String getServiceIndustry() {
		return serviceIndustry;
	}

	public void setServiceIndustry(String serviceIndustry) {
		this.serviceIndustry = serviceIndustry;
	}

	public String getCreditRate() {
		return creditRate;
	}

	public void setCreditRate(String creditRate) {
		this.creditRate = creditRate;
	}

	public String getCompanyKind() {
		return companyKind;
	}

	public void setCompanyKind(String companyKind) {
		this.companyKind = companyKind;
	}

	

	public Date getRelDate() {
		return relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public String getServiceKind() {
		return serviceKind;
	}

	public void setServiceKind(String serviceKind) {
		this.serviceKind = serviceKind;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
