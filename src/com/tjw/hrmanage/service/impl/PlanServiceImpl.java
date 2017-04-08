package com.tjw.hrmanage.service.impl;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.dao.IPlanDao;
import com.tjw.hrmanage.model.Plan;
import com.tjw.hrmanage.service.IPlanService;

/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:26:08
 * 2016.4
 */
 
public class PlanServiceImpl implements IPlanService {
	private IPlanDao planDao;

	public void setPlanDao(IPlanDao planDao) {
		this.planDao = planDao;
	}


	public List<Plan> findAllPlan() throws Exception {
		List<Plan> list = planDao.findAllPlan();
		return list;
	}


	public String addPlan(Plan p) throws Exception {
		planDao.addPlan(p);
		return "添加成功！";
	}

	public Plan findPlanById(int planId) throws Exception {
		Plan p=planDao.findPlanById(planId);
		return p;
	}
	
	
	public String updatePlan(Plan p) throws Exception {
		planDao.updatePlan(p);
		return "修改成功！";
	}

	public String delPlan(int planId) throws Exception {
		Plan t = this.findPlanById(planId);
		if(t==null){
			throw new Exception("要删除的记录不存在！");
		}
		planDao.delPlan(t);
		return "删除成功！";
	}


	public List<Plan> findPlanByCondition(Map m) throws Exception {
		List<Plan> list = planDao.findPlanByCondition(m);
		return list;
	}
	//批量删除
	public String delPlanBatch(Integer[] planIdArr)throws Exception {
		planDao.delPlanBatch(planIdArr);
		return "删除成功！";
	}

}
