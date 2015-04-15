package cn.edu.bjtu.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Driverinfo;
import cn.edu.bjtu.vo.Linetransport;

@Controller
public class CarController {

	@Resource(name = "carServiceImpl")
	CarService carService;
	@Resource
	CompanyService companyService;
	@Resource
	LinetransportService linetransportService;

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/car")
	/**
	 * 返回所有车辆信息（视图查询）
	 * @return
	 */
	public ModelAndView getAllCar(@RequestParam int flag,
			HttpServletRequest request) {
		int Display=10;//默认的每页大小
		int PageNow=1;//默认的当前页面
		
		if (flag == 0) {
			List carList = carService.getAllCar(Display,PageNow);
			int count = carService.getTotalRows("All", "All", "All", "All");// 获取总记录数,不需要where子句，所以参数都是All
			System.out.println("count+"+count);
			int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
			mv.addObject("count", count);
			mv.addObject("pageNum", pageNum);
			mv.addObject("pageNow", PageNow);
			
			mv.addObject("carList", carList);
			mv.setViewName("resource_list3");
		} else if (flag == 1) {
			// 这里用session取id
			 String carrierId=(String)request.getSession().getAttribute("userId");
			//String carrierId = "C-0002";// 删除
			List carList = carService.getCompanyCar(carrierId);
			mv.addObject("carList", carList);
			mv.setViewName("mgmt_r_car");// 后台还没实现
		}
		return mv;
	}

	@RequestMapping(value = "/cardetail", method = RequestMethod.GET)
	/**
	 * 获取特定的车辆信息
	 * 同时返回公司和车辆两个表的信息
	 * @param
	 * @return
	 */
	public ModelAndView getCarInfo(@RequestParam("carId") String carId,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("linetransportId") String linetransportId,
			@RequestParam("flag") int flag, HttpServletRequest request) {
		Carinfo carInfo = carService.getCarInfo(carId);// 车辆信息
		mv.addObject("carInfo", carInfo);

		Linetransport line = linetransportService
				.getLinetransportInfo(linetransportId);// 干线信息
		mv.addObject("linetransportInfo", line);
		if (flag == 0) {// 对应资源栏车辆详情
			Carrierinfo carrierInfo = companyService.getCarrierInfo(carrierId);

			mv.addObject("carrierInfo", carrierInfo);

			mv.setViewName("resource_detail3");
		} else if (flag == 1)// 对应我的信息列车辆信息
		{
			// 需要司机信息
			Driverinfo driverinfo = carService.getDriverByCarId(carId);
			mv.addObject("driverInfo", driverinfo);
			mv.setViewName("mgmt_r_car4");
		} else if (flag == 2)// 对应我的信息-车辆-更新
		{
			// 需要司机信息
			Driverinfo driverinfo = carService.getDriverByCarId(carId);
			mv.addObject("driverInfo", driverinfo);
			// 此处要查出本公司所有司机的姓名以供选择
			// String carrierId=(String)request.getSession().getAttribute("carrierId");
			// carrierId = "C-0002";// 删除
			List driverNameList = carService.getAllDriverName(carrierId);
			mv.addObject("driverNameList", driverNameList);
			mv.setViewName("mgmt_r_car3");
		}
		return mv;
	}

	@RequestMapping("carselected")
	/**
	 * 返回符合筛选条件的车辆信息
	 * @param carLocation1
	 * @param endPlace
	 * @param carUse
	 * @param carColdStorage
	 * @param carLength
	 * @param carLocation
	 * @param Display
	 * @param PageNow
	 * @return
	 */
	public ModelAndView getSelectedCar(@RequestParam String carLocation,
			@RequestParam String endPlace, @RequestParam String carBase,
			@RequestParam String carLength,
			@RequestParam String carWeight,
			//@RequestParam String location,
			@RequestParam int Display, @RequestParam int PageNow,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入筛选车辆的控制器");
		
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("已经进入控制器");

		List carList = carService.getSelectedCar(
				carLocation,
				//endPlace, 没有目的城市
				carBase, carLength, carWeight,
				//location, 没有定位信息
				Display, PageNow);
		int count = carService.getTotalRows(carLocation,
				//endPlace,
				carBase, carLength, carWeight
				//, location
				);// 获取总记录数

		int pageNum = (int) Math.ceil(count * 1.0 / Display);// 页数
		//System.out.println("总记录数+"+count);
		//System.out.println("页数+"+pageNum);
		mv.addObject("carList", carList);
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pageNow", PageNow);
		mv.setViewName("resource_list3");
		
		return mv;
	}

	@RequestMapping("driver")
	/**
	 * 获取司机列表
	 * @param flag
	 * @return
	 */
	public ModelAndView getAllDriver(@RequestParam int flag,
			HttpServletRequest request, HttpServletResponse response) {
		// 从session里取出id查询
		if (flag == 0) {//所有的司机信息
			List driverList = carService.getAllDriver();
			mv.addObject("driverList", driverList);
			mv.setViewName("mgmt_r_driver");
		} else if (flag == 1) {//公司司机列表
			// 这里用session取id
			String carrierId=(String)request.getSession().getAttribute("userId");
			// String carrierId = "C-0002";// 删除
			List driverList = carService.getCompanyDriver(carrierId);
			mv.addObject("driverList", driverList);
			mv.setViewName("mgmt_r_driver");
		}

		return mv;
	}

	@RequestMapping("driverdetail")
	/**
	 * 司机信息详情
	 * @param driverId
	 * @param flag
	 * @return
	 */
	public ModelAndView getDriverInfo(@RequestParam String driverId,
			@RequestParam int flag) {
		Driverinfo driver = carService.getDriverInfo(driverId);
		mv.addObject("driver", driver);
		if (flag == 1) {// 对应司机详情
			mv.setViewName("mgmt_r_driver4");
		} else if (flag == 2)// 对应司机更新
		{
			mv.setViewName("mgmt_r_driver3");
		}

		return mv;
	}

	@RequestMapping(value = "insertCar", method = RequestMethod.POST)
	/**
	 * 新增车辆信息
	 * @param carNum
	 * @param carTeam
	 * @param locationType
	 * @param carType
	 * @param carBase
	 * @param carBrand
	 * @param carUse
	 * @param carLength
	 * @param carWidth
	 * @param carHeight
	 * @param carWeight
	 * @param driverName
	 * @param purchaseTime
	 * @param storage
	 * @param startPlace
	 * @param endPlace
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView insertCar(@RequestParam String carNum,
			@RequestParam String carTeam, @RequestParam String locationType,
			@RequestParam String carType, @RequestParam String carBase,
			@RequestParam String carBrand, @RequestParam String carUse,
			@RequestParam double carLength, @RequestParam double carWidth,
			@RequestParam double carHeight, @RequestParam double carWeight,
			@RequestParam String driverName, @RequestParam String purchaseTime,
			@RequestParam String storage, @RequestParam String startPlace,
			@RequestParam String endPlace, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("进入控制器");
		String carrierId=(String)request.getSession().getAttribute("userId");
		//String carrierId = "C-0002";// 删除
		/*
		 * boolean flag = linetransportService.insertLine(lineName, startPlace,
		 * endPlace, onWayTime, type, refPrice, remarks,carrierId);
		 */
		boolean flag = carService.insertCar(carNum, carTeam, locationType,
				carBase, carBrand, carType, carUse, carLength, carWidth,
				carHeight, carWeight, driverName, purchaseTime, storage,
				startPlace, endPlace, carrierId);
		System.out.println("flag+" + flag);
		if (flag == true) {
			try {
				System.out.println("redirect之前");
				response.sendRedirect("car?flag=1");// 重定向，显示最新的结果 error,无法重定向
				// mv.setViewName("mgmt_r_car");
				System.out.println("redirect之后");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("car插入后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;
	}

	@RequestMapping(value="/insertDriver",method = RequestMethod.POST)
	/**
	 * 新增司机
	 * @param name
	 * @param sex
	 * @param licenceRate
	 * @param phone
	 * @param IDCard
	 * @param licenceNum
	 * @param licenceTime
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView insertDriver(@RequestParam String name,
			@RequestParam String sex, @RequestParam String licenceRate,
			@RequestParam String phone, @RequestParam String IDCard,
			@RequestParam String licenceNum, @RequestParam String licenceTime,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入driver控制器insert");
		String carrierId=(String)request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除

		boolean flag = carService.insertDriver(name, sex, licenceRate, phone,
				IDCard, licenceNum, licenceTime, carrierId);
		System.out.println("flag+" + flag);
		if (flag == true) {
			try {
				System.out.println("redirect之前");
				response.sendRedirect("driver?flag=1");// 重定向，显示最新的结果
														// error,无法重定向
				// mv.setViewName("mgmt_r_car");
				System.out.println("redirect之后");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("driver插入后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;
	}
	
	@RequestMapping(value = "updateCar", method = RequestMethod.POST)
	/**
	 * * 更新车辆信息（不包括司机和路线）
	 * @param id
	 * @param carNum
	 * @param carTeam
	 * @param locType
	 * @param GPSText
	 * @param carType
	 * @param carBase
	 * @param carBrand
	 * @param carUse
	 * @param carLength
	 * @param carWidth
	 * @param carHeight
	 * @param carWeight
	 * @param carPurTime
	 * @param storage
	 * @param driverName
	 * @param startPlace
	 * @param endPlace
	 * @param stopPlace
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateCar(
			@RequestParam String id,// GET方式传入，在action中
			@RequestParam String carNum, @RequestParam String carTeam,
			@RequestParam String locType, 
			@RequestParam String GPSText,// 缺少参数
			@RequestParam String carType,
			@RequestParam String carBase,
			@RequestParam String carBrand,
			@RequestParam String carUse,
			@RequestParam double carLength,
			@RequestParam double carWidth,
			@RequestParam double carHeight,
			@RequestParam double carWeight,
			@RequestParam String carPurTime,
			@RequestParam String storage,
			@RequestParam String driverName,
			@RequestParam String startPlace,
			@RequestParam String endPlace,
			@RequestParam String stopPlace,
			HttpServletRequest request,
			HttpServletResponse response) {

		// 此处获取session里的carrierid，下面方法增加一个参数
		String carrierId=(String)request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除
		System.out.println("in controller");//null
		
		boolean flag = carService.updateCar(id, carNum, carTeam, locType, 
				 GPSText, carType, carBase, carBrand, carUse, carLength, carWidth,
				 carHeight,carWeight, carPurTime, storage, driverName, startPlace,
				 endPlace, stopPlace, carrierId);
		
		System.out.println("out updateCar");//null
		if (flag == true) {
			// mv.setViewName("mgmt_r_line");
			try {
				response.sendRedirect("car?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("car更新后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;

	}
	
	@RequestMapping(value="/updateDriver",method = RequestMethod.POST)
	/**
	 * * 更新司机信息
	 * @param id
	 * @param name
	 * @param sex
	 * @param IDCard
	 * @param licenceNum
	 * @param licenceRate
	 * @param licenceTime
	 * @param phone
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateDriver(
			@RequestParam String id,// GET方式传入，在action中
			@RequestParam String name,
			@RequestParam String sex, 
			@RequestParam String IDCard,
			@RequestParam String licenceNum,
			@RequestParam String licenceRate,
			 @RequestParam String licenceTime, @RequestParam String phone, 
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入driver控制器update");
		String carrierId=(String)request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除

		boolean flag = carService.updateDriver(id, name, sex, IDCard, licenceNum, 
				licenceRate, licenceTime, phone, carrierId);
		System.out.println("flag+" + flag);
		if (flag == true) {
			try {
				System.out.println("redirect之前");
				response.sendRedirect("driver?flag=1");// 重定向，显示最新的结果
														// error,无法重定向
				// mv.setViewName("mgmt_r_car");
				System.out.println("redirect之后");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("driver更新后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;
	}
	
	@RequestMapping(value = "cardelete", method = RequestMethod.GET)
	/**
	 * 删除
	 */
	public ModelAndView deleteCar(
			@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("进入删除控制器");
		System.out.println(id);
		// 此处获取session里的carrierid，下面方法增加一个参数
		//String carrierId=(String)request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除
		boolean flag = carService.deleteCar(id);
		if (flag == true) {
			// mv.setViewName("mgmt_r_line");
			try {
				response.sendRedirect("car?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("删除后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;

	}
	@RequestMapping(value = "driverdelete", method = RequestMethod.GET)
	/**
	 * 删除
	 */
	public ModelAndView deleteDriver(
			@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("进入删除控制器");
		System.out.println(id);
		// 此处获取session里的carrierid，下面方法增加一个参数
		//String carrierId=(String)request.getSession().getAttribute("userId");
		// String carrierId = "C-0002";// 删除
		boolean flag = carService.deleteDriver(id);
		if (flag == true) {
			// mv.setViewName("mgmt_r_line");
			try {
				response.sendRedirect("driver?flag=1");// 重定向，显示最新的结果
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// 此处应该记录日志
				System.out.println("删除后重定向失败");
				e.printStackTrace();
			}
		} else
			mv.setViewName("fail");
		return mv;

	}
}
