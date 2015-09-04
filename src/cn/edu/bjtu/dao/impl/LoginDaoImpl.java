package cn.edu.bjtu.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.LoginDao;
import cn.edu.bjtu.vo.Userinfo;

@Repository
public class LoginDaoImpl extends BaseDaoImpl<Userinfo> implements LoginDao {


	@Resource
	Userinfo userinfo;

	@Override
	public Userinfo checkLogin(String username, String password,int userKind) {
		
		//ÐèÒªÐÞ¸Ä 
		String hql="from Userinfo where username=:username and password=:password and userKind=:userKind";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("username", username);
		params.put("password", password);
		params.put("userKind", userKind);
		
		return this.get(hql, params);
	}
	

	
	

}
