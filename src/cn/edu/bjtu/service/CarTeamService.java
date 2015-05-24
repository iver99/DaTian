package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Carteam;

public interface CarTeamService {
	public List getCarteam(String carrierId);
	public Carteam getCarteamInfo(String id);
	public boolean insertCarteam(String teamName,String carCount,String chief,String phone,
			String explaination,String carrierId);
	public boolean deleteCarteam(String id);
	public boolean updateCarteam(String id,String teamName,String carCount,String chief,String phone,
			String explaination);

}
