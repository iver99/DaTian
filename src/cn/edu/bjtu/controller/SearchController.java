package cn.edu.bjtu.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.common.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.SearchService;
import cn.edu.bjtu.util.PageUtil;

import com.alibaba.fastjson.JSONArray;

/**
 * 搜索控制器
 * 
 * @author RussWest0
 *
 */
@Controller
public class SearchController {

	@Autowired
	SearchService searchService;
	private static final Logger logger=Logger.getLogger(SearchController.class);
	ModelAndView mv = new ModelAndView();
	
	/**
	 * 搜索功能
	 * @param search_content
	 * @param resource_kind
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	@RequestMapping(value="searchResourceAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSearchResult(String search_content, String resource_kind,
			PageUtil pageUtil, HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		logger.info(request.getHeader("referer"));
		String request_url=request.getHeader("referer");
		String url="";
		if(!checkURL(request_url)){
			try{
				if("线路".equals(resource_kind)){
					/*RequestDispatcher dispatcher= request.getRequestDispatcher("linetransport?flag=0");
					 dispatcher.forward(request, response);*/
					response.sendRedirect("linetransport?flag=0");
					url="linetransport?flag=0";
				}else if("配送".equals(resource_kind)){
					RequestDispatcher dispatcher= request.getRequestDispatcher("cityline?flag=0");
					dispatcher.forward(request, response);
				}else if("车辆".equals(resource_kind)){
					RequestDispatcher dispatcher= request.getRequestDispatcher("car?flag=0");
					dispatcher.forward(request, response);
				}else if("仓库".equals(resource_kind)){
					RequestDispatcher dispatcher= request.getRequestDispatcher("warehouse?flag=0");
					dispatcher.forward(request, response);
				}else if("公司".equals(resource_kind)){
					RequestDispatcher dispatcher= request.getRequestDispatcher("company");
					dispatcher.forward(request, response);
				}else{//货物
					RequestDispatcher dispatcher= request.getRequestDispatcher("goodsform?flag=0");
					dispatcher.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return url;
			
		}else{//在资源list发出的搜索

		JSONArray jsonArray=new JSONArray();
		if(resource_kind.equals("线路")){
			jsonArray=searchService.getLineResourceByCityName(search_content, pageUtil, session);
		}else if(resource_kind.equals("配送")){
			jsonArray=searchService.getCitylineResourceByName(search_content, pageUtil, session);
		}
		else if(resource_kind.equals("车辆")){
			jsonArray=searchService.getCarResourceByCarNum(search_content, pageUtil, session);
		}
		else if(resource_kind.equals("仓库")){
			jsonArray=searchService.getWarehouseResourceByName(search_content, pageUtil, session);
		}
		else if(resource_kind.equals("公司")){
			jsonArray=searchService.getCompanyResourceByCompanyName(search_content, pageUtil, session);
		}
		else if(resource_kind.equals("货物")){
				jsonArray=searchService.getGoodsResourceByName(search_content, pageUtil, session);
		}
		
		return jsonArray.toString();
		}
		
	}
	
	/**
	 * 检查搜索的请求是不是由资源list页面发出来的，如果是，页面不用跳转，如果不是
	 * 页面需要跳转到list页面以供显示资源
	 * @Title: checkURL 
	 *  
	 * @param: @param url
	 * @param: @return 
	 * @return: boolean 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年6月29日 下午4:18:38
	 */
	private boolean checkURL(String url){
		
		if (url.contains("linetransport?flag=0")
				|| url.contains("cityline?flag=0")
				|| url.contains("car?flag=0")
				|| url.contains("warehouse?flag=0") || url.contains("company")
				|| url.contains("goodsform?flag=0")) {
			
			return true;
		}
		else
			return false;
		
	}

	/*@RequestMapping(value = "searchResource")
	@Deprecated
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
			List resultListPart1 = searchService
					.getLineResourceByStartPlace(searchContent);

			List resultListPart2 = searchService
					.getLineResourceByEndPlace(searchContent);

			// 合并结果集

			resultList.addAll(resultListPart1);
			resultList.addAll(resultListPart2);


			mv.addObject("linetransportList", resultList);// 名字要和linetransport里的对上，不然页面显示不出啦
			mv.setViewName("resource_list");

		} else if (resourceChoose.equals("配送"))// 匹配城市配送
		{
			//List resultList = new ArrayList();
			List resultList = searchService
					.getCitylineResourceByName(searchContent);

			mv.addObject("citylineList", resultList);// 
			mv.setViewName("resource_list2");
		} else if (resourceChoose.equals("货物"))// 匹配货物搜索
		{
			//List resultList = new ArrayList();
			List resultList = searchService
					.getGoodsResourceByName(searchContent);

			mv.addObject("goodsformInfo", resultList);// 
			mv.setViewName("resource_list6");
		} else if (resourceChoose.equals("公司")) {// 匹配车辆搜索
			List resultList = searchService
					.getCompanyResourceByCompanyName(searchContent);

			mv.addObject("companyList", resultList);// 
			mv.setViewName("resource_list5");
		} else if (resourceChoose.equals("车辆")) {// 匹配车辆
			List resultList = searchService
					.getCarResourceByCarNum(searchContent);

			mv.addObject("carList", resultList);//
			mv.setViewName("resource_list3");
		} else if (resourceChoose.equals("仓库")) {// 匹配仓库
			List resultList = searchService
					.getWarehouseResourceByName(searchContent);


			mv.addObject("warehouseList", resultList);
			mv.setViewName("resource_list4");
		}
		return mv;
	}*/
}
