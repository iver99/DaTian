package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.search.CarSearchBean;
import cn.edu.bjtu.bean.search.CargoSearchBean;
import cn.edu.bjtu.bean.search.CityLineSearchBean;
import cn.edu.bjtu.bean.search.CompanySearchBean;
import cn.edu.bjtu.bean.search.LinetransportSearchBean;
import cn.edu.bjtu.bean.search.WarehouseSearchBean;
import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.dao.CitylineDao;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.dao.LinetransportDao;
import cn.edu.bjtu.dao.WarehouseDao;
import cn.edu.bjtu.service.SearchService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 搜索服务层
 * @author RussWest0
 *
 */
@Transactional
@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	LinetransportDao linetransportDao;
	@Autowired
	CitylineDao citylineDao;
	@Autowired
	WarehouseDao warehouseDao;
	@Autowired
	GoodsInfoDao goodsDao;
	@Autowired
	CarDao carDao;
	@Autowired
	CompanyDao companyDao;
	/**
	 * 根据城市名搜索干线资源
	 */
	@Override
	public JSONArray getLineResourceByCityName(String cityName,PageUtil pageUtil,HttpSession session) {
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String sql = "select t1.id,"
				+ "t1.carrierId,"
				+ "t1.lineName,"
				+ "t1.startPlace,"
				+ "t1.endPlace,"
				+ "t1.refPrice,"
				+ "t1.relDate,"
				+ "t1.type,"
				+ "t1.onWayTime,"
				+ "t1.companyName,"
				+ "t3.status "
				+ " from line_carrier_view t1 "
				+ "left join ("
				+ "select * from focus t2 ";
				
		if(userId!=null){//如果当前有用户登录在条件中加入用户信息
			sql+=" where t2.focusType='linetransport' and t2.clientId=:clientId ";
			params.put("clientId", userId);
		}
		sql+=") t3 on t1.id=t3.focusId where t1.startPlace like '%"+cityName+"%' or t1.endPlace like '%"+cityName+"%' ";
		
		JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=linetransportDao.findBySql(sql, params,page,display);
		
		List<LinetransportSearchBean> lineList=new ArrayList<LinetransportSearchBean>();
		for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
			LinetransportSearchBean lineBean=new LinetransportSearchBean();
			
			Object[] obj=it.next();
			lineBean.setId((String)obj[0]);
			lineBean.setCarrierId((String)obj[1]);
			lineBean.setLineName((String)obj[2]);
			lineBean.setStartPlace((String)obj[3]);
			lineBean.setEndPlace((String)obj[4]);
			lineBean.setRefPrice(((Float)obj[5])+"");
			lineBean.setRelDate((Date)obj[6]);
			lineBean.setTransportType((String)obj[7]);
			lineBean.setOnWayTime((Integer)obj[8]);
			lineBean.setCompanyName((String)obj[9]);
			lineBean.setStatus((String)obj[10]);
			lineList.add(lineBean);
		}
		/*//计算总条数
		String countsql="select count(t1.id) from line_carrier_view t1";
		//Long count=linetransportDao.countBySql(countsql, params);
		Long count=linetransportDao.countBySql("select count(*) from linetransport");*/
		
		for(int i=0;i<lineList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(lineList.get(i));
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
	}


	/**
	 * 根据名称搜索城市配送资源
	 */
	@Override
	public JSONArray getCitylineResourceByName(String name, PageUtil pageUtil,
			HttpSession session) {

		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
			String sql = "select t1.id,"
				+ "t1.carrierId,"
				+ "t1.cityName,"
				+ "t1.name,"
				+ "t1.refPrice,"
				+ "t1.relDate,"
				+ "t1.VIPService,"
				+ "t1.creditRate,"
				+ "t1.companyName,"
				+ "t3.status "
				+ " from city_carrier_view t1 "
				+ "left join ("
				+ "select * from focus t2 ";
				
		if(userId!=null){//如果当前有用户登录在条件中加入用户信息
			sql+=" where t2.focusType='cityline' and t2.clientId=:clientId ";
			params.put("clientId", userId);
		}
		sql+=") t3 on t1.id=t3.focusId where t1.name like '%"+name+"%'";
		
		JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=citylineDao.findBySql(sql, params,page,display);
		
		List<CityLineSearchBean> citylineList=new ArrayList<CityLineSearchBean>();
		for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
			CityLineSearchBean citylinebean=new CityLineSearchBean();
			Object[] obj=it.next();
			citylinebean.setId((String)obj[0]);
			citylinebean.setCarrierId((String)obj[1]);
			citylinebean.setCityName((String)obj[2]);
			citylinebean.setName((String)obj[3]);;
			citylinebean.setRefPrice((Float)obj[4]+"");
			citylinebean.setRelDate((Date)obj[5]);
			citylinebean.setVIPService((String)obj[6]);
			citylinebean.setCreditRate((Integer)obj[7]);
			citylinebean.setCompanyName((String)obj[8]);
			citylinebean.setStatus((String)obj[9]);
			citylineList.add(citylinebean);
		}
		
		for(int i=0;i<citylineList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(citylineList.get(i));
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	/**
	 * 根据名称模糊搜索货物
	 */
	@Override
	public JSONArray getGoodsResourceByName(String name, PageUtil pageUtil,
			HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String sql = "select t1.id,"
				+ "t1.name,"
				+ "t1.transportType,"
				+ "t1.weight,"
				+ "t1.relDate,"
				+ "t1.limitDate,"
				+ "t3.status "
				+ " from goodsform t1 "
				+ "left join ("
				+ "select * from focus t2 ";
				
		if(userId!=null){//
			sql+=" where t2.focusType='goods' and t2.clientId=:clientId ";
			params.put("clientId", userId);
		}
		sql+=") t3 on t1.id=t3.focusId where t1.name like '%"+name+"%'";
		
		JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=goodsDao.findBySql(sql, params,page,display);
		
		List<CargoSearchBean> cargoList=new ArrayList<CargoSearchBean>();
		for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
			CargoSearchBean instanceBean=new CargoSearchBean();
			Object[] obj=it.next();
			instanceBean.setId((String)obj[0]);
			instanceBean.setName((String)obj[1]);
			instanceBean.setTransportType((String)obj[2]);
			instanceBean.setWeight((Float)obj[3]+"");;
			instanceBean.setRelDate((Date)obj[4]);;
			instanceBean.setLimitDate((Date)obj[5]);;
			instanceBean.setStatus((String)obj[6]);
			cargoList.add(instanceBean);
		}
		
		for(int i=0;i<cargoList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(cargoList.get(i));
			jsonArray.add(jsonObject);
		}
		return jsonArray;

	}

	/**
	 * 根据公司名称搜索
	 */
	@Override
	public JSONArray getCompanyResourceByCompanyName(String companyName,
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
		}
		sql+=") t3 on t1.id=t3.focusId where  t1.companyName like '%"+companyName+"%' ";
		
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
	 * 搜索车辆，根据车牌
	 */
	@Override
	public JSONArray getCarResourceByCarNum(String carNum, PageUtil pageUtil,
			HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
			String sql = "select t1.id,"
				+ "t1.carrierId,"
				+ "t1.carNum,"
				+ "t1.companyName,"
				+ "t1.carBase,"
				+ "t1.carState,"
				+ "t1.carLength,"
				+ "t1.carWeight,"
				+ "t1.carLocation,"
				+ "t1.relDate,"
				+ "t1.linetransportId,"
				+ "t3.status "
				+ " from car_carrier_view t1 "
				+ "left join ("
				+ "select * from focus t2 ";
				
		if(userId!=null){//如果当前有用户登录在条件中加入用户信息
			sql+=" where t2.focusType='car' and t2.clientId=:clientId ";
			params.put("clientId", userId);
		}
		sql+=") t3 on t1.id=t3.focusId where t1.carNum like '%"+carNum+"%'";
		
		JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=carDao.findBySql(sql, params,page,display);
		
		List<CarSearchBean> carList=new ArrayList<CarSearchBean>();
		for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
			CarSearchBean carBean=new CarSearchBean();
			Object[] obj=it.next();
			carBean.setId((String)obj[0]);
			carBean.setCarrierId((String)obj[1]);
			carBean.setCarNum((String)obj[2]);
			carBean.setCompanyName((String)obj[3]);;
			carBean.setCarBase((String)obj[4]);
			carBean.setCarState((String)obj[5]);
			carBean.setCarLength((Double)obj[6]+"");
			carBean.setCarWeight((Double)obj[7]+"");;
			carBean.setCarLocation((String)obj[8]);
			carBean.setRelDate((Date)obj[9]);
			carBean.setLinetransportId((String)obj[10]);;
			carBean.setStatus((String)obj[11]);
			carList.add(carBean);
		}
		
		for(int i=0;i<carList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(carList.get(i));
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	/**
	 * 搜索仓库
	 */
	@Override
	public JSONArray getWarehouseResourceByName(String name, PageUtil pageUtil,
			HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
			String sql = "select t1.id,"
				+ "t1.carrierId,"
				+ "t1.name,"
				+ "t1.companyName,"
				+ "t1.fireRate,"
				+ "t1.type,"
				+ "t1.houseArea,"
				+ "t1.relDate,"
				+ "t3.status "
				+ " from warehouse_carrier_view t1 "
				+ "left join ("
				+ "select * from focus t2 ";
				
		if(userId!=null){//如果当前有用户登录在条件中加入用户信息
			sql+=" where t2.focusType='warehouse' and t2.clientId=:clientId ";
			params.put("clientId", userId);
		}
		sql+=") t3 on t1.id=t3.focusId where t1.name like '%"+name+"%'";
		
		JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=warehouseDao.findBySql(sql, params,page,display);
		
		List<WarehouseSearchBean> warehouseList=new ArrayList<WarehouseSearchBean>();
		for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
			WarehouseSearchBean instanceBean=new WarehouseSearchBean();
			Object[] obj=it.next();
			instanceBean.setId((String)obj[0]);
			instanceBean.setCarrierId((String)obj[1]);
			instanceBean.setName((String)obj[2]);;
			instanceBean.setCompanyName((String)obj[3]);;
			instanceBean.setFireRate((String)obj[4]);
			instanceBean.setType((String)obj[5]);
			instanceBean.setHouseArea((Float)obj[6]+"");
			instanceBean.setRelDate((Date)obj[7]);;
			instanceBean.setStatus((String)obj[8]);
			warehouseList.add(instanceBean);
		}
		
		for(int i=0;i<warehouseList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(warehouseList.get(i));
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}


	/* 搜索功能总记录数
	 * @see cn.edu.bjtu.service.SearchService#searchLinetransportTotalRows(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer searchLinetransportTotalRows(String resource_kind,
			String search_content) {
		String hql="";
		Long count=0L;
//		Map<String,Object> params=new HashMap<String,Object>();
		if("线路".equals(resource_kind)){
			hql="select count(*) from Linetransport t where t.startPlace like '%"+search_content+"%' or t.endPlace like '%"+search_content+"%' ";
			count=linetransportDao.count(hql);
		}else if("配送".equals(resource_kind)){
			hql="select count(*) from Cityline t where t.name like '%"+search_content+"%'";
			count=citylineDao.count(hql);
		}else if("车辆".equals(resource_kind)){
			hql="select count(*) from Carinfo t where t.carNum like '%"+search_content+"%'";
			count=carDao.count(hql);
		}else if ("仓库".equals(resource_kind)){
			hql="select count(*) from Warehouse t where t.name like '%"+search_content+"%'";
			count=warehouseDao.count(hql);
		}else if("公司".equals(resource_kind)){
			hql="select count(*) from Carrierinfo t where t.companyName like '%"+search_content+"%'";
			count=companyDao.count(hql);
		}else{//货物
			hql="select count(*) from Goodsform t where t.name like '%"+search_content+"%'";
			count=goodsDao.count(hql);
		}
		
		return count.intValue();
		
	}

	
	

	
	
}
