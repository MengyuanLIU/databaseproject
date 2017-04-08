<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>">
    
    <title>人力资源管理系统</title>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/pub_js.js"></script>
<script type="text/javascript" >
     function onloadFun(){
		 var username = document.getElementById("username");
		 username.focus();
	 }
	 function checkLogin(){
		var username = myTrim(document.getElementById("username").value);
		var userpwd = document.getElementById("userpwd").value;
		var inputCodeId = myTrim(document.getElementById("inputCodeId").value);
		if(username==""){
			alert("请输入用户名");
			return;
		}
		if(userpwd==""){
			alert("请输入密码");
			return;
		}
		if(inputCodeId==""){
			alert("请输入验证码");
			return;
		}
	 	document.getElementById("loginForm").submit();
	 }
	 function keyUp(e) {
       var currKey=0,e=e||event;
       currKey=e.keyCode||e.which||e.charCode;
       var keyName = String.fromCharCode(currKey);
	   if(currKey==13){
		   document.getElementById("imgBtn").click();
	   }
   }
   document.onkeyup = keyUp;
    //刷新验证码
	function reloadCode(){
		var verify=document.getElementById('imgCodeId');
		verify.setAttribute('src','<c:url value="/captcha.svl"/>'+'?'+Math.random());
	}
    </script>
  </head>
  <body style="margin:0;padding:0;overflow: hidden" onload="onloadFun()">

  
  
  
  
  

  
 <div id="center" style="background:#2286C2;width:100%;height:800px; text-align:center;padding-top:30px; ">
			
            	<table width="100%" >  
				<tr height="100">
				<font color=white >SDU LiuMengyuan ZhangYupeng Xinzengwei           Advisor：Pro.ShiBing</font>
				</tr>
				
					
				
                  
                <div style="text-align:center;width:100%">   
            	<form id="loginForm" action="<%=basePath%>login_login.action" method="post" style="background:url('images/login_box.jpg'); background-position:center; background-repeat:no-repeat; text-align:center;">
                	<table align="center" border="0" width="588" style="font-size:14px; font-family:Verdana, Geneva, sans-serif" > 
                    <tr height="50" >
                    	<td colspan="2" align="center">
                        	<table width="100%" style="font-size:14px; font-family:Verdana, Geneva, sans-serif; color:#FFFFFF">
                            	<tr  height="30">
                                	<td></td>
                                   
                                </tr>
                            </table>
                        
                        </td>
                        
                    </tr>
                    <tr>
                    	<td align="center" colspan="2"><img src="images/index1_01.gif"  height="74" /></td>
                        <td></td>
                    </tr>
                    <tr>
                    
                    <td align="right" width="200" >  
                      username</td><td><input type="text" size="30" id="username" name="account">
                     </td></tr>
                      <tr>
                    <td align="right" > 
                       password</td><td><input type="password" size="30" id="userpwd" name="password">
                     </td>
                     </tr>
                     
                      <tr>
		<td align="right" height="50">
			
		verification code</td>
		<td align="left" valign="center" >
			<table border="0" cellpadding="0" cellspacing="0" style="">
				<tr>
				<td align="left">
					<input id="inputCodeId" name="inputCode" size="7" style="height: 25px"  />
				</td>
				<td>
					<img style="border: none" id="imgCodeId" src="<c:url value="/captcha.svl"/>" width="70" height="35"  />
					<a style="color:blue;font-size: 12" href="javascript:reloadCode()">Changing</a>
					&nbsp;&nbsp;
					<font color="red" style="font-size:12px">
					<%
	                    	String errorInfo = request.getParameter("errorInfo");
	                    	if("".equals(errorInfo)||null==errorInfo){
	                    	
	                    	}else if("error1".equals(errorInfo)){
	                    		out.print("验证码错误");
	                    	}else if("error2".equals(errorInfo)){
	                    		out.print("用户名或密码错误");
	                    	}else{
	                    		out.print("系统异常");
	                    	}
                    	%>
					</font>
				</td>
				</tr>
			</table>
			</td>
			<td>
			</td> 
		</tr>
                     
                       <tr>
                    <td> 
                    </td>
                    <td height="60"> 
						<a href="javascript:checkLogin()" style="text-decoration:none">
						<div id="loginBtn"    style="display:block;cursor: hand;width:248px;height:52px;background:url(images/btn_login.jpg);border:none;text-align: center;">
                        </div>
                          </a>   
                    </td>
                    </tr>
                   </table>
               <table width="100%" border="0" cellspacing="0" cellpadding="0">    
  
    
    
  
  
  
  

</body>
</html>
