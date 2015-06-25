package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.vo.Comment;

/**
 * 评价相关业务逻辑
 * @author RussWest0
 * @date   2015年5月23日 下午5:09:32
 */
public interface CommentService {
	/**
	 * 提交评价
	 * @param rate1
	 * @param rate2
	 * @param rate3
	 * @param rate4
	 * @param remarks
	 * @param userId
	 * @return
	 */
	public boolean commitComment(String rate1,String rate2,String rate3,String rate4,String remarks,String userId,String orderid);

	/**
	 * 根据carrierid得到公司干线评论
	 * @param userId
	 * @return
	 *//*
	public List<Comment> getLinetransportCommentById(String linetransportId,String userId);
	*//**
	 * 根据carrierid得到城市配送评论
	 * @param userId
	 * @return
	 *//*
	public List<Comment> getCitylineCommentById(String citylineId,String userId);
	*//**
	 * 根据carrierid得到车辆评论
	 * @param userId
	 * @return
	 *//*
	public List<Comment> getCarCommentById(String carId,String userId);
	*//**
	 * 根据carrierid得到仓库评论
	 * @param userId
	 * @return
	 *//*
	public List<Comment> getWarehouseCommentById(String warehouseid,String userId);
	*/
	
	/**
	 * 根据订单号得到订单评价
	 * @param orderId
	 * @return
	 */
	public Comment getCommentByOrderId(String orderId);
	
	/**
	 * 返回用户的好评率
	 * @param session
	 * @return
	 */
	public Double getUserGoodCommentRateAjax(HttpSession session);
	
	/**
	 * 获取公司评论
	 * @param carrierId
	 * @return
	 */
	public List<Comment> getCompanyComment(String carrierId);
	
	/**
	 * 获取公司评论的平均评价
	 * @param carrierId
	 * @return
	 */
	public Comment getCompanyAverageCommentRate(String carrierId);
	
	
}
