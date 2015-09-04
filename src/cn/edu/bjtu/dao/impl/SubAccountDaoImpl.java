package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.SubAccountDao;

import cn.edu.bjtu.vo.SubAccount;


@Repository

/**
 * 子账户dao层实现
 *
 */
public class SubAccountDaoImpl extends BaseDaoImpl<SubAccount> implements SubAccountDao{

	
	@Override
	public List getSubAccount(String userId) {
		
		return this.find("from SubAccount where hostAccountId='"+userId+"'");
	}
	
	@Override
	public boolean changeStatus(String id){
		
		SubAccount subAccount = this.get(SubAccount.class, id);
		String temp="";
		temp=subAccount.getStatus();
		if(temp.equals("已停用")){
			subAccount.setStatus("正常");// 修改状态
		}
		else if(temp.equals("正常")){
			subAccount.setStatus("已停用");// 修改状态
		}

		//return baseDao.update(subAccount);
		this.save(subAccount);
		return true;
	}
	
	@Override
	public boolean deleteSubAccount(String id){
		
		SubAccount subAccount =this.get(SubAccount.class, id);
		this.delete(subAccount);
		 return true;
	}
}
