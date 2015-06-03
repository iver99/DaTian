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

@Controller
/**
 * 公司客户businessclient相关控制器
 * @author RussWest0
 * @date   2015年5月28日 下午11:16:36
 */
public class BusinessClientController {
	
	@Resource
	ClientService clientService;
	
	ModelAndView mv=new ModelAndView();
	
	
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
	 * 添加businessclient新客户
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
		String carrierId = (String) request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除

		String path = null;
		String fileName = null;
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
		}
		// 没有上传文件的情况path 和 filenName默认为null
		
		boolean flag = clientService.insertBusinessClient(account, clientName,
				clientBusiness, contact, phone, remarks, carrierId,path,fileName);
		if (flag == true) {
			try {
				response.sendRedirect("client");// 重定向，显示最新的结果
												// error,无法重定向
				// mv.setViewName("mgmt_r_car");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("client插入后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("mgmt_r_customer");
		return mv;
	}
	/**
	 * 更新businessclient信息
	 */
	@RequestMapping(value = "updateClient", method = RequestMethod.POST)
	/**
	 * 
	 * 更新businessclient信息
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
	public ModelAndView updateClientInfo(@RequestParam MultipartFile file,
			@RequestParam String id,// GET方式传入，在action中
			@RequestParam String account, @RequestParam String clientName,
			@RequestParam String clientBusiness, @RequestParam String contact,
			@RequestParam String phone, @RequestParam String remarks,
			HttpServletRequest request, HttpServletResponse response) {
		String carrierId = (String) request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除

		String path = null;
		String fileName = null;
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
	
		
		boolean flag = clientService.updateBusinessClient(id, account, clientName,
				clientBusiness, contact, phone, remarks, carrierId,path,fileName);
		System.out.println("flag+" + flag);
		if (flag == true) {
			try {
				response.sendRedirect("client");// 重定向，显示最新的结果
												// error,无法重定向
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("client更新后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("mgmt_r_customer");
		return mv;
	}

	@RequestMapping(value = "clientdelete", method = RequestMethod.GET)
	/**
	 * 删除businessclient
	 */
	public ModelAndView deleteClient(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		boolean flag = clientService.deleteBusinessClient(id);
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
			mv.setViewName("mgmt_r_customer");
		return mv;
	}
	
	/**
	 * 下载businessclient相关的文件
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "downloadclientrelated", method = RequestMethod.GET)
	public ModelAndView downloadClientRelated(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		Businessclient clientInfo = clientService.getBusinessclientInfo(id);
		try {
			String file = clientInfo.getRelatedMaterial();
			File tempFile =new File(file.trim());  	          
	        String fileName = tempFile.getName();  			
			InputStream is = new FileInputStream(file);
			response.reset(); // 必要地清除response中的缓存信息
			response.setHeader("Content-Disposition", "attachment; filename="
					+ java.net.URLEncoder.encode(fileName, "UTF-8"));
			javax.servlet.ServletOutputStream out = response.getOutputStream();
			byte[] content = new byte[1024];
			int length = 0;
			while ((length = is.read(content)) != -1) {
				out.write(content, 0, length);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println("重定向失败");
			e.printStackTrace();
		}

		return mv;
	}
}
