package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CompanycertificateService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Companycertificate;

@Controller
public class CompanycertificateController {
	@Resource
	CompanycertificateService companycertificateService;
	ModelAndView mv = new ModelAndView();
	

	@RequestMapping("getcompanyvalidateform")
	/**
	 * 验证公司表单
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getCompanyValidateForm() {
		mv.setViewName("mgmt_a_info4");
		return mv;
	}
	
	
	@RequestMapping("companycertificate")
	/**
	 * 验证公司信息
	 */
	public ModelAndView companycertificate(
			@RequestParam(required = false) MultipartFile file,
			@RequestParam(required = false) String companyName, @RequestParam(required = false) String divisionCode,
			@RequestParam(required = false) String legalName, @RequestParam(required = false) String legalIDCard,
			@RequestParam(required = false) String companyAddr, @RequestParam(required = false) String companyType,
			@RequestParam(required = false) String companyScale, @RequestParam(required = false) String invoiceKind,
			@RequestParam(required = false) String serviceIndustry, @RequestParam(required = false) String businessKind,
			@RequestParam(required = false) String companyContact, @RequestParam(required = false) String phone,
			@RequestParam(required = false) String basicSituation,
			HttpServletRequest request,	HttpServletResponse response) {
		String userId=(String)request.getSession().getAttribute(Constant.USER_ID);
		
				String path = null;
				String fileName = null;
				if (file.getSize() != 0)// 有上传文件的情况
				{
					path = UploadPath.getCompanyCertificatePath();// 不同的地方取不同的上传路径
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

		boolean flag=companycertificateService.validateCompany(userId,companyName,divisionCode,legalName,
				legalIDCard,companyAddr,companyType,companyScale,invoiceKind,serviceIndustry,
				businessKind,companyContact,phone,basicSituation,path,fileName);
		if(flag==true){
			try {
				response.sendRedirect("accountinfo");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else mv.setViewName("mgmt_a_info");
		return mv;
	}
	
	@RequestMapping("detailcompanycertificate")
	/**
	 * 查看公司验证信息
	 */
	
	public ModelAndView detailCompanyCertificate(
			@RequestParam int flag,
			HttpServletRequest request, HttpServletResponse response) {

		String companyId = (String) request.getSession().getAttribute(Constant.USER_ID);
		Companycertificate companycertificate = companycertificateService.getCompanycertificate(companyId);
		mv.addObject("detailCompanyCertificate", companycertificate);
		if (flag == 0) {// 对应公司验证查看详情
			mv.setViewName("mgmt_a_info6a");
		} else if (flag == 1)// 对应公司验证更新
		{
			mv.setViewName("mgmt_a_info6");
		} 
		return mv;
	}
	
	@RequestMapping(value = "downloadcompanycertificatematerial", method = RequestMethod.GET)
	/**
	 * 下载认证公司的相关材料
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView downloadCompanyCertificateMaterial(String id,
			HttpServletRequest request, HttpServletResponse response) {
			Companycertificate companycertificate = companycertificateService.getCompanycertificate(id);
			String file = companycertificate.getRelatedMaterial();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	
	@RequestMapping("companycertificateupdate")
	/**
	 * 验证公司
	 */
	public ModelAndView companycertificateUpdate(
			@RequestParam(required = false) MultipartFile file,
			@RequestParam(required = false) String companyName, @RequestParam(required = false) String divisionCode,
			@RequestParam(required = false) String legalName, @RequestParam(required = false) String legalIDCard,
			@RequestParam(required = false) String companyAddr, @RequestParam(required = false) String companyType,
			@RequestParam(required = false) String companyScale, @RequestParam(required = false) String invoiceKind,
			@RequestParam(required = false) String serviceIndustry, @RequestParam(required = false) String businessKind,
			@RequestParam(required = false) String companyContact, @RequestParam(required = false) String phone,
			@RequestParam(required = false) String basicSituation,
			HttpServletRequest request,	HttpServletResponse response) {
		String userId=(String)request.getSession().getAttribute(Constant.USER_ID);
		
		// ////////////////////////////////////////////
				String path = null;
				String fileName = null;
				if (file.getSize() != 0)// 有上传文件的情况
				{
					path = UploadPath.getCompanyCertificatePath();// 不同的地方取不同的上传路径
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
		
		boolean flag=companycertificateService.companycertificateUpdate(userId,companyName,divisionCode,legalName,
				legalIDCard,companyAddr,companyType,companyScale,invoiceKind,serviceIndustry,
				businessKind,companyContact,phone,basicSituation,path,fileName);
		if(flag==true){
			try {
				response.sendRedirect("accountinfo");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else mv.setViewName("mgmt_a_info");
		return mv;
	}
}
