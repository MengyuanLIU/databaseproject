package com.tjw.hrmanage.dao;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.SalaryRec;
/**
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:22:33
 * 2016.4
 */

public interface ISalaryRecDao {
	List<SalaryRec> findAllSalaryRec() ;

	void addSalaryRec(SalaryRec sa) ;
	/**根据数据库主键查询*/
	SalaryRec findSalaryRecById(int salaryRecId);
	
	/**根据业务主键查询*/
	SalaryRec findSalaryRecBySerialNumber(String emSerialNumber) ;
	
	void updateSalaryRec(SalaryRec sa) ;

	void delSalaryRec(SalaryRec sa) ;
	
	List<SalaryRec> findSalaryRecByCondition(Map map) ;

	void delSalaryRecBatch(Integer[] emIdArr);
}
