package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.search.CompanySearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;

import com.alibaba.fastjson.JSONArray;

public interface CompanyService {
	
	
	/*public Carrierinfo getCarrierInfo(String id);*/
	public List getLinetransportByCarrierId(String id);
	public List getCitylineByCarrierId(String id);
	public List getwarehouseByCarrierId(String id);

	public Carrierinfo getCompanyById(String carrierId);
	
	/**
	 * 资源栏-公司筛选
	 * @Title: getSelectedCompanyNew 
	 *  
	 * @param: @param companyBean
	 * @param: @param pageUtil
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年6月15日 下午4:42:53
	 */
	public JSONArray getSelectedCompanyNew(CompanySearchBean companyBean,PageUtil pageUtil,HttpSession session);
	
	/**
	 * 资源栏公司筛选总记录数
	 * @Title: getSelectedCompanyTotalRows 
	 *  
	 * @param: @param companyBean
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年6月15日 下午4:43:04
	 */
	public Integer getSelectedCompanyTotalRows(CompanySearchBean companyBean);
	
	/**
	 * 获取已通过验证的公司
	 * @param session
	 * @return
	 */
	public JSONArray getCertificatedCompany(HttpSession session);
}
