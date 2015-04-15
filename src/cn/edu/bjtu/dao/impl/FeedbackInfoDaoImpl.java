package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.FeedbackInfoDao;

@Repository
public class FeedbackInfoDaoImpl implements FeedbackInfoDao{
	
	@Resource
	private HibernateTemplate ht;

	
	@Override
	/**
	 * 返回所有城市信息
	 */
	public List getAllFeedbackInfo() {
		// TODO Auto-generated method stub
		
		return ht.find("from FeedbackGoodsView where recieverId='Cl-0001'");
		
	}
	
}
