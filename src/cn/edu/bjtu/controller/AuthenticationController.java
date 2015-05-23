package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.AuthenticationService;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Clientinfo;

@Controller
/**
 * 认证相关控制器
 * @author RussWest0
 *
 */
public class AuthenticationController {
	
	@Resource(name="authenticationServiceImpl")
	AuthenticationService authenticationService;

	ModelAndView mv = new ModelAndView();
	
	@RequestMapping("/authentic")
	/**
	 * 获取所有待认证信息
	 * @param request
	 * @return
	 */
	public ModelAndView getAllAuthentication(HttpServletRequest request) {
		//String carrierId=(String)request.getSession().getAttribute("userId");
		//String carrierId = "C-0002";
		System.out.println("auth-controller");
		List validateList = authenticationService.getAllAuthentication();
		System.out.println("validateList" + validateList);
		mv.addObject("validateList", validateList);
		mv.setViewName("mgmt_m_register");
		return mv;

	}
	
	@RequestMapping("authenticdetail")
	/**
	 * 个人认证信息详情
	 * @param clientId
	 * @param flag
	 * @return
	 */
	public ModelAndView getAuthenticationInfo(@RequestParam String clientId,
			@RequestParam int flag, HttpServletRequest request, HttpServletResponse response) {
		//String carrierId=(String)request.getSession().getAttribute("userId");
		//String carrierId = "C-0002";
		Clientinfo clientinfo = authenticationService.getAuthenticationInfo(clientId);
		mv.addObject("clientinfo", clientinfo);
		if (flag == 1)// 详情
		{
			//mv.setViewName("mgmt_m_register2");
		} else if (flag == 2)// 终止
		{
			mv.setViewName("mgmt_m_register2");
		} else if (flag == 3)
		{
			boolean judge = authenticationService.updateAuthenticStatus(clientId,"已审核");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (flag == 4)
		{
			boolean judge = authenticationService.updateAuthenticStatus(clientId,"未通过");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return mv;
	}
	
	@RequestMapping("authenticview")
	/**
	 * 合同详情
	 * @param clientId
	 * @param flag
	 * @return
	 */
	public ModelAndView getAuthenticationCheck(@RequestParam String clientId
			, HttpServletRequest request, HttpServletResponse response) {
		//String carrierId=(String)request.getSession().getAttribute("userId");
		//String carrierId = "C-0002";
		Clientinfo clientinfo = authenticationService.getAuthenticationInfo(clientId);
		mv.addObject("clientinfo", clientinfo);
		mv.setViewName("mgmt_m_register2a");
		return mv;
	}

}
