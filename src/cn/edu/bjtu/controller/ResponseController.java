
package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.GoodsInfoService;
import cn.edu.bjtu.service.ResponseService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Response;

import com.alibaba.fastjson.JSONArray;

@Controller
/**
 * 反馈相关控制器
 * @author RussWest0
 * @date   2015年6月2日 上午11:04:13
 */
public class ResponseController {
	
	@Autowired
	ResponseService responseService;
	@Autowired
	GoodsInfoService goodsInfoService;
	
	@Autowired
	CompanyService companyService;
	
	ModelAndView mv=new ModelAndView();
	
	/**
	 * 我的货物-查看反馈操作(未确认前)
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("viewResponseDetail")
	public ModelAndView viewResponseDetail(String goodsid){
		List<Response> respList=responseService.getResponseListByGoodsId(goodsid);
		
		mv.addObject("respList", respList);
		mv.setViewName("mgmt_r_cargo5a");
		return mv;
		
	}
	
	/**
	 * 我的货物-查看反馈操作(确认后)
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("viewResponseDetailAfter")
	public ModelAndView viewResponseDetail2(String goodsid){
		List<Response> respList=responseService.getResponseListByGoodsId(goodsid);
		
		mv.addObject("respList", respList);
		mv.setViewName("mgmt_r_cargo5b");
		return mv;
		
	}
	
	/**
	 * 我的货物-查看反馈（已确认）-查看
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("viewResponseDetailInfo")
	public ModelAndView viewResponseDetailInfo(String responseid){
		
		Response response=responseService.getResponseById(responseid);
		
		mv.addObject("response", response);
		mv.setViewName("mgmt_r_cargo6b");
		
		return mv;
		
		
	}
	
	/**
	 * 我的反馈-查看操作
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("viewResponseInfo")
	public ModelAndView viewResponse(String responseid){
		
		Response response=responseService.getResponseById(responseid);
		
		mv.addObject("response", response);
		mv.setViewName("mgmt_d_response3");
		
		return mv;
		
	}
	/**
	 * 获取反馈确认表单 
	 * @param goodsid
	 * @param carrrierid
	 * @return
	 */
	@RequestMapping("getConfirmResponseForm")
	public ModelAndView getConfirmResponseForm(String goodsid,String carrrierid,String responseid){
		//需要准备该条反馈的文件和说明
		Response response=responseService.getResponseById(responseid);
		
		mv.addObject("responseinfo", response);
		
		mv.setViewName("mgmt_r_cargo6a");
		return mv;
	}
	
	
	/**
	 * 确认反馈操作，跳转到订单页面
	 * @param responseid
	 * @param carrierid
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("confirmResponse")
	public ModelAndView confirmResponse(String responseid,String carrierid,String goodsid){
		
		Carrierinfo carrierinfo=companyService.getCompanyById(carrierid);
		//页面上需要承运方id
		mv.addObject("carrierInfo", carrierinfo);
		mv.addObject("responseId", responseid);
		mv.addObject("carrierId", carrierid);
		mv.addObject("goodsId", goodsid);
		
		mv.setViewName("mgmt_d_order_s2a");
		return mv;
	}
	
	/**
	 *  下载反馈文件
	 * @return
	 */
	@RequestMapping("downloadResponseMaterial")
	public ModelAndView downloadResponseFile(String responseid,HttpServletRequest request,HttpServletResponse response){
		
		Response resp=responseService.getResponseById(responseid);
		String fileLocation=resp.getRelatedMaterial();
		DownloadFile.downloadFile(fileLocation, request, response);
		return mv;
	}
	
	/**
	 * 获取所有反馈
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getallresponse")
	public String getAllResponse() {
		return "mgmt_d_response";
	}
	
	/**
	 * 获取用户的所有反馈
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getUserResponseAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserResponse(HttpSession session,PageUtil pageUtil){
		JSONArray jsonArray=responseService.getUserResponse(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	/**
	 * 我的反馈-总条数
	 * @param session
	 * @return
	 */
	@RequestMapping("getUserResponseTotalRowsAjax")
	@ResponseBody
	public Integer getUserResponseTotalRows(HttpSession session){
		return responseService.getUserResponseTotalRows(session);
		
	}

	/**
	 * 获取创建反馈表单
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("getresponseform")
	public ModelAndView getResponseForm(String goodsid) {
		mv.addObject("goodsId", goodsid);

		mv.setViewName("mgmt_d_response2");

		return mv;
	}

	/**
	 * 创建反馈
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("commitresponse")
	public ModelAndView commitResponse(MultipartFile file,String goodsid, String remarks,
			HttpServletRequest request, HttpServletResponse response) {

		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		String path = null;
		String fileName = null;
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getResponsePath();// 不同的地方取不同的上传路径
			fileName = file.getOriginalFilename();
			fileName = carrierId + "_" + fileName;// 文件名
			File targetFile = new File(path, fileName);
			try { // 保存 文件
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		//没有上传文件的情况path 和 filenName默认为null
		boolean flag = goodsInfoService.commitResponse(goodsid, remarks,
				carrierId,path,fileName);
		if (flag == true) {
			try {
				response.sendRedirect("getallresponse");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}

		return mv;
	}
	/*@RequestMapping("downloadMyResponseMaterial")
	public ModelAndView downMyResponseMaterial(String responseid){
		public ModelAndView downloadResponseFile(String responseid,HttpServletRequest request,HttpServletResponse response){
			
			Response resp=responseService.getResponseById(responseid);
			String fileLocation=resp.getRelatedMaterial();
			DownloadFile.downloadFile(fileLocation, request, response);
			return mv;
		
		return mv;
	}*/

}
