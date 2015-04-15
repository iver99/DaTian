package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.GoodsClientView;

public interface GoodsInfoService {

	public List getAllGoodsInfo(int Display,int PageNow);
	public GoodsClientView getAllGoodsDetail(String id);
	
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
			String vipservice,
			String oriented,
			String limitDate,
			String invoice,
			String relatedMaterial,
			String remarks);

}
