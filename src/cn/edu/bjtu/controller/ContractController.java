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
import cn.edu.bjtu.service.ContractService;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Contract;

@Controller
/**
 * 合同控制器
 * @author RussWest0
 *
 */
public class ContractController {

	@Resource(name="contractServiceImpl")
	ContractService contractService;
	@Resource
	CompanyService companyService;

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/contract")
	/**
	 * 获取公司所有的合同
	 * @param contractId
	 * @param flag
	 * @param request
	 * @return
	 */
	public ModelAndView getCompanyContract(HttpServletRequest request) {
		String carrierId=(String)request.getSession().getAttribute("userId");
		//String carrierId = "C-0002";
		List contractList = contractService.getCompanyContract(carrierId);
		System.out.println("contractList+" + contractList);
		mv.addObject("contractList", contractList);
		Carrierinfo carrierInfo = companyService.getCarrierInfo(carrierId);
		mv.addObject("carrierInfo", carrierInfo);
		mv.setViewName("mgmt_r_contact_s");
		return mv;

	}

	@RequestMapping("contractdetail")
	/**
	 * 合同详情
	 * @param contractId
	 * @param flag
	 * @return
	 */
	public ModelAndView getContractInfo(@RequestParam String contractId,
			@RequestParam int flag, HttpServletRequest request) {
		String carrierId=(String)request.getSession().getAttribute("userId");
		//String carrierId = "C-0002";
		Contract contract = contractService.getContractInfo(contractId);
		mv.addObject("contract", contract);
		Carrierinfo carrierInfo = companyService.getCarrierInfo(carrierId);
		mv.addObject("carrierInfo", carrierInfo);
		if (flag == 1)// 详情
		{
			mv.setViewName("mgmt_r_contact_s4");
		} else if (flag == 2)// 终止
		{
			mv.setViewName("mgmt_r_contact_s3");
		}

		return mv;

	}

	@RequestMapping(value = "insertContract", method = RequestMethod.POST)
	/**
	 * 新增合同
	 * @param id
	 * @param name
	 * @param caculateType
	 * @param carrierAccount
	 * @param startDate
	 * @param endDate
	 * @param contact
	 * @param phone
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView insertContract(@RequestParam MultipartFile file,@RequestParam String id,
			@RequestParam String name, @RequestParam String caculateType,
			@RequestParam String carrierAccount,
			@RequestParam String startDate, @RequestParam String endDate,
			@RequestParam String contact, @RequestParam String phone,
			@RequestParam String remarks,
			@RequestParam(required=false) String monthlyStatementDays, 
			HttpServletRequest request,	HttpServletResponse response) {
		String carrierId=(String)request.getSession().getAttribute("userId");
		//String carrierId = "C-0002";// 删除

		String path = null;
		String fileName = null;
		// System.out.println("file+"+file+"filename"+file.getOriginalFilename());//不上传文件还是会显示有值
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getContactPath();// 不同的地方取不同的上传路径
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
	
		boolean flag = contractService.insertContract(id, name, caculateType,
				carrierAccount, startDate, endDate, contact, phone, remarks,
				carrierId, monthlyStatementDays, path, fileName);
		if (flag == true) {
			try {
				response.sendRedirect("contract");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("contract插入后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;
	}
	@RequestMapping(value="shutdownContract",method = RequestMethod.POST)
	/**
	 * 终止合同
	 * @param contractId
	 * @param reason
	 * @param response
	 * @return
	 */
	public ModelAndView shutdownContract(@RequestParam String contractId,@RequestParam String reason,HttpServletResponse response)
	{
		
		boolean flag=false;
		flag=contractService.shutdownContract(contractId, reason);
		if(flag==true)
			try {
				response.sendRedirect("contract");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("终止合同失败");
				e.printStackTrace();
			}
		return mv;
	}
	
	@RequestMapping(value="findcontract",method = RequestMethod.POST)
	/**
	 * 查找合同
	 */
	public ModelAndView findContract(@RequestParam String startDate,@RequestParam String endDate,
			@RequestParam String name, HttpServletResponse response, HttpServletRequest request)
	{
		int PageNow=1;//默认的当前页面
		int Display=10;//默认的每页大小
		
		System.out.println("进入contract控制器");
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("已经进入控制器");

		String carrierId=(String)request.getSession().getAttribute("userId");
		//String carrierId = "C-0002";
		List contractList = contractService.getFindContract(carrierId, startDate, endDate, name, Display, PageNow);
		System.out.println("contractList+" + contractList);
		mv.addObject("contractList", contractList);
		Carrierinfo carrierInfo = companyService.getCarrierInfo(carrierId);
		mv.addObject("carrierInfo", carrierInfo);
		
		int count = contractService.getFindContractTotalRows(carrierId, startDate, endDate, name, Display, PageNow);// 获取查询总记录数
		System.out.println("coount+"+count);
		int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
		System.out.println("总记录数+"+count);
		System.out.println("页数+"+pageNum);
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pageNow", PageNow);
		mv.setViewName("mgmt_r_contact_s");
		return mv;
		
	}

}
