package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.BusinessClientDao;
import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.ClientService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;
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
	@Autowired
	UserinfoDao userinfoDao;
	
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
	 * 通过id获取客户信息
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
	public boolean insertBusinessClient(String account, String clientName,
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
	public boolean updateBusinessClient(String id, String account, String clientName,
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
	public boolean deleteBusinessClient(String id){
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
	/**
	 * 检查用户头像设置的状态
	 */
	public boolean checkHeadIconStatus(String userId) {
		// TODO Auto-generated method stub
		Userinfo userinfo=userinfoDao.get(Userinfo.class, userId);
		if(userinfo !=null){
			if(userinfo.getHeadIcon().equals("已设置")){
				return true;//已设置头像
			}else 
				return false;//未设置头像
		}
		return false;
		
	}
	@Override
	public String getStatus(String userId) {
		// TODO Auto-generated method stub
		return clientDao.getStatus(userId);
	}
	@Override
	/**
	 * 个人用户信息认证
	 */
	public boolean validateUser(String userId, String realName, String phone,
			String IDCard, String sex, String path, String fileName) {
		// TODO Auto-generated method stub
		return clientDao.validateUser(userId,realName,phone,IDCard,sex, path, fileName);
	}
	@Override
	/**
	 *  更新个人用户信息
	 */
	public boolean updateClientinfo(Clientinfo clientinfo, String path,
			String fileName, String userId) {
		// TODO Auto-generated method stub
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			clientinfo.setIDPicture(fileLocation);//设置文件上传路径
		}
		Userinfo userinfo=userinfoDao.get(Userinfo.class,userId);
		// add by RussWest0 at 2015年6月4日,下午8:23:30 
//		更新后显示审核中
		userinfo.setStatus("审核中");
		clientinfo.setId(userId);
		
		userinfoDao.update(userinfo);
		clientDao.update(clientinfo);//更新信息
		return true;
	}
	
	
	
	
	
}
