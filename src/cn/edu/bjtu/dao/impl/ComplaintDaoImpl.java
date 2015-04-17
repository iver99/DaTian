package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.ComplaintDao;
import cn.edu.bjtu.vo.Complaintform;
@Repository
public class ComplaintDaoImpl implements ComplaintDao
{
	@Resource
	HibernateTemplate ht;
	
	
	@Override
	public List getUserCompliant(String userId) {
		// TODO Auto-generated method stub
		return ht.find("from Complaintform where clientId='"+userId+"'");
	}

	@Override
	public Complaintform getComplaintInfo(String id) {
		return ht.get(Complaintform.class, id);
	}
	
	
}
