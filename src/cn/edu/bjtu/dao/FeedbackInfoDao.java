package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Feedbackform;

public interface FeedbackInfoDao extends BaseDao<Feedbackform>
{
	
	public List getAllFeedbackInfo();
}
