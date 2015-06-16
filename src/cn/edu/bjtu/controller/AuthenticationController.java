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
import cn.edu.bjtu.service.ClientSecurityService;
import cn.edu.bjtu.service.CompanycertificateService;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Companycertificate;
import cn.edu.bjtu.vo.Userinfo;

@Controller
/**
 * 认证相关控制器
 * @author RussWest0
 *
 */
public class AuthenticationController {

	@Resource(name = "authenticationServiceImpl")
	AuthenticationService authenticationService;
	@Resource
	ClientSecurityService clientSecurityService;
	@Resource
	CompanycertificateService companycertificateService;
	
	ModelAndView mv = new ModelAndView();

	@RequestMapping("/authentic")
	/**
	 * 获取所有待认证信息
	 * @param request
	 * @return
	 */
	public ModelAndView getAllAuthentication(HttpServletRequest request) {
		List<Userinfo> validateList = authenticationService.getAllAuthentication();
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
			@RequestParam(required=false) String feedback,
			@RequestParam int flag, HttpServletRequest request,
			HttpServletResponse response) {
		// String carrierId=(String)request.getSession().getAttribute(Constant.USER_ID);
		// String carrierId = "C-0002";
		Clientinfo clientinfo = authenticationService
				.getAuthenticationInfo(clientId);
		mv.addObject("clientinfo", clientinfo);
		Userinfo userinfo = clientSecurityService.getUserById(clientId);
		mv.addObject("userinfo", userinfo);
		
		if (flag == 1)// 详情
		{
			// mv.setViewName("mgmt_m_register2");
		} else if (flag == 22)// 审核个人页面跳转
		{
			mv.setViewName("mgmt_m_register2");
		} else if (flag == 23)// 审核公司页面跳转
		{
			Companycertificate companycertificate = companycertificateService.getCompanycertificate(clientId);
			mv.addObject("detailCompanyCertificate", companycertificate);
			mv.setViewName("mgmt_m_register3");
		} else if (flag == 32) {//审核个人
			boolean judge = authenticationService.updateAuthenticStatus(feedback,
					clientId, "已审核");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (flag == 42) {//审核个人
			boolean judge = authenticationService.updateAuthenticStatus(feedback,
					clientId, "未通过");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (flag == 33) {//审核公司
			boolean judge = authenticationService.updateAuthenticStatus(feedback,
					clientId, "已审核");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (flag == 43) {//审核公司
			boolean judge = authenticationService.updateAuthenticStatus(feedback,
					clientId, "未通过");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return mv;
	}
	
	/**
	 * 获取审核个人用户页面
	 * @param userid
	 * @return
	 */
	@RequestMapping("authenticdetailuserpage")
	public ModelAndView getAuthenticUserpage(String userid){
		Clientinfo clientinfo = authenticationService
				.getAuthenticationInfo(userid);
		mv.addObject("clientinfo", clientinfo);
		Userinfo userinfo = clientSecurityService.getUserById(userid);
		mv.addObject("userinfo", userinfo);
		mv.setViewName("mgmt_m_register2");//审核个人页面
		return mv;
	}
	
	/*
	 * 
	 * 获取审核公司用户页面
	 */
	@RequestMapping("authenticdetailcompanypage")
	public ModelAndView getAuthenticCompanyPage(String userid){
		
		Userinfo userinfo = clientSecurityService.getUserById(userid);
		mv.addObject("userinfo", userinfo);
		Companycertificate companycertificate = companycertificateService.getCompanycertificate(userid);
		mv.addObject("detailCompanyCertificate", companycertificate);
		mv.setViewName("mgmt_m_register3");//审核公司页面 
		
		return mv;
	}
	/**
	 * 审核个人用户通过,需要修改状态为已验证
	 * @return
	 */
	@RequestMapping("authenUserPass")
	public ModelAndView authenUserPass(String feedback,String user_id,HttpServletResponse response){
		
		boolean flag = authenticationService.authenUserPass(feedback, user_id);
		if (flag == true) {
			// mv.setViewName("");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		mv.setViewName("mgmt_m_register");

		return mv;
		
	}
	
	/**
	 * 审核个人用户拒绝，需要修改状态为未验证
	 * @return
	 */
	@RequestMapping("authenUserDeny")
	public ModelAndView authenUserDeny(String feedback,String user_id,HttpServletResponse response){
		
		boolean flag = authenticationService.authenUserDeny(feedback, user_id);
		if (flag == true) {
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mv.setViewName("mgmt_m_register");
		return mv;

	}
	
	/**
	 * 审核公司用户通过
	 * @return
	 */
	@RequestMapping("authenCompanyPass")
	public ModelAndView authenCompanyPass(String feedback,String user_id,HttpServletResponse response){
		
		boolean flag=authenticationService.authenCompanyPass(feedback,user_id);
		
		if(flag==true){
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mv.setViewName("mgmt_m_register");
		
		return mv;
	}
	
	/**
	 * 审核公司用户拒绝
	 * @return
	 */
	@RequestMapping("authenCompanyDeny")
	public ModelAndView authenCompanyDeny(String feedback,String user_id,HttpServletResponse response){
		
		boolean flag=authenticationService.authenCompanyDeny(feedback,user_id);
		
		if(flag==true){
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mv.setViewName("mgmt_m_register");
		
		return mv;
	}
	
	

	@RequestMapping("authenticview")
	/**
	 * 
	 * @param clientId
	 * @param flag
	 * @return
	 */
	public ModelAndView getAuthenticationCheck(@RequestParam String clientId,
			@RequestParam int flag, HttpServletRequest request,
			HttpServletResponse response) {
		if(flag == 2){//查看个人信息
			Clientinfo clientinfo = authenticationService
					.getAuthenticationInfo(clientId);
			mv.addObject("clientinfo", clientinfo);
			Userinfo userinfo = clientSecurityService.getUserById(clientId);
			mv.addObject("userinfo", userinfo);
			mv.setViewName("mgmt_m_register2a");
		}
		else if(flag == 3){//查看公司信息
			Companycertificate companycertificate = companycertificateService.getCompanycertificate(clientId);
			mv.addObject("detailCompanyCertificate", companycertificate);
			Userinfo userinfo = clientSecurityService.getUserById(clientId);
			mv.addObject("userinfo", userinfo);
			mv.setViewName("mgmt_m_register3a");
		}
		return mv;
	}

	@RequestMapping("/findbyusername")
	/**
	 * 获取所有待认证信息
	 * @param request
	 * @return
	 */
	public ModelAndView findByUsername(String username,
			HttpServletRequest request) {
		List validateList = authenticationService.getFindUser(username);
		mv.addObject("validateList", validateList);
		mv.setViewName("mgmt_m_register");

		return mv;

	}
}
