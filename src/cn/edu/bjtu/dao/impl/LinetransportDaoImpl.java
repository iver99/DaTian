package cn.edu.bjtu.dao.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.LinetransportDao;

import cn.edu.bjtu.vo.Linetransport;

@Repository
public class LinetransportDaoImpl extends BaseDaoImpl<Linetransport> implements LinetransportDao {


	/**
	 * 返回具体干线信息
	 */
	@Override
	public Linetransport getLinetransportInfo(String linetransportid) {
		
		return this.get(Linetransport.class, linetransportid);
	}


}
