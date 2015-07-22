package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.search.CompanySearchBean;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Userinfo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author RussWest0
 *
 */
@Repository
@Transactional
public class CompanyServiceImpl implements CompanyService{
	
	@Resource
	CompanyDao companyDao;
	@Resource
	HQLTool hqltool;
	@Autowired
	UserinfoDao userinfoDao;
	
	@Override
	/**
	 * 返回所有公司
	 */
	@Deprecated
	public List getAllCompany(int Display,int PageNow)  {
		
		return companyDao.getAllCompany(Display,PageNow);
	}
	

	@Override
	/**
	 * 返回所有公司
	 */
	@Deprecated
	public List getAllCompanyWithoutPage(){
		return companyDao.getAllCompanyWithoutPage();
	}

	/*@Override
	*//**
	 * 返回公司信息
	 *//*
	public Carrierinfo getCarrierInfo(String id) {
		
		return companyDao.getCarrierInfo(id);
	}*/
	
	@Override
	/**
	 * 条件筛选公司
	 */
	@Deprecated
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
		
		return companyDao.getSelectedCompany(sql,Display,PageNow);
	}
	
	@Override
	/**
	 * 获取总记录条数 
	 */
	@Deprecated
	public int getTotalRows(String resourceRate, String serviceIndustry, String creditRate, String business) {
		
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

	/**
	 * 查找Carrierinfo实体
	 */
	@Override
	public Carrierinfo getCompanyById(String carrierId) {
		
		return companyDao.get(Carrierinfo.class, carrierId);
	}
	
	/**
	 * 资源栏-公司筛选
	 */
	@Override
	public JSONArray getSelectedCompanyNew(CompanySearchBean companyBean,
			PageUtil pageUtil, HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
			String sql = "select t1.id,"
				+ "t1.companyName,"
				+ "t1.resourceRate,"
				+ "t1.companyType,"
				+ "t1.creditRate,"
				+ "t1.relDate,"
				+ "t3.status "
				+ " from carrierinfo t1 "
				+ "left join ("
				+ "select * from focus t2 ";
		if(userId!=null){
			sql+=" where t2.focusType='company' and t2.clientId=:clientId ";
			params.put("clientId", userId);
		}else{
			sql+=" where t2.focusType='company' and t2.clientId=''";
		}
		sql+=") t3 on t1.id=t3.focusId ";
		String wheresql=whereSql(companyBean,params);
		sql+=wheresql+" order by t1.relDate desc";
		
		JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=companyDao.findBySql(sql, params,page,display);
		
		List<CompanySearchBean> companyList=new ArrayList<CompanySearchBean>();
		for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
			CompanySearchBean instanceBean=new CompanySearchBean();
			Object[] obj=it.next();
			instanceBean.setId((String)obj[0]);
			instanceBean.setCompanyName((String)obj[1]);;
			instanceBean.setResourceRate((String)obj[2]);;
			instanceBean.setCompanyKind((String)obj[3]);;;
			instanceBean.setCreditRate((Integer)obj[4]+"");;
			instanceBean.setRelDate((Date)obj[5]);
			instanceBean.setStatus((String)obj[6]);
			companyList.add(instanceBean);
		}
		
		for(int i=0;i<companyList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(companyList.get(i));
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	/**
	 * 资源栏-公司筛选总记录数
	 */
	@Override
	public Integer getSelectedCompanyTotalRows(CompanySearchBean companyBean) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Carrierinfo t1 "+whereSql(companyBean, params);
		Long count=companyDao.count(hql, params);
		
		return count.intValue();
	}
	
	/**
	 * where sql
	 * @Title: whereSql 
	 *  
	 * @param: @param companyBean
	 * @param: @param params
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年6月15日 下午4:51:20
	 */
	private String whereSql(CompanySearchBean companyBean,Map<String ,Object> params){
		String wheresql="where 1=1 ";
		if (companyBean.getCity() != null
				&& !companyBean.getCity().equals("中文或拼音")
				&& !companyBean.getCity().equals("All")
				&& !companyBean.getCity().equals("")){
			wheresql+=" and ( t1.companyName like '%"+companyBean.getCity()+"%' "
					+ "or t1.companyAddr like '%"+companyBean.getCity()+"%' ) ";
		}
		if (companyBean.getResourceRate() != null
				&& !companyBean.getResourceRate().equals("All")
				&& !companyBean.getResourceRate().equals("")){
			String resourceRate=companyBean.getResourceRate().trim();
			if (resourceRate.equals("自有资源")) {
				wheresql+=" and t1.resourceRate='自有' ";
			}
			if (resourceRate.equals("核心资源")) {
				wheresql+=" and t1.resourceRate='核心' ";
			}
			if (resourceRate.equals("外围资源")) {
				wheresql+=" and t1.resourceRate='外围 ' ";
			}
		}
		if (companyBean.getServiceIndustry() != null
				&& !companyBean.getServiceIndustry().equals("")
				&& !companyBean.getServiceIndustry().equals("All")){
			String serviceIndustry=companyBean.getServiceIndustry().trim();
			if(serviceIndustry.equals("医药行业")){
				wheresql+=" and t1.serviceIndustry='医药' ";
			}
			if(serviceIndustry.equals("电子行业")){
				wheresql+=" and t1.serviceIndustry='电子' ";
			}
			if(serviceIndustry.equals("汽车行业")){
				wheresql+=" and t1.serviceIndustry='汽车' ";
			}
		}
		if (companyBean.getCreditRate() != null
				&& !companyBean.getCreditRate().equals("")
				&& !companyBean.getCreditRate().equals("All")) {
			String creditRate=companyBean.getCreditRate().trim();
			if(creditRate.equals("1级信用等级")){
				wheresql+=" and t1.creditRate=1 ";
			}
			if(creditRate.equals("2级信用等级")){
				wheresql+=" and t1.creditRate=2 ";
			}
			if(creditRate.equals("3级信用等级")){
				wheresql+=" and t1.creditRate=3 ";
			}
		}
		if (companyBean.getServiceKind() != null
				&& !companyBean.getServiceKind().equals("")
				&& !companyBean.getServiceKind().equals("All")) {
			String serviceKind=companyBean.getServiceKind().trim();
			if(serviceKind.equals("干线运输业务")){
				wheresql+=" and t1.line=1";
			}if(serviceKind.equals("城市配送业务")){
				wheresql+=" and t1.city=1";
			}if(serviceKind.equals("仓储业务")){
				wheresql+=" and t1.warehouse=1";
			}
		}
		
		return wheresql;
	}


	/**
	 * 获取已经通过验证的公司列表
	 */
	@Override
	public JSONArray getCertificatedCompany(HttpSession session) {
		
		String hql="from Userinfo t where t.status='已审核' and t.userKind=3";
		List<Userinfo> userList=userinfoDao.find(hql);
		//通过获取到的userList中取出公司的id获取公司的信息
		List<Carrierinfo> companyList=new ArrayList<Carrierinfo>();
		for(Userinfo user:userList){
			Carrierinfo company=companyDao.get(Carrierinfo.class, user.getId());
			if(company !=null){
				companyList.add(company);
			}
		}
		
		JSONArray jsonArray=new JSONArray();
		for(Carrierinfo company:companyList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(company);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
	}
	
	
	
}
