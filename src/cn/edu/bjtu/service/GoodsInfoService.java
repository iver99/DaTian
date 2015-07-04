package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.search.CargoSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;

import com.alibaba.fastjson.JSONArray;

public interface GoodsInfoService {
	
	public GoodsClientView getAllGoodsDetail(String id);
	public Goodsform getMyGoodsDetail(String id);
	@Deprecated
	public List getSelectedGoodsInfo(String startPlace, String endPlace, String transportType, int Display,int PageNow);
	@Deprecated
	public int getTotalRows(String startPlace, String endPlace, String transportType);
	
	public boolean insertGoods(String name,
			String type,
			float weight,
			String transportType,
			String transportReq,
			String startPlace,
			String endPlace,
			String damageReq,
			String VIPService,
			String oriented,
			String limitDate,
			String invoice,
			String remarks,
			String clientId,
			String path,
			String fileName);
	
	public boolean updateGoods(String id, String name,
			String type,
			float weight,
			String transportType,
			String transportReq,
			String startPlace,
			String endPlace,
			String damageReq,
			String VIPService,
			String oriented,
			String limitDate,
			String invoice,
			String remarks,
			String clientId,
			String path,
			String fileName);
	
	public boolean commitResponse(String goodsId,String remarks,String userId,String path,String fileName);
	
	public List getAllResponse(String carrierId);
	@Deprecated
	public List getUserGoodsInfo(String clientId);
	
	public boolean deleteGoods(String id);
	
	/**
	 * 确认反馈，修改货物状态
	 * @param goodsId
	 * @return
	 */
	public boolean confirmResponse(String goodsId);
	
	/**
	 * 资源栏-货物-筛选
	 * @param cargoBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedCargoNew(CargoSearchBean cargoBean,PageUtil pageUtil,HttpSession session);
	
	/**
	 * 资源栏-货物总记录数
	 * @param cargoBean
	 * @return
	 */
	public Integer getSelectedCargoTotalRows(CargoSearchBean cargoBean);
	
	/**
	 * 我的信息-货物信息
	 * @Title: getUserCargoResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午4:59:36
	 */
	public JSONArray getUserCargoResource(HttpSession session,PageUtil pageUtil);
	
	/**
	 * 我的信息-货物in西
	 * @Title: getUserCargoTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午5:20:34
	 */
	public Integer getUserCargoTotalRows(HttpSession session);

}
