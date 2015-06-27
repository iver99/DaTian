package cn.edu.bjtu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.AuthenticationDao;
import cn.edu.bjtu.dao.UserinfoDao;
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
	@Autowired
	UserinfoDao userinfoDao;	
	
	/*@Resource
	BaseDao baseDao;*/
	@Resource
	HQLTool hqltool;
	@Resource
	private HibernateTemplate ht;

	private String hql = "";
	private static boolean flag = false;
	
	@Override
	/**
	 * 获取所有认证信息
	 */
	public List<Userinfo> getAllAuthentication() {
		
		return authenticationDao.getAllAuthentication();
	}
	@Override
	/**
	 * 获取个人信息
	 * @param clientId
	 * return
	 */
	public Userinfo getMyUserDetail(String clientId) {
		
		return authenticationDao.getMyUserDetail(clientId);
	}
	@Override
	/**
	 * 获取个人信息
	 * @param clientId
	 * return
	 */
	public Clientinfo getAuthenticationInfo(String clientId) {
		
		return authenticationDao.getAuthenticationInfo(clientId);
	}
	
	 @Override
	 /**
	  * 更新认证状态
	  * @param clientId
	  * @param status
	  */
	public boolean updateAuthenticStatus(String feedback, String clientId,String status) {
			
		userinfo = getMyUserDetail(clientId);
		userinfo.setFeedback(feedback);
		userinfo.setStatus(status);
		authenticationDao.update(userinfo);//保存实体
		 return true;
	}
	@Override
	public List getFindUser(String username) {
		
		return authenticationDao.getFindUser(username);
	}
	
	/**
	 * 个人用户审核拒绝
	 */
	@Override
	public boolean authenUserDeny(String feedback, String user_id) {
		
		Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("未验证");
		userinfo.setFeedback(feedback);
		
		userinfoDao.update(userinfo);
		return true;
	}
	
	/**
	 * 个人用户审合通过
	 */
	@Override
	public boolean authenUserPass(String feedback, String user_id) {
		
		Userinfo userinfo = userinfoDao.get(Userinfo.class, user_id);

		userinfo.setStatus("已审核");
		userinfo.setFeedback(feedback);

		userinfoDao.update(userinfo);
		return true;
	}
	/**
	 * 公司用户验证拒绝
	 */
	@Override
	public boolean authenCompanyDeny(String feedback, String user_id) {
		
		Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("未验证");
		userinfo.setFeedback(feedback);
		userinfoDao.update(userinfo);
		
		return true;
		
	}
	
	/**
	 * 公司用户验证通过
	 */
	@Override
	public boolean authenCompanyPass(String feedback, String user_id) {

Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("已审核");
		userinfo.setFeedback(feedback);
		userinfoDao.update(userinfo);
		
		return true;
	
	}
	
	
	
}
