package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.bean.search.LinetransportSearchBean;
import cn.edu.bjtu.util.DataModel;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;

public interface LinetransportService {


	public Linetransport getLinetransportInfo(String linetransportid);

	public boolean insertNewLinetransport(Linetransport line,HttpServletRequest request, MultipartFile file);

	public String getLinetransportIdByCity(String startPlace, String endPlace);
	
	public boolean deleteLine(String id);

	
	/**
	 * 资源栏获取筛选后的城市配送资源
	 * @param linetransportbean
	 * @param page
	 * @param session
	 * @return
	 */
	public DataModel getSelectedLineNew(LinetransportSearchBean linetransportbean,
			PageUtil page,HttpSession session);
	
	
	/**
	 * 资源栏筛选总条数
	 * @param lineBean
	 * @return
	 */
	public Integer getSelectedLineTotalRows(LinetransportSearchBean lineBean);
	
	/**
	 * 我的信息-我的干线资源
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public JSONArray getUserLinetransportResource(HttpSession session,PageUtil pageUtil);
	/**
	 * 我的信息-干线资源-总记录数
	 * @Title: getUserLinetransportResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午9:43:48
	 */
	public Integer getUserLinetransportResourceTotalRows(HttpSession session);
	
	/**
	 * 干线资源你更新
	 * @param line
	 * @param request
	 * @return
	 */
	public boolean updateLinetransport(Linetransport line,HttpServletRequest request,MultipartFile file);

	
	/**
	 * 获取公司的所有 干线资源
	 * @param carrierId
	 * @return
	 */
	public String getCompanyLinetransport(String carrierId);
	
}
