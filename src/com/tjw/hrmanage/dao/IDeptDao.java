package com.tjw.hrmanage.dao;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Department;
/**
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:21:33
 * 2016.4
 */
public interface IDeptDao {

	List<Department> find1AllDept();

	void addDept(Department d);

	void delDept(Department d);

	Department findDeptById(int deptId);

	void updateDept(Department d);

	List<Department> findDeptByCondition(Map<String, String> map);

	void delDeptBatch(Integer[] deptIdArr);

}
