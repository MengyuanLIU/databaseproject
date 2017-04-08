package com.tjw.hrmanage.service.impl;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.dao.IManagerDao;
import com.tjw.hrmanage.model.Manager;
import com.tjw.hrmanage.service.IManagerService;
import com.tjw.hrmanage.util.Md5Encrypt;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:26:02
 * 2016.4
 */

public class ManagerServiceImpl implements IManagerService{
	private IManagerDao managerDao;
	public void setManagerDao(IManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	public List<Manager> findAllManager() throws Exception {
		List<Manager> list = managerDao.findAllmanager();
		if(list.size()<1){
			throw new Exception("查询失败");
		}
		return list;
	}
	public String addManager(Manager m) throws Exception  {
		List list = managerDao.findManagerByAccount(m.getAccount());
		if(list.size()>0){
			return "添加失败！该账户名已存在！";
		}
		
		//32位md5加密密码
		String md5Password = Md5Encrypt.md5(m.getPassword(),"utf-8");
		m.setPassword(md5Password);
		managerDao.addManager(m);
		return "添加成功！";
	}
	public String delManager(int managerId) throws Exception {
		Manager m = this.findManagerById(managerId);
		if(m==null){
			throw new Exception("删除的记录不存在！删除失败！");
		}
		managerDao.delManager(m);
		return "删除成功！";
	}
	public Manager findManagerById(int managerId)throws Exception{
		Manager m =managerDao.findManagerById(managerId);
		return m;
	}
	public String updateManager(Manager m2) {
		managerDao.updateManager(m2);
		return "修改用户成功！";
	}
	public void delManagerBatch(Integer[] managerIdArr) {
		managerDao.delDeptBatch(managerIdArr);
		
	}
	public List<Manager> findManagerByCondition(Map<String, String> map) {
		return managerDao.findManagerByCondition(map);
	}
	public String updatePwd(int managerId, String oldPassword,
			String newPassword) throws Exception{
		List<Manager> list = 
			managerDao.findManagerByHQL("from Manager where managerId=? and password=?", new Object[]{managerId,Md5Encrypt.md5(oldPassword)});
		if(list.size()==0){
			return "wrongPwd";
		}
		Manager m = list.get(0);
		m.setPassword(Md5Encrypt.md5(newPassword));
		managerDao.updateManager(m);
		return "修改密码成功，请重新登录！";
	}

}
