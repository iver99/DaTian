package cn.edu.bjtu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Userinfo checkLogin(String username, String password,int userKind) {
		// TODO Auto-generated method stub
		//需要修改 
		//userinfo=(Userinfo)ht.find("from Userinfo where username='"+username+"' and password='"+password+"'");
		List list=null;
		String hql="from Userinfo where username='"+username+"' and password='"+password+"'"+" and userKind="+userKind;
		list=ht.find(hql);
		if(list.size()>0){
			userinfo=(Userinfo)list.get(0);
			return userinfo;
		}
		else
			return null;//不存在次用户
		/*if(userinfo!= null)
		{
			return userinfo;
		}
		else
			return null;*/
	}
	

	
	

}
