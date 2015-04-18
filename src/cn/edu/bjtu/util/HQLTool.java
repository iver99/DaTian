package cn.edu.bjtu.util;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 * hql工具类
 * @author RussWest0
 *
 */
@Component
public class HQLTool {
	@Resource
	public HibernateTemplate ht;
	
	public static HQL_POJO spellHql(HQL_POJO hql) {
		//System.out.println("flag+" + flag);
		if (hql.flag == false) {
			hql.hql = " where ";
			hql.flag = true;
		} else {
			hql.hql = " and ";

		}
		return hql;
	}
	
	/**
	 * 返回总记录数
	 * 
	 * @param hql
	 * @return
	 */
	public int getTotalRows(String hql) {
		int count = 0;
		//System.out.println("ht+"+ht);
		List list = ht.find("select count(*) " + hql);
		if (list != null)
			count = ((Number) list.get(0)).intValue();
		return count;
	}
	
	public List getQueryList(String hql,int page,int pageSize)
	{
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery(hql); // 创建hql语句
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		List list = query.list();
		session.close();
		
		return list;
	}
	
	public static String spellHql2(String hql,String[] paramList,String[] valueList)
	{
		HQL_POJO hqlobj=new HQL_POJO();
		//hqlobj.hql="from LineCarrierView ";//会变化
		hqlobj.hql=hql;
		for(int i=0;i<paramList.length;i++)
		{
			if(!(valueList[i].equals("All")))//要是等于all，说明是默认的，即不写到where子句
			{
				hqlobj.hql+= HQLTool.spellHql(hqlobj).hql;
				hqlobj.hql+=paramList[i]+"='"+valueList[i]+ "' ";
			}
		}
		return hqlobj.hql;
	}

	

}
