package com.tjw.hrmanage.dao.impl;

import java.util.List;
import java.util.Map;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tjw.hrmanage.dao.ICandidateDao;
import com.tjw.hrmanage.dao.IEmDao;
import com.tjw.hrmanage.model.Candidate;
import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
/**
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:20:59
 * 2016.4
 */
public class CandidateDaoImpl implements ICandidateDao {
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public List<Candidate> findAllCdt() {
		List<Candidate> list = template.find("from Candidate");
		return list;
	}
	public void addCdt(Candidate c) throws Exception{
			template.save(c);
	}
	public void updateWithHql(String hql) throws Exception{
		//getCurrentSession()是获取当前线程的session，与当前request请求一致，
		//如果是getSession则没有没加入spring的事务管理器中
		Session session  = template.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}
	public Candidate findCdtById(int cdtId) {
		//get方法是针对主键使用
		Candidate c =(Candidate) template.get(Candidate.class, cdtId);
		return c;
	}
	
	//使用saveOrUpdate，没有主键则为新增，其他情况为更新
	public void updateCdt(Candidate c) {
		template.saveOrUpdate(c);
	}
	public void delCdt(Candidate c) {
		template.delete(c);
	}
	/**根据条件查询，使用criteria接口，Expression操作*/
	public List<Candidate> findCdtByCondition(Map map) {
		String cdtName = (String) map.get("cdtName");
		String isHire = (String) map.get("isHire");
		Session session = template.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Candidate.class);
		if((null!=cdtName)&&(!"".equals(cdtName))){
			criteria.add(Restrictions.eq("cdtName",cdtName));
		}
		if((null!=isHire)&&(!"".equals(isHire))&&(!"no".equals(isHire))){
			criteria.add(Restrictions.eq("isHire",isHire));
		}
		
		List list = criteria.list();
        return list;
	}
	/**批量删除*/
	public void delCdtBatch(Integer[] cdtIdArr) throws Exception {
			Session session =  template.getSessionFactory().getCurrentSession();
			String hql = "delete from Candidate where cdtId in (:cdtIds)";
			Query query = session.createQuery(hql);
			//注意这里是setParameterList方法，参数的是object数组
			query.setParameterList("cdtIds", cdtIdArr);
			query.executeUpdate();
	}
	

}
