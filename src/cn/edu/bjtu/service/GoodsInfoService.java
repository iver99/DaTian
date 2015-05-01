package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;

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
			String clientId);
	
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
			String clientId);
	
	public boolean commitResponse(String goodsId,String remarks,String userId);
	
	public List getAllResponse(String carrierId);
	
	public List getUserGoodsInfo(String clientId);
	
	public boolean deleteGoods(String id);
	
}
