package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Complaintform;

public interface ComplaintDao extends BaseDao<Complaintform>{
	
	public List getUserCompliant(String userId);
	public List getAllUserCompliant();
	/*public Complaintform getComplaintInfo(String id);*/
	public List getFindComplaint(String sql);
}
