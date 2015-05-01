package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;

public interface GoodsInfoDao {
	
	public List getAllGoodsInfo(int Display,int PageNow);
	public List getSelectedGoodsInfo(String hql,int Display,int PageNow);
	
	public GoodsClientView getAllGoodsDetail(String id);
	public Goodsform getMyGoodsDetail(String id);
	
	public boolean commitResponse(String goodsId,String remarks,String userId);
	
	public List getAllResponse(String carrierId);
	
	public List getUserGoodsInfo(String clientId);
	
	public boolean deleteGoods(String id);
}
