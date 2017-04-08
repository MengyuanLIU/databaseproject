
	
	window.onload=function(){
		var top_1= document.getElementById("top_1");
		var top_2= document.getElementById("top_2");
		var top_3= document.getElementById("top_3");
		top_1.attachEvent("onmouseover", mouseoverHandler('1'));
		top_2.attachEvent("onmouseover", mouseoverHandler('2'));
		top_3.attachEvent("onmouseover", mouseoverHandler('3'));
		top_1.attachEvent("onmouseout", mouseoutHandler('1'));
		top_2.attachEvent("onmouseout", mouseoutHandler('2'));
		top_3.attachEvent("onmouseout", mouseoutHandler('3'));
	}
	function mouseoutHandler(num)
	{
		return function(){
		document.getElementById("img_"+num).src="images/top-"+num+".gif";
		}
	}
	function mouseoverHandler(num)
	{
		return function(){
		document.getElementById("img_"+num).src="images/top-"+num+num+".gif";
		}
	}