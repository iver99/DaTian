package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.bjtu.bean.search.LinetransportSearchBean;
import cn.edu.bjtu.service.SearchService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DataModel;

/**
 * 搜索服务层
 * @author RussWest0
 *
 */
@Transactional
@Service
public class SearchServiceImpl implements SearchService{

	/**
	 * 根据城市名搜索干线资源
	 */
	@Override
	public JSONArray getLineResourceByCityName(String cityName,int display,int currentPage) {
		// TODO Auto-generated method stub
		/*String userId=(String)session.getAttribute(Constant.USER_ID);
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
		String countsql="select count(t1.id) from line_carrier_view t1"+whereSql(linetransportbean,params);
		//Long count=linetransportDao.countBySql(countsql, params);
		Long count=linetransportDao.countBySql("select count(*) from linetransport");
		dataModel.setTotal(count);
		dataModel.setRows(lineList);
		return dataModel;
		
		for(int i=0;i<warehouseList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(warehouseList.get(i));
			jsonArray.add(jsonObject);
		}*/
		
		return new JSONArray();
	}
	
	/**
	 * 根据资源名搜索城市配送
	 */
	@Override
	public JSONArray getCitylineResourceByName(String name,int display,int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getGoodsResourceByName(String name,int display,int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getCompanyResourceByCompanyName(String companyName,int display,int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getCarResourceByCarNum(String carNum,int display,int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getWarehouseResourceByName(String name,int display,int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
