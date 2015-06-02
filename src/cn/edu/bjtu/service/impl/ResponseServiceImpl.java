package cn.edu.bjtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.ResponseDao;
import cn.edu.bjtu.service.ResponseService;
import cn.edu.bjtu.vo.Response;
@Service
@Transactional
/**
 * 反馈service实现
 * @author RussWest0
 * @date   2015年6月2日 上午11:08:09
 */
public class ResponseServiceImpl implements ResponseService{

	@Autowired
	ResponseDao responseDao;
	
	@Override
	/**
	 * 根据id得到response实例
	 */
	public Response getResponseById(String responseId) {
		// TODO Auto-generated method stub
		
		return responseDao.get(Response.class, responseId);
	}
	
	

}
