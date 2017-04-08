package com.tjw.hrmanage.service.impl;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.dao.ISalaryBaseDao;
import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
import com.tjw.hrmanage.service.ISalaryBaseService;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:26:14
 * 2016.4
 */

public class SalaryBaseServiceImpl implements ISalaryBaseService {
	private ISalaryBaseDao salaryBaseDao;

	public void setSalaryBaseDao(ISalaryBaseDao salaryBaseDao) {
		this.salaryBaseDao = salaryBaseDao;
	}

	public List<Employee> findAllEm() throws Exception {
		List<Employee> list = salaryBaseDao.findAllEm();
		return list;
	}

	public Department findDeptById(int deptId) throws Exception {
		Department dept = salaryBaseDao.getDeptById(deptId);
		return dept;
	}

	public String addEm(Employee e) throws Exception {
		salaryBaseDao.addEm(e);
		//添加员工的同时更新部门表
		String hql = "update Department set peopleNum=peopleNum+1 where deptId="+e.getDepartment().getDeptId(); 
		salaryBaseDao.updateWithHql(hql);
		return "添加成功！";
	}

	public Employee findEmById(int emId) throws Exception {
		Employee employee=salaryBaseDao.findEmById(emId);
		return employee;
	}
	
	public Employee findEmBySerialNumber(String emSerialNumber)throws Exception {
		Employee employee=salaryBaseDao.findEmBySerialNumber(emSerialNumber);
		return employee;
	}
	
	public String updateEm(Employee e) throws Exception {
		salaryBaseDao.updateEm(e);
		return "修改成功！";
	}

	public String delEm(int emId) throws Exception {
		Employee em = this.findEmById(emId);
		if(em==null){
			throw new Exception("要删除的记录不存在！");
		}
		salaryBaseDao.delEm(em);
		//删除员工的同时更新部门表
		String hql = "update Department set peopleNum=peopleNum-1 where deptId="+em.getDepartment().getDeptId(); 
		salaryBaseDao.updateWithHql(hql);
		return "删除成功！";
	}

	public List<Employee> findEmByDept(int deptId) throws Exception {
		List<Employee> list=salaryBaseDao.findEmbyDept(deptId);
		return list;
	}

	public List<Employee> findEmByCondition(Map m) throws Exception {
		List<Employee> list = salaryBaseDao.findEmByCondition(m);
		return list;
	}
	//批量删除员工
	public String delEmBatch(Integer[] emIdArr)throws Exception {
		List<Employee> emList = salaryBaseDao.findEmByObjArr(emIdArr);
		salaryBaseDao.delEmBatch(emIdArr);
		//批量删除员工的同时更新部门表
		for(int i =0 ;i<emList.size();i++){
			int deptId = emList.get(i).getDepartment().getDeptId();
			String hqlStr = "update Department set peopleNum=peopleNum-1 where deptId="+deptId; 
			salaryBaseDao.updateWithHql(hqlStr);
		}
		return "删除成功！";
	}

	public List<Employee> findEmByDeptArr(Integer[] deptIdArr) {
		
		return salaryBaseDao.findEmByDeptArr(deptIdArr);
	}

	

}
