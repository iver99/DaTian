package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.SubAccount;

public interface SubAccountDao extends BaseDao<SubAccount>{
	public List getSubAccount(String userId);
	public List getFindSubAccount(String sql);
	public SubAccount getSubAccountDetail(String id);
	public boolean changeStatus(String id);
	public boolean deleteSubAccount(String id);
}
