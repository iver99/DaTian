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
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
/**
 * 干线相关控制器
 * @author RussWest0
 *
 */
public class LinetransportController {

	private Logger logger = Logger.getLogger(LinetransportController.class);
	
	
	@RequestMapping(value="/linetransport",params="flag=0",produces = "text/html;charset=UTF-8")
	/**
	 * 资源栏所有干线信息
	 * @return
	 */
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
	@Deprecated
	@RequestMapping(value="/linetransport",params="flag=1")
	public ModelAndView getAllCompanyLine(@RequestParam int flag,
			PageUtil page, HttpSession session) {
		String userId = (String) session.getAttribute(Constant.USER_ID);
		if(userId==null)
		{
			mv.setViewName("login");
			return mv;
		}
		List linetransportList = linetransportService.getCompanyLine(
				userId, 10, 1);// 新增两个参数

		mv.addObject("linetransportList", linetransportList);
			mv.setViewName("mgmt_r_line");
			return mv;
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
	// 同时拦截两种请求
		/**              
		 * 返回干线符合筛选的条件的信息
		 * @param startPlace
		 * @param endPlace
		 * @param type
		 * @param startPlace
		 * @param refPrice
		 * @param Display
		 * @param PageNow
		 * @return
		 */
	@Deprecated
	@RequestMapping(value = { "linetransportselected", "searchResourceselected" })
	public ModelAndView getSelectedLine(@RequestParam String startPlace,
			@RequestParam String endPlace, @RequestParam String type,
			@RequestParam String startPlace1, @RequestParam String refPrice,
			@RequestParam int Display, @RequestParam int PageNow,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// 
			e.printStackTrace();
		}

		List linetransportList = linetransportService.getSelectedLine(
				startPlace, endPlace, type, startPlace1, refPrice, Display,
				PageNow);
		int count = linetransportService.getTotalRows(startPlace, endPlace,
				type, startPlace1, refPrice);// 获取总记录数

		int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
		mv.addObject("linetransportList", linetransportList);
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pageNow", PageNow);
		mv.setViewName("resource_list");

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

	@RequestMapping(value = "insertLine", method = RequestMethod.POST)
	/**
	 * 新增干线线路
	 * @param lineName
	 * @param startPlace
	 * @param endPlace
	 * @param onWayTime
	 * @param type
	 * @param refPrice
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView insertLine(
			@RequestParam(required = false) MultipartFile file,// new add
			@RequestParam String lineName, @RequestParam String startPlace,
			@RequestParam String endPlace, @RequestParam int onWayTime,
			@RequestParam String type,
			@RequestParam float refPrice,// 缺少详细报价参数
			@RequestParam String remarks, HttpServletRequest request,
			HttpServletResponse response) {
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		// ////////////////////////////////////////////////////////////////////////

		String path = null;
		String fileName = null;
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getLinetransportPath();// 不同的地方取不同的上传路径
			fileName = file.getOriginalFilename();
			fileName = carrierId + "_" + fileName;// 文件名
			File targetFile = new File(path, fileName);
			try { // 保存 文件
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// //////////////////////////////////////////////////////////////////
		} 
		//没有上传文件的情况path 和 filenName默认为null
		boolean flag = linetransportService.insertLine(lineName, startPlace,
				endPlace, onWayTime, type, refPrice, remarks, carrierId, path,
				fileName);
		// 修改此方法,增加两个参数
		if (flag == true) {
			try {
				response.sendRedirect("linetransport?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// 
				// 此处应该记录日志
				e.printStackTrace();
			}
		} else
			mv.setViewName("mgmt_r_line");
		return mv;
	}

	@RequestMapping(value = "updateLine", method = RequestMethod.POST)
	/**
	 * 更新干线信息
	 * @param id
	 * @param lineName
	 * @param startPlace
	 * @param endPlace
	 * @param onWayTime
	 * @param type
	 * @param refPrice
	 * @param remarks
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateLine(@RequestParam MultipartFile file,
			@RequestParam String id,// GET方式传入，在action中
			@RequestParam String lineName, @RequestParam String startPlace,
			@RequestParam String endPlace, @RequestParam int onWayTime,
			@RequestParam String type,
			@RequestParam float refPrice,// 缺少详细报价参数
			@RequestParam String remarks, HttpServletRequest request,
			HttpServletResponse response) {
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//////////////////////////////////////////////
		String path = null;
		String fileName = null;
		if (file.getSize() != 0)// 有上传文件的情况
		{
			path = UploadPath.getLinetransportPath();// 不同的地方取不同的上传路径
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
		
		//////////////////////////////////////////////
		
		boolean flag = linetransportService.updateLine(id, lineName,
				startPlace, endPlace, onWayTime, type, refPrice, remarks,
				carrierId,path,fileName);//change
		if (flag == true) {
			try {
				response.sendRedirect("linetransport?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// 此处应该记录日志
				e.printStackTrace();
			}
		} else
			mv.setViewName("mgmt_r_line");
		return mv;

	}

	@RequestMapping(value = "linetransportdelete", method = RequestMethod.GET)
	/**
	 * 删除干线
	 */
	public ModelAndView deleteLine(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		boolean flag = linetransportService.deleteLine(id);
		if (flag == true) {
			// mv.setViewName("mgmt_r_line");
			try {
				response.sendRedirect("linetransport?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// 
				// 此处应该记录日志
				e.printStackTrace();
			}
		} else
			mv.setViewName("mgmt_r_line");
		return mv;

	}

	@RequestMapping(value = "downloadlinedetailprice", method = RequestMethod.GET)
	/**
	 * 删除
	 */
	public ModelAndView downloadLineDetailPrice(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		Linetransport linetransportInfo = linetransportService.getLinetransportInfo(id);
			String file = linetransportInfo.getDetailPrice();
			DownloadFile.downloadFile(file,request,response);
		return mv;

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
