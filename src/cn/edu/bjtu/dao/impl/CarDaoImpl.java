package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Driverinfo;

@Repository
public class CarDaoImpl implements CarDao{
	
	@Resource
	private HibernateTemplate ht;
	@Resource 
	private HQLTool hqltool;
	
	@Override
	/**
	 * 返回所有车辆信息
	 * 视图查询
	 * 
	 */
	public List getAllCar(int Display,int PageNow) {
		// TODO Auto-generated method stub
		int page = PageNow;
		int pageSize = Display;
		String hql=" from CarCarrierView";
		
		return hqltool.getQueryList(hql, page, pageSize);//dao层分批取数据方法
		
	}
	
	@Override
	/**
	 * 返回具体车辆信息
	 */
	public Carinfo getCarInfo(String carid) {
		// TODO Auto-generated method stub
		return ht.get(Carinfo.class, carid);
		
	}

	@Override
	/**
	 * 返回所有司机信息
	 */
	public List getAllDriver() {
		// TODO Auto-generated method stub
		return ht.find("from Driverinfo");
	}

	@Override
	public Driverinfo getDriverInfo(String driverId) {
		// TODO Auto-generated method stub
		return ht.get(Driverinfo.class,driverId);
	}

	@Override
	/**
	 * 返回公司车辆
	 */
	public List getCompanyCar(String carrierId) {
		// TODO Auto-generated method stub
		return ht.find("from Carinfo where carrierId='"+carrierId+"'");
	}

	@Override
	/**
	 * 获取某公司的所有司机姓名 
	 */
	public List getAllDriverName(String carrierId) {
		// TODO Auto-generated method stub
		return ht.find("select driverName from Driverinfo where carrierId='"+carrierId+"'");
	}

	@Override
	public String getDriverIdByName(String driverName) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	/**
	 * 返回公司司机
	 */
	public List getCompanyDriver(String carrier) {
		// TODO Auto-generated method stub
		return ht.find("from Driverinfo where carrierId='"+carrier+"'");
	}
	
	
	@Override
	public List getSelectedCar(String hql, int display, int pageNow) {
		// TODO Auto-generated method stub
		//System.out.println("hql+"+hql);
		int page = pageNow;
		int pageSize = display;

		return hqltool.getQueryList(hql, page, pageSize);//Dao层分页函数提取到此方法
	}
	
}
