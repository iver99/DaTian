package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.SubAccountBean;
import cn.edu.bjtu.vo.SubAccount;

public interface SubAccountService {

	public List getSubAccount(String userId);
	public List getFindSubAccount(String userId, String username);
	public boolean changeStatus(String id);
	public boolean deleteSubAccount(String id);
	@Deprecated
	public boolean insertSubAccount(String username,String password,String resourceManagement,
			String transactionManagement,String schemaManagement,
			String statisticsManagement,String remarks,
			String hostAccountId,String hostAccountName);
	
	/**
	 * 更新附属账户
	 * @param subAccountBean
	 * @param session
	 * @return
	 */
	public boolean updateSubAccount(SubAccountBean subAccountBean,HttpSession session);
	
	/*
	 * 添加附属账户
	 */
	public boolean addNewSubAccount(SubAccountBean subAccountBean,HttpSession session);
	
	/**
	 * 获取附属账户
	 * @param id
	 * @return
	 */
	public SubAccount getSubAccountDetail(String id);
}
