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
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;招聘管理&nbsp;>&nbsp;修改应聘人员信息</strong></span>
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
							
							
							
							
											<form id="updateCdtForm" action="cdt_updateCdt.action?cdtId=${cdt.cdtId }" method="post">
											<table width="620" border="1"  class="formTable"
											cellpadding="0" cellspacing="1" style="text-align:left;margin-left:100px;margin-top:0px;"> 
											<tr>
												
												<td class="tabIndex" style="height:10px">姓名：</td>
												<td>&nbsp;<input class="notNull"  name="cdtName" title="姓名" value="${cdt.cdtName }"/></td>
												<td class="tabIndex" style="height:10px">年龄：</td>
											<td>&nbsp;<input class="notNull"   name="cdtAge" title="年龄" value="${cdt.cdtAge }"/></td>
											</tr>
											<tr>
											 
											<td class="tabIndex" style="height:10px">性别：</td>
											<td>&nbsp;<input type="radio"  name="cdtSex" value="男" id="cdtSex_male" checked/>男
											&nbsp;<input type="radio"  name="cdtSex" value="女" id="cdtSex_female"/>女
											</td>
											<script type="text/javascript">
												var cdtSex="${cdt.cdtSex}";
												if(cdtSex=="男"){
													$("#cdtSex_male").attr("checked",true);
												}else if(cdtSex=="女"){
													$("#cdtSex_female").attr("checked",true);
												}else{
												}
											</script>
											<td class="tabIndex" style="height:10px">出生日期：</td>
												<td>&nbsp;<input class="notNull" value="${cdt.cdtBorn }"   name="cdtBorn" title="出生日期" onClick="SelectDate(this,'yyyy-MM-dd');" style="cursor: hand;" />格式:2010-12-12
												</td>

											</tr>
											<tr>
												
																								<td class="tabIndex" style="height:10px">应聘职位：</td>
												<td>&nbsp;<input class="notNull"   name="cdtPosition" title="应聘职位" value="${cdt.cdtPosition }"/></td>
												<td class="tabIndex" style="height:10px">
											  专业：</td>
											<td>&nbsp;<input class="notNull"  name="cdtSpeciality" value="${cdt.cdtSpeciality }"  title="专业"/></td>
											</tr>
											<tr>
											
											<td class="tabIndex" style="height:10px">
											  毕业院校：</td>
											<td>&nbsp;<input type="text" name="cdtGraduateSchool" value="${cdt.cdtGraduateSchool }"  title="毕业院校"/>
											
											</td>
											<td class="tabIndex" style="height:10px">
											  学历：
											</td>
											<td>&nbsp;<select name="cdtDegree" id="cdtDegreeId">
													<option value="1">本科</option>
													<option value="2">高中</option>
													<option value="3">大专</option>
													<option value="4">硕士</option>
													<option value="5">博士</option>
												</select>
												<script type="text/javascript">
												var selVal = "${cdt.cdtDegree}";
												$("#cdtDegreeId").val(selVal);
											</script>
											</td>
										</tr>
										<tr>
											
											<td class="tabIndex" style="height:10px">
											 工作经验：
											</td>
											<td>&nbsp;<select name="cdtExperience" id="cdtExperienceId">
													<option value="1">1~2年</option>
													<option value="2">3~5年</option>
													<option value="3">5~10年</option>
													<option value="4">10年以上</option>
													<option value="5">无经验</option>
												</select>
												<script type="text/javascript">
												var selVal = "${cdt.cdtExperience}";
												$("#cdtExperienceId").val(selVal);
											</script>
											</td>
											<td class="tabIndex" style="height:10px">
											  联系电话：
											</td>
											<td>&nbsp;<input name="cdtTel" title="联系电话" value="${cdt.cdtTel }" /></td>
										</tr>
										<tr>
											
											<td class="tabIndex" style="height:10px">
											  联系地址：
											</td>
											<td>&nbsp;<input name="cdtAddress" title="联系地址" value="${cdt.cdtAddress }"/></td>
											<td class="tabIndex" style="height:10px">
											  登记时间：
											</td>
											<td>&nbsp;<input id="cdtRegTime" name="cdtRegTime" value="${cdt.cdtRegTime }" readonly/></td>
										</tr>
										<tr>
											<td class="tabIndex" style="height:10px">
											  是否录用：
											</td>
											<td>&nbsp;<input type="radio"  name="isHire" id="isHire_y" value="是" checked/>是
											&nbsp;<input type="radio"  name="isHire" id="isHire_n" value="否" />否
											</td>
										</tr>
										<script type="text/javascript">
												var isHire="${cdt.isHire}";
												if(isHire=="是"){
													$("#isHire_y").attr("checked",true);
												}else if(isHire=="否"){
													$("#isHire_n").attr("checked",true);
												}else{
												}
											</script>
										<tr>
											<td class="tabIndex">备注信息：
											</td>
											<td><textarea rows="6" cols="20" name="cdtIntro" >${cdt.cdtIntro }</textarea>
											</td>
										</tr>
									</table>

									<div style="text-align:center;margin-top:15px">
									<a href="javascript:myConfirm('updateCdtForm')"><img src="images/save.gif" width="60" height="25" border="0" /></a>
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
					  <a style="" href="cdt_findAllCdt.action"><img src="images/back.gif" width="60" height="25" border="0" /></a>
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
