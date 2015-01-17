package cn.edu.bjtu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.bjtu.dao.LoginDao;
import cn.edu.bjtu.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{	
	
	@Resource(name="loginDaoImpl")
	private LoginDao loginDao;
	
	@Override
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		
		/*这里进行一些逻辑处理*/
		
		
		return loginDao.checkLogin(username, password); 
	}

}
