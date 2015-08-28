package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Focus;

public interface FocusDao extends BaseDao<Focus>{
	public List getFocusJudgement(String clientId, String focusType, String focusId);

	public boolean deleteFocus(String id);
	
	public List getFocusList(String clientId,String focusType);

	public List getFind(String sql);
}
