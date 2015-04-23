package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.GoodsClientView;

public interface GoodsInfoDao {
	
	public List getAllGoodsInfo(int Display,int PageNow);
	public List getSelectedGoodsInfo(String hql,int Display,int PageNow);
	
	public GoodsClientView getAllGoodsDetail(String id);
	
	public boolean commitResponse(String goodsId,String remarks,String userId);
	
	public List getAllResponse(String userId);
}
