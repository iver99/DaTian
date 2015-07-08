package cn.edu.bjtu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.dao.ContractDao;
import cn.edu.bjtu.service.ContractService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.ParseDate;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Contract;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Transactional
@Service("contractServiceImpl")
/**
 * 合同服务层实现 
 * @author RussWest0
 *
 */
public class ContractServiceImpl implements ContractService{

	@Resource
	ContractDao contractDao;
	@Resource 
	Contract contract;
	@Resource
	HQLTool hqltool;

	
	@Override
	/**
	 * 获取公司合同
	 */
	@Deprecated
	public List getCompanyContract(String carrierId) {
		
		
		return contractDao.getCompanyContract(carrierId);
	}
	
	
	@Override
	public List<Contract> getContractByClientId(String clientId) {
		
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", clientId);
		String hql="from Contract where clientId=:clientId";
		return contractDao.find(hql,params);
	}

	@Override
	/**
	 * 获取合同信息
	 */
	public Contract getContractInfo(String contractId) {
		
		return contractDao.getContractInfo(contractId);
	}
	@Override
	/**
	 * 新增合同
	 */
	public boolean insertNewContract(Contract contract,HttpServletRequest request,MultipartFile file){
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//保存文件
		String fileLocation=UploadFile.uploadFile(file, carrierId, "contract");

		
		//设置文件位置 
		contract.setRelatedMaterial(fileLocation);
		contractDao.save(contract);// 保存实体
		return true;
	}
	@Deprecated
	public boolean insertContract(String id,String name, String caculateType,
			String carrierAccount, String carrierId, String startDate, String endDate,
			String contact, String phone, String remarks, String clientId,
			String monthlyStatementDays,String path, String fileName) {
		
		contract.setCaculateType(caculateType);
		contract.setCarrierAccount(carrierAccount);
		contract.setClientId(clientId);
		contract.setCarrierId(carrierId);
		contract.setContact(contact);
		contract.setEndDate(ParseDate.parseDate(startDate));
		contract.setStartDate(ParseDate.parseDate(endDate));
		contract.setName(name);
		contract.setPhone(phone);
		contract.setRemarks(remarks);
		contract.setId(id);
		contract.setState("待确认");
		if(monthlyStatementDays != ""){
			contract.setMonthlyStatementDays(monthlyStatementDays);
		}
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			contract.setRelatedMaterial(fileLocation);
		}
		contractDao.save(contract);//保存实体
		return true;
		
	}
	@Override
	/**
	 * 终止合同
	 */
	public boolean shutdownContract(String contractId, String reason) {
		
		return contractDao.shutdownContract(contractId,reason);
	}
	
	@Override
	/**
	 * 查询合同（需求方）
	 */
	public List getFindContract(String clientId,String startDate,String endDate,String name,int Display,int PageNow){
		String sql="from Contract where clientId='"+clientId+"' and ";
		if(name.equals("合同名称")){
			//查找时不考虑合同名字
			name = "";
		}
		if(!startDate.equals("开始时间")){
			if(!endDate.equals("结束时间")){
				//查询时有开始和截止时间
				sql+=" startDate >= '"+startDate+"' and endDate <= '"+endDate+"' and name like '%"+name+"%'";
				
			}
			else{
				//只有开始日期没有截止日期
				sql+=" startDate >= '"+startDate+"' and name like '%"+name+"%'";
				
			}
		}
		else if(!endDate.equals("结束时间")){
			//只有结束时间没有开始时间
			sql+=" endDate <= '"+endDate+"' and name like '%"+name+"%'";
			
		}
		else{
			//没有时间限制
			sql+=" name like '%"+name+"%'";
		}
		return contractDao.getFindContract(sql, Display, PageNow);
	}
	
	@Override
	/**
	 * 查询合同（承运方）
	 */
	public List getFindContract2(String carrierId,String startDate,String endDate,String name,int Display,int PageNow){
		String sql="from Contract where carrierId='"+carrierId+"' and ";
		if(name.equals("合同名称")){
			//查找时不考虑合同名字
			name = "";
		}
		if(!startDate.equals("开始时间")){
			if(!endDate.equals("结束时间")){
				//查询时有开始和截止时间
				sql+=" startDate >= '"+startDate+"' and endDate <= '"+endDate+"' and name like '%"+name+"%'";
				
			}
			else{
				//只有开始日期没有截止日期
				sql+=" startDate >= '"+startDate+"' and name like '%"+name+"%'";
				
			}
		}
		else if(!endDate.equals("结束时间")){
			//只有结束时间没有开始时间
			sql+=" endDate <= '"+endDate+"' and name like '%"+name+"%'";
			
		}
		else{
			//没有时间限制
			sql+=" name like '%"+name+"%'";
		}
		return contractDao.getFindContract(sql, Display, PageNow);
	}
	
	@Override
	/**
	 * 查询合同的结果页数
	 */
	public int getFindContractTotalRows(String carrierId,String startDate,String endDate,String name,int Display,int PageNow){
		String sql="from Contract where carrierId='"+carrierId+"' and ";
		if(name.equals("合同名称")){
			//查找时不考虑合同名字
			name = "";
		}
		if(!startDate.equals("开始时间")){
			if(!endDate.equals("结束时间")){
				//查询时有开始和截止时间
				sql+=" startDate >= '"+startDate+"' and endDate <= '"+endDate+"' and name like '%"+name+"%'";
				
			}
			else{
				//只有开始日期没有截止日期
				sql+=" startDate >= '"+startDate+"' and name like '%"+name+"%'";
				
			}
		}
		else if(!endDate.equals("结束时间")){
			//只有结束时间没有开始时间
			sql+=" endDate <= '"+endDate+"' and name like '%"+name+"%'";
			
		}
		else{
			//没有时间限制
			sql+=" name like '%"+name+"%'";
		}
		return hqltool.getTotalRows(sql);// 这里的HQLTool实例千万不能自己new出来，用@Resource
	}
	@Override
	public boolean changeStatus(String id) {
		
		return contractDao.changeStatus(id);
	}
	
	/**
	 * 我的信息-合同信息
	 */
	@Override
	public JSONArray getUserContract(HttpSession session,PageUtil pageUtil) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String hql="from Contract t where ";
		if(userKind == 2){//个人用户
			hql+="t.clientId=:userId";
		}else if(userKind == 3){//企业用户
			hql+="t.carrierId=:userId";
		}
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("userId", userId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Contract> contractList = contractDao.find(hql, params,page,display);
		JSONArray jsonArray = new JSONArray();
		for (Contract contract : contractList) {
			JSONObject jsonObject = (JSONObject) JSONObject.toJSON(contract);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;

	}

	/**
	 * 我的信息-合同信息-总记录数
	 */
	@Override
	public Integer getUserContractTotalRows(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String hql="select count(*) from Contract t where ";
		if(userKind == 2){//个人用户
			hql+="t.clientId=:userId";
		}else if(userKind == 3){//企业用户
			hql+="t.carrierId=:userId";
		}
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("userId", userId);
		
		Long count=contractDao.count(hql, params);
		return count.intValue();
	}

}
