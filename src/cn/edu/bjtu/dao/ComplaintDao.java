package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Complaintform;

public interface ComplaintDao {
	
	public List getUserCompliant(String userId);
	public Complaintform getComplaintInfo(String id) ;
}
