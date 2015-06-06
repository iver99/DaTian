package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.LinetransportDao;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.Linetransport;

@Repository
public class LinetransportDaoImpl extends BaseDaoImpl<Linetransport> implements LinetransportDao {

	@Resource
	private HibernateTemplate ht;
	@Resource
	private HQLTool hqltool;

	@Override
	/**
	 * 返回所有干线信息
	 */
	public List getAllLinetransport(int display, int pageNow) {
		// TODO Auto-generated method stub
		int page = pageNow;
		int pageSize = display;
		String hql = " from LineCarrierView";

		return hqltool.getQueryList(hql, page, pageSize);// dao层分批取数据方法

	}

	@Override
	public List getAllLinetransportWithoutPage() {
		// TODO Auto-generated method stub
		String hql = " from LineCarrierView";

		return ht.find(hql);// dao层分批取数据方法
	}
	
	@Override
	/**
	 * 返回具体干线信息
	 */
	public Linetransport getLinetransportInfo(String linetransportid) {
		// TODO Auto-generated method stub
		return ht.get(Linetransport.class, linetransportid);
	}

	@Override
	/**
	 * 返回公司干线列表
	 */
	public List getCompanyLine(String carrierId, int display, int pageNow) {
		// TODO Auto-generated method stub
		int page = pageNow;
		int pageSize = display;
		String hql = "from Linetransport as s where s.carrierId='" + carrierId
				+ "'";

		return hqltool.getQueryList(hql, page, pageSize);// dao层分批取数据方法
	}

	@Override
	public List getSelectedLine(String hql, int display, int pageNow) {
		// TODO Auto-generated method stub
		// System.out.println("hql+"+hql);
		int page = pageNow;
		int pageSize = display;

		return hqltool.getQueryList(hql, page, pageSize);// Dao层分页函数提取到此方法

	}

	@Override
	/**
	 * 返回公司干线总条数
	 */
	public int getCompanyTotalRows(String carrierId) {
		// TODO Auto-generated method stub
		int count = 0;
		List list = ht.find("select count(*) from Cityline where carrierId='"+carrierId+"'");
		if (list != null)
			count = ((Number) list.get(0)).intValue();
		return count;
	}


	
	

}
