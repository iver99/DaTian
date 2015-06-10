package cn.edu.bjtu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.RegisterService;
import cn.edu.bjtu.util.Encrypt;
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
			String password, String passwordRepeat,int userkind, HttpServletRequest request,HttpServletResponse response) {
		
		String psw = Encrypt.MD5(password);
		//验证码未实现 
		String userId=registerServiceImpl.register(username, psw, phone,userkind);
		request.getSession().setAttribute("userId", userId);
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("userKind", userkind);
		
		mv.setViewName("register1");
		return mv;
	}
	

	@RequestMapping("usercheck")
	/**
	 * 用户名检测是否使用
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String userCheck(
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		String username = request.getParameter("username");
		List userCheck = registerServiceImpl.getUserCheck(username);
		if(userCheck.isEmpty() || userCheck==null)
		{
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("true");
		}
		else
		{
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("false");
		}
		return null;
	}
}
