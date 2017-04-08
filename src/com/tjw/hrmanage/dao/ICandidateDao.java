package com.tjw.hrmanage.dao;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Candidate;
/**
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:21:11
 * 2016.4
 */
public interface ICandidateDao {
	List<Candidate> findAllCdt();


	void addCdt(Candidate c) throws Exception;
	/**根据数据库主键查询*/
	Candidate findCdtById(int cdtId);
	/**根据业务主键查询*/
	
	void updateCdt(Candidate c);
	
	void updateWithHql(String hql) throws Exception;
	
	void delCdt(Candidate e);

	/**根据条件查询，使用criteria接口，Expression操作*/
	List<Candidate> findCdtByCondition(Map m);

	void delCdtBatch(Integer[] cdtIdArr) throws Exception;

}
