package cn.edu.bjtu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.util.Constant;


@Controller
/**
 * 评价相关的操作
 * @author RussWest0
 * @date   2015年5月23日 下午4:35:59
 */
public class CommentController {
	
	
	@Autowired
	 CommentService commentService;	
	
	ModelAndView mv=new ModelAndView();
	
	/**
	 * 提交评论
	 * @param session
	 * @param rate1
	 * @param rate2
	 * @param rate3
	 * @param rate4
	 * @param remarks
	 * @return
	 */
	@RequestMapping("/commitcomment")
	public String commitComment(HttpSession session ,
			String rate1,String rate2,String rate3,String rate4,
			String remarks,String orderid,HttpServletResponse response)
	{
		String userId=(String)session.getAttribute(Constant.USER_ID);
		commentService.commitComment(rate1,rate2,rate3,rate4,remarks,userId,orderid);
		
		return "redirect:turnToOrderPage";
		
	}
	
	/**
	 * 我的信息-首页显示好评率,返回一个小于1的百分数
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserGoodCommentRateAjax")
	public Double getUserGoodCommentRateAjax(HttpSession session){
		Double rate=commentService.getUserGoodCommentRateAjax(session);
		return rate;
	}

}
