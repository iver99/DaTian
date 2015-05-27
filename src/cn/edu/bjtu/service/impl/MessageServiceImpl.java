package cn.edu.bjtu.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.FocusDao;
import cn.edu.bjtu.dao.MessageDao;
import cn.edu.bjtu.dao.impl.BaseDaoImpl;
import cn.edu.bjtu.service.MessageService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Message;
@Service
@Transactional
public class MessageServiceImpl extends BaseDaoImpl<Message> implements MessageService{

	@Autowired
	Message message;
	@Autowired
	MessageDao messageDao;
	
	@Override
	/**
	  * ÃÌº”¡Ù—‘
	  */
	public boolean insertMessage(String clientId, String content){
		
		message.setId(IdCreator.createMessageId());
		message.setClientId(clientId);
		message.setContent(content);
		message.setRelDate(new Date());
		messageDao.save(message);
		return true;
	}
}
