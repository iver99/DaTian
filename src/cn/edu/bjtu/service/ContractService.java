package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Contract;

import com.alibaba.fastjson.JSONArray;

/**
 * 
 * @author RussWest0
 *
 */
public interface ContractService {

	public Contract getContractInfo(String contractId);
	public boolean insertNewContract(Contract contract,HttpServletRequest request,MultipartFile file);
	public boolean shutdownContract(String contractId,String reason);

	public boolean changeStatus(String id);

	public List<Contract> getContractByClientId(String clientId);
	
	/**
	 * 我的信息-合同信息
	 * @Title: getUserContract 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONObject 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午5:44:24
	 */
	public JSONArray getUserContract(HttpSession session,PageUtil pageUtil,Contract contract);
	
	/**
	 * 我的信息-合同信息-总记录数
	 * @Title: getUserContractTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 下午5:46:09
	 */
	public Integer getUserContractTotalRows(HttpSession session,Contract contract);
	
	

}
