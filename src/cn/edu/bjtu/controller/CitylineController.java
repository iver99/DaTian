package cn.edu.bjtu.controller;

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
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CitylineService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Cityline;

@Controller
/**
 * 城市配送相关
 * @author RussWest0
 *
 */
public class CitylineController {

	@Resource
	CitylineService citylineService;
	@Resource
	CompanyService companyService;

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/cityline")
	/**
	 * 获取所有城市配送线路信息
	 * @param flag
	 * @return
	 */
	public ModelAndView getAllCityline(@RequestParam int flag,
			HttpServletRequest request) {
		int Display=10;//默认的每页大小
		int PageNow=1;//默认的当前页面
		
		if (flag == 0) {
			List citylineList = citylineService.getAllCityline(Display,PageNow);
			int count = citylineService.getTotalRows("All", "All", "All");// 获取总记录数,不需要where子句，所以参数都是All
			System.out.println("count+"+count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);
			
			mv.addObject("citylineList", citylineList);
			mv.setViewName("resource_list2");// 点击资源栏城市配送显示所有信息
		} else if (flag == 1) {
			// 这里用session取id
			String carrierId=(String) request.getSession().getAttribute("userId");
			//String carrierId = "C-0002";// 删除
			List citylineList = citylineService.getCompanyCityline(carrierId);
			mv.addObject("citylineList", citylineList);
			mv.setViewName("mgmt_r_city");// 点击左边城市配送显示所有信息
		}
		return mv;
	}

	@RequestMapping(value = "/citylinedetail", method = RequestMethod.GET)
	/**
	 * 获取城市配送线路详情
	 * @param citylineId
	 * @param carrierId
	 * @param flag
	 * @return
	 */
	public ModelAndView getCitylineInfo(
			@RequestParam("citylineId") String citylineId,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("flag") int flag) {
		System.out.println("citylineid+" + citylineId);
		Cityline citylineInfo = citylineService.getCitylineInfo(citylineId); // 需要重构,返回一条具体的线路不是list

		mv.addObject("citylineInfo", citylineInfo);
		if (flag == 0) {
			Carrierinfo carrierInfo = companyService.getCarrierInfo(carrierId);
			mv.addObject("carrierInfo", carrierInfo);
			mv.setViewName("resource_detail2");// 资源栏点击详情的页面
		} else if (flag == 1)
			mv.setViewName("mgmt_r_city");// 3是有更新和删除操作的页面
		else if (flag == 2)
			mv.setViewName("mgmt_r_city4");// 4是点击详情的页面
		else if (flag == 3)
			mv.setViewName("mgmt_r_city3");// 点击更新 的页面
		return mv;
	}

	@RequestMapping("citylineselected")
	/**
	 * 获取满足条件的城市配送线路
	 * @param cityName
	 * @param VIPService
	 * @param refPrice
	 * @param Display
	 * @param PageNow
	 * @return
	 */
	public ModelAndView getSelectedCityLine(@RequestParam String cityName,
			@RequestParam String VIPService, @RequestParam String refPrice,
			@RequestParam int Display, @RequestParam int PageNow,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println("进入cityline控制器");
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("已经进入控制器");

		List citylineList = citylineService.getSelectedCityline(
				cityName, VIPService, refPrice, Display,
				PageNow);
		int count = citylineService.getTotalRows(cityName, VIPService, refPrice);// 获取总记录数
		//System.out.println("coount+"+count);
		int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
		//System.out.println("总记录数+"+count);
		//System.out.println("页数+"+pageNum);
		mv.addObject("citylineList", citylineList);
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pageNow", PageNow);
		mv.setViewName("resource_list2");

		return mv;
	}

	@RequestMapping(value = "/insertCityLine", method = RequestMethod.POST)
	/**
	 * 新增城市配送线路
	 * @param name
	 * @param cityName
	 * @param VIPService
	 * @param refPrice
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView insertCityLine(@RequestParam String name,
			@RequestParam String cityName, @RequestParam String VIPService,
			@RequestParam float refPrice, @RequestParam String remarks,
			@RequestParam(required = false) String VIPDetail,
			HttpServletRequest request, HttpServletResponse response) {
		String carrierId=(String)request.getSession().getAttribute("userId");
		// carrierId = "C-0002";// 删除
		/*boolean flag = linetransportService.insertLine(lineName, startPlace,
				endPlace, onWayTime, type, refPrice, remarks, carrierId);*/
		System.out.println("vipdetail+"+VIPDetail);
		boolean flag=citylineService.insertCityLine(name, cityName, VIPService, refPrice, remarks, carrierId, VIPDetail);
		if (flag == true) {
			// mv.setViewName("mgmt_r_line");
			try {
				response.sendRedirect("cityline?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("cityline插入后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;
	}
	
	@RequestMapping(value = "/updateCityline", method = RequestMethod.POST)
	/**
	 * * 更新城市配送信息
	 * @param id
	 * @param citylineName
	 * @param cityName
	 * @param VIPService
	 * @param refPrice
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateCityline(
			@RequestParam String id,// GET方式传入，在action中
			@RequestParam String citylineName, @RequestParam String cityName,
			@RequestParam String VIPService,
			@RequestParam String VIPServiceText,// 缺少详细增值服务参数
			@RequestParam float refPrice,
			@RequestParam String remarks, HttpServletRequest request,
			HttpServletResponse response) {

		// 此处获取session里的carrierid，下面方法增加一个参数
		String carrierId=(String)request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除
		boolean flag = citylineService.updateLine(id, citylineName, 
				cityName, VIPService, VIPServiceText, refPrice, remarks, carrierId);
		if (flag == true) {
			
			try {
				response.sendRedirect("cityline?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("cityline更新后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;

	}
	
	@RequestMapping(value = "citydelete", method = RequestMethod.GET)
	/**
	 * 删除
	 */
	public ModelAndView deleteCityline(
			@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("进入删除控制器");
		System.out.println(id);
		// 此处获取session里的carrierid，下面方法增加一个参数
		//String carrierId=(String)request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除
		boolean flag = citylineService.deleteCityline(id);
		if (flag == true) {
			// mv.setViewName("mgmt_r_line");
			try {
				response.sendRedirect("cityline?flag=1");// 重定向，显示最新的结果
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
