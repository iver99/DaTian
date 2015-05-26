package cn.edu.bjtu.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.ComplaintDao;
import cn.edu.bjtu.dao.ContractDao;
import cn.edu.bjtu.service.ComplaintService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Complaintform;

@Service("complaintServiceImpl")
@Transactional
public class ComplaintServiceImpl implements ComplaintService{

	@Resource
	ComplaintDao complaintDao;
	@Resource 
	Complaintform complaintform;
	@Resource 
	OrderService orderService;
	
	@Override
	public List getUserCompliant(String userId) {
		// TODO Auto-generated method stub
		return complaintDao.getUserCompliant(userId);
	}

	@Override
	public List getAllUserCompliant(){
		
		return complaintDao.getAllUserCompliant();
	}
	
	@Override
	public Complaintform getComplaintInfo(String id) {
		
		return complaintDao.getComplaintInfo(id);
	}
	
	@Override
	/**
	 * 新增投诉
	 */
	public boolean insertComplaint(String type, String theme,
			String content, String orderNum, String carrierId,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		complaintform.setId(IdCreator.createCityLineId());
		complaintform.setType(type);
		complaintform.setTheme(theme);
		complaintform.setContent(content);

		complaintform.setCarrierId(carrierId);
		complaintform.setClientId(carrierId);
		complaintform.setRelDate(new Date());
		if(orderNum!=null)//不考虑订单号出错的情况
		{
			if(orderService.getOrderIdByOrderNum(orderNum).isEmpty())
			{
				System.out.println("找不到订单编号");
				/*try {
					response.sendRedirect("mycomplaint");//重定向显示最新结果
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				return false;
			}
			else {
				complaintform.setOrderId(orderService.
						getOrderIdByOrderNum(orderNum).
						get(0).toString());
			}
		}
		complaintDao.save(complaintform);
		return true;
	
	}
	
	@Override
	public boolean doAcceptComplaint(String id, String feedback){
		
		complaintform = getComplaintInfo(id);
		complaintform.setFeedback(feedback);
		complaintform.setState("已受理");
		complaintDao.update(complaintform);
		return false;
	}
	
	@Override
	public List getFindComplaint(String theme, int flag, String clientId){
		String sql="from ComplaintClientView ";
		if(flag==0){
			if(theme.equals("投诉主题")){
				//查找时不考虑投诉主题
			}
			else sql+="where theme like '%"+theme+"%' ";
			
		}
		else if(flag==1){
			if(theme.equals("投诉主题")){
				//查找时不考虑投诉主题
			}
			else sql+="where theme like '%"+theme+"%' and clientId='"+clientId+"'";
			
		}
		return complaintDao.getFindComplaint(sql);
	}
}
