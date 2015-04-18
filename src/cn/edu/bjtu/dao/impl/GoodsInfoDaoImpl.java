package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.GoodsClientView;

@Repository
public class GoodsInfoDaoImpl implements GoodsInfoDao{
	
	@Resource
	private HibernateTemplate ht;
	@Resource
	private HQLTool hqltool;
	
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
}
