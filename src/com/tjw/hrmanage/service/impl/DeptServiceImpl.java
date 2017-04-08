package com.tjw.hrmanage.service.impl;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.dao.IDeptDao;
import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
import com.tjw.hrmanage.model.Manager;
import com.tjw.hrmanage.service.IDeptService;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:25:34
 * 2016.4
 */

public class DeptServiceImpl implements IDeptService{
	private IDeptDao deptDao;
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}
	public List<Department> findAllDept() throws Exception {
		List<Department> list = deptDao.find1AllDept();
		return list;
	}
	public String addDept(Department d) throws Exception{
		deptDao.addDept(d);
		return "添加成功！";
	}
	public String delDept(int deptId) throws Exception {
		Department d = this.findDeptById(deptId);
		if(d==null){
			throw new Exception("删除失败,记录不存在！");
		}
		this.deptDao.delDept(d);
		return "删除成功！";
	}
	public Department findDeptById(int deptId) throws Exception {
		Department d = deptDao.findDeptById(deptId);
		return d;
	}
	public String updateDept(Department d) throws Exception {
		deptDao.updateDept(d);
		return "修改成功！";
	}
	
	public List<Department> findDeptByCondition(Map<String, String> map) {
		List<Department> list = deptDao.findDeptByCondition(map);
		return list;
	}
	public void delDeptBatch(Integer[] deptIdArr) {
		deptDao.delDeptBatch(deptIdArr);
	}
	
	
}
