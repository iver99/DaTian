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
public class LoginController {
	@Autowired
	LoginService loginService;
	ModelAndView mv = new ModelAndView();
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginAction(String username, String password,int userkind,
			HttpServletRequest request) {
	
		mv.addObject("username", username);
		mv.addObject("password", password);
		Userinfo userinfo = loginService.checkLogin(username, password,userkind);
		if (userinfo!=null) {//存入session
			mv.setViewName("mgmt");
			request.getSession().setAttribute("username", userinfo.getUsername());
			request.getSession().setAttribute("userId",userinfo.getId());
			request.getSession().setAttribute("email",userinfo.getEmail());
			request.getSession().setAttribute("email",userinfo.getUserKind());//用户类型
		}

		else{
			String msg="登录出错，请重新登录!";
			mv.addObject("msg", msg);
			mv.setViewName("login");
		}
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