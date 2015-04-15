package cn.edu.bjtu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.FeedbackInfoService;

@Controller
public class FeedbackInfoController {

	@Resource
	FeedbackInfoService feedbackinfoService;

	ModelAndView mv=new ModelAndView();
	
	@RequestMapping("/feedbackinfo")
	public ModelAndView getAllFeedbackInfo()
	{
		
		List feedbackinfoList=feedbackinfoService.getAllFeedbackInfo();
		mv.addObject("feedbackinfoList",feedbackinfoList);
		mv.setViewName("mgmt_d_response");
		
		return mv;
	}
	
}
