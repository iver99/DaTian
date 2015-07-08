package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;

public interface GoodsInfoDao extends BaseDao<Goodsform>{
	
	@Deprecated
	public List getSelectedGoodsInfo(String hql,int Display,int PageNow);
	
	public GoodsClientView getAllGoodsDetail(String id);
	public Goodsform getMyGoodsDetail(String id);
	
	public boolean commitResponse(String goodsId,String remarks,String userId,String path,String fileName);
	@Deprecated
	public List getAllResponse(String carrierId);
	@Deprecated
	public List getUserGoodsInfo(String clientId);
	
	public boolean deleteGoods(String id);
}
