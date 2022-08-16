<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>excel</title>
    </head>
    <body>
        <h2 style="text-align: center;font-family: 楷书;">excel项目文件生成</h2>
        <p>使用须知:输入项目工作区，选择项目文件，点击上传即可生成所有项目对应绩效监控表。</p>
        <p style="color: red;">若项目表无其他工作区,则不要填写任何内容。<br>如果发现服务器没有响应，可能是报错了，刷新页面重试即可。<p>
        <p>本项目中用的绩效监控表生成模板是固定的，代码也是固定的,若更换模板或者项目表格式,请告知开发者,下面是参考模板</p>
        <img alt="" src="img/project.jpg" style="width:500px;height: 300px">
        <img alt="" src="img/template.jpg" style="width:500px;height: 300px">
        <br><br>
        <form action="http://192.168.1.167:8080/excelpro/excel" enctype="multipart/form-data" method="post">
            <!-- <input name="ProName" value="" placeholder="若只需要生成项目表中一个项目的绩效表，则输入该项目的名称" style="width:600px"><br> -->
            <input name="ProSheet" value="" placeholder="若表在工作区中，输入工作区名称" style="width:200px">
            <input id="file1" name="file1" type="file" onclick="check1()">
            <input type="submit" value="确定">
            <input id="proFile" name="proFile" type="hidden" >
          <!--   <br><br><br> -->
      <!--       <input name="TempCell" placeholder="若绩效表模板在此上传的excel表工作区内,则输入工作区名，此模板只需上传一次且只有一个，若需更换模板请重新上传" style="width:700px">
            <input id="file2" name="file2" type="file" onclick="check2()"><br>
            <input type="submit" value="上传指定模板">
            <input id="temFile" name="temFile" type="hidden"> -->
        </form>

    </body>
<script type="text/javascript">
	//window.load = check;
	var file1 = document.getElementById("proFile");
	var file2 = document.getElementById("temFile"),
	check1 = function (){	
		file1.value = "1";	
		//alert();
	}
	check2 = function (){	
		file2.value = "1";
		//alert();
	}
</script>
</html>
