package cn.edu.bjtu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.FocusDao;
import cn.edu.bjtu.dao.impl.BaseDaoImpl;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Focus;

@Service
@Transactional
public class FocusServiceImpl extends BaseDaoImpl<Focus> implements FocusService {
	
	@Resource
	HibernateTemplate ht;
	/*@Resource 
	BaseDao baseDao;*/
	@Autowired
	FocusDao focous;
	@Resource 
	Focus focus;
	@Autowired
	FocusDao focusDao;

	@Override
	/**
	  * 添加关注
	  */
	public boolean insertFocus(String clientId, String foucsType, String foucsId){
		
		focus.setId(IdCreator.createFocusId());
		focus.setClientId(clientId);
		focus.setFocusType(foucsType);
		focus.setFocusId(foucsId);
		focus.setStatus("有效");
		focusDao.save(focus);
		return true;
	}

	@Override
	/**
	  * 判断某条信息是否已被关注 
	  */
	public List getFocusJudgement(String clientId, String focusType,
			String foucsId) {
		// TODO Auto-generated method stub
		return focusDao.getFocusJudgement(clientId,focusType,foucsId);
	}

	@Override
	/**
	  * 删除关注 
	  */
	public boolean deleteFocus(String id){
		return focusDao.deleteFocus(id);
	}
	@Override
	/**
	 * 关注列表获取
	 */
	public List getFocusList(String clientId,String focusType) {
		// TODO Auto-generated method stub
		return focusDao.getFocusList(clientId,focusType);
	}
	
	@Override
	/**
	 * 我的关注列表获取
	 */
	public List getAllFocusLine(String clientId){
		return focusDao.getAllFocusLine(clientId);
	}
	@Override
	public List getAllFocusCityline(String clientId){
		return focusDao.getAllFocusCityline(clientId);
	}
	@Override
	public List getAllFocusWarehouse(String clientId){
		return focusDao.getAllFocusWarehouse(clientId);
	}
	@Override
	public List getAllFocusCar(String clientId){
		return focusDao.getAllFocusCar(clientId);
	}
	@Override
	public List getAllFocusCompany(String clientId){
		return focusDao.getAllFocusCompany(clientId);
	}
	@Override
	public List getAllFocusGoods(String clientId){
		return focusDao.getAllFocusGoods(clientId);
	}
	
}
