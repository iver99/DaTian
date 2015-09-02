package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Complaintform;

public interface ComplaintDao extends BaseDao<Complaintform>{
	public List getAllUserCompliant();
	public List getFindComplaint(String sql);
}
