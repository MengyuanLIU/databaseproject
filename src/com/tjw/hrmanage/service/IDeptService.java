package com.tjw.hrmanage.service;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Department;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:24:26
 * 2016.4
 */

public interface IDeptService {

	List<Department> findAllDept() throws Exception;

	String addDept(Department d) throws Exception;

	String delDept(int deptId) throws Exception;
	
	Department findDeptById(int deptId) throws Exception;
	/**修改部门信息*/
	String updateDept(Department d) throws Exception;

	List<Department> findDeptByCondition(Map<String, String> map);

	void delDeptBatch(Integer[] deptIdArr);
	
}
