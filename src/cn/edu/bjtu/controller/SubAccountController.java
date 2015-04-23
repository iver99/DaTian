package cn.edu.bjtu.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.SubAccountService;
import cn.edu.bjtu.vo.SubAccount;

@Controller
public class SubAccountController {
	
	ModelAndView mv=new ModelAndView();
	
	@Resource 
	SubAccountService subAccountService;
	
	@RequestMapping("getsubaccount")
	public ModelAndView getSubAccount(HttpServletRequest request,HttpServletResponse response)
	{
		String userId=(String)request.getSession().getAttribute("userId");
		List subAccountList = subAccountService.getSubAccount(userId);
		System.out.println("subAccountList+" + subAccountList);
		mv.addObject("subAccountList", subAccountList);
		mv.setViewName("mgmt_a_subaccount");
		return mv;
	}
	
	@RequestMapping("findbyaccountname")
	/**
	 * 子账户的查询功能
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView findByAccountName(
			@RequestParam String username,
			HttpServletRequest request,HttpServletResponse response){
		
		String userId=(String)request.getSession().getAttribute("userId");
		//System.out.println("已经进入subaccount控制器");

		List subAccountList = subAccountService.getFindSubAccount(userId, username);
		//System.out.println("subAccountList+" + subAccountList);
		mv.addObject("subAccountList", subAccountList);
		mv.setViewName("mgmt_a_subaccount");
		return mv;
	}
	
	@RequestMapping("subaccountdetail")
	/**
	 * 显示具体子账户信息
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView subAccountDetail(
			@RequestParam String id,
			HttpServletRequest request,HttpServletResponse response){
		
		String userId=(String)request.getSession().getAttribute("userId");
		//System.out.println("已经进入subaccount控制器");

		SubAccount subAccount = subAccountService.getSubAccountDetail(id);
		//System.out.println("subAccount+" + subAccount);
		mv.addObject("subAccount", subAccount);
		mv.setViewName("mgmt_a_subaccount4");
		return mv;
	}
	
	@RequestMapping("changestatus")
	/**
	 * 更改用户停用启用状态
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView changeStatus(
			@RequestParam String id,
			HttpServletRequest request,HttpServletResponse response){
		
		String userId=(String)request.getSession().getAttribute("userId");
		System.out.println("已经进入subaccount控制器");
		boolean flag = subAccountService.changeStatus(id);
		try {
			if (flag == true)
				response.sendRedirect("getsubaccount");
			else
				System.out.println("更改用户停用启用失败");// 应记录日志
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// 此处应记录日志
			e.printStackTrace();

		}
		
		return mv;
	}
	
	@RequestMapping("deletesubaccount")
	/**
	 * 删除用户
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView deleteSubAccount(
			@RequestParam String id,
			HttpServletRequest request,HttpServletResponse response){
		
		String userId=(String)request.getSession().getAttribute("userId");
		//System.out.println("已经进入subaccount控制器");
		boolean flag = subAccountService.deleteSubAccount(id);
		try {
			if (flag == true)
				response.sendRedirect("getsubaccount");
			else
				System.out.println("删除用户失败");// 应记录日志
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// 此处应记录日志
			e.printStackTrace();

		}
		
		return mv;
	}
	
	@RequestMapping("addsubaccount")
	/**
	 * 跳转到新增用户界面
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addSubAccount(
			HttpServletRequest request,HttpServletResponse response){
		
		String userId=(String)request.getSession().getAttribute("userId");
		String username=(String)request.getSession().getAttribute("username");
		//System.out.println("已经进入subaccount控制器");
		mv.addObject("username", username);
		mv.setViewName("mgmt_a_subaccount2");
		return mv;
	}
	
	 @RequestMapping("insertsubaccount")
	/**
	 * 跳转到新增用户界面
	 * @param username
	 * @param password
	 * @param resourceManagement
	 * @param transactionManagement
	 * @param schemaManagement
	 * @param statisticsManagement
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView insertSubAccount(
		@RequestParam String username,
		@RequestParam String password,
		@RequestParam(required=false) String resourceManagement,
		@RequestParam(required=false) String transactionManagement,
		@RequestParam(required=false) String schemaManagement,
		@RequestParam(required=false) String statisticsManagement,
		@RequestParam String remarks,
		HttpServletRequest request,HttpServletResponse response){
		
		 String hostAccountId=(String)request.getSession().getAttribute("userId");
		 String hostAccountName=(String)request.getSession().getAttribute("username");
			
			//System.out.println("已经进入insertsubaccount控制器");
			
			boolean flag = subAccountService.insertSubAccount(username,password,resourceManagement,
					transactionManagement,schemaManagement,statisticsManagement,remarks,
					hostAccountId,hostAccountName);
			try {
				if (flag == true)
					response.sendRedirect("getsubaccount");
				else
					System.out.println("添加用户失败");// 应记录日志
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应记录日志
				e.printStackTrace();

			}
			
		return mv;
	}
	
	 @RequestMapping("updatesubaccount")
		/**
		 * 跳转到更新用户界面
		 * @param id
		 * @return
		 */
	 	public ModelAndView updateSubAccount(
	 			@RequestParam String id,
				HttpServletRequest request,HttpServletResponse response){
			
			String userId=(String)request.getSession().getAttribute("userId");
			System.out.println("已经进入subaccount控制器");

			SubAccount subAccount = subAccountService.getSubAccountDetail(id);
			System.out.println("subAccount+" + subAccount);
			mv.addObject("subAccount", subAccount);
			mv.setViewName("mgmt_a_subaccount3");
			return mv;
	 }
	
	 @RequestMapping("doupdate")
		/**
		 * 跳转到新增用户界面
		 * @param id
		 * @param username
		 * @param password
		 * @param resourceManagement
		 * @param transactionManagement
		 * @param schemaManagement
		 * @param statisticsManagement
		 * @param remarks
		 * @param request
		 * @param response
		 * @return
		 */
		public ModelAndView doUpdate(
			@RequestParam String id,
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam(required=false) String resourceManagement,
			@RequestParam(required=false) String transactionManagement,
			@RequestParam(required=false) String schemaManagement,
			@RequestParam(required=false) String statisticsManagement,
			@RequestParam String remarks,
			HttpServletRequest request,HttpServletResponse response){
			//System.out.println("已经进入updatesubaccount控制器");
				
			boolean flag = subAccountService.updateSubAccount(id, username, password,
					resourceManagement, transactionManagement, schemaManagement,
					statisticsManagement, remarks);
			try {
				if (flag == true)
					response.sendRedirect("getsubaccount");
				else
					System.out.println("添加用户失败");// 应记录日志
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应记录日志
				e.printStackTrace();
			}
			
			return mv;
		}
	 
}
