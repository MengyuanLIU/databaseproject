package com.tjw.hrmanage.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tjw.hrmanage.dao.IManagerDao;
import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Manager;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:23:17
 * 2016.4
 */
 
public class ManagerDaoImpl implements IManagerDao{
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public List<Manager> findAllmanager() {
		List<Manager> list =this.template.find("from Manager");
		return list;
	}
	public void addManager(Manager m) {
		this.template.save(m);
	}
	public void delManager(Manager m) {
		this.template.delete(m);
	}
	/**查找一条管理员信息*/
	public Manager findManagerById(int managerId){
		Manager m = (Manager) this.template.get(Manager.class, managerId);
		return m;
	}
	/**修改*/
	public void updateManager(Manager m2) {
		this.template.update(m2);
	}
	/**批量删除*/
	public void delDeptBatch(Integer[] managerIdArr) {
		Session session =  template.getSessionFactory().getCurrentSession();
		String hql = "delete from Manager where managerId in (:managerIds)";
		Query query = session.createQuery(hql);
		query.setParameterList("managerIds", managerIdArr);
		query.executeUpdate();
	}
	/**根据条件查询，使用criteria接口，Expression操作*/
	public List<Manager> findManagerByCondition(Map<String, String> map) {
		String account = (String) map.get("account");
		String managerLevel = (String) map.get("managerLevel");
		Session session = template.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Manager.class);
		if((null!=account)&&(!"".equals(account))){
			criteria.add(Restrictions.eq("account",account));
		}
		if("0".equals(managerLevel)||"1".equals(managerLevel)){
			//注意：如果映射的是对象而获取的是对象的id，那么也不必先通过id查询对象再进行后续操作
			//而是面向对象的思想,对象.属性来设置参数，又如hql=from .....where department.deptId=:deptId
			criteria.add(Restrictions.eq("managerLevel",managerLevel));
		}
		
		List list = criteria.list();
        return list;
	}
	public List<Manager> findManagerByAccount(String account) {
		List<Manager> list = this.template.find("from Manager where account=?",account);
		//this.template.find("from Manager where account=? and xx=?",new String[]{"test", "123"});
		return list;
	}
	//通用查询方法
	public List<Manager> findManagerByHQL(String hql,Object[] objArr){
		List<Manager> list = this.template.find(hql,objArr);
		return list;
	}
}
