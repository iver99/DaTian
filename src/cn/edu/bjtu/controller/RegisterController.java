package cn.edu.bjtu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.RegisterService;

/**
 * 注册控制器
 * 
 * @author RussWest0
 *
 */
@Controller
public class RegisterController {

	ModelAndView mv = new ModelAndView();
	@Resource
	RegisterService registerServiceImpl;
	@RequestMapping("/register")
	public ModelAndView register(String username, String phone,/*String validationKey,*/
			String password, String passwordRepeat, HttpServletRequest request,HttpServletResponse response) {
		
		//System.out.println("username"+username);
		//验证码未实现 
		String usreId=registerServiceImpl.register(username, password, phone);
		request.getSession().setAttribute("userId", usreId);
		request.getSession().setAttribute("username", username);
		
		mv.setViewName("register1");
		return mv;
	}
	@RequestMapping("userdetail")
	public ModelAndView userValidation()
	{
		//未实现
		return mv;
	}
}
