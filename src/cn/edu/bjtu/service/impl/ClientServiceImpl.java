package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.BusinessClientDao;
import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.service.ClientService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Clientinfo;
@Repository
/**
 * client服务层实现
 * @author RussWest0
 *
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService{

	@Autowired	
	ClientDao clientDao;
	@Autowired
	BusinessClientDao businessClientDao;
	@Resource
	Businessclient businessClient;
	
	@Override
	/**
	 *返回公司客户 
	 */
	public List getCompanyClient(String carrierId) {
		// TODO Auto-generated method stub
		return clientDao.getCompanyClient(carrierId);
	}
	@Override
	/**
	 * 获取客户信息
	 */
	public Clientinfo getClientInfo(String clientId) {
		// TODO Auto-generated method stub
		return clientDao.getClientInfo(clientId);
	}
	
	@Override
	/**
	 * 获取客户信息(businessclient)
	 */
	public Businessclient getBusinessclientInfo(String businessclientId) {
		// TODO Auto-generated method stub
		return clientDao.getBusinessclientInfo(businessclientId);
	}
	
	@Override
	/**
	 * 新增客户s
	 */
	public boolean insertClient(String account, String clientName,
			String clientBusiness, String contact, String phone,
			String remarks, String carrierId,String path,String fileName) {
		// TODO Auto-generated method stub
		businessClient.setAccount(account);
		businessClient.setCarrierId(carrierId);
		businessClient.setClientBusiness(clientBusiness);
		businessClient.setClientName(clientName);
		businessClient.setContact(contact);
		businessClient.setId(IdCreator.createBusinessClientId());
		businessClient.setPhone(phone);
		businessClient.setRelDate(new Date());
		businessClient.setRemarks(remarks);
		
		// 保存文件路径
		if(path!=null && fileName!=null) {
			String fileLocation = path + "//" + fileName;
			businessClient.setRelatedMaterial(fileLocation);
		}
		businessClientDao.save(businessClient);//保存实体
		return true;
	}
	
	@Override
	/**
	 * 更新客户
	 */
	public boolean updateClient(String id, String account, String clientName,
			String clientBusiness, String contact, String phone,
			String remarks, String carrierId,String path,String fileName) {
		// TODO Auto-generated method stub
		businessClient=getBusinessclientInfo(id);//根据id查找到客户信息
		businessClient.setAccount(account);
		businessClient.setClientName(clientName);
		businessClient.setClientBusiness(clientBusiness);
		businessClient.setContact(contact);
		businessClient.setPhone(phone);
		businessClient.setRelDate(new Date());
		businessClient.setRemarks(remarks);
		businessClient.setCarrierId(carrierId);
		
		// 保存文件路径
		if(path!=null && fileName!=null) {
			String fileLocation = path + "//" + fileName;
			businessClient.setRelatedMaterial(fileLocation);
		}
		businessClientDao.update(businessClient);//保存实体
		return true;
	}
	@Override
	/**
	 * 删除客户
	 */
	public boolean deleteClient(String id){
		businessClient=getBusinessclientInfo(id);//根据id查找到客户信息
		businessClientDao.delete(businessClient);
		return true;
	}
	@Override
	public String getBasicUserInfo(String userId) {
		// TODO Auto-generated method stub
		return clientDao.getBasicUserInfo(userId);
	}
	@Override
	public boolean checkHeadIcon(String userId,int userKind) {
		// TODO Auto-generated method stub
		return clientDao.checkHeadIcon(userId,userKind);
	}
	@Override
	public String getStatus(String userId) {
		// TODO Auto-generated method stub
		return clientDao.getStatus(userId);
	}
	@Override
	public boolean validateUser(String userId, String realName, String phone,
			String IDCard, String sex) {
		// TODO Auto-generated method stub
		return clientDao.validateUser(userId,realName,phone,IDCard,sex);
	}
	
	
	
	
}
