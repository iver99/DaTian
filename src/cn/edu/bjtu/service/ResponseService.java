package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.vo.Response;

/**
 * 反馈相关的serivce
 * @author RussWest0
 * @date   2015年6月2日 上午11:06:13
 */
public interface ResponseService{

	/**
	 * 根据id得到视图实例,用于我的反馈页面上点击
	 * @param responseId
	 * @return
	 */
//	public Response getResponseById(String responseId);
	
	/**
	 * 根据货物id得到货物反馈信息
	 * @param goodsId
	 * @return
	 */
	public List<Response> getResponseListByGoodsId(String goodsId);
	
	/**
	 * 根据id得到单条反馈信息
	 * @param responseId
	 * @return
	 */
	public Response getResponseById(String responseId);
	
	/**
	 * 确认反馈，修改状态
	 * @param responseId
	 * @return
	 */
	public boolean confirmResponse(String responseId,String carrierId,String goodsId);
}
