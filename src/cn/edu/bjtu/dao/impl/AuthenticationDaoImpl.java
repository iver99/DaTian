package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.AuthenticationDao;

import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;
@Repository
/**
 * 合同dao层实现
 * @author RussWest0
 *
 */
public class AuthenticationDaoImpl extends BaseDaoImpl<Userinfo> implements AuthenticationDao{

	@Resource
	HibernateTemplate ht;
	
	Userinfo userinfo=null;
	@Override
	/**
	 * 返回认证列表
	 */
	public List<Userinfo> getAllAuthentication() {
		
		return this.find("from Userinfo where status = '审核中' or status = '已审核'");
	}
	
	@Override
	/**
	 * 返回认证信息
	 */
	public Clientinfo getAuthenticationInfo(String clientId) {
		
		return ht.get(Clientinfo.class, clientId);
	}

	@Override
	/**
	 * 返回个人信息
	 * @param clientId
	 */
	public Userinfo getMyUserDetail(String clientId) {
		
		
		return ht.get(Userinfo.class,clientId);
		
	}

	@Override
	public List getFindUser(String username) {
		
		String sql = "from Userinfo where (status = '审核中' or status = '已审核') ";
			if (username.equals("用户名")) {
				// 查找时不考虑用户名
			} else
				sql += "and username like '%" + username + "%'";
		return ht.find(sql);
	}

	
}