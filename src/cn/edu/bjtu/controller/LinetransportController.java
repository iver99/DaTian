package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.bean.search.LinetransportSearchBean;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DataModel;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.JSON;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 干线相关控制器
 * @author RussWest0
 *
 */
@Controller
public class LinetransportController {

	private Logger logger = Logger.getLogger(LinetransportController.class);
	
	
	/**
	 * 资源栏所有干线信息
	 * @return
	 */
	@RequestMapping(value="/linetransport",params="flag=0",produces = "text/html;charset=UTF-8")
	public String getAllLinetransport() {
 		
		return "resource_list";
	}
	/**
	 * 我的信息-我的干线资源
	 * @param flag
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/linetransport",params="flag=1")
	public String getAllCompanyLine(@RequestParam int flag,
			PageUtil page, HttpSession session) {
		return "mgmt_r_line";
	}
	/**
	 * 我的信息-干线资源 
	 * @param session
	 * @param lineBean
	 * @param pageUtil
	 * @return
	 */
	@RequestMapping(value="getUserLinetransportResourceAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserLinetransportResource(HttpSession session,PageUtil pageUtil) {
		
		JSONArray jsonArray=linetransportService.getUserLinetransportResource(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	
	
	/**
	 * 我的信息-干线资源总条数
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getUserLinetransportResourceTotalRowsAjax")
	@ResponseBody
	public Integer getUserLinetransportResourceTotalRows(HttpSession session){
		
		return linetransportService.getUserLinetransportResourceTotalRows(session);
	}
	
	@RequestMapping(value = "/linetransportdetail", method = RequestMethod.GET)
	/**
	 * 获取特定的干线信息
	 * @param linetransportid
	 * @return
	 */
	public ModelAndView getLinetransportInfo(
			@RequestParam("linetransportid") String linetransportid,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("flag") int flag, HttpSession session) {
		Linetransport linetransportInfo = linetransportService
				.getLinetransportInfo(linetransportid);// 需要重构，返回一条线路信息
		mv.addObject("linetransportInfo", linetransportInfo);
		String userId = (String) session.getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(userId,"linetransport");
		mv.addObject("focusList", focusList);
		if (flag == 0) {
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			//此处需要获取到干线评价详情 
			// add by RussWest0 at 2015年5月30日,上午9:19:53 
			List<Comment> commentList=commentService.getCompanyComment(carrierId);
			mv.addObject("commentList",commentList);
			mv.addObject("carrierInfo", carrierInfo);
			mv.setViewName("resource_detail1");
			//需要获取资源对应的公司的评价平均数bean
			Comment comment=commentService.getCompanyAverageCommentRate(carrierId);
			mv.addObject("avgComment", comment);
		} else if (flag == 1) {// 详情
			mv.setViewName("mgmt_r_line4");
		} else if (flag == 2) {// 更新
			mv.setViewName("mgmt_r_line3");

		}
		return mv;
	}
	/**
	 * 返回新干线信息
	 * @return
	 */
	@RequestMapping(value="/linetransporttest",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllLinetransportTest(
			LinetransportSearchBean linetransportbean, PageUtil page,
			HttpSession session, HttpServletResponse response,HttpServletRequest request) {
		DataModel dataModel = linetransportService.getSelectedLineNew(
				linetransportbean,page,session);
		/*response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8"); */
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<dataModel.getRows().size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(dataModel.getRows().get(i));
			jsonArray.add(jsonObject);
		}
		//request.setAttribute("count", 66);
		//dataModel.setTotal(66L);
		//return dataModel;
		return jsonArray.toString();
	}
	
	/**
	 * 获取干线筛选总条数
	 * @param lineBean
	 * @return
	 */
	@RequestMapping("getSelectedLineTotalRowsAjax")
	@ResponseBody
	public Integer getSelectedLineTotalRows(LinetransportSearchBean lineBean){
		Integer count=linetransportService.getSelectedLineTotalRows(lineBean);
		return count;
	}

	/**
	 * 新增干线线路
	 * @param line
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "insertLine", method = RequestMethod.POST)
	public String insertNewLinetransport(Linetransport line,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=linetransportService.insertNewLinetransport(line,request,file);
		return "redirect:linetransport?flag=1";
	}

	/**
	 * 更新干线信息
	 * @param line
	 * @param request
	 * @param response
	 */
	@RequestMapping("updateLine")
	public String updateLinetransport(Linetransport line,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=linetransportService.updateLinetransport(line,request,file);
		return "redirect:linetransport?flag=1";
	}

	/**
	 * 删除干线
	 */
	@RequestMapping(value = "linetransportdelete", method = RequestMethod.GET)
	public String deleteLine(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		linetransportService.deleteLine(id);
		return "redirect:linetransport?flag=1";

	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "downloadlinedetailprice", method = RequestMethod.GET)
	public ModelAndView downloadLineDetailPrice(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		Linetransport linetransportInfo = linetransportService.getLinetransportInfo(id);
			String file = linetransportInfo.getDetailPrice();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	
	/*
	 * 从公司详情页面进入订单页面加载干线资源名称 
	 */
	@ResponseBody
	@RequestMapping(value="getCompanyLinetransportAjax",produces = "text/html;charset=UTF-8")
	public String getCompanyLinetransportAjax(String carrierId,HttpSession session){
		
		return linetransportService.getCompanyLinetransport(carrierId);
	}
	
	
	@Autowired
	CommentService commentService;
	@Resource
	LinetransportService linetransportService;
	@Resource
	CompanyService companyService;
	@Autowired
	FocusService focusService;
	ModelAndView mv = new ModelAndView();
}
