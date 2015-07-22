package cn.edu.bjtu.service.impl;

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

import cn.edu.bjtu.bean.search.WarehouseSearchBean;
import cn.edu.bjtu.dao.WarehouseDao;
import cn.edu.bjtu.service.WarehouseService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Linetransport;
import cn.edu.bjtu.vo.Warehouse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Repository
/**
 * 
 * @author RussWest0
 *
 */
@Transactional
public class WarehouseServiceImpl implements WarehouseService {

	@Resource
	WarehouseDao warehouseDao;
	@Resource
	Warehouse warehouse;
	/*@Resource
	BaseDao baseDao;*/
	@Resource
	HQLTool hqltool;


	@Override
	/**
	 * 条件筛选车辆
	 */
	@Deprecated
	public List getSelectedWarehouse(String city, String type,
			String storageForm, String houseArea, int Display, int PageNow) {

		if (type.equals("保税仓库")) {
			type = "保税";
		} else if (type.equals("非保税仓库")) {
			type = "非保税";
		}

		if (storageForm.equals("普通仓库")) {
			storageForm = "普通";
		} else if (storageForm.equals("冷藏仓库")) {
			storageForm = "冷藏";
		} else if (storageForm.equals("恒温仓库")) {
			storageForm = "恒温";
		} else if (storageForm.equals("露天仓库")) {
			storageForm = "露天";
		} else if (storageForm.equals("危险品仓库")) {
			storageForm = "危险品";
		}

		String sql = "";
		String hql = "from WarehouseCarrierView ";// 会变化
		if (houseArea.equals("大于1万平方米")) {

			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);

			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 10000";
			} else
				sql += "and houseArea > 10000";

		} else if (houseArea.equals("大于2万平方米")) {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 20000";
			} else
				sql += "and houseArea > 20000";

		} else if (houseArea.equals("大于5万平方米")) {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 50000";
			} else
				sql += "and houseArea > 50000";

		} else {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);

		}
		return warehouseDao.getSelectedWarehouse(sql, Display, PageNow);
	}

	@Override
	/**
	 * 获取总记录条数 
	 */
	@Deprecated
	public int getTotalRows(String city, String type, String storageForm,
			String houseArea) {
		
		if (type.equals("保税仓库")) {
			type = "保税";
		} else if (type.equals("非保税仓库")) {
			type = "非保税";
		}

		if (storageForm.equals("普通仓库")) {
			storageForm = "普通";
		} else if (storageForm.equals("冷藏仓库")) {
			storageForm = "冷藏";
		} else if (storageForm.equals("恒温仓库")) {
			storageForm = "恒温";
		} else if (storageForm.equals("露天仓库")) {
			storageForm = "露天";
		} else if (storageForm.equals("危险品仓库")) {
			storageForm = "危险品";
		}

		String sql = "";
		String hql = "from WarehouseCarrierView ";// 会变化
		if (houseArea.equals("大于1万平方米")) {

			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);

			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 10000";
			} else
				sql += "and houseArea > 10000";

		} else if (houseArea.equals("大于2万平方米")) {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 20000";
			} else
				sql += "and houseArea > 20000";

		} else if (houseArea.equals("大于5万平方米")) {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 50000";
			} else
				sql += "and houseArea > 50000";

		} else {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);

		}

		return hqltool.getTotalRows(sql);// 这里的HQLTool实例千万不能自己new出来，用@Resource
	}

	@Override
	public Warehouse getWarehouseInfo(String Warehouseid) {
		

		return warehouseDao.getWarehouseInfo(Warehouseid);
	}

	@Override
	@Deprecated
	public List getCompanyWarehouse(String carrierId) {
		
		return warehouseDao.getCompanyWarehouse(carrierId);
	}

	@Override
	public boolean insertNewWarehouse(Warehouse warehouse,HttpServletRequest request,MultipartFile file){
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//保存文件
		String fileLocation=UploadFile.uploadFile(file, carrierId, "warehouse");

		warehouse.setId(IdCreator.createRepositoryId());
		warehouse.setCarrierId(carrierId);
		warehouse.setRelDate(new Date());
		//设置文件位置 
		warehouse.setDetailPrice(fileLocation);
		warehouseDao.save(warehouse);// 保存实体
		return true;
	}
	@Deprecated
	public boolean insertWarehouse(String name, String city, String address,
			String type, String kind, float houseArea, float yardArea,
			float height, String fireRate, String storageForm,
			String fireSecurity, String environment, String serviceContent,
			String contact, String phone, String remarks, String carrierId,String path,String fileName) {
		
		warehouse.setAddress(address);
		warehouse.setCarrierId(carrierId);
		warehouse.setCity(city);
		warehouse.setContact(contact);
		// warehouse.setDetailPrice(detailPrice);
		warehouse.setEnvironment(environment);
		warehouse.setFireRate(fireRate);
		warehouse.setFireSecurity(fireSecurity);
		warehouse.setHeight(height);
		warehouse.setHouseArea(houseArea);
		warehouse.setId(IdCreator.createRepositoryId());
		warehouse.setKind(kind);
		warehouse.setName(name);
		warehouse.setPhone(phone);
		warehouse.setRelDate(new Date());
		warehouse.setRemarks(remarks);
		warehouse.setServiceContent(serviceContent);
		warehouse.setStorageForm(storageForm);
		warehouse.setType(type);
		warehouse.setYardArea(yardArea);
		
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			warehouse.setDetailPrice(fileLocation);
		}
		 warehouseDao.save(warehouse);// 保存实体
		 return true;
	}

	@Override
	@Deprecated
	public boolean updateWarehouse(String id, String name, String city,
			String address, String type, String kind, float houseArea,
			float yardArea, float height, String fireRate, String storageForm,
			String fireSecurity, String environment, String serviceContent,
			String contact, String phone, String remarks, String carrierId,String path,String fileName) {
		

		warehouse = getWarehouseInfo(id);// 根据id查找到仓库信息
		warehouse.setName(name);
		warehouse.setCity(city);
		warehouse.setAddress(address);
		warehouse.setType(type);
		warehouse.setKind(kind);
		warehouse.setHouseArea(houseArea);
		warehouse.setYardArea(yardArea);
		warehouse.setHeight(height);
		warehouse.setFireRate(fireRate);
		warehouse.setStorageForm(storageForm);
		warehouse.setFireSecurity(fireSecurity);
		warehouse.setEnvironment(environment);
		warehouse.setServiceContent(serviceContent);
		warehouse.setContact(contact);
		warehouse.setPhone(phone);
		warehouse.setRelDate(new Date());
		warehouse.setRemarks(remarks);
		warehouse.setCarrierId(carrierId);
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			warehouse.setDetailPrice(fileLocation);
		}
		 warehouseDao.update(warehouse);// 保存实体
		 return true;
	}
	
	@Override
	public boolean updateNewWarehouse(Warehouse warehouse,HttpServletRequest request,MultipartFile file){
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//保存文件
		String fileLocation=UploadFile.uploadFile(file, carrierId, "warehouse");

		Warehouse warehouseInstance = warehouseDao.get(Warehouse.class,warehouse.getId());
		warehouseInstance.setName(warehouse.getName());
		warehouseInstance.setCity(warehouse.getCity());
		warehouseInstance.setAddress(warehouse.getAddress());
		warehouseInstance.setType(warehouse.getType());
		warehouseInstance.setKind(warehouse.getKind());
		warehouseInstance.setHouseArea(warehouse.getHouseArea());
		warehouseInstance.setYardArea(warehouse.getYardArea());
		warehouseInstance.setHeight(warehouse.getHeight());
		warehouseInstance.setFireRate(warehouse.getFireRate());
		warehouseInstance.setStorageForm(warehouse.getStorageForm());
		warehouseInstance.setFireSecurity(warehouse.getFireSecurity());
		warehouseInstance.setEnvironment(warehouse.getEnvironment());
		warehouseInstance.setServiceContent(warehouse.getServiceContent());
		warehouseInstance.setContact(warehouse.getContact());
		warehouseInstance.setPhone(warehouse.getPhone());
		warehouseInstance.setRelDate(new Date());
		warehouseInstance.setRemarks(warehouse.getRemarks());
		warehouseInstance.setCarrierId(carrierId);
		
		//设置文件位置 
		warehouseInstance.setDetailPrice(fileLocation);

		//更新
		warehouseDao.update(warehouseInstance);
		return true;
	}
	
	public boolean deleteWarehouse(String id){
		warehouse = getWarehouseInfo(id);// 根据id查找到仓库信息
		warehouseDao.delete(warehouse);
		return true;
	}

	/**
	 * 资源栏-仓库筛选
	 */
	@Override
	public JSONArray getSelectedWarehouseNew(WarehouseSearchBean warehouseBean,
			PageUtil pageUtil, HttpSession session) {
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
		}else{
			sql+=" where t2.focusType='warehouse' and t2.clientId='' ";
		}
		sql+=") t3 on t1.id=t3.focusId ";
		String wheresql=whereSql(warehouseBean,params);
		sql+=wheresql+" order by t1.relDate desc";
		
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
	
	/**
	 * where sql
	 * @param warehouseBean
	 * @param params
	 * @return
	 */
	private String whereSql(WarehouseSearchBean warehouseBean,Map<String,Object> params){
		String wheresql=" where 1=1 ";
		if(warehouseBean.getCity()!=null && !warehouseBean.getCity().equals("中文或拼音") && !warehouseBean.getCity().equals("All") && !warehouseBean.getCity().equals("")){
			wheresql+=" and t1.city=:city";
			params.put("city", warehouseBean.getCity());
		}
		if(warehouseBean.getType()!=null && !warehouseBean.getType().equals("") && !warehouseBean.getType().equals("All")&& !warehouseBean.getType().equals("")){
			String type=warehouseBean.getType();
			if(type.equals("保税仓库")){
				wheresql+=" and t1.type='保税'";
			}
			if(type.equals("非保税仓库")){
				wheresql+=" and t1.type='非保税'";
			}
		}
		if(warehouseBean.getStorageForm()!= null && !warehouseBean.getStorageForm().equals("") &&!warehouseBean.getStorageForm().equals("All")){
			String storageForm=warehouseBean.getStorageForm();
			if(storageForm.equals("普通仓库")){
				wheresql+=" and t1.storageForm='普通'";
			}
			if(storageForm.equals("冷藏仓库")){
				wheresql+=" and t1.storageForm='冷藏'";
			}
			if(storageForm.equals("恒温仓库")){
				wheresql+=" and t1.storageForm='恒温'";
			}
			if(storageForm.equals("露天仓库")){
				wheresql+=" and t1.storageForm='露天'";
			}
			if(storageForm.equals("危险品仓库")){
				wheresql+=" and t1.storageForm='危险品'";
			}
		}
		if(warehouseBean.getHouseArea()!=null && !warehouseBean.getHouseArea().equals("") && !warehouseBean.getHouseArea().equals("All")){
			String houseArea=warehouseBean.getHouseArea();
			if (houseArea.equals("大于1万平方米")) {
				wheresql+=" and t1.houseArea>=10000";
			}
			if (houseArea.equals("大于2万平方米")) {
				wheresql+=" and t1.houseArea>=20000";
			}
			if (houseArea.equals("大于5万平方米")) {
				wheresql+=" and t1.houseArea>=50000";
			}
		}
		
		return wheresql;
	}

	/**
	 * 资源栏-仓库筛选总记录数
	 */
	@Override
	public Integer getSelectedWarehouseTotalRows(
			WarehouseSearchBean warehouseBean) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from WarehouseCarrierView t1 "+whereSql(warehouseBean, params);
		Long count=warehouseDao.count(hql, params);
		
		return count.intValue();
	}
	
	/**
	 * 我的信息-货物信息
	 */
	@Override
	public JSONArray getUserWarehouseResource(HttpSession session,PageUtil pageUtil) {
		
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Warehouse t where t.carrierId=:carrierId order by t.relDate";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Warehouse> warehouseList=warehouseDao.find(hql, params,page,display);
		JSONArray jsonArray=new JSONArray();
		for(Warehouse warehouse:warehouseList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(warehouse);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	/**
	 * 我的信息-货物信息-总记录条数
	 */
	@Override
	public Integer getUserWarehouseResourceTotalRows(HttpSession session) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from Warehouse t where t.carrierId=:carrierId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		
		Long count =warehouseDao.count(hql, params);
		return count.intValue();
	}
	
}
