package cn.edu.bjtu.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.service.GoodsInfoService;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;
@Transactional
@Repository
public class GoodsInfoServiceImpl implements GoodsInfoService{
	
	@Resource
	GoodsInfoDao goodsinfoDao;
	@Resource
	Goodsform goodsform;
	@Resource
	HQLTool hqltool;
	@Resource
	GoodsClientView goodsClientView;
	
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
		return hqltool.getTotalRows(sql);//这里的HQLTool实例千万不能自己new出来，用@Resource
	}
	
	@Override
	public GoodsClientView getAllGoodsDetail(String id) {
		// TODO Auto-generated method stub
		return goodsinfoDao.getAllGoodsDetail(id);
	}
	
	@Override
	/**
	 * 根据goodsid得到货物信息
	 */
	public Goodsform getMyGoodsDetail(String id) {
		// TODO Auto-generated method stub
		return goodsinfoDao.getMyGoodsDetail(id);
	}
	
	//@SuppressWarnings("deprecation")
	@Override
	public boolean insertGoods(String name, String type, float weight,
		String transportType, String transportReq, String startPlace, String endPlace,
		String damageReq, String VIPService, String oriented, String limitDate,
		String invoice, String remarks,String clientId,String path,
		String fileName) {
		// TODO Auto-generated method stub
		
		goodsform.setId(IdCreator.createGoodsId());
		goodsform.setName(name);
		goodsform.setType(type);
		goodsform.setWeight(weight);
		goodsform.setTransportType(transportType);
		goodsform.setTransportReq(transportReq);
		goodsform.setStartPlace(startPlace);
		goodsform.setEndPlace(endPlace);
		goodsform.setDamageReq(damageReq);
		goodsform.setVipservice(VIPService);
		goodsform.setOriented(oriented);
		goodsform.setLimitDate(stringToDate(limitDate));
		goodsform.setInvoice(invoice);
		goodsform.setRemarks(remarks);
		
		goodsform.setRelDate(new Date());
		goodsform.setState("待确认");
		goodsform.setClientId(clientId);
		
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			goodsform.setRelatedMaterial(fileLocation);
		}
		goodsinfoDao.save(goodsform);//保存实体
		return true;
		
	}

	@Override
	public boolean commitResponse(String goodsId, String remarks, String userId,String path,String fileName) {
		// TODO Auto-generated method stub
		return goodsinfoDao.commitResponse(goodsId,remarks,userId,path,fileName);
	}

	@Override
	public List getAllResponse(String userId) {
		// TODO Auto-generated method stub
		return goodsinfoDao.getAllResponse(userId);
	}

	@Override
	public List getUserGoodsInfo(String userId) {
		// TODO Auto-generated method stub
		
		return goodsinfoDao.getUserGoodsInfo(userId);
	}
	
	 public static Date stringToDate(String str) {  
	        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        Date date = null;  
	        try {  
	            // Fri Feb 24 00:00:00 CST 2012  
	            date = format.parse(str);   
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        // 2012-02-24  
	        date = java.sql.Date.valueOf(str);  
	                                              
	        return date;  
	} 
	
	 @Override
		public boolean updateGoods(String id, String name, String type, float weight,
			String transportType, String transportReq, String startPlace, String endPlace,
			String damageReq, String VIPService, String oriented, String limitDate,
			String invoice, String remarks,String clientId,String path, String fileName) {
			// TODO Auto-generated method stub
			goodsform = getMyGoodsDetail(id);

			goodsform.setName(name);
			goodsform.setType(type);
			goodsform.setWeight(weight);
			goodsform.setTransportType(transportType);
			goodsform.setTransportReq(transportReq);
			goodsform.setStartPlace(startPlace);
			goodsform.setEndPlace(endPlace);
			goodsform.setDamageReq(damageReq);
			goodsform.setVipservice(VIPService);
			goodsform.setOriented(oriented);
			goodsform.setLimitDate(stringToDate(limitDate));
			goodsform.setInvoice(invoice);
			goodsform.setRemarks(remarks);
			// 保存文件路径
			if (path != null && fileName != null) {
				String fileLocation = path + "//" + fileName;
				goodsform.setRelatedMaterial(fileLocation);
			}
			goodsinfoDao.update(goodsform);//保存实体
			return true;
			
		}
	 
	 @Override
	 public boolean deleteGoods(String id){
		 return goodsinfoDao.deleteGoods(id);
	 }

	@Override
	/**
	 * 确认反馈时修改货物状态为已确认
	 */
	public boolean confirmResponse(String goodsId) {
		// TODO Auto-generated method stub
		Goodsform goodsinfo=goodsinfoDao.getMyGoodsDetail(goodsId);	
		
		if(goodsinfo!=null){
			//修改货物状态为已确认
			goodsinfo.setState("已确认");
			goodsinfoDao.update(goodsinfo);
		}
		
		return true;

		
	}
	 
	 
	 
	 
}
