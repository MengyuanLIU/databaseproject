package com.tjw.hrmanage.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tjw.hrmanage.dao.ILoginDao;
import com.tjw.hrmanage.model.Manager;

/**
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:23:07
 * 2016.4
 */
public class LoginDaoImpl implements ILoginDao{
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public Manager login(Manager m) {
		String hql = "from Manager m where m.account=? and m.password=?";
		List<Manager> list = this.template.find(hql,new Object[]{m.getAccount(),m.getPassword()});
		if(list.size()<1){
		return null;
		}else{
		return (Manager)list.get(0);
		}
	}

}
