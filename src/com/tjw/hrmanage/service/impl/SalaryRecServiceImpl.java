package com.tjw.hrmanage.service.impl;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.dao.ISalaryRecDao;
import com.tjw.hrmanage.model.SalaryRec;
import com.tjw.hrmanage.service.ISalaryRecService;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:26:20
 * 2016.4
 */

public class SalaryRecServiceImpl implements ISalaryRecService {
	private ISalaryRecDao salaryRecDao;

	public void setSalaryRecDao(ISalaryRecDao salaryRecDao) {
		this.salaryRecDao = salaryRecDao;
	}


	public List<SalaryRec> findAllSalaryRec() throws Exception {
		List<SalaryRec> list = salaryRecDao.findAllSalaryRec();
		return list;
	}


	public String addSalaryRec(SalaryRec sa) throws Exception {
		salaryRecDao.addSalaryRec(sa);
		return "添加成功！";
	}

	public SalaryRec findSalaryRecById(int salaryRecId) throws Exception {
		SalaryRec sa=salaryRecDao.findSalaryRecById(salaryRecId);
		return sa;
	}
	
	public SalaryRec findSalaryRecBySerialNumber(String emSerialNumber)throws Exception {
		SalaryRec sa=salaryRecDao.findSalaryRecBySerialNumber(emSerialNumber);
		return sa;
	}
	
	public String updateSalaryRec(SalaryRec sa) throws Exception {
		salaryRecDao.updateSalaryRec(sa);
		return "修改成功！";
	}

	public String delSalaryRec(int salaryRecId) throws Exception {
		SalaryRec sa = this.findSalaryRecById(salaryRecId);
		if(sa==null){
			throw new Exception("要删除的记录不存在！");
		}
		salaryRecDao.delSalaryRec(sa);
		return "删除成功！";
	}


	public List<SalaryRec> findSalaryRecByCondition(Map m) throws Exception {
		List<SalaryRec> list = salaryRecDao.findSalaryRecByCondition(m);
		return list;
	}
	//批量删除
	public String delSalaryRecBatch(Integer[] salaryRecIdArr)throws Exception {
		salaryRecDao.delSalaryRecBatch(salaryRecIdArr);
		return "删除成功！";
	}

	



	

}
