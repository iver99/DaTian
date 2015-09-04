package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.bean.search.CarSearchBean;
import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.CarTeamService;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Driverinfo;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
public class CarController {
	@Autowired
	CommentService commentService;
	@Autowired
	CarService carService;
	@Resource
	CompanyService companyService;
	
	@Autowired
	CarTeamService carTeamService;
	
	@Autowired
	DriverService driverService;
	
	@Resource
	LinetransportService linetransportService;
	@Autowired
	FocusService focusService;

	ModelAndView mv = new ModelAndView();

	/**
	 * 资源栏-车辆信息
	 * @return
	 */
	@RequestMapping(value="/car",params="flag=0")
	public String getAllCar() {
		return "resource_list3";
	}
	
	/**
	 * 获取我的信息-车辆信息
	 * @return
	 */
	@RequestMapping(value="car",params="flag=1")
	public String getMyInfoCar(HttpServletRequest request){
		return "mgmt_r_car";
		
	}
	
	/**
	 * 资源栏获取筛选后的车辆信息
	 * @return
	 */
	@RequestMapping(value="getSelectedCarAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getCarSelected(CarSearchBean carBean,PageUtil pageUtil,HttpSession session){
		
		JSONArray jsonArray = carService.getSelectedCarNew(carBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	
	/**
	 * 返回资源-车辆筛选记录总条数
	 * @return
	 */
	@RequestMapping(value="getSelectedCarTotalRowsAjax",method = RequestMethod.POST)
	@ResponseBody
	public Integer getSelectedCarTotalRows(CarSearchBean carBean){
		Integer count=carService.getSelectedCarTotalRows(carBean);
		return count;
	}

	/**
	 * 获取特定的车辆信息
	 * 同时返回公司和车辆两个表的信息
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/cardetail", method = RequestMethod.GET)
	public ModelAndView getCarInfo(@RequestParam("carId") String carId,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("linetransportId") String linetransportId,
			@RequestParam("flag") int flag, HttpServletRequest request) {
		Carinfo carInfo = carService.getCarInfo(carId);// 车辆信息
		mv.addObject("carInfo", carInfo);
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"car");
		Linetransport line = linetransportService
				.getLinetransportInfo(linetransportId);// 干线信息
		mv.addObject("focusList", focusList);
		mv.addObject("linetransportInfo", line);
		if (flag == 0) {// 对应资源栏车辆详情
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			List<Comment> commentList=commentService.getCompanyComment(carrierId);
			//需要获取资源对应的公司的评价平均数bean
			Comment comment=commentService.getCompanyAverageCommentRate(carrierId);
			mv.addObject("avgComment", comment);
			mv.addObject("commentList",commentList);
			
			mv.addObject("carrierInfo", carrierInfo);

			mv.setViewName("resource_detail3");
		} else if (flag == 1)// 对应我的信息列车辆信息
		{
			// 需要司机信息
			Driverinfo driverinfo = driverService.getDriverByCarId(carId);
			mv.addObject("driverInfo", driverinfo);
			mv.setViewName("mgmt_r_car4");
		} else if (flag == 2)// 对应我的信息-车辆-更新
		{
			// 需要司机信息
			Driverinfo driverinfo = driverService.getDriverByCarId(carId);
			mv.addObject("driverInfo", driverinfo);
			List driverList = driverService.getAllDriver(carrierId);
			mv.addObject("driverList", driverList);
			mv.setViewName("mgmt_r_car3");
		}
		return mv;
	}

	

	/**
	 * 新增车辆信息
	 */
	@RequestMapping(value = "insertCar", method = RequestMethod.POST)
	public String insertNewCar(Carinfo car,
			HttpServletRequest request) {
		boolean flag=carService.insertNewCar(car,request);
		return "redirect:car?flag=1";
	}

	/**
	 * 新增司机
	 */
	@RequestMapping(value = "/insertDriver", method = RequestMethod.POST)
	public String insertNewDriver(Driverinfo driver,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=driverService.insertNewDriver(driver,request,file);
		return "redirect:driver?flag=1";
	}
	

	@RequestMapping(value = "updateCar", method = RequestMethod.POST)
	public String updateNewCar(Carinfo car,
			HttpServletRequest request) {
		boolean flag=carService.updateNewCar(car,request);
		return "redirect:car?flag=1";
	}
	

	/**
	 * 删除
	 */
	@RequestMapping(value = "cardelete", method = RequestMethod.GET)
	public String deleteCar(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		carService.deleteCar(id);
		return "redirect:car?flag=1";

	}

	

	/**
	 * 获取车队列表
	 * @return
	 */
	@RequestMapping("carteam")
	public ModelAndView getCarteam(HttpServletRequest request,
			HttpServletResponse response) {
		// 从session里取出id查询
		// 这里用session取id
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		// String carrierId = "C-0002";// 删除
		List<Carteam> carteamList = carTeamService.getCarteam(carrierId);
		mv.addObject("carteamList", carteamList);
		mv.setViewName("mgmt_r_car_fleet");

		return mv;
	}

	/**
	 * 获取特定的车队信息
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/carteamdetail", method = RequestMethod.GET)
	public ModelAndView getCarteamDetail(@RequestParam String id,
			@RequestParam("flag") int flag, HttpServletRequest request) {
		Carteam carteaminfo = carTeamService.getCarteamInfo(id);// 车队信息
		mv.addObject("carteaminfo", carteaminfo);
		if (flag == 1)// 对应车队信息查看
		{
			mv.setViewName("mgmt_r_car_fleet4");
		} else if (flag == 2)// 对应车队信息更新
		{
			mv.setViewName("mgmt_r_car_fleet3");
		}
		return mv;
	}

	/**
	 */
	@RequestMapping(value = "insertcarteam", method = RequestMethod.POST)
	public String insertCarteam(@RequestParam String teamName,
			@RequestParam String carCount, @RequestParam String chief,
			@RequestParam String phone, @RequestParam String explaination,
			HttpServletRequest request, HttpServletResponse response) {
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		boolean flag = carTeamService.insertCarteam(teamName, carCount, chief,
				phone, explaination, carrierId);
		return "redirect:carteam";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "deletecarteam", method = RequestMethod.GET)
	public String deleteCarteam(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {

		carTeamService.deleteCarteam(id);
		return "redirect:carteam";

	}

	@RequestMapping(value = "updatecarteam", method = RequestMethod.POST)
	public String updateCarteam(@RequestParam String id,
			@RequestParam String teamName, @RequestParam String carCount,
			@RequestParam String chief, @RequestParam String phone,
			@RequestParam String explaination, HttpServletRequest request,
			HttpServletResponse response) {
		carTeamService.updateCarteam(id, teamName, carCount, chief,
				phone, explaination);
		return "redirect:carteam";
	}
	
	@RequestMapping(value = "downloadidscans", method = RequestMethod.GET)
	/**
	 * 删除
	 */
	public ModelAndView downloadIdScans(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		Driverinfo driverinfo = driverService.getDriverInfo(id);
			String file = driverinfo.getIdscans();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	
	/**
	 * 异步获取公司的车队列表
	 * @Title: getCompanyCarteamList 
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 	
	 * @date: 2015年6月29日 下午5:32:46
	 */
	@RequestMapping(value="getCompanyCarteamList",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCompanyCarteamList(HttpSession session){
		List<Carteam> carTeamList=carService.getCompanyCarteamList(session);
		//JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		if(carTeamList!=null && carTeamList.size()>0){
			for(int i=0;i<carTeamList.size();i++){
				JSONObject jsonObject=(JSONObject)JSONObject.toJSON(carTeamList.get(i));
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray.toString();
		
	}
	
	
	/**
	 * 我的信息-车辆信息
	 * @Title: getUserCarResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午11:10:00
	 */
	@RequestMapping(value="getUserCarResourceAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getUserCarResource(HttpSession session,PageUtil pageUtil){
		
		JSONArray jsonArray=carService.getUserCarResource(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	/**
	 * 我的信息-车辆信息-总记录条数
	 * @Title: getUserCarResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午11:11:56
	 */
	@RequestMapping(value="getUserCarResourceTotalRowsAjax")
	@ResponseBody
	public Integer getUserCarResourceTotalRows(HttpSession session){
		
		return carService.getUserCarResourceTotalRows(session);
	}
	/**
	 * 我的信息-司机信息
	 * @Title: getUserCarResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午11:10:00
	 */
	@RequestMapping(value="getUserDriverResourceAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getUserDriverResource(HttpSession session,PageUtil pageUtil){
		
		JSONArray jsonArray=driverService.getUserDriverResource(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	/**
	 * 我的信息-车辆信息-总记录条数
	 * @Title: getUserCarResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午11:11:56
	 */
	@RequestMapping(value="getUserDriverResourceTotalRowsAjax")
	@ResponseBody
	public Integer getUserDriverResourceTotalRows(HttpSession session){
		
		return driverService.getUserDriverResourceTotalRows(session);
	}
	
	/**
	 * 我的资源-车辆信息-车队i信息
	 * @Title: getUserCarTeamResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月15日 上午11:17:55
	 */
	@RequestMapping(value="getUserCarTeamResourceAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserCarTeamResource(HttpSession session,PageUtil pageUtil){
		return carTeamService.getUserCarTeamResource(session,pageUtil);
	}
	/**
	 * 我的资源-车辆信息-车队i信息-总记录数
	 * @Title: getUserCarTeamResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月15日 上午11:19:43
	 */
	@RequestMapping("getUserCarTeamResourceTotalRowsAjax")
	@ResponseBody
	public Integer getUserCarTeamResourceTotalRows(HttpSession session){
		return carTeamService.getUserCarTeamResourceTotalRows(session);
	}

	
	/**
	 * 从公司详情页面进入订单加载公司的车辆资源  
	 * @param carrierId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getCompanyCarAjax",produces="text/html;charset=UTF-8")
	public String getCompanyCarAjax(String carrierId){
		return carService.getCompanyCarAjax(carrierId);
		
	}
}
