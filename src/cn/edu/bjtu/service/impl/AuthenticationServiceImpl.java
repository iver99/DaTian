package cn.edu.bjtu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.AuthenticationDao;
import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.service.AuthenticationService;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;
@Transactional
@Service("authenticationServiceImpl")
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Resource
	Userinfo userinfo;
	@Autowired
	AuthenticationDao authenticationDao;
	/*@Resource
	BaseDao baseDao;*/
	@Resource
	HQLTool hqltool;

	private String hql = "";
	private static boolean flag = false;
	
	@Override
	/**
	 * 获取所有认证信息
	 */
	public List getAllAuthentication() {
		// TODO Auto-generated method stub
		
		return authenticationDao.getAllAuthentication();
	}
	@Override
	/**
	 * 获取个人信息
	 * @param clientId
	 * return
	 */
	public Userinfo getMyUserDetail(String clientId) {
		// TODO Auto-generated method stub
		return authenticationDao.getMyUserDetail(clientId);
	}
	@Override
	/**
	 * 获取个人信息
	 * @param clientId
	 * return
	 */
	public Clientinfo getAuthenticationInfo(String clientId) {
		// TODO Auto-generated method stub
		return authenticationDao.getAuthenticationInfo(clientId);
	}
	
	 @Override
	 /**
	  * 更新认证状态
	  * @param clientId
	  * @param status
	  */
	public boolean updateAuthenticStatus(String clientId,String status) {
			// TODO Auto-generated method stub
		userinfo = getMyUserDetail(clientId);
		userinfo.setStatus(status);
		authenticationDao.update(userinfo);//保存实体
		 return true;
	}
}
