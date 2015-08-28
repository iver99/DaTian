package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.Carrierinfo;
/**
 * 
 * @author RussWest0
 *
 */
@Repository
public class CompanyDaoImpl extends BaseDaoImpl<Carrierinfo> implements CompanyDao{
	
	@Resource
	private HibernateTemplate ht;
	
	@Override
	/**
	 * 返回特定的公司信息
	 */
	public Carrierinfo getCarrierInfo(String id) {
		
		
		return ht.get(Carrierinfo.class, id);
	}
	
	@Override
	public List getLinetransportByCarrierId(String id){
		return ht.find("from Linetransport as s where s.carrierId='" + id+ "'");
	}
	
	@Override
	public List getCitylineByCarrierId(String id){
		return ht.find("from Cityline as s where s.carrierId='" + id+ "'");
	}
	
	@Override
	public List getwarehouseByCarrierId(String id){
		return ht.find("from Warehouse as s where s.carrierId='" + id+ "'");
	}
	
	
	

}
