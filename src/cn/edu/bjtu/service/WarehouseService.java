package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.search.WarehouseSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Warehouse;

import com.alibaba.fastjson.JSONArray;

public interface WarehouseService {

	@Deprecated
	public List getSelectedWarehouse(String city, String type, String storageForm, String houseArea, int Display,int PageNow);
	@Deprecated
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
	
	/**
	 * 资源栏-仓库筛选
	 * @param warehouseBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedWarehouseNew(WarehouseSearchBean warehouseBean,PageUtil pageUtil,HttpSession session);

	/**
	 * 资源栏-仓库筛选总条数
	 * @param warehouseBean
	 * @return
	 */
	public Integer getSelectedWarehouseTotalRows(WarehouseSearchBean warehouseBean);
}
