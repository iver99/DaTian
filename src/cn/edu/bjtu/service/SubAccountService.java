package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.SubAccount;

public interface SubAccountService {

	public List getSubAccount(String userId);
	public List getFindSubAccount(String userId, String username);
	public SubAccount getSubAccountDetail(String id);
	public boolean changeStatus(String id);
	public boolean deleteSubAccount(String id);
	
	public boolean insertSubAccount(String username,String password,String resourceManagement,
			String transactionManagement,String schemaManagement,
			String statisticsManagement,String remarks,
			String hostAccountId,String hostAccountName);
	
	public boolean updateSubAccount(String id, String username,String password,String resourceManagement,
			String transactionManagement,String schemaManagement,
			String statisticsManagement,String remarks);
}
