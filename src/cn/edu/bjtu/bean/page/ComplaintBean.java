package cn.edu.bjtu.bean.page;

import java.util.Date;

/**
 * 投诉功能的页面Bean
 * @author RussWest0
 * @date   2015年6月9日 下午11:01:47
 */
public class ComplaintBean {
	
	/**
	 * 说明：
	 * 此包下的类都是page Bean，供页面上显示或者页面向后台传参数使用（写在控制器的方法参数里），
	 * 里面的属性可以不是一张表的内容，注意和vo包下的类区分（vo包的类必须和表一一对应）
	 */
	
	private String type;
	private String theme;
	private String content;
	private String orderId;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
	

}
