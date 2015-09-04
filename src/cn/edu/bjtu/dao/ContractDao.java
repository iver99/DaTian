package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Contract;

public interface ContractDao extends BaseDao<Contract>{
	public List getCompanyContract(String carrierId);
	public Contract getContractInfo(String contractId);
	public boolean shutdownContract(String contractId,String reason);
	public boolean changeStatus(String id);
	//public List getCompanyContractForUser(String clientId);
}
