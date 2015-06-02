package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Userinfo;

public interface RegisterDao extends BaseDao<Userinfo>{
	public List getUserCheck(String username);

}
