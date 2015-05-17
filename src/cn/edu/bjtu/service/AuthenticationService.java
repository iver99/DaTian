package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.Userinfo;

public interface AuthenticationService {
	
	public List getAllAuthentication();
	public Clientinfo getAuthenticationInfo(String clientId);
	public boolean updateAuthenticStatus(String clientId,String status);
	public Userinfo getMyUserDetail(String clientId);

}
