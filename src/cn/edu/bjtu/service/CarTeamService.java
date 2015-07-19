package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carteam;

public interface CarTeamService {
	public List<Carteam> getCarteam(String carrierId);
	public Carteam getCarteamInfo(String id);
	public boolean insertCarteam(String teamName,String carCount,String chief,String phone,
			String explaination,String carrierId);
	public boolean deleteCarteam(String id);
	public boolean updateCarteam(String id,String teamName,String carCount,String chief,String phone,
			String explaination);
	
	/**
	 * 我的信息-我的资源-车辆信息-车队信息
	 * @Title: getUserCarTeamResource 
	 * @Description: TODO 
	 * @param: @param session
	 * @param: @param pageUtil
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月15日 上午11:21:10
	 */
	public String getUserCarTeamResource(HttpSession session,PageUtil pageUtil);
	
	/**
	 * 我的信息-我的资源-车辆信息=车队信息=总记录是
	 * @Title: getUserCarTeamResourceTotalRows 
	 * @Description: TODO 
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月15日 上午11:21:45
	 */
	public Integer getUserCarTeamResourceTotalRows(HttpSession session);


}
