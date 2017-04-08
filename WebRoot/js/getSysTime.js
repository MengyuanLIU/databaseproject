		//获取系统时间
		function getSysTime(format){
			var d, s;          
		   d = new Date(); 
		   if(format=="yyyy-MM-dd"||format==""||format==null){                         
			   s=d.getFullYear()+ "-";
			   var month=d.getMonth() + 1
			   if(month<10){
			   		month="0"+month;
			   }
			   s +=month + "-";
			   dd=d.getDate();
			   if(dd<10){
			   		dd="0"+dd;
			   }         
			   s += dd;    
			   return s;
		   }else if(format=="yyyy-MM-dd hh:mm:ss"){
			   s=d.getFullYear()+ "-";
			   var month=d.getMonth() + 1
			   if(month<10){
			   		month="0"+month;
			   }
			   s +=month + "-";
			   dd=d.getDate();
			   if(dd<10){
			   		dd="0"+dd;
			   }         
			   s += dd;                  
			   s += " "+(d.getHours()<10?"0"+d.getHours():d.getHours())+":";
			   s += (d.getMinutes()<10?"0"+d.getMinutes():d.getMinutes())+":";
			   s += (d.getSeconds()<10?"0"+d.getSeconds():d.getSeconds()); 
			   return s;
		   }else if(format=="yyyy年MM月dd日 hh:mm:ss"){
			   s=d.getFullYear()+ "年";
			   var month=d.getMonth() + 1
			   if(month<10){
			   		month="0"+month;
			   }
			   s +=month + "月";
			   dd=d.getDate();
			   if(dd<10){
			   		dd="0"+dd+"日";
			   }         
			   s += dd;                  
			   s += " "+(d.getHours()<10?"0"+d.getHours():d.getHours())+":";
			   s += (d.getMinutes()<10?"0"+d.getMinutes():d.getMinutes())+":";
			   s += (d.getSeconds()<10?"0"+d.getSeconds():d.getSeconds()); 
			   return s;
		   }else if(format=="yyyyMMdd"){
		   	   s=d.getFullYear();
			   var month=d.getMonth() + 1
			   if(month<10){
			   		month="0"+month;
			   }
			   s +=""+month;
			   dd=d.getDate();
			   if(dd<10){
			   		dd="0"+dd;
			   }         
			   s += dd;    
			   return s;
		   }else if(format=="yyyy年MM月dd日"){
		   	   s=d.getFullYear()+"年";
			   var month=d.getMonth() + 1
			   if(month<10){
			   		month="0"+month;
			   }
			   s +=""+month+"月";
			   dd=d.getDate();
			   if(dd<10){
			   		dd="0"+dd+"日";
			   }         
			   s += dd;    
			   return s;
		   }else if(format=="yyyyMMddhhmmss"){
		   	   s=d.getFullYear();
			   var month=d.getMonth() + 1
			   if(month<10){
			   		month="0"+month;
			   }
			   s +=""+month;
			   dd=d.getDate();
			   if(dd<10){
			   		dd="0"+dd;
			   }         
			   s += dd;                  
			   s += (d.getHours()<10?"0"+d.getHours():d.getHours());
			   s += (d.getMinutes()<10?"0"+d.getMinutes():d.getMinutes());
			   s += (d.getSeconds()<10?"0"+d.getSeconds():d.getSeconds()); 
			   return s;
		   }else if(format=="yyyy"){
		   	   s=d.getFullYear()+"";
		   	   return s;
		   }else{
		   		alert("参数错误");
		   		return "参数错误";
		   }
		}