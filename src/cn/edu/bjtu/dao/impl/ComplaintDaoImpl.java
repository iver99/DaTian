package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.ComplaintDao;

import cn.edu.bjtu.vo.Complaintform;

@Repository
public class ComplaintDaoImpl extends BaseDaoImpl<Complaintform> implements ComplaintDao
{
	@Resource
	HibernateTemplate ht;

	@Override
	/**
	 * 获取所有投诉 
	 */
	public List getAllUserCompliant() {
		
		return ht.find("from ComplaintClientView");
	}

	
	@Override
	public List getFindComplaint(String sql){
		return ht.find(sql);
	}
}
