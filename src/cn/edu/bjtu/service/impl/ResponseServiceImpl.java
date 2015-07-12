package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.ResponseBean;
import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.dao.ResponseDao;
import cn.edu.bjtu.service.ResponseService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.Response;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
	@Autowired
	GoodsInfoDao goodsInfoDao;
	

	@Override
	/**
	 * 根据货物id得到货物信息
	 */
	public List<Response> getResponseListByGoodsId(String goodsId) {
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

	/**
	 * 红区用户的所有反馈 
	 */
	@Override
	public JSONArray getUserResponse(HttpSession session,PageUtil pageUtil) {
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Response t where t.carrierId=:carrierId order by t.relDate desc";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", userId);
		
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Response> respList=responseDao.find(hql, params,page,display);
		List<ResponseBean> beanList=new ArrayList<ResponseBean>();
		for(Response resp:respList){
			ResponseBean respBean=new ResponseBean();
			BeanUtils.copyProperties(resp, respBean);
			String cargoName=goodsInfoDao.get(Goodsform.class,resp.getGoodsId()).getName();
			respBean.setName(cargoName);
			
			beanList.add(respBean);
			
		}
		JSONArray jsonArray=new JSONArray();
		for(ResponseBean respBean:beanList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(respBean);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
	}

	/**
	 * 我的反馈-总条数
	 */
	@Override
	public Integer getUserResponseTotalRows(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from Response t where t.carrierId=:carrierId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", userId);
		
		Long count=responseDao.count(hql, params);
		
		return count.intValue();
	}
	
	
	
	
	
	
	

}
