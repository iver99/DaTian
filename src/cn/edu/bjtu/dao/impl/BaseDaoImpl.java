package cn.edu.bjtu.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.BaseDao;

/**
 * BaseDao实现
 * @author RussWest0
 *
 */
@Repository
public class BaseDaoImpl implements BaseDao {

	@Resource
	HibernateTemplate ht;

	@Override
	/**
	 * 保存实体
	 */
	public boolean save(Object obj) {
		// TODO Auto-generated method stub
		ht.save(obj);
		return true;
	}

	@Override
	/**
	 * 删除实体
	 */
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		ht.delete(obj);
		return true;
	}

	@Override
	/**
	 * 更新实体
	 */
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		ht.update(obj);
		return true;
	}
	
	

}
