package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.ContractDao;

import cn.edu.bjtu.vo.Contract;
import cn.edu.bjtu.vo.SubAccount;
@Repository
/**
 * 合同dao层实现
 * @author RussWest0
 *
 */
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao{

	@Resource
	HibernateTemplate ht;
	
	Contract contract=null;
	@Override
	/**
	 * 返回公司合同
	 */
	public List getCompanyContract(String carrierId) {
		
		return ht.find("from Contract where carrierId='"+carrierId+"'");
	}
	
	/*@Override
	public List getCompanyContractForUser(String clientId) {
		
		return this.find("from Contract where clientId='"+clientId+"'");
	}*/
	
	@Override
	/**
	 * 返回合同信息
	 */
	public Contract getContractInfo(String contractId) {
		
		return ht.get(Contract.class, contractId);
	}
	@Override
	/**
	 * 终止合同
	 */
	public boolean shutdownContract(String contractId, String reason) {
		
		contract=ht.get(Contract.class, contractId);
		contract.setState("已终止");//更新状态
		contract.setReason(reason);
		/*baseDao.update(contract);		*/
		this.update(contract);
		return true;
	}
	
	
	@Override
	public boolean changeStatus(String id) {
		
		Contract contract = (Contract) ht.get(Contract.class, id);
		String temp="";
		temp=contract.getState();
		if(temp.equals("待确认")){
			contract.setState("有效");// 修改状态
		}

		//return baseDao.update(subAccount);
		this.update(contract);
		return true;
	}
	
}
