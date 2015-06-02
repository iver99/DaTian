package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.RegisterDao;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.Userinfo;
@Repository
public class RegisterDaoImpl extends BaseDaoImpl<Userinfo> implements RegisterDao{
	@Resource
	private HibernateTemplate ht;
	@Resource
	private HQLTool hqltool;
	@Override
	public List getUserCheck(String username) {
		// TODO Auto-generated method stub
		return ht.find("From Userinfo where username='" + username + "'");
	}

}
