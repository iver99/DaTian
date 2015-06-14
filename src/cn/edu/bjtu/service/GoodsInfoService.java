package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.search.CargoSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;

import com.alibaba.fastjson.JSONArray;

public interface GoodsInfoService {

	public List getAllGoodsInfo(int Display,int PageNow);
	public GoodsClientView getAllGoodsDetail(String id);
	public Goodsform getMyGoodsDetail(String id);
	
	public List getSelectedGoodsInfo(String startPlace, String endPlace, String transportType, int Display,int PageNow);
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
}
