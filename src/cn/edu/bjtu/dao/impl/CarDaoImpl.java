package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CarDao;

import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Driverinfo;

@Repository
public class CarDaoImpl extends BaseDaoImpl<Carinfo> implements CarDao{
	
	@Resource
	private HibernateTemplate ht;
	
	@Override
	/**
	 * 返回具体车辆信息
	 */
	public Carinfo getCarInfo(String carid) {
		
		return ht.get(Carinfo.class, carid);
		
	}


	
}
