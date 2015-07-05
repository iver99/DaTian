package cn.edu.bjtu.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * @author RussWest0
 * @date   2015年7月5日 下午2:51:20
 */
public class UploadFile {
	
	/**
	 * 保存文件，返回文件的绝对路径
	 * @param file 文件
	 * @param userId 用户id
	 * @param fileType 文件类型
	 * @return
	 */
	public static String uploadFile(MultipartFile file,String userId,String fileType){
		String path = "";
		String fileName = "";
		String fileLocation ="";
		
		if ("linetransport".equals(fileType)) {
			path = UploadPath.getLinetransportPath();
		} else if ("cityline".equals(fileType)) {
			path = UploadPath.getCitylinePath();
		} else if ("cargo".equals(fileType)) {
			path = UploadPath.getGoodsPath();
		} else if ("warehouse".equals(fileType)) {
			path = UploadPath.getWarehousePath();
		} else if ("businessClient".equals(fileType)) {
			path = UploadPath.getClientPath();
		} else if ("contract".equals(fileType)) {
			path = UploadPath.getContractPath();
		} else if ("driver".equals(fileType)) {
			path = UploadPath.getDriverPath();
		} else if ("companyCertificate".equals(fileType)) {
			path = UploadPath.getCompanyCertificatePath();
		} else if ("signBill".equals(fileType)) {
			path = UploadPath.getSignBillPath();
		} else if ("response".equals(fileType)) {
			path = UploadPath.getResponsePath();
		} else if ("complaint".equals(fileType)) {
			path = UploadPath.getComplaintPath();
		}
		
		if (file.getSize() != 0)// 有上传文件的情况
		{
			fileName = file.getOriginalFilename();
			fileName = userId + "_" + fileName;// 文件名
			File targetFile = new File(path, fileName);
			try { // 保存 文件
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			fileLocation = path + "//" + fileName;
			
			return fileLocation;
		
	}

}
