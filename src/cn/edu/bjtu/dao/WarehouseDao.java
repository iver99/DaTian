package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Warehouse;

public interface WarehouseDao extends BaseDao<Warehouse>{
	
	public Warehouse getWarehouseInfo(String warehouseid);
}
