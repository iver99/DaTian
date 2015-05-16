package cn.edu.bjtu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.Carrierinfo;

/**
 * 
 * @author RussWest0
 *
 */
@Repository
public class CompanyServiceImpl implements CompanyService{
	
	@Resource
	CompanyDao companyDao;
	@Resource
	HQLTool hqltool;
	
	@Override
	/**
	 * 返回所有公司
	 */
	public List getAllCompany(int Display,int PageNow)  {
		// TODO Auto-generated method stub
		return companyDao.getAllCompany(Display,PageNow);
	}

	@Override
	/**
	 * 返回公司信息
	 */
	public Carrierinfo getCarrierInfo(String id) {
		// TODO Auto-generated method stub
		return companyDao.getCarrierInfo(id);
	}
	
	@Override
	/**
	 * 条件筛选公司
	 */
	public List getSelectedCompany(String resourceRate, String serviceIndustry, 
			String creditRate, String business, int Display,int PageNow) {
		String sql="";
		if(resourceRate.equals("自有资源")){
			resourceRate="自有";
		}
		else if(resourceRate.equals("核心资源")){
			resourceRate="核心";
		}
		else if(resourceRate.equals("外围资源")){
			resourceRate="外围";
		}
		
		if(serviceIndustry.equals("医药行业")){
			serviceIndustry="医药";
		}
		else if(serviceIndustry.equals("电子行业")){
			serviceIndustry="电子";
		}
		else if(serviceIndustry.equals("汽车行业")){
			serviceIndustry="汽车";
		}
		if(business.equals("干线运输业务"))
		{
			String line="1";
			String [] paramList={"resourceRate","serviceIndustry","creditRate","line"};//没startplace1 
			String [] valueList={resourceRate,serviceIndustry,creditRate,line};
			String hql="from Carrierinfo ";//会变化
			sql=HQLTool.spellHql2(hql,paramList, valueList);
		}
		else if(business.equals("城市配送业务"))
		{
			String city="1";
			String [] paramList={"resourceRate","serviceIndustry","creditRate","city"};//没startplace1 
			String [] valueList={resourceRate,serviceIndustry,creditRate,city};
			String hql="from Carrierinfo ";//会变化
			sql=HQLTool.spellHql2(hql,paramList, valueList);
		}
		else if(business.equals("仓储业务"))
		{
			String warehouse="1";
			String [] paramList={"resourceRate","serviceIndustry","creditRate","warehouse"};//没startplace1 
			String [] valueList={resourceRate,serviceIndustry,creditRate,warehouse};
			String hql="from Carrierinfo ";//会变化
			sql=HQLTool.spellHql2(hql,paramList, valueList);
		}
		else
		{
			String [] paramList={"resourceRate","serviceIndustry","creditRate"};//没startplace1 
			String [] valueList={resourceRate,serviceIndustry,creditRate};
			String hql="from Carrierinfo ";//会变化
			sql=HQLTool.spellHql2(hql,paramList, valueList);
		}
		
		//System.out.println("hql+" + sql);
		return companyDao.getSelectedCompany(sql,Display,PageNow);
	}
	
	@Override
	/**
	 * 获取总记录条数 
	 */
	public int getTotalRows(String resourceRate, String serviceIndustry, String creditRate, String business) {
		// TODO Auto-generated method stub
		String sql="";
		if(resourceRate.equals("自有资源")){
			resourceRate="自有";
		}
		else if(resourceRate.equals("核心资源")){
			resourceRate="核心";
		}
		else if(resourceRate.equals("外围资源")){
			resourceRate="外围";
		}
		
		if(serviceIndustry.equals("医药行业")){
			serviceIndustry="医药";
		}
		else if(serviceIndustry.equals("电子行业")){
			serviceIndustry="电子";
		}
		else if(serviceIndustry.equals("汽车行业")){
			serviceIndustry="汽车";
		}
		if(business.equals("干线运输业务"))
		{
			String line="1";
			String [] paramList={"resourceRate","serviceIndustry","creditRate","line"};//没startplace1 
			String [] valueList={resourceRate,serviceIndustry,creditRate,line};
			String hql="from Carrierinfo ";//会变化
			sql=HQLTool.spellHql2(hql,paramList, valueList);
		}
		else if(business.equals("城市配送业务"))
		{
			String city="1";
			String [] paramList={"resourceRate","serviceIndustry","creditRate","city"};//没startplace1 
			String [] valueList={resourceRate,serviceIndustry,creditRate,city};
			String hql="from Carrierinfo ";//会变化
			sql=HQLTool.spellHql2(hql,paramList, valueList);
		}
		else if(business.equals("仓储业务"))
		{
			String warehouse="1";
			String [] paramList={"resourceRate","serviceIndustry","creditRate","warehouse"};//没startplace1 
			String [] valueList={resourceRate,serviceIndustry,creditRate,warehouse};
			String hql="from Carrierinfo ";//会变化
			sql=HQLTool.spellHql2(hql,paramList, valueList);
		}
		else
		{
			String [] paramList={"resourceRate","serviceIndustry","creditRate"};//没startplace1 
			String [] valueList={resourceRate,serviceIndustry,creditRate};
			String hql="from Carrierinfo ";//会变化
			sql=HQLTool.spellHql2(hql,paramList, valueList);
		}
		//System.out.println("hql+"+sql);
		return hqltool.getTotalRows(sql);//这里的HQLTool实例千万不能自己new出来，用@Resource
	}
	
	@Override
	public List getLinetransportByCarrierId(String id){
		return companyDao.getLinetransportByCarrierId(id);
	}
	
	@Override
	public List getCitylineByCarrierId(String id){
		return companyDao.getCitylineByCarrierId(id);
	}
	
	@Override
	public List getwarehouseByCarrierId(String id){
		return companyDao.getwarehouseByCarrierId(id);
	}
	
}
