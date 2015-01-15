package cn.edu.bjtu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	/*@RequestMapping(value="/login")//凡是后缀为login的请求执行此方法
	public String showHomePage(Map<String,Object> model)//也可以传入request等参数
	{
		
		model.put("name", "iver99");
		
		//此处调用业务逻辑层代码，调用后面的DAO层，访问数据库等等，省略
		
		return "success";//返回一个视图的字符串名称，由视图解析器渲染页面
	}*/
	@RequestMapping(value="/login")
	public ModelAndView loginAction(HttpServletRequest request)
	{
		String name=request.getParameter("username");//从页面获取username
		ModelAndView mv=new ModelAndView();
		//System.out.println(name);
		mv.addObject("name",name);
		mv.setViewName("success");
		return mv;
		
	}
}