package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.CarTeamDao;
import cn.edu.bjtu.service.CarTeamService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carteam;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
@Transactional
public class CarTeamServiceImpl implements CarTeamService{
	
	@Autowired
	CarTeamDao carTeamDao;
	@Autowired
	Carteam carteam;

	@Override
	public List<Carteam> getCarteam(String carrierId) {
		
		String hql="from Carteam t where t.carrierId=:carrierId ";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		return carTeamDao.find(hql, params);
	}

	@Override
	public Carteam getCarteamInfo(String id) {
		
		return carTeamDao.getCarteamInfo(id);
	}

	@Override
	public boolean insertCarteam(String teamName, String carCount,
			String chief, String phone, String explaination, String carrierId) {
		carteam.setTeamName(teamName);
		carteam.setCarCount(carCount);
		carteam.setCarrierId(carrierId);
		carteam.setChief(chief);
		carteam.setPhone(phone);
		carteam.setExplaination(explaination);
		carteam.setRelDate(new Date());
		// return true;
		carTeamDao.save(carteam);// 保存实体
		return true;
	}

	@Override
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public boolean deleteCarteam(String id) {
		carteam = getCarteamInfo(id);// 根据id查找到车辆信息
		carTeamDao.delete(carteam);
		return true;
	}

	@Override
	public boolean updateCarteam(String id, String teamName, String carCount,
			String chief, String phone, String explaination) {
		carteam = getCarteamInfo(id);// 根据id查找到车辆信息
		carteam.setTeamName(teamName);
		carteam.setCarCount(carCount);
		carteam.setChief(chief);
		carteam.setPhone(phone);
		carteam.setExplaination(explaination);
		// return true;
		carTeamDao.update(carteam);// 保存实体
		return true;
	}
	
	/**
	 * 我的信息-我的资源-车辆信息-车队信息
	 */
	@Override
	public String getUserCarTeamResource(HttpSession session, PageUtil pageUtil) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Carteam t where t.carrierId=:carrierId order by t.relDate desc";
		params.put("carrierId", carrierId);
		
		List<Carteam> carTeamList=carTeamDao.find(hql, params);
		JSONArray jsonArray=new JSONArray();
		for(Carteam carteam:carTeamList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(carteam);
			jsonArray.add(carteam);
		}
		
		return jsonArray.toString();
	}

	/**
	 * 我的信息-我的资源-车辆信息=车队信息=总记录是
	 */
	@Override
	public Integer getUserCarTeamResourceTotalRows(HttpSession session) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Carteam t where t.carrierId=:carrierId ";
		params.put("carrierId", carrierId);
		
		Long count=carTeamDao.count(hql, params);
		
		return count.intValue();
	}
}
