package cn.edu.bjtu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.util.CheckLogin;
import cn.edu.bjtu.util.IdCreator;

@Controller
/**
 * 此控制器主要用于简单的页面跳转，没有其他功能
 * @author RussWest0
 *
 */
public class CommonController {

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/myinfo")
	public ModelAndView getMyInfo() {
		mv.setViewName("mgmt");
		return mv;
	}

	@RequestMapping("/insert")
	/**
	 * 我的信息-我的资源-所有的新增操作
	 * @param flag
	 * @return
	 */
	public ModelAndView insert(@RequestParam int flag,HttpServletRequest request,HttpServletResponse response) {
		
		//CheckLogin.checkLogin(request, response);//检查登录
		System.out.println("common控制器");
		if (flag == 1)
			mv.setViewName("mgmt_r_line2");// 干线
		else if (flag == 2)
			mv.setViewName("mgmt_r_city2");// 城市配送
		else if (flag == 3)
			mv.setViewName("mgmt_r_car2");// 车辆
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
	/*@RequestMapping("userdetailinfo")
	public String getdetail*/
}
