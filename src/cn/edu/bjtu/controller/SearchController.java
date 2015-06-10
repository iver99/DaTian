package cn.edu.bjtu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.SearchService;

/**
 * 搜索控制器
 * 
 * @author RussWest0
 *
 */
@Controller
public class SearchController {

	@Autowired
	SearchService searchServiceImpl;
	ModelAndView mv = new ModelAndView();

	@RequestMapping(value = "searchResource", method = RequestMethod.POST)
	public ModelAndView getSearchInfo(String resourceChoose,
			String searchContent,
			@RequestParam(required = false) Integer Display,
			@RequestParam(required = false) Integer PageNow) {
		if (Display == null)
			Display = 10;// 默认的每页大小
		if (PageNow == null)
			PageNow = 1;// 默认的当前页面

		if (resourceChoose.equals("线路"))// 匹配干线搜索
		{

			List resultList = new ArrayList();
			List resultListPart1 = searchServiceImpl
					.getLineResourceByStartPlace(searchContent);

			List resultListPart2 = searchServiceImpl
					.getLineResourceByEndPlace(searchContent);

			// 合并结果集

			resultList.addAll(resultListPart1);
			resultList.addAll(resultListPart2);


			mv.addObject("linetransportList", resultList);// 名字要和linetransport里的对上，不然页面显示不出啦
			mv.setViewName("resource_list");

		} else if (resourceChoose.equals("配送"))// 匹配城市配送
		{
			//List resultList = new ArrayList();
			List resultList = searchServiceImpl
					.getCitylineResourceByName(searchContent);

			mv.addObject("citylineList", resultList);// 
			mv.setViewName("resource_list2");
		} else if (resourceChoose.equals("货物"))// 匹配货物搜索
		{
			//List resultList = new ArrayList();
			List resultList = searchServiceImpl
					.getGoodsResourceByName(searchContent);

			mv.addObject("goodsformInfo", resultList);// 
			mv.setViewName("resource_list6");
		} else if (resourceChoose.equals("公司")) {// 匹配车辆搜索
			List resultList = searchServiceImpl
					.getCompanyResourceByCompanyName(searchContent);

			mv.addObject("companyList", resultList);// 
			mv.setViewName("resource_list5");
		} else if (resourceChoose.equals("车辆")) {// 匹配车辆
			List resultList = searchServiceImpl
					.getCarResourceByCarNum(searchContent);

			mv.addObject("carList", resultList);//
			mv.setViewName("resource_list3");
		} else if (resourceChoose.equals("仓库")) {// 匹配仓库
			List resultList = searchServiceImpl
					.getWarehouseResourceByName(searchContent);


			mv.addObject("warehouseList", resultList);
			mv.setViewName("resource_list4");
		}
		return mv;
	}
}
