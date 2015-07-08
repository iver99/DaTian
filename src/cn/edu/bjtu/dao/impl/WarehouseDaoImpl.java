package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.WarehouseDao;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.Warehouse;

@Repository
public class WarehouseDaoImpl extends BaseDaoImpl<Warehouse> implements WarehouseDao{
	
	@Resource
	private HibernateTemplate ht;
	@Resource 
	private HQLTool hqltool;
	
	
	@Override
	/**
	 * 返回具体货物信息
	 */
	public Warehouse getWarehouseInfo(String warehouseid) {
		
		return ht.get(Warehouse.class, warehouseid);
		
	}

	@Override
	@Deprecated
	public List getCompanyWarehouse(String carrierId) {
		
		return ht.find("from Warehouse where carrierId='"+carrierId+"'");
	}
	
	@Override
	@Deprecated
	public List getSelectedWarehouse(String hql, int display, int pageNow) {
		
		int page = pageNow;
		int pageSize = display;

		return hqltool.getQueryList(hql, page, pageSize);//Dao层分页函数提取到此方法
	}
}
