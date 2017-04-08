package com.tjw.hrmanage.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tjw.hrmanage.dao.ISalaryRecDao;
import com.tjw.hrmanage.model.SalaryRec;
import com.tjw.hrmanage.util.ChangeTimeType;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:23:38
 * 2016.4
 */
 
public class SalaryRecDaoImpl implements ISalaryRecDao {
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public List<SalaryRec> findAllSalaryRec() {
		List<SalaryRec> list = template.find("from SalaryRec");
		return list;
	}
	public void addSalaryRec(SalaryRec sa) {
			template.save(sa);
	}
	
	
	
	public SalaryRec findSalaryRecById(int salaryRecId) {
		//get方法是针对主键使用
		SalaryRec sa =(SalaryRec) template.get(SalaryRec.class, salaryRecId);
		return sa;
	}
	public SalaryRec findSalaryRecBySerialNumber(String emSerialNumber) {
		Session session  = template.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from SalaryRec where emSerialNumber=?");
		query.setString(0,emSerialNumber); 
		List<SalaryRec> list = query.list();
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	//使用saveOrUpdate，没有主键则为新增，其他情况为更新
	public void updateSalaryRec(SalaryRec sa) {
		template.saveOrUpdate(sa);
	}
	public void delSalaryRec(SalaryRec sa) {
		template.delete(sa);
	}
	
	/**根据条件查询，使用criteria接口，Expression操作*/
	public List<SalaryRec> findSalaryRecByCondition(Map map) {
		String emSerialNumber = (String) map.get("emSerialNumber");
		String emName = (String) map.get("emName");
		String payMonth_b = (String) map.get("payMonth_b");
		String payMonth_e = (String) map.get("payMonth_e");
		Date payMonthDate_b=(null!=payMonth_b)&&(!"".equals(payMonth_b))?ChangeTimeType.changeToDate(payMonth_b):null;
		Date payMonthDate_e=(null!=payMonth_e)&&(!"".equals(payMonth_e))?ChangeTimeType.changeToDate(payMonth_e):null;
		String isPay = (String) map.get("isPay");
		Session session = template.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(SalaryRec.class);
		if((null!=emSerialNumber)&&(!"".equals(emSerialNumber))){
			criteria.add(Restrictions.eq("emSerialNumber",emSerialNumber));
		}
		if((null!=emName)&&(!"".equals(emName))){
			criteria.add(Restrictions.eq("emName",emName));
		}
		if(null!=payMonthDate_b||null!=payMonthDate_e){
			criteria.add(Restrictions.between("payMonth", payMonthDate_b, payMonthDate_e));
			
		}
		if((null!=isPay)&&(!"".equals(isPay))&&(!"-1".equals(isPay))){
			criteria.add(Restrictions.eq("isPay",isPay));
		}
		
		List list = criteria.list();
        return list;
	}
	
	/**根据多个薪资记录号查询*/
//	public List<SalaryRec> findSalaryRecByObjArr(Integer[] arr) throws Exception{
//		Session session =  template.getSessionFactory().getCurrentSession();
//		String hql = "from SalaryRec where salaryRecId in (:salaryRecIds)";
//		Query query = session.createQuery(hql);
//		//注意这里是setParameterList方法，参数的是object数组
//		query.setParameterList("salaryRecIds", arr);
//		List li = query.list();
//		return li;
//	}
	/**批量删除*/
	public void delSalaryRecBatch(Integer[] salaryRecIdArr) {
			Session session =  template.getSessionFactory().getCurrentSession();
			String hql = "delete from SalaryRec where salaryRecId in (:salaryRecIds)";
			Query query = session.createQuery(hql);
			//注意这里是setParameterList方法，参数的是object数组
			query.setParameterList("salaryRecIds", salaryRecIdArr);
			query.executeUpdate();
	}
	
	

}
