package cn.edu.bjtu.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.AddressService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Address;

import com.alibaba.fastjson.JSONArray;


@Controller
public class AddressController {
	
	ModelAndView mv=new ModelAndView();
	
	@Autowired
	AddressService addressService;
	@Resource
	Address address;
	/**
	 * 跳转到常用发货地址
	 * @return
	 */
	@RequestMapping("getaddress")
	public String getAddress(){
		return "mgmt_a_address";
	}
	
	/**
	 * 跳转道常用收货地址
	 * @return
	 */
	@RequestMapping("getRecieveAddress")
	public String getRecieveAddress(){
		return "mgmt_a_address1";
	}
	
	
	@RequestMapping("deleteaddress")
	/**
	 * 删除
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView deleteAddress(
			@RequestParam String id,
			HttpServletRequest request,HttpServletResponse response){
		
		boolean flag = addressService.deleteAddress(id);
		try {
			if (flag == true)
				response.sendRedirect("getaddress");
			else
				System.out.println("删除失败");// 应记录日志
		} catch (IOException e) {
			// 
			// 此处应记录日志
			e.printStackTrace();

		}
		
		return mv;
	}
	
	@RequestMapping("addaddress")
	/**
	 * 跳转到新增界面
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addAddress(
			HttpServletRequest request,HttpServletResponse response){
		
		String userId=(String)request.getSession().getAttribute(Constant.USER_ID);
		mv.setViewName("mgmt_a_address2");
		return mv;
	}
	
	/**
	 * 新增常用地址
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("insertaddress")
	public String insertAddress(HttpSession session,Address address){
		
		//String clientId=(String)request.getSession().getAttribute(Constant.USER_ID);
		boolean flag = addressService.insertAddress(session,address);

		return "redirect:getaddress";
	}
	
		/**
		 * 跳转到更新界面
		 * @param id
		 * @return
		 */
	@RequestMapping("updateaddress")
	 	public ModelAndView updateAddress(
	 			@RequestParam String id,
				HttpServletRequest request,HttpServletResponse response){
			
			String userId=(String)request.getSession().getAttribute(Constant.USER_ID);
			System.out.println("已经进入address控制器");

			Address address = addressService.getAddressDetail(id);
			System.out.println("address+" + address);
			mv.addObject("address", address);
			mv.setViewName("mgmt_a_address3");
			return mv;
	 }
	
		/**
		 * 更新常用地址
		 * @param session
		 * @param address
		 * @return
		 */
		@RequestMapping("doupdateaddress")
		public String updateAddress(HttpSession session,Address address){
				
			addressService.updateAddress(session,address);

			return "redirect:getaddress";
		}
	 
	 /**
	  * 添加常用地址
	  * @param session
	  * @param address
	  */
	 @RequestMapping("addAddressAjax")
	 @ResponseBody
	 @Deprecated
	 public void addAddressAjax(HttpSession session,Address address){
		 addressService.addUserAddress(session,address);
		 return ;
	 }
	 /**
	  * 下订单时获取用户常用地址列表
	  * @param session
	  * @param address
	  */
	 @Deprecated
	 @RequestMapping(value="getUserFrequentAddressAjax",produces="text/html;charset=UTF-8")
	 @ResponseBody
	 public String getUserFrequentAddress(HttpSession session){
		 
		 JSONArray jsonArray=addressService.getUserFrequentAddress(session);
		 return jsonArray.toString();
		 
	 }
	 
	/**
	 * 获取常用发货地址
	 * 
	 * @Title: getSendAddress
	 * @Description: TODO
	 * @param: @param session
	 * @param: @param pageUtil
	 * @param: @return
	 * @return: String
	 * @throws: 异常
	 * @author: chendonghao
	 * @date: 2015年7月29日 上午11:24:19
	 */
	@RequestMapping(value = "getAddressAjax", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSendAddress(HttpSession session, PageUtil pageUtil,
			Address address) {
		return addressService.getAddress(session, pageUtil, address);
	}

	/**
	 * 常用发货地址-总记录数
	 * 
	 * @Title: getSendAddressTotalRows
	 * @Description: TODO
	 * @param: @param session
	 * @param: @return
	 * @return: Integer
	 * @throws: 异常
	 * @author: chendonghao
	 * @date: 2015年7月29日 上午11:30:34
	 */
	@RequestMapping("getAddressTotalRowsAjax")
	@ResponseBody
	public Integer getSendAddressTotalRows(HttpSession session, Address address) {
		return addressService.getAddressTotalRows(session, address);
	}

}
