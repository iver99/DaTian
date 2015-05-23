package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.AuthenticationDao;
import cn.edu.bjtu.dao.BaseDao;


import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.Userinfo;
@Repository
/**
 * 合同dao层实现
 * @author RussWest0
 *
 */
public class AuthenticationDaoImpl implements AuthenticationDao{

	@Resource
	HibernateTemplate ht;
	@Resource
	BaseDao baseDao;
	@Resource 
	private HQLTool hqltool;
	
	Userinfo userinfo=null;
	@Override
	/**
	 * 返回认证列表
	 */
	public List getAllAuthentication() {
		// TODO Auto-generated method stub
		return ht.find("from Userinfo where status = '审核中' or status = '已审核'");
	}
	
	@Override
	/**
	 * 返回认证信息
	 */
	public Clientinfo getAuthenticationInfo(String clientId) {
		// TODO Auto-generated method stub
		return ht.get(Clientinfo.class, clientId);
	}

	@Override
	/**
	 * 返回个人信息
	 * @param clientId
	 */
	public Userinfo getMyUserDetail(String clientId) {
		// TODO Auto-generated method stub
		
		return ht.get(Userinfo.class,clientId);
		
	}

	
}