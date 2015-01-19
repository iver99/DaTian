package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.LoginDao;
import cn.edu.bjtu.vo.User;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Resource
	private HibernateTemplate ht;
	@Resource
	private SessionFactory sf;

	/*
	 * @Resource private User user;
	 */

	@Override
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		List list=null;
		
		Query query = sess.createQuery("from User u where u.username=? and u.password=?");
				
				
		query.setString(0, username);
		query.setString(1, password);

		list = query.list();
		tx.commit();
		
		if (list.size()>0) {
				User user=(User)list.get(0);
				if(user.getUsername().equals(username)&& user.getPassword().equals(password))
					return true;
				else
					return false;
				
		} else {
			return false;
		}

		/*System.out.println("loginÖ´ĞĞµ½Dao");
		
		return false;*/
	}

}
