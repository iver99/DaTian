package cn.edu.bjtu.dao;

/**
 * 
 * @author RussWest0
 *
 */
public interface BaseDao {
	public boolean save(Object obj);
	
	public boolean delete(Object obj);
	
	public boolean update(Object obj);
	
	//public boolean find()
}
