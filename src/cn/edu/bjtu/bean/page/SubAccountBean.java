package cn.edu.bjtu.bean.page;

import java.util.Date;

/**
 * ∏Ω Ù’Àªßpage bean
 * 
 * @author RussWest0
 * @date   2015ƒÍ7‘¬24»’ œ¬ŒÁ3:20:41
 */
public class SubAccountBean {

	private String id;
	private String hostAccountId;//∏∏’Àªß
	private String hostAccountName;//∏∏’Àªßusername
	private String username;//∏Ω Ù’Àªßusername
	private String password;//∏Ω Ù’Àªß√‹¬Î
	private String resourceManagement;
	private String transactionManagement;
	private String schemaManagement;
	private String statisticsManagement;
	private String remarks;
	private Date relDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getHostAccountId() {
		return hostAccountId;
	}
	public void setHostAccountId(String hostAccountId) {
		this.hostAccountId = hostAccountId;
	}
	public String getHostAccountName() {
		return hostAccountName;
	}
	public void setHostAccountName(String hostAccountName) {
		this.hostAccountName = hostAccountName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRelDate() {
		return relDate;
	}
	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	public String getResourceManagement() {
		return resourceManagement;
	}
	public void setResourceManagement(String resourceManagement) {
		this.resourceManagement = resourceManagement;
	}
	public String getTransactionManagement() {
		return transactionManagement;
	}
	public void setTransactionManagement(String transactionManagement) {
		this.transactionManagement = transactionManagement;
	}
	public String getSchemaManagement() {
		return schemaManagement;
	}
	public void setSchemaManagement(String schemaManagement) {
		this.schemaManagement = schemaManagement;
	}
	public String getStatisticsManagement() {
		return statisticsManagement;
	}
	public void setStatisticsManagement(String statisticsManagement) {
		this.statisticsManagement = statisticsManagement;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
