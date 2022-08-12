<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
<script type="text/javascript" src=""></script>
</head>
 <script>
 //true
             		var input = window.document.getElementById('ip');
             		var Tip = document.getElementById("tip");
             		//input.addEventListener('input', updateValue);
             		input.addEventListener('change', updateValue);
					function updateValue(e) {
						var pattern = /^((2(5[0-5]|[0-4]\d))|[0-1]?\d{1,2})(\.((2(5[0-5]|[0-4]\d))|[0-1]?\d{1,2})){3}$/;
					    var str = window.document.getElementById("ip").value;
					    if(pattern.test(str)){
						    
					    }else{
							Tip.innerHTML="输入IP有误";
					    }
					   
					}	
				  </script>
 <script>
<!-- <script>
             		var input = window.document.getElementById('ip');
             		var Tip = document.getElementById("tip");
             		//input.addEventListener('input', updateValue);
             		input.addEventListener('change', updateValue);
					function updateValue(e) {
						var pattern = /^((2(5[0-5]|[0-4]\d))|[0-1]?\d{1,2})(\.((2(5[0-5]|[0-4]\d))|[0-1]?\d{1,2})){3}$/;
					    var str = window.document.getElementById("ip").value;
					    if(pattern.test(str)){
						    
					    }else{
							Tip.innerHTML="输入IP有误";
					    }
					   
					}	
</script> --> 
 $("input:text").bind("input propertychange",function(){
	var pattern = /^((2(5[0-5]|[0-4]\d))|[0-1]?\d{1,2})(\.((2(5[0-5]|[0-4]\d))|[0-1]?\d{1,2})){3}$/;
    var str = window.document.getElementById("ip").value;
    if(pattern.test(str)){
		document.write(pattern.test(str));
    }esle{
		alert("IP有误");
    }
	 
	});
 </script>
<body>
<input type="text" id="ip" οninput="onInput(event)" onpropertychange="onPropertyChange(event)" placeholder="Enter IP"  name="ipAddress" />
</body>
</html>