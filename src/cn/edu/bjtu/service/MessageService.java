package cn.edu.bjtu.service;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.vo.Message;

public interface MessageService extends BaseDao<Message> {
	public boolean insertMessage(String clientId, String content);

}
