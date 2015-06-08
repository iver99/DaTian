package cn.edu.bjtu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * 根据货物id得到货物信息
	 */
	public List<Response> getResponseListByGoodsId(String goodsId) {
		// TODO 根据货物id得到货物信息
		Map<String,Object> params=new HashMap<String ,Object>();
		String hql="from Response where goodsId=:goodsId";
		params.put("goodsId", goodsId);
		List<Response> respList=responseDao.find(hql, params);
		return respList;
	}

	@Override
	/**
	 * 根据id返回单条反馈信息
	 */
	public Response getResponseById(String responseId) {
		return responseDao.get(Response.class, responseId);
	}

	

	/**
	 * 确认反馈操作，修改其它反馈信息状态
	 */
	@Override
	public boolean confirmResponse(String responseId, String carrierId,
			String goodsId) {
		//List<Response> confirmList=responseDao.find("from Response where ")
		Response confirmResp=responseDao.get(Response.class,responseId);
		if(confirmResp!=null){
			confirmResp.setStatus("已确认");//修改确认的反馈记录
			responseDao.update(confirmResp);
		}
		
		String hql="from Response where goodsId=:goodsId and carrierId <>:carrierId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		params.put("goodsId", goodsId);
		
		List<Response> unconfirmRespList=responseDao.find(hql,params);
		//修改该货物信息的其它反馈信息为已取消
		if(unconfirmRespList!=null){
			for(Response resp:unconfirmRespList){
				resp.setStatus("已取消");
				responseDao.update(resp);
				
			}
		}
		
		
		return true;
	}
	
	
	
	
	
	

}
