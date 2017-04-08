package com.tjw.hrmanage.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:26:36
 * 2016.4
 */



public class AccessFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String currentURL = request.getRequestURI(); // 取得根目录所对应的绝对路径:
		String targetURL = currentURL.substring(currentURL.indexOf("/", 1),
				currentURL.length()); // 截取到当前文件名用于比较
		
		//此参数为false当请求能够获取到session时，返回此session，当不能够获取到session返回null
		HttpSession session = request.getSession(false);

		if ("/login.jsp".equals(targetURL)||targetURL.contains("login.do")||"/noLoginTip.jsp".equals(targetURL)||"/".equals(targetURL)) {
			// 判断当前页是否是重定向以后的登录页面页面，如果是就不做session的判断，防止出现死循环
			filterChain.doFilter(request, response);
		}else{
			if(session == null){
				request.setAttribute("noLoginTip", "您尚未登录！请首先<a href='login.jsp' target='_top' style='color:#144882'><strong>登录</strong></a>！");
				request.getRequestDispatcher("/noLoginTip.jsp").forward(request, response);
				return;
			}else if(session.getAttribute("manager") != null){
				filterChain.doFilter(request, response);
			}else{
				request.setAttribute("noLoginTip", "您尚未登录！请首先<a href='login.jsp' target='_top' style='color:#144882'><strong>登录</strong></a>！");
				request.getRequestDispatcher("/noLoginTip.jsp").forward(request, response);
				return;
			}
		}
		
	}
	public void init(FilterConfig filterConfig) throws ServletException {

	}
}
