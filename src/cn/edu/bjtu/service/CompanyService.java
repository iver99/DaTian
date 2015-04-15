package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Carrierinfo;

public interface CompanyService {
	
	public List getAllCompany(int Display,int PageNow);
	public List getSelectedCompany(String resourceRate, String serviceIndustry, 
			String creditRate, String business, int Display,int PageNow);
	public int getTotalRows(String resourceRate, String serviceIndustry, 
			String creditRate, String business);
	
	public Carrierinfo getCarrierInfo(String id);

}
