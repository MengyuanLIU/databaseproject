package com.tjw.hrmanage.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tjw.hrmanage.dao.IDeptDao;
import com.tjw.hrmanage.model.Department;
/**
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:22:56
 * 2016.4
 */
public class DeptDaoImpl implements IDeptDao {
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public List<Department> find1AllDept() {
		List<Department> list = this.template.find("from Department");
		return list;
	}
	public void addDept(Department d) {
		template.save(d);
	}
	public void delDept(Department d) {
		template.delete(d);
	}
	public Department findDeptById(int deptId) {
		Department d = (Department) template.get(Department.class, deptId);
		return d;
	}
	
	//使用saveOrUpdate，没有主键则为新增，其他情况为更新
	public void updateDept(Department d) {
		template.saveOrUpdate(d);
	}
	
	/**根据条件查询，使用criteria接口，Expression操作*/
	public List<Department> findDeptByCondition(Map<String, String> map) {
		String deptName = (String) map.get("deptName");
		String deptIdStr = (String) map.get("deptId");
		int deptId = 0 ;
		if((null!=deptIdStr)&&(!deptIdStr.equals(""))){
			deptId = Integer.parseInt(deptIdStr);
		}
		Session session = template.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Department.class);
		if((null!=deptName)&&(!"".equals(deptName))){
			criteria.add(Restrictions.eq("deptName",deptName));
		}
		if(deptId!=0){
			//注意：如果映射的是对象而获取的是对象的id，那么也不必先通过id查询对象再进行后续操作
			//而是面向对象的思想,对象.属性来设置参数，又如hql=from .....where department.deptId=:deptId
			criteria.add(Restrictions.eq("deptId",deptId));
		}
		
		List list = criteria.list();
        return list;
	}
	public void delDeptBatch(Integer[] deptIdArr) {
		Session session =  template.getSessionFactory().getCurrentSession();
		String hql = "delete from Department where deptId in (:deptIds)";
		Query query = session.createQuery(hql);
		//注意这里是setParameterList方法，参数的是object数组
		query.setParameterList("deptIds", deptIdArr);
		query.executeUpdate();
	}

}
