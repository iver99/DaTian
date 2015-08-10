package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.SubAccountBean;
import cn.edu.bjtu.util.PageUtil;
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
	
	/**
	 * 附属账户-列表
	 * @Title: getSubAccountList 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月27日 下午4:07:01
	 */
	public String getSubAccountList(HttpSession session,SubAccount subAccount,PageUtil pageUtil);
	
	/**
	 * 附属账户-总记录数
	 * @Title: getSubAccountTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月27日 下午4:07:28
	 */
	public Integer getSubAccountTotalRows(HttpSession session,SubAccount subAccount);
	
	/**
	 * 检查附属账户是否存在
	 * @param username
	 * @return
	 */
	public boolean checkSubAccountUsername(String username);
}
