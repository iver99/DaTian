package cn.edu.bjtu.dao;

import cn.edu.bjtu.vo.Userinfo;

public interface ClientSecurityDao {
	public boolean checkOldPassword(String oldPassword,String userId);
	
	public boolean changePassword(String newPassword,String userId);
	
	public boolean bindEmail(String email ,String userId);
	
	public Userinfo getUserById(String userId);
	
	public boolean changeBindEmail(String newEmail,String userId);
}
