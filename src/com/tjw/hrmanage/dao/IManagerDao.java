package com.tjw.hrmanage.dao;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Manager;
/**
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:22:02
 * 2016.4
 */
public interface IManagerDao {

	List<Manager> findAllmanager();

	void addManager(Manager m);

	void delManager(Manager m);
	
	Manager findManagerById(int managerId);

	void updateManager(Manager m2);

	void delDeptBatch(Integer[] managerIdArr);

	List<Manager> findManagerByCondition(Map<String, String> map);
	
	List<Manager> findManagerByAccount(String account);
	
	public List<Manager> findManagerByHQL(String hql,Object[] objArr);
}
