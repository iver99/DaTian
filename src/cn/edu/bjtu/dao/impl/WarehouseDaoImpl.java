package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.WarehouseDao;

import cn.edu.bjtu.vo.Warehouse;

@Repository
public class WarehouseDaoImpl extends BaseDaoImpl<Warehouse> implements WarehouseDao{
	
	@Resource
	private HibernateTemplate ht;
	@Override
	/**
	 * 返回具体货物信息
	 */
	public Warehouse getWarehouseInfo(String warehouseid) {
		
		return ht.get(Warehouse.class, warehouseid);
		
	}

}
