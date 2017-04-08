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
function listHireFun(url){
if(confirm("确认录用此应聘者？")){
	location.href=url;
}
}
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
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;招聘管理&nbsp;>&nbsp;招聘信息列表</strong></span>
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
                            <form method="post" id="conditionForm" action="cdt_findCdtByCondition.action">
								<div style="padding-top:10px;margin:0;float:left;height:30px">
									
									&nbsp;&nbsp;应聘者姓名&nbsp;<input size="10" id="cdtName_search" name="cdtName_search" value="${cdtName_save}">
									&nbsp;&nbsp;是否录用&nbsp;<select name="isHire_search" id="isHireId">
									<option value="no">--请选择--</option>
									<option value="是">是</option>
									<option value="否">否</option>
									</select>	
									<c:if test="${isHire_save!=null&&isHire_save!=''}">
									<script type="text/javascript">
										$("#isHireId").val("${isHire_save}");
									</script>
									</c:if>
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
	                      <a href="cdt_addCdtPage.action" target="main"><img src="images/add.gif" width="60" height="25" border="0" /></a>
	                      &nbsp;<a href="javascript:updateRecord('cdt_updateCdtPage.action?cdtId=')" target="main"><img src="images/edit2.gif" width="60" height="25" border="0" /></a>
	                      &nbsp;<a href="javascript:delBatchRecord('cdt_delCdtBatch.action?cdtIds=')" target="main"><img src="images/delete.gif" width="60" height="25" border="0" /></a>
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
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">姓名</td>
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">性别</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">年龄</td>
                            <td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">学历</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">应聘职位</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">登记时间</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">是否录用</td>
							<td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">操作</td>
                            
                          </tr>
						  
						  
                
						<c:forEach items="${cdtList}" var="cdt">
                          <tr>
                            
                            <td height="25" align="center" bgcolor="#FFFFFF">
                              <label>
                              <input type="checkbox" name="box_em" value="${cdt.cdtId}" />
                              </label>
                            </td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${cdt.cdtName}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${cdt.cdtSex}</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${cdt.cdtAge}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">
								<c:choose>
									<c:when test="${cdt.cdtDegree=='1'}">
									本科
									</c:when>
									<c:when test="${cdt.cdtDegree=='2'}">
									高中
									</c:when>
									<c:when test="${cdt.cdtDegree=='3'}">
									大专
									</c:when>
									<c:when test="${cdt.cdtDegree=='4'}">
									硕士
									</c:when>
									<c:when test="${cdt.cdtDegree=='5'}">
									博士
									</c:when>
									<c:otherwise>
									无
									</c:otherwise>
								</c:choose>
							
							</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${cdt.cdtPosition}</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${cdt.cdtRegTime}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${cdt.isHire}</td>
                            <td align="center" bgcolor="#FFFFFF" width="200">
								<a href="cdt_findCdtById.action?cdtId=${cdt.cdtId}"><span style="text-decoration: underline">查看</span></a>&nbsp;
								<a href="cdt_updateCdtPage.action?cdtId=${cdt.cdtId}"><span style="text-decoration: underline">修改 </span></a>&nbsp;
								<a href="javascript:delRecord('cdt_delCdt.action?cdtId=${cdt.cdtId}')"><span style="text-decoration: underline">删除</span></a>&nbsp;|
								
								<c:if test="${cdt.isHire=='否'}">
								<a href="javascript:listHireFun('cdt_listHire.action?cdtId=${cdt.cdtId}')"><span style="text-decoration: underline">录用</span></a>
								</c:if>
								<c:if test="${cdt.isHire=='是'}">
								录用
								</c:if>
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
