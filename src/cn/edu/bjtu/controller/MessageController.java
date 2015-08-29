package cn.edu.bjtu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.Messages;

import cn.edu.bjtu.service.MessageService;
import cn.edu.bjtu.util.Constant;

@Controller
public class MessageController {

	@Autowired
	MessageService messageService;
	
	/**
	  * 留言页面
	  * @param request
	  * @param response
	  * @return
	  */
	@RequestMapping("insertmessage")
	public String insertMessage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String clientId = (String) request.getSession().getAttribute(
				Constant.USER_ID);
		String content = request.getParameter("content");
		boolean flag = true;
		flag = messageService.insertMessage(clientId, content);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("true");

		return null;
	}
	/**
	 * 获取用户所有的留言
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getAllUserMessage",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAllUserMessage(HttpSession session){
		JSONArray jsonArray = messageService.getAllUserMessage(session);
		return jsonArray.toString();
	}
}
