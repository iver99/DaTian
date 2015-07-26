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
	
}
