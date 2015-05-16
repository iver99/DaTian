package cn.edu.bjtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bjtu.dao.ClientSecurityDao;
import cn.edu.bjtu.service.ClientSecurityService;
import cn.edu.bjtu.vo.Userinfo;
@Service
public class ClientSecurityServiceImpl implements ClientSecurityService{

	
	@Autowired
	ClientSecurityDao clientSecurityDao;
	
	@Override
	public boolean bindEmail(String email, String userId) {
		// TODO Auto-generated method stub
		if(!checkEmail(email))
			return false;
		return clientSecurityDao.bindEmail(email,userId);
	}
	
	@Override
	public boolean checkOldPassword(String oldPassword,String userId) {
		// TODO Auto-generated method stub
		return clientSecurityDao.checkOldPassword(oldPassword,userId);
	}
	@Override
	public boolean changePassword(String newPassword,String userId) {
		// TODO Auto-generated method stub
		return clientSecurityDao.changePassword(newPassword,userId);
	}
	
	@Override
	public Userinfo getUserById(String userId) {
		// TODO Auto-generated method stub
		return clientSecurityDao.getUserById(userId);
	}
	

	@Override
	/**
	 * 修改绑定邮箱
	 */
	public boolean changeBindEmail(String newEmail, String userId) {
		// TODO Auto-generated method stub
		if(checkEmail(newEmail))
			return clientSecurityDao.changeBindEmail(newEmail,userId);
		return false;
	}

	/**
	 * 检查email格式(未实现)
	 * @param email
	 * @return
	 */
	private boolean checkEmail(String email)
	{
		return true;//未实现
	}

}
