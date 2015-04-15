package cn.edu.bjtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubAccountController {
	
	ModelAndView mv=new ModelAndView();
	
	@RequestMapping("getsubaccount")
	public ModelAndView getSubAccount()
	{
		
		return mv;
	}
}
