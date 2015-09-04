package cn.edu.bjtu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.ComplaintClientViewDao;
import cn.edu.bjtu.dao.ComplaintDao;
import cn.edu.bjtu.vo.Complaintform;

@Repository
public class ComplaintDaoImpl extends BaseDaoImpl<Complaintform> implements ComplaintDao
{
	@Autowired
	ComplaintClientViewDao complaintClientViewDao;
	
	/**
	 * 获取所有投诉 
	 */
	@Override
	public List getAllUserCompliant() {
		
		return complaintClientViewDao.find("from ComplaintClientView");
	}

	
}
