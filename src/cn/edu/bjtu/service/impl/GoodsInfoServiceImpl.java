package cn.edu.bjtu.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.bean.search.CargoSearchBean;
import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.service.GoodsInfoService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Transactional
@Repository
public class GoodsInfoServiceImpl implements GoodsInfoService{
	
	@Resource
	GoodsInfoDao goodsinfoDao;
	@Resource
	Goodsform goodsform;
	@Resource
	HQLTool hqltool;
	@Resource
	GoodsClientView goodsClientView;
	
	@Override
	@Deprecated
	public List getSelectedGoodsInfo(String startPlace, String endPlace,
			String transportType, int Display,int PageNow) {
		
		String [] paramList={"startPlace","endPlace","transportType"};//ûstartplace1 
		String [] valueList={startPlace,endPlace,transportType};
		String hql="from GoodsClientView ";
		String sql=HQLTool.spellHql2(hql,paramList, valueList);
		return goodsinfoDao.getSelectedGoodsInfo(sql,Display,PageNow);
	}
	
	@Override
	@Deprecated
	public int getTotalRows(String startPlace, String endPlace, String transportType) {
		
		String [] paramList={"startPlace","endPlace","transportType"};//ûstartplace1 
		String [] valueList={startPlace,endPlace,transportType};
		String hql="from GoodsClientView "; 
		String sql=HQLTool.spellHql2(hql,paramList, valueList);
		return hqltool.getTotalRows(sql); 
	}
	
	@Override
	public GoodsClientView getAllGoodsDetail(String id) {
		
		return goodsinfoDao.getAllGoodsDetail(id);
	}
	
	@Override
	public Goodsform getMyGoodsDetail(String id) {
		
		return goodsinfoDao.getMyGoodsDetail(id);
	}
	
	//@SuppressWarnings("deprecation")
	@Override
	public boolean  insertNewGoods(Goodsform goods,HttpServletRequest request,MultipartFile file){
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		String fileLocation=UploadFile.uploadFile(file, clientId, "cargo");
		
		goods.setId(IdCreator.createGoodsId());
		goods.setState("待确认");
		goods.setRelDate(new Date());
		goods.setClientId(clientId);
		
		
		//设置文件位置 
		goods.setRelatedMaterial(fileLocation);
		goodsinfoDao.save(goods);// 保存实体
		return true;
		
	}
	@Deprecated
	public boolean insertGoods(String name, String type, float weight,
		String transportType, String transportReq, String startPlace, String endPlace,
		String damageReq, String VIPService, String oriented, String limitDate,
		String invoice, String remarks,String clientId,String path,
		String fileName) {
		
		
		goodsform.setId(IdCreator.createGoodsId());
		goodsform.setName(name);
		goodsform.setType(type);
		goodsform.setWeight(weight);
		goodsform.setTransportType(transportType);
		goodsform.setTransportReq(transportReq);
		goodsform.setStartPlace(startPlace);
		goodsform.setEndPlace(endPlace);
		goodsform.setDamageReq(damageReq);
		goodsform.setVipservice(VIPService);
		goodsform.setOriented(oriented);
		goodsform.setLimitDate(stringToDate(limitDate));
		goodsform.setInvoice(invoice);
		goodsform.setRemarks(remarks);
		
		goodsform.setRelDate(new Date());
		goodsform.setState("��ȷ��");
		goodsform.setClientId(clientId);
		
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			goodsform.setRelatedMaterial(fileLocation);
		}
		goodsinfoDao.save(goodsform); 
		return true;
		
	}

	@Override
	public boolean commitResponse(String goodsId, String remarks, String userId,String path,String fileName) {
		
		return goodsinfoDao.commitResponse(goodsId,remarks,userId,path,fileName);
	}

	@Override
	@Deprecated
	public List getAllResponse(String userId) {
		
		return goodsinfoDao.getAllResponse(userId);
	}
	@Deprecated
	@Override
	public List getUserGoodsInfo(String userId) {
		
		
		return goodsinfoDao.getUserGoodsInfo(userId);
	}
	
	 public static Date stringToDate(String str) {  
	        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        Date date = null;  
	        try {  
	            // Fri Feb 24 00:00:00 CST 2012  
	            date = format.parse(str);   
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        // 2012-02-24  
	        date = java.sql.Date.valueOf(str);  
	                                              
	        return date;  
	} 
	
	 @Override
	 @Deprecated
		public boolean updateGoods(String id, String name, String type, float weight,
			String transportType, String transportReq, String startPlace, String endPlace,
			String damageReq, String VIPService, String oriented, String limitDate,
			String invoice, String remarks,String clientId,String path, String fileName) {
			
			goodsform = getMyGoodsDetail(id);

			goodsform.setName(name);
			goodsform.setType(type);
			goodsform.setWeight(weight);
			goodsform.setTransportType(transportType);
			goodsform.setTransportReq(transportReq);
			goodsform.setStartPlace(startPlace);
			goodsform.setEndPlace(endPlace);
			goodsform.setDamageReq(damageReq);
			goodsform.setVipservice(VIPService);
			goodsform.setOriented(oriented);
			goodsform.setLimitDate(stringToDate(limitDate));
			goodsform.setInvoice(invoice);
			goodsform.setRemarks(remarks);
			if (path != null && fileName != null) {
				String fileLocation = path + "//" + fileName;
				goodsform.setRelatedMaterial(fileLocation);
			}
			goodsinfoDao.update(goodsform); 
			return true;
			
		}
	 
	 @Override
	 public boolean  updateNewGoods(Goodsform goods,HttpServletRequest request,MultipartFile file){
		 String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
			String fileLocation=UploadFile.uploadFile(file, carrierId, "cargo");

			Goodsform goodsInstance = goodsinfoDao.get(Goodsform.class,goods.getId());
			goodsInstance.setName(goods.getName());
			goodsInstance.setType(goods.getType());
			goodsInstance.setWeight(goods.getWeight());
			goodsInstance.setTransportType(goods.getTransportType());
			goodsInstance.setTransportReq(goods.getTransportReq());
			goodsInstance.setStartPlace(goods.getStartPlace());
			goodsInstance.setEndPlace(goods.getEndPlace());
			goodsInstance.setDamageReq(goods.getDamageReq());
			goodsInstance.setVipservice(goods.getVipservice());
			goodsInstance.setOriented(goods.getOriented());
			goodsInstance.setLimitDate(goods.getLimitDate());
			goodsInstance.setInvoice(goods.getInvoice());
			goodsInstance.setRemarks(goods.getRemarks());
			goodsInstance.setVipServiceDetail(goods.getVipServiceDetail());
			goodsInstance.setRelatedMaterial(fileLocation);

			goodsinfoDao.update(goodsInstance);
			return true;
	 }
	 
	 /**
	  * 删除货物，同时删除反馈表中的记录
	  */
	 @Override
	 public boolean deleteGoods(String id){
		 Goodsform goodsform = goodsinfoDao.get(Goodsform.class, id);
		 goodsinfoDao.delete(goodsform);
		 
		 String hql="delete from Response t where t.goodsId=:goodsId";
		 Map<String,Object> params=new HashMap<String,Object>();
		 params.put("goodsId", id);
		 goodsinfoDao.executeHql(hql, params);
		 
		 return true;
		 
	 }

	 /**
	  * 确认反馈
	  */
	@Override
	public boolean confirmResponse(String goodsId) {
		
		Goodsform goodsinfo=goodsinfoDao.getMyGoodsDetail(goodsId);	
		
		if(goodsinfo!=null){
			goodsinfo.setState("已确认");
			goodsinfoDao.update(goodsinfo);
		}
		
		return true;
	}

	/**
	 *资源栏货物筛选
	 */
	@Override
	public JSONArray getSelectedCargoNew(CargoSearchBean cargoBean,
			PageUtil pageUtil, HttpSession session) {
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
		sql+=") t3 on t1.id=t3.focusId ";
		String wheresql=whereSql(cargoBean,params);
		sql+=wheresql+" order by t1.relDate desc";
		
		JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=goodsinfoDao.findBySql(sql, params,page,display);
		
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
	 * 资源栏-货物-总记录条数
	 */
	@Override
	public Integer getSelectedCargoTotalRows(CargoSearchBean cargoBean) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Goodsform t1"+whereSql(cargoBean, params);
		Long count=goodsinfoDao.count(hql, params);
		
		return count.intValue();
	}
	 
	/**
	 * where sql
	 * @param cargoBean
	 * @return
	 */
	public String whereSql(CargoSearchBean cargoBean,Map<String,Object> params){
		String wheresql=" where 1=1 ";
		if (cargoBean.getStartPlace() != null
				&& !cargoBean.getStartPlace().equals("全国")
				&& !cargoBean.getStartPlace().equals("中文或拼音")
				&& !cargoBean.getStartPlace().equals("All")
				&& !cargoBean.getStartPlace().equals("")) {
			wheresql+=" and t1.startPlace=:startPlace ";
			params.put("startPlace", cargoBean.getStartPlace());
		}
		if(cargoBean.getEndPlace()!=null && !cargoBean.getEndPlace().equals("")
				&& !cargoBean.getEndPlace().equals("中文或拼音")
				&& !cargoBean.getEndPlace().equals("全国")
				&& !cargoBean.getEndPlace().equals("All")){
			wheresql+=" and t1.endPlace=:endPlace ";
			params.put("endPlace", cargoBean.getEndPlace());
		}
		if (cargoBean.getTransportType() != null
				&& !cargoBean.getTransportType().trim().equals("")
				&& !cargoBean.getTransportType().trim().equals("All")) {
			wheresql+=" and t1.transportType=:transportType ";
			params.put("transportType", cargoBean.getTransportType().trim());
		}
		if (cargoBean.getWeight() != null && !cargoBean.getWeight().equals("")
				&& !cargoBean.getWeight().equals("All")) {
			String weight = cargoBean.getWeight().trim();
			if (weight.equals("10吨")) {	
				wheresql+=" and t1.weight=10 ";
			}
			if (weight.equals("15吨")) {
				wheresql+=" and t1.weight=15 ";
			}
			if (weight.equals("20吨")) {
				wheresql+=" and t1.weight=20 ";
			}
			if (weight.equals("35吨")) {
				wheresql+=" and t1.weight=35 ";
			}
		}
		if (cargoBean.getTransportReq() != null
				&& !cargoBean.getTransportReq().equals("")
				&& !cargoBean.getTransportReq().equals("All")) {
			String transportReq=cargoBean.getTransportReq();
			if (transportReq.equals("高栏货车")) {
				wheresql+=" and t1.transportReq like '%高栏%' ";
			}
			if (transportReq.equals("厢式货车")) {
				wheresql+=" and t1.transportReq like '%厢式%' ";
			}
			if (transportReq.equals("平板货车")) {
				wheresql+=" and t1.transportReq like '%ƽ平板%' ";
			}
		}
		return wheresql;
	}
	 
	/**
	 * 我的信息-我的货物
	 */
	@Override
	public JSONArray getUserCargoResource(HttpSession session,PageUtil pageUtil) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		  String hql="from Goodsform t where t.clientId=:clientId order by t.relDate desc";
		  Map<String,Object> params=new HashMap<String,Object>();
		  params.put("clientId", userId);
		  int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
			int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		  List<Goodsform> cargoList=goodsinfoDao.find(hql, params,page,display);
		 
		  JSONArray jsonArray=new JSONArray();
		  for(Goodsform cargo:cargoList){
		   JSONObject jsonObject=(JSONObject)JSONObject.toJSON(cargo);
		   jsonArray.add(jsonObject);
		  }
		 
		  return jsonArray;
	}

	/**
	 * 我的资源-货物信息-总记录条数
	 */
	@Override
	public Integer getUserCargoTotalRows(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		  String hql="select count(*) from Goodsform t where t.clientId=:clientId";
		  Map<String,Object> params=new HashMap<String,Object>();
		  params.put("clientId", userId);
		  
		  Long count=goodsinfoDao.count(hql, params);
		  return count.intValue();
	}
	
	 
}
