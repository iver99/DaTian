package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.CitylineDao;
import cn.edu.bjtu.service.CitylineService;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Cityline;

@Repository
/**
 * 城市配送服务层实现
 * @author RussWest0
 *
 */
public class CitylineServiceImpl implements CitylineService {

	@Resource
	CitylineDao citylineDao;
	@Resource
	Cityline cityline;
	@Resource
	BaseDao baseDao;
	@Resource
	HQLTool hqltool;

	@Override
	/**
	 * 获取所有城市配送线路
	 */
	public List getAllCityline(int Display, int PageNow) {
		// TODO Auto-generated method stub

		return citylineDao.getAllCityline(Display, PageNow);
	}

	@Override
	/**
	 * 条件筛选城市配送线路
	 */
	public List getSelectedCityline(String cityName, String VIPService,
			String refPrice, int Display, int PageNow) {
		String sql = "";
		String hql = "from CityCarrierView ";// 会变化
		if (VIPService.equals("有增值服务")) {
			String[] paramList = { "cityName", "VIPService" };
			String[] valueList = { cityName, "有" };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			if (refPrice.equals("大于2元/kg")) {
				sql += "and refPrice > 2";
			} else if (refPrice.equals("1至2元/kg")) {
				sql += "and refPrice >= 1 and refPrice <=2";
			} else if (refPrice.equals("小于1元/kg")) {
				sql += "and refPrice < 1";
			}
		} else if (VIPService.equals("无增值服务")) {
			String[] paramList = { "cityName", "VIPService" };
			String[] valueList = { cityName, "无" };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			if (refPrice.equals("大于2元/kg")) {
				sql += "and refPrice > 2";
			} else if (refPrice.equals("1至2元/kg")) {
				sql += "and refPrice >= 1 and refPrice <=2";
			} else if (refPrice.equals("小于1元/kg")) {
				sql += "and refPrice < 1";
			}
		} else {// 不限制增值服务,值为All

			String[] paramList = { "cityName", "VIPService" };
			String[] valueList = { cityName, VIPService };
			sql = HQLTool.spellHql2(hql, paramList, valueList);

			if (refPrice.equals("大于2元/kg")) {
				int i = 0;
				for (; i < paramList.length; i++) {
					if (!(valueList[i].equals("All"))) {
						break;
					}
				}
				if (i == paramList.length) {
					// 要是所有项都等于All，即要补上where字段
					sql += "where refPrice > 2";
				} else
					sql += "and refPrice > 2";

			} else if (refPrice.equals("1至2元/kg")) {
				int i = 0;
				for (; i < paramList.length; i++) {
					if (!(valueList[i].equals("All"))) {
						break;
					}
				}
				if (i == paramList.length) {
					// 要是所有项都等于All，即要补上where字段
					sql += "where refPrice >= 1 and refPrice <=2";
				} else
					sql += "and refPrice >= 1 and refPrice <=2";
			} else if (refPrice.equals("小于1元/kg")) {
				int i = 0;
				for (; i < paramList.length; i++) {
					if (!(valueList[i].equals("All"))) {
						break;
					}
				}
				if (i == paramList.length) {
					// 要是所有项都等于All，即要补上where字段
					sql += "where refPrice < 1";
				} else
					sql += "and refPrice < 1";
			}

		}
		
		// System.out.println("hql+" + sql);
		return citylineDao.getSelectedCityline(sql, Display, PageNow);
	}

	@Override
	/**
	 * 获取总记录条数 
	 */
	public int getTotalRows(String cityName, String VIPService, String refPrice) {
		// TODO Auto-generated method stub
		String sql = "";
		String hql = "from CityCarrierView ";// 会变化
		if (VIPService.equals("有增值服务")) {
			String[] paramList = { "cityName", "VIPService" };
			String[] valueList = { cityName, "有" };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			if (refPrice.equals("大于2元/kg")) {
				sql += "and refPrice > 2";
			} else if (refPrice.equals("1至2元/kg")) {
				sql += "and refPrice >= 1 and refPrice <=2";
			} else if (refPrice.equals("小于1元/kg")) {
				sql += "and refPrice < 1";
			}
		} else if (VIPService.equals("无增值服务")) {
			String[] paramList = { "cityName", "VIPService" };
			String[] valueList = { cityName, "无" };
			sql = HQLTool.spellHql2(hql, paramList, valueList);
			if (refPrice.equals("大于2元/kg")) {
				sql += "and refPrice > 2";
			} else if (refPrice.equals("1至2元/kg")) {
				sql += "and refPrice >= 1 and refPrice <=2";
			} else if (refPrice.equals("小于1元/kg")) {
				sql += "and refPrice < 1";
			}
		} else {// 不限制增值服务,值为All

			String[] paramList = { "cityName", "VIPService" };
			String[] valueList = { cityName, VIPService };
			sql = HQLTool.spellHql2(hql, paramList, valueList);

			if (refPrice.equals("大于2元/kg")) {
				int i = 0;
				for (; i < paramList.length; i++) {
					if (!(valueList[i].equals("All"))) {
						break;
					}
				}
				if (i == paramList.length) {
					// 要是所有项都等于All，即要补上where字段
					sql += "where refPrice > 2";
				} else
					sql += "and refPrice > 2";

			} else if (refPrice.equals("1至2元/kg")) {
				int i = 0;
				for (; i < paramList.length; i++) {
					if (!(valueList[i].equals("All"))) {
						break;
					}
				}
				if (i == paramList.length) {
					// 要是所有项都等于All，即要补上where字段
					sql += "where refPrice >= 1 and refPrice <=2";
				} else
					sql += "and refPrice >= 1 and refPrice <=2";
			} else if (refPrice.equals("小于1元/kg")) {
				int i = 0;
				for (; i < paramList.length; i++) {
					if (!(valueList[i].equals("All"))) {
						break;
					}
				}
				if (i == paramList.length) {
					// 要是所有项都等于All，即要补上where字段
					sql += "where refPrice < 1";
				} else
					sql += "and refPrice < 1";
			}

		}
		// System.out.println("hql+"+sql);
		return hqltool.getTotalRows(sql);// 这里的HQLTool实例千万不能自己new出来，用@Resource
	}

	@Override
	/**
	 * 获取城市配送信息
	 */
	public Cityline getCitylineInfo(String citylineid) {
		// TODO Auto-generated method stub

		return citylineDao.getCitylineInfo(citylineid);
	}

	@Override
	/**
	 * 获取公司城市配送线路
	 */
	public List getCompanyCityline(String carrierId) {
		// TODO Auto-generated method stub
		return citylineDao.getCompanyCityline(carrierId);
	}

	@Override
	/**
	 * 新增城市配送
	 */
	public boolean insertCityLine(String name, String cityName,
			String VIPService, float refPrice, String remarks, String carrierId, String VIPDetail,
			String path, String fileName) {
		// TODO Auto-generated method stub
		cityline.setId(IdCreator.createCityLineId());
		cityline.setName(name);
		cityline.setCityName(cityName);
		cityline.setVIPService(VIPService);
		cityline.setRefPrice(refPrice);
		cityline.setRemarks(remarks);
		cityline.setCarrierId(carrierId);
		cityline.setRelDate(new Date());
		if(VIPDetail != ""){
			cityline.setVIPDetail(VIPDetail);
		}
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			cityline.setDetailPrice(fileLocation);
		}
		return baseDao.save(cityline);
	}

	@Override
	/**
	 * 更新城市配送
	 */
	public boolean updateLine(String id, String citylineName, String cityName,
			String VIPService, String VIPDetail, float refPrice,
			String remarks, String carrierId,String path,String fileName) {
		// TODO Auto-generated method stub

		cityline = getCitylineInfo(id);// 根据id查找到城市配送信息

		cityline.setName(citylineName);
		cityline.setCityName(cityName);
		cityline.setVIPService(VIPService);
		cityline.setVIPDetail(VIPDetail);
		cityline.setRefPrice(refPrice);
		cityline.setRemarks(remarks);
		cityline.setRelDate(new Date());
		
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			cityline.setDetailPrice(fileLocation);
		}
		return baseDao.update(cityline);

	}
	
	@Override
	/**
	 * 删除城市配送
	 */
	public boolean deleteCityline(String id) {
		cityline = getCitylineInfo(id);// 根据id查找到城市配送信息
		return baseDao.delete(cityline);
	}
}
