package cn.edu.bjtu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.LoginDao;
import cn.edu.bjtu.service.LoginService;
import cn.edu.bjtu.vo.Userinfo;
@Service
@Transactional
public class LoginServiceImpl implements LoginService{	
	
	@Resource(name="loginDaoImpl")
	private LoginDao loginDao;
	
	@Override
	public Userinfo checkLogin(String username, String password,int userKind) {
		// TODO Auto-generated method stub
		
		/*这里进行一些逻辑处理*/
		
		
		return loginDao.checkLogin(username, password,userKind); 
	}

}
