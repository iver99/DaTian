package cn.edu.bjtu.service;

import javax.servlet.http.HttpSession;

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

}
