package cn.edu.bjtu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import cn.edu.bjtu.service.ClientService;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Driverinfo;

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

	@RequestMapping("/client")
	/**
	 * 获取公司所有客户
	 * @param request
	 * @return
	 */
	public ModelAndView getCompanyClient(HttpServletRequest request) {
		String carrierId = (String) request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除
		List clientList = clientService.getCompanyClient(carrierId);// 获取businessclient，不是user
																	// client
		mv.addObject("clientList", clientList);
		mv.setViewName("mgmt_r_customer");
		return mv;
	}

	@RequestMapping("clientdetail")
	/**
	 * 获取客户详细信息
	 * @param clientId
	 * @param flag
	 * @return
	 */
	public ModelAndView getClientInfo(@RequestParam String clientId,
			@RequestParam int flag) {
		// Clientinfo clientInfo = clientService.getClientInfo(clientId);
		Businessclient clientInfo = clientService
				.getBusinessclientInfo(clientId);
		mv.addObject("clientInfo", clientInfo);
		if (flag == 1) {
			mv.setViewName("mgmt_r_customer4");
		} else if (flag == 2) {
			mv.setViewName("mgmt_r_customer3");
		}
		return mv;
	}

	@RequestMapping(value = "insertClient", method = RequestMethod.POST)
	/**
	 * 添加新客户
	 * @param account
	 * @param clientName
	 * @param clientBusiness
	 * @param contact
	 * @param phone
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView insertClient(@RequestParam MultipartFile file,@RequestParam String account,
			@RequestParam String clientName,
			@RequestParam String clientBusiness, @RequestParam String contact,
			@RequestParam String phone, @RequestParam String remarks,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入client控制器insert");
		String carrierId = (String) request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除

		String path = null;
		String fileName = null;
		// System.out.println("file+"+file+"filename"+file.getOriginalFilename());//不上传文件还是会显示有值
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getClientPath();// 不同的地方取不同的上传路径
			fileName = file.getOriginalFilename();
			fileName = carrierId + "_" + fileName;// 文件名
			File targetFile = new File(path, fileName);
			try { // 保存 文件
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// System.out.println("path+fileName+" + path + "-" + fileName);
		}
		// 没有上传文件的情况path 和 filenName默认为null

		// ////////////////////////////////////////////
	
		
		boolean flag = clientService.insertClient(account, clientName,
				clientBusiness, contact, phone, remarks, carrierId,path,fileName);
		System.out.println("flag+" + flag);
		if (flag == true) {
			try {
				System.out.println("redirect之前");
				response.sendRedirect("client");// 重定向，显示最新的结果
												// error,无法重定向
				// mv.setViewName("mgmt_r_car");
				System.out.println("redirect之后");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("client插入后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;
	}

	@RequestMapping(value = "updateClient", method = RequestMethod.POST)
	/**
	 * 
	 * 更新客户
	 * @param id
	 * @param account
	 * @param clientName
	 * @param clientBusiness
	 * @param contact
	 * @param phone
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateClient(@RequestParam MultipartFile file,
			@RequestParam String id,// GET方式传入，在action中
			@RequestParam String account, @RequestParam String clientName,
			@RequestParam String clientBusiness, @RequestParam String contact,
			@RequestParam String phone, @RequestParam String remarks,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入client控制器update");
		String carrierId = (String) request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除

		String path = null;
		String fileName = null;
		// System.out.println("file+"+file+"filename"+file.getOriginalFilename());//不上传文件还是会显示有值
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getClientPath();// 不同的地方取不同的上传路径
			fileName = file.getOriginalFilename();
			fileName = carrierId + "_" + fileName;// 文件名
			File targetFile = new File(path, fileName);
			try { // 保存 文件
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// System.out.println("path+fileName+" + path + "-" + fileName);
		}
		// 没有上传文件的情况path 和 filenName默认为null

		// ////////////////////////////////////////////
	
		
		boolean flag = clientService.updateClient(id, account, clientName,
				clientBusiness, contact, phone, remarks, carrierId,path,fileName);
		System.out.println("flag+" + flag);
		if (flag == true) {
			try {
				System.out.println("redirect之前");
				response.sendRedirect("client");// 重定向，显示最新的结果
												// error,无法重定向
				// mv.setViewName("mgmt_r_car");
				System.out.println("redirect之后");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("client更新后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;
	}

	@RequestMapping(value = "clientdelete", method = RequestMethod.GET)
	/**
	 * 删除
	 */
	public ModelAndView deleteClient(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入删除控制器");
		System.out.println(id);
		// 此处获取session里的carrierid，下面方法增加一个参数
		// String carrierId=(String)request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除
		boolean flag = clientService.deleteClient(id);
		if (flag == true) {
			// mv.setViewName("mgmt_r_line");
			try {
				response.sendRedirect("client");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("删除后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;
	}

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
		// 当前下考虑个人用户，企业用户先不考虑，（数据库没有表)
		String userId = (String) request.getSession().getAttribute("userId");
		if(userId==null)//未登录
		{
			mv.setViewName("login");
			return mv;
		}
		int userKind=(Integer)request.getSession().getAttribute("userKind");
		boolean flag = clientService.checkHeadIcon(userId,userKind);
		// 个人用户
		/*if(userKind==2){//普通用户{
*/		String status = clientService.getStatus(userId);
		mv.addObject("status", status);
		mv.addObject("headCheck", flag);
	/*}else if(userKind==3){//企业用户
		
	}*/
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
		String userId = (String) request.getSession().getAttribute("userId");

		String email = clientService.getBasicUserInfo(userId);
		mv.addObject("email", email);
		mv.setViewName("mgmt_a_info2");
		return mv;
	}

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

	@RequestMapping("validateaccount")
	public ModelAndView validateAccount(HttpServletRequest request,
			HttpServletResponse response) {
		String userId = (String) request.getSession().getAttribute("userId");
		// 未完成
		return mv;
	}

	@RequestMapping("validateuser")
	public ModelAndView validateUser(String realName, String phone,
			String IDCard, String sex, HttpServletRequest request,
			HttpServletResponse response) {
		//System.out.println("进入验证用户控制器");
		String userId=(String)request.getSession().getAttribute("userId");
		
		boolean flag=clientService.validateUser(userId,realName,phone,IDCard,sex);
		if(flag==true)
			try {
				response.sendRedirect("accountinfo");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("验证账户出错");//logging
				e.printStackTrace();
			}
		return mv;
	}

	@RequestMapping(value = "downloadclientrelated", method = RequestMethod.GET)
	/**
	 * 删除
	 */
	public ModelAndView downloadClientRelated(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入删除控制器");
		System.out.println(id);
		// 此处获取session里的carrierid，下面方法增加一个参数
		// String carrierId=(String)request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除
		Businessclient clientInfo = clientService.getBusinessclientInfo(id);
		try {
			String file = clientInfo.getRelatedMaterial();
			/*File tempFile =new File(file.trim());  	          
	        String fileName = tempFile.getName();  			*/
			InputStream is = new FileInputStream(file);
			response.reset(); // 必要地清除response中的缓存信息
			response.setHeader("Content-Disposition", "attachment; filename="
					+ file);
			//response.setContentType("application/vnd.ms-excel");// 根据个人需要,这个是下载文件的类型
			javax.servlet.ServletOutputStream out = response.getOutputStream();
			byte[] content = new byte[1024];
			int length = 0;
			while ((length = is.read(content)) != -1) {
				out.write(content, 0, length);
			}
			out.write(content);
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println("重定向失败");
			e.printStackTrace();
		}

		//response.setHeader("Content-disposition", "attachment;filename="+ citylineInfo.getDetailPrice());
		return mv;

	}
	
	
}
