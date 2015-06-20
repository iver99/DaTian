package cn.edu.bjtu.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.SettlementRecordService;
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
	@Autowired
	SettlementRecordService settlementRecordService;
	
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
		List orderList=settlementService.getUserSettlementList(userId);
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
	public String createSingleStatement(HttpSession session,@RequestParam String orderNum,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
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
	    //之后需要修改结算状态为已结算，记录当前生成人
	    settlementRecordService.finishSettlement(orderNum,session);
	    return "redirect:mgmt_d_settle_s";
	    
	}
	
	@RequestMapping("/createMultipleStatement")
	/**
	 * 生成批量对账单
	 * @param request
	 * @param response
	 * @return
	 */
	public String createMultipleStatement(HttpSession session,@RequestParam String checklist,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String[] statement=checklist.split(",");
		List<SettlementCarrierView> multipleStatement = new ArrayList<SettlementCarrierView>();
		for(int i=0;i<statement.length;i++)
		{
			List orderList=settlementService.getOrderStatement(statement[i]);
			SettlementCarrierView settlement = (SettlementCarrierView) orderList.get(0);
			multipleStatement.add(settlement);
			//之后需要修改结算状态为已结算，记录当前生成人
		    settlementRecordService.finishSettlement(settlement.getOrderNum(),session);
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
	    //settlementRecordService.finishMultipleSettlement(,session);
	    return "redirect:mgmt_d_settle_s";
	}
	
	/**
	 * 查找合同
	 */
	@RequestMapping(value="findsettlement",method = RequestMethod.POST)
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
		mv.addObject("orderList", settlementList);
		
		mv.setViewName("mgmt_d_settle_s");
		return mv;
		
	}
	
	/**
	 * 返回我的信息-本月已结算金额
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserSettlementInfoAjax")
	public String getUserSettlementInfoAjax(HttpSession session){
		
		
		
	}
	
}
