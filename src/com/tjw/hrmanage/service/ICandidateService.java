package com.tjw.hrmanage.service;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Candidate;
import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:24:19
 * 2016.4
 */

public interface ICandidateService {

	List<Candidate> findAllCdt() throws Exception;


	String addCdt(Candidate c) throws Exception;
	/**根据数据库主键查询*/
	Candidate findCdtById(int cdtId)throws Exception;
	
	
	String updateCdt(Candidate c) throws Exception;

	String delCdt(int cdtId) throws Exception;

	
	List<Candidate> findCdtByCondition(Map map) throws Exception;

	String delCdtBatch(Integer[] cdtIdArr)throws Exception;


	String listHire(int cdtId) throws Exception;

}
