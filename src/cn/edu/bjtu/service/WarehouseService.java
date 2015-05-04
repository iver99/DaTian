package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Warehouse;

public interface WarehouseService {

	public List getAllWarehouse(int Display,int PageNow);
	public List getSelectedWarehouse(String city, String type, String storageForm, String houseArea, int Display,int PageNow);
	public int getTotalRows(String city, String type, String storageForm, String houseArea);
	
	public Warehouse getWarehouseInfo(String warehouseid);
	public List getCompanyWarehouse(String carrierId);
	public boolean insertWarehouse(String name,String city,String address,String type,String kind,
			float houseArea,float yardArea,float height,String fireRate,String storageForm,
			String fireSecurity,String environment,String serviceContent,String contact,
			String phone,String remarks,String carrierId,String path,String fileName);
	public boolean updateWarehouse(String id, String name,String city,String address,String type,String kind,
			float houseArea,float yardArea,float height,String fireRate,String storageForm,
			String fireSecurity,String environment,String serviceContent,
			String contact,String phone,String remarks,String carrierId,String path,String fileName);
	public boolean deleteWarehouse(String id);
}
