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
import cn.edu.bjtu.service.WarehouseService;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Warehouse;

@Controller
public class WarehouseController {

	@Resource
	WarehouseService warehouseService;
	@Resource
	CompanyService companyService;

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/warehouse")
	/**
	 * 返回所有仓库信息（视图查询）
	 * @return
	 */
	public ModelAndView getAllWarehouse(@RequestParam int flag,
			HttpServletRequest request) {
		int Display=10;//默认的每页大小
		int PageNow=1;//默认的当前页面
		
		
		if (flag == 0) {// 对应资源栏点击车辆
			List warehouseList = warehouseService.getAllWarehouse(Display,PageNow);
			int count = warehouseService.getTotalRows("All", "All", "All", "All");// 获取总记录数,不需要where子句，所以参数都是All
			System.out.println("count+"+count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);
			
			mv.addObject("warehouseList", warehouseList);
			mv.setViewName("resource_list4");
		} else if (flag == 1) {// 对应我的信息栏点击车辆信息
			String carrierId=(String)request.getSession().getAttribute("userId");
			// carrierId = "C-0002";// 需要删除
			List warehouseList = warehouseService
					.getCompanyWarehouse(carrierId);
			mv.addObject("warehouseList", warehouseList);
			mv.setViewName("mgmt_r_warehouse");
		}
		return mv;
	}

	@RequestMapping(value = "/warehousedetail", method = RequestMethod.GET)
	/**
	 * 获取特定的仓库信息
	 * 同时返回公司和仓库两个表的信息
	 * @param
	 * @return
	 */
	public ModelAndView getWarehouseInfo(
			@RequestParam("warehouseId") String warehouseid,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("flag") int flag) {
		Warehouse warehouseInfo = warehouseService
				.getWarehouseInfo(warehouseid);

		mv.addObject("warehouseInfo", warehouseInfo);
		if (flag == 0) {// 对应资源栏仓库详情
			Carrierinfo carrierInfo = companyService.getCarrierInfo(carrierId);
			mv.addObject("carrierInfo", carrierInfo);
			mv.setViewName("resource_detail4");
		} else if (flag == 1)// 对应我的信息栏仓库详情
			mv.setViewName("mgmt_r_warehouse4");
		else if (flag == 2)// 我的信息栏仓库更新
			mv.setViewName("mgmt_r_warehouse3");

		return mv;
	}

	@RequestMapping("warehouseselected")
	/**
	 * 返回符合筛选条件的仓库信息
	 * @param city
	 * @param type
	 * @param storageForm
	 * @param houseArea
	 * @param Display
	 * @param PageNow
	 * @return
	 */
	public ModelAndView getSelectedWarehouse(@RequestParam String city,
			@RequestParam String type, @RequestParam String storageForm,
			@RequestParam String houseArea, @RequestParam int Display,
			@RequestParam int PageNow,
			HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("进入仓库筛选控制器");
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("已经进入控制器");

		List warehouseList = warehouseService.getSelectedWarehouse(
				city, type, storageForm, houseArea,
				Display, PageNow);
		int count = warehouseService.getTotalRows(city, type, storageForm, houseArea);// 获取总记录数

		int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
		System.out.println("总记录数+"+count);
		System.out.println("页数+"+pageNum);
		mv.addObject("warehouseList", warehouseList);
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pageNow", PageNow);
		mv.setViewName("resource_list4");
		
		return mv;
	}

	@RequestMapping(value = "/insertWarehouse", method = RequestMethod.POST)
	/**
	 * 新增仓库
	 * @param name
	 * @param contact
	 * @param address
	 * @param city
	 * @param type
	 * @param houseArea
	 * @param yardArea
	 * @param height
	 * @param kind
	 * @param fireRate
	 * @param storageForm
	 * @param environment
	 * @param phone
	 * @param remarks
	 * @param serviceContent
	 * @param fireSecurity
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView insertWarehouse(@RequestParam MultipartFile file,
			@RequestParam String name,
			@RequestParam String contact, @RequestParam String address,
			@RequestParam String city, @RequestParam String type,
			@RequestParam float houseArea, @RequestParam float yardArea,
			@RequestParam float height, @RequestParam String kind,
			@RequestParam String fireRate, @RequestParam String storageForm,
			@RequestParam String environment, @RequestParam String phone,
			@RequestParam String remarks, @RequestParam String serviceContent,
			@RequestParam String fireSecurity, HttpServletRequest request,
			HttpServletResponse response) {
		// 此处获取session里的carrierid，下面方法增加一个参数
		// String
		String carrierId=(String)request.getSession().getAttribute("userId");
		//String carrierId = "C-0002";// 删除
		
		String path = null;
		String fileName = null;
		// System.out.println("file+"+file+"filename"+file.getOriginalFilename());//不上传文件还是会显示有值
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getWarehousePath();// 不同的地方取不同的上传路径
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
		
		System.out.println("进入插入仓库控制器");
		boolean flag = warehouseService.insertWarehouse(name, city, address,
				type, kind, houseArea, yardArea, height, fireRate, storageForm,
				fireSecurity, environment, serviceContent, contact, phone,
				remarks, carrierId, path, fileName);
		if (flag == true) {
			try {
				response.sendRedirect("warehouse?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("warehouse插入后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;
	}
	
	@RequestMapping(value = "/updateWarehouse", method = RequestMethod.POST)
	/**
	 * 更新仓库信息
	 * @param id
	 * @param name
	 * @param city
	 * @param address
	 * @param type
	 * @param kind
	 * @param houseArea
	 * @param yardArea
	 * @param height
	 * @param fireRate
	 * @param storageForm
	 * @param fireSecurity
	 * @param environment
	 * @param serviceContent
	 * @param contact
	 * @param phone
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateWarehouse(@RequestParam MultipartFile file,
			@RequestParam String id,// GET方式传入，在action中
			@RequestParam String name,
			@RequestParam String city,
			@RequestParam String address,
			@RequestParam String type,
			@RequestParam String kind,
			@RequestParam float houseArea,
			@RequestParam float yardArea,
			@RequestParam float height,
			@RequestParam String fireRate,
			@RequestParam String storageForm,
			@RequestParam String fireSecurity,
			@RequestParam String environment,
			@RequestParam String serviceContent,
			@RequestParam String contact,
			@RequestParam String phone,
			@RequestParam String remarks, HttpServletRequest request,
			HttpServletResponse response) {

		// 此处获取session里的carrierid，下面方法增加一个参数
		// String
		String carrierId=(String)request.getSession().getAttribute("userId");
		//String carrierId = "C-0002";// 删除

		String path = null;
		String fileName = null;
		// System.out.println("file+"+file+"filename"+file.getOriginalFilename());//不上传文件还是会显示有值
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getWarehousePath();// 不同的地方取不同的上传路径
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
	
		
		boolean flag = warehouseService.updateWarehouse(id, name, city, address, type,
				kind, houseArea, yardArea, height, fireRate, storageForm, fireSecurity,
				environment, serviceContent, contact, phone, remarks, carrierId, path, fileName);
		if (flag == true) {
			
			try {
				response.sendRedirect("warehouse?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("warehouse更新后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;

	}
	
	@RequestMapping(value = "warehousedelete", method = RequestMethod.GET)
	/**
	 * 删除
	 */
	public ModelAndView deleteWarehouse(
			@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("进入删除控制器");
		System.out.println(id);
		// 此处获取session里的carrierid，下面方法增加一个参数
		//String carrierId=(String)request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除
		boolean flag = warehouseService.deleteWarehouse(id);
		if (flag == true) {
			// mv.setViewName("mgmt_r_line");
			try {
				response.sendRedirect("warehouse?flag=1");// 重定向，显示最新的结果
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
}
