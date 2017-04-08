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
<script language="JavaScript"  src="js/listOperation.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<style type="text/css">

</style>
</head>
<body>
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
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;员工管理&nbsp;>&nbsp;员工信息列表</strong></span>
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
                <td bgcolor="#FFFFFF" style="height:460px; vertical-align:top;">
                  <table width="100%" border="0" cellspacing="10" cellpadding="0">
				  
				  
					
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
                          <tr>
                            <td height="25" align="left"  background="images/index1_72.gif" bgcolor="#FFFFFF">&nbsp;&nbsp;<strong>查询条件</strong></td>
                          </tr>
                          <tr>      
                            <td height="50" align="left" bgcolor="#FFFFFF">
                            <form method="post" id="conditionForm" action="em_findEmByCondition.action">
								<div style="padding-top:10px;margin:0;float:left;height:30px">
									&nbsp;&nbsp;选择部门&nbsp;
									<select name="deptId_search" id="deptId_search">
									<option value="0">--请选择--</option>
									<c:forEach items="${emDeptList}" var="emDept">
										<option value="${emDept.deptId}">${emDept.deptName}</option>
									</c:forEach>
									</select>
									&nbsp;&nbsp;员工编号&nbsp;<input size="10" id="emSerialNumber_search" name="emSerialNumber_search" value="${emSerialNumber_save}">
									&nbsp;&nbsp;员工姓名&nbsp;<input size="10" id="emName_search" name="emName_search" value="${emName_save}">
								</div>
								<div style="padding-top:10px;float:left">
								&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" name="img_sub" src="images/search.gif" onclick="submit()"/>
								</div>
							</form>
							<c:if test="${deptId_save!=null&&deptId_save!=''}">
							<script type="text/javascript">
								$("#deptId_search").val(${deptId_save});
							</script>
							</c:if>
							</td>
                          </tr>  
                        </table> 
						</td>
					</tr>
					<tr>           
                      <td>
	                      <a href="em_addEmPage.action" target="main"><img src="images/add.gif" width="60" height="25" border="0" /></a>
	                      &nbsp;<a href="javascript:updateRecord('em_updateEmPage.action?emId=')" target="main"><img src="images/edit2.gif" width="60" height="25" border="0" /></a>
	                      &nbsp;<a href="javascript:delBatchRecord('em_delEmBatch.action?emIds=')" target="main""><img src="images/delete.gif" width="60" height="25" border="0" /></a>
                      </td>
                    </tr>
					
					
					
                    <tr>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
                          <tr style="font-weight:700">
                           
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">
                              <label>
                              <input id="selectall" type="checkbox" />
                              </label>
                            </td>
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">员工号</td>
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">姓名</td>
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">性别</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">部门</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">工种</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">学历</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">入职时间</td>
							<td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">操作</td>
                            
                          </tr>
						  
						  
                
						<c:forEach items="${emList}" var="em">
                          <tr>
                            
                            <td height="25" align="center" bgcolor="#FFFFFF">
                              <label>
                              <input type="checkbox" name="box_em" value="${em.emId}" />
                              </label>
                            </td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${em.emSerialNumber}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${em.emName}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${em.emSex}</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${em.department.deptName}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${em.deptGz}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${em.emDegree}</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${em.emWorkTime}</td>
                            <td align="center" bgcolor="#FFFFFF" width="200">
								<a href="em_findEmById.action?emId=${em.emId}"><span style="text-decoration: underline">查看</span></a>&nbsp;&nbsp;
								<a href="em_updateEmPage?emId=${em.emId}"><span style="text-decoration: underline">修改 </span></a>&nbsp;&nbsp;
								<a href="javascript:delRecord('em_delEm.action?emId=${em.emId}')"><span style="text-decoration: underline">删除</span></a>
							</td>
                          </tr>
						 </c:forEach>
                          
                          
                        </table>
						<div id="pagediv" style="margin-left:300px;margin-top:10px">
						${printCtrl }
						</div>

						
						
						
						
						
                      </td>
                    </tr>
                    
                    
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
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</body>
</html>
