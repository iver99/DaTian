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
			String path = "D://uploadFile//linetransport";
			file = new File(path);
			file.mkdirs();//以防文件夹不存在
			return path;
		}
		else//linux系统 (未测试)
		{
			//如果文件夹不存在情况没有处理
			String path= "/usr/local/tomcat7/webapps/DaTian/uploadFile/linetransport";
			file=new File(path);
			file.mkdirs();
			return path;
		}
	}
	
	

	/*
	 * public static void main(String [] args) { File file=new File("");
	 * System.out.println("path+"+file.getAbsolutePath()); }
	 */

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
