<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="java.util.Date"%>
<%@page import="com.gxnu.entity.Unit"%>
<%@page import="com.gxnu.service.imp.UnitService"%>
<%@page import="com.gxnu.service.IUnitService"%>
<%@page import="com.gxnu.entity.DrugInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.DrugInfoService"%>
<%@page import="com.gxnu.service.IDrugInfoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
//获取请求转发信息
	Object obj1 = request.getAttribute("UNITS");
	List<Unit> units = new ArrayList<Unit>();
	if (obj1 != null) {
		units = (List<Unit>) obj1;
	}
	List<Integer> sums = new ArrayList<>();
	Object obj2 = request.getAttribute("SUMS");
	if (obj2 != null) {
		sums = (List<Integer>)obj2;
	}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>统计 </title>

    <!-- project css file  -->
    <link rel="stylesheet" href="<%=Data.URL%>/Manage/static/css/ihealth.style.min.css">
</head>
<body>

<div id="ihealth-layout" class="theme-tradewind">

    <!-- main body area -->
    <div class="main px-lg-4 px-md-4">
    
        <!-- Body: Body -->
        <div class="body d-flex py-3">
            <div class="container-xxl">
                <div class="row g-3 mb-3 row-deck">
                    <div class="col-sm-12">
                        <div class="card">
                            <div class="card-header py-3 d-flex justify-content-between bg-transparent border-bottom-0">
                                <h6 class="mb-0 fw-bold ">统计图</h6> 
                            </div>
                            <form action="<%=Data.URL%>/draw" method="post">
                                                                            请输入统计的日期，格式为2022-08-10：<input type="text" name="time"/>
		                    
		                    <input type="submit" class="btn btn-primary" value="确认"
								 />
							 <div id="main" style="width: 600px;height:400px;"></div>
		                    </form>
                        </div>
                    </div>
                </div><!-- .row end -->
            </div>
        </div>
    </div>
  
</div>



<!-- Jquery Core Js -->
<script src="<%=Data.URL%>/Manage/static/js/libscripts.bundle.js"></script>

<!-- Plugin Js -->
<script src="<%=Data.URL%>/Manage/static/js/echarts.min.js"></script>

<!-- Jquery Page Js -->
<script src="<%=Data.URL%>/Manage/static/js/template.js"></script>
<script src="<%=Data.URL%>/Manage/static/js/covid.js"></script>


 <script type="text/javascript">
   // 基于准备好的dom，初始化echarts实例
   var myChart = echarts.init(document.querySelector('#main'));

   // 指定图表的配置项和数据
   var option = {
   title: {
          text: '各科室一天的预约人数'
   },
   tooltip: {},
   legend: {
   data: ['预约人数']
   },
   xAxis: {
	   <%
       String[] data = new String[100] ;  
       StringBuffer sb = new StringBuffer("[");
       for(int i = 0; i<units.size();i++){
    	   data[i] = units.get(i).getName();
    	   sb.append("'"+data[i]+"',");
       }
	   String xxx =  sb.substring(0,sb.length()-1)+"]";
       //System.out.println(xxx);
       %>
       data: <%=xxx%>
       
   },
  yAxis: {},
         series: [
         {
         name: '预约人数',
         type: 'bar',
         <%
         StringBuffer ysb = new StringBuffer("[");
         int[] array;
         array = sums.stream().mapToInt(Integer::intValue).toArray();
         for(int i = 0;i<sums.size();i++){
        	 ysb.append("'"+array[i]+"',");
         }
         String yyy =  ysb.substring(0,ysb.length()-1)+"]";
         System.out.println(yyy);
         %>
         data: <%=yyy%>
         }
       ]
  };

 // 使用刚指定的配置项和数据显示图表。
 myChart.setOption(option);
 </script>

</body>
</html> 