package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Linetransport;

public interface LinetransportDao extends BaseDao<Linetransport>{


	public Linetransport getLinetransportInfo(String linetransportid);
	

	
}
