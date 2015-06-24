package cn.edu.bjtu.util;

import java.io.File;

/**
 * 返回各种上传的路径-每个路径都包含两种windows和linux
 * 
 * @author RussWest0
 *
 */
public class UploadPath {

	
	public static File file = null;

	/**
	 * 返回干线文件上传的路径
	 * 
	 * @return
	 */
	public static String getLinetransportPath() {
		// return sep+Base_Directory+sep+"linetransport";
		if (isWindows()) {//windows系统
			String path = "D://uploadFile//linetransport";//上传到D盘
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/uploadFile/linetransport";
			file=new File(path);
			file.mkdirs();//防止文件夹不存在
			return path;
		}
	}
	
	public static String getCitylinePath() {
		if (isWindows()) {//windows系统
			String path = "D://uploadFile//cityline";//上传到D盘
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/uploadFile/cityline";
			file=new File(path);
			file.mkdirs();//防止文件夹不存在
			return path;
		}
	}
	
	public static String getGoodsPath() {
		if (isWindows()) {//windows系统
			String path = "D://uploadFile//goods";//上传到D盘
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/uploadFile/goods";
			file=new File(path);
			file.mkdirs();//防止文件夹不存在
			return path;
		}
	}
	
	public static String getWarehousePath() {
		if (isWindows()) {//windows系统
			String path = "D://uploadFile//warehouse";//上传到D盘
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/uploadFile/warehouse";
			file=new File(path);
			file.mkdirs();//防止文件夹不存在
			return path;
		}
	}

	public static String getClientPath() {
		if (isWindows()) {//windows系统
			String path = "D://uploadFile//client";//上传到D盘
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/uploadFile/client";
			file=new File(path);
			file.mkdirs();//防止文件夹不存在
			return path;
		}
	}
	
	public static String getContactPath() {
		if (isWindows()) {//windows系统
			String path = "D://uploadFile//client";//上传到D盘
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/uploadFile/client";
			file=new File(path);
			file.mkdirs();//防止文件夹不存在
			return path;
		}
	}
	
	public static String getDriverPath() {
		if (isWindows()) {//windows系统
			String path = "D://uploadFile//driver";//上传到D盘
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/uploadFile/driver";
			file=new File(path);
			file.mkdirs();//防止文件夹不存在
			return path;
		}
	}
	

	public static String getCompanyCertificatePath() {
		
		if (isWindows()) {//windows系统
			String path = "D://uploadFile//companyCertificate";//上传到D盘
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/uploadFile/companyCertificate";
			file=new File(path);
			file.mkdirs();//防止文件夹不存在
			return path;
		}
	}
	
	public static String getSignBillPath() {
		if (isWindows()) {//windows系统
			String path = "D://uploadFile//signBill";//上传到D盘
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/uploadFile/signBill";
			file=new File(path);
			file.mkdirs();//防止文件夹不存在
			return path;
		}
	}
	/**
	 * 提交反馈时提交的文件
	 * @return
	 */
	public static String getResponsePath(){
		if (isWindows()) {//windows系统
			String path = "D://uploadFile//response";//上传到D盘
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/uploadFile/response";
			file=new File(path);
			file.mkdirs();//防止文件夹不存在
			return path;
		}
	}
	
	/**
	 * 提交投诉时提交的文件
	 * @return
	 */
	public static String getComplaintPath(){
		if (isWindows()) {//windows系统
			String path = "D://uploadFile//complaint";//上传到D盘
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/uploadFile/complaint";
			file=new File(path);
			file.mkdirs();//防止文件夹不存在
			return path;
		}
	}
	
	
	// 判断当前系统
	public static boolean isWindows() {
		boolean flag = false;
		if (System.getProperties().getProperty("os.name").toUpperCase()
				.indexOf("WINDOWS") != -1) {
			flag = true;
		}
		return flag;
	}


}
