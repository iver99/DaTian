package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;

@Repository
/**
 * �ͻ�dao��ʵ��
 * @author RussWest0
 *
 */
public class ClientDaoImpl implements ClientDao {

	@Resource
	HibernateTemplate ht;
	
	@Resource
	BaseDao baseDao;

	@Override
	/**
	 * ���ع�˾�ͻ�
	 */
	public List getCompanyClient(String carrierId) {
		// TODO Auto-generated method stub
		return ht.find("from Businessclient where carrierId='" + carrierId
				+ "'");

	}

	@Override
	/**
	 * ��ȡ�ͻ���Ϣ
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
	 * �����û��Ļ�����Ϣ
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
	 * ����Ƿ�����ͷ��
	 */
	public boolean checkHeadIcon(String userId) {
		// TODO Auto-generated method stub
		// System.out.println("userId"+userId);
		List list = ht.find("select headIcon from Clientinfo where id='"
				+ userId + "'");
		if (list != null) {
			// System.out.println("list+"+list);
			if (list.get(0) != null)
				return true;
			else
				return false;
		} else
			return false;
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
		clientInfo.setRealName(realName);
		clientInfo.setPhone(phone);
		clientInfo.setIdcard(IDCard);
		clientInfo.setSex(sex);
		
		boolean flag= baseDao.update(clientInfo);
		//�޸ĸ�����Ϣ״̬
		if(flag== true)
		{
			Userinfo userInfo=ht.get(Userinfo.class, userId);
			userInfo.setStatus("�����");
			baseDao.update(userInfo);
		}
		
		return flag;
	}
	

}