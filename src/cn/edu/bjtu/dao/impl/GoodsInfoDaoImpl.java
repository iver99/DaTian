package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.GoodsClientView;
import cn.edu.bjtu.vo.Goodsform;

@Repository
public class GoodsInfoDaoImpl implements GoodsInfoDao{
	
	@Resource
	private HibernateTemplate ht;
	@Resource
	private HQLTool hqltool;
	
	@Resource
	private BaseDao baseDao;
	
	@Override
	/**
	 * 返回所有城市信息
	 */
	public List getAllGoodsInfo(int Display,int PageNow) {
		// TODO Auto-generated method stub
		
		int page = PageNow;
		int pageSize = Display;
		String hql=" from GoodsClientView";
		System.out.println("hql+goods"+hql);
		return hqltool.getQueryList(hql, page, pageSize);//dao层分批取数据方法
		
	}
	
	public GoodsClientView getAllGoodsDetail(String id) {
		// TODO Auto-generated method stub
		
		return ht.get(GoodsClientView.class,id);
		
	}
	
	@Override
	public List getSelectedGoodsInfo(String hql, int display, int pageNow) {
		// TODO Auto-generated method stub
		//System.out.println("hql+"+hql);
		int page = pageNow;
		int pageSize = display;

		return hqltool.getQueryList(hql, page, pageSize);//Dao层分页函数提取到此方法
	}

	@Override
	/**
	 * 提交反馈Dao
	 */
	public boolean commitResponse(String goodsId, String remarks, String userId) {
		// TODO Auto-generated method stub
		Goodsform goods=ht.get(Goodsform.class, goodsId);
		goods.setRemarks(remarks);
		goods.setCarrierId(userId);
		// 修改状态
		goods.setState("待确认");
		return baseDao.update(goods);
	}

	@Override
	public List getAllResponse(String carrierId) {
		// TODO Auto-generated method stub
		return ht.find("from Goodsform where clientId='"+carrierId+"'");
	}

	@Override
	public List getUserGoodsInfo(String clientId) {
		// TODO Auto-generated method stub
		return ht.find("from Goodsform where clientId='"+clientId+"'");
	}
	
	
	
}
