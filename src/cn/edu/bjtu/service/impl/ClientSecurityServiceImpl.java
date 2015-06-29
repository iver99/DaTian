package cn.edu.bjtu.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.dao.ClientSecurityDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.ClientSecurityService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;
@Service
@Transactional
public class ClientSecurityServiceImpl implements ClientSecurityService{

	
	@Autowired
	ClientSecurityDao clientSecurityDao;
	@Autowired
	UserinfoDao userinfoDao;
	@Autowired
	ClientDao clientDao;
	
	
	@Override
	public boolean bindEmail(String email,HttpSession session) {
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		//return clientSecurityDao.bindEmail(email,userId);
		Userinfo user = userinfoDao.get(Userinfo.class, userId);
		user.setEmail(email);
		user.setEmailStatus("已绑定");// 修改状态
		userinfoDao.update(user);
		if(userKind== 2){
			Clientinfo clientinfo = clientDao.get(Clientinfo.class, userId);
			clientinfo.setEmail(email);
			clientDao.update(clientinfo);
			
		}else if(userKind ==3){
			//FIXME 公司用户无法绑定邮箱
		}
		
		return true;

	}
	
	@Override
	public boolean checkOldPassword(String oldPassword,String userId) {
		
		return clientSecurityDao.checkOldPassword(oldPassword,userId);
	}
	@Override
	public boolean changePassword(String newPassword,String userId) {
		
		return clientSecurityDao.changePassword(newPassword,userId);
	}
	
	@Override
	public Userinfo getUserById(String userId) {
		
		return clientSecurityDao.getUserById(userId);
	}
	

	@Override
	/**
	 * 修改绑定邮箱
	 */
	public boolean changeBindEmail(String newEmail, String userId) {
		
		//if(checkEmail(newEmail))
			return clientSecurityDao.changeBindEmail(newEmail,userId);
		//return false;
	}

	@Override
	public boolean setSecurityQuestion(String q1, String q2, String q3,
			String a1, String a2, String a3, String uId) {
		
		if(q1.equals("请选择") || q2.equals("请选择") || q3.equals("请选择"))
			return false;
		if(a1.trim().equals("") || a2.trim().equals("")|| a3.trim().equals(""))
			return false;
		
		return clientSecurityDao.setSecurityQuestion(q1,q2,q3,a1,a2,a3,uId);
	}

	
	@Override
	public boolean checkAnswer(String a1, String a2, String a3,String uId) {
		
		if(a1.trim().equals("") || a2.trim().equals("") || a3.trim().equals(""))
			return false;
		
		return clientSecurityDao.checkAnswer(a1,a2,a3,uId);
	}

	/**
	 * 检查email格式(未实现)
	 * @param email
	 * @return
	 *//*
	private boolean checkEmail(String email)
	{
		return true;//未实现
	}*/

}
