package cn.edu.bjtu.service;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.vo.Userinfo;

public interface ClientSecurityService {
	
	public boolean checkOldPassword(String oldPassword,String userId);
	public boolean changePassword(String newPassword,String userId);
	
	public boolean bindEmail(String email,HttpSession session);
	
	public Userinfo getUserById(String userId);
	public boolean changeBindEmail(String newEmail,HttpSession session);
	
	public boolean setSecurityQuestion(String q1,String q2,String q3,String a1,String a2,String a3,String uId);
	public boolean checkAnswer(String  a1,String a2,String a3,String uId);


}
