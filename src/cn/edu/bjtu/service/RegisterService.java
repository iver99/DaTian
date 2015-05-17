package cn.edu.bjtu.service;
/**
 * 
 * @author RussWest0
 *
 */
public interface RegisterService {
	public String register(String username,String password,String phone,int userKind);
	
	//public boolean registerInfo(String userId);
}
