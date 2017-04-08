package com.tjw.hrmanage.web.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.octo.captcha.service.CaptchaServiceException;
import com.opensymphony.xwork2.ActionSupport;
import com.tjw.hrmanage.util.jcaptcha.CaptchaServiceSingleton;
import com.tjw.hrmanage.model.Manager;
import com.tjw.hrmanage.service.IDeptService;
import com.tjw.hrmanage.service.ILoginService;
import com.tjw.hrmanage.util.GetSystemTime;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:28:11
 * 2016.4
 */

public class LoginAction extends ActionSupport{
	private ILoginService loginService;
	private IDeptService deptService;
	private String account;
	private String password;
	
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
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	/**用户登陆*/
	public String login()
			throws Exception {
		// 验证验证码
		 String inputCode = request.getParameter("inputCode");
		 Boolean isResponseCorrect =Boolean.FALSE;
		 String sessionId =request.getSession().getId();
		 try {
			 isResponseCorrect =CaptchaServiceSingleton.getInstance().validateResponseForID(sessionId,inputCode);
		 } catch (CaptchaServiceException e) {
		 }
		 if(!isResponseCorrect){
			 response.sendRedirect("login.jsp?errorInfo=error1");
			 return null;
		 }
		
		Manager m = new Manager();
		m.setAccount(getAccount());
		m.setPassword(getPassword());
		try{
			Manager manager = loginService.login(m);
			HttpSession session = request.getSession();
			//登陆成功后把账户放入session
			session.setAttribute("manager", manager);
			
			//更新上次登录时间
			String curTime = new GetSystemTime().getYearMonthDayAndTime();
			manager.setLastLoginDate(manager.getCurrLoginDate());
			manager.setCurrLoginDate(curTime);
			loginService.updateManager(manager);
			//采用redirector方式而不是forward方式，可以防止刷新页面表单被重复提交的问题
			response.sendRedirect("index.jsp");
			return null;
			//return mapping.findForward("index");
		}catch(Exception e){
			String s ="error3";
			if("userOrPwdWrong".equals(e.getMessage())){
				s="error2";
			}
			response.sendRedirect("login.jsp?errorInfo="+s);
			return null;
		}
	}
	/**用户 退出*/
	public String loginout()
			throws Exception {
		try{
			HttpSession session =request.getSession();
			//调用invalidate使session失效，销毁session和其中的数据，下次登录产生新的session
			session.invalidate();
			
			
			//采用redirector方式而不是forward方式，可以防止刷新页面表单被重复提交的问题
			response.sendRedirect("login.jsp");
			return null;
		}catch(Exception e){
			request.setAttribute("loginerrorInfo", e.getMessage());
			return "loginerror";
		}
	}
}
