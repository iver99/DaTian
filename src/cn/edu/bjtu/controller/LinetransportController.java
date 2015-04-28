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

import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Linetransport;

@Controller
/**
 * 干线相关控制器
 * @author RussWest0
 *
 */
public class LinetransportController {

	/*
	 * @Resource HibernateTemplate ht;
	 */
	@RequestMapping("/linetransport")
	/**
	 * 返回所有干线信息
	 * @return
	 */
	public ModelAndView getAllLinetransport(@RequestParam int flag,
			@RequestParam(required = false) Integer Display,
			@RequestParam(required = false) Integer PageNow,
			HttpServletRequest request) {
		if (Display == null)
			Display = 10;// 默认的每页大小
		if (PageNow == null)
			PageNow = 1;// 默认的当前页面

		if (flag == 0) {
			List linetransportList = linetransportService.getAllLinetransport(
					Display, PageNow);
			int count = linetransportService.getTotalRows("All", "All", "All",
					"All", "All");// 获取总记录数,不需要where子句，所以参数都是All
			// System.out.println("count+"+count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);
			mv.addObject("linetransportList", linetransportList);
			mv.setViewName("resource_list");
		} else if (flag == 1) {
			// 这里从session取出id，查询指定的line
			String carrierId = (String) request.getSession().getAttribute(
					"userId");

			List linetransportList = linetransportService.getCompanyLine(
					carrierId, Display, PageNow);// 新增两个参数
			// System.out.println("linetransportsize+"+linetransportList.size());
			int count = linetransportService.getCompanyTotalRows(carrierId);// 新增的访法
			// System.out.println("count+"+count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);

			mv.addObject("linetransportList", linetransportList);
			mv.setViewName("mgmt_r_line");
		}
		return mv;
	}

	@RequestMapping(value = "/linetransportdetail", method = RequestMethod.GET)
	/**
	 * 获取特定的干线信息
	 * @param linetransportid
	 * @return
	 */
	public ModelAndView getLinetransportInfo(
			@RequestParam("linetransportid") String linetransportid,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("flag") int flag, HttpServletRequest request) {
		Linetransport linetransportInfo = linetransportService
				.getLinetransportInfo(linetransportid);// 需要重构，返回一条线路信息
		mv.addObject("linetransportInfo", linetransportInfo);
		if (flag == 0) {
			// carrierId=(String)request.getSession().getAttribute("carrierId");
			// carrierId="C-0002";//删除
			Carrierinfo carrierInfo = companyService.getCarrierInfo(carrierId);
			mv.addObject("carrierInfo", carrierInfo);
			mv.setViewName("resource_detail1");
		} else if (flag == 1) {// 详情
			mv.setViewName("mgmt_r_line4");
		} else if (flag == 2) {// 更新
			mv.setViewName("mgmt_r_line3");

		}
		return mv;
	}

	@RequestMapping(value = { "linetransportselected", "searchResourceselected" })
	// 同时拦截两种请求
	/**              
	 * 返回干线符合筛选的条件的信息
	 * @param startPlace
	 * @param endPlace
	 * @param type
	 * @param startPlace
	 * @param refPrice
	 * @param Display
	 * @param PageNow
	 * @return
	 */
	public ModelAndView getSelectedLine(@RequestParam String startPlace,
			@RequestParam String endPlace, @RequestParam String type,
			@RequestParam String startPlace1, @RequestParam String refPrice,
			@RequestParam int Display, @RequestParam int PageNow,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("已经进入linetransport控制器");

		List linetransportList = linetransportService.getSelectedLine(
				startPlace, endPlace, type, startPlace1, refPrice, Display,
				PageNow);
		int count = linetransportService.getTotalRows(startPlace, endPlace,
				type, startPlace1, refPrice);// 获取总记录数

		int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
		// System.out.println("总记录数+"+count);
		// System.out.println("页数+"+pageNum);
		mv.addObject("linetransportList", linetransportList);
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pageNow", PageNow);
		mv.setViewName("resource_list");

		return mv;
	}

	@RequestMapping(value = "insertLine", method = RequestMethod.POST)
	/**
	 * 新增干线线路
	 * @param lineName
	 * @param startPlace
	 * @param endPlace
	 * @param onWayTime
	 * @param type
	 * @param refPrice
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView insertLine(
			@RequestParam(required = false) MultipartFile file,// new add
			@RequestParam String lineName, @RequestParam String startPlace,
			@RequestParam String endPlace, @RequestParam int onWayTime,
			@RequestParam String type,
			@RequestParam float refPrice,// 缺少详细报价参数
			@RequestParam String remarks, HttpServletRequest request,
			HttpServletResponse response) {
		String carrierId = (String) request.getSession().getAttribute("userId");
		// ////////////////////////////////////////////////////////////////////////

		String path = null;
		String fileName = null;
		//System.out.println("file+"+file+"filename"+file.getOriginalFilename());//不上传文件还是会显示有值
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getLinetransportPath();// 不同的地方取不同的上传路径
			fileName = file.getOriginalFilename();
			fileName = carrierId + "_" + fileName;// 文件名
			File targetFile = new File(path, fileName);
			try { // 保存 文件
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//System.out.println("path+fileName+" + path + "-" + fileName);
			// //////////////////////////////////////////////////////////////////
		} 
		//没有上传文件的情况path 和 filenName默认为null
		boolean flag = linetransportService.insertLine(lineName, startPlace,
				endPlace, onWayTime, type, refPrice, remarks, carrierId, path,
				fileName);
		// 修改此方法,增加两个参数
		if (flag == true) {
			try {
				response.sendRedirect("linetransport?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("linetransport插入后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;
	}

	@RequestMapping(value = "updateLine", method = RequestMethod.POST)
	/**
	 * 更新干线信息
	 * @param id
	 * @param lineName
	 * @param startPlace
	 * @param endPlace
	 * @param onWayTime
	 * @param type
	 * @param refPrice
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateLine(@RequestParam MultipartFile file,
			@RequestParam String id,// GET方式传入，在action中
			@RequestParam String lineName, @RequestParam String startPlace,
			@RequestParam String endPlace, @RequestParam int onWayTime,
			@RequestParam String type,
			@RequestParam float refPrice,// 缺少详细报价参数
			@RequestParam String remarks, HttpServletRequest request,
			HttpServletResponse response) {
		String carrierId = (String) request.getSession().getAttribute("userId");
		//////////////////////////////////////////////
		String path = null;
		String fileName = null;
		//System.out.println("file+"+file+"filename"+file.getOriginalFilename());//不上传文件还是会显示有值
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getLinetransportPath();// 不同的地方取不同的上传路径
			fileName = file.getOriginalFilename();
			fileName = carrierId + "_" + fileName;// 文件名
			File targetFile = new File(path, fileName);
			try { // 保存 文件
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//System.out.println("path+fileName+" + path + "-" + fileName);
		} 
		//没有上传文件的情况path 和 filenName默认为null
		
		//////////////////////////////////////////////
		
		boolean flag = linetransportService.updateLine(id, lineName,
				startPlace, endPlace, onWayTime, type, refPrice, remarks,
				carrierId,path,fileName);//change
		if (flag == true) {
			try {
				response.sendRedirect("linetransport?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("linetransport更新后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;

	}

	@RequestMapping(value = "linetransportdelete", method = RequestMethod.GET)
	/**
	 * 删除干线
	 */
	public ModelAndView deleteLine(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		boolean flag = linetransportService.deleteLine(id);
		if (flag == true) {
			// mv.setViewName("mgmt_r_line");
			try {
				response.sendRedirect("linetransport?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("linetransport删除后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;

	}

	@Resource
	LinetransportService linetransportService;
	@Resource
	CompanyService companyService;

	ModelAndView mv = new ModelAndView();
}
