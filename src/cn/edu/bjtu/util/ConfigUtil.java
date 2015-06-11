package cn.edu.bjtu.util;

import java.util.ResourceBundle;

/**
 * 
 * @author RussWest0
 * @date   2015年6月10日 下午8:56:55
 */
public class ConfigUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("config");

	/**
	 * 鑾峰緱sessionInfo鍚嶅瓧
	 * 
	 * @return
	 *//*
	public static final String getSessionInfoName() {
		return bundle.getString("sessionInfoName");
	}
*/
	/**
	 * 根据key得到配置文件内容
	 * 
	 * @param key
	 * @return
	 */
	public static final String get(String key) {
		if(!bundle.containsKey(key)){
			return null;
		}else{
			return bundle.getString(key);
		}
		
		
	}

}
