package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Clientinfo;

/**
 * 
 * @author RussWest0
 *
 */
public interface ClientService {
	
	public List getCompanyClient(String carrierId);
	public Clientinfo getClientInfo(String clientId);
	public Businessclient getBusinessclientInfo(String clientId);
	public boolean insertClient(String account,String clientName,String clientBusiness,
			String contact,String phone,String remarks,String carrierId,String path,String fileName);
	public boolean updateClient(String id, String account,String clientName,String clientBusiness,
			String contact,String phone,String remarks,String carrierId,String path,String fileName);
	public boolean deleteClient(String id);
	public String getBasicUserInfo(String userId);
	public boolean checkHeadIcon(String userId);
	
	public String getStatus(String userId);
	
	public boolean validateUser(String userId,String realName,String phone,String IDCard,String sex);
}
