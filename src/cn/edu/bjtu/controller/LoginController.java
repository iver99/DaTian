 package cn.edu.bjtu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.LoginService;
import cn.edu.bjtu.vo.Userinfo;

@Controller
/* @RequestMapping(value = "/views") */
public class LoginController {
	@Autowired
	LoginService loginService;
	ModelAndView mv = new ModelAndView();
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginAction(String username, String password,
			HttpServletRequest request) {
	
		mv.addObject("username", username);
		mv.addObject("password", password);
		Userinfo userinfo = loginService.checkLogin(username, password);
		//System.out.println(userId);
		if (userinfo!=null) {//¥Ê»Îsession
			mv.setViewName("index");
			request.getSession().setAttribute("username", userinfo.getUsername());
			request.getSession().setAttribute("userId",userinfo.getId());
			request.getSession().setAttribute("email",userinfo.getEmail());
		}

		else
			mv.setViewName("login");
		return mv;

	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("userId");
		mv.setViewName("index");
		return mv;
	}
}