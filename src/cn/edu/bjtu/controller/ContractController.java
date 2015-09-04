package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.ContractService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Contract;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
	private Logger logger=Logger.getLogger(ContractController.class);

	ModelAndView mv = new ModelAndView();

	/**
	 * 获取需求方合同页面
	 * @return
	 */
	@RequestMapping("contract")
	public String getUserContractPage(){
		return "mgmt_r_contact_s";
	}
	
	/**
	 * 获取承运方合同页面 
	 * @return
	 */
	@RequestMapping("contract2")
	public String getCarrierContractPage(){
		return "mgmt_r_contact_r";
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
		String carrierId=(String)request.getSession().getAttribute(Constant.USER_ID);
		//String carrierId = "C-0002";
		Contract contract = contractService.getContractInfo(contractId);
		mv.addObject("contract", contract);
		Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
		mv.addObject("carrierInfo", carrierInfo);
		//需求方
		if (flag == 1)// 详情
		{
			mv.setViewName("mgmt_r_contact_s4");
		} else if (flag == 2)// 终止
		{
			mv.setViewName("mgmt_r_contact_s3");
		}
		 else if (flag == 3)// 终止后查看，带有终止原因
		{
			mv.setViewName("mgmt_r_contact_s4a");
		}
		//承运方
		 else if (flag == 11)// 确认
		{
			mv.setViewName("mgmt_r_contact_r2");
		} else if (flag == 22)// 终止
		{
			mv.setViewName("mgmt_r_contact_r3");
		}
		 else if (flag == 33)// 终止后查看，带有终止原因
		{
			mv.setViewName("mgmt_r_contact_r4a");
		}
		 else if (flag == 44)// 普通查看详情
		{
			mv.setViewName("mgmt_r_contact_r4");
		}
		return mv;

	}

	/**
	 * 新增合同
	 * @param contract
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "insertContract", method = RequestMethod.POST)
	public String insertNewContract(Contract contract,MultipartFile file,
			HttpServletRequest request) {
		contractService.insertNewContract(contract,request,file);
		return "redirect:contract";
	}
	
	
	/**
	 * 终止合同
	 * @param contractId
	 * @param reason
	 * @param response
	 * @return
	 */
	@RequestMapping(value="shutdownContract",method = RequestMethod.POST)
	public String shutdownContract(@RequestParam String contractId,
			@RequestParam int rorsflag,//标识是承运方还是需求方
			@RequestParam String reason,HttpServletResponse response)
	{
		
		boolean flag=false;
		flag=contractService.shutdownContract(contractId, reason);
		if(flag==true&&rorsflag==1){
			return "redirect:contract";
		}else {
			return "redirect:contract2";
		}
			
	}
	

	/**
	 * 删除
	 */
	@RequestMapping(value = "downloadcontactrelated", method = RequestMethod.GET)
	public ModelAndView downloadContactRelated(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		Contract contract = contractService.getContractInfo(id);
		String file = contract.getRelatedMaterial();
		DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	
	
	@RequestMapping(value = "confirmcontract", method = RequestMethod.POST)
	public String confirmContract(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		boolean flag = contractService.changeStatus(id);
		return "redirect:contract2";
	}
	
	/**
	 * 获取当前用户的合同id
	 * @param currentUserId
	 * @return
	 */
	@RequestMapping("getUserContractIdAjax")
	@ResponseBody
	public String getUserContractId(HttpServletResponse response,HttpSession session){
		String userId=(String)session.getAttribute(Constant.USER_ID);
		List<Contract> contractList=contractService.getContractByClientId(userId);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<contractList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(contractList.get(i));
			jsonArray.add(jsonObject);
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		return jsonArray.toString();
		
	}
	
	/**
	 * 我的信息-合同信息
	 * @Title: getUserContract 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午5:40:28
	 */
	@RequestMapping(value="getUserContractAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getUserContract(HttpSession session,PageUtil pageUtil,Contract contract){
		JSONArray jsonArray=contractService.getUserContract(session,pageUtil,contract);
		return jsonArray.toString();
	}
	
	/**
	 * 我的信息-合同信息-总记录数
	 * @Title: getUserContractTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午5:42:46
	 */
	@RequestMapping("getUserContractTotalRowsAjax")
	@ResponseBody
	public Integer getUserContractTotalRows(HttpSession session,Contract contract){
		return contractService.getUserContractTotalRows(session,contract);
	}
	
	
	
}
