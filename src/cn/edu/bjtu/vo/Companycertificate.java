package cn.edu.bjtu.vo;

// Generated 2015-1-31 22:44:34 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author zhai
 */
@Component
public class Companycertificate implements java.io.Serializable {

	private String id;
	private String companyName;
	private String divisionCode;
	private String legalName;
	private String legalIDCard;
	private String companyAddr;
	private String companyType;
	private String companyScale;
	private String invoiceKind;
	private String serviceIndustry;
	private String businessKind;
	private String companyContact;
	private String phone;
	private String basicSituation;
	private String relatedMaterial;
	
	public Companycertificate() {
	}

	public Companycertificate(String id) {
		this.id = id;
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

	public String getDivisionCode() {
		return this.divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public String getLegalName() {
		return this.legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLegalIDCard() {
		return this.legalIDCard;
	}

	public void setLegalIDCard(String legalIDCard) {
		this.legalIDCard = legalIDCard;
	}

	public String getCompanyAddr() {
		return this.companyAddr;
	}

	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	
	public String getCompanyType() {
		return this.companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	
	public String getCompanyScale() {
		return this.companyScale;
	}

	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}

	public String getInvoiceKind() {
		return this.invoiceKind;
	}

	public void setInvoiceKind(String invoiceKind) {
		this.invoiceKind = invoiceKind;
	}

	public String getServiceIndustry() {
		return this.serviceIndustry;
	}

	public void setServiceIndustry(String serviceIndustry) {
		this.serviceIndustry = serviceIndustry;
	}

	
	public String getBusinessKind() {
		return this.businessKind;
	}

	public void setBusinessKind(String businessKind) {
		this.businessKind = businessKind;
	}

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBasicSituation() {
		return basicSituation;
	}

	public void setBasicSituation(String basicSituation) {
		this.basicSituation = basicSituation;
	}
	
	public String getRelatedMaterial() {
		return relatedMaterial;
	}

	public void setRelatedMaterial(String relatedMaterial) {
		this.relatedMaterial = relatedMaterial;
	}

}
