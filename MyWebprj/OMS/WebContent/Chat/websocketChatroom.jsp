<%@page import="com.gxnu.entity.Registration"%>
<%@page import="com.gxnu.dao.RegistrationDAO"%>
<%@page import="com.gxnu.util.Data"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会诊室</title>
<script type="text/javascript" src="Chat/js/jquery-1.4.3.js"></script>
<script type="text/javascript">
	var ws;
	//嵌入Java代码，不加""js不执行'
	var ws_url=  "<%=Data.CHAT%>"
	//发新消息，滚动条置底
	window.onload = reset;
	
	var text = $('.ctext');
	$(function() {	
		 ws_connect();
		 $("#send").click(function(){
		    ws_sendMsg();
		    reset();
		 });
		 $("#uploadImg").click(function(){ 
			ws_sendImg();
			reset();
		 });		 
	
	});
	function ws_connect() {
		var name ="${sessionScope.NAME}"
		if ('WebSocket' in window) {
			ws = new WebSocket(ws_url+"?NAME="+name);
		} else if ('MozWebSocket' in window) {
			ws = new MozWebSocket(ws_url+"?NAME="+name);
		} else {
			console.log('Error: WebSocket is not supported by this browser.');
			return;
		}

		ws.onopen = function() {
			console.log('Info: WebSocket connection opened.');
			
		};

		ws.onclose = function() {
			
			console.log('Info: WebSocket closed.');
		};

/* 		ws.onmessage = function(message) {
			//console.log("@@@"+message.data);
			var receiveMsg=message.data;
			 var obj=JSON.parse(receiveMsg);
			 if(obj.type=="s"){
				 $("#record").append("<div>"+obj.msgDateStr+""+obj.msgInfo+"</div>");
				 var userHtml="";
				  var userList=obj.userList;
				    for(var i=0;i<userList.length;i++){
				    	userHtml=userHtml+userList[i]+"<br/><br/>";
				    }
				     $("#userList").html(userHtml);
			 }else if(obj.type=="p"){
				 $("#record").append("<div>"+obj.msgSender+":&nbsp;"+obj.msgDateStr+"</div><div>"+obj.msgInfo+"</div>");
			 }else{
				 //未来可以用于扩展功能
			 }
			
		};
	}; */
	ws.onmessage = function(message) {
		   if("string"==typeof(message.data)){
		   	//console.log("@@@"+message.data);
			var receiveMsg=message.data;
			 var obj=JSON.parse(receiveMsg);
			 if(obj.type=="s"){
				 $("#record").append("<div>"+obj.msgDateStr+""+obj.msgInfo+"</div>");
				 reset();
				 var userHtml="";
				  var userList=obj.userList;
				    for(var i=0;i<userList.length;i++){
				    	userHtml=userHtml+userList[i]+"<br/><br/>";
				    }
				     $("#userList").html(userHtml);
			 }else if(obj.type=="p"){
				 $("#record").append("<div>"+obj.msgSender+":&nbsp;"+obj.msgDateStr+"</div><div>"+obj.msgInfo+"</div>");
				 reset();
			 }else if(obj.type=="img"){
				 picp="<div>"+obj.msgSender+":&nbsp;"+obj.msgDateStr+"</div>";
				 reset();
			 }else{
			  //未来可以用于扩展功能
			 }
		   }else{
		      var reader=new FileReader();
		      reader.readAsDataURL(message.data);
		      reader.onload=function(evt){
		          if(evt.target.readyState==FileReader.DONE){
		             var url=evt.target.result;
		           $("#record").append(picp+"<div><img src='"+url+"' style='max-height:150px; max-width:150px; vertical-align: middle; align: center;'/></div>");
		           reset();
		          }
		      }
		      
		   }
			
		};
	};

	function ws_sendMsg() {
		if($("#msg").val()){
			var msg=$("#msg").val();
	         ws.send(msg);
	        msg= $("#msg").val("");
		 }else{
			alert("发送消息不能为空");
		 }
         
	};

	function ws_sendImg() {
	      var fObj=$("#img")[0].files[0];
	        if(fObj){
	          var reader=new FileReader();
	          reader.readAsArrayBuffer(fObj);
	           reader.onload=function(evt){
	              ws.send(evt.target.result);
	              reset();
	           }
	           $("#img").val("");
	        }else{
	          $("#img").val("");
	        }
		};

	function reset(){	
		//重置滚动条
		let height = document.querySelector('.ctext').scrollHeight;
        document.querySelector(".ctext").scrollTop = height;
        //alert('2');
	};
		
</script>
</head>
<%
	Object obj = session.getAttribute("id");
	int id = 0;
	if(obj!=null){
		id =  Integer.parseInt(String.valueOf(obj));
	}
	Object objt = session.getAttribute("sid");
	int sid = 0;
	if(obj!=null){
		sid = Integer.parseInt(String.valueOf(objt));
	}
%>
	<script type="text/javascript">
		//var btn = 
		function disconn(){
			
			window.top.location.href="<%=Data.URL%>/disconnect?id=<%=id %>&sid=<%=sid%>";
		}
	</script>
<body>
	********************会诊室******************************
	<table style="border: 1px solid #00F;">
		<tbody>
			<tr>
				<td colspan="2" align="center">
					<h3>welcome to【${sessionScope.NAME}】 use this system!</h3>
				</td>
			</tr>
			<tr>
				<td width="500px" height="300px"
					style="border: 1px solid #00F; vertical-align: top;" id="content"
					name="content">
					<div  style="background-color: white;">
						<table  id="tbRecord">
							<tbody class="ctext" id="record"
								style="display: block; height: 300px; width: 500px; overflow: auto;" />
						</table>
					</div>
				</td>
				<td width="100px"
					style="border: 1px solid #00F; vertical-align: top;">
					<div style="overflow: auto;">
						<table id="tbuserList">
							<tbody id="userList"
								style="display: block; height: 300px; overflow: auto;" />
						</table>
					</div>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" align="center"><input id="msg" name="msg"
					style="width: 100%;" placeholder="输入您想要发送的消息..." /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button style="margin: 0 30px 0 30px" id="send" name="send">send</button>
					<input type="file" id="img" style="width: 200px; height: 30px" />
					<button id="uploadImg" name="uploadImg">uploadImg</button>
					<input type="button" style="margin: 0 30px 0 30px" id="disconnect"
						name="disconnect" value="Disconnect" onclick="disconn()">
				</td>			
			</tr>
		</tfoot>
	</table>
</body>
	
</html>