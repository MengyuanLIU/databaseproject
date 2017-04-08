<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page  import="com.tjw.hrmanage.model.Manager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Manager manager = (Manager)session.getAttribute("manager");
String managerLevel = manager.getManagerLevel();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜单页面</title>
<!-- 调用CSS，JS -->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function loginout2(){
			if(confirm("确认退出系统？")){
				top.location.href="login_loginout.action";
			}
		}
</script>
<style type="text/css">

</style>
</head>
<body>
<div style="padding:10px;">
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="8" height="8"><img src="images/index1_23.gif" width="8" height="29" /></td>
                <td width="100%" background="images/index1_24.gif"><span style="font-size:14px;color:#144882"><strong>&nbsp;MENU</strong></span></td>
                <td width="8" height="8"><img src="images/index1_26.gif" width="8" height="29" /></td>
              </tr>
              <tr>
                <td style="background:url(images/index1_45.gif);" width="8"></td>
                <td bgcolor="#FFFFFF" align="center" style="padding:0 0px 0 0px; vertical-align:top;height:470px;">
                  <table width="147" border="0" cellpadding="0" cellspacing="0">
					<tr><td>&nbsp;</td></tr>
                    <tr width="147" height="23">
						<td width="147" style="background:url(images/main_34.gif);background-repeat:no-repeat;background-position:center" align="center">
						<span>
							<a href="em_findAllEm.action" target="main"  style="font-size:14px;color:#144882;text-decoration:none"><strong>staff</strong></a>
						</span>
						</td>
					</tr>
					<tr><td>&nbsp;</td></tr>
                    <tr width="100%" height="23">
                    	<td width="147" style="background:url(images/main_34.gif);background-repeat:no-repeat;background-position:center" align="center">
						<span>
							<a href="dept_findAllDept.action" target="main"  style="font-size:14px;color:#144882;text-decoration:none"><strong>department</strong></a>
						</span>
						</td>
					</tr>	
					<tr><td>&nbsp;</td></tr>
					<tr width="100%" height="23">
                    	<td width="147" style="background:url(images/main_34.gif);background-repeat:no-repeat;background-position:center" align="center">
						<span>
							<a href="salaryBase_findAllEmWithSalary.action" target="main"  style="font-size:14px;color:#144882;text-decoration:none"><strong>salray</strong></a>
						</span>
						</td>
					</tr>	
					<tr><td>&nbsp;</td></tr>
					<tr width="100%" height="23">
                    	<td width="147" style="background:url(images/main_34.gif);background-repeat:no-repeat;background-position:center" align="center">
						<span>
							<a href="cdt_findAllCdt.action" target="main"  style="font-size:14px;color:#144882;text-decoration:none"><strong>recruitment</strong></a>
						</span>
						</td>
					</tr>	
					<tr><td>&nbsp;</td></tr>
					<tr width="100%" height="23">
                    	<td width="147" style="background:url(images/main_34.gif);background-repeat:no-repeat;background-position:center" align="center">
						<span>
							<a href="train_findAllTrain.action" target="main"  style="font-size:14px;color:#144882;text-decoration:none"><strong>training</strong></a>
						</span>
						</td>
					</tr>	
					<tr><td>&nbsp;</td></tr>
					<tr width="100%" height="23">
                    	<td width="147" style="background:url(images/main_34.gif);background-repeat:no-repeat;background-position:center" align="center">
						<span>
							<a href="plan_findAllPlan.action" target="main"  style="font-size:14px;color:#144882;text-decoration:none"><strong>plan</strong></a>
						</span>
						</td>
					</tr>	
					<tr><td>&nbsp;</td></tr>
					<c:if test='<%="1".equals(managerLevel) %>' scope="session" var="te">
					<tr width="100%" height="23">
						<td width="147" style="background:url(images/main_34.gif);background-repeat:no-repeat;background-position:center" align="center">
						<span>
							<a href="manager_findAllManager.action" target="main"  style="font-size:14px;color:#144882;text-decoration:none"><strong>system management</strong></a>
						</span>
						</td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					</c:if>
					<tr width="100%" height="23">
                    	<td width="147" style="background:url(images/main_34.gif);background-repeat:no-repeat;background-position:center" align="center">
						<span>
							<a href="manager_managerUpdatePwdPage.action" target="main"  style="font-size:14px;color:#144882;text-decoration:none"><strong>password changing</strong></a>
						</span>
						</td>
					</tr>	
					<tr><td>&nbsp;</td></tr>
					<tr width="100%" height="23">
                    	<td width="147" style="background:url(images/main_34.gif);background-repeat:no-repeat;background-position:center" align="center">
						<span>
							<a href="javascript:loginout2()"   style="font-size:14px;color:#144882;text-decoration:none"><strong>exit</strong></a>
						</span>
						</td>
					</tr>	
					<tr><td>&nbsp;</td></tr>
                  </table>
                </td>
                <td background="images/index1_47.gif"></td>
              </tr>
              <tr>
                <td width="8" height="8"><img src="images/index1_91.gif" width="8" height="8" /></td>
                <td background="images/index1_92.gif"></td>
                <td width="8" height="8"><img src="images/index1_93.gif" width="8" height="8" /></td>
        </tr>
</table>
</div>
</body>
</html>
