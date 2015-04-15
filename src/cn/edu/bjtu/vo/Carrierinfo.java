package cn.edu.bjtu.vo;

// Generated 2015-1-31 22:44:34 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * Carrierinfo generated by hbm2java
 */
@Component
public class Carrierinfo implements java.io.Serializable {

	private String id;
	private String companyName;
	private String companyAccount;
	private String resourceRate;
	private Integer creditRate;
	private Integer depositCondition;
	private String invoiceKind;
	private String companyAddr;
	private String companyScale;
	private String serviceIndustry;
	private String companyType;
	private Date relDate;
	private String remarks;
	private String line;
	private String city;
	private String warehouse;
	private String phone;

	public String getCompanyAccount() {
		return companyAccount;
	}

	public void setCompanyAccount(String companyAccount) {
		this.companyAccount = companyAccount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Carrierinfo() {
	}

	public Carrierinfo(String id) {
		this.id = id;
	}

	

	public Carrierinfo(String id, String companyName, String companyAccount,
			String resourceRate, Integer creditRate, Integer depositCondition,
			String invoiceKind, String companyAddr, String companyScale,
			String serviceIndustry, String companyType, Date relDate,
			String remarks, String line, String city, String warehouse,
			String phone) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.companyAccount = companyAccount;
		this.resourceRate = resourceRate;
		this.creditRate = creditRate;
		this.depositCondition = depositCondition;
		this.invoiceKind = invoiceKind;
		this.companyAddr = companyAddr;
		this.companyScale = companyScale;
		this.serviceIndustry = serviceIndustry;
		this.companyType = companyType;
		this.relDate = relDate;
		this.remarks = remarks;
		this.line = line;
		this.city = city;
		this.warehouse = warehouse;
		this.phone = phone;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getResourceRate() {
		return this.resourceRate;
	}

	public void setResourceRate(String resourceRate) {
		this.resourceRate = resourceRate;
	}

	public Integer getCreditRate() {
		return this.creditRate;
	}

	public void setCreditRate(Integer creditRate) {
		this.creditRate = creditRate;
	}

	public Integer getDepositCondition() {
		return this.depositCondition;
	}

	public void setDepositCondition(Integer depositCondition) {
		this.depositCondition = depositCondition;
	}

	public String getInvoiceKind() {
		return this.invoiceKind;
	}

	public void setInvoiceKind(String invoiceKind) {
		this.invoiceKind = invoiceKind;
	}

	public String getCompanyAddr() {
		return this.companyAddr;
	}

	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}

	public String getCompanyScale() {
		return this.companyScale;
	}

	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}

	public String getServiceIndustry() {
		return this.serviceIndustry;
	}

	public void setServiceIndustry(String serviceIndustry) {
		this.serviceIndustry = serviceIndustry;
	}

	public String getCompanyType() {
		return this.companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public Date getRelDate() {
		return this.relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getLine() {
		return this.line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

}
