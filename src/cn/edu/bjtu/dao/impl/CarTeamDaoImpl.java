package cn.edu.bjtu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CarTeamDao;
import cn.edu.bjtu.vo.Carteam;
@Repository
public class CarTeamDaoImpl extends BaseDaoImpl<Carteam> implements CarTeamDao{
	
	
	@Override
	/**
	 * 返回具体车队信息
	 */
	public Carteam getCarteamInfo(String id) {
		
		return this.get(Carteam.class,id);
	}
}
