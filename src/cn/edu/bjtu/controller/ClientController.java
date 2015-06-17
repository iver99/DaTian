package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.ClientService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Clientinfo;

@Controller
/**
 * 客户控制器
 * @author RussWest0
 *
 */
public class ClientController {
	@Resource
	ClientService clientService;
	ModelAndView mv = new ModelAndView();

	@RequestMapping("accountinfo")
	/**
	 * 列出当前用户的验证信息
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getAccountInfo(HttpServletRequest request,
			HttpServletResponse response) {
		// 此方法内可能需要判断用户种类,因为企业用户和个人用户的验证页面不一样
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		if(userId==null)//未登录
		{
			mv.setViewName("login");
			return mv;
		}
		//int userKind=(Integer)request.getSession().getAttribute("userKind");
		boolean flag = clientService.checkHeadIconStatus(userId);
		String status = clientService.getStatus(userId);
		mv.addObject("status", status);
		mv.addObject("headCheck", flag);
		mv.setViewName("mgmt_a_info");
		return mv;
	}

	@RequestMapping("basicuserinfo")
	/**
	 * 基本信息
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getBasicUserInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);

		String email = clientService.getBasicUserInfo(userId);
		mv.addObject("email", email);
		mv.setViewName("mgmt_a_info2");
		return mv;
	}
	/**
	 * 获取个人用户验证表单
	 */
	@RequestMapping("getvalidateform")
	/**
	 * 验证账户表单
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getValidateForm() {
		mv.setViewName("mgmt_a_info3");
		return mv;
	}

	@RequestMapping("validateuser")
	public ModelAndView validateUser(@RequestParam(required = false) MultipartFile file,
			String realName, String phone,
			String IDCard, String sex, HttpServletRequest request,
			HttpServletResponse response) {
		String userId=(String)request.getSession().getAttribute(Constant.USER_ID);
		
		// ////////////////////////////////////////////
		String path = null;
		String fileName = null;
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getClientPath();// 不同的地方取不同的上传路径
			fileName = file.getOriginalFilename();
			fileName = userId + "_" + fileName;// 文件名
			File targetFile = new File(path, fileName);
			try { // 保存 文件
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 没有上传文件的情况path 和 filenName默认为null

		// ////////////////////////////////////////////
		
		boolean flag=clientService.validateUser(userId,realName,phone,IDCard,sex,path,fileName);
		if(flag==true){
			try {
				response.sendRedirect("accountinfo");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{//验证账户出错
			mv.setViewName("mgmt_a_info");
			mv.addObject("msg", "验证账户出错，稍后请重试");
		}
			
		return mv;
	}
	/**
	 * 获取更新用户验证信息表单
	 * @return
	 */
	@RequestMapping("getupdateUserinfoForm")
	public ModelAndView getUpdateUserInfoForm(HttpSession session){
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Clientinfo clientinfo=clientService.getClientInfo(userId);//根据id获取clientinfo
		mv.addObject("clientinfo", clientinfo);
		mv.setViewName("mgmt_a_info3a");
		return mv;
	}
	
	@RequestMapping("updateclientinfo")
	/**
	 * 更新用户信息 
	 * @param session
	 * @param clientinfo
	 * @return
	 */
	public ModelAndView updateClientInfo(HttpServletResponse response,HttpSession session,Clientinfo clientinfo,MultipartFile file){
		String userId=(String) session.getAttribute(Constant.USER_ID);
		String path = null;
		String fileName = null;
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getClientPath();// 不同的地方取不同的上传路径
			fileName = file.getOriginalFilename();
			fileName = userId + "_" + fileName;// 文件名
			File targetFile = new File(path, fileName);
			try { // 保存 文件
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		boolean flag=clientService.updateClientinfo(clientinfo,path, fileName,userId);
		if(flag){
			mv.addObject("msg", "更新个人信息成功!");
			try {
				response.sendRedirect("accountinfo");//跳到我的信息页面
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			mv.addObject("msg", "更新个人信息失败！");
			try {
				response.sendRedirect("accountinfo");//跳到我的信息页面 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mv;
	}
	
	@RequestMapping("viewClientInfoDetail")
	/**
	 * 查看用户信息详情
	 * @return
	 */
	public ModelAndView viewClientInfoDetail(HttpSession session){
		String userId=(String )session.getAttribute(Constant.USER_ID);
		Clientinfo clientinfo=clientService.getClientInfo(userId);
		
		mv.addObject("clientinfo", clientinfo);
		mv.setViewName("mgmt_a_info3b");
		return mv;
	}

	/**
	 * 下载idpicture
	 */
	@RequestMapping(value = "downloaduseridpicture", method = RequestMethod.GET)
	public ModelAndView downloadUserIDPicture(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
			Clientinfo clientinfo = clientService.getClientInfo(id);
			String file = clientinfo.getIDPicture();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	
	/**
	 * 返回我的信息-首页下方交易信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserTransactionInfoAjax")
	public String getUserTransactionInfo(HttpSession session){
		//待结算未实现
		String data=clientService.getTransactionInfo(session);
		return data;
		
	}
	
}
