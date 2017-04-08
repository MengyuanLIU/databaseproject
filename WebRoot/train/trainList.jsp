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
<script type="text/javascript">

</script> 
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
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;培训管理&nbsp;>&nbsp;培训信息列表</strong></span>
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
                            <form method="post" id="conditionForm" action="train_findTrainByCondition.action">
								<div style="padding-top:10px;margin:0;float:left;height:30px">
									
									&nbsp;&nbsp;培训标题&nbsp;<input size="10" id="cdtName_search" name="trainTitle_search" value="${trainTitle_save}">
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
	                      <a href="train_addTrainPage.action" target="main"><img src="images/add.gif" width="60" height="25" border="0" /></a>
	                      &nbsp;<a href="javascript:updateRecord('train_updateTrainPage.action?trainId=')" target="main"><img src="images/edit2.gif" width="60" height="25" border="0" /></a>
	                      &nbsp;<a href="javascript:delBatchRecord('train_delTrainBatch.action?trainIds=')" target="main"><img src="images/delete.gif" width="60" height="25" border="0" /></a>
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
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">培训标题</td>
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">培训人</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">培训宗旨</td>
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">培训时间</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">培训地址</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">参加人员</td>
							<td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">操作</td>
                            
                          </tr>
						  
						  
                
						<c:forEach items="${trainList}" var="train">
                          <tr>
                            
                            <td height="25" align="center" bgcolor="#FFFFFF">
                              <label>
                              <input type="checkbox" name="box_em" value="${train.trainId}" />
                              </label>
                            </td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${train.trainTitle}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${train.trainMan}</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${train.trainZz}</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${train.trainTime}</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${train.trainAddress}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${train.trainEmps}</td>
                            <td align="center" bgcolor="#FFFFFF" width="200">
								<a href="train_findTrainById.action?trainId=${train.trainId}"><span style="text-decoration: underline">查看</span></a>&nbsp;
								<a href="train_updateTrainPage.action?trainId=${train.trainId}"><span style="text-decoration: underline">修改 </span></a>&nbsp;
								<a href="javascript:delRecord('train_delTrain.action?trainId=${train.trainId}')"><span style="text-decoration: underline">删除</span></a>&nbsp;
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
