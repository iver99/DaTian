package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Warehouse;

public interface WarehouseDao extends BaseDao<Warehouse>{
	
	public List getAllWarehouse(int Display,int PageNow);
	public Warehouse getWarehouseInfo(String warehouseid);
	public List getCompanyWarehouse(String carrierId);
	public List getSelectedWarehouse(String hql,int Display,int PageNow);
}
