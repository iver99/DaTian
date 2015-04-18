package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.LoginDao;
import cn.edu.bjtu.vo.Userinfo;

@Repository
public class LoginDaoImpl implements LoginDao {

	

	@Resource
	HibernateTemplate ht;
	@Resource
	Userinfo userinfo;

	@Override
	public String checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		//ÐèÒªÐÞ¸Ä 
		//userinfo=(Userinfo)ht.find("from Userinfo where username='"+username+"' and password='"+password+"'");
		List list=null;
		list=ht.find("from Userinfo where username='"+username+"' and password='"+password+"'");
		if(list.size()>0)
			userinfo=(Userinfo)list.get(0);
		if(userinfo!= null)
		{
			return userinfo.getId();
		}
		else
			return "";
	}
	

	
	

}
