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

<script type="text/javascript">

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
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;员工管理&nbsp;>&nbsp;查看员工信息</strong></span>
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
							
							
							
							
											<form id="addEmForm" action="em_addEm.action" method="post">
											<table width="620" border="1"  class="formTable"
											cellpadding="0" cellspacing="1" style="text-align:left;margin-left:100px;margin-top:0px;"> 
											<tr>
												<td class="tabIndex" style="height:10px">员工号：</td>
												<td>&nbsp;<input class="notNull"  name="emSerialNumber" title="员工号" value="${em.emSerialNumber}" readonly/></td>
												<td class="tabIndex" style="height:10px">姓名：</td>
												<td>&nbsp;<input class="notNull"  name="emName" title="姓名" value="${em.emName}" readonly/></td>
											</tr>
											<tr>
											 <td class="tabIndex" style="height:10px">年龄：</td>
											<td>&nbsp;<input class="notNull"   name="emAge" title="年龄" value="${em.emAge}" readonly/></td>
											<td class="tabIndex" style="height:10px">性别：</td>
											<td>&nbsp;<input value="${em.emSex}"  readonly/>
											</td>
											</tr>
											<tr>
												<td class="tabIndex" style="height:10px">身份证号：</td>
												<td>&nbsp;<input class="notNull"   name="emIdCard" title="身份证号" value="${em.emIdCard}" readonly/></td>
												<td class="tabIndex" style="height:10px">出生日期：</td>
												<td>&nbsp;<input class="notNull"   name="emBorn" title="出生日期" value="${em.emBorn}" readonly/>格式:2010-12-12</td>
											</tr>
											<tr>
											<td class="tabIndex" style="height:10px">
											  名族：</td>
											<td>&nbsp;<input class="notNull"  name="emMz" title="民族" value="${em.emMz}" readonly/></td>
											<td class="tabIndex" style="height:10px">
											  婚姻状况：</td>
											<td>&nbsp;<input value="${em.emMarriage}" name="emMarriage"  readonly/>
											</td>
										</tr>
										<tr>
											<td class="tabIndex" style="height:10px">
											  籍贯：
											</td>
											<td>&nbsp;<input class="notNull"  name="emJg" title="籍贯" value="${em.emJg}" readonly/></td>
											<td class="tabIndex" style="height:10px">
											 政治面貌：
											</td>
											<td>&nbsp;<input value="${em.emZzmm}" name="emZzmm"  readonly/>
											</td>
										</tr>
										<tr>
											<td class="tabIndex" style="height:10px">
											  联系电话：
											</td>
											<td>&nbsp;<input name="emTel" value="${em.emTel}" readonly/></td>
											<td class="tabIndex" style="height:10px">
											  家庭住址：
											</td>
											<td>&nbsp;<input name="emAddress" value="${em.emAddress}" readonly/></td>
										</tr>
										<tr>
											<td class="tabIndex" style="height:10px">
											  毕业院校：
											</td>
											<td>&nbsp;<input name="emGraduateSchool" value="${em.emGraduateSchool }" readonly/></td>
											<td class="tabIndex" style="height:10px">
											  专业：
											</td>
											<td>&nbsp;<input name="emSpeciality" value="${em.emSpeciality }" readonly/></td>
										</tr>
										 <tr>
											<td class="tabIndex" style="height:10px">
											  文化程序：
											</td>
											<td>
                								&nbsp;<input value="${em.emDegree}" name="emDegree" readonly/>
											</td>
											<td class="tabIndex" style="height:10px">
											  上岗时间：
											</td>
											<td>&nbsp;<input name="emWorkTime" value="${em.emWorkTime}" readonly/>格式:2010-12-12</td>
										</tr>
										 <tr>
											<td class="tabIndex" style="height:10px">
											  部门名称：
											</td>
											<td>
												&nbsp;<input value="${em.department.deptName}" name="department" readonly/>
											</td>
											<td class="tabIndex" style="height:10px">
											  部门工种：
											</td>
											<td>
												&nbsp;<input value="${em.deptGz}" name="deptGz" readonly/>
											</td>
										</tr>
										 <tr>
											<td class="tabIndex" style="height:10px">
											  登记人名：
											</td>
											<td>&nbsp;<input name="registerName" value="${em.registerName}" readonly/></td>
											<td class="tabIndex" style="height:10px">
											  登记时间：
											</td>
											<td>&nbsp;<input id="registerTimeId" value="${em.registerTime}" readonly/></td>
										</tr>
										<tr>
											<td class="tabIndex">备注信息：
											</td>
											<td><textarea rows="6" cols="20" name="emNote" readonly>${em.emNote}</textarea>
											</td>
										</tr>
									</table>

									<div style="margin-left:330px;margin-top:15px">
									
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
					  <a style="" href="em_findAllEm.action"><img src="images/back.gif" width="60" height="25" border="0" /></a>
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
