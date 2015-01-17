package cn.edu.bjtu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.LoginService;

@Controller
@RequestMapping(value="/views")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ModelAndView loginAction(String username,String password)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("username",username);
		mv.addObject("password",password);
		mv.setViewName("success");
		
		return mv;
		
	}
}