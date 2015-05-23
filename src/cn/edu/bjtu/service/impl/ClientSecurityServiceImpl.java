package cn.edu.bjtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.ClientSecurityDao;
import cn.edu.bjtu.service.ClientSecurityService;
import cn.edu.bjtu.vo.Userinfo;
@Service
@Transactional
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

	@Override
	public boolean setSecurityQuestion(String q1, String q2, String q3,
			String a1, String a2, String a3, String uId) {
		// TODO Auto-generated method stub
		if(q1.equals("请选择") || q2.equals("请选择") || q3.equals("请选择"))
			return false;
		if(a1.trim().equals("") || a2.trim().equals("")|| a3.trim().equals(""))
			return false;
		
		return clientSecurityDao.setSecurityQuestion(q1,q2,q3,a1,a2,a3,uId);
	}

	
	@Override
	public boolean checkAnswer(String a1, String a2, String a3,String uId) {
		// TODO Auto-generated method stub
		if(a1.trim().equals("") || a2.trim().equals("") || a3.trim().equals(""))
			return false;
		
		return clientSecurityDao.checkAnswer(a1,a2,a3,uId);
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
