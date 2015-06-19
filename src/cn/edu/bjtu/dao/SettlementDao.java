package cn.edu.bjtu.dao;

import java.util.List;

public interface SettlementDao {
	
	public List getUserOrder(String userId);
	public List getFindSettlement(String sql, int display, int pageNow);
	public List getOrderStatement(String orderNum);

}
