package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;

@Repository
/**
 * 客户dao层实现
 * @author RussWest0
 *
 */
public class ClientDaoImpl extends BaseDaoImpl<Clientinfo> implements ClientDao {

	@Resource
	HibernateTemplate ht;
	@Autowired
	UserinfoDao userinfoDao;
	
	/*@Resource
	BaseDao baseDao;*/
	/*@Autowired
	ClientDao clientDao;*/

	@Override
	/**
	 * 返回公司客户
	 */
	public List getCompanyClient(String carrierId) {
		// TODO Auto-generated method stub
		return ht.find("from Businessclient where carrierId='" + carrierId
				+ "'");

	}

	@Override
	/**
	 * 获取客户信息
	 */
	public Clientinfo getClientInfo(String clientId) {
		// TODO Auto-generated method stub
		return ht.get(Clientinfo.class, clientId);
	}

	public Businessclient getBusinessclientInfo(String clientId) {
		// TODO Auto-generated method stub
		return ht.get(Businessclient.class, clientId);
	}

	@Override
	/**
	 * 查找用户的基本信息
	 */
	public String getBasicUserInfo(String userId) {
		// TODO Auto-generated method stub
		List list = ht.find("select email from Clientinfo where id='" + userId
				+ "'");
		if (list != null)
			return (String) list.get(0);
		else
			return null;
	}

	@Override
	/**
	 * 检查是否设置头像
	 */
	public boolean checkHeadIcon(String userId,int userKind) {
		// TODO Auto-generated method stub
		// System.out.println("userId"+userId);
		
		if(userKind == 1)//个人用户 
		{
			List list = ht.find("select headIcon from Clientinfo where id='"
					+ userId + "'");
			if (list != null) {
				// System.out.println("list+"+list);
				return true;
			} else
				return false;
		}else//企业用户
		{
			List list= ht.find("select headIcon from Carrierinfo where id='"+userId+"'");
			if(list !=null)
				return true;
			else 
				return false;
		}
		
	}

	@Override
	public String getStatus(String userId) {
		// TODO Auto-generated method stub
		List list = ht.find("select status from Userinfo where id='" + userId
				+ "'");
		if (list != null)
			return (String) list.get(0);
		else
			return null;
	}

	@Override
	public boolean validateUser(String userId, String realName, String phone,
			String IDCard, String sex) {
		// TODO Auto-generated method stub
		Clientinfo clientInfo=ht.get(Clientinfo.class, userId);
			if(clientInfo == null){//clientinfo找不到记录
				return false;
			}
		
			clientInfo.setRealName(realName);
			clientInfo.setPhone(phone);
			clientInfo.setIdcard(IDCard);
			clientInfo.setSex(sex);
			this.update(clientInfo);
			Userinfo userInfo=ht.get(Userinfo.class, userId);
			userInfo.setStatus("审核中");
			userinfoDao.update(userInfo);
			
	//}
		
		return true;
	}
	

}
