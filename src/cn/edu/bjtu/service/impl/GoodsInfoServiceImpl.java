package cn.edu.bjtu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.service.GoodsInfoService;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;

@Repository
public class GoodsInfoServiceImpl implements GoodsInfoService{
	
	@Resource
	GoodsInfoDao goodsinfoDao;
	@Resource
	Goodsform goodsform;
	@Resource
	BaseDao baseDao;
	@Resource
	HQLTool hqltool;
	
	@Override
	public List getAllGoodsInfo(int Display,int PageNow) {
		// TODO Auto-generated method stub
		return goodsinfoDao.getAllGoodsInfo(Display, PageNow);
	}
	
	@Override
	/**
	 * 条件筛选干线线路
	 */
	public List getSelectedGoodsInfo(String startPlace, String endPlace,
			String transportType, int Display,int PageNow) {
		
		String [] paramList={"startPlace","endPlace","transportType"};//没startplace1 
		String [] valueList={startPlace,endPlace,transportType};
		String hql="from GoodsClientView ";//会变化
		String sql=HQLTool.spellHql2(hql,paramList, valueList);
		//System.out.println("hql+" + sql);
		return goodsinfoDao.getSelectedGoodsInfo(sql,Display,PageNow);
	}
	
	@Override
	/**
	 * 获取总记录条数 
	 */
	public int getTotalRows(String startPlace, String endPlace, String transportType) {
		// TODO Auto-generated method stub
		String [] paramList={"startPlace","endPlace","transportType"};//没startplace1 
		String [] valueList={startPlace,endPlace,transportType};
		String hql="from GoodsClientView ";//会变化
		String sql=HQLTool.spellHql2(hql,paramList, valueList);
		//System.out.println("hql+"+sql);
		return hqltool.getTotalRows(sql);//这里的HQLTool实例千万不能自己new出来，用@Resource
	}
	
	@Override
	public GoodsClientView getAllGoodsDetail(String id) {
		// TODO Auto-generated method stub
		return goodsinfoDao.getAllGoodsDetail(id);
	}
	
	@Override
	public boolean insertGoods(String name, String type, float weight,
		String transportType, String transportReq, String startPlace, String endPlace,
		String damageReq, String vipservice, String oriented, String limitDate,
		String invoice, String relatedMaterial, String remarks) {
		// TODO Auto-generated method stub
		System.out.println("insertGoods");
		goodsform.setId(IdCreator.createlineTransportId());
		goodsform.setName(name);
		goodsform.setType(type);
		goodsform.setTransportType(transportType);
		goodsform.setTransportReq(transportReq);
		goodsform.setStartPlace(startPlace);
		goodsform.setEndPlace(endPlace);
		goodsform.setDamageReq(damageReq);
		goodsform.setVipservice(vipservice);
		goodsform.setOriented(oriented);
		//goodsform.setLimitDate(limitDate);
		goodsform.setInvoice(invoice);
		goodsform.setRelatedMaterial(relatedMaterial);
		goodsform.setRemarks(remarks);
		
		return baseDao.save(goodsform);//保存实体
		
	}
}
