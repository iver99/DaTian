package cn.edu.bjtu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CitylineDao;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.LinetransportDao;
import cn.edu.bjtu.dao.WarehouseDao;
import cn.edu.bjtu.vo.Carrierinfo;
/**
 * 
 * @author RussWest0
 *
 */
@Repository
public class CompanyDaoImpl extends BaseDaoImpl<Carrierinfo> implements CompanyDao{
	
	@Autowired
	LinetransportDao linetransportDao;
	@Autowired
	CitylineDao citylineDao;
	@Autowired
	WarehouseDao warehouseDao;
	
	@Override
	/**
	 * 返回特定的公司信息
	 */
	public Carrierinfo getCarrierInfo(String id) {
		
		
		return this.get(Carrierinfo.class, id);
	}
	
	@Override
	public List getLinetransportByCarrierId(String id){
		return linetransportDao.find("from Linetransport as s where s.carrierId='" + id+ "'");
	}
	
	@Override
	public List getCitylineByCarrierId(String id){
		return citylineDao.find("from Cityline as s where s.carrierId='" + id+ "'");
	}
	
	@Override
	public List getwarehouseByCarrierId(String id){
		return warehouseDao.find("from Warehouse as s where s.carrierId='" + id+ "'");
	}
	
	
	

}
