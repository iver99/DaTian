package cn.edu.bjtu.dao;

import cn.edu.bjtu.vo.Userinfo;

public interface LoginDao {
	public Userinfo checkLogin(String username,String password,int userKind);
	

}
