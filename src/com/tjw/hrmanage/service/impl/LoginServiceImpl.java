package com.tjw.hrmanage.service.impl;

import com.tjw.hrmanage.dao.ILoginDao;
import com.tjw.hrmanage.dao.IManagerDao;
import com.tjw.hrmanage.model.Manager;
import com.tjw.hrmanage.service.ILoginService;
import com.tjw.hrmanage.util.Md5Encrypt;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:25:50
 * 2016.4
 */

public class LoginServiceImpl implements ILoginService {
	private ILoginDao loginDao;
	private IManagerDao managerDao;
	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	public void setManagerDao(IManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public Manager login(Manager m) throws Exception {
		//登录的密码进行md5加密后验证
		m.setPassword(Md5Encrypt.md5(m.getPassword(),"utf-8"));
		Manager manager = loginDao.login(m);
		if(manager==null){
			throw new Exception("userOrPwdWrong");
			//throw异常以后，后面的代码就不会执行了
		}
		
		//更新此用户登录次数
		manager.setLoginCnt(manager.getLoginCnt()+1);
		managerDao.updateManager(manager);
		return manager;
	}
	public void updateManager(Manager manager) throws Exception{
		managerDao.updateManager(manager);
	}
}
