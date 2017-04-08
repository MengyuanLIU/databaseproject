package com.tjw.hrmanage.service.impl;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.dao.IEmDao;
import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
import com.tjw.hrmanage.service.IEmService;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:25:44
 * 2016.4
 */

public class EmServiceImpl implements IEmService {
	private IEmDao emDao;
	public void setEmDao(IEmDao emDao) {
		this.emDao = emDao;
	}

	public List<Employee> findAllEm() throws Exception {
		List<Employee> list = emDao.findAllEm();
		return list;
	}

	public Department findDeptById(int deptId) throws Exception {
		Department dept = emDao.getDeptById(deptId);
		return dept;
	}

	public String addEm(Employee e) throws Exception {
		emDao.addEm(e);
		//添加员工的同时更新部门表
		String hql = "update Department set peopleNum=peopleNum+1 where deptId="+e.getDepartment().getDeptId(); 
		emDao.updateWithHql(hql);
		return "添加成功！";
	}

	public Employee findEmById(int emId) throws Exception {
		Employee employee=emDao.findEmById(emId);
		return employee;
	}
	
	public Employee findEmBySerialNumber(String emSerialNumber)throws Exception {
		Employee employee=emDao.findEmBySerialNumber(emSerialNumber);
		return employee;
	}
	
	public String updateEm(Employee e) throws Exception {
		emDao.updateEm(e);
		return "修改成功！";
	}

	public String delEm(int emId) throws Exception {
		Employee em = this.findEmById(emId);
		if(em==null){
			throw new Exception("要删除的记录不存在！");
		}
		emDao.delEm(em);
		//删除员工的同时更新部门表
		String hql = "update Department set peopleNum=peopleNum-1 where deptId="+em.getDepartment().getDeptId(); 
		emDao.updateWithHql(hql);
		return "删除成功！";
	}

	public List<Employee> findEmByDept(int deptId) throws Exception {
		List<Employee> list=emDao.findEmbyDept(deptId);
		return list;
	}

	public List<Employee> findEmByCondition(Map m) throws Exception {
		List<Employee> list = emDao.findEmByCondition(m);
		return list;
	}
	//批量删除员工
	public String delEmBatch(Integer[] emIdArr)throws Exception {
		List<Employee> emList = emDao.findEmByObjArr(emIdArr);
		emDao.delEmBatch(emIdArr);
		//批量删除员工的同时更新部门表
		for(int i =0 ;i<emList.size();i++){
			int deptId = emList.get(i).getDepartment().getDeptId();
			String hqlStr = "update Department set peopleNum=peopleNum-1 where deptId="+deptId; 
			emDao.updateWithHql(hqlStr);
		}
		return "删除成功！";
	}

	public List<Employee> findEmByDeptArr(Integer[] deptIdArr) {
		
		return emDao.findEmByDeptArr(deptIdArr);
	}

	

}
