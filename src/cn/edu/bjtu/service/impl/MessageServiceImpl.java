package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.MessageDao;
import cn.edu.bjtu.dao.impl.BaseDaoImpl;
import cn.edu.bjtu.service.MessageService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Service
@Transactional
public class MessageServiceImpl extends BaseDaoImpl<Message> implements MessageService{

	@Autowired
	Message message;
	@Autowired
	MessageDao messageDao;
	
	@Override
	/**
	  * 添加留言
	  */
	public boolean insertMessage(String clientId, String content){
		
		message.setId(IdCreator.createMessageId());
		message.setClientId(clientId);
		message.setContent(content);
		message.setRelDate(new Date());
		messageDao.save(message);
		return true;
	}

	/**
	 * 返回用户所有的留言
	 */
	@Override
	public JSONArray getAllUserMessage(HttpSession session) {
		// TODO Auto-generated method stub
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Message t where t.clientId=:clientId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		List<Message> msgList=messageDao.find(hql, params);
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<msgList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(msgList.get(i));
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	
	
}
