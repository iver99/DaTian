package cn.edu.bjtu.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.bean.search.CompanySearchBean;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;

import com.alibaba.fastjson.JSONArray;
/**
 * 公司相关控制器
 * @author RussWest0
 *
 */
@Controller
public class CompanyController {
	
	@Resource
	CompanyService companyService;
	@Resource
	HibernateTemplate ht;
	@Autowired
	FocusService focusService;
	ModelAndView mv=new ModelAndView();
	
	/**
	 * 返回所有公司信息
	 * @return
	 */
	@RequestMapping("/company")
	public String getAllCompany(HttpSession session)
	{	
		return "resource_list5";
	}
	/**
	 * 资源栏-公司筛选
	 * @param companyBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getSelectedCompanyAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSelectedCompanyAjax(CompanySearchBean companyBean,PageUtil pageUtil,HttpSession session){
		JSONArray jsonArray = companyService.getSelectedCompanyNew(companyBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	
	/**
	 * 资源栏-公司筛选-总记录条数
	 * @param companyBean
	 * @return
	 */
	@RequestMapping("getSelectedCompanyTotalRowsAjax")
	@ResponseBody
	public Integer getSelectedCompanyTotalRowsAjax(CompanySearchBean companyBean){
		Integer count=companyService.getSelectedCompanyTotalRows(companyBean);
		return count;
	}
	

	/**
	 * 返回公司的具体信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/companyDetail",method=RequestMethod.GET)
	public ModelAndView companyDetail(@RequestParam String id,HttpSession session)
	{
		Carrierinfo carrierinfo=companyService.getCompanyById(id);
		
		//公司相关的干线信息，城市配送信息以及仓库信息
		List linetransportList = companyService.getLinetransportByCarrierId(id);
		List citylineList = companyService.getCitylineByCarrierId(id);
		List warehouseList = companyService.getwarehouseByCarrierId(id);
		String clientId = (String) session.getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"company");
		mv.addObject("carrierinfo", carrierinfo);
		mv.addObject("linetransportList", linetransportList);
		mv.addObject("citylineList", citylineList);
		mv.addObject("focusList", focusList);
		mv.addObject("warehouseList", warehouseList);
		mv.setViewName("resource_detail5");
		return mv;
	}
	
	
	/**
	 * 获取已经通过验证的公司
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getCertificatedCompanyAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCertificatedCompany(HttpSession session){
		JSONArray jsonArray=companyService.getCertificatedCompany(session);
		
		return jsonArray.toString();
	}

}
