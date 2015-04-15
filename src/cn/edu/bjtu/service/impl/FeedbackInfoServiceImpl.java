package cn.edu.bjtu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.FeedbackInfoDao;
import cn.edu.bjtu.service.FeedbackInfoService;

@Repository
public class FeedbackInfoServiceImpl implements FeedbackInfoService{
	
	@Resource
	FeedbackInfoDao feedbackinfoDao;
	
	@Override
	public List getAllFeedbackInfo() {
		// TODO Auto-generated method stub
		return feedbackinfoDao.getAllFeedbackInfo();
	}
}
