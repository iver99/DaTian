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
		// TODO Auto-generated method stub
		//System.out.println("from Focus where clientId='"+clientId+"' and focusType='"+focusType+"' and focusId='"+focusId+"'");
		return ht.find("from Focus where clientId='"+clientId+"' and focusType='"+focusType+"' and focusId='"+focusId+"'");
	}

	@Override
	/**
	 * 删除关注信息
	 */
	public boolean deleteFocus(String id) {
		// TODO Auto-generated method stub
		Focus focus = ht.get(Focus.class, id);
		 this.delete(focus);
		 return true;
	}

}
