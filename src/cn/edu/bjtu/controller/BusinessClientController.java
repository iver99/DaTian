package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.BusinessClientService;
import cn.edu.bjtu.service.ClientService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;

/**
 * 公司客户businessclient相关控制器
 * @author RussWest0
 * @date   2015年5月28日 下午11:16:36
 */
@Controller
public class BusinessClientController {
	
	@Resource
	ClientService clientService;
	@Autowired
	BusinessClientService businessClientService;
	
	ModelAndView mv=new ModelAndView();
	
	
	/**
	 * 获取公司所有客户
	 * @param request
	 * @return
	 */
	@RequestMapping("/client")
	public String getCompanyClient(HttpServletRequest request) {
		return "mgmt_r_customer";
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

	/**
	 * 添加businessclient新客户
	 * @return
	 */
	@RequestMapping(value = "insertClient", method = RequestMethod.POST)
	public String insertNewClient(Businessclient client,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=businessClientService.insertNewClient(client,file,request);
		return "redirect:client";
	}

	@RequestMapping(value = "updateClient", method = RequestMethod.POST)
	public String updateNewClient(Businessclient client,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=businessClientService.updateNewClient(client,file,request);
		return "redirect:client";
	}
	
	/**
	 * 删除businessclient
	 */
	@RequestMapping(value = "clientdelete", method = RequestMethod.GET)
	public String deleteClient(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		clientService.deleteBusinessClient(id);
		return "redirect:client";
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
		String file = clientInfo.getRelatedMaterial();
		DownloadFile.downloadFile(file,request,response);

		return mv;
	}
	
	/**
	 * 获取用户的所属客户(订单页面)
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getUserBusinessClientAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserBusinessClientAjax(HttpSession session){
		
		JSONArray jsonArray=businessClientService.getUserBusinessClient(session);
		
		return jsonArray.toString();
		
		
	}
	/**
	 * 我的信息-客户信息
	 * @Title: getUserBusinessClient 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午4:26:54
	 */
	@ResponseBody
	@RequestMapping(value="getUserBusinessClientResourceAjax",produces = "text/html;charset=UTF-8")
	public String getUserBusinessClient(HttpSession session,PageUtil pageUtil){
		JSONArray jsonArray=businessClientService.getUserBusinessClient(session,pageUtil);
		
		return jsonArray.toString();
		
	}
	
	/**
	 * 我的信息-客户信息总记录数
	 * @Title: getUserBusinessClientTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午4:28:30
	 */
	@ResponseBody
	@RequestMapping(value="getUserBusinessClientTotalRowsAjax")
	public Integer getUserBusinessClientTotalRows(HttpSession session){
		return businessClientService.getUserBusinessClientTotalRows(session);
		
	}
}
