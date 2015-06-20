package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.SettlementCarrierView;

public interface SettlementDao extends BaseDao<SettlementCarrierView>{
	public List getFindSettlement(String sql, int display, int pageNow);
	public List getOrderStatement(String orderNum);

}
