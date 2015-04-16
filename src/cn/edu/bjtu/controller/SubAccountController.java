package cn.edu.bjtu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubAccountController {
	
	ModelAndView mv=new ModelAndView();
	
	@RequestMapping("getsubaccount")
	public ModelAndView getSubAccount(HttpServletRequest request,HttpServletResponse response)
	{
		String userId=(String)request.getSession().getAttribute("userId");
		
		mv.setViewName("mgmt_a_subaccount");
		return mv;
	}
}
