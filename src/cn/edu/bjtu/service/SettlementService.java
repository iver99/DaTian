package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface SettlementService {
	
	public List getUserSettlementList(String userId);

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
	
	
}
