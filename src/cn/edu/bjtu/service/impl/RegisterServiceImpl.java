package cn.edu.bjtu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.service.RegisterService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;
@Service("registerServiceImpl")
/**
 * 
 * @author RussWest0
 *
 */
public class RegisterServiceImpl implements RegisterService{

	@Resource 
	BaseDao baseDao;
	@Resource 
	Userinfo userInfo;
	@Resource
	Clientinfo clientInfo;
	@Override
	public String register(String username, String password, String phone) {
		// TODO Auto-generated method stub
		userInfo.setUsername(username);
		userInfo.setPhone(phone);
		userInfo.setId(IdCreator.createClientId());
		userInfo.setPassword(password);//未加密
		userInfo.setStatus("未验证");
		clientInfo.setId(userInfo.getId());//同时在信息表中保存实体
		//clientInfo.setStatus("未验证");//新增用户 先设置成未验证 
		baseDao.save(userInfo);//保存实体
		
		baseDao.save(clientInfo);
		//registerInfo(userInfo.getId());
		return userInfo.getId();
	}
	/*@Override
	public boolean registerInfo(String userId) {
		// TODO Auto-generated method stub
		clientInfo.setId(userId);
		return baseDao.save(clientInfo);
	}*/
	
	

}
