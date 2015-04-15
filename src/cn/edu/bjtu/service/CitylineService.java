package cn.edu.bjtu.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.bjtu.vo.Cityline;

public interface CitylineService {
	public List getAllCityline(int Display,int PageNow);
	public List getSelectedCityline(String resourceRate, String serviceIndustry, String creditRate, int Display,int PageNow);
	public int getTotalRows(String resourceRate, String serviceIndustry, String creditRate);
	
	public Cityline getCitylineInfo(String citylineid);
	public List getCompanyCityline(String carrierId);
	public boolean insertCityLine(String name,String cityName,String VIPService,float refPrice,String remarks,String carrierId, String VIPDetail);
	public boolean updateLine(String id, String citylineName, String cityName, String VIPService, String VIPServiceText,
			float refPrice, String remarks, String carrierId);
	public boolean deleteCityline(String id);
}
