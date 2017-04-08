package com.tjw.hrmanage.dao;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
/**
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:22:19
 * 2016.4
 */
public interface ISalaryBaseDao {
	List<Employee> findAllEm();

	Department getDeptById(int deptId);

	void addEm(Employee e) throws Exception;
	/**根据数据库主键查询*/
	Employee findEmById(int emId);
	/**根据业务主键查询*/
	Employee findEmBySerialNumber(String emSerialNumber);
	
	void updateEm(Employee e);
	
	void updateWithHql(String hql) throws Exception;
	/**根据多个员工号查询*/
	List<Employee> findEmByObjArr(Integer[] arr) throws Exception;
	
	void delEm(Employee e);

	List<Employee> findEmbyDept(int deptId);
	/**根据条件查询，使用criteria接口，Expression操作*/
	List<Employee> findEmByCondition(Map m);

	void delEmBatch(Integer[] emIdArr) throws Exception;
	/**根据多个部门号查询*/
	List<Employee> findEmByDeptArr(Integer[] deptIdArr);

}
