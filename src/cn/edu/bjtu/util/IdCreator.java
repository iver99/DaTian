package cn.edu.bjtu.util;

import java.util.Calendar;
import java.util.Date;

/**
 * id生成类
 * @author RussWest0
 *
 */
public class IdCreator {

	/**
	 * 
	 * @return 返回需求方随机id
	 */
	public static String createClientId() {
		return "CL" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回商业客户的id
	 * @return
	 */
	public static String createBusinessClientId()
	{
		return "BU"+(int)(Math.random() * 100000000);
	}
	/**
	 * 返回承运方id
	 * @return
	 */
	public static String createCarrierId() {
		return "CA" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回干线id
	 * @return
	 */
	public static String createlineTransportId() {
		return "LI" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回货物id
	 * @return
	 */
	public static String createGoodsId() {
		return "GO" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回城市配送id
	 * @return
	 */
	public static String createCityLineId() {
		return "CI" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回车辆id（不是车牌）
	 * @return
	 */
	public static String createCarId() {
		return "CAR" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回仓库id
	 * @return
	 */
	public static String createRepositoryId() {
		return "RE" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回司机id
	 * @return
	 */
	public static String createDriverId() {
		return "DR" + (int)(Math.random() * 100000000);
	}
	/**
	 * 返回订单id-时间敏感
	 * @return
	 */
	public static String createOrderId() {
		return "OR"+(int)(Math.random() * 100000000);
	}
	
	/**
	 * 返回投诉id-时间敏感
	 * @return
	 */
	public static String createComplaintId() {
		return "CO"+(int)(Math.random() * 100000000);
	}
	/**
	 * 返回评价id-时间敏感
	 * @return
	 */
	public static String createAssessId() {
		return "AS"+(int)(Math.random() * 100000000);
	}
	/**
	 * 返回合同id
	 * @return
	 */
	public static String createContractId(){
		return "CO"+(int)(Math.random()*100000000);
	}
	
	

}
