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
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;部门管理&nbsp;>&nbsp;部门信息列表</strong></span>
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
                            <form method="post" id="conditionForm" action="dept_findDeptByCondition.action">
								<div style="padding-top:10px;margin:0;float:left;height:30px">
									&nbsp;&nbsp;
									&nbsp;&nbsp;部门编号&nbsp;<input size="10" id="deptId_search" name="deptId_search" value="${deptId_save}">
									&nbsp;&nbsp;部门名称&nbsp;<input size="10" id="deptName_search" name="deptName_search" value="${deptName_save}">
								</div>
								<div style="padding-top:10px;float:left">
								&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" name="img_sub" src="images/search.gif" onclick="submit()"/>
								</div>
							</form>
							
							</td>
                          </tr>  
                        </table> 
						</td>
					</tr>
					<tr>           
                      <td>
	                      <a href="dept_addDeptPage.action" target="main"><img src="images/add.gif" width="60" height="25" border="0" /></a>
	                      &nbsp;<a href="javascript:updateRecord('dept_updateDeptPage.action?deptId=')" target="main"><img src="images/edit2.gif" width="60" height="25" border="0" /></a>
	                      &nbsp;<a href="javascript:delBatchRecord('dept_delDeptBatch.action?deptIds=')" target="main""><img src="images/delete.gif" width="60" height="25" border="0" /></a>
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
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">部门编号</td>
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">部门名称</td>
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">创建时间</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">部门人数</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">备注</td>
							<td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">操作</td>
                            
                          </tr>
						  
						  
                
						<c:forEach items="${deptList}" var="dept">
                          <tr>
                            
                            <td height="25" align="center" bgcolor="#FFFFFF">
                              <label>
                              <input type="checkbox" name="box_em" value="${dept.deptId}" />
                              </label>
                            </td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${dept.deptId }</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${dept.deptName}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${dept.createTime}</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${dept.peopleNum}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${dept.deptNote}</td>
                            <td align="center" bgcolor="#FFFFFF" width="200">
								<a href="dept_findDeptById.action?deptId=${dept.deptId}"><span style="text-decoration: underline">查看</span></a>&nbsp;&nbsp;
								<a href="dept_updateDeptPage.action?deptId=${dept.deptId}"><span style="text-decoration: underline">修改 </span></a>&nbsp;&nbsp;
								<a href="javascript:delRecord('dept_delDept.action?deptId=${dept.deptId}')"><span style="text-decoration: underline">删除</span></a>
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
