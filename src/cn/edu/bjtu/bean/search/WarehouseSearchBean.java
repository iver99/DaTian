package cn.edu.bjtu.bean.search;

import java.util.Date;

/**
 *  仓库筛选pagebean
 *  
 * @author RussWest0
 * @date   2015年6月13日 下午4:13:23
 */
public class WarehouseSearchBean {
	
	private String id;
	private String carrierId;
	private String city;
	private String type;//仓库类型
//	private String kind;
	private String storageForm;//保管心态
	private String houseArea;//仓库面积 
	private String status;//关注状态  
	
	private String name;
	private String companyName;
	private String fireRate;
	private Date relDate;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getFireRate() {
		return fireRate;
	}


	public void setFireRate(String fireRate) {
		this.fireRate = fireRate;
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStorageForm() {
		return storageForm;
	}


	public void setStorageForm(String storageForm) {
		this.storageForm = storageForm;
	}
	public String getHouseArea() {
		return houseArea;
	}


	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
