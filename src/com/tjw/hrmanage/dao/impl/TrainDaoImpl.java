package com.tjw.hrmanage.dao.impl;

import java.util.List;
import java.util.Map;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tjw.hrmanage.dao.ITrainDao;
import com.tjw.hrmanage.model.Train;

/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:23:45
 * 2016.4
 */
 
public class TrainDaoImpl implements ITrainDao {
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public List<Train> findAllTrain() {
		List<Train> list = template.find("from Train order by trainId desc");
		return list;
	}
	public void addTrain(Train t) throws Exception{
			template.save(t);
	}
	public void updateWithHql(String hql) throws Exception{
		//getCurrentSession()是获取当前线程的session，与当前request请求一致，
		//如果是getSession则没有没加入spring的事务管理器中
		Session session  = template.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}
	public Train findTrainById(int trainId) {
		//get方法是针对主键使用
		Train t =(Train) template.get(Train.class, trainId);
		return t;
	}
	
	//使用saveOrUpdate，没有主键则为新增，其他情况为更新
	public void updateTrain(Train t) {
		template.saveOrUpdate(t);
	}
	public void delTrain(Train t) {
		template.delete(t);
	}
	/**根据条件查询，使用criteria接口，Expression操作*/
	public List<Train> findTrainByCondition(Map map) {
		String trainTitle = (String) map.get("trainTitle");
		Session session = template.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Train.class);
		if((null!=trainTitle)&&(!"".equals(trainTitle))){
			criteria.add(Restrictions.like("trainTitle", "%"+trainTitle+"%"));
		}
		criteria.addOrder(Order.desc("trainId"));
		List list = criteria.list();
        return list;
	}
	/**批量删除*/
	public void delTrainBatch(Integer[] trainIdArr) throws Exception {
			Session session =  template.getSessionFactory().getCurrentSession();
			String hql = "delete from Train where trainId in (:trainIds)";
			Query query = session.createQuery(hql);
			//注意这里是setParameterList方法，参数的是object数组
			query.setParameterList("trainIds", trainIdArr);
			query.executeUpdate();
	}
	

}
