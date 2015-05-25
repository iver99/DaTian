package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.vo.Focus;

public interface FocusService extends BaseDao<Focus>{
	public boolean insertFocus(String clientId, String foucsType, String foucsId);
	public List getFocusJudgement(String clientId, String foucsType, String foucsId);
	public boolean deleteFocus(String id);
	public List getFocusList(String clientId,String focusType);

	public List getAllFocusLine(String clientId);
	public List getAllFocusCityline(String clientId);
	public List getAllFocusWarehouse(String clientId);
	public List getAllFocusCar(String clientId);
	public List getAllFocusCompany(String clientId);
	public List getAllFocusGoods(String clientId);
}
