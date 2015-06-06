package cn.edu.bjtu.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.dao.CarTeamDao;
import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;
@Transactional
@Service("carServiceImpl")
public class CarServiceImpl implements CarService {

	@Autowired
	CarDao carDao;
	@Resource
	Carinfo carinfo;
	
	/*@Resource
	BaseDao baseDao;*/
	@Resource
	LinetransportService linetransportService;
	/*@Autowired
	CarService carService;*/
	/*@Resource
	Driverinfo driverinfo;*/
	@Resource
	Carteam carteam;
	// List driverNameList=new ArrayList();
	@Resource
	HQLTool hqltool;
	
	
	@Override
	/**
	 * 返回所有车辆
	 */
	public List getAllCar(int Display, int PageNow) {
		// TODO Auto-generated method stub

		return carDao.getAllCar(Display, PageNow);
	}
	
	@Override
	/**
	 * 返回所有车辆
	 */
	public List getAllCarWithoutPage() {
		// TODO Auto-generated method stub

		return carDao.getAllCarWithoutPage();
	}
	
	@Override
	/**
	 * 返回车辆位置
	 */
	public List getAllLocation() {
		// TODO Auto-generated method stub

		return carDao.getAllLocation();
	}

	@Override
	/**
	 * 条件筛选车辆
	 */
	public List getSelectedCar(String carLocation, String carBase,
			String carLength, String carWeight, int Display, int PageNow) {

		String[] paramList = { "carLocation", "carBase", "carLength",
				"carWeight" };// 没startplace1
		String[] valueList = { carLocation, carBase, carLength, carWeight };
		String hql = "from CarCarrierView ";// 会变化
		String sql = HQLTool.spellHql2(hql, paramList, valueList);
		// System.out.println("hql+" + sql);
		return carDao.getSelectedCar(sql, Display, PageNow);
	}

	@Override
	/**
	 * 获取总记录条数 
	 */
	public int getTotalRows(String carLocation, String carBase,
			String carLength, String carWeight) {
		// TODO Auto-generated method stub
		String[] paramList = { "carLocation", "carBase", "carLength",
				"carWeight" };// 没startplace1
		String[] valueList = { carLocation, carBase, carLength, carWeight };
		String hql = "from CarCarrierView ";// 会变化
		String sql = HQLTool.spellHql2(hql, paramList, valueList);
		// System.out.println("hql+"+sql);
		return hqltool.getTotalRows(sql);// 这里的HQLTool实例千万不能自己new出来，用@Resource
	}

	@Override
	/**
	 * 返回特定车辆信息
	 */
	public Carinfo getCarInfo(String carid) {
		// TODO Auto-generated method stub

		return carDao.getCarInfo(carid);
	}

	

	@Override
	public List getCompanyCar(String carrierId) {
		// TODO Auto-generated method stub
		return carDao.getCompanyCar(carrierId);
	}

	

	@Override
	/**
	 * 增加车辆
	 */
	public boolean insertCar(String carNum, String carTeam,
			String locationType, String terminalId, String carBase, String carBrand,
			String carType, String carUse, double carLength, double carWidth,
			double carHeight, double carWeight, String driverId,
			String purchaseTime, String storage, String startPlace,
			String endPlace, String stopPlace, String carrierId) {
		// TODO Auto-generated method stub
		
		carinfo.setId(IdCreator.createCarId());
		carinfo.setCarNum(carNum);
		carinfo.setCarTeam(carTeam);
		carinfo.setLocationType(locationType);
		carinfo.setTerminalId(terminalId);
		carinfo.setCarBase(carBase);
		carinfo.setCarBrand(carBrand);
		carinfo.setCarType(carType);
		carinfo.setCarUse(carUse);
		carinfo.setCarLength(carLength);
		carinfo.setCarWidth(carWidth);
		carinfo.setCarHeight(carHeight);
		carinfo.setCarWeight(carWeight);
		carinfo.setDriverId(driverId);
		carinfo.setPurchaseTime(stringToDate(purchaseTime));
		carinfo.setStorage(storage);
		carinfo.setStartPlace(startPlace);
		carinfo.setEndPlace(endPlace);
		carinfo.setStopPlace(stopPlace);
		carinfo.setCarrierId(carrierId);
		carinfo.setRelDate(new Date());
		
		carDao.save(carinfo);
		return true;
	}

	

	@Override
	/**
	 * 更新车辆信息
	 */
	public boolean updateCar(String id, String carNum, String carTeam,
			String locType, String terminalId, String carType, String carBase,
			String carBrand, String carUse, double carLength, double carWidth,
			double carHeight, double carWeight, String carPurTime,
			String storage, String driverId, String startPlace,// 缺少参数
			String endPlace,// 缺少参数
			String stopPlace,// 缺少参数
			String carrierId) {
		// TODO Auto-generated method stub
		System.out.println("in updateCar");// null
		carinfo = getCarInfo(id);// 根据id查找到车辆信息
		carinfo.setCarTeam(carTeam);
		carinfo.setLocationType(locType);
		carinfo.setTerminalId(terminalId);
		carinfo.setCarType(carType);
		carinfo.setCarBase(carBase);
		carinfo.setCarBrand(carBrand);
		carinfo.setCarUse(carUse);
		carinfo.setCarLength(carLength);
		carinfo.setCarWidth(carWidth);
		carinfo.setCarHeight(carHeight);
		carinfo.setCarWeight(carWeight);
		carinfo.setPurchaseTime(stringToDate(carPurTime));
		carinfo.setStorage(storage);
		carinfo.setDriverId(driverId);
		carinfo.setStopPlace(stopPlace);
		carinfo.setStartPlace(startPlace);
		carinfo.setEndPlace(endPlace);
		carDao.update(carinfo);
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
	 * 删除车辆
	 * @param id
	 * @return
	 */
	public boolean deleteCar(String id) {
		carinfo = getCarInfo(id);// 根据id查找到车辆信息

		carDao.delete(carinfo);
		return true;
	}

	
}
