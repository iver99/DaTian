package cn.edu.bjtu.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.dao.DriverDao;
import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Driverinfo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
@Transactional
public class DriverServiceImpl implements DriverService{

	@Autowired
	DriverDao driverDao;
	@Autowired
	Driverinfo driverinfo;
	@Autowired
	CarDao carDao;
	
	
	@Override
	/**
	 * 返回所有司机信息
	 */
	public List getAllDriver() {
		
		return driverDao.getAllDriver();
	}

	@Override
	/**
	 * 通过driverid找到司机信息
	 */
	public Driverinfo getDriverInfo(String driverId) {
		
		return driverDao.getDriverInfo(driverId);
	}
	
	@Override
	/**
	 * 通过carid找到driverinfo
	 */
	public Driverinfo getDriverByCarId(String carId) {
		
		String driverId = ((Carinfo) carDao.getCarInfo(carId)).getDriverId();

		return driverDao.getDriverInfo(driverId);
	}

	@Override
	/**
	 * 获取所有的司机姓名，更新车辆页面使用
	 */
	public List getAllDriverName(String carrierId) {
		
		return driverDao.getAllDriverName(carrierId);
	}

	@Override
	public List getAllDriver(String carrierId) {
		
		return driverDao.getAllDriver(carrierId);
	}
	
	
	@Override
	// 未实现
	public String getDriverIdByName(String driverName) {
		
		return "";
	}

	@Override
	/**
	 * 新增司机
	 */
	public boolean insertDriver(String name, String sex, String licenceRate,
			String phone, String IDCard, String licenceNum, String licenceTime,
			String carrierId, String path, String fileName) {
		
		// driverinfo.setAge(age);
		driverinfo.setCarrierId(carrierId);
		driverinfo.setDriverName(name);
		driverinfo.setId(IdCreator.createDriverId());
		driverinfo.setIDCard(IDCard);
		driverinfo.setLicenceNum(licenceNum);
		driverinfo.setLicenceRate(licenceRate);
		driverinfo.setLicenceTime(stringToDate(licenceTime));
		driverinfo.setPhone(phone);
		driverinfo.setRelDate(new Date());
		driverinfo.setSex(sex);
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			driverinfo.setIdscans(fileLocation);
		}
		driverDao.save(driverinfo);// 保存实体
		return true;
	}

	@Override
	/**
	 * 返回公司司机
	 */
	public List getCompanyDriver(String carrierId) {
		
		return driverDao.getCompanyDriver(carrierId);
	}
	
	@Override
	/**
	 * 更新司机
	 */
	public boolean updateDriver(String id, String name, String sex,
			String IDCard, String licenceNum, String licenceRate,
			String licenceTime, String phone, String carrierId, String path,
			String fileName) {
		
		// driverinfo.setAge(age);
		driverinfo = getDriverInfo(id);// 根据id查找到车辆信息
		driverinfo.setDriverName(name);
		driverinfo.setSex(sex);
		driverinfo.setIDCard(IDCard);
		driverinfo.setLicenceNum(licenceNum);
		driverinfo.setLicenceRate(licenceRate);
		driverinfo.setLicenceTime(stringToDate(licenceTime));
		driverinfo.setPhone(phone);
		//driverinfo.setRelDate(new Date());
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			driverinfo.setIdscans(fileLocation);
		}
		driverDao.update(driverinfo);// 保存实体
		return true;
	}
	
	private static Date stringToDate(String str) {  
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
	/**
	 * 删除司机
	 * @param id
	 * @return
	 */
	public boolean deleteDriver(String id) {
		driverinfo = getDriverInfo(id);// 根据id查找到车辆信息
		driverDao.delete(driverinfo);
		return true;
	}
	/**
	 * 我的信息-司机信息
	 */
	@Override
	public JSONArray getUserDriverResource(HttpSession session,PageUtil pageUtil) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Driverinfo t where t.carrierId=:carrierId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Driverinfo> driverList=driverDao.find(hql, params,page,display);
		
		JSONArray jsonArray=new JSONArray();
		for(Driverinfo driver:driverList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(driver);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
		
	}

	/**
	 * 我的信息-司机信息-总记录条数
	 */
	@Override
	public Integer getUserDriverResourceTotalRows(HttpSession session) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from Driverinfo t where t.carrierId=:carrierId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		
		Long count=driverDao.count(hql, params);
		return count.intValue();
		
	}
	
}
