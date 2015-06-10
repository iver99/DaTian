package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Driverinfo;

@Repository
public class CarDaoImpl extends BaseDaoImpl<Carinfo> implements CarDao{
	
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
	public List getAllCarWithoutPage() {
		// TODO Auto-generated method stub
		return ht.find(" from CarCarrierView");
	}
	
	@Override
	/**
	 * 返回所有车辆经纬度信息
	 * 视图查询
	 * 
	 */
	public List getAllLocation() {
		// TODO Auto-generated method stub
		return ht.find("from Carinfo");
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
	 * 返回公司车辆
	 */
	public List getCompanyCar(String carrierId) {
		// TODO Auto-generated method stub
		return ht.find("from Carinfo where carrierId='"+carrierId+"'");
	}

	
	
	
	@Override
	public List getSelectedCar(String hql, int display, int pageNow) {
		// TODO Auto-generated method stub
		int page = pageNow;
		int pageSize = display;

		return hqltool.getQueryList(hql, page, pageSize);//Dao层分页函数提取到此方法
	}


	
}
