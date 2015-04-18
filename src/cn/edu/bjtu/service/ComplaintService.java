package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.bjtu.vo.Complaintform;

public interface ComplaintService {

	public List getUserCompliant(String userId);
	public Complaintform getComplaintInfo(String id);
	public boolean insertComplaint(String type, String theme,
			String content, String orderNum, String carrierId,
			HttpServletRequest request, HttpServletResponse response);
}
