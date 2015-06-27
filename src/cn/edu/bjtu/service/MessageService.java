package cn.edu.bjtu.service;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.vo.Message;

import com.alibaba.fastjson.JSONArray;

public interface MessageService extends BaseDao<Message> {
	public boolean insertMessage(String clientId, String content);
	
	/**
	 * 返回用户的所有留言
	 * @param session
	 * @return
	 */
	public JSONArray getAllUserMessage(HttpSession session);

}
