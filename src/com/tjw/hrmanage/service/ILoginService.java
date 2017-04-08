package com.tjw.hrmanage.service;

import com.tjw.hrmanage.model.Manager;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:24:37
 * 2016.4
 */
 
public interface ILoginService {

	public Manager login (Manager m) throws Exception;
	public void updateManager(Manager manager) throws Exception;
}
