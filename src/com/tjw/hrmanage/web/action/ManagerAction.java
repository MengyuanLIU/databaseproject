package com.tjw.hrmanage.web.action;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Manager;
import com.tjw.hrmanage.service.IManagerService;
import com.tjw.hrmanage.util.ChangeTimeType;
import com.tjw.hrmanage.util.MyPagination;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:28:15
 * 2016.4
 */

public class ManagerAction extends ActionSupport{
	private IManagerService managerService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	public void setManagerService(IManagerService managerService) {
		this.managerService = managerService;
	}
	private String account;
	 
	private String password;
	 
	private String managerLevel;
	
	private String realName;
	/**
	 * 注册日期
	 */
	private String regDate;
	
	

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getManagerLevel() {
		return managerLevel;
	}

	public void setManagerLevel(String managerLevel) {
		this.managerLevel = managerLevel;
	}
	
	/**查询所有管理员*/
	public String findAllManager()
			{
		
		
		String PageStr = request.getParameter("Page");
		int Page=1;
		if(PageStr==null){
			Page=1;
		}else{
			Page = Integer.parseInt(PageStr);
			
		}
		
		try{
			List<Manager> list = managerService.findAllManager();
			//分页操作
			MyPagination pageination = new MyPagination();
			List pageList = pageination.getInitPage(list, Page, -1);
			String printCtrl = pageination.printCtrl(Page,"manager_findAllManager.action?");
			request.setAttribute("managerList", pageList);
			request.setAttribute("printCtrl", printCtrl);
			return "managerFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**添加账户展示页面*/
	public String addManagerPage()
			throws Exception {
		try{
			return "managerAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	/**添加账户*/
	public String addManager()
			throws Exception {
		Manager m = new Manager();
		m.setAccount(getAccount());
		m.setPassword(getPassword());
		m.setManagerLevel(getManagerLevel());
		m.setRealName(getRealName());
		m.setRegDate(ChangeTimeType.changeToDate(getRegDate()));
		try{
			String str = managerService.addManager(m);;
			//设置返回相应页面标识
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "managerAdd";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			
			return "error";
		}
	}
	
	/**删除账户*/
	public String delManager()
			throws Exception {
			String managerIdStr = request.getParameter("managerId");
		try{
			int managerId=0;
			if(managerIdStr!=null){
				 managerId = Integer.parseInt(managerIdStr);
			}else{
				throw new Exception("获取账户信息出错！");
			}
			String str = managerService.delManager(managerId);
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "managerDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**批量删除账户信息*/
	public String delManagerBatch()
			throws Exception{
		String managerIdStr = request.getParameter("managerIds");
		try{
			Integer[] managerIdArr=null;
			if(managerIdStr!=null&managerIdStr!=""){
				String[] managerIdStrArr = managerIdStr.split(",");
				managerIdArr= new Integer[managerIdStrArr.length];
				for(int i=0;i<managerIdStrArr.length;i++){
					managerIdArr[i]=new Integer(managerIdStrArr[i]);
				}
				
			}else{
				throw new Exception("获取账户信息出错！");
			}
			
			/**批量删除方法之一：但是在这里需要加入事务控制
			/**批量删除方法之二*/
			managerService.delManagerBatch(managerIdArr);
			
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", "删除成功！");
			return "managerDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
		
	}
	//根据查询条件查找
	public String findManagerByCondition()
			throws Exception {
		String account_search = request.getParameter("account_search");
		String managerLevel_search = request.getParameter("managerLevel_search");
		//get方式提交才进行转码
		if("GET".equals(request.getMethod())){
			account_search = new String(account_search.getBytes("iso-8859-1"),("utf-8"));
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("account", account_search);
		map.put("managerLevel", managerLevel_search);
		try{
			List<Manager> list = managerService.findManagerByCondition(map);
			//分页数据
			String PageStr = request.getParameter("Page");
			int Page=1;
			if(PageStr==null){
				Page=1;
			}else{
				Page = Integer.parseInt(PageStr);
			}
			MyPagination pageination = new MyPagination();
			List<Department> managerList = pageination.getInitPage(list, Page, -1);
			//要分页，需要保存分页条件application/x-www-form-urlencoded 
			String pageStr = "&account_search="+URLEncoder.encode(account_search,"UTF-8")+"&managerLevel_search="+URLEncoder.encode(managerLevel_search,"UTF-8");
			String printCtrl = pageination.printCtrl(Page,"manager_findManagerByCondition.action?"+pageStr);
			request.setAttribute("managerList", managerList);
			request.setAttribute("printCtrl", printCtrl);
			//保存页面查询条件
			request.setAttribute("account_save", account_search);
			request.setAttribute("managerLevel_save", managerLevel_search);
			
			return "managerFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**修改密码跳转页面*/
	public String managerUpdatePwdPage()
			throws Exception {
		try{
			return "managerUpdatePwd";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**修改密码*/
	public String updatePwd()
			throws Exception {
			Manager manager = (Manager) request.getSession().getAttribute("manager");
			if(manager==null){
				throw new Exception("获取session信息出错！");
			}
			int managerId = manager.getManagerId();
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
		try{
			String str = managerService.updatePwd(managerId,oldPassword,newPassword);
			if("wrongPwd".equals(str)){
				request.setAttribute("isBackFlag", "wrongPwd");
				request.setAttribute("returnInfo", "旧密码错误，请重新操作！");
				return "managerUpdatePwd";
			}
			//修改密码后销毁session
			request.getSession().invalidate();
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "managerUpdatePwd";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
}
