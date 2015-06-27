package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.SubAccountDao;
import cn.edu.bjtu.service.SubAccountService;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.SubAccount;


@Transactional
@Service("subAccountServiceImpl")
/**
 * 子账户服务层实现 
 * 
 *
 */
public class SubAccountServiceImpl implements SubAccountService{
	
	@Resource
	HibernateTemplate ht;
	@Resource 
	SubAccountDao subAccountDao;
	/*@Resource 
	BaseDao baseDao;*/
	@Resource
	HQLTool hqltool;
	@Resource
	SubAccount subAccount;
	
	@Override
	/**
	 * 获取子账户列表
	 */
	public List getSubAccount(String userId) {
		
		
		return subAccountDao.getSubAccount(userId);
	}
	
	@Override
	public List getFindSubAccount(String userId, String username){
		String sql="from SubAccount where hostAccountId='"+userId+"' ";
		
		if(username.equals("账户名称")){
			//查找时不考虑用户名字
			username = "";
			sql+=" and username like '%"+username+"%' ";
		}
		else if(username.contains("-")){
			String[] temp=username.split("-");
			if (temp.length<=1);
			else{
				String hostAccountNam=temp[0];
				String usernam=temp[1];
				sql+=" and username like '%"+usernam+"%' and hostAccountName like '%"+hostAccountNam+"%'";
			}	
			
		}
		else sql+=" and username like '%"+username+"%' or hostAccountName like '%"+username+"%'";
		return subAccountDao.getFindSubAccount(sql);
	}
	
	@Override
	public SubAccount getSubAccountDetail(String id){
		
		return subAccountDao.getSubAccountDetail(id);
	}
	
	@Override
	public boolean changeStatus(String id){
		return subAccountDao.changeStatus(id);
	}
	
	@Override
	public boolean deleteSubAccount(String id){
		return subAccountDao.deleteSubAccount(id);
	}
	
	@Override
	/**
	 * 添加新的附属账户
	 */
	public boolean insertSubAccount(String username,String password,String resourceManagement,
			String transactionManagement,String schemaManagement,
			String statisticsManagement,String remarks,
			String hostAccountId,String hostAccountName){
		
		if(resourceManagement==null){
			resourceManagement = new String("无");}
		else if (resourceManagement.equals("on"))
		{resourceManagement = new String("有");}
		if(transactionManagement==null){
			transactionManagement = new String("无");}
		else if (transactionManagement.equals("on"))
		{transactionManagement = new String("有");}
		if(schemaManagement==null){
			schemaManagement = new String("无");}
		else if (schemaManagement.equals("on"))
		{schemaManagement = new String("有");}
		if(statisticsManagement==null){
			statisticsManagement = new String("无");}
		else if (statisticsManagement.equals("on"))
		{statisticsManagement = new String("有");}
		
		subAccount.setId(IdCreator.createSubAccountId());
		subAccount.setUsername(username);
		subAccount.setPassword(password);
		subAccount.setResourceManagement(resourceManagement);
		subAccount.setTransactionManagement(transactionManagement);
		subAccount.setSchemaManagement(schemaManagement);
		subAccount.setStatisticsManagement(statisticsManagement);
		subAccount.setRemarks(remarks);
		subAccount.setHostAccountId(hostAccountId);
		subAccount.setHostAccountName(hostAccountName);
		subAccount.setRelDate(new Date());
		subAccount.setStatus("正常");
		
		subAccountDao.save(subAccount);
		return true;
	}
	
	@Override
	public boolean updateSubAccount(String id, String username,String password,String resourceManagement,
			String transactionManagement,String schemaManagement,
			String statisticsManagement,String remarks){
		
		if(resourceManagement==null){
			resourceManagement = new String("无");}
		else if (resourceManagement.equals("on"))
		{resourceManagement = new String("有");}
		if(transactionManagement==null){
			transactionManagement = new String("无");}
		else if (transactionManagement.equals("on"))
		{transactionManagement = new String("有");}
		if(schemaManagement==null){
			schemaManagement = new String("无");}
		else if (schemaManagement.equals("on"))
		{schemaManagement = new String("有");}
		if(statisticsManagement==null){
			statisticsManagement = new String("无");}
		else if (statisticsManagement.equals("on"))
		{statisticsManagement = new String("有");}
		
		subAccount = subAccountDao.getSubAccountDetail(id);// 根据id查找到子账户

		subAccount.setUsername(username);
		subAccount.setPassword(password);
		subAccount.setResourceManagement(resourceManagement);
		subAccount.setTransactionManagement(transactionManagement);
		subAccount.setSchemaManagement(schemaManagement);
		subAccount.setStatisticsManagement(statisticsManagement);
		subAccount.setRemarks(remarks);
		
		 subAccountDao.update(subAccount);
		 return true;
	}
	
}
