package cn.edu.bjtu.service;

import cn.edu.bjtu.vo.Response;

/**
 * 反馈相关的serivce
 * @author RussWest0
 * @date   2015年6月2日 上午11:06:13
 */
public interface ResponseService {

	/**
	 * 根据id得到视图实例
	 * @param responseId
	 * @return
	 */
	public Response getResponseById(String responseId);
}
