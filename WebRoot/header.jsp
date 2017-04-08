<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page  import="com.tjw.hrmanage.model.Manager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Manager manager = (Manager)session.getAttribute("manager");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Personal Management</title>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 调用CSS，JS -->
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
	
	</style>
	<script type="text/javascript" src="js/getSysTime.js"></script>
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript">
	
		function loginout(){
			if(confirm("确认退出系统？")){
				top.location.href="login_loginout.action";
			}
		}
		function setSysTime(){
			$("#sysTimeSpan").text("系统时间:"+getSysTime("yyyy年MM月dd日 hh:mm:ss"));
		}
		function onloadFun(){
			setInterval("setSysTime()",10);
		}
	</script>
	</head>
  
  <body onload="onloadFun()">
<table width="100%" border="0" cellspacing="0" cellpadding="0">    
  <tr>
    <td height="74" colspan="2" background="images/index1_03.gif">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="33%" rowspan="2" align="center"><img src="images/index1_01.gif" width="253" height="74" /></td>
          <td width="6%" rowspan="2">&nbsp;</td>
          <td width="61%" height="38" align="right">
            <table width="70" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="center"><img src="images/index1_08.gif" width="16" height="16" /></td>
                <td align="center" class="font2"><a href="javascript:loginout()" class="font2" ><strong style="font-size: 14px">退出</strong></a>&nbsp;&nbsp;</td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td align="right">
            <table width="600" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="right" class="font2">
                &nbsp;登陆账户：<%=manager.getAccount() %>&nbsp;|&nbsp;级别：<%="1".equals(manager.getManagerLevel())?"系统管理员":"普通用户" %>&nbsp;|
                &nbsp;<span style="width:200px;" id="sysTimeSpan"></span>&nbsp;|&nbsp;&nbsp;</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</body>
</html>
