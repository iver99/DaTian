package cn.edu.bjtu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.util.IdCreator;

@Controller
/**
 * 此控制器主要用于简单的页面跳转，没有其他功能
 * @author RussWest0
 *
 */
public class CommonController {
	
	/*@Autowired
	CarService carService;*/
	@Autowired
	DriverService driverService;
	@Autowired
	CompanyService companyService;
	ModelAndView mv = new ModelAndView();

	@RequestMapping("/myinfo")
	public ModelAndView getMyInfo(HttpSession session) {
		String userId=(String)session.getAttribute("userId");
		// add by RussWest0 at 2015年5月30日,下午7:09:34 
		if(userId==null){
			mv.setViewName("login");
		}else{
			mv.setViewName("mgmt");
		}
		return mv;
	}

	@RequestMapping("/insert")
	/**
	 * 我的信息-我的资源-所有的新增操作
	 * @param flag
	 * @return
	 */
	public ModelAndView insert(@RequestParam int flag,HttpServletRequest request,HttpServletResponse response) {
		
		if (flag == 1)
			mv.setViewName("mgmt_r_line2");// 干线
		else if (flag == 2)
			mv.setViewName("mgmt_r_city2");// 城市配送
		else if (flag == 3){
			String carrierId=(String)request.getSession().getAttribute("userId");
			List driverList = driverService.getAllDriver(carrierId);
			mv.addObject("driverList", driverList);
			mv.setViewName("mgmt_r_car2");// 车辆
		}
		else if (flag == 4)
			mv.setViewName("mgmt_r_warehouse2");// 仓库
		else if (flag == 5)
			mv.setViewName("mgmt_r_driver2");// 司机
		else if (flag == 6)
			mv.setViewName("mgmt_r_customer2");//客户 
		else if(flag==7)
		{
			String id=IdCreator.createContractId();
			mv.addObject("id", id);
			String clientId=(String)request.getSession().getAttribute("userId");
			List companyList = companyService.getAllCompanyWithoutPage();
			mv.addObject("companyList", companyList);
			mv.setViewName("mgmt_r_contact_s2");//合同
		}
		else if (flag == 8)
			mv.setViewName("mgmt_d_complain2");//投诉 
		else if (flag == 9)
			mv.setViewName("mgmt_r_cargo2");//货物 
		else if (flag == 10)
			mv.setViewName("mgmt_r_car_fleet2");//车队
		return mv;
	}
	
	@RequestMapping("loginForm")
	public String getLoginForm()
	{
		return "login";
	}
	@RequestMapping("registerForm")
	public String getRegisterForm()
	{
		return "register";
	}
	
	@RequestMapping(value="homepage",method=RequestMethod.GET)
	/**
	 * 回到首页
	 * @return
	 */
	public String gotoHomePage()
	{
		return "index";
	}
}
