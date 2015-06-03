package cn.edu.bjtu.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.dao.DriverDao;
import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Driverinfo;

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
		// TODO Auto-generated method stub
		return driverDao.getAllDriver();
	}

	@Override
	/**
	 * 通过driverid找到司机信息
	 */
	public Driverinfo getDriverInfo(String driverId) {
		// TODO Auto-generated method stub
		return driverDao.getDriverInfo(driverId);
	}
	
	@Override
	/**
	 * 通过carid找到driverinfo
	 */
	public Driverinfo getDriverByCarId(String carId) {
		// TODO Auto-generated method stub
		String driverId = ((Carinfo) carDao.getCarInfo(carId)).getDriverId();

		return driverDao.getDriverInfo(driverId);
	}

	@Override
	/**
	 * 获取所有的司机姓名，更新车辆页面使用
	 */
	public List getAllDriverName(String carrierId) {
		// TODO Auto-generated method stub
		return driverDao.getAllDriverName(carrierId);
	}

	@Override
	public List getAllDriver(String carrierId) {
		// TODO Auto-generated method stub
		return driverDao.getAllDriver(carrierId);
	}
	
	
	@Override
	// 未实现
	public String getDriverIdByName(String driverName) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	/**
	 * 新增司机
	 */
	public boolean insertDriver(String name, String sex, String licenceRate,
			String phone, String IDCard, String licenceNum, String licenceTime,
			String carrierId, String path, String fileName) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
}
