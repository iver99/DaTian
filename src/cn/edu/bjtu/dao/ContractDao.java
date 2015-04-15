package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Contract;

public interface ContractDao {
	public List getCompanyContract(String carrierId);
	public Contract getContractInfo(String contractId);
	public boolean shutdownContract(String contractId,String reason);
	public List getFindContract(String hql, int display, int pageNow);
}
