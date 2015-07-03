package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.CommentDao;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Orderform;

@Service
@Transactional
/**
 * 评价相关的业务实现类
 * @author RussWest0
 * @date   2015年5月23日 下午5:11:05
 */
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentDao commentDao;
	@Autowired
	OrderDao orderDao;
	
	@Override
	/**
	 * 提交评价,修改订单状态
	 */
	public boolean commitComment(String rate1, String rate2, String rate3,
			String rate4, String remarks, String userId,String orderid) {
		
		Comment comment=new Comment();
		comment.setId(IdCreator.createAssessId());
		comment.setRelDate(new Date());
		comment.setClientId(userId);
		comment.setServiceAttitude(rate1);
		comment.setTotalMoney(rate4);
		comment.setTransportEfficiency(rate2);
		comment.setCargoSafety(rate3);
		comment.setComment(remarks);
		
		//add by RussWest0 at 2015年6月7日,下午4:25:06 
		Orderform order=orderDao.get(Orderform.class, orderid);
		comment.setLinetransportId(order.getLinetransportId());
		comment.setWarehouseId(order.getWarehouseId());
		comment.setCarrierId(order.getCarrierId());
		comment.setCitylineId(order.getCitylineId());
		comment.setOrderId(order.getId());
		
		if(order!= null){
			order.setState("已完成");
			order.setCommentId(comment.getId());
			orderDao.update(order);
		}
		
		commentDao.save(comment);
		
		
		return true;
	}

	/*@Override
	*//**
	 *根据公司id和干线id得到评价
	 *//*
	public List<Comment> getLinetransportCommentById(String linetransportId,String userId) {
		
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Comment where linetransportId=:linetransportId and carrierId=:carrierId";
		params.put("linetransportId", linetransportId);
		params.put("carrierId", userId);
		return commentDao.find(hql, params);
	}

	@Override
	public List<Comment> getCitylineCommentById(String citylineId, String userId) {
		
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Comment where citylineId=:citylineId and carrierId=:carrierId";
		params.put("citylineId", citylineId);
		params.put("carrierId", userId);
		return commentDao.find(hql, params);
	}

	@Override
	public List<Comment> getCarCommentById(String carId, String userId) {
		
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Comment where carId=:carId and carrierId=:carrierId";
		params.put("carId", carId);
		params.put("carrierId", userId);
		return commentDao.find(hql, params);
	}

	@Override
	public List<Comment> getWarehouseCommentById(String warehouseid,
			String userId) {
		
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Comment where warehouseid=:warehouseid and carrierId=:carrierId";
		params.put("warehouseid", warehouseid);
		params.put("carrierId", userId);
		return commentDao.find(hql, params);
	}*/

	/**
	 * 根据订单id得到订单评价
	 */
	@Override
	public Comment getCommentByOrderId(String orderId) {
		
		String hql="from Comment where orderId=:orderId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("orderId", orderId);
		List<Comment> commentList=commentDao.find(hql, params);
		
		if(commentList!=null){
			return commentList.get(0);
		}
		return null;
	}
	
	/**
	 * 返回用户的好评率
	 */
	@Override
	public Double getUserGoodCommentRateAjax(HttpSession session) {
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String hql_count="select count(*) from Comment t ";
		String hql="from Comment t ";
		Map<String,Object> params=new HashMap<String,Object>();
		if(userKind==2){
			hql_count+=" where t.clientId=:clientId ";
			hql+=" where t.clientId=:clientId ";
			params.put("clientId", userId);
		}else{
			hql_count+=" where t.carrierId=:carrierId ";
			hql+=" where t.carrierId=:carrierId ";
			params.put("carrierId", userId);
		}
		Long total_count=commentDao.count(hql_count, params);
		if(total_count==0L){
			return 0D;
		}
		
		Integer good_comment_num=0;
		List<Comment> commentList=commentDao.find(hql, params);
		for(int i=0;i<commentList.size();i++){
			Comment comment=commentList.get(i);
			int c1=getCommentRate(comment.getCargoSafety());
			int c2=getCommentRate(comment.getServiceAttitude());
			int c3=getCommentRate(comment.getTransportEfficiency());
			int c4=getCommentRate(comment.getTotalMoney());
			float rate=(c1+c2+c3+c4)/4.0f;
			if(rate>=4){
				good_comment_num++;
			}
		}
		
		return good_comment_num*1.0/total_count.intValue();
	}
	
	/**
	 * 获取没一个评论字段对应的数字 
	 * @Title: getCommentRate 
	 *  
	 * @param: @param comment
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年6月24日 下午2:35:43
	 */
	public Integer getCommentRate(String comment){
		if("很好".equals(comment)){
			return 5;
		}else if("好".equals(comment)){
			return 4;
		}else if("一般".equals(comment)){
			return 3;
		}else if("差".equals(comment)){
			return 2;
		}else{//很差
			return 1;
		}
		
	}
	
	/**
	 * 获取公司评论
	 */
	@Override
	public List<Comment> getCompanyComment(String carrierId) {
		
		String hql=" from Comment t where t.carrierId=:carrierId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		
		return commentDao.find(hql, params);
	}

	/**
	 * 获取资源详情页的平均评价
	 */
	@Override
	public Comment getCompanyAverageCommentRate(String carrierId) {
		String hql="from Comment t where t.carrierId=:carrierId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		//纵向算平均数，算出list中每种评论的平均数 
		int r1=0,r2=0,r3=0,r4=0;
		Comment new_comment=new Comment();
		List<Comment> commentList=commentDao.find(hql, params);
		if(commentList!=null && commentList.size()>0){
			for(Comment comment:commentList){
				 r1+=getCommentRate(comment.getCargoSafety());
				 r2+=getCommentRate(comment.getServiceAttitude());
				 r3+=getCommentRate(comment.getTransportEfficiency());
				 r4+=getCommentRate(comment.getTotalMoney());
			}
			Double rate1=0D;
			Double rate2=0D;
			Double rate3=0D;
			Double rate4=0D;
			Integer total_num=commentList.size();
			rate1=r1*1.0/total_num;
			rate2=r2*1.0/total_num;
			rate3=r3*1.0/total_num;
			rate4=r4*1.0/total_num;
			
			new_comment.setCargoSafety(getCommentFromRate(rate1));
			new_comment.setServiceAttitude(getCommentFromRate(rate2));
			new_comment.setTransportEfficiency(getCommentFromRate(rate3));
			new_comment.setTotalMoney(getCommentFromRate(rate4));
		}
		return new_comment;
		
	}
	
	/**
	 * 根据评价的平均数字得到平均评价
	 * @Title: getCommentFromRate 
	 *  
	 * @param: @param rate
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年6月25日 下午5:50:33
	 */
	private String getCommentFromRate(Double rate){
		if(rate==5.0){
			return "很好";
		}else if(rate >=4.0){
			return "好";
		}else if(rate >=3.0){
			return "一般";
		}else if(rate >=2.0){
			return "差";
		}else{
			return "很差";
		}
	}
	
}
