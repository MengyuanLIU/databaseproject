// JavaScript Document


function myConfirm(formId) {
var a=0;
var arrayObj = new Array();
//非空验证
$(".notNull").each(function(i){
	
	if($(this).val()==""){
		arrayObj.push($(this).attr("title")+"不能为空");
		a+=1;
	}
	
})

//其它验证
$("input").each(function(i){
	
	if($(this).attr("name")=="emAge"&&$(this).val()!=""){
		var myReg = /^[0-9]*$/;
		if(!myReg.test($(this).val())){
			arrayObj.push("年龄只能为数字");
			a+=1;
		}
	}
	
	if($(this).attr("name")=="emIdCard"&&$(this).val()!=""){
		var myReg = /^([0-9a-zA-Z]{15}|[0-9a-zA-Z]{18})$/;
		if(!myReg.test($(this).val())){
			arrayObj.push("身份证号长度错误");
			a+=1;
		}
	}
	
	if($(this).attr("name")=="emTel"&&$(this).val()!=""){
		var myReg = /^[0-9]*$/;
		if(!myReg.test($(this).val())){
			arrayObj.push("联系电话只能为数字");
			a+=1;
		}
	}
	if($(this).attr("name")=="emBorn"&&$(this).val()!=""){
		var myReg = /^[0-9]{4}[-][0-9]{2}[-][0-9]{2}$/;
		if(!myReg.test($(this).val())){
			arrayObj.push("出生日期格式错误");
			a+=1;
		}
	}
	if($(this).attr("name")=="emWorkTime"&&$(this).val()!=""){
		var myReg = /^[0-9]{4}[-][0-9]{2}[-][0-9]{2}$/;
		if(!myReg.test($(this).val())){
			arrayObj.push("上岗时间格式错误");
			a+=1;
		}
	}
	
})

//提示信息
if(arrayObj.length>0){
	alert(arrayObj[0]);
}

if(a==0){
document.getElementById(formId).submit();

}

}
