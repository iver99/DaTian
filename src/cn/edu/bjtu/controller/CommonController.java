package cn.edu.bjtu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
/**
 * 此控制器主要用于简单的页面跳转，没有其他功能
 * @author RussWest0
 *
 */
public class CommonController {
	
	private Logger logger=Logger.getLogger(CommonController.class);
	@Autowired
	DriverService driverService;
	@Autowired
	CompanyService companyService;
	@Autowired
	LinetransportService linetransportService;
	
	ModelAndView mv = new ModelAndView();

	@RequestMapping("/myinfo")
	public ModelAndView getMyInfo(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
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
			String carrierId=(String)request.getSession().getAttribute(Constant.USER_ID);
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
	
	@RequestMapping("city")
	public String getCity()
	{
		return "city";
	}
	
	@RequestMapping("getSetHeadIconPage")
	public ModelAndView getSetHeadIconPage()
	{
		mv.setViewName("mgmt_a_info5");
		return mv;
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
	
	/**
	 * 下面方法供测试使用
	 * @param msg
	 * @return
	 */
	@RequestMapping("/views/testAjax")
	@ResponseBody
	public String testAjax(String msg){
		logger.info(msg+"--");
		
		List<Linetransport> lineList=linetransportService.getAllLinetransport(3, 1);
		
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<lineList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(lineList.get(i));
			jsonArray.add(jsonObject);
		}
		
		return jsonArray.toString();
	}
	
	@RequestMapping("intro")
	public String introPage(){
		return "intro";
	}
}
