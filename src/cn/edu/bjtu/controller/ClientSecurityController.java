package cn.edu.bjtu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientSecurityController {
	
	ModelAndView mv=new ModelAndView();
	@RequestMapping("/mysecurity")
	public ModelAndView getMySercurityPage(HttpSession session)
	{
		String userId=(String) session.getAttribute("userId");
		System.out.println("userId+"+userId);
		
		mv.setViewName("mgmt_a_security");
		return mv;
		
	}

}
