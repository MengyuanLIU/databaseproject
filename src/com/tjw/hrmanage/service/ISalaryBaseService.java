package com.tjw.hrmanage.service;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:24:58
 * 2016.4
 */
 
public interface ISalaryBaseService {

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
