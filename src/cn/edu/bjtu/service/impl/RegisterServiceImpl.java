package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.CompanycertificateDao;
import cn.edu.bjtu.dao.RegisterDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.RegisterService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Companycertificate;
import cn.edu.bjtu.vo.Userinfo;
@Service("registerServiceImpl")
@Transactional
/**
 * 
 * @author RussWest0
 *
 */
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	UserinfoDao userinfoDao;
	@Autowired
	ClientDao clientDao;
	@Autowired
	CompanyDao companyDao;	
	@Autowired
	CompanycertificateDao companyCertificateDao;
	@Resource
	Carrierinfo carrierinfo;
	@Autowired
	Companycertificate companyCertificate;
	@Resource 
	Userinfo userInfo;
	@Resource
	Clientinfo clientInfo;
	@Resource
	RegisterDao registerDao;
	@Override
	public String register(String username, String password, String phone,int userKind) {
		// TODO Auto-generated method stub
		userInfo.setUsername(username);
		userInfo.setPhone(phone);
		userInfo.setId(IdCreator.createClientId());
		userInfo.setPassword(password);//未加密
		userInfo.setStatus("未验证");
		userInfo.setEmailStatus("未绑定");
		userInfo.setPhoneStatus("已绑定");/////////////需要修改
		userInfo.setSecurityQuestionStatus("未设置");
		//userInfo.setPrivilege(privilege);
		userInfo.setStatus("未验证");
		userInfo.setUserKind(userKind);
		
		if(userKind == 2){//个人用户
		clientInfo.setId(userInfo.getId());//同时在信息表中保存实体
		//clientInfo.setCarrierId(carrierId);
		clientInfo.setCreateDate(new Date());
		clientInfo.setPhone(phone);
		clientDao.save(clientInfo);
		}
		else //企业用户，目前维护两个公司表，以后重构成一个
		{
			companyCertificate.setId(userInfo.getId());
			companyCertificate.setPhone(phone);
			companyCertificateDao.save(companyCertificate);
			
			
			carrierinfo.setPhone(phone);
			carrierinfo.setId(userInfo.getId());
			carrierinfo.setStatus("未验证");
			companyDao.save(carrierinfo);
		}
		//clientInfo.setStatus("未验证");//新增用户 先设置成未验证 
		userinfoDao.save(userInfo);//保存实体
		return userInfo.getId();
	}
	@Override
	/**
	 * 检测用户名
	 */
	public List getUserCheck(String username) {
		// TODO Auto-generated method stub
		return registerDao.getUserCheck(username);
	}
	
	

}
