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
//根据员工号检索
function checkEmBySerialNumber(){
var emSerialNumber = $("#emSerialNumber").val();
location.href="salaryRec_checkEmBySerialNumber.action?emSerialNumber="+encodeURIComponent(emSerialNumber);
}
//核算实发工资
function checkActualMoney(){
	
	var baseMoney = isNaN(parseInt($("#baseMoney").val()))?0:parseInt($("#baseMoney").val());
	var overtimeMoney = isNaN(parseInt($("#overtimeMoney").val()))?0:parseInt($("#overtimeMoney").val());
	var ageMoney = isNaN(parseInt($("#ageMoney").val()))?0:parseInt($("#ageMoney").val());
	var checkMoney = isNaN(parseInt($("#checkMoney").val()))?0:parseInt($("#checkMoney").val());
	var absentMoney = isNaN(parseInt($("#absentMoney").val()))?0:parseInt($("#absentMoney").val());
	var safetyMoney = isNaN(parseInt($("#safetyMoney").val()))?0:parseInt($("#safetyMoney").val());
	var actualMoney = baseMoney+overtimeMoney+ageMoney+checkMoney-absentMoney-safetyMoney;
	$("#actualMoney").val(actualMoney);
}
//加载方法
function onloadFun(){
	$("#emSerialNumber").focus();
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
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;薪资管理&nbsp;>&nbsp;薪资发放登记</strong></span>
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
                  <table width="80%" border="0" cellspacing="10" cellpadding="0" >
				  
				  
					
					<tr>
						<td>
						
							
							 <!--表单内容开始-->
							
							
							
							
											<form id="addSalaryRecForm" action="salaryRec_addSalaryRec.action" method="post">
											<table width="720" border="1"  class="formTable"
											cellpadding="0" cellspacing="1" style="text-align:left;margin-left:100px;margin-top:50px;"> 
											<tr>
												<td class="tabIndex" style="height:10px">员工号：</td>
												
												<td>
												<c:if test="${checkBySerialNumber==null}" var="cdt1" scope="request">
												&nbsp;<input id="emSerialNumber" class="notNull"  name="emSerialNumber" title="员工号" value="请输入员工号检索" />
												</c:if>
												<c:if test="${checkBySerialNumber=='back'}" var="cdt2" scope="request">
												&nbsp;<input id="emSerialNumber" class="notNull"  name="emSerialNumber" title="员工号" value="${emSerialNumber_back }" />
												</c:if>
												<img src="images/zoom.png" title="检索" onclick="checkEmBySerialNumber()" style="cursor: hand;"></td>
												<td class="tabIndex" style="height:10px">姓名：</td>
												<td>&nbsp;<input class="notNull"  name="emName" title="姓名" value="${emName_back }"/></td>
											</tr>
											<tr>
											 <td class="tabIndex" style="height:10px">部门：</td>
											<td>&nbsp;<input class="notNull"   name="emDept" title="部门" value="${emDept_back }"/></td>
											<td class="tabIndex" style="height:10px">发放日期：</td>
											<td>&nbsp;<input class="notNull" name="payMonth" onClick="SelectDate(this,'yyyy-MM-dd');" style="cursor: hand;" title="发放月份"/>格式:2010-12-12
											</td>
											</tr>
											<tr>
											<td class="tabIndex" style="height:10px">
											  基本工资：</td>
											<td>&nbsp;<input class="notNull" id="baseMoney"  name="baseMoney" title="基本工资" value="${baseMoney_back }"/></td>
											<td class="tabIndex" style="height:10px">
											  加班费：</td>
											<td>&nbsp;<input class="notNull" id="overtimeMoney"  name="overtimeMoney" title="加班费"/></td>
										</tr>
										<tr>
											<td class="tabIndex" style="height:10px">
											  工龄费：
											</td>
											<td>&nbsp;<input class="notNull" id="ageMoney"  name="ageMoney" title="工龄费"/></td>
											<td class="tabIndex" style="height:10px">
											 考勤费：
											</td>
											<td>&nbsp;<input class="notNull" id="checkMoney"  name="checkMoney" title="考勤费"/>
											</td>
										</tr>
										<tr>
											<td class="tabIndex" style="height:10px">
											  旷工费：
											</td>
											<td>&nbsp;<input class="notNull" id="absentMoney" name="absentMoney" title="旷工费"/></td>
											<td class="tabIndex" style="height:10px">
											 保险费：
											</td>
											<td>&nbsp;<input class="notNull" id="safetyMoney" name="safetyMoney" title="保险费" value="${safetyMoney_back }"/></td>
										</tr>
										<tr>
											<td class="tabIndex" style="height:10px">
											  实发工资：
											</td>
											<td>&nbsp;<input class="notNull" id="actualMoney" name="actualMoney" title="实发工资"/>
											<input type="button" onclick="checkActualMoney()" value="核算实发工资">
											</td>
										</tr>
										 <tr>
											<td class="tabIndex" style="height:10px">
											  是否发放：
											</td>
											<td>
											&nbsp;<input type="radio" name="isPay" value="1" checked/>已发放
											&nbsp;<input type="radio" name="isPay" value="0" />未发放
											
											</td>
										</tr>
									</table>

									<div style="text-align:center;margin-top:15px">
									<a href="javascript:myConfirm('addSalaryRecForm')"><img src="images/save.gif" width="60" height="25" border="0" /></a>
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
					  <a style="" href="salaryRec_findAllSalaryRec.action"><img src="images/back.gif" width="60" height="25" border="0" /></a>
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
