package com.tjw.hrmanage.service;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Manager;

/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:24:45
 * 2016.4
 */
 
public interface IManagerService {

	List<Manager> findAllManager() throws Exception;

	String addManager(Manager m) throws Exception ;

	String delManager(int managerId) throws Exception;
	
	Manager findManagerById(int managerId)throws Exception;

	String updateManager(Manager m2);

	void delManagerBatch(Integer[] managerIdArr);

	List<Manager> findManagerByCondition(Map<String, String> map);

	String updatePwd(int managerId, String oldPassword, String newPassword) throws Exception;
}
