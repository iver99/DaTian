package cn.edu.bjtu.controller;

import java.util.ArrayList;
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
		System.out.println("½øÈëtest¿ØÖÆÆ÷");
		ModelAndView mv=new ModelAndView();
		//BaseDaoImpl dao=new BaseDaoImpl();
		List list=ht.find("select count(*) from Carinfo");
		System.out.println("size+"+list.get(0));
		mv.setViewName("success");
		return mv;
		
	}
	
	/*public static void main(String [] args)
	{
		List list=new ArrayList();
		List list2=new ArrayList();
		
		list.add(0,"1");
		list.add(1, "b");
		
		list2.add(0,"a");
		list2.add(1,"2");
		
		list.addAll(list2);
		System.out.println("list+"+list);
	}*/
}
