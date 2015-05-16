package cn.edu.bjtu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.ClientSecurityService;
import cn.edu.bjtu.vo.Userinfo;

@Controller
public class ClientSecurityController {

	@Autowired
	ClientSecurityService clientSecurityService;

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/mysecurity")
	/**
	 * 获取我的安全设置页面
	 * @param session
	 * @return
	 */
	public ModelAndView getMySercurityPage(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		// System.out.println("userId+"+userId);
		Userinfo userinfo = clientSecurityService.getUserById(userId);
		mv.addObject("userinfo", userinfo);
		mv.setViewName("mgmt_a_security");
		return mv;

	}

	@RequestMapping("getchangepasswordpage")
	/**
	 * 获取修改密码表单
	 * @return
	 */
	public ModelAndView gotoChangePasswordPage() {

		mv.setViewName("mgmt_a_security2");
		return mv;
	}

	@RequestMapping("changepassword")
	/*
	 * 修改密码
	 */
	public ModelAndView changePassword(HttpSession session, String oldPassword,
			String newPassword, String repeatPassword) {
		String userId = (String) session.getAttribute("userId");
		boolean flag = false;
		flag = clientSecurityService.checkOldPassword(oldPassword, userId);
		if (flag == true)// 旧密码正确 的情况
		{
			if (newPassword.equals(repeatPassword))// 两次新密码一样
			{
				clientSecurityService.changePassword(newPassword, userId);// 修改密码
				String msg = "修改密码成功";
				mv.addObject("msg", msg);
				mv.setViewName("mgmt_a_security");
				return mv;
			} else// 两次新密码不一样
			{
				String msg = "两次密码输入不一致，请重新输入新密码!";
				mv.addObject("msg", msg);
				mv.setViewName("mgmt_a_security2");
				return mv;
			}

		} else// 旧密码错误
		{
			String msg = "原始密码错误!请重新输入";
			mv.addObject("msg", msg);
			mv.setViewName("mgmt_a_security2");
			return mv;
		}
	}

	@RequestMapping("getbindemailpage")
	/**
	 * 绑定邮箱页面
	 * @param session
	 * @return
	 */
	public ModelAndView gotoBindEmailPage() {
		mv.setViewName("mgmt_a_security4");
		return mv;
	}

	@RequestMapping("bindemail")
	public ModelAndView bindEmail(HttpSession session, String email) {
		String userId = (String) session.getAttribute("userId");
		boolean flag = clientSecurityService.bindEmail(email, userId);
		if (flag == true) {
			mv.setViewName("mgmt_a_security");
			String msg = "邮箱绑定成功";
			mv.addObject("msg", msg);
			return mv;
		} else {
			mv.setViewName("mgmt_a_security4");
			String msg = "绑定失败";
			mv.addObject("msg", msg);
			return mv;
		}

	}

	@RequestMapping("getchangebindemailpage")
	/**			     
	 * 获取更改邮箱绑定页面
	 * @param session
	 * @return
	 */
	public ModelAndView gotoChangeEmailPage(HttpSession session) {
		String userId = (String) session.getAttribute("userId");

		String email = (String) session.getAttribute("email");
		// System.out.println("email+"+email);////
		mv.addObject("email", email);
		mv.setViewName("mgmt_a_security4b");
		return mv;
	}

	@RequestMapping("changebindemail")
	public ModelAndView changeBindEmail(HttpSession session, String newEmail) {
		String userId = (String) session.getAttribute("userId");
		boolean flag = false;
		flag = clientSecurityService.changeBindEmail(newEmail, userId);
		if (flag == true) {
			String msg = "修改绑定邮箱成功";
			mv.addObject("msg", msg);
			mv.setViewName("mgmt_a_security");
			return mv;
		} else {
			String msg = "修改绑定邮箱错误，请重新填写!";
			mv.addObject("msg", msg);
			mv.setViewName("mgmt_a_security4b");
			return mv;
		}

	}
}
