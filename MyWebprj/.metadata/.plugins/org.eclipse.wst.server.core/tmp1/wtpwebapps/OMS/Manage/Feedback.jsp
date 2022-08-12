<%@page import="com.gxnu.entity.Feedback"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.FeedbackService"%>
<%@page import="com.gxnu.service.IFeedbackService"%>
<%@page import="com.gxnu.util.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	int pageSize=10;			//每一页 上显示信息的最大条数
	int firstPage=1;		//首页的页码
	int previousPage=1;		//上一页的页码
	int nextPage=1;			//下一页的页码
	int lastPage=1;			//最后一页的页码
	int currentPage=1;		//当前的页码
	
	//获取请求参数P，该值为要显示的页码
	String cp = request.getParameter("P");
	if(cp!=null){
		currentPage = Integer.parseInt(cp);
	}

   //调用业务方法，检索所有菜单信息
   IFeedbackService feedbackService = new FeedbackService();
   List<Feedback> feedbacks = feedbackService.find();
   int total = feedbacks.size(); //最记录条数
   //分页
   feedbacks = feedbackService.find(currentPage,pageSize);
   
   //最后一页的页码
   if(total%pageSize==0){
	   lastPage = total/pageSize;
   }else{
	   lastPage = total/pageSize + 1;
   }
   
	//得到上一页的页号
   previousPage=currentPage-1;
   if(previousPage<=firstPage){
	previousPage=firstPage;
   }
	
   //得到下一页的页号
   nextPage=currentPage+1;
   if(nextPage>=lastPage){
	 nextPage=lastPage;
   }
   
%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>:: 后台管理::  留言反馈 </title>
    <!-- plugin css file  -->
    <link rel="stylesheet" href="static/css/responsive.dataTables.min.css">
    <link rel="stylesheet" href="static/css/dataTables.bootstrap5.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="static/css/ihealth.style.min.css">
    <script>
   function xxx(n){
	   //重新跳转到menu.jsp，即“刷新tab.jsp”,且把要显示的号码以请求参数的方法进行传递，如 P=4
	   window.location.href="<%=Data.URL+"/Manage/Feedback.jsp?P="%>"+n;
   }
</script>
</head>
<body>

<div id="ihealth-layout" class="theme-tradewind">
   <div class="main px-lg-4 px-md-4">
        <!-- Body: Body -->
        <div class="body d-flex py-3">
            <div class="container-xxl">
                <div class="row align-items-center">
                    <div class="border-0 mb-4">
                        <div class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                            <h3 class="fw-bold mb-0">留言反馈管理</h3>
                        </div>
                    </div>
                </div> 
                
                <!-- 页码显示、搜索框 -->
               
                  <table border="0" style="width:85%"><tr>
                              <td>  <table border="0">
                                <tr>
                               <td style="align:right"> 每页</td>
                               <td style="width:40%">
                               <select name="editable_length" aria-controls="editable" class="form-control input-sm"  style="width:100px;margin: 0 auto">
                             	<option value="10"  >10</option>
                             	<option value="25">25</option>
                             	<option value="50">50</option>
                             	</select></td>  <td style="margin:60%;">条记录</br></td>
                               </tr></table></td>
                               
                                <!-- 搜索框的设置 -->
                               <td> <table border="0">
                                <tr>
                                <td id="editable_filter" class="dataTables_filter"> 搜索：</td>
                                <td><input type="search" class="form-control form-control-sm" placeholder="" aria-controls="patient-table"></td>
                                </tr></table></td>
                                
                                </tr></td></table>
                                </br>
                
                <!-- Row end  -->
                <div class="row mb-3">
                    <div class="card">
                        <div class="card-body">
                            <table id="patient-table" class="table table-hover align-middle mb-0" style="width: 100%;">
                                <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>时间</th>
                                        <th>内容</th>        
                                    </tr>
                                    
                                      <%
			            //循环遍历集合，每循环一次，生成一行html<tr></tr>，在每一个单元格中 <td></td>,把静态数据改成数据库表中的记录
			            for(Feedback feedback : feedbacks ) {
			          %>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><%=feedbacks.indexOf(feedback)+1%></td>
                                        <td><span><%=feedback.getTime() %></span></td>
                                        <td><%=feedback.getContent()%></td>
                                    </tr> <%} %>
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
      
     
      <table style="width: 100%;"><tr>
      <td class="dataTables_info" id="patient-table_info" role="status" aria-live="polite">显示1至10个结果，共 <%=total %>条记录</td>
     
      <td><ul class="pagination">
      <li class="paginate_button page-item previous disabled" id="patient-table_previous">
       <input type="button" value="上一页"  onclick="xxx(<%=previousPage%>)" aria-controls="patient-table" data-dt-idx="0" tabindex="0"/></li>&nbsp;&nbsp;&nbsp;
      <li class="paginate_button page-item active">
      <a href="#" aria-controls="patient-table" data-dt-idx="1" tabindex="0" ><%=currentPage %>/<%=lastPage %>页 </a></li>&nbsp;&nbsp;&nbsp;
      <li class="paginate_button page-item next disabled" id="patient-table_next">
      <input type="button" value="下一页"  onclick="xxx(<%=nextPage%>)"/></li>
       </ul></td>
       
     <td>  
     <button style="display:block;margin:70 auto" type="" class="btn btn-primary mt-4" onclick="javascript:window.location.href='<%=Data.URL%>/Manage/index.html'"/>返回</button>
     </td>
     </tr>
     </table>
       
     
      
        <!-- Modal Custom Settings-->
       <div class="modal fade right" id="Settingmodal" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog  modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Custom Settings</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body custom_setting">
                        <!-- Settings: Color -->
                        <div class="setting-theme pb-3">
                            <h6 class="card-title mb-2 fs-6 d-flex align-items-center"><i class="icofont-color-bucket fs-4 me-2 text-primary"></i>Template Color Settings</h6>
                            <ul class="list-unstyled row row-cols-3 g-2 choose-skin mb-2 mt-2">
                                <li data-theme="indigo"><div class="indigo"></div></li>
                                <li data-theme="tradewind" class="active"><div class="tradewind"></div></li>
                                <li data-theme="monalisa"><div class="monalisa"></div></li>
                                <li data-theme="blue"><div class="blue"></div></li>
                                <li data-theme="cyan"><div class="cyan"></div></li>
                                <li data-theme="green"><div class="green"></div></li>
                                <li data-theme="orange"><div class="orange"></div></li>
                                <li data-theme="blush"><div class="blush"></div></li>
                                <li data-theme="red"><div class="red"></div></li>
                            </ul>
                        </div>
                        <div class="sidebar-gradient py-3">
                            <h6 class="card-title mb-2 fs-6 d-flex align-items-center"><i class="icofont-paint fs-4 me-2 text-primary"></i>Sidebar Gradient</h6>
                            <div class="form-check form-switch gradient-switch pt-2 mb-2">
                                <input class="form-check-input" type="checkbox" id="CheckGradient">
                                <label class="form-check-label" for="CheckGradient">Enable Gradient! ( Sidebar )</label>
                            </div>
                        </div>
                        <!-- Settings: Template dynamics -->
                        <div class="dynamic-block py-3">
                            <ul class="list-unstyled choose-skin mb-2 mt-1">
                                <li data-theme="dynamic"><div class="dynamic"><i class="icofont-paint me-2"></i> Click to Dyanmic Setting</div></li>
                            </ul>
                            <div class="dt-setting">
                                <ul class="list-group list-unstyled mt-1">
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label>Primary Color</label>
                                        <button id="primaryColorPicker" class="btn bg-primary avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label>Secondary Color</label>
                                        <button id="secondaryColorPicker" class="btn bg-secondary avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label class="text-muted">Chart Color 1</label>
                                        <button id="chartColorPicker1" class="btn chart-color1 avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label class="text-muted">Chart Color 2</label>
                                        <button id="chartColorPicker2" class="btn chart-color2 avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label class="text-muted">Chart Color 3</label>
                                        <button id="chartColorPicker3" class="btn chart-color3 avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label class="text-muted">Chart Color 4</label>
                                        <button id="chartColorPicker4" class="btn chart-color4 avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label class="text-muted">Chart Color 5</label>
                                        <button id="chartColorPicker5" class="btn chart-color5 avatar xs border-0 rounded-0"></button>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- Settings: Font -->
                        <div class="setting-font py-3">
                            <h6 class="card-title mb-2 fs-6 d-flex align-items-center"><i class="icofont-font fs-4 me-2 text-primary"></i> Font Settings</h6>
                            <ul class="list-group font_setting mt-1">
                                <li class="list-group-item py-1 px-2">
                                    <div class="form-check mb-0">
                                        <input class="form-check-input" type="radio" name="font" id="font-poppins" value="font-poppins">
                                        <label class="form-check-label" for="font-poppins">
                                            Poppins Google Font
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item py-1 px-2">
                                    <div class="form-check mb-0">
                                        <input class="form-check-input" type="radio" name="font" id="font-opensans" value="font-opensans" checked="">
                                        <label class="form-check-label" for="font-opensans">
                                            Open Sans Google Font
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item py-1 px-2">
                                    <div class="form-check mb-0">
                                        <input class="form-check-input" type="radio" name="font" id="font-montserrat" value="font-montserrat">
                                        <label class="form-check-label" for="font-montserrat">
                                            Montserrat Google Font
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item py-1 px-2">
                                    <div class="form-check mb-0">
                                        <input class="form-check-input" type="radio" name="font" id="font-mukta" value="font-mukta">
                                        <label class="form-check-label" for="font-mukta">
                                            Mukta Google Font
                                        </label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <!-- Settings: Light/dark -->
                        <div class="setting-mode py-3">
                            <h6 class="card-title mb-2 fs-6 d-flex align-items-center"><i class="icofont-layout fs-4 me-2 text-primary"></i>Contrast Layout</h6>
                            <ul class="list-group list-unstyled mb-0 mt-1">
                                <li class="list-group-item d-flex align-items-center py-1 px-2">
                                    <div class="form-check form-switch theme-switch mb-0">
                                        <input class="form-check-input" type="checkbox" id="theme-switch">
                                        <label class="form-check-label" for="theme-switch">Enable Dark Mode!</label>
                                    </div>
                                </li>
                                <li class="list-group-item d-flex align-items-center py-1 px-2">
                                    <div class="form-check form-switch theme-high-contrast mb-0">
                                        <input class="form-check-input" type="checkbox" id="theme-high-contrast">
                                        <label class="form-check-label" for="theme-high-contrast">Enable High Contrast</label>
                                    </div>
                                </li>
                                <li class="list-group-item d-flex align-items-center py-1 px-2">
                                    <div class="form-check form-switch theme-rtl mb-0">
                                        <input class="form-check-input" type="checkbox" id="theme-rtl">
                                        <label class="form-check-label" for="theme-rtl">Enable RTL Mode!</label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="modal-footer justify-content-start">
                        <button type="button" class="btn btn-white border lift" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary lift">Save Changes</button>
                    </div>
                </div>
            </div>
        </div> 
     </div>
</div>

<!--Jquery核心Js-->
<script src="static/js/libscripts.bundle.js"></script>

<!-- 插件Js-->
<script src="static/js/dataTables.bundle.js"></script>

<!-- Jquery页面Js -->
<script src="static/js/template.js"></script>

 
</body>
</html> 