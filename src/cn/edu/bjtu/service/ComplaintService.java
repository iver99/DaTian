package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.bjtu.vo.Complaintform;

public interface ComplaintService {

	public List getUserCompliant(String userId);
	public List getAllUserCompliant();
	public Complaintform getComplaintInfo(String id);
	public boolean insertComplaint(String type, String theme,
			String content, String orderNum, String carrierId,String path,String fileName);
	public boolean doAcceptComplaint(String id, String feedback);
	public List getFindComplaint(String theme,int flag, String clientId);
}
