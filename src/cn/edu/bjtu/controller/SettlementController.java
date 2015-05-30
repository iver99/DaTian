package cn.edu.bjtu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.SettlementService;

/**
 * 我的结算-控制器
 * @author RussWest0
 *
 */
@Controller
public class SettlementController {
	public ModelAndView mv=new ModelAndView();
	@Resource(name="settlementServiceImpl")
	SettlementService settlementService;
	
	@RequestMapping("/mysettlement")
	public ModelAndView getMySettlement(HttpServletRequest request,HttpServletResponse response)
	{
		String userId=(String )request.getSession().getAttribute("userId");
		
		List orderList=settlementService.getUserOrder(userId);
		mv.addObject("orderList", orderList);
		mv.setViewName("mgmt_d_settle_s");
		return mv;
	}
}
