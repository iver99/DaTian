
package cn.edu.bjtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.GoodsInfoService;
import cn.edu.bjtu.service.ResponseService;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.Response;

@Controller
/**
 * 反馈相关控制器
 * @author RussWest0
 * @date   2015年6月2日 上午11:04:13
 */
public class ResponseController {
	
	@Autowired
	ResponseService responseService;
	@Autowired
	GoodsInfoService goodsInfoService;
	
	ModelAndView mv=new ModelAndView();
	
	/**
	 * 查看反馈操作
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("viewResponseDetail")
	public ModelAndView viewResponseDetail(String goodsid){
		List<Response> respList=responseService.getResponseListByGoodsId(goodsid);
		
		mv.addObject("respList", respList);
		mv.setViewName("mgmt_r_cargo5a");
		return mv;
		
	}
	/**
	 * 获取反馈确认表单 
	 * @param goodsid
	 * @param carrrierid
	 * @return
	 */
	@RequestMapping("getConfirmResponseForm")
	public ModelAndView getConfirmResponseForm(String goodsid,String carrrierid,String responseid){
		//需要准备该条反馈的文件和说明
		Response response=responseService.getResponseById(responseid);
		
		mv.addObject("responseinfo", response);
		
		mv.setViewName("mgmt_r_cargo6a");
		return mv;
	}
	
	//跳到提交订单页面之后，未完成...........
	public ModelAndView confirmResponse(String responseid,String carrierid,String goodsid){
		//需要修改此条货物信息的其它反馈为已取消
		
		//反馈表修改状态
		responseService.confirmResponse(responseid,carrierid,goodsid);//修改确认反馈信息为已确认，其它反馈信息为已取消状态
		//货物表修改状态
		goodsInfoService.confirmResponse(goodsid);
		
		
		mv.addObject("", "");
		
		mv.setViewName("mgmt_d_order_s2a");
		return mv;
	}

}
