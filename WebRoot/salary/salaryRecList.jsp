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
<script language="JavaScript"  src="js/date.js"></script>
<script type="text/javascript">
function newSubmit(){
	var payMonth_search_b = $("#payMonth_search_b").val();
	var payMonth_search_e = $("#payMonth_search_e").val();
	if(payMonth_search_b==""&&payMonth_search_e!=""){
		alert("起始日期不能为空！")
		return;
	}
	if(payMonth_search_e==""&&payMonth_search_b!=""){
		alert("结束日期不能为空！")
		return;
	}
	payMonth_search_b = payMonth_search_b.replace("-","").replace("-","");
	payMonth_search_e = payMonth_search_e.replace("-","").replace("-","");
	if(payMonth_search_e<payMonth_search_b){
		alert("结束日期不能小于开始日期！")
		return;
	}
	
	document.getElementById("conditionForm").submit();
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
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;薪资管理&nbsp;>&nbsp;薪资发放记录列表</strong></span>
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
                <div style="padding-top:15px;font-size:14px;">
                	&nbsp;&nbsp;&nbsp;
                	<a style="font-size: 14px;text-decoration: underline;" href="salaryBase_findAllEmWithSalary.action"><strong>薪资基本信息</strong></a>&nbsp;|&nbsp;<strong>薪资发放记录</strong></div>
                  <table width="100%" border="0" cellspacing="10" cellpadding="0">
				  
				  
					
					<tr>
						<td>
						 <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
                          <tr>
                            <td height="25" align="left"  background="images/index1_72.gif" bgcolor="#FFFFFF">&nbsp;&nbsp;<strong>查询条件</strong></td>
                          </tr>
                          <tr>      
                            <td height="50" align="left" bgcolor="#FFFFFF">
                            <form method="post" id="conditionForm" action="salaryRec_findSalaryRecByCondition.action" style="width:900px">
								<div style="padding-top:10px;margin:0;float:left;height:30px;">
									&nbsp;&nbsp;员工编号&nbsp;<input size="10" id="emSerialNumber_search" name="emSerialNumber_search" value="${emSerialNumber_save}">
									&nbsp;&nbsp;员工姓名&nbsp;<input size="10" id="emName_search" name="emName_search" value="${emName_save}">
									&nbsp;&nbsp;发放日期&nbsp;<input id="payMonth_search_b" name="payMonth_search_b" size="10"  value="${payMonth_save_b}" onClick="SelectDate(this,'yyyy-MM-dd');" style="cursor: hand;" title="开始月份"/>到
									<input id="payMonth_search_e" name="payMonth_search_e" size="10"  value="${payMonth_save_e}" onClick="SelectDate(this,'yyyy-MM-dd');" style="cursor: hand;" title="结束月份"/>
									&nbsp;&nbsp;发放状态&nbsp;
									<select name="isPay_search" id="isPay_search_id">
										<option value="-1">--请选择--</option>
										<option value="1">已发放</option>
										<option value="0">未发放</option>
									</select>
								</div>
								<div style="padding-top:10px;">
								&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:newSubmit()" ><img style="border:0" src="images/search.gif" /></a>
								</div>
							</form>
							<c:if test="${isPay_save!=null&&isPay_save!=''}">
							<script type="text/javascript">
								$("#isPay_search_id").val(${isPay_save});
							</script>
							</c:if>
							</td>
                          </tr>  
                        </table> 
						</td>
					</tr>
					<tr>           
                      <td>
	                      <a href="salaryRec_addSalaryRecPage.action" target="main"><img src="images/add.gif" width="60" height="25" border="0" /></a>
	                      &nbsp;<a href="javascript:updateRecord('salaryRec_updateSalaryRecPage.action?salaryRecId=')" target="main"><img src="images/edit2.gif" width="60" height="25" border="0" /></a>
	                      &nbsp;<a href="javascript:delBatchRecord('salaryRec_delSalaryRecBatch.action?salaryRecIds=')" target="main""><img src="images/delete.gif" width="60" height="25" border="0" /></a>
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
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">发放日期</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">基本工资</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">实发工资</td>
							<td height="25" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">是否发放</td>
							<td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">操作</td>
                            
                          </tr>
						  
						  
                
						<c:forEach items="${salaryRecList}" var="recList">
                          <tr>
                            
                            <td height="25" align="center" bgcolor="#FFFFFF">
                              <label>
                              <input type="checkbox" name="box_em" value="${recList.salaryRecId}" />
                              </label>
                            </td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${recList.emSerialNumber}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${recList.emName}</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${recList.emDept}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${recList.payMonth}</td>
                            <td height="25" align="center" bgcolor="#FFFFFF">${recList.baseMoney}</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${recList.actualMoney}</td>
							<td height="25" align="center" bgcolor="#FFFFFF">${recList.isPay=='1'?'<font color=green>已发放</font>':'<font color=red>未发放</font>'}</td>
                            <td align="center" bgcolor="#FFFFFF" width="200">
								<a href="salaryRec_findSalaryRecById.action?salaryRecId=${recList.salaryRecId}"><span style="text-decoration: underline">查看</span></a>&nbsp;&nbsp;
								<a href="salaryRec_updateSalaryRecPage.action?salaryRecId=${recList.salaryRecId}"><span style="text-decoration: underline">修改 </span></a>&nbsp;&nbsp;
								<a href="javascript:delRecord('salaryRec_delSalaryRec.action?salaryRecId=${recList.salaryRecId}')"><span style="text-decoration: underline">删除</span></a>
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
