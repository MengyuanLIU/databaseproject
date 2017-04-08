<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
location.href="salaryRec_checkEmBySerialNumber.action?emSerialNumber="+emSerialNumber;
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
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;薪资管理&nbsp;>&nbsp;薪资发放记录修改</strong></span>
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
							
							
							
							
											<form id="updateSalaryRecForm" action="salaryRec_updateSalaryRec.action" method="post">
											<table width="720" border="1"  class="formTable"
											cellpadding="0" cellspacing="1" style="text-align:left;margin-left:100px;margin-top:50px;"> 
											<tr>
												<td class="tabIndex" style="height:10px">员工号：</td>
												
												<td><input type="hidden" name="salaryRecId" value="${salaryRec.salaryRecId}">
												&nbsp;<input id="emSerialNumber" class="notNull"  name="emSerialNumber" title="员工号" value="${salaryRec.emSerialNumber }" readonly />
												</td>
												<td class="tabIndex" style="height:10px">姓名：</td>
												<td>&nbsp;<input class="notNull"  name="emName" title="姓名" value="${salaryRec.emName }" readonly/></td>
											</tr>
											<tr>
											 <td class="tabIndex" style="height:10px">部门：</td>
											<td>&nbsp;<input class="notNull"   name="emDept" title="部门" value="${salaryRec.emDept }" readonly/></td>
											<td class="tabIndex" style="height:10px">发放月份：</td>
											<td>&nbsp;<input class="notNull" name="payMonth" value="${salaryRec.payMonth}" onClick="SelectDate(this,'yyyy-MM-dd');" style="cursor: hand;" title="发放月份"/>格式:2010-12-12
											</td>
											</tr>
											<tr>
											<td class="tabIndex" style="height:10px">
											  基本工资：</td>
											<td>&nbsp;<input class="notNull" id="baseMoney"  name="baseMoney" title="基本工资" value="${salaryRec.baseMoney }"/></td>
											<td class="tabIndex" style="height:10px">
											  加班费：</td>
											<td>&nbsp;<input class="notNull" id="overtimeMoney"  name="overtimeMoney" value="${salaryRec.overtimeMoney }" title="加班费"/></td>
										</tr>
										<tr>
											<td class="tabIndex" style="height:10px">
											  工龄费：
											</td>
											<td>&nbsp;<input class="notNull" id="ageMoney"  name="ageMoney" value="${salaryRec.ageMoney }" title="工龄费"/></td>
											<td class="tabIndex" style="height:10px">
											 考勤费：
											</td>
											<td>&nbsp;<input class="notNull" id="checkMoney"  name="checkMoney" value="${salaryRec.checkMoney}" title="考勤费"/>
											</td>
										</tr>
										<tr>
											<td class="tabIndex" style="height:10px">
											  旷工费：
											</td>
											<td>&nbsp;<input class="notNull" id="absentMoney" name="absentMoney" value="${salaryRec.absentMoney }" title="旷工费"/></td>
											<td class="tabIndex" style="height:10px">
											 保险费：
											</td>
											<td>&nbsp;<input class="notNull" id="safetyMoney" name="safetyMoney" title="保险费" value="${salaryRec.safetyMoney}"/></td>
										</tr>
										<tr>
											<td class="tabIndex" style="height:10px">
											  实发工资：
											</td>
											<td>&nbsp;<input class="notNull" id="actualMoney" name="actualMoney" title="实发工资" value="${salaryRec.actualMoney}"/>
											</td>
										</tr>
										 <tr>
											<td class="tabIndex" style="height:10px">
											  是否发放：
											</td>
											<td>
											&nbsp;<input type="radio" id="isPay_t" name="isPay" value="1" checked/>已发放
											&nbsp;<input type="radio" id="isPay_f" name="isPay" value="0" />未发放
											<script type="text/javascript">
												var isPay="${salaryRec.isPay}";
												if(isPay=="1"){
													$("#isPay_t").attr("checked",true);
												}else if(isPay=="0"){
													$("#isPay_f").attr("checked",true);
												}else{
												}
											</script>
											</td>
										</tr>
									</table>

									<div style="text-align:center;margin-top:15px">
									<a href="javascript:myConfirm('updateSalaryRecForm')"><img src="images/save.gif" width="60" height="25" border="0" /></a>
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
