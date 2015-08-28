package cn.edu.bjtu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.ContractDao;
import cn.edu.bjtu.service.ContractService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.ParseDate;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Contract;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mchange.io.impl.EndsWithFilenameFilter;
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
	@Autowired
	CompanyDao companyDao;

	
	
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
	/**
	 * 新增合同
	 */
	@Override
	public boolean insertNewContract(Contract contract,HttpServletRequest request,MultipartFile file){
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//保存文件
		String fileLocation=UploadFile.uploadFile(file, userId, "contract");
		contract.setCarrierId(contract.getCarrierId());
		contract.setClientId(userId);
		contract.setState("待确认");//新建合同的初始状态为待确认  
		
		Carrierinfo company=companyDao.get(Carrierinfo.class, contract.getCarrierId());
		contract.setCarrierAccount(company.getCompanyName());
		
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
	public boolean changeStatus(String id) {
		
		return contractDao.changeStatus(id);
	}
	
	/**
	 * 我的信息-合同信息
	 */
	@Override
	public JSONArray getUserContract(HttpSession session,PageUtil pageUtil,Contract contract) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Contract t "+whereHql(contract,params);
		if(userKind == 2){//个人用户
			hql+=" and t.clientId=:userId";
		}else if(userKind == 3){//企业用户
			hql+=" and t.carrierId=:userId";
		}
		hql+=" order by t.startDate desc";
		params.put("userId", userId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Contract> contractList = contractDao.find(hql, params,page,display);
		JSONArray jsonArray = new JSONArray();
		for (Contract contractIns : contractList) {
			JSONObject jsonObject = (JSONObject) JSONObject.toJSON(contractIns);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;

	}
	
	/**
	 * where hql
	 * @param contract
	 * @return
	 */
	private String whereHql(Contract contract,Map<String,Object> params){
		String hql=" where 1=1 ";
		String startDate=contract.getStartDate()==null?"1970-01-01":ParseDate.DateToString(contract.getStartDate());
		String endDate=contract.getEndDate()==null?"1970-01-01":ParseDate.DateToString(contract.getEndDate());
		if(!"1970-01-01".equals(startDate)){
			hql+="and t.startDate >=:startDate ";
			params.put("startDate", contract.getStartDate());
		}
		if(!"1970-01-01".equals(endDate)){
			hql+=" and t.endDate <=:endDate ";
			params.put("endDate", contract.getEndDate());
		}
		if(!"".equals(contract.getName()) && contract.getName()!=null){
			hql+=" and t.name like '%"+contract.getName()+"%' ";
//			params.put("name", contract.getName());
		}
		return hql;
	}

	/**
	 * 我的信息-合同信息-总记录数
	 */
	@Override
	public Integer getUserContractTotalRows(HttpSession session,Contract contract) {
		Map<String,Object> params=new HashMap<String,Object>();
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String hql="select count(*) from Contract t "+whereHql(contract,params);
		if(userKind == 2){//个人用户
			hql+=" and t.clientId=:userId";
		}else if(userKind == 3){//企业用户
			hql+=" and t.carrierId=:userId";
		}
		params.put("userId", userId);
		
		Long count=contractDao.count(hql, params);
		return count.intValue();
	}

}
