package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.search.LinetransportSearchBean;
import cn.edu.bjtu.dao.LinetransportDao;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DataModel;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.HQL_POJO;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;

@Transactional
@Service
/**
 * 
 * @author RussWest0
 *
 */
public class LinetransportServiceImpl implements LinetransportService {

	@Resource
	LinetransportDao linetransportDao;
	@Resource
	Linetransport linetransport;
	/*@Resource
	BaseDao baseDao;*/
	@Resource
	HQLTool hqltool;
	private Logger logger=Logger.getLogger(LinetransportServiceImpl.class);

	private String hql = "";
	private static boolean flag = false;

	@Override
	/**
	 * 返回所有干线列表
	 */
	public List getAllLinetransport(int Display, int PageNow) {
		// TODO Auto-generated method stub
		return linetransportDao.getAllLinetransport(Display, PageNow);
	}
	
	@Override
	/**
	 * 返回所有干线列表
	 */
	public List getAllLinetransportWithoutPage() {
		// TODO Auto-generated method stub
		return linetransportDao.getAllLinetransportWithoutPage();
	}

	@Override
	/**
	 * 返回干线信息
	 */
	public Linetransport getLinetransportInfo(String linetransportid) {
		// TODO Auto-generated method stub
		return linetransportDao.getLinetransportInfo(linetransportid);
	}

	@Override
	/**
	 * 条件筛选干线
	 */
	public List getSelectedLine(String startPlace, String endPlace,
			String type, String startPlace1, String refPrice, int Display,
			int PageNow) {
		// TODO Auto-generated method stub

		String sql = "";
		if (refPrice.equals("大于2元/kg")) {
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where refPrice > 2";
			} else
				sql += "and refPrice > 2";
		} else if (refPrice.equals("1至2元/kg")) {
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where refPrice >= 1 and refPrice <= 2";
			} else
				sql += "and refPrice >= 1 and refPrice <= 2";
		} else if (refPrice.equals("小于1元/kg")) {
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where refPrice < 1";
			} else
				sql += "and refPrice < 1";
		} else {
			String[] paramList = { "startPlace", "endPlace", "type", "refPrice" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type, refPrice };
			sql = spellHql2(paramList, valueList);
		}

		return linetransportDao.getSelectedLine(sql, Display, PageNow);
		// return null;

	}

	@Override
	/**
	 * 获取总记录条数 
	 */
	public int getTotalRows(String startPlace, String endPlace, String type,
			String startPlace1, String refPrice) {
		// TODO Auto-generated method stub
		String sql = "";
		if (refPrice.equals("大于2元/kg")) {
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where refPrice > 2";
			} else
				sql += "and refPrice > 2";
		} else if (refPrice.equals("1至2元/kg")) {
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where refPrice >= 1 and refPrice <= 2";
			} else
				sql += "and refPrice >= 1 and refPrice <= 2";
		} else if (refPrice.equals("小于1元/kg")) {
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where refPrice < 1";
			} else
				sql += "and refPrice < 1";
		} else {
			String[] paramList = { "startPlace", "endPlace", "type", "refPrice" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type, refPrice };
			sql = spellHql2(paramList, valueList);
		}
		// System.out.println("hql+"+sql);
		return hqltool.getTotalRows(sql);// 这里的HQLTool实例千万不能自己new出来，用@Resource
	}

	/**
	 * 工具函数-拼接hql
	 * 
	 * @param paramList
	 * @param valueList
	 * @return 返回拼接好的hql语句
	 */
	private String spellHql2(String[] paramList, String[] valueList) {
		HQL_POJO hqlobj = new HQL_POJO();
		hqlobj.hql = "from LineCarrierView ";// 会变化
		for (int i = 0; i < paramList.length; i++) {
			if (!(valueList[i].equals("All")||valueList[i].equals("中文或拼音")||valueList[i].equals("")))// 要是等于all，说明是默认的，即不写到where子句
			{
				hqlobj.hql += HQLTool.spellHql(hqlobj).hql;
				hqlobj.hql += paramList[i] + "='" + valueList[i] + "' ";
			}
		}
		return hqlobj.hql;
	}

	/*
	 * public static void main(String[] args) { int i = new
	 * LinetransportServiceImpl().getTotalRows("All", "All", "All", "All",
	 * "All"); }
	 */

	@Override
	/**
	 * 新增干线
	 */
	public boolean insertLine(String lineName, String startPlace,
			String endPlace, int onWayTime, String type, float refPrice,
			String remarks, String carrierId, String path, String fileName) {
		// TODO Auto-generated method stub
		linetransport.setId(IdCreator.createlineTransportId());
		linetransport.setCarrierId(carrierId);// 插入session里的carrierid
		linetransport.setLineName(lineName);
		linetransport.setStartPlace(startPlace);
		linetransport.setEndPlace(endPlace);
		linetransport.setOnWayTime(onWayTime);
		linetransport.setRefPrice(refPrice);
		linetransport.setRelDate(new Date());
		linetransport.setRemarks(remarks);
		linetransport.setType(type);
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			linetransport.setDetailPrice(fileLocation);
		}
		linetransportDao.save(linetransport);// 保存实体
		return true;

	}

	@Override
	/**
	 * 返回某公司的所有干线信息
	 */
	public List getCompanyLine(String carrierId, int Display, int PageNow) {
		// TODO Auto-generated method stub
		return linetransportDao.getCompanyLine(carrierId, Display, PageNow);// 未完成
	}

	@Override
	// 未实现
	public String getLinetransportIdByCity(String startPlace, String endPlace) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int getCompanyTotalRows(String carrierId) {
		// TODO Auto-generated method stub
		return linetransportDao.getCompanyTotalRows(carrierId);
	}

	@Override
	/**
	 * 更新干线
	 */
	public boolean updateLine(String id, String lineName, String startPlace,
			String endPlace, int onWayTime, String type, float refPrice,
			String remarks, String carrierId, String path, String fileName) {
		// TODO Auto-generated method stub

		linetransport = getLinetransportInfo(id);// 根据id查找到干线信息
		linetransport.setLineName(lineName);
		linetransport.setStartPlace(startPlace);
		linetransport.setEndPlace(endPlace);
		linetransport.setOnWayTime(onWayTime);
		linetransport.setType(type);
		linetransport.setRefPrice(refPrice);
		linetransport.setRemarks(remarks);
		linetransport.setRelDate(new Date());
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			linetransport.setDetailPrice(fileLocation);
		}

		linetransportDao.update(linetransport);
		return true;

	}

	@Override
	/**
	 * 删除干线
	 */
	public boolean deleteLine(String id) {
		linetransport = getLinetransportInfo(id);// 根据id查找到干线信息

		linetransportDao.delete(linetransport);
		
		return true;
	}
	
	
	@Override
	/**
	 * 新条件筛选干线
	 */
	public DataModel getSelectedLineNew(LinetransportSearchBean linetransportbean,
			PageUtil pageUtil,HttpSession session) {
		// TODO Auto-generated method stub
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
		sql+=") t3 on t1.id=t3.focusId ";
		String wheresql=whereSql(linetransportbean,params);
		sql+=wheresql;
		
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
		//计算总条数
		DataModel dataModel=new DataModel();
		/*String countsql="select count(t1.id) from line_carrier_view t1"+whereSql(linetransportbean,params);
		//Long count=linetransportDao.countBySql(countsql, params);
		Long count=linetransportDao.countBySql("select count(*) from linetransport");
		dataModel.setTotal(count);*/
		dataModel.setRows(lineList);
		return dataModel;
	}
	
	/**
	 * 拼接where
	 * @param linetransportBean
	 * @param page
	 * @param params
	 * @return
	 */
	private String whereSql(LinetransportSearchBean linetransportBean,Map<String,Object> params){
		
		String wheresql=" where 1=1 ";
		if(linetransportBean.getStartPlace()!=null && !linetransportBean.getStartPlace().trim().equals("中文或拼音")&&
				!linetransportBean.getStartPlace().trim().equals("全国") && !linetransportBean.getStartPlace().trim().equals("")){
			wheresql+=" and t1.startPlace=:startPlace";
			params.put("startPlace", linetransportBean.getStartPlace());
		}
		if(linetransportBean.getEndPlace()!=null && !linetransportBean.getEndPlace().trim().equals("中文或拼音")&&
				!linetransportBean.getEndPlace().trim().equals("全国") && !linetransportBean.getStartPlace().trim().equals("")){
			wheresql+=" and t1.endPlace=:endPlace";
			params.put("endPlace", linetransportBean.getEndPlace());
		}
		if(linetransportBean.getRefPrice()!=null && !linetransportBean.getRefPrice().trim().equals("All") && !linetransportBean.getRefPrice().trim().equals("")){
			String refPrice=linetransportBean.getRefPrice().trim();
			if(refPrice.equals("大于2元/kg")){
				wheresql+=" and t1.refPrice > 2 ";
			}
			if(refPrice.equals("1至2元/kg")){
				wheresql+=" and t1.refPrice > 1 and t1.refPrice < 1 ";
			}
			if(refPrice.equals("小于1元/kg")){
				wheresql+=" and t1.refPrice <1 ";
			}
		}
		if(linetransportBean.getTransportType()!=null && !linetransportBean.getTransportType().trim().equals("All") && !linetransportBean.getTransportType().trim().equals("")){
			wheresql+=" and t1.type=:transportType ";
			params.put("transportType", linetransportBean.getTransportType());
		}
		//始发城市先不实现
		/*if(linetransportBean.getFromPlace() != null && linetr linetransportBean.getFromPlace().trim().equals("All")){
			
		}*/
		
		return wheresql;
		
	}
	/**
	 * 干线筛选总条数
	 */
	@Override
	public Integer getSelectedLineTotalRows(LinetransportSearchBean lineBean) {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<String,Object>();
		//String countsql="select count(t1.id) from line_carrier_view t1"+whereSql(lineBean,params);
		String hql="select count(*) from LineCarrierView t1"+whereSql(lineBean, params);
		//Long count=linetransportDao.countBySql(countsql, params);
		//Long count=linetransportDao.countBySql("select count(*) from linetransport");
		Long count=linetransportDao.count(hql, params);
		
		return count.intValue();
		
	}
	

}
