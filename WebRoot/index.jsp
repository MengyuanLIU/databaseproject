<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>人力资源管理系统</title>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
<FRAMESET border=0 frameSpacing=0 rows="74, *,25" frameBorder=0 noResize>
<FRAME name=header src="header.jsp" frameBorder=0 noResize scrolling=no>
<FRAMESET border=0 frameSpacing=0 cols="230, *" >
<FRAME name=menu src="menu.jsp" frameBorder=0 noResize scrolling=no>
<FRAME name=main src="welcome.jsp" frameBorder=0 noResize scrolling=auto >
</FRAMESET>
<FRAME name=footer src="footer.jsp" frameBorder=0 noResize scrolling=no>
</FRAMESET>
<noframes>
</noframes>
</html>
