package com.tjw.hrmanage.service;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
import com.tjw.hrmanage.model.SalaryRec;

/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:25:06
 * 2016.4
 */
 
public interface ISalaryRecService {
	List<SalaryRec> findAllSalaryRec() throws Exception;

	String addSalaryRec(SalaryRec sa) throws Exception;
	/**根据数据库主键查询*/
	SalaryRec findSalaryRecById(int salaryRecId)throws Exception;
	
	/**根据业务主键查询*/
	SalaryRec findSalaryRecBySerialNumber(String emSerialNumber) throws Exception;
	
	String updateSalaryRec(SalaryRec sa) throws Exception;

	String delSalaryRec(int SalaryRecId) throws Exception;
	
	List<SalaryRec> findSalaryRecByCondition(Map map) throws Exception;

	String delSalaryRecBatch(Integer[] emIdArr)throws Exception;
}
