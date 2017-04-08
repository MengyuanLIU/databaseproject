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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理页面</title>
<!-- 调用CSS，JS -->
<script language="JavaScript" src="js/jquery-1.4.2.min.js"></script>
<script language="JavaScript"  src="js/form.js"></script>
<script language="JavaScript"  src="js/date.js"></script>
<script language="JavaScript"  src="js/Clock.js"></script>
<script type="text/javascript">
function myConfirm2(formId){
	var newPassword = $("#newPassword").val();
	var re_newPassword=$("#re_newPassword").val();
	if(newPassword!=re_newPassword){
		alert("两次输入的新密码不一致");
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
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;修改密码&nbsp;</strong></span>
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
							
							
							
									
									<form id="managerUpdatePwdForm" action="manager_updatePwd.action" method="post">
											<table width="500" border="1"  class="formTable"
											cellpadding="0" cellspacing="1" style="text-align:left;margin-top:50px;"> 
											<tr>
												<td class="tabIndex" style="height:10px">账户名称：</td>
												<td>&nbsp;<input   name="account" title="账户名称" value="<%=manager.getAccount() %>" readonly/></td>
											</tr>
											<tr>
												<td class="tabIndex" style="height:10px">旧密码：</td>
												<td>&nbsp;<input id="oldPassword" type="password" class="notNull"  name="oldPassword" title="旧密码" /></td>
											</tr>
											<tr>
												<td class="tabIndex" style="height:10px">新密码：</td>
												<td>&nbsp;<input id="newPassword" type="password" class="notNull"  name="newPassword" title="新密码" /></td>
											</tr>
											<tr>
												<td class="tabIndex" style="height:10px">确认新密码：</td>
												<td>&nbsp;<input id="re_newPassword" type="password" class="notNull"  name="re_newPassword" title="确认新密码" /></td>
											</tr>
											
									</table>

									<div style="text-align:center;margin-top:15px">
									<a href="javascript:myConfirm2('managerUpdatePwdForm')"><img src="images/save.gif" width="60" height="25" border="0" /></a>
									<a style="margin-left:60px;" href="javascript:history.go(-1);"><img src="images/back.gif" width="60" height="25" border="0" /></a>
									 
									</div>
									</form>
							
							
							
							
							
							
							<!--表单内容结束-->
								
							
						
						</td>
					</tr>
					
                  </table>
				  </c:if>
				  
				  <c:if test="${isBackFlag=='wrongPwd'}" var="condition" scope="request">
				  <!-- 返回信息 -->
				  <div style="width:100%;text-align: center;padding-top:180px;">
					  <strong style="color:#1E5494">${returnInfo}</strong><br/><br/>
					  <a style="" href="javascript:history.go(-1);"><img src="images/back.gif" width="60" height="25" border="0" /></a>
				  </div>
				  </c:if>
				  
				  <c:if test="${isBackFlag=='yes'}" var="condition" scope="request">
				  <!-- 返回信息 -->
				  <div style="width:100%;text-align: center;padding-top:180px;">
					  <strong style="color:#1E5494">${returnInfo}</strong><br/><br/>
					  <a href="login.jsp" target="_top" style="color:#144882;text-decoration: underline;"><strong>重新登陆</strong></a>
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
