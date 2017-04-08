package com.tjw.hrmanage.dao.impl;

import java.util.List;
import java.util.Map;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tjw.hrmanage.dao.IPlanDao;
import com.tjw.hrmanage.model.Plan;

/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:23:23
 * 2016.4
 */
 
public class PlanDaoImpl implements IPlanDao {
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public List<Plan> findAllPlan() {
		List<Plan> list = template.find("from Plan order by planId desc");
		return list;
	}
	public void addPlan(Plan p) throws Exception{
			template.save(p);
	}
	public void updateWithHql(String hql) throws Exception{
		//getCurrentSession()是获取当前线程的session，与当前request请求一致，
		//如果是getSession则没有没加入spring的事务管理器中
		Session session  = template.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}
	public Plan findPlanById(int planId) {
		//get方法是针对主键使用
		Plan p =(Plan) template.get(Plan.class, planId);
		return p;
	}
	
	//使用saveOrUpdate，没有主键则为新增，其他情况为更新
	public void updatePlan(Plan p) {
		template.saveOrUpdate(p);
	}
	public void delPlan(Plan p) {
		template.delete(p);
	}
	/**根据条件查询，使用criteria接口，Expression操作*/
	public List<Plan> findPlanByCondition(Map map) {
		String planTitle = (String) map.get("planTitle");
		Session session = template.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Plan.class);
		if((null!=planTitle)&&(!"".equals(planTitle))){
			criteria.add(Restrictions.like("planTitle", "%"+planTitle+"%"));
		}
		criteria.addOrder(Order.desc("planId"));
		List list = criteria.list();
        return list;
	}
	/**批量删除*/
	public void delPlanBatch(Integer[] planIdArr) throws Exception {
			Session session =  template.getSessionFactory().getCurrentSession();
			String hql = "delete from Plan where planId in (:planIds)";
			Query query = session.createQuery(hql);
			//注意这里是setParameterList方法，参数的是object数组
			query.setParameterList("planIds", planIdArr);
			query.executeUpdate();
	}
	

}
