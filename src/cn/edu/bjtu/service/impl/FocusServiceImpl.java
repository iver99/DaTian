package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.FocusBean;
import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.dao.CitylineDao;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.FocusDao;
import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.dao.LinetransportDao;
import cn.edu.bjtu.dao.WarehouseDao;
import cn.edu.bjtu.dao.impl.BaseDaoImpl;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Cityline;
import cn.edu.bjtu.vo.Focus;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.Linetransport;
import cn.edu.bjtu.vo.Warehouse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
@Transactional
public class FocusServiceImpl extends BaseDaoImpl<Focus> implements FocusService {
	
	@Resource
	HibernateTemplate ht;
	/*@Resource 
	BaseDao baseDao;*/
	@Autowired
	FocusDao focous;
	@Resource 
	Focus focus;
	@Autowired
	FocusDao focusDao;
	@Autowired
	LinetransportDao linetransportDao;
	@Autowired
	CitylineDao citylineDao;
	@Autowired
	WarehouseDao warehouseDao;
	@Autowired
	CarDao carDao;
	@Autowired
	GoodsInfoDao goodsinfoDao;
	@Autowired
	CompanyDao companyDao;
	

	@Override
	/**
	  * 添加关注
	  */
	public boolean insertFocus(String clientId, String foucsType, String foucsId){
		
		focus.setId(IdCreator.createFocusId());
		focus.setClientId(clientId);
		focus.setFocusType(foucsType);
		focus.setFocusId(foucsId);
		focus.setStatus("有效");
		focusDao.save(focus);
		return true;
	}

	@Override
	/**
	  * 判断某条信息是否已被关注 
	  */
	public List getFocusJudgement(String clientId, String focusType,
			String foucsId) {
		
		return focusDao.getFocusJudgement(clientId,focusType,foucsId);
	}

	@Override
	/**
	  * 删除关注 
	  */
	public boolean deleteFocus(String id){
		return focusDao.deleteFocus(id);
	}
	@Override
	/**
	 * 关注列表获取
	 */
	public List getFocusList(String clientId,String focusType) {
		
		return focusDao.getFocusList(clientId,focusType);
	}
	
	@Override
	/**
	 * 我的关注列表获取
	 */
	public List getAllFocusLine(String clientId){
		return focusDao.getAllFocusLine(clientId);
	}
	@Override
	public List getAllFocusCityline(String clientId){
		return focusDao.getAllFocusCityline(clientId);
	}
	@Override
	public List getAllFocusWarehouse(String clientId){
		return focusDao.getAllFocusWarehouse(clientId);
	}
	@Override
	public List getAllFocusCar(String clientId){
		return focusDao.getAllFocusCar(clientId);
	}
	@Override
	public List getAllFocusCompany(String clientId){
		return focusDao.getAllFocusCompany(clientId);
	}
	@Override
	public List getAllFocusGoods(String clientId){
		return focusDao.getAllFocusGoods(clientId);
	}
	
	@Override
	public List findFocusLine(String text,String clientId){
		String sql="from FocusLinetransportView ";
		if(text.equals("关注内容")){
			//查找时不考虑投诉主题
		}
		else sql+="where (startPlace like '%"+text+"%' or endPlace like '%"+text+"%') and clientId='"+clientId+"'";
		return focusDao.getFind(sql);
	}
	@Override
	public List findFocusCityline(String text,String clientId){
		String sql="from FocusCitylineView ";
		if(text.equals("关注内容")){
			//查找时不考虑投诉主题
		}
		else sql+="where name like '%"+text+"%' and clientId='"+clientId+"'";
		return focusDao.getFind(sql);
	}
	@Override
	public List findFocusWarehouse(String text,String clientId){
		String sql="from FocusWarehouseView ";
		if(text.equals("关注内容")){
			//查找时不考虑投诉主题
		}
		else sql+="where name like '%"+text+"%' and clientId='"+clientId+"'";
		return focusDao.getFind(sql);
	}
	@Override
	public List findFocusCar(String text,String clientId){
		String sql="from FocusCarView ";
		if(text.equals("关注内容")){
			//查找时不考虑投诉主题
		}
		else sql+="where carNum like '%"+text+"%' and clientId='"+clientId+"'";
		return focusDao.getFind(sql);
	}
	@Override
	public List findFocusCompany(String text,String clientId){
		String sql="from FocusCompanyView ";
		if(text.equals("关注内容")){
			//查找时不考虑投诉主题
		}
		else sql+="where companyName like '%"+text+"%' and clientId='"+clientId+"'";
		return focusDao.getFind(sql);
	}
	@Override
	public List findFocusGoods(String text,String clientId){
		String sql="from FocusGoodsView ";
		if(text.equals("关注内容")){
			//查找时不考虑投诉主题
		}
		else sql+="where name like '%"+text+"%' and clientId='"+clientId+"'";
		return focusDao.getFind(sql);
	}
	
	/**
	 * 搜索关注
	 */
	@Override
	public JSONArray searchFocus(FocusBean bean, HttpSession session) {
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Focus t where t.clientId=:clientId ";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		List<Focus> focusList=focusDao.find(hql, params);
		List<FocusBean> focusBeanList=new ArrayList<FocusBean>();
		/*for(Focus focus:focusList){
			FocusBean focusBean=new FocusBean();
			BeanUtils.copyProperties(focus, focusBean);
			focusBeanList.add(focusBean);
		}*/
		String search_content=bean.getSearch_content();
//		if(!"".equals(search_content) && search_content!=null){
			for(Focus focus:focusList){
				FocusBean focusBean=new FocusBean();
				if("linetransport".equals(focus.getFocusType())){
					Linetransport line=linetransportDao.get(Linetransport.class, focus.getFocusId());
					if("".equals(search_content) || (!"".equals(search_content) && line.getLineName().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setStartPlace(line.getStartPlace());
						focusBean.setEndPlace(line.getEndPlace());
						focusBean.setLineName(line.getLineName());
						focusBean.setRelDate(line.getRelDate());
						focusBean.setResourceId(line.getId());
						focusBean.setCarrierId(line.getCarrierId());
						focusBeanList.add(focusBean);
					}
				}else if("cityline".equals(focus.getFocusType())){
					Cityline cityline=citylineDao.get(Cityline.class, focus.getFocusId());
					if("".equals(search_content) || (!"".equals(search_content) && cityline.getName().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setName(cityline.getName());
						focusBean.setRelDate(cityline.getRelDate());
						focusBean.setResourceId(cityline.getId());
						focusBean.setCarrierId(cityline.getCarrierId());
						focusBeanList.add(focusBean);
					}
				}else if("car".equals(focus.getFocusType())){
					Carinfo car=carDao.get(Carinfo.class, focus.getFocusId());
					if("".equals(search_content) || (!"".equals(search_content) && car.getCarNum().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setCarNum(car.getCarNum());
						focusBean.setRelDate(car.getRelDate());
						focusBean.setResourceId(car.getId());
						focusBean.setCarrierId(car.getCarrierId());
						focusBeanList.add(focusBean);
					}
				}else if("company".equals(focus.getFocusType())){
					Carrierinfo company=companyDao.get(Carrierinfo.class, focus.getFocusId());
					if("".equals(search_content) || (!"".equals(search_content) &&company.getCompanyName().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setCompanyName(company.getCompanyName());
						focusBean.setRelDate(company.getRelDate());
						focusBean.setResourceId(company.getId());
						focusBean.setCarrierId(company.getId());
						focusBeanList.add(focusBean);
					}
				}else if("warehouse".equals(focus.getFocusType())){
					Warehouse warehouse=warehouseDao.get(Warehouse.class, focus.getFocusId());
					if("".equals(search_content) || (!"".equals(search_content) && warehouse.getName().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setRelDate(warehouse.getRelDate());
						focusBean.setName(warehouse.getName());
						focusBean.setResourceId(warehouse.getId());
						focusBean.setCarrierId(warehouse.getCarrierId());
						focusBeanList.add(focusBean);
					}
					
				}else if("goods".equals(focus.getFocusType())){
					Goodsform cargo=goodsinfoDao.get(Goodsform.class, focus.getFocusId());
					if("".equals(search_content) || (!"".equals(search_content) && cargo.getName().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setRelDate(cargo.getRelDate());
						focusBean.setName(cargo.getName());
						focusBean.setResourceId(cargo.getId());
						
						//FIXME  //没有设置id
						//focusBean.setCarrierId(line.getCarrierId());
						focusBeanList.add(focusBean);
					}
				}
//			}
		}
		
		//转成jsonarray
		JSONArray jsonArray=new JSONArray();
		for(FocusBean fBean: focusBeanList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(fBean);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
		
	}
	
	
}
