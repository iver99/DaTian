package cn.edu.bjtu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.SearchDao;
import cn.edu.bjtu.service.SearchService;

/**
 * ËÑË÷·þÎñ²ã
 * @author RussWest0
 *
 */
@Transactional
@Service
public class SearchServiceImpl implements SearchService{

	@Resource 
	SearchDao searchDao;
	@Override
	public List getLineResourceByStartPlace(String startPlace) {
		// TODO Auto-generated method stub
		
		return searchDao.getLineResourceByStartPlace(startPlace);
	}

	@Override
	public List getLineResourceByEndPlace(String endPlace) {
		// TODO Auto-generated method stub
		return searchDao.getLineResourceByStartPlace(endPlace);
	}

	@Override
	public List getCitylineResourceByName(String name) {
		// TODO Auto-generated method stub
		return searchDao.getCitylineResourceByName(name);
	}
	
	@Override
	public List getGoodsResourceByName(String name){
		return searchDao.getGoodsResourceByName(name);
	}
	
	@Override
	public List getCompanyResourceByCompanyName(String companyName){
		return searchDao.getCompanyResourceByCompanyName(companyName);
	}
	
	@Override
	public List getCarResourceByCarNum(String carNum){
		return searchDao.getCarResourceByCarNum(carNum);
	}
	
	@Override
	public List getWarehouseResourceByName(String name){
		return searchDao.getWarehouseResourceByName(name);
	}
	
}
