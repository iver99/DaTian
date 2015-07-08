package cn.edu.bjtu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.dao.BusinessClientDao;
import cn.edu.bjtu.service.BusinessClientService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Service
@Transactional
public class BusinessClientServiceImpl implements BusinessClientService{

	@Autowired
	BusinessClientDao businessClientDao;
	/**
	 * 我的信息-客户信息
	 */
	@Override
	public JSONArray getUserBusinessClient(HttpSession session,PageUtil pageUtil) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Businessclient t where t.carrierId=:userId";
		params.put("userId", userId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Businessclient> clientList=businessClientDao.find(hql, params,page,display);
		
		JSONArray jsonArray=new JSONArray();
		if(clientList!=null && clientList.size()>0){
			for(int i=0;i<clientList.size();i++){
				JSONObject jsonObject=(JSONObject)JSONObject.toJSON(clientList.get(i));
				jsonArray.add(jsonObject);
			}
			
		}
		
		return jsonArray;
	}
	
	
	/**
	 * 获取用户客户
	 */
	@Override
	public JSONArray getUserBusinessClient(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Businessclient t where t.carrierId=:userId";
		params.put("userId", userId);
		List<Businessclient> clientList=businessClientDao.find(hql, params);
		
		JSONArray jsonArray=new JSONArray();
		if(clientList!=null && clientList.size()>0){
			for(int i=0;i<clientList.size();i++){
				JSONObject jsonObject=(JSONObject)JSONObject.toJSON(clientList.get(i));
				jsonArray.add(jsonObject);
			}
			
		}
		
		return jsonArray;
	}



	/**
	 * 我的信息-客户信息-总记录数
	 */
	@Override
	public Integer getUserBusinessClientTotalRows(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Businessclient t where t.carrierId=:userId";
		params.put("userId", userId);
		Long count=businessClientDao.count(hql, params);
		return count.intValue();
	}

	@Override
	public boolean updateNewClient(Businessclient client,MultipartFile file,
			HttpServletRequest request){
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//保存文件
		String fileLocation=UploadFile.uploadFile(file, carrierId, "businessClient");

		Businessclient clientInstance = businessClientDao.get(Businessclient.class,client.getId());
		
		clientInstance.setAccount(client.getAccount());
		clientInstance.setClientName(client.getClientName());
		clientInstance.setClientBusiness(client.getClientBusiness());
		clientInstance.setContact(client.getContact());
		clientInstance.setPhone(client.getPhone());
		clientInstance.setRemarks(client.getRemarks());
		
		//设置文件位置 
		clientInstance.setRelatedMaterial(fileLocation);

		//更新
		businessClientDao.update(clientInstance);
		return true;
	}
}
