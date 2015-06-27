package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface SettlementService {
	

	/**
	 * 结算页面的查询
	 * @param carrierId
	 * @param name
	 * @param display
	 * @param pageNow
	 * @return
	 */
	public List getFindSettlement(String carrierId, String name, int display, int pageNow);
	
	/*public int getFindSettlementTotalRows(String carrierId, String name, int display, int pageNow);*/

	public List getOrderStatement(String orderNum);
	
	/**
	 * 返回用户 已结算金额/待结算金额flag=0已结算  flag=1待结算
	 * @param session
	 */
	public  Float getUserSettlementMoney(HttpSession session,int flag);
	
	/**
	 * 获取结算list
	 * @param session
	 * @return
	 */
	public List getUserSettlementList(HttpSession session);
	
	
	
}
