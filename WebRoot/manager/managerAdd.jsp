<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="systemTime" scope="page" class="com.tjw.hrmanage.util.GetSystemTime"></jsp:useBean>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理页面</title>
<!-- 调用CSS，JS -->
<script language="JavaScript" src="js/jquery-1.4.2.min.js"></script>
<script language="JavaScript"  src="js/form.js"></script>
<script language="JavaScript"  src="js/date.js"></script>
<script language="JavaScript"  src="js/Clock.js"></script>
<script type="text/javascript">
function myConfirm2(formId){
	var password = $("#password").val();
	var re_password=$("#re_password").val();
	if(password!=re_password){
		alert("两次输入的密码不一致");
		return;
	}
	myConfirm(formId);
}

//加载方法
function onloadFun(){
}
</script>


<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">

</style>
</head>
<body onload="onloadFun();">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="2">
      <table width="100%" border="0" cellspacing="10" cellpadding="0">
        <tr>
          
          <td width="90%" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="8" height="8"><img src="images/index1_28.gif" width="8" height="39" /></td>
                <td width="100%" background="images/index1_40.gif">
                  <table  width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
					
                      <td>
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="5"><img src="images/index1_35.gif" width="5" height="39" /></td>
							
                            <td align="left" background="images/index1_36.gif">
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;系统管理&nbsp;>&nbsp;添加账户信息</strong></span>
							</td>
							
                            <td width="5"><img src="images/index1_38.gif" width="5" height="39" /></td>
                          </tr>
                        </table>
                      </td>
                      
                    </tr>
                  </table>
                </td>
                <td width="8" height="8"><img src="images/index1_43.gif" width="8" height="39" /></td>
              </tr>
              <tr>
                <td background="images/index1_45.gif"></td>
                <td bgcolor="#FFFFFF" style="height:460px; vertical-align:top;" align="center">
                
                
                
                
                <c:if test="${isBackFlag==null}" var="condition" scope="request">
                  <table width="50%" border="0" cellspacing="10" cellpadding="0" >
				  
				  
					
					<tr>
						<td>
						
							
							 <!--表单内容开始-->
							
							
							
									
									<form id="addManagerForm" action="manager_addManager.action" method="post">
											<table width="500" border="1"  class="formTable"
											cellpadding="0" cellspacing="1" style="text-align:left;margin-top:50px;"> 
											<tr>
												<td class="tabIndex" style="height:10px">账户名称：</td>
												<td>&nbsp;<input class="notNull"  name="account" title="账户名称" /></td>
											</tr>
											<tr>
												<td class="tabIndex" style="height:10px">密码：</td>
												<td>&nbsp;<input id="password" type="password" class="notNull"  name="password" title="密码" /></td>
											</tr>
											<tr>
												<td class="tabIndex" style="height:10px">再次输入密码：</td>
												<td>&nbsp;<input id="re_password" type="password" class="notNull"  name="re_password" title="再次输入密码" /></td>
											</tr>
											<tr>
												<td class="tabIndex" style="height:10px">真实姓名：</td>
												<td>&nbsp;<input class="notNull"  name="realName" title="真实姓名" /></td>
											</tr>
											<tr>
											<td class="tabIndex" style="height:10px">
											  账户级别：
											</td>
											<td>&nbsp;
												<select name="managerLevel">
													<option value="0">普通账户</option>
													<option value="1">系统管理员</option>
												</select>
											</td>
											</tr>
											<tr>
												<td class="tabIndex" style="height:10px">创建时间：</td>
												<td>&nbsp;<input value="<%=systemTime.getYearMonthDay()%>" name="regDate"  readonly/></td>
											</tr>
											
											
										
									</table>

									<div style="text-align:center;margin-top:15px">
									<a href="javascript:myConfirm2('addManagerForm')"><img src="images/save.gif" width="60" height="25" border="0" /></a>
									<a style="margin-left:60px;" href="javascript:history.go(-1);"><img src="images/back.gif" width="60" height="25" border="0" /></a>
									 
									</div>
									</form>
							
							
							
							
							
							
							<!--表单内容结束-->
								
							
						
						</td>
					</tr>
					
                  </table>
				  </c:if>
				  
				  
				  <c:if test="${isBackFlag=='yes'}" var="condition" scope="request">
				  <!-- 返回信息 -->
				  <div style="width:100%;text-align: center;padding-top:180px;">
					  <strong style="color:#1E5494">${returnInfo}</strong><br/><br/>
					  <a style="" href="manager_findAllManager.action"><img src="images/back.gif" width="60" height="25" border="0" /></a>
				  </div>
				  </c:if>
				  
				  
				
                </td>
                <td background="images/index1_47.gif"></td>
              </tr>
              <tr>
                <td width="8" height="8"><img src="images/index1_91.gif" width="8" height="8" /></td>
                <td background="images/index1_92.gif"></td>
                <td width="8" height="8"><img src="images/index1_93.gif" width="8" height="8" /></td>
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
