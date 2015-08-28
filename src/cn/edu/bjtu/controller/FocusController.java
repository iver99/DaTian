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

import cn.edu.bjtu.bean.page.FocusBean;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.vo.Focus;

import com.alibaba.fastjson.JSONArray;

/**
 * 关注相关控制器
 * @author RussWest0
 *
 */
@Controller
public class FocusController {

	@Autowired
	FocusService focusService;
	@Resource
	Focus focus;

	ModelAndView mv = new ModelAndView();

	/**
	  * 关注页面
	  * @param request
	  * @param response
	  * @return
 	  */
	@RequestMapping("focus")
	public String insertFocus(
			HttpServletRequest request,HttpServletResponse response) throws Exception{
			String clientId=(String)request.getSession().getAttribute(Constant.USER_ID);
			//String userKind=(String)request.getSession().getAttribute("useKind");
			
			if(clientId==null)
			{
				response.setContentType("text/html;charset=UTF-8");
			    response.getWriter().print("login");
				return null;
			}
			String focusType = request.getParameter("type");
			String foucsId = request.getParameter("id");
			List focusJudgement = focusService.getFocusJudgement(clientId,focusType,foucsId);
			boolean flag = true;
			if(focusJudgement.isEmpty())
			{
				flag = focusService.insertFocus(clientId,focusType,foucsId);
			    response.setContentType("text/html;charset=UTF-8");
			    response.getWriter().print("insert");				
			}

			else{
				focus = (Focus) focusJudgement.get(0);
				flag = focusService.deleteFocus(focus.getId());
				response.setContentType("text/html;charset=UTF-8");
			    response.getWriter().print("delete");
			}
			
			return null;
		}
	
	
	@RequestMapping("getallfocus")
	public String getFocusPage(){
		return "mgmt_d_focus";
	}
	
	/**
	 * 取消关注页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("deletefocus")
	public String deleteFocus(HttpServletRequest request,
			HttpServletResponse response,@RequestParam String id) {
		//String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		focusService.deleteFocus(id);
		
		return "redirect:getallfocus";
	}
	
	
	/**
	 * 搜索关注
	 * @Title: searchFocus 
	 *  
	 * @param: @param search_content
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月6日 上午11:44:57
	 */
	@RequestMapping(value="getUserFocusAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String searchFocus(FocusBean focusBean,HttpSession session){
		JSONArray jsonArray=focusService.searchFocus(focusBean,session);
		
		return jsonArray.toString();
	}
	
	/**
	 * 我的关注总记录数 
	 * @param focusBean
	 * @param session
	 * @return
	 */
	@RequestMapping("getUserFocusTotalRowsAjax")
	@ResponseBody
	public Integer getUserFocusTotalRows(FocusBean focusBean,HttpSession session){
		return focusService.getUserFocusTotalRowsAjax(focusBean,session);
	}

	
}
