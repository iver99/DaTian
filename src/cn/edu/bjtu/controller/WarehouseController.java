package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import cn.edu.bjtu.bean.search.WarehouseSearchBean;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.WarehouseService;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Warehouse;

import com.alibaba.fastjson.JSONArray;

@Controller
public class WarehouseController {
	@Autowired
	CommentService commentService;
	@Resource
	WarehouseService warehouseService;
	@Resource
	CompanyService companyService;
	@Autowired
	FocusService focusService;
	ModelAndView mv = new ModelAndView();

	
	/**
	 * 返回所有仓库信息（视图查询）
	 * @return
	 */
	@RequestMapping(value="/warehouse",params="flag=0")
	public String getAllWarehouse() {
		return "resource_list4";
	}
	
	/**
	 * 返回仓库筛选结果
	 * @param warehouseBean
	 * @param pageUtil
	 * @param sesion
	 * @return
	 */
	@RequestMapping(value="getSelectedWarehouseAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSelectedWarehouseAjax(WarehouseSearchBean warehouseBean,PageUtil pageUtil,HttpSession session){
		JSONArray jsonArray = warehouseService.getSelectedWarehouseNew(warehouseBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	
	/**
	 * 返回仓库筛选页面总记录数
	 * @param warehouseBean
	 * @return
	 */
	@RequestMapping("getSelectedWarehouseTotalRowsAjax")
	@ResponseBody
	public Integer getSelectedWarehouseTotalRowsAjax(WarehouseSearchBean warehouseBean){
		Integer count=warehouseService.getSelectedWarehouseTotalRows(warehouseBean);
		return count;
	}
	
	/**
	 * 我的信息-仓库信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/warehouse",params="flag=1")
	public ModelAndView getMyInfoWarehouse(HttpServletRequest request){
		String carrierId=(String)request.getSession().getAttribute("userId");
		// carrierId = "C-0002";// 需要删除
		List warehouseList = warehouseService
				.getCompanyWarehouse(carrierId);
		mv.addObject("warehouseList", warehouseList);
		mv.setViewName("mgmt_r_warehouse");
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
			@RequestParam("flag") int flag,
			HttpServletRequest request) {
		Warehouse warehouseInfo = warehouseService
				.getWarehouseInfo(warehouseid);
		String clientId = (String) request.getSession().getAttribute("userId");
		List focusList = focusService.getFocusList(clientId,"warehouse");
		mv.addObject("focusList", focusList);
		mv.addObject("warehouseInfo", warehouseInfo);
		if (flag == 0) {// 对应资源栏仓库详情
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			List<Comment> commentList=commentService.getWarehouseCommentById(warehouseid,carrierId);
			mv.addObject("commentList",commentList);
			mv.addObject("carrierInfo", carrierInfo);
			mv.setViewName("resource_detail4");
		} else if (flag == 1)// 对应我的信息栏仓库详情
			mv.setViewName("mgmt_r_warehouse4");
		else if (flag == 2){
			// 我的信息栏仓库更新
			// 保管形态字符串拆解
			String storageForm = warehouseInfo.getStorageForm();
			String[] storageFormSpl = storageForm.split(",");
			String[] everystorageForm ={"普通","冷藏","恒温","露天","危险品"};
			for(int i=0;i<5;i++)
			{
				int j=0;
				for(;j<storageFormSpl.length;j++){
					if(storageFormSpl[j].equals(everystorageForm[i])){
						break;
					}
				}
				System.out.println(j);
				if(j==storageFormSpl.length){
					everystorageForm[i]="";
				}
			}
			mv.addObject("everystorageForm", everystorageForm);
			// 防火安保字符串拆解
			String fireSecurity = warehouseInfo.getFireSecurity();
			String[] fireSecuritySpl = fireSecurity.split(",");
			String[] everyfireSecurity ={"烟感","自动喷淋","24小时摄像监控","无"};
			for(int i=0;i<4;i++)
			{
				int j=0;
				for(;j<fireSecuritySpl.length;j++){
					if(fireSecuritySpl[j].equals(everyfireSecurity[i])){
						break;
					}
				}
				System.out.println(j);
				if(j==fireSecuritySpl.length){
					everyfireSecurity[i]="";
				}
			}
			mv.addObject("everyfireSecurity", everyfireSecurity);
			// IT环境字符串拆解
			String environment = warehouseInfo.getEnvironment();
			String[] environmentSpl = environment.split(",");
			String[] everyenvironment ={"Internet宽带接入","仓库信息管理系统","无"};
			for(int i=0;i<3;i++)
			{
				int j=0;
				for(;j<environmentSpl.length;j++){
					if(environmentSpl[j].equals(everyenvironment[i])){
						break;
					}
				}
				System.out.println(j);
				if(j==environmentSpl.length){
					everyenvironment[i]="";
				}
			}
			mv.addObject("everyenvironment", everyenvironment);
			// 服务内容字符串拆解
			String serviceContent = warehouseInfo.getServiceContent();
			String[] serviceContentSpl = serviceContent.split(",");
			String[] everyserviceContent ={"机械出入库搬运","分拣","包装","打托盘","地面存储 ","货架存储"};
			for(int i=0;i<6;i++)
			{
				int j=0;
				for(;j<serviceContentSpl.length;j++){
					if(serviceContentSpl[j].equals(everyserviceContent[i])){
						break;
					}
				}
				System.out.println(j);
				if(j==serviceContentSpl.length){
					everyserviceContent[i]="";
				}
			}
			mv.addObject("everyserviceContent", everyserviceContent);
			
			mv.setViewName("mgmt_r_warehouse3");
		}
			

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
		
		String path = null;
		String fileName = null;

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

		String path = null;
		String fileName = null;
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
	
	@RequestMapping(value = "downloadwarehousedetailprice", method = RequestMethod.GET)
	/**
	 * 删除
	 */
	public ModelAndView downloadWarehouseDetailPrice(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		Warehouse warehouseInfo = warehouseService.getWarehouseInfo(id);
			String file = warehouseInfo.getDetailPrice();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	
	
}
