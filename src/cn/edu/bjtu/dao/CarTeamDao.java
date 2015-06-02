package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Carteam;

public interface CarTeamDao extends BaseDao<Carteam>{
	public List getCarteam(String carrierId);
	public Carteam getCarteamInfo(String id);
}
