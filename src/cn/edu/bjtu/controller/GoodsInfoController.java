package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import cn.edu.bjtu.bean.search.CargoSearchBean;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.GoodsInfoService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;

import com.alibaba.fastjson.JSONArray;

@Controller
public class GoodsInfoController {

	@Resource
	GoodsInfoService goodsInfoService;
	@Autowired
	FocusService focusService;
	ModelAndView mv = new ModelAndView();

	/**
	 * 资源栏货物
	 * @param flag
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/goodsform",params="flag=0")
	public String getAllGoodsInfo() {
		return "resource_list6";
	}
	
	/**
	 * 资源栏-货物筛选
	 * @param cargoBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getSelectedCargoAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSelectedCargoAjax(CargoSearchBean cargoBean,PageUtil pageUtil,HttpSession session){
		JSONArray jsonArray = goodsInfoService.getSelectedCargoNew(cargoBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	/**
	 * 返回货物筛选页面总记录数
	 * @param warehouseBean
	 * @return
	 */
	@RequestMapping("getSelectedCargoTotalRowsAjax")
	@ResponseBody
	public Integer getSelectedCargoTotalRowsAjax(CargoSearchBean cargoBean){
		Integer count=goodsInfoService.getSelectedCargoTotalRows(cargoBean);
		return count;
	}
	
	/**
	 * 我的信息-货物信息
	 * @param flag
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/goodsform",params="flag=1")
	public String getMyInfoGoods() {
			return"mgmt_r_cargo";
	}

	@RequestMapping("/goodsdetail")
	/**
	 * 资源栏货物详情
	 * @param id
	 * @return
	 */
	public ModelAndView getAllGoodsDetail(@RequestParam String id) {
		GoodsClientView goodsformInfo = goodsInfoService.getAllGoodsDetail(id);
		mv.addObject("goodsformInfo", goodsformInfo);
		mv.setViewName("resource_detail6");

		return mv;
	}


	@RequestMapping(value = "insertGoods", method = RequestMethod.POST)
	public String insertNewGoods(Goodsform goods,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=goodsInfoService.insertNewGoods(goods,request,file);
		return "redirect:goodsform?flag=1";
	}

	@RequestMapping("mygoodsdetail")
	public ModelAndView myGoodsDetail(@RequestParam String id,
			@RequestParam int flag, HttpServletRequest request,
			HttpServletResponse response) {
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		GoodsClientView goodsformInfo = goodsInfoService.getAllGoodsDetail(id);
		mv.addObject("goodsdetail", goodsformInfo);

		if (flag == 1) {
			mv.setViewName("mgmt_r_cargo4");
		}

		else if (flag == 2) {
			mv.setViewName("mgmt_r_cargo3");
		}

		return mv;
	}

	
	@RequestMapping(value = "updategoods", method = RequestMethod.POST)
	public String updateNewGoods(Goodsform goods,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=goodsInfoService.updateNewGoods(goods,request,file);
		return "redirect:goodsform?flag=1";
	}

	/**
	 * 删除货物
	 * @param id
	 * @return
	 */
	@RequestMapping("deletegoods")
	public String deleteGoods(@RequestParam String id) {

		boolean flag = goodsInfoService.deleteGoods(id);
		return "redirect:goodsform?flag=1";
	}
	
	@RequestMapping(value = "downloadgoodsrelated", method = RequestMethod.GET)
	/**
	 * 删除
	 */
	public ModelAndView downloadGoodsRelated(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		GoodsClientView goodsformInfo = goodsInfoService.getAllGoodsDetail(id);
			String file = goodsformInfo.getRelatedMaterial();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	/**
	 * 我的信息=我的货物
	 * @Title: getUserCargoResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午4:56:10
	 */
	@ResponseBody
	@RequestMapping(value="getUserCargoResourceAjax",produces = "text/html;charset=UTF-8")
	public String getUserCargoResource(HttpSession session,PageUtil pageUtil){
		JSONArray jsonArray=goodsInfoService.getUserCargoResource(session,pageUtil);
		return jsonArray.toString();
	}
	
	/**
	 * 我的信息-货物信息-总记录数
	 * @Title: getUserCargoResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午4:58:56
	 */
	@ResponseBody
	@RequestMapping("getUserCargoResourceTotalRowsAjax")
	public Integer getUserCargoResourceTotalRows(HttpSession session){
		return goodsInfoService.getUserCargoTotalRows(session);
	}

}
