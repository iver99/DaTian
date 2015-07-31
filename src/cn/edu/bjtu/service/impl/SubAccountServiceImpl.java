package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.SubAccountBean;
import cn.edu.bjtu.dao.SubAccountDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.SubAccountService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.Encrypt;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.SubAccount;
import cn.edu.bjtu.vo.Userinfo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


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
	@Autowired
	UserinfoDao userinfoDao;
	
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
	public boolean changeStatus(String id){
		return subAccountDao.changeStatus(id);
	}
	
	/**
	 * 删除公司子账户
	 */
	@Override
	public boolean deleteSubAccount(String id){
		subAccountDao.deleteSubAccount(id);
		//删除userinfo表
		Userinfo user=userinfoDao.get(Userinfo.class, id);
		
		userinfoDao.delete(user);
		
		return true;
		
	}
	
	/**
	 * 添加新的附属账户
	 */
	@Override
	@Deprecated
	public boolean insertSubAccount(String username,String password,String resourceManagement,
			String transactionManagement,String schemaManagement,
			String statisticsManagement,String remarks,
			String hostAccountId,String hostAccountName){
		
		/*if(resourceManagement==null){
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
		
		subAccountDao.save(subAccount);*/
		return true;
	}
	
	@Override
	public boolean updateSubAccount(SubAccountBean subAccountBean,HttpSession session){
		
		SubAccount sub_account=subAccountDao.get(SubAccount.class, subAccountBean.getId());
		sub_account.setPassword(Encrypt.MD5(subAccountBean.getPassword()));
		sub_account.setRemarks(subAccountBean.getRemarks());
		sub_account.setResourceManagement(subAccountBean.getResourceManagement());
		sub_account.setSchemaManagement(subAccountBean.getSchemaManagement());
		sub_account.setStatisticsManagement(subAccountBean.getStatisticsManagement());
		sub_account.setTransactionManagement(subAccountBean.getTransactionManagement());
		//账户为父username-子username格式
		sub_account.setUsername(subAccountBean.getHostAccountName().trim()+"-"+subAccountBean.getUsername());
		
		subAccountDao.update(sub_account);
		
		//更新userinfo表
		Userinfo user=userinfoDao.get(Userinfo.class, subAccountBean.getId());
		user.setUsername(subAccountBean.getHostAccountName().trim()+"-"+subAccountBean.getUsername());
		user.setPassword(Encrypt.MD5(subAccountBean.getPassword()));//未加密
		return true;
	}

	/**
	 * 新增附属庄户
	 */
	@Override
	public boolean addNewSubAccount(SubAccountBean subAccountBean,
			HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		SubAccount sub_account=new SubAccount();
		BeanUtils.copyProperties(subAccountBean, sub_account);
		sub_account.setUsername(subAccountBean.getHostAccountName().trim()+"-"+subAccountBean.getUsername());
		sub_account.setPassword(Encrypt.MD5(subAccountBean.getPassword()));
		sub_account.setId(IdCreator.createSubAccountId());
		sub_account.setHostAccountId(userId);
		sub_account.setRelDate(new Date());
		sub_account.setStatus("正常");
		subAccountDao.save(sub_account);
		
		//保存userinfo表
		Userinfo userInfo=new Userinfo();
		userInfo.setUsername(subAccountBean.getHostAccountName().trim()+"-"+subAccountBean.getUsername());
		//userInfo.setPhone(phone);
		userInfo.setId(sub_account.getId());
		userInfo.setPassword(Encrypt.MD5(subAccountBean.getPassword()));//未加密
		userInfo.setStatus("未验证");
		userInfo.setEmailStatus("未绑定");
		userInfo.setPhoneStatus("已绑定");
		userInfo.setSecurityQuestionStatus("未设置");
		//userInfo.setPrivilege(privilege);
		userInfo.setStatus("未验证");
		userInfo.setUserKind(3);//默认作为企业用户
		userInfo.setHeadIcon("未设置");// add by RussWest0 at 2015年6月2日,下午11:56:49 
		userinfoDao.save(userInfo);//保存实体
		return true;
	}

	/**
	 * 获取附属账户
	 */
	@Override
	public SubAccount getSubAccountDetail(String id) {
		
		return subAccountDao.get(SubAccount.class, id);
	}
	
	/**
	 * 附属账户
	 */
	@Override
	public String getSubAccountList(HttpSession session,SubAccount subAccount,PageUtil pageUtil) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from SubAccount t "+whereHql(subAccount,params);
		hql+=" and t.hostAccountId=:hostAccountId ";
		params.put("hostAccountId", carrierId);
		List<SubAccount> subAccountList=subAccountDao.find(hql, params);
		JSONArray jsonArray=new JSONArray();
		for(SubAccount sub:subAccountList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(sub);
			jsonArray.add(jsonObject);
		}
		return jsonArray.toString();
	}

	/**
	 * 附属账户-总记录数
	 */
	@Override
	public Integer getSubAccountTotalRows(HttpSession session,SubAccount subAccount) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from SubAccount t where t.hostAccountId=:hostAccountId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("hostAccountId", carrierId);
		Long count=subAccountDao.count(hql, params);
		
		return count.intValue();
		
	}
	
	/**
	 * where hql
	 * @param subAccount
	 * @param params
	 * @return
	 */
	private String whereHql(SubAccount subAccount,Map<String,Object> params){
		String hql="where 1=1 ";
		if(subAccount !=null){
			if(!"".equals(subAccount.getUsername()) && subAccount.getUsername()!=null){
				hql+=" and t.username like '%"+subAccount.getUsername()+"%'";
			}
		}
		
		return hql;
	}
	
}
