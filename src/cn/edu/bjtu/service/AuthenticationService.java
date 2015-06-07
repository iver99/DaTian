package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;

public interface AuthenticationService {
	
	public List<Userinfo> getAllAuthentication();
	public Clientinfo getAuthenticationInfo(String clientId);
	public boolean updateAuthenticStatus(String feedback, String clientId,String status);
	public Userinfo getMyUserDetail(String clientId);
	public List getFindUser(String username);
	
	
	/**
	 * 个人用户验证拒绝
	 * @param feedback
	 * @param user_id
	 * @return
	 */
	public boolean authenUserDeny(String feedback,String user_id);
	
	/**
	 * 个人用户验证通过
	 * @param feedback
	 * @param user_id
	 * @return
	 */
	public boolean authenUserPass(String feedback,String user_id);
	
	/**
	 * 公司验证拒绝
	 * @param feedback
	 * @param user_id
	 * @return
	 */
	public boolean authenCompanyDeny(String feedback,String user_id);
	
	/**
	 * 公司验证通过
	 * @param feedback
	 * @param user_id
	 * @return
	 */
	public boolean authenCompanyPass(String feedback,String user_id);
}
