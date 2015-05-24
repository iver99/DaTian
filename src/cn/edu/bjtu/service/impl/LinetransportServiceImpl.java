package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.LinetransportDao;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.HQLTool;
import cn.edu.bjtu.util.HQL_POJO;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Linetransport;

@Transactional
@Service
/**
 * 
 * @author RussWest0
 *
 */
public class LinetransportServiceImpl implements LinetransportService {

	@Resource
	LinetransportDao linetransportDao;
	@Resource
	Linetransport linetransport;
	/*@Resource
	BaseDao baseDao;*/
	@Resource
	HQLTool hqltool;

	private String hql = "";
	private static boolean flag = false;

	@Override
	/**
	 * 返回所有干线列表
	 */
	public List getAllLinetransport(int Display, int PageNow) {
		// TODO Auto-generated method stub
		return linetransportDao.getAllLinetransport(Display, PageNow);
	}

	@Override
	/**
	 * 返回干线信息
	 */
	public Linetransport getLinetransportInfo(String linetransportid) {
		// TODO Auto-generated method stub
		return linetransportDao.getLinetransportInfo(linetransportid);
	}

	@Override
	/**
	 * 条件筛选干线
	 */
	public List getSelectedLine(String startPlace, String endPlace,
			String type, String startPlace1, String refPrice, int Display,
			int PageNow) {
		// TODO Auto-generated method stub

		String sql = "";
		if (refPrice.equals("大于2元/kg")) {
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
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
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where refPrice >= 1 and refPrice <= 2";
			} else
				sql += "and refPrice >= 1 and refPrice <= 2";
		} else if (refPrice.equals("小于1元/kg")) {
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
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
		} else {
			String[] paramList = { "startPlace", "endPlace", "type", "refPrice" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type, refPrice };
			sql = spellHql2(paramList, valueList);
		}

		System.out.println(sql);
		// System.out.println("hql+" + sql);
		return linetransportDao.getSelectedLine(sql, Display, PageNow);
		// return null;

	}

	@Override
	/**
	 * 获取总记录条数 
	 */
	public int getTotalRows(String startPlace, String endPlace, String type,
			String startPlace1, String refPrice) {
		// TODO Auto-generated method stub
		String sql = "";
		if (refPrice.equals("大于2元/kg")) {
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
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
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
			int i = 0;
			for (; i < paramList.length; i++) {
				if (!(valueList[i].equals("All"))) {
					break;
				}
			}
			if (i == paramList.length) {
				// 要是所有项都等于All，即要补上where字段
				sql += "where refPrice >= 1 and refPrice <= 2";
			} else
				sql += "and refPrice >= 1 and refPrice <= 2";
		} else if (refPrice.equals("小于1元/kg")) {
			String[] paramList = { "startPlace", "endPlace", "type" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type };
			sql = spellHql2(paramList, valueList);
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
		} else {
			String[] paramList = { "startPlace", "endPlace", "type", "refPrice" };// 没startplace1
			String[] valueList = { startPlace, endPlace, type, refPrice };
			sql = spellHql2(paramList, valueList);
		}
		// System.out.println("hql+"+sql);
		return hqltool.getTotalRows(sql);// 这里的HQLTool实例千万不能自己new出来，用@Resource
	}

	/**
	 * 工具函数-拼接hql
	 * 
	 * @param paramList
	 * @param valueList
	 * @return 返回拼接好的hql语句
	 */
	private String spellHql2(String[] paramList, String[] valueList) {
		HQL_POJO hqlobj = new HQL_POJO();
		hqlobj.hql = "from LineCarrierView ";// 会变化
		for (int i = 0; i < paramList.length; i++) {
			if (!(valueList[i].equals("All")))// 要是等于all，说明是默认的，即不写到where子句
			{
				hqlobj.hql += HQLTool.spellHql(hqlobj).hql;
				hqlobj.hql += paramList[i] + "='" + valueList[i] + "' ";
			}
		}
		return hqlobj.hql;
	}

	/*
	 * public static void main(String[] args) { int i = new
	 * LinetransportServiceImpl().getTotalRows("All", "All", "All", "All",
	 * "All"); }
	 */

	@Override
	/**
	 * 新增干线
	 */
	public boolean insertLine(String lineName, String startPlace,
			String endPlace, int onWayTime, String type, float refPrice,
			String remarks, String carrierId, String path, String fileName) {
		// TODO Auto-generated method stub
		linetransport.setCarrierId(carrierId);// 插入session里的carrierid
		// linetransport.setDetailPrice(detailPrice);
		linetransport.setEndPlace(endPlace);
		linetransport.setId(IdCreator.createlineTransportId());
		linetransport.setOnWayTime(onWayTime);
		linetransport.setRefPrice(refPrice);
		linetransport.setRelDate(new Date());
		linetransport.setRemarks(remarks);
		linetransport.setStartPlace(startPlace);
		linetransport.setType(type);
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			linetransport.setDetailPrice(fileLocation);
		}
		linetransportDao.save(linetransport);// 保存实体
		return false;

	}

	@Override
	/**
	 * 返回某公司的所有干线信息
	 */
	public List getCompanyLine(String carrierId, int Display, int PageNow) {
		// TODO Auto-generated method stub
		return linetransportDao.getCompanyLine(carrierId, Display, PageNow);// 未完成
	}

	@Override
	// 未实现
	public String getLinetransportIdByCity(String startPlace, String endPlace) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int getCompanyTotalRows(String carrierId) {
		// TODO Auto-generated method stub
		return linetransportDao.getCompanyTotalRows(carrierId);
	}

	@Override
	/**
	 * 更新干线
	 */
	public boolean updateLine(String id, String lineName, String startPlace,
			String endPlace, int onWayTime, String type, float refPrice,
			String remarks, String carrierId, String path, String fileName) {
		// TODO Auto-generated method stub

		linetransport = getLinetransportInfo(id);// 根据id查找到干线信息

		linetransport.setStartPlace(startPlace);
		linetransport.setEndPlace(endPlace);
		linetransport.setOnWayTime(onWayTime);
		linetransport.setType(type);
		linetransport.setRefPrice(refPrice);
		linetransport.setRemarks(remarks);
		linetransport.setRelDate(new Date());
		// 保存文件路径
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			linetransport.setDetailPrice(fileLocation);
		}

		linetransportDao.update(linetransport);
		return false;

	}

	@Override
	/**
	 * 删除干线
	 */
	public boolean deleteLine(String id) {
		linetransport = getLinetransportInfo(id);// 根据id查找到干线信息

		System.out.println(linetransport);
		System.out.println(id);
		linetransportDao.delete(linetransport);
		
		return false;
	}

}
