package com.tjw.hrmanage.service;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
/** 
 * Copyright (c) 2011.

 * @author 田竞文 E-mail: tjwen@126.com
 * @version 创建时间：2011-11-21 下午05:28:36 
 *
 * 类说明 
 */
public interface IEmService {

	List<Employee> findAllEm() throws Exception;

	Department findDeptById(int deptId) throws Exception;

	String addEm(Employee e) throws Exception;
	/**根据数据库主键查询*/
	Employee findEmById(int emId)throws Exception;
	
	/**根据业务主键查询*/
	Employee findEmBySerialNumber(String emSerialNumber) throws Exception;
	
	
	String updateEm(Employee e) throws Exception;

	String delEm(int emId) throws Exception;

	List<Employee> findEmByDept(int deptId) throws Exception;
	
	List<Employee> findEmByCondition(Map map) throws Exception;

	String delEmBatch(Integer[] emIdArr)throws Exception;

	List<Employee> findEmByDeptArr(Integer[] deptIdArr);
}
