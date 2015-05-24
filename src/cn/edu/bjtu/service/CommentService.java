package cn.edu.bjtu.service;
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
	public boolean commitComment(String rate1,String rate2,String rate3,String rate4,String remarks,String userId);

}
