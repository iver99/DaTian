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
	@Resource 
	private HQLTool hqltool;
	
	
	@Override
	/**
	 * 返回所有公司信息
	 */
	public List getAllCompany(int Display,int PageNow) {
		// TODO Auto-generated method stub
		//return ht.find("from Carrierinfo");
		int page = PageNow;
		int pageSize = Display;
		String hql=" from Carrierinfo";
		
		return hqltool.getQueryList(hql, page, pageSize);//dao层分批取数据方法
		
		
	}


	@Override
	/**
	 * 返回符合筛选条件的公司信息
	 */
	public List getSelectedCompany(String hql, int display, int pageNow) {
		// TODO Auto-generated method stub
		//System.out.println("hql+"+hql);
		int page = pageNow;
		int pageSize = display;

		return hqltool.getQueryList(hql, page, pageSize);//Dao层分页函数提取到此方法
	}


	@Override
	/**
	 * 返回特定的公司信息
	 */
	public Carrierinfo getCarrierInfo(String id) {
		// TODO Auto-generated method stub
		
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
