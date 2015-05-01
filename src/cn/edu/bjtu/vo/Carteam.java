package cn.edu.bjtu.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Carteam {

	private String id;
	private String teamName;
	private String carCount;
	private String chief;
	private String phone;
	private Date relDate;
	private String explaination;
	private String carrierId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getCarCount() {
		return carCount;
	}
	public void setCarCount(String carCount) {
		this.carCount = carCount;
	}
	public String getChief() {
		return chief;
	}
	public void setChief(String chief) {
		this.chief = chief;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getRelDate() {
		return relDate;
	}
	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	public String getExplaination() {
		return explaination;
	}
	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
}
