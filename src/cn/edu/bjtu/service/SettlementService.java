package cn.edu.bjtu.service;

import java.util.List;

public interface SettlementService {
	
	public List getUserOrder(String userId);

	public List getFindSettlement(String carrierId, String name, int display, int pageNow);

	public int getFindSettlementTotalRows(String carrierId, String name, int display, int pageNow);

	public List getOrderStatement(String orderNum);
}
