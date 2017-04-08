package com.tjw.hrmanage.dao.impl;

import java.util.List;
import java.util.Map;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tjw.hrmanage.dao.IEmDao;
import com.tjw.hrmanage.dao.ISalaryBaseDao;
import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:23:32
 * 2016.4
 */
 
public class SalaryBaseDaoImpl implements ISalaryBaseDao {
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public List<Employee> findAllEm() {
		List<Employee> list = template.find("from Employee");
		return list;
	}
	public Department getDeptById(int deptId) {
		Department dept = (Department) template.get(Department.class, deptId);
		return dept;
	}
	public void addEm(Employee e) throws Exception{
			template.save(e);
	}
	public void updateWithHql(String hql) throws Exception{
		//getCurrentSession()是获取当前线程的session，与当前request请求一致，
		//如果是getSession则没有没加入spring的事务管理器中
		Session session  = template.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}
	/**根据多个员工号查询*/
	public List<Employee> findEmByObjArr(Integer[] arr) throws Exception{
		Session session =  template.getSessionFactory().getCurrentSession();
		String hql = "from Employee where emId in (:emIds)";
		Query query = session.createQuery(hql);
		//注意这里是setParameterList方法，参数的是object数组
		query.setParameterList("emIds", arr);
		List li = query.list();
		return li;
	}
	public Employee findEmById(int emId) {
		//get方法是针对主键使用
		Employee employee =(Employee) template.get(Employee.class, emId);
		return employee;
	}
	public Employee findEmBySerialNumber(String emSerialNumber) {
		Session session  = template.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Employee where emSerialNumber=?");
		query.setString(0,emSerialNumber); 
		List<Employee> list = query.list();
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	//使用saveOrUpdate，没有主键则为新增，其他情况为更新
	public void updateEm(Employee e) {
		template.saveOrUpdate(e);
	}
	public void delEm(Employee e) {
		template.delete(e);
	}
	public List<Employee> findEmbyDept(int deptId) {
		Department dept = this.getDeptById(deptId);
		Session session = template.getSessionFactory().getCurrentSession();
		Criteria cri = session.createCriteria(Employee.class);
		cri.add(Expression.eq("department",dept));
		List<Employee> list = cri.list();
		return list;
	}
	/**根据条件查询，使用criteria接口，Expression操作*/
	public List<Employee> findEmByCondition(Map map) {
		String emSerialNumber = (String) map.get("emSerialNumber");
		String emName = (String) map.get("emName");
		String deptIdStr = (String) map.get("deptId");
		int deptId = 0 ;
		if((null!=deptIdStr)&&(!deptIdStr.equals(""))){
			deptId = Integer.parseInt(deptIdStr);
		}
		Session session = template.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		if((null!=emSerialNumber)&&(!"".equals(emSerialNumber))){
			criteria.add(Restrictions.eq("emSerialNumber",emSerialNumber));
		}
		if((null!=emName)&&(!"".equals(emName))){
			criteria.add(Restrictions.eq("emName",emName));
		}
		if(deptId!=0){
			//注意：如果映射的是对象而获取的是对象的id，那么也不必先通过id查询对象再进行后续操作
			//而是面向对象的思想,对象.属性来设置参数，又如hql=from .....where department.deptId=:deptId
			criteria.add(Restrictions.eq("department.deptId",deptId));
		}
		
		List list = criteria.list();
        return list;
	}
	/**批量删除*/
	public void delEmBatch(Integer[] emIdArr) throws Exception {
			Session session =  template.getSessionFactory().getCurrentSession();
			String hql = "delete from Employee where emId in (:emIds)";
			Query query = session.createQuery(hql);
			//注意这里是setParameterList方法，参数的是object数组
			query.setParameterList("emIds", emIdArr);
			query.executeUpdate();
	}
	/**根据多个部门号查询*/
	public List<Employee> findEmByDeptArr(Integer[] deptIdArr) {
		Session session =  template.getSessionFactory().getCurrentSession();
		String hql = "from Employee where department.deptId in (:deptIds)";
		Query query = session.createQuery(hql);
		//注意这里是setParameterList方法，参数的是object数组
		query.setParameterList("deptIds", deptIdArr);
		List li = query.list();
		return li;
	}
	

}
