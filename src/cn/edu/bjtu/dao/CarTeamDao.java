package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Carteam;

public interface CarTeamDao extends BaseDao<Carteam>{
	public Carteam getCarteamInfo(String id);
}
