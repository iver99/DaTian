package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.FocusDao;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.vo.Address;
import cn.edu.bjtu.vo.Focus;
@Repository
public class FocusDaoImpl extends BaseDaoImpl<Focus> implements FocusDao{
	@Resource
	private HibernateTemplate ht;
	@Resource
	private HQLTool hqltool;
	/*@Resource
	BaseDao baseDao;*/
	
	@Override
	/**
	 * 返回是否获取到关注
	 */
	public List getFocusJudgement(String clientId, String focusType, String focusId) {
		
		return ht.find("from Focus where clientId='"+clientId+"' and focusType='"+focusType+"' and focusId='"+focusId+"'");
	}

	@Override
	/**
	 * 删除关注信息
	 */
	public boolean deleteFocus(String id) {
		
		Focus focus = ht.get(Focus.class, id);
		 this.delete(focus);
		 return true;
	}
	
	@Override
	public List getFocusList(String clientId,String focusType) {
		
		if(focusType != "")
			return ht.find("from Focus where clientId='"+clientId+"' and focusType='"+focusType+"'");
		else
			return ht.find("from Focus where clientId='"+clientId+"'");
	}
	
	@Override
	public List getAllFocusLine(String clientId) {
		
		return ht.find("from FocusLinetransportView where clientId='"+clientId+"'");
	}
	@Override
	public List getAllFocusCityline(String clientId) {
		
		return ht.find("from FocusCitylineView where clientId='"+clientId+"'");
	}
	@Override
	public List getAllFocusWarehouse(String clientId) {
		
		return ht.find("from FocusWarehouseView where clientId='"+clientId+"'");
	}
	@Override
	public List getAllFocusCar(String clientId) {
		
		return ht.find("from FocusCarView where clientId='"+clientId+"'");
	}
	@Override
	public List getAllFocusCompany(String clientId) {
		
		return ht.find("from FocusCompanyView where clientId='"+clientId+"'");
	}
	@Override
	public List getAllFocusGoods(String clientId) {
		
		return ht.find("from FocusGoodsView where clientId='"+clientId+"'");
	}

	@Override
	public List getFind(String sql) {
		
		return ht.find(sql);
	}
}
