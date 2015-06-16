package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Warehouse;

public interface WarehouseDao extends BaseDao<Warehouse>{
	
	public Warehouse getWarehouseInfo(String warehouseid);
	public List getCompanyWarehouse(String carrierId);
	@Deprecated
	public List getSelectedWarehouse(String hql,int Display,int PageNow);
}
