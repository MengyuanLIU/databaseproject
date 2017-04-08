package com.tjw.hrmanage.service;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Plan;

/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:24:51
 * 2016.4
 */
 
public interface IPlanService {
	List<Plan> findAllPlan() throws Exception;


	String addPlan(Plan p) throws Exception;
	/**根据数据库主键查询*/
	Plan findPlanById(int planId)throws Exception;
	
	String updatePlan(Plan p) throws Exception;

	String delPlan(int planId) throws Exception;

	List<Plan> findPlanByCondition(Map map) throws Exception;

	String delPlanBatch(Integer[] planIdArr)throws Exception;
}
