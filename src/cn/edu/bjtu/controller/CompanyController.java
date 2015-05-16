package cn.edu.bjtu.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Linetransport;
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
	
	ModelAndView mv=new ModelAndView();
	
	@RequestMapping("/company")
	/**
	 * 返回所有公司信息
	 * @return
	 */
	public ModelAndView getAllCompany()
	{	
		int Display=10;//默认的每页大小
		int PageNow=1;//默认的当前页面
		List companyList = companyService.getAllCompany(Display,PageNow);
		int count = companyService.getTotalRows("All", "All", "All", "All");// 获取总记录数,不需要where子句，所以参数都是All
		System.out.println("count+"+count);
		int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pageNow", PageNow);
		
		mv.addObject("companyList", companyList);
		mv.setViewName("resource_list5");// 点击资源栏城市配送显示所有信息
		return mv;
	}
	
	
	@RequestMapping(value="/companyDetail",method=RequestMethod.GET)
	/**
	 * 返回公司的具体信息
	 * @param id
	 * @return
	 */
	public ModelAndView companyDetail(@RequestParam String id)
	{
		System.out.println("id+"+id);
		Carrierinfo carrierinfo=companyService.getCarrierInfo(id);
		System.out.println("tele+"+carrierinfo.getPhone());//null
		
		//公司相关的干线信息，城市配送信息以及仓库信息
		List linetransportList = companyService.getLinetransportByCarrierId(id);
		List citylineList = companyService.getCitylineByCarrierId(id);
		List warehouseList = companyService.getwarehouseByCarrierId(id);
		
		mv.addObject("carrierinfo", carrierinfo);
		mv.addObject("linetransportList", linetransportList);
		mv.addObject("citylineList", citylineList);
		mv.addObject("warehouseList", warehouseList);
		mv.setViewName("resource_detail5");
		return mv;
	}
	
	@RequestMapping("companyselected")
	/**
	 * 查找符合条件的承运方
	 * @param city
	 * @param resourceRate
	 * @param serviceIndustry
	 * @param creditRate
	 * @param business
	 * @param Display
	 * @param PageNow
	 * @return
	 */
	public ModelAndView getSelectedCompany(@RequestParam String city,
			@RequestParam String resourceRate,
			@RequestParam String serviceIndustry,
			@RequestParam String creditRate,
			@RequestParam String business,
			@RequestParam int Display,
			@RequestParam int PageNow,
			HttpServletRequest request, HttpServletResponse response)
			{
				System.out.println("进入公司筛选控制器");
				try {
					response.setCharacterEncoding("UTF-8");
					request.setCharacterEncoding("UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("已经进入控制器");
				System.out.println("rate+"+creditRate);
				
				List companyList = companyService.getSelectedCompany(
						resourceRate, serviceIndustry, creditRate, business, Display,
						PageNow);
				int count = companyService.getTotalRows(resourceRate, serviceIndustry, creditRate, business);// 获取总记录数

				int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
				//System.out.println("总记录数+"+count);
				//System.out.println("页数+"+pageNum);
				mv.addObject("companyList", companyList);
				mv.addObject("count", count);
				mv.addObject("pageNum", pageNum);
				mv.addObject("pageNow", PageNow);
				mv.setViewName("resource_list5");
				
				return mv;
			}

}
