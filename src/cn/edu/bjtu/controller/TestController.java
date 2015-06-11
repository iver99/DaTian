package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("views")
/**
 * 
 * @author RussWest0
 *
 */
public class TestController {
	
	@Resource
	HibernateTemplate ht;
	@RequestMapping("test")
	public ModelAndView test()
	{	
		ModelAndView mv=new ModelAndView();
		//BaseDaoImpl dao=new BaseDaoImpl();
		List list=ht.find("select count(*) from Carinfo");
		mv.setViewName("success");
		return mv;
		
	}
	
	
	
}
