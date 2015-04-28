package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Linetransport;

public interface LinetransportService {

	public List getAllLinetransport(int Display,int PageNow);

	public Linetransport getLinetransportInfo(String linetransportid);

	public List getSelectedLine(String startPlace, String endPlace,
			String type, String startPlace1, String refPrice,int Display,int PageNow);

	public boolean insertLine(String lineName, String startPlace,
			String endPlace, int onWayTime, String type, float refPrice,
			String remarks, String carrierId,String path,String fileName);

	public List getCompanyLine(String carrierId,int Display,int PageNow);

	public String getLinetransportIdByCity(String startPlace, String endPlace);

	public boolean updateLine(String id, String lineName, String startPlace,
			String endPlace, int onWayTime, String type, float refPrice,
			String remarks, String carrierId,String path,String fileName);
	
	public int getTotalRows(String startPlace, String endPlace,
			String type, String startPlace1, String refPrice);
	
	public int getCompanyTotalRows(String carrierId);
	
	public boolean deleteLine(String id);
	
}
