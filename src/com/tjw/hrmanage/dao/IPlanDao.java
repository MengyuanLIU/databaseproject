package com.tjw.hrmanage.dao;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Plan;


public interface IPlanDao {
	
	List<Plan> findAllPlan();

	void addPlan(Plan p) throws Exception;
	/**根据数据库主键查询*/
	Plan findPlanById(int planId);
	/**根据业务主键查询*/
	
	void updatePlan(Plan p);
	
	void updateWithHql(String hql) throws Exception;
	
	void delPlan(Plan p);

	/**根据条件查询，使用criteria接口，Expression操作*/
	List<Plan> findPlanByCondition(Map m);

	void delPlanBatch(Integer[] planIdArr) throws Exception;

}
