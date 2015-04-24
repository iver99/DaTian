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

import cn.edu.bjtu.service.GoodsInfoService;
import cn.edu.bjtu.vo.GoodsClientView;

@Controller
public class GoodsInfoController {

	@Resource
	GoodsInfoService goodsInfoService;

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/goodsform")
	/**
	 * 资源栏货物
	 * @param flag
	 * @param request
	 * @return
	 */
	public ModelAndView getAllGoodsInfo(@RequestParam int flag,
			HttpServletRequest request) {
		int Display = 10;// 默认的每页大小
		int PageNow = 1;// 默认的当前页面

		if (flag == 0) {
			List goodsInfoList = goodsInfoService.getAllGoodsInfo(Display,
					PageNow);
			int count = goodsInfoService.getTotalRows("All", "All", "All");// 获取总记录数,不需要where子句，所以参数都是All
			System.out.println("count+" + count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);

			mv.addObject("goodsformInfo", goodsInfoList);
			mv.setViewName("resource_list6");// 点击资源栏城市配送显示所有信息
		}
		
		return mv;
	}

	@RequestMapping("/goodsdetail")
	/**
	 * 资源栏货物详情
	 * @param id
	 * @return
	 */
	public ModelAndView getAllGoodsDetail(@RequestParam String id) {
		System.out.println(id);
		GoodsClientView goodsformInfo = goodsInfoService.getAllGoodsDetail(id);
		//System.out.println(goodsformInfo);
		mv.addObject("goodsformInfo", goodsformInfo);
		mv.setViewName("resource_detail6");

		return mv;
	}

	@RequestMapping("goodsformselected")
	/**
	 *  * 获取满足条件的货物
	 * @param startPlace
	 * @param endPlace
	 * @param transportType
	 * @param Display
	 * @param PageNow
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getSelectedGoodsInfo(@RequestParam String startPlace,
			@RequestParam String endPlace, @RequestParam String transportType,
			@RequestParam int Display, @RequestParam int PageNow,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println("进入goodsInfo控制器");
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		List goodsInfoList = goodsInfoService.getSelectedGoodsInfo(startPlace,
				endPlace, transportType, Display, PageNow);
		int count = goodsInfoService.getTotalRows(startPlace, endPlace,
				transportType);// 获取总记录数

		int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
		// System.out.println("总记录数+"+count);
		// System.out.println("页数+"+pageNum);
		mv.addObject("goodsformInfo", goodsInfoList);
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pageNow", PageNow);
		mv.setViewName("resource_list6");

		return mv;
	}

	@RequestMapping(value = "insertGoods", method = RequestMethod.POST)
	public ModelAndView insertGoods(@RequestParam String name,
			@RequestParam String type, @RequestParam float weight,
			@RequestParam String transportType,
			@RequestParam String transportReq, @RequestParam String startPlace,
			@RequestParam String endPlace, @RequestParam String damageReq,
			@RequestParam String vipservice, @RequestParam String service,
			@RequestParam String oriented, @RequestParam String user,
			@RequestParam String limitDate, @RequestParam String invoice,
			@RequestParam String relatedMaterial, @RequestParam String remarks) {
		// System.out.println("进入货物控制器");
		boolean flag = goodsInfoService.insertGoods(name, type, weight,
				transportType, transportReq, startPlace, endPlace, damageReq,
				vipservice, oriented, limitDate, invoice, relatedMaterial,
				remarks);
		if (flag == true)
			mv.setViewName("mgmt_r_line");
		else
			mv.setViewName("fail");
		// mv.setViewName("mgmt_r_line");
		return mv;
	}
	@RequestMapping("getallresponse")
	/**
	 * 获取所有反馈
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getAllResponse(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("进入反馈控制器");
		String userId=(String)request.getSession().getAttribute("userId");
		
		List responseList=goodsInfoService.getAllResponse(userId);
		
		mv.addObject("responseList", responseList);
		mv.setViewName("mgmt_d_response");
		return mv;
	}

	@RequestMapping("getresponseform")
	/**
	 * 获取创建反馈表单
	 * @param goodsid
	 * @return
	 */
	public ModelAndView getResponseForm(String goodsid) {
		mv.addObject("goodsId", goodsid);

		mv.setViewName("mgmt_d_response2");

		return mv;
	}

	@RequestMapping("commitresponse")
	/**
	 * 创建反馈
	 * @param goodsid
	 * @return
	 */
	public ModelAndView commitResponse(String goodsid, String remarks,
			HttpServletRequest request, HttpServletResponse response) {

		String carrierId = (String) request.getSession().getAttribute("userId");
		//System.out.println("进入创建反馈 控制器+goodsid+" + goodsid);

		boolean flag = goodsInfoService
				.commitResponse(goodsid, remarks, carrierId);
		if (flag == true)
		{
			try {
				response.sendRedirect("getallresponse");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return mv;
	}

	@RequestMapping("goodsinfo")
	public ModelAndView getGoodsInfo(HttpServletRequest request,HttpServletResponse response)
	{
		String clientId=(String)request.getSession().getAttribute("userId");
		List goodsList=goodsInfoService.getUserGoodsInfo(clientId);
		mv.addObject("goodsList", goodsList);
		mv.setViewName("mgmt_r_cargo");
		return mv;
	}
}
