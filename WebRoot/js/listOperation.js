//执行全选和反选
$(function() { 
	//监听主选框
	$("#selectall").click(function() {
		var hasCancelFlag=0;
		$("input[name='box_em']").each(function(i) { 
			if(!$(this).attr("checked")){
				hasCancelFlag+=1;
			}; 
		}); 
		if(hasCancelFlag>0){
			//全选
			$("input[name='box_em']").each(function(i) { 
				$(this).attr("checked",true);
			});
		}else{
			//反选
			if(!$("#selectall").attr("checked")){//主框被选中
				$("input[name='box_em']").each(function(i){
					$(this).attr("checked",false);
				});
			}else{//主框未被选中
				
			}
		}
	}); 
	//监听子选框
	$("input[name='box_em']").each(function(i) { 
		$(this).click(function(i){
			if(!$(this).attr("checked")){
				$("#selectall").attr("checked",false);
			}
		});
	});
});
//获取所有选择框的值

function getSelectValues(){
	var myArr= new Array();
	$("input[name='box_em']").each(function(i) { 
		if($(this).attr("checked")){
			myArr.push($(this).val());
		}; 
	});
	return myArr;
}
//列表批量修改按钮
function updateRecord(url){
	var valuesArr = getSelectValues();
	if(valuesArr.length==0){
		alert("请选择要修改的条目！");
		return;
	}
	if(valuesArr.length>1){
		alert("不能执行批量修改！");
		return;
	}
	if(valuesArr.length==1){
		var u=url+valuesArr[0];
		location.href=u;
	}
}


//列表批量删除按钮
function delBatchRecord(url){
	var valuesArr = getSelectValues();
	if(valuesArr.length==0){
		alert("请选择要删除的条目！");
		return;
	}
	if(!confirm("确认删除所选条目？")){
		return;
	}
	location.href=url+valuesArr;
}

//列表确认删除（列表操作项）
function delRecord(url){
	if(!confirm("确认删除此条信息？")){
		return;
	}
	location.href=url;
}