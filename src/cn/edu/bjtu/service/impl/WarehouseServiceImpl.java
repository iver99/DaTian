package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.WarehouseDao;
import cn.edu.bjtu.service.WarehouseService;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Warehouse;

@Repository
/**
 * 
 * @author RussWest0
 *
 */
@Transactional
public class WarehouseServiceImpl implements WarehouseService {

	@Resource
	WarehouseDao warehouseDao;
	@Resource
	Warehouse warehouse;
	@Resource
	BaseDao baseDao;
	@Resource
	HQLTool hqltool;

	@Override
	public List getAllWarehouse(int Display, int PageNow) {
		// TODO Auto-generated method stub
		return warehouseDao.getAllWarehouse(Display, PageNow);
	}

	@Override
	/**
	 * 条件筛选车辆
	 */
	public List getSelectedWarehouse(String city, String type,
			String storageForm, String houseArea, int Display, int PageNow) {

		if (type.equals("保税仓库")) {
			type = "保税";
		} else if (type.equals("非保税仓库")) {
			type = "非保税";
		}

		if (storageForm.equals("普通仓库")) {
			storageForm = "普通";
		} else if (storageForm.equals("冷藏仓库")) {
			storageForm = "冷藏";
		} else if (storageForm.equals("恒温仓库")) {
			storageForm = "恒温";
		} else if (storageForm.equals("露天仓库")) {
			storageForm = "露天";
		} else if (storageForm.equals("危险品仓库")) {
			storageForm = "危险品";
		}

		String sql = "";
		String hql = "from WarehouseCarrierView ";// 会变化
		if (houseArea.equals("大于1万平方米")) {

			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);

			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 10000";
			} else
				sql += "and houseArea > 10000";

		} else if (houseArea.equals("大于2万平方米")) {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 20000";
			} else
				sql += "and houseArea > 20000";

		} else if (houseArea.equals("大于5万平方米")) {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 50000";
			} else
				sql += "and houseArea > 50000";

		} else {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);

		}
		// System.out.println("hql+" + sql);
		return warehouseDao.getSelectedWarehouse(sql, Display, PageNow);
	}

	@Override
	/**
	 * 获取总记录条数 
	 */
	public int getTotalRows(String city, String type, String storageForm,
			String houseArea) {
		// TODO Auto-generated method stub
		if (type.equals("保税仓库")) {
			type = "保税";
		} else if (type.equals("非保税仓库")) {
			type = "非保税";
		}

		if (storageForm.equals("普通仓库")) {
			storageForm = "普通";
		} else if (storageForm.equals("冷藏仓库")) {
			storageForm = "冷藏";
		} else if (storageForm.equals("恒温仓库")) {
			storageForm = "恒温";
		} else if (storageForm.equals("露天仓库")) {
			storageForm = "露天";
		} else if (storageForm.equals("危险品仓库")) {
			storageForm = "危险品";
		}

		String sql = "";
		String hql = "from WarehouseCarrierView ";// 会变化
		if (houseArea.equals("大于1万平方米")) {

			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);

			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 10000";
			} else
				sql += "and houseArea > 10000";

		} else if (houseArea.equals("大于2万平方米")) {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 20000";
			} else
				sql += "and houseArea > 20000";

		} else if (houseArea.equals("大于5万平方米")) {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where houseArea > 50000";
			} else
				sql += "and houseArea > 50000";

		} else {
			String[] paramList = { "city", "type", "storageForm" };
			String[] valueList = { city, type, storageForm };
			sql = HQLTool.spellHql2(hql, paramList, valueList);

		}

		// System.out.println("hql+"+sql);
		return hqltool.getTotalRows(sql);// 这里的HQLTool实例千万不能自己new出来，用@Resource
	}

	@Override
	public Warehouse getWarehouseInfo(String Warehouseid) {
		// TODO Auto-generated method stub

		return warehouseDao.getWarehouseInfo(Warehouseid);
	}

	@Override
	public List getCompanyWarehouse(String carrierId) {
		// TODO Auto-generated method stub
		return warehouseDao.getCompanyWarehouse(carrierId);
	}

	@Override
	public boolean insertWarehouse(String name, String city, String address,
			String type, String kind, float houseArea, float yardArea,
			float height, String fireRate, String storageForm,
			String fireSecurity, String environment, String serviceContent,
			String contact, String phone, String remarks, String carrierId,String path,String fileName) {
		// TODO Auto-generated method stub
		warehouse.setAddress(address);
		warehouse.setCarrierId(carrierId);
		warehouse.setCity(city);
		warehouse.setContact(contact);
		// warehouse.setDetailPrice(detailPrice);
		warehouse.setEnvironment(environment);
		warehouse.setFireRate(fireRate);
		warehouse.setFireSecurity(fireSecurity);
		warehouse.setHeight(height);
		warehouse.setHouseArea(houseArea);
		warehouse.setId(IdCreator.createRepositoryId());
		warehouse.setKind(kind);
		warehouse.setName(name);
		warehouse.setPhone(phone);
		warehouse.setRelDate(new Date());
		warehouse.setRemarks(remarks);
		warehouse.setServiceContent(serviceContent);
		warehouse.setStorageForm(storageForm);
		warehouse.setType(type);
		warehouse.setYardArea(yardArea);
		
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			warehouse.setDetailPrice(fileLocation);
		}
		 baseDao.save(warehouse);// 保存实体
		 return true;
	}

	@Override
	public boolean updateWarehouse(String id, String name, String city,
			String address, String type, String kind, float houseArea,
			float yardArea, float height, String fireRate, String storageForm,
			String fireSecurity, String environment, String serviceContent,
			String contact, String phone, String remarks, String carrierId,String path,String fileName) {
		// TODO Auto-generated method stub

		warehouse = getWarehouseInfo(id);// 根据id查找到仓库信息
		warehouse.setName(name);
		warehouse.setCity(city);
		warehouse.setAddress(address);
		warehouse.setType(type);
		warehouse.setKind(kind);
		warehouse.setHouseArea(houseArea);
		warehouse.setYardArea(yardArea);
		warehouse.setHeight(height);
		warehouse.setFireRate(fireRate);
		warehouse.setStorageForm(storageForm);
		warehouse.setFireSecurity(fireSecurity);
		warehouse.setEnvironment(environment);
		warehouse.setServiceContent(serviceContent);
		warehouse.setContact(contact);
		warehouse.setPhone(phone);
		warehouse.setRelDate(new Date());
		warehouse.setRemarks(remarks);
		warehouse.setCarrierId(carrierId);
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			warehouse.setDetailPrice(fileLocation);
		}
		 baseDao.update(warehouse);// 保存实体
		 return true;
	}
	public boolean deleteWarehouse(String id){
		warehouse = getWarehouseInfo(id);// 根据id查找到仓库信息
		baseDao.delete(warehouse);
		return true;
	}
}
