package cn.edu.bjtu.service;

import java.util.List;

/**
 * 
 * @author RussWest0
 *
 */
public interface RegisterService {
	public String register(String username,String password,String phone,int userKind);
	public List getUserCheck(String username);
	//public boolean registerInfo(String userId);
	
	
	/**
	 * ×¢²á£¨Ìí¼Ó£©¸½ÊôÕË»§
	 * @param username
	 * @param password
	 * @param userKind
	 * @return
	 */
	public boolean registerSubAccount(String username,String password,int  userKind);
}
