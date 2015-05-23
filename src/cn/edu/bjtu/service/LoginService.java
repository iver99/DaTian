package cn.edu.bjtu.service;

import cn.edu.bjtu.vo.Userinfo;

public interface LoginService {
	
	public Userinfo checkLogin(String username,String password,int userKind);
}
