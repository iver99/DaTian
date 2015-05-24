package cn.edu.bjtu.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.vo.Focus;

@Controller
/**
 * 关注相关控制器
 * @author RussWest0
 *
 */
public class FocusController {
	
	@Autowired
	FocusService focusService;
	@Resource 
	Focus focus;

	ModelAndView mv = new ModelAndView();
	
	@RequestMapping("focus")
	/**
	  * 关注页面
	  * @param request
	  * @param response
	  * @return
 	  */
	public ModelAndView insertFocus(
			HttpServletRequest request,HttpServletResponse response){
			String clientId=(String)request.getSession().getAttribute("userId");
			if(clientId==null)
			{
				mv.setViewName("login");
				return mv;
			}
			String focusType = request.getParameter("type");
			String foucsId = request.getParameter("id");
			List focusJudgement = focusService.getFocusJudgement(clientId,focusType,foucsId);
			//System.out.println("focusJudgement="+focusJudgement);
			boolean flag = true;
			if(focusJudgement.isEmpty())
				flag = focusService.insertFocus(clientId,focusType,foucsId);
			else{
				focus = (Focus) focusJudgement.get(0);
				flag = focusService.deleteFocus(focus.getId());
				//System.out.println(focus.getId());
			}
			//boolean flag = focusService.insertFocus(clientId,focusType,foucsId);
				try {
					if (flag == true)
						response.sendRedirect("getaddress");
					else
						System.out.println("添加失败");// 应记录日志
				} catch (IOException e) {
					// TODO Auto-generated catch block
					// 此处应记录日志
					e.printStackTrace();

				}
				
			return mv;
		}
}
