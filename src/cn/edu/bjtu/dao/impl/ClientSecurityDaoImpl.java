package cn.edu.bjtu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.dao.ClientSecurityDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;

@Repository
public class ClientSecurityDaoImpl implements ClientSecurityDao {

	@Autowired
	private HibernateTemplate ht;

	@Autowired
	ClientDao clientDao;
	@Autowired
	UserinfoDao userinfoDao;

	@Override
	/**
	 * 检查旧密码
	 */
	public boolean checkOldPassword(String oldPassword, String userId) {
		
		Userinfo user = ht.get(Userinfo.class, userId);

		if (user.getPassword().equals(oldPassword))
			return true;
		return false;
	}

	@Override
	/**
	 * 修改密码
	 */
	public boolean changePassword(String newPassword, String userId) {
		
		Userinfo user = ht.get(Userinfo.class, userId);
		user.setPassword(newPassword);
		userinfoDao.save(user);
		return true;
	}

	@Override
	/**
	 * 绑定邮箱
	 */
	public boolean bindEmail(String email, String userId) {
		
		Userinfo user = ht.get(Userinfo.class, userId);
		user.setEmail(email);
		user.setEmailStatus("已绑定");// 修改状态
		Clientinfo clientinfo = ht.get(Clientinfo.class, userId);
		clientinfo.setEmail(email);

		/*baseDao.update(user);
		baseDao.update(clientinfo);*/
		userinfoDao.update(user);
		clientDao.update(clientinfo);
		return true;
	}

	@Override
	/**
	 * 返回用户信息
	 */
	public Userinfo getUserById(String userId) {
		
		return ht.get(Userinfo.class, userId);
	}

	@Override
	/**
	 * 修改绑定邮箱
	 */
	public boolean changeBindEmail(String newEmail, String userId) {
		
		Userinfo userinfo = ht.get(Userinfo.class, userId);

		userinfo.setEmail(newEmail);

		Clientinfo clientinfo = ht.get(Clientinfo.class, userId);

		clientinfo.setEmail(newEmail);

		/*baseDao.update(userinfo);
		baseDao.update(clientinfo);*/
		userinfoDao.update(userinfo);
		clientDao.update(clientinfo);
		return true;

	}

	@Override
	public boolean setSecurityQuestion(String q1, String q2, String q3,
			String a1, String a2, String a3, String uId) {
		
		Userinfo userinfo = ht.get(Userinfo.class, uId);

		userinfo.setSecurityAnswerOne(a1.trim());
		userinfo.setSecurityAnswerTwo(a2.trim());
		userinfo.setSecurityAnswerThree(a3.trim());
		userinfo.setSecurityQuestionOne(q1.trim());
		userinfo.setSecurityQuestionTwo(q2.trim());
		userinfo.setSecurityQuestionThree(q3.trim());

		userinfo.setSecurityQuestionStatus("已设置");

		/*baseDao.update(userinfo);*/
		userinfoDao.update(userinfo);
		return true;
	}

	@Override
	/**
	 * 检查密保问题答案
	 * @param a1
	 * @param a2
	 * @param a3
	 * @param userId
	 * @return
	 */
	public boolean checkAnswer(String a1, String a2, String a3, String userId) {
		
		Userinfo userinfo = ht.get(Userinfo.class, userId);

		if (a1.trim().endsWith(userinfo.getSecurityAnswerOne())
				&& a2.trim().equals(userinfo.getSecurityAnswerTwo())
				&& a3.trim().equals(userinfo.getSecurityAnswerThree()))
			return true;

		return false;

	}

}
