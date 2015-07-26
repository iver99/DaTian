package cn.edu.bjtu.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.bean.page.SubAccountBean;
import cn.edu.bjtu.service.RegisterService;
import cn.edu.bjtu.service.SubAccountService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.vo.SubAccount;

import com.alibaba.fastjson.JSONObject;

@Controller
public class SubAccountController {
	
	ModelAndView mv=new ModelAndView();
	
	@Resource 
	SubAccountService subAccountService;
	@Autowired
	RegisterService registerService;
	
	/**
	 * 获取公司子账户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getsubaccount")
	public ModelAndView getSubAccount(HttpServletRequest request,HttpServletResponse response)
	{
		String userId=(String)request.getSession().getAttribute(Constant.USER_ID);
		List subAccountList = subAccountService.getSubAccount(userId);
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
		
		String userId=(String)request.getSession().getAttribute(Constant.USER_ID);

		List subAccountList = subAccountService.getFindSubAccount(userId, username);
		mv.addObject("subAccountList", subAccountList);
		mv.setViewName("mgmt_a_subaccount");
		return mv;
	}
	
	/**
	 * 显示具体子账户信息
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("subaccountdetail")
	public String subAccountDetail(@RequestParam String id,
			HttpServletRequest request){
		request.setAttribute("id", id);
		return "mgmt_a_subaccount4";
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
		
		String userId=(String)request.getSession().getAttribute(Constant.USER_ID);
		boolean flag = subAccountService.changeStatus(id);
		try {
			if (flag == true)
				response.sendRedirect("getsubaccount");
			else
				System.out.println("更改用户停用启用失败");// 应记录日志
		} catch (IOException e) {
			// 
			// 此处应记录日志
			e.printStackTrace();

		}
		
		return mv;
	}
	
	/**
	 * 删除子账户 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("deletesubaccount")
	public String deleteSubAccount(
			@RequestParam String id,
			HttpServletRequest request,HttpServletResponse response){
		
		subAccountService.deleteSubAccount(id);
		return "redirect:getsubaccount";
	}
	
	@RequestMapping("addsubaccount")
	/**
	 * 获取添加附属账户表单 -跳转到新增用户界面
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addSubAccount(
			HttpServletRequest request,HttpServletResponse response){
		String username=(String)request.getSession().getAttribute("username");
		mv.addObject("username", username);
		mv.setViewName("mgmt_a_subaccount2");
		return mv;
	}
	
	/**
	 * 新增附属账户
	 * @param subAccountBean
	 * @param session
	 * @return
	 */
	@RequestMapping("insertsubaccount")
	public String insertSubAccount(SubAccountBean subAccountBean,HttpSession session){
			boolean flag=subAccountService.addNewSubAccount(subAccountBean,session);
	
			return "redirect:getsubaccount";
	}
	
		/**
		 * 获取附属账户信息
		 * @param id
		 * @return
		 */
		@RequestMapping(value="getSubAccountInfoAjax",produces="text/html;charset=UTF-8")
		@ResponseBody
	 	public String updateSubAccount(@RequestParam String id,
				HttpServletRequest request,HttpServletResponse response){
			SubAccount subAccount=subAccountService.getSubAccountDetail(id);
			String str=JSONObject.toJSONString(subAccount);
			return str;
	 }
		
	/**
	 * 跳到附属账户信息页面(更新操作)
	 * @return
	 */
	@RequestMapping("getUpdateSubAccountPage")
	public String getSubAccountInfoPage(String id,HttpServletRequest request){
		request.setAttribute("id", id);
		return "mgmt_a_subaccount3";
	}
	
	/**
	 * 更新附属账户
	 * @param subAccountBean
	 * @param session
	 * @return
	 */
		@RequestMapping("doupdate")
		public String doUpdate(SubAccountBean subAccountBean,HttpSession session){
			//更新subaccount表	//更新userinfo表
			subAccountService.updateSubAccount(subAccountBean,session);
			
			return "redirect:getsubaccount";
		}
	 
}
