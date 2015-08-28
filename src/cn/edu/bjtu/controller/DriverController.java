package cn.edu.bjtu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.vo.Driverinfo;

/**
 * 司机相关的控制器
 * @author russwest
 * @date   2015年8月28日 下午2:05:14
 */
@Controller
public class DriverController {
	@Autowired
	DriverService driverService;
	
	ModelAndView mv = new ModelAndView();
	/**
	 * 获取司机列表
	 * @param flag
	 * @return
	 */
	@RequestMapping("driver")
	@Deprecated
	public ModelAndView getAllDriver(@RequestParam int flag,
			HttpServletRequest request, HttpServletResponse response) {
		// 从session里取出id查询
		if (flag == 0) {// 所有的司机信息
			List driverList = driverService.getAllDriver();
			mv.addObject("driverList", driverList);
			mv.setViewName("mgmt_r_driver");
		} else if (flag == 1) {// 公司司机列表
			// 这里用session取id
			String carrierId = (String) request.getSession().getAttribute(
					"userId");
			// String carrierId = "C-0002";// 删除
			List driverList = driverService.getCompanyDriver(carrierId);
			mv.addObject("driverList", driverList);
			mv.setViewName("mgmt_r_driver");
		}

		return mv;
	}

	/**
	 * 司机信息详情
	 * @param driverId
	 * @param flag
	 * @return
	 */
	@RequestMapping("driverdetail")
	public ModelAndView getDriverInfo(@RequestParam String driverId,
			@RequestParam int flag) {
		Driverinfo driver = driverService.getDriverInfo(driverId);
		mv.addObject("driver", driver);
		if (flag == 1) {// 对应司机详情
			mv.setViewName("mgmt_r_driver4");
		} else if (flag == 2)// 对应司机更新
		{
			mv.setViewName("mgmt_r_driver3");
		}

		return mv;
	}
}
