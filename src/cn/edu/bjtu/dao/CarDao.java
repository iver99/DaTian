package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Driverinfo;

public interface CarDao extends BaseDao<Carinfo>{
	
	public Carinfo getCarInfo(String carid);
	
	
}
