package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;

public interface AuthenticationDao extends BaseDao<Userinfo> {
	public List<Userinfo> getAllAuthentication();
	public Clientinfo getAuthenticationInfo(String clientId);
	public Userinfo getMyUserDetail(String clientId);
	public List getFindUser(String username);

}
