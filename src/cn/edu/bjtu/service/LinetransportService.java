package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.search.LinetransportSearchBean;
import cn.edu.bjtu.util.DataModel;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;

public interface LinetransportService {

	public List getAllLinetransport(int Display,int PageNow);

	public Linetransport getLinetransportInfo(String linetransportid);

	@Deprecated
	public List getSelectedLine(String startPlace, String endPlace,
			String type, String startPlace1, String refPrice,int Display,int PageNow);

	public boolean insertLine(String lineName, String startPlace,
			String endPlace, int onWayTime, String type, float refPrice,
			String remarks, String carrierId,String path,String fileName);

	public List getCompanyLine(String carrierId,int Display,int PageNow);

	public String getLinetransportIdByCity(String startPlace, String endPlace);

	public boolean updateLine(String id, String lineName, String startPlace,
			String endPlace, int onWayTime, String type, float refPrice,
			String remarks, String carrierId,String path,String fileName);
	@Deprecated
	public int getTotalRows(String startPlace, String endPlace,
			String type, String startPlace1, String refPrice);
	@Deprecated
	public int getCompanyTotalRows(String carrierId);
	
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

	
}
