package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.ComplaintBean;
import cn.edu.bjtu.dao.ComplaintDao;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.service.ComplaintService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Complaintform;

@Service("complaintServiceImpl")
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

	@Resource
	ComplaintDao complaintDao;
	@Resource
	Complaintform complaintform;
	@Resource
	OrderService orderService;
	@Autowired
	OrderDao orderDao;

	@Override
	public List getUserCompliant(String userId) {
		
		return complaintDao.getUserCompliant(userId);
	}

	@Override
	public List getAllUserCompliant() {

		return complaintDao.getAllUserCompliant();
	}

	@Override
	public Complaintform getComplaintById(String id) {

		return complaintDao.get(Complaintform.class,id);
	}

	@Override
	/**
	 * 新增投诉
	 */
	public boolean insertComplaint(ComplaintBean complaintBean, String carrierId, String path, String fileName) {
		

		complaintform.setId(IdCreator.createCityLineId());
		complaintform.setType(complaintBean.getType());
		complaintform.setTheme(complaintBean.getTheme());
		complaintform.setContent(complaintBean.getContent());
		complaintform.setOrderNum(complaintBean.getOrderNum());
		
		complaintform.setCarrierId(carrierId);
		complaintform.setClientId(carrierId);
		complaintform.setRelDate(new Date());
		// add by RussWest0 at 2015年5月30日,下午10:05:22
		
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			complaintform.setRelatedMaterial(fileLocation);
		}

		complaintform.setState("受理中");
		complaintDao.save(complaintform);
		return true;

	}

	@Override
	public boolean doAcceptComplaint(String id, String feedback) {

		complaintform = getComplaintById(id);
		complaintform.setFeedback(feedback);
		complaintform.setState("已受理");
		complaintDao.update(complaintform);
		return true;
	}

	@Override
	public List getFindComplaint(String theme, int flag, String clientId) {
		String sql = "from ComplaintClientView ";
		if (flag == 0) {
			if (theme.equals("投诉主题")) {
				// 查找时不考虑投诉主题
			} else
				sql += "where theme like '%" + theme + "%' ";

		} else if (flag == 1) {
			if (theme.equals("投诉主题")) {
				// 查找时不考虑投诉主题
			} else
				sql += "where theme like '%" + theme + "%' and clientId='"
						+ clientId + "'";

		}
		return complaintDao.getFindComplaint(sql);
	}
	
	/**
	 * 获取用户投诉率
	 */
	@Override
	public Double getUserComplaintRateAjax(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String hql_count="select count(*) from Orderform t ";
		String hql="select count(*) from Complaintform t ";
		Map<String,Object> params=new HashMap<String,Object>();
		if(userKind==2){//个人用户
			hql_count+=" where t.clientId=:clientId ";
			hql+=" where t.clientId=:clientId ";
			params.put("clientId", userId);
		}else if(userKind==3){//企业用户
			hql_count+=" where t.carrierId=:carrierId ";
			hql+=" where t.carrierId=:carrierId ";
			params.put("carrierId", userId);
		}
		Long total_num=orderDao.count(hql_count, params);
		if(total_num == 0L){
			return 0D;
		}
		Long complaint_num=complaintDao.count(hql, params);
		
		return complaint_num.intValue()*1.0/total_num.intValue();
		
	}
}
