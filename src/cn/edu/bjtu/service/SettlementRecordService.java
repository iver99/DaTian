package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.vo.Settlement;

import com.alibaba.fastjson.JSONArray;

/**
 * 用于记录生成对账单信息
 * @author RussWest0
 * @date   2015年6月20日 下午7:11:59
 */
public interface SettlementRecordService {
	/**
	 * 修改订单状态为已结算，并记录生成人
	 * @param orderNum
	 * @param session
	 * @return
	 */
	public boolean finishSettlement(String orderNum,HttpSession session);
	
	/**
	 * 根据订单号获取结算生成记录
	 * @param orderNum
	 * @return
	 */
	public List<Settlement> getSettlementRecordByOrderNum(String orderNum);
	
	/**
	 * 我的结算
	 * @param session
	 * @return
	 */
	public JSONArray getUserSettlement(HttpSession session,String name);
	
	/**
	 * 我的结算-总记录条数 
	 * @param session
	 * @return
	 */
	public Integer getUserSettlementTotalRows(HttpSession session);

}
