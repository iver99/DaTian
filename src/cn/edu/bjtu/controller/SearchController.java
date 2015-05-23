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
		// System.out.println("进入搜索控制器 ");
		// System.out.println("resourcechoose+" + resourceChoose);
		 //System.out.println("resourcecontent+"+searchContent);
		if (Display == null)
			Display = 10;// 默认的每页大小
		if (PageNow == null)
			PageNow = 1;// 默认的当前页面

		if (resourceChoose.equals("线路"))// 匹配干线搜索
		{

			System.out.println("进入线路");
			List resultList = new ArrayList();
			List resultListPart1 = searchServiceImpl
					.getLineResourceByStartPlace(searchContent);

			List resultListPart2 = searchServiceImpl
					.getLineResourceByEndPlace(searchContent);

			System.out.println("listpart1+" + resultListPart1.size()
					+ "+listpart2+" + resultListPart2.size());
			// 合并结果集

			resultList.addAll(resultListPart1);
			resultList.addAll(resultListPart2);

			/*int count = resultList.size();
			// System.out.println("count+"+count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);*/

			mv.addObject("linetransportList", resultList);// 名字要和linetransport里的对上，不然页面显示不出啦
			mv.setViewName("resource_list");

		} else if (resourceChoose.equals("配送"))// 匹配城市配送
		{
			System.out.println("进入城市配送");
			//List resultList = new ArrayList();
			List resultList = searchServiceImpl
					.getCitylineResourceByName(searchContent);

			//List resultListPart2 = searchServiceImpl.getLineResourceByEndPlace(searchContent);

			System.out.println("list+" + resultList.size());
			//		+ "+listpart2+" + resultListPart2.size());
			// 合并结果集

			//resultList.addAll(resultListPart1);
			//resultList.addAll(resultListPart2);

			/*int count = resultList.size();
			// System.out.println("count+"+count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);*/

			mv.addObject("citylineList", resultList);// 名字要和linetransport里的对上，不然页面显示不出啦
			mv.setViewName("resource_list2");
		} else if (resourceChoose.equals("货物"))// 匹配货物搜索
		{
			System.out.println("进入货物");
			//List resultList = new ArrayList();
			List resultList = searchServiceImpl
					.getGoodsResourceByName(searchContent);

			//List resultListPart2 = searchServiceImpl.getLineResourceByEndPlace(searchContent);

			System.out.println("list+" + resultList.size());
			//		+ "+listpart2+" + resultListPart2.size());
			// 合并结果集

			//resultList.addAll(resultListPart1);
			//resultList.addAll(resultListPart2);

			/*int count = resultList.size();
			// System.out.println("count+"+count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);*/

			mv.addObject("goodsformInfo", resultList);// 名字要和linetransport里的对上，不然页面显示不出啦
			mv.setViewName("resource_list6");
		} else if (resourceChoose.equals("公司")) {// 匹配车辆搜索
			System.out.println("进入公司");
			//List resultList = new ArrayList();
			List resultList = searchServiceImpl
					.getCompanyResourceByCompanyName(searchContent);

			//List resultListPart2 = searchServiceImpl.getLineResourceByEndPlace(searchContent);

			System.out.println("list+" + resultList.size());
			//		+ "+listpart2+" + resultListPart2.size());
			// 合并结果集

			//resultList.addAll(resultListPart1);
			//resultList.addAll(resultListPart2);

			/*int count = resultList.size();
			// System.out.println("count+"+count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);*/

			mv.addObject("companyList", resultList);// 名字要和linetransport里的对上，不然页面显示不出啦
			mv.setViewName("resource_list5");
		} else if (resourceChoose.equals("车辆")) {// 匹配车辆
			System.out.println("进入车辆");
			//List resultList = new ArrayList();
			List resultList = searchServiceImpl
					.getCarResourceByCarNum(searchContent);

			//List resultListPart2 = searchServiceImpl.getLineResourceByEndPlace(searchContent);

			System.out.println("list+" + resultList.size());
			//		+ "+listpart2+" + resultListPart2.size());
			// 合并结果集

			//resultList.addAll(resultListPart1);
			//resultList.addAll(resultListPart2);

			/*int count = resultList.size();
			// System.out.println("count+"+count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);*/

			mv.addObject("carList", resultList);// 名字要和linetransport里的对上，不然页面显示不出啦
			mv.setViewName("resource_list3");
		} else if (resourceChoose.equals("仓库")) {// 匹配仓库
			System.out.println("进入仓库");
			//List resultList = new ArrayList();
			List resultList = searchServiceImpl
					.getWarehouseResourceByName(searchContent);

			//List resultListPart2 = searchServiceImpl.getLineResourceByEndPlace(searchContent);

			System.out.println("list+" + resultList.size());
			//		+ "+listpart2+" + resultListPart2.size());
			// 合并结果集

			//resultList.addAll(resultListPart1);
			//resultList.addAll(resultListPart2);

			/*int count = resultList.size();
			// System.out.println("count+"+count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);*/

			mv.addObject("warehouseList", resultList);// 名字要和linetransport里的对上，不然页面显示不出啦
			mv.setViewName("resource_list4");
		}

		// mv.setViewName("");
		return mv;
	}
}
