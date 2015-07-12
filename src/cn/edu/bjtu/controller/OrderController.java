package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.bean.page.OrderBean;
import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.CitylineService;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.service.GoodsInfoService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.ResponseService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.JSON;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Cityline;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Driverinfo;
import cn.edu.bjtu.vo.Linetransport;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

import com.alibaba.fastjson.JSONArray;

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

	@Resource
	LinetransportService linetransportService;
	@Resource
	CitylineService citylineService;
	@Autowired
	CompanyService companyService;
	@Autowired
	CommentService commentService;
	@Autowired
	GoodsInfoService goodsInfoService;
	@Autowired
	ResponseService responseService;
	
	@Autowired
	DriverService driverService;
	
	ModelAndView mv = new ModelAndView();

	@RequestMapping("/sendorderinfo")
	/**
	 * 我提交的订单信息
	 * @return
	 */
	@Deprecated
	public ModelAndView getAllSendOrderInfo(HttpSession session) {
		// 从session获取用户Id
		String userId = (String) session.getAttribute(Constant.USER_ID);
		List orderList = orderService.getAllSendOrderInfo(userId);
		mv.addObject("orderList", orderList);
		if (userId == null){
			mv.setViewName("login");
		}
		else{
			mv.setViewName("mgmt_d_order_s");
		}
		return mv;
	}
	
	/**
	 * u获取用户提交的订单
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getUserSendOrderAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserSendOrder(HttpSession session,PageUtil pageUtil,Orderform order){
		JSONArray jsonArray=orderService.getUserSendOrder(session,pageUtil,order);
		
		return jsonArray.toString();
		
	}

	/**
	 * 我提交的订单-总记录以
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUseSendOrderTotalRowsAjax")
	public Integer getUserSendOrderTotalRows(HttpSession session,Orderform order){
		//XXX unused
		return orderService.getUserSendOrderTotalRows(session,order);
	}

	@RequestMapping("/recieveorderinfo")
	/**
	 * 我收到的订单信息
	 * @return
	 */
	@Deprecated
	public ModelAndView getAllRecieveOrderInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List orderList = orderService.getAllRecieveOrderInfo(userId);
		mv.addObject("receiveOrderList", orderList);
		mv.setViewName("mgmt_d_order_r");

		return mv;
	}
	
	/**
	 * 我收到的订单
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getUserRecieveOrderAjax",produces="text/html;charset=UTF-8")
	public String getUserRecieveOrder(HttpSession session,PageUtil pageUtil,Orderform order){
		JSONArray jsonArray=orderService.getUserRecieveOrder(session,pageUtil,order);
		return jsonArray.toString();
	}
	
	/**
	 * 我收到的订单-总记录数
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserRecieveOrderTotalRowsAjax")
	public Integer getUserRevieveOrderTotalRows(HttpSession session,Orderform order){
		return orderService.getUserRecieveOrderTotalRows(session,order);
	}

	@RequestMapping("/sendorderdetail")
	/**
	 * 提交订单详情
	 * @param id
	 * @return
	 */
	public ModelAndView getSendOrderDetail(@RequestParam String id) {
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
		Orderform recieveorderdetail = orderService.getRecieveOrderDetail(id);
		mv.addObject("recieveorderdetail", recieveorderdetail);
		mv.setViewName("mgmt_d_order_r3");

		return mv;
	}

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

	/**
	 * 获取受理表单
	 * @param orderid
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("acceptOrderForm")
	public ModelAndView getAcceptOrderForm(String orderid,
			HttpServletRequest request, HttpServletResponse response) {

		// 需要查出公司司机列表 add by RussWest0 at 2015年6月7日,下午7:56:32 
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List<Driverinfo> driverList=driverService.getAllDriver(carrierId);
		mv.addObject("driverList",driverList);
		// 需要获取车牌号和司机名
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
			HttpServletResponse response,String driver) {

		// 需要更新订单的司机列表，并且修改订单状态为已受理(待收货)
		// 需要重定向,用来更新页面
		//获取到司机，但是未作处理 add by RussWest0 at 2015年6月7日,下午8:03:50 
		boolean flag = orderService.acceptOrder(orderid);
		try {
			if (flag == true)
				response.sendRedirect("recieveorderinfo");
			else
				System.out.println("接收订单失败");// 应记录日志
		} catch (IOException e) {
			// 
			// 此处应记录日志
			e.printStackTrace();

		}
		// mv.setViewName("mgmt_d_order_r");
		return mv;
	}

	@RequestMapping("getSignBillForm")
	/**
	 * 获取签单上传表单
	 * @param orderid
	 * @return
	 */
	public ModelAndView getSignBillForm(String orderid) {
		// 上传图片，添加实际运费，修改订单状态为待确认
		// 需要再页面上显示合同规定运费和预期运费
		// 上传图片未实现
		float expectedMoney = orderService.getExpectedMoney(orderid);
		// System.out.println("签单上传+orderid+" + orderid);
		mv.addObject("expectedPrice", expectedMoney);
		mv.addObject("orderId", orderid);
		mv.setViewName("mgmt_d_order_r6");
		return mv;
	}

	@RequestMapping("signBill")
	public ModelAndView SignBill(@RequestParam(required = false) MultipartFile file,String orderid, float actualPrice,
			String explainReason, HttpServletRequest request,
			HttpServletResponse response) {
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		// ////////////////////////////////////////////////////////////////////////

		String path = null;
		String fileName = null;
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getSignBillPath();// 不同的地方取不同的上传路径
			fileName = file.getOriginalFilename();
			fileName = carrierId + "_" + fileName;// 文件名
			File targetFile = new File(path, fileName);
			try { // 保存 文件
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		//没有上传文件的情况path 和 filenName默认为null
		boolean flag = orderService.signBill(orderid, actualPrice,
				explainReason,path,fileName);
		try {
			if (flag == true)
				response.sendRedirect("recieveorderinfo");
			else
				System.out.println("签单上传失败");// logging...
		} catch (IOException e) {
			// 
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
		Float expectedPrice = order.getExpectedPrice();
		Float actualPrice = order.getActualPrice();
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
				// 
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
	public ModelAndView getCommentForm(String orderid,String ordernum)
	{

		mv.addObject("orderId", orderid);
		mv.addObject("orderNum", ordernum);
		mv.setViewName("mgmt_d_order_s8");
		return mv;
	}

	@RequestMapping("comment")
	public ModelAndView comment(String orderid, int serviceAttitude,
			int transportEfficiency, int cargoSafety, int totalMoney,
			HttpServletRequest request, HttpServletResponse response) {
		// 修改订单状态为已完成
		// 存储评价内容
		// 评价页面错误

		return mv;
	}

	/**
	 * 获取更新订单页面
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "updateOrder")
	public ModelAndView getUpdateOrderPage(@RequestParam("orderid") String orderid,
			HttpServletRequest request) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s3");
		return mv;
	}

	/**
	 *更新订单操作
	 * @return
	 *//*
	@Deprecated
	@RequestMapping(value = "doUpdate", method = RequestMethod.POST)
	public ModelAndView doUpdate(
	@RequestParam String orderid, @RequestParam String clientName,
			@RequestParam String hasCarrierContract,
			@RequestParam String contractId, @RequestParam String goodsName,
			@RequestParam float goodsWeight, @RequestParam float goodsVolume,
			@RequestParam float declaredPrice, @RequestParam float insurance,
			@RequestParam float expectedPrice,
			@RequestParam String deliveryName,
			@RequestParam String recieverName,
			@RequestParam String deliveryPhone,
			@RequestParam String recieverPhone,
			@RequestParam String deliveryAddr,
			@RequestParam String recieverAddr, @RequestParam String remarks,
			HttpServletRequest request, HttpServletResponse response

	) {
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		// 字符串拆解
		
		boolean flag = orderService.updateOrder(orderid, clientName,
				hasCarrierContract, contractId, goodsName, goodsWeight,
				goodsVolume, declaredPrice, insurance, expectedPrice,
				deliveryName, deliveryPhone, deliveryAddr, recieverName,
				recieverPhone, recieverAddr, remarks);
		if (flag == true) {

			try {
				response.sendRedirect("sendorderinfo");// 重定向，显示最新的结果
			} catch (IOException e) {
				// 
				// 此处应该记录日志
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;
	}*/
	/**
	 * 更新订单
	 * @param session
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("doUpdate")
	public String updateOrder(HttpSession session,OrderBean orderBean){
		
		boolean flag=orderService.updateOrder(session, orderBean);
		return "redirect:sendorderinfo";
		
	}

	@RequestMapping(value = "cancelOrder")
	/**
	 * 取消订单
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView cancelOrder(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s9");
		return mv;
	}

	@RequestMapping(value = "getOrderCancelOrder")
	/**
	 * 取消订单
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView getOrderCancelOrder(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r7");
		return mv;
	}

	@RequestMapping(value = "doCancel", method = RequestMethod.POST)
	/**
	 * 取消订单
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView doCancel(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String cancelReason,
			String orderid) {
		boolean flag = orderService.cancel(cancelReason, orderid);
		if (flag == true)
			try {
				response.sendRedirect("sendorderinfo");
			} catch (IOException e) {
				// 
				e.printStackTrace();
				// logging
			}
		else
			System.out.println("取消失败");// logging

		return mv;
	}

	@RequestMapping(value = "getOrderDoCancel", method = RequestMethod.POST)
	/**
	 * 取消订单
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView getOrderDoCancel(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String cancelReason,
			String orderid) {
		boolean flag = orderService.cancel(cancelReason, orderid);
		if (flag == true)
			try {
				response.sendRedirect("recieveorderinfo");
			} catch (IOException e) {
				// 
				e.printStackTrace();
				// logging
			}
		else
			System.out.println("取消失败");// logging

		return mv;
	}

	@RequestMapping(value = "orderDetail")
	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView orderDetail(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s4");
		return mv;
	}

	@RequestMapping(value = "orderDetailWaitToReceive")
	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView orderDetailWaitToReceive(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s6");
		return mv;
	}

	@RequestMapping(value = "orderDetailAlreadyCancel")
	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView orderDetailAlreadyCancel(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s4a");
		return mv;
	}

	@RequestMapping(value = "orderDetailFinish")
	/**
	 * 
	 * 订单完成后查看操作
	 * @param orderid
	 * @return
	 */
	public ModelAndView orderDetailFinish(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		//页面需要评价信息 add by RussWest0 at 2015年6月7日,下午4:04:16 
		Comment comment=commentService.getCommentByOrderId(orderid);
		mv.addObject("comment", comment);
		mv.setViewName("mgmt_d_order_s6a");
		return mv;
	}

	@RequestMapping(value = "orderDetailComment")
	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView orderDetailComment(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s6b");
		return mv;
	}

	@RequestMapping(value = "getOrderDetail")
	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView getOrderDetail(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r3");
		return mv;
	}

	@RequestMapping(value = "getOrderDetailCancel")
	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView getOrderDetailCancel(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r3a");
		return mv;
	}

	@RequestMapping(value = "getOrderDetailWaitToReceive")
	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView getOrderDetailWaitToReceive(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r4");
		return mv;
	}
	
	@RequestMapping(value = "getOrderDetailCargoTrack")
	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView getOrderDetailCargoTrack(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String orderNum, 
			@RequestParam String carNum) {
		List cargoTrackList = orderService.getCargoTrack(orderNum,carNum);
		mv.addObject("cargoTrackList", cargoTrackList);
		mv.setViewName("mgmt_d_order_s7");
		return mv;
	}

	@RequestMapping(value = "getOrderDetailWaitToConfirm")
	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView getOrderDetailWaitToConfirm(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r4a");
		return mv;
	}

	@RequestMapping(value = "getOrderDetailFinish")
	/**
	 * 
	 * 承运方-我收到的订单-已完成-查看
	 * @param orderid
	 * @return
	 */
	public ModelAndView getOrderDetailFinish(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		//页面需要评价信息
		Comment comment=commentService.getCommentByOrderId(orderid);
		mv.addObject("comment",comment);
		mv.setViewName("mgmt_d_order_r4b");
		return mv;
	}

	@RequestMapping("getOrderWaitToConfirmUpdate")
	public ModelAndView getOrderWaitToConfirmUpdate(String orderid) {

		// 需要再页面上显示合同规定运费和预期运费,实际运费,原因
		// 上传图片未实现

		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r6a");
		return mv;
	}

	@RequestMapping("updateSignBill")
	public ModelAndView updateSignBill(String orderid,
			float actualPrice, String explainReason,
			HttpServletRequest request, HttpServletResponse response,@RequestParam(required = false) MultipartFile file) {
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		String path = null;
		String fileName = null;
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getSignBillPath();// 不同的地方取不同的上传路径
			fileName = file.getOriginalFilename();
			fileName = carrierId + "_" + fileName;// 文件名
			File targetFile = new File(path, fileName);
			try { // 保存 文件
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		boolean flag = orderService.DoGetOrderWaitToConfirmUpdate(orderid,
				actualPrice, explainReason,path,fileName);
		try {
			if (flag == true)
				response.sendRedirect("recieveorderinfo");
			else
				System.out.println("待确认失败");// logging...
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("getneworderform")
	/**
	 * 获取创建订单表单
	 * @return
	 */
	public ModelAndView getNewOrderForm(@RequestParam String carrierid,
			@RequestParam(required=false) String resourceId,@RequestParam int flag) {
		// 需要取出承运方公司名称
		//flag和resourceType中标识1为干线，2为城市，3为车辆,4为公司
		int resourceType = 0;
		if(flag==4){//从公司页面提交订单
			Carrierinfo carrierInfo=companyService.getCompanyById(carrierid);
			mv.addObject("carrierInfo", carrierInfo);
			mv.addObject("carrierId", carrierid);
			
			mv.setViewName("mgmt_d_order_s2a");
			return mv;
		}
		if(flag==1){//从干线资源提交订单
			Linetransport linetransportInfo = linetransportService
					.getLinetransportInfo(resourceId);
			resourceType = 1;
			mv.addObject("resourceType", resourceType);
			mv.addObject("linetransportInfo", linetransportInfo);
		}
		if(flag==2){// 从城市配送提交订单
			Cityline citylineInfo = citylineService.getCitylineInfo(resourceId);
			resourceType = 2;
			mv.addObject("resourceType", resourceType);
			mv.addObject("citylineInfo", citylineInfo);
		}
		if(flag==3){//从车辆资源提交订单
			Carinfo carInfo = carService.getCarInfo(resourceId);
			resourceType = 3;
			mv.addObject("resourceType", resourceType);
			mv.addObject("carInfo", carInfo);
		}
		Carrierinfo company=companyService.getCompanyById(carrierid);
		mv.addObject("companyName", company.getCompanyName());
		mv.addObject("carrierId", carrierid);
		mv.setViewName("mgmt_d_order_s2");
		return mv;
	}

	
	
	/**
	 * 新建订单
	 * @param session
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("createneworder")
	public String createNewOrder(HttpSession session,OrderBean orderBean){
		JSON json=new JSON();
		boolean flag=orderService.createOrder(session,orderBean);
		if(flag==true){
			json.setMsg("sucess");
			json.setSuccess(true);
		}else{
			json.setMsg("fail");
			json.setSuccess(false);
		}
		
		return "redirect:sendorderinfo";
	}
	
	/*@Deprecated
	@RequestMapping("createNewOrderFromGoods")
	public ModelAndView createNewOrderFromGoods(String carrierid, String clientName,
			String hasCarrierContract, @RequestParam String deliveryName,
			@RequestParam String recieverName,
			@RequestParam String deliveryPhone,
			@RequestParam String recieverPhone,
			@RequestParam String deliveryAddr,
			@RequestParam String recieverAddr, String remarks,
			String goodsName, float goodsWeight, float goodsVolume,
			float declaredPrice, float expectedPrice, float insurance,
			String contractId, HttpServletRequest request,
			HttpServletResponse response,@RequestParam String isLinkToClientWayBill,
			@RequestParam(required=false) String clientWayBillNum,String resourceName,String resourceType,String companyName,
			String responseid,String goodsid) {
		// 页面有许多字段没有传入
		// clientName参数里有，但是没有使用
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		boolean flag = orderService.createNewOrder(userId, hasCarrierContract,
				deliveryName, recieverName, deliveryPhone, recieverPhone,
				deliveryAddr, recieverAddr, remarks, goodsName, goodsVolume,
				goodsWeight, expectedPrice, declaredPrice, insurance,
				contractId, carrierid,isLinkToClientWayBill,clientWayBillNum,resourceName,resourceType,companyName,clientName);
		if (flag == true) {
			//反馈表修改状态
			responseService.confirmResponse(responseid,carrierid,goodsid);//修改确认反馈信息为已确认，其它反馈信息为已取消状态
			//货物表修改状态
			goodsInfoService.confirmResponse(goodsid);
			
			try {
				response.sendRedirect("sendorderinfo");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}
		mv.setViewName("mgmt_d_order_s");
		return mv;
	}*/
	
	/**
	 * 从我的货物栏下订单
	 * @param session
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("createOrderFromCargo")
	public String createOrderFromCargo(HttpSession session,OrderBean orderBean){
		boolean flag=orderService.createOrder(session,orderBean);
		String goodsId=orderBean.getGoodsId();
		String responseId=orderBean.getResponseId();
		String carrierId=orderBean.getCarrierId();
		if (flag == true) {
			//反馈表修改状态
			responseService.confirmResponse(responseId,carrierId,goodsId);//修改确认反馈信息为已确认，其它反馈信息为已取消状态
			//货物表修改状态
			goodsInfoService.confirmResponse(goodsId);
			return "redirect:sendorderinfo";
		}
		return "redirect:mgmt_d_order_s";
	}

}
