package cn.edu.bjtu.dao;

import cn.edu.bjtu.vo.Userinfo;

public interface ClientSecurityDao {
	public boolean checkOldPassword(String oldPassword,String userId);
	
	public boolean changePassword(String newPassword,String userId);
	
	public boolean bindEmail(String email ,String userId);
	
	public Userinfo getUserById(String userId);
	
	public boolean changeBindEmail(String newEmail,String userId);
	
	public boolean setSecurityQuestion(String q1,String q2,String q3,String a1,String a2,String a3,String uId);
	public boolean checkAnswer(String a1,String a2,String a3,String userId);


}
