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
								<span  class="font3"><strong> &nbsp;首页&nbsp;>&nbsp;培训管理&nbsp;>&nbsp;查看培训信息</strong></span>
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
							
							
							
							
											<form >
											<table width="620" border="1"  class="formTable"
											cellpadding="0" cellspacing="1" style="text-align:left;margin-left:100px;margin-top:50px;"> 
											<tr>
												
												<td class="tabIndex" style="height:10px">培训标题：</td>
												<td>&nbsp;<input   name="trainTitle" value="${train.trainTitle }" title="培训标题"  readonly/></td>
												<td class="tabIndex" style="height:10px">培训人：</td>
											<td>&nbsp;<input   name="trainMan" value="${train.trainMan }" title="培训人" readonly/></td>
											</tr>
											<tr>
											 
											<td class="tabIndex" style="height:10px">培训宗旨：</td>
											<td>&nbsp;<input type="text"  name="trainZz" value="${train.trainZz }" title="培训宗旨" readonly/>
											<td class="tabIndex" style="height:10px">培训时间：</td>
												<td>&nbsp;<input class="notNull"   name="trainTime" value="${train.trainTime }" title="培训时间" readonly /></td>
											</tr>
											<tr>
												
												<td class="tabIndex" style="height:10px">培训地址：</td>
												<td>&nbsp;<input class="notNull"   name="trainAddress" value="${train.trainAddress }" title="培训地址" readonly/></td>
												<td class="tabIndex" style="height:10px">
											  参加人员：</td>
											<td>&nbsp;<input   name="trainEmps" value="${train.trainEmps }" title="参加人员" readonly/></td>
											</tr>
										<tr>
											<td class="tabIndex">备注信息：
											</td>
											<td><textarea rows="6" cols="20" name="trainNote" readonly>${train.trainNote }</textarea>
											</td>
										</tr>
									</table>

									<div style="text-align:center;margin-top:15px">
									<a style="" href="javascript:history.go(-1);"><img src="images/back.gif" width="60" height="25" border="0" /></a>
									 
									</div>
									</form>
							
							
							
							
							
							
							
							<!--表单内容结束-->
								
							
						
						</td>
					</tr>
					
                  </table>
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
