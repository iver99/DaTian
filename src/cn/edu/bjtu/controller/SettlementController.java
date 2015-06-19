package cn.edu.bjtu.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.WriteException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.SettlementService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.ExcelCreator;
import cn.edu.bjtu.vo.SettlementCarrierView;

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
	/**
	 * 获取当前用户的结算
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getMySettlement(HttpServletRequest request,HttpServletResponse response)
	{
		String userId=(String )request.getSession().getAttribute(Constant.USER_ID);
		List orderList=settlementService.getUserOrder(userId);
		mv.addObject("orderList", orderList);
		mv.setViewName("mgmt_d_settle_s");
		return mv;
	}
	
	@RequestMapping("/createSingleStatement")
	/**
	 * 生成单个对账单
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView createSingleStatement(@RequestParam String orderNum,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		//String userId=(String )request.getSession().getAttribute(Constant.USER_ID);
		//System.out.println("生成对账单");
		List orderList=settlementService.getOrderStatement(orderNum);
		SettlementCarrierView settlement = (SettlementCarrierView) orderList.get(0);
		//System.out.println(settlement.getCompanyName());
		String fname = "对账单";
	    OutputStream os = response.getOutputStream();//取得输出流
	    response.reset();//清空输出流 
	    //下面是对中文文件名的处理
	    response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
	    fname = java.net.URLEncoder.encode(fname,"UTF-8");
	    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
	    response.setContentType("application/msexcel");//定义输出类型
	    ExcelCreator ec = new ExcelCreator();
	    ec.createSingleExcel(settlement,os);
		mv.setViewName("mgmt_d_settle_s");
		return mv;
	}
	
	@RequestMapping("/createMultipleStatement")
	/**
	 * 生成批量对账单
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView createMultipleStatement(@RequestParam String checklist,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String[] statement=checklist.split(",");
		System.out.println("批量生成对账单");
		List<SettlementCarrierView> multipleStatement = new ArrayList<SettlementCarrierView>();
		for(int i=0;i<statement.length;i++)
		{
			List orderList=settlementService.getOrderStatement(statement[i]);
			SettlementCarrierView settlement = (SettlementCarrierView) orderList.get(0);
			multipleStatement.add(settlement);
		}
		
		String fname = "批量对账单";
	    OutputStream os = response.getOutputStream();//取得输出流
	    response.reset();//清空输出流 
	    //下面是对中文文件名的处理
	    response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
	    fname = java.net.URLEncoder.encode(fname,"UTF-8");
	    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
	    response.setContentType("application/msexcel");//定义输出类型
	    ExcelCreator ec = new ExcelCreator();
	    ec.createMultipleExcel(multipleStatement,os);
		
		//System.out.println(multipleStatement);
		mv.setViewName("mgmt_d_settle_s");
		return mv;
	}
	
	@RequestMapping(value="findsettlement",method = RequestMethod.POST)
	/**
	 * 查找合同
	 */
	public ModelAndView findSettlement(//@RequestParam String startDate,@RequestParam String endDate,
			@RequestParam String name, HttpServletResponse response, HttpServletRequest request)
	{
		int PageNow=1;//默认的当前页面
		int Display=10;//默认的每页大小
		
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String carrierId=(String)request.getSession().getAttribute(Constant.USER_ID);
		//String carrierId = "C-0002";
		List settlementList = settlementService.getFindSettlement(carrierId, name, Display, PageNow);
		System.out.println("settlementList+" + settlementList);
		mv.addObject("orderList", settlementList);
		
		int count = settlementService.getFindSettlementTotalRows(carrierId, name, Display, PageNow);// 获取查询总记录数
		int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pageNow", PageNow);
		
		mv.setViewName("mgmt_d_settle_s");
		return mv;
		
	}
	
}
