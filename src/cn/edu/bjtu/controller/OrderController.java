package cn.edu.bjtu.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

/**
 * 
 * @author RussWest0
 *
 */
@Controller
public class OrderController {

	@Resource
	OrderService orderService;

	@Resource(name = "carServiceImpl")
	CarService carService;

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/sendorderinfo")
	/**
	 * 我提交的订单信息
	 * @return
	 */
	public ModelAndView getAllSendOrderInfo(HttpServletRequest request,
			HttpServletResponse response) {
		// 从session获取用户Id
		// System.out.println("进入收到订单控制器");
		String userId = (String) request.getSession().getAttribute("userId");
		// System.out.println("userId+"+userId);
		List orderList = orderService.getAllSendOrderInfo(userId);
		System.out.println("orderList+" + orderList);
		mv.addObject("orderList", orderList);
		mv.setViewName("mgmt_d_order_s");

		return mv;
	}

	@RequestMapping("/recieveorderinfo")
	/**
	 * 我收到的订单信息
	 * @return
	 */
	public ModelAndView getAllRecieveOrderInfo(HttpServletRequest request,
			HttpServletResponse response) {
		// 从session获取用户Id
		// System.out.println("进入收到订单控制器");
		String userId = (String) request.getSession().getAttribute("userId");
		// System.out.println("userId+" + userId);
		List orderList = orderService.getAllRecieveOrderInfo(userId);
		// System.out.println("orderList+"+orderList);
		mv.addObject("receiveOrderList", orderList);
		// mv.addObject("name", "iver99");
		mv.setViewName("mgmt_d_order_r");

		return mv;
	}

	@RequestMapping("/sendorderdetail")
	/**
	 * 提交订单详情
	 * @param id
	 * @return
	 */
	public ModelAndView getSendOrderDetail(@RequestParam String id) {
		// System.out.println(id);// ///
		OrderCarrierView sendorderdetail = orderService.getSendOrderDetail(id);
		mv.addObject("sendorderdetail", sendorderdetail);

		mv.setViewName("mgmt_d_order_s4");

		return mv;
	}

	@RequestMapping("/recieveorderdetail")
	/**
	 * 收到订单详情
	 * @param id
	 * @return
	 */
	public ModelAndView getAllRecieveOrderDetail(@RequestParam String id) {
		System.out.println(id);
		Orderform recieveorderdetail = orderService.getRecieveOrderDetail(id);
		mv.addObject("recieveorderdetail", recieveorderdetail);
		mv.setViewName("mgmt_d_order_r3");

		return mv;
	}

	/*@RequestMapping(value = "insertOrder", method = RequestMethod.POST)
	public ModelAndView insertOrder(@RequestParam String goodsName,
			@RequestParam String clientCompany,
			@RequestParam String contactWaybill,
			@RequestParam String carrierAccount,
			@RequestParam String deliveryAddr,
			@RequestParam String recieverAddr,
			@RequestParam String deliveryName,
			@RequestParam String deliveryPhone,
			@RequestParam String recieverName,
			@RequestParam String recieverPhone,
			@RequestParam float goodsWeight, @RequestParam float goodsVolume,
			@RequestParam float expectedPrice, @RequestParam float insurance,
			@RequestParam float freight, @RequestParam String contractNum,
			@RequestParam String remarks) {

		System.out.println("进入订单控制器");
		boolean flag = orderService.insertOrder(goodsName, contactWaybill,
				deliveryAddr, recieverAddr, deliveryName, deliveryPhone,
				recieverName, recieverPhone, goodsWeight, goodsVolume,
				expectedPrice, insurance, freight, contractNum, remarks);
		if (flag == true)
			mv.setViewName("mgmt_r_line");
		else
			mv.setViewName("fail");
		// mv.setViewName("mgmt_r_line");
		return mv;
	}*/

	@RequestMapping("getUpdateOrderForm")
	/**
	 * 获取更新订单表单
	 * @param orderId
	 * @return
	 */
	public ModelAndView getUpdateOrderForm(String orderId) {

		OrderCarrierView orderCarrierView = orderService
				.getOrderByOrderId(orderId);// 从视图查

		mv.addObject("orderinfo", orderCarrierView);
		mv.setViewName("mgmt_d_order_s3");
		return mv;
	}

	@RequestMapping("acceptOrderForm")
	public ModelAndView getAcceptOrderForm(String orderid,
			HttpServletRequest request, HttpServletResponse response) {

		// 需要查出公司司机列表
		String carrierId = (String) request.getSession().getAttribute("userId");

		// 需要获取车牌号和司机名
		// System.out.println("获取接收表单-orderid+"+orderid);
		mv.addObject("orderId", orderid);

		mv.setViewName("mgmt_d_order_r2");
		return mv;
	}

	@RequestMapping("acceptOrder")
	/**
	 * 受理操作
	 * @param orderid
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView acceptOrder(String orderid, HttpServletRequest request,
			HttpServletResponse response) {

		// 需要更新订单的司机列表，并且修改订单状态为已受理(待收货)
		// 需要重定向,用来更新页面
		System.out.println("接收订单+orderId+" + orderid);
		System.out.println("接收订单-orderId+" + orderid);
		boolean flag = orderService.acceptOrder(orderid);
		try {
			if (flag == true)
				response.sendRedirect("recieveorderinfo");
			else
				System.out.println("接收订单失败");// 应记录日志
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// 此处应记录日志
			e.printStackTrace();

		}
		// mv.setViewName("mgmt_d_order_r");
		return mv;
	}

	@RequestMapping("getSignBillForm")
	public ModelAndView getSignBillForm(String orderid) {
		// 上传图片，添加实际运费，修改订单状态为待确认
		// 需要再页面上显示合同规定运费和预期运费
		// 上传图片未实现
		float expectedMoney = orderService.getExpectedMoney(orderid);

		System.out.println("expectedPrice+" + expectedMoney);
		// System.out.println("签单上传+orderid+" + orderid);
		mv.addObject("expectedPrice", expectedMoney);
		mv.addObject("orderId", orderid);
		mv.setViewName("mgmt_d_order_r6");
		return mv;
	}

	@RequestMapping("signBill")
	public ModelAndView SignBill(String orderid, float actualPrice,
			String explainReason, HttpServletRequest request,
			HttpServletResponse response) {
		// System.out.println("actualPrice+"+actualPrice);
		// System.out.println("explainReason+"+explainReason);
		boolean flag = orderService.signBill(orderid, actualPrice,
				explainReason);
		try {
			if (flag == true)
				response.sendRedirect("recieveorderinfo");
			else
				System.out.println("签单上传失败");// logging...
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	/*
	 * @RequestMapping("receivecargoform")
	 *//**
	 * 获取收货表单
	 * 
	 * @param orderid
	 * @return
	 */
	/*
	 * public ModelAndView getReceiveCargoForm(String orderid) {
	 * 
	 * // 需要更新订单状态为已收货(评价状态) mv.setViewName("mgmt_d_order_s5"); return mv; }
	 */
	@RequestMapping("getConfirmForm")
	/**
	 * 获取确认收货表单
	 * @param orderid
	 * @return
	 */
	public ModelAndView getConfirmForm(String orderid) {
		// 跳到确认收货页面
		// 需要规定费用，实际费用，说明
		Orderform order = orderService.getOrderInfo(orderid);
		float expectedPrice = order.getExpectedPrice();
		float actualPrice = order.getActualPrice();
		String explianReason = order.getExplainReason();
		mv.addObject("orderId", orderid);
		mv.addObject("expectedPrice", expectedPrice);
		mv.addObject("actualPrice", actualPrice);
		mv.addObject("explainReason", explianReason);
		mv.setViewName("mgmt_d_order_s5");
		return mv;
	}

	@RequestMapping("confirm")
	public ModelAndView confirm(String orderid, HttpServletRequest request,
			HttpServletResponse response) {
		// 修改订单为待评价
		boolean flag = orderService.confirmCargo(orderid);
		mv.addObject("orderId", orderid);
		if (flag == true)
			try {
				response.sendRedirect("sendorderinfo");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// logging
			}
		else
			System.out.println("确认收货失败");// logging

		return mv;
	}

	@RequestMapping("getCommentForm")
	/**
	 * 获取评价页面
	 * @param orderid
	 * @return
	 */
	public ModelAndView getCommentForm(String orderid)

	{
		
		mv.addObject("orderId", orderid);
		mv.setViewName("mgmt_d_order_s8");
		return mv;
	}
	@RequestMapping("comment")
	public ModelAndView comment(String orderid, int serviceAttitude,
			int transportEfficiency, int cargoSafety, int totalMoney,
			HttpServletRequest request, HttpServletResponse response) {
		// 修改订单状态为已完成
		// 存储评价内容
		//评价页面错误
		System.out.println("service attitude+"+serviceAttitude);
		System.out.println("cargoSafety+"+cargoSafety);
		
		
		return mv;
	}
}
