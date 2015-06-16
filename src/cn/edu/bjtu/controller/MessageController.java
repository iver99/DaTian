package cn.edu.bjtu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.bjtu.service.MessageService;
import cn.edu.bjtu.util.Constant;

@Controller
public class MessageController {

	@Autowired
	MessageService messageService;
	@RequestMapping("insertmessage")
	/**
	  * ¡Ù—‘“≥√Ê
	  * @param request
	  * @param response
	  * @return
 	  */
	public String insertMessage(
			HttpServletRequest request,HttpServletResponse response) throws Exception{
			String clientId=(String)request.getSession().getAttribute(Constant.USER_ID);
			/*if(clientId==null)
			{
				mv.setViewName("login");
				return mv;
			}*/
			String content = request.getParameter("content");
			boolean flag = true;
			flag = messageService.insertMessage(clientId,content);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("true");				
				
			return null;
		}
}
