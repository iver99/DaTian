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
	 * 返回具体车辆信息
	 */
	public Carinfo getCarInfo(String carid) {
		
		return ht.get(Carinfo.class, carid);
		
	}


	@Override
	/**
	 * 返回公司车辆
	 */
	public List getCompanyCar(String carrierId) {
		
		return ht.find("from Carinfo where carrierId='"+carrierId+"'");
	}

	
	
	
	@Override
	@Deprecated
	public List getSelectedCar(String hql, int display, int pageNow) {
		
		int page = pageNow;
		int pageSize = display;

		return hqltool.getQueryList(hql, page, pageSize);//Dao层分页函数提取到此方法
	}


	
}
