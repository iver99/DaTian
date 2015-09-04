package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface SettlementService {
	


	public List getOrderStatement(String orderNum);
	
	/**
	 * 返回用户 已结算金额/待结算金额flag=0已结算  flag=1待结算
	 * @param session
	 */
	public  Float getUserSettlementMoney(HttpSession session,int flag);
	
	
	
	
}
