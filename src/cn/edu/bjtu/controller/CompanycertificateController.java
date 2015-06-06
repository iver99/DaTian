package cn.edu.bjtu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
		String userId=(String)request.getSession().getAttribute("userId");
		
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
					// System.out.println("path+fileName+" + path + "-" + fileName);
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
				System.out.println("验证公司出错");//logging
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

		String companyId = (String) request.getSession().getAttribute("userId");
		Companycertificate companycertificate = companycertificateService.getCompanycertificate(companyId);
		mv.addObject("detailCompanyCertificate", companycertificate);
		if (flag == 0) {// 对应公司验证查看详情
			mv.setViewName("mgmt_a_info4a");
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
	public ModelAndView downloadCompanyCertificateMaterial(
			HttpServletRequest request, HttpServletResponse response) {
		
		String companyId=(String)request.getSession().getAttribute("userId");
		Companycertificate companycertificate = companycertificateService.getCompanycertificate(companyId);
		try {
			String file = companycertificate.getRelatedMaterial();
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
		System.out.println("进入验证公司更新控制器");
		String userId=(String)request.getSession().getAttribute("userId");
		
		// ////////////////////////////////////////////
				String path = null;
				String fileName = null;
				// System.out.println("file+"+file+"filename"+file.getOriginalFilename());//不上传文件还是会显示有值
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
					// System.out.println("path+fileName+" + path + "-" + fileName);
				}
				// 没有上传文件的情况path 和 filenName默认为null

				// ////////////////////////////////////////////
		
		boolean flag=companycertificateService.companycertificateUpdate(userId,companyName,divisionCode,legalName,
				legalIDCard,companyAddr,companyType,companyScale,invoiceKind,serviceIndustry,
				businessKind,companyContact,phone,basicSituation,path,fileName);
		System.out.println(flag);
		if(flag==true){
			try {
				System.out.println("redirect之前");
				response.sendRedirect("accountinfo");
				System.out.println("redirect之后");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("验证公司更新出错");//logging
				e.printStackTrace();
			}
		}
		else mv.setViewName("mgmt_a_info");
		return mv;
	}
}
