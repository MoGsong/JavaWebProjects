<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>    
<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Schedule"%>
<%@page import="com.gxnu.service.imp.ScheduleService"%>
<%@page import="com.gxnu.service.IScheduleService"%>
<%@page import="com.gxnu.entity.Unit"%>
<%@page import="com.gxnu.service.imp.UnitService"%>
<%@page import="com.gxnu.service.IUnitService"%>
<%@page import="com.gxnu.entity.Doctor"%>
<%@page import="com.gxnu.service.imp.DoctorService"%>
<%@page import="com.gxnu.service.IDoctorService"%>
<%@page import="com.gxnu.entity.Unit"%>
<%@page import="com.gxnu.service.imp.UnitService"%>
<%@page import="com.gxnu.service.IUnitService"%>
<%
	
	    //直接获取数据库信息，显示出界面
	    IScheduleService iis = new ScheduleService();
		List<Schedule> schedules1 = new ArrayList<Schedule>();

		List<Schedule> schedules2 = new ArrayList<Schedule>();
		
		/*
		Object obj = request.getAttribute(Data.UNIT);
		Unit selectedUnit = new Unit();
		if (obj != null) {
			selectedUnit = (Unit) obj;
		}
		int selectedUnitId = selectedUnit.getId();
		*/
		
		int selectedUnitId =0;
		//Object obj = request.getAttribute("unitId");
		Object obj = session.getAttribute("unitId");
		if (obj != null) {
			selectedUnitId = (int) obj;
		}
		
		IDoctorService ids = new DoctorService();
		List<Doctor> doctors = ids.findByUnit(selectedUnitId);
		
%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>值班管理 </title>
    <!-- plugin css file  -->
    <link rel="stylesheet" href="<%=Data.URL%>/Manage/static/css/main.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="<%=Data.URL%>/Manage/static/css/ihealth.style.min.css">


</head>
<body>

<div id="ihealth-layout" class="theme-tradewind">
    <!-- main body area -->
    <div class="main px-lg-4 px-md-4">

        <!-- Body: Body -->
        <div class="body d-flex py-lg-3 py-md-2">
            <div class="container-xxl">
                <div class="row align-items-center">
                    <div class="border-0 mb-4">
                        <div class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom">
                            <h3 class="fw-bold mb-0">值班管理</h3>    
                            <div class="col-auto d-flex">
                           <!-- 添加排班按钮 data-bs-target="#addevent"-->
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addevent">
                                <i class="icofont-plus-circle me-2 fs-6"></i>添加排班</button>
                            </div>
                        </div>
                    </div>
                </div> <!-- Row end  -->
                


                <!-- Start Doctor Calendar Area -->
        <section class="doctor-calendar-area section" >
            <div class="container">
                <div class="row">
					<div class="col-lg-12">
						<div class="section-title">
							<h2>值班表</h2>
						</div>
					</div>
				</div>
                <div class="row">
					<div class="col-12">
						<div class="doctor-calendar-table table-responsive">
							<table class="table">
								<thead>
									<tr style="background-color: #6AAB9C;">
										<th>Time</th>
										<th>Monday</th>
										<th>Tuesday</th>
										<th>Wednesday</th>
										<th>Thursday</th>
										<th>Friday</th>
										<th>Saturday</th>
										<th>Sunday</th>
									</tr>
								</thead>


								
  					<form  id="updateForm" method="post" >
								<tbody style="padding: 12px;">
									<tr>
										<td><span class="time">上午</span></td>
									<%
											
											//循环遍历集合，每循环一次，生成一行html<tr></tr>，在每一个单元格中 <td></td>,把静态数据改成数据库表中的记录
											
													for (int i=1;i<=7;i++){
														%>
														<td>
														<% 
														schedules1 = iis.find(i, "上午",selectedUnitId);
														
														for(Schedule schedule1:schedules1){
															String selectName = "updateDoctorM"+ String.valueOf(i)+String.valueOf(schedule1.getId());
															%>
													<div style="margin-bottom:5px;">
														<select name="<%=selectName %>" id="<%=selectName %>" class="form-control" style="width: 80%;">
															<%
															
															for(Doctor doctor1 : doctors){
															%>
																<option value=<%=doctor1.getId() %><%if(doctor1.getId()==schedule1.getDoctor().getId()){ out.print("selected='selected'");} %>>
																	<%=doctor1.getName() %>
																</option>
															<%}%>
														</select>
														   <button type="button" class="btn btn-outline-secondary"   
                                                            		onclick="edit(<%=schedule1.getId() %>,'<%=selectName %>')">
                                                           			 <i class="icofont-edit text-success"></i>
                                                         	</button>
															<span style="align-content: center;"><%=schedule1.getDoctor().getTel() %></span>
								                            <div class="col-auto d-flex" >
								                             
								                            </div>
						                           		</div>		
							                           													
														<% } %>

													</td>
												<% } %>
										</tr>				

									<tr>
										<td><span class="time">下午</span></td>
									<%
											
											//循环遍历集合，每循环一次，生成一行html<tr></tr>，在每一个单元格中 <td></td>,把静态数据改成数据库表中的记录
											
													for (int i=1;i<=7;i++){
														%>
														<td>
														<% 
														schedules2 = iis.find(i, "下午",selectedUnitId);
														for(Schedule schedule2:schedules2){
															String selectName = "updateDoctorA"+ String.valueOf(i)+String.valueOf(schedule2.getId());
															%>
													<div style="margin-bottom:5px;">
														<select name="<%=selectName %>" id="<%=selectName %>" class="form-control" style="width: 80%;">
															<%
															
															for(Doctor doctor2 : doctors){
															%>
																<option value=<%=doctor2.getId() %> <%if(doctor2.getId()==schedule2.getDoctor().getId()){ out.print("selected='selected'");} %>>
																	<%=doctor2.getName() %>
																</option>
															<%}%>
														</select>
														 <button type="button" class="btn btn-outline-secondary"   
	                                                  		onclick="edit(<%=schedule2.getId() %>,'<%=selectName %>')">
	                                                 		<i class="icofont-edit text-success"></i>
                                               			</button>
																<span style="align-content: center;"><%=schedule2.getDoctor().getTel() %></span>
									                            <div class="col-auto d-flex" >
									                        
									                               
                                                         			
									                            </div>
							                           		</div>		
							                           													
														<% } %>

													</td>
												<% } %>
										</tr>
								</tbody>
								</form>
								</table>
							</table>
						</div>
					</div>
                </div>
            </div>
        </section>
        <!-- End Doctor Calendar Area -->


            </div>
        </div>

<%
//String addUrl = Data.URL+"/schedule?OP=add&unitId="+selectedUnitId;
String addUrl = Data.URL+"/schedule?OP=add";
%>
<!-- 点击添加“排班按钮”后 跳转到这 -->
        <!-- Add Event-->
        <div class="modal fade" id="addevent" tabindex="-1" aria-hidden="true">
	        <form  id="addForm" method="post" action=<%=addUrl %>>
	           	 <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <h5 class="modal-title  fw-bold" id="eventaddLabel">添加排班</h5>
		                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		                </div>
		             
		                <div class="modal-body">
		                    <div class="mb-3">
		                        <label for="exampleFormControlInput99" class="form-label">值班医生</label>
		                        	<div> 
	                					<select name="addDoctor" id="addDoctor" class="form-control" style="width: 30%;">
											<%
											for(Doctor doctor3 : doctors){
											%>
												<option value=<%=doctor3.getId() %>><%=doctor3.getName() %></option>
											<%}%>
										</select>
		           					 </div>
		                    </div>
		                    <div class="deadline-form">
		                            <div class="row g-3 mb-3">
		                              <div class="col">
		                                <label for="updatepickerded" class="form-label">值班周天</label>
		                                 <div> 
		                					<select name="addWeek" id="addWeek" class="form-control" style="width: 30%;">
					                            <option value="1">周一</option>
					                            <option value="2">周二</option>
					                            <option value="3">周三</option>
					                            <option value="4">周四</option>
					                            <option value="5">周五</option>
					                            <option value="6">周六</option>
					                            <option value="7">周日</option>
		                        			</select>
		           						 </div>
		                                
		                                
		                                
		                              </div>
		                               <div class="col">
		                                <label for="datepickerdedone" class="form-label">值班时段</label>
		                                  <div> 
		                					<select name="addPeriod" id="addperiod" class="form-control" style="width: 30%;">
					                            <option >上午</option>
					                            <option >下午</option>
		                        			</select>
		           					 	</div>
		                              </div>
		                              
		                          <div class="col">
	                                <label for="datepickerded" class="form-label">值班开始日期</label>
	                                <input name="addTime" id="addTime" type="date" class="form-control" id="datepickerded">
	                              </div>
	                              
		                            </div>   
		                            
		                  	  </div>	
		                  	  
			                    <div class="mb-3">
			                        <label for="exampleFormControlTextarea78" class="form-label">内容描述（可省略）</label>
			                        <textarea class="form-control" id="exampleFormControlTextarea78" rows="3" placeholder="Add any extra details about the request"></textarea>
			                    </div>
			                </div>
		                <!-- 按钮 -->
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
                            <input type="button" class="btn btn-primary" onclick="tjAdd()" value="添加"/>
		                </div>
		            </div>
	           	</form>
            	
            </div>


 <script>
        // project data table
       // $("#depedit").modal("hide");
       //第一种 无用
        function Values(ID){//在按钮中定义的点击事件函数Values,传入ID
          //  alert(ID);
			$("#id").val(ID); //接收传入的ID值,发送给id为id的标签
			
            }
		//第二种

        function edit(id,selectName){
        	
        	
        	console.log("<%=Data.URL%>/schedule?OP=update&updateId="+id+"&selectName="+selectName);
        	document.getElementById("updateForm").action="<%=Data.URL%>/schedule?OP=update&updateId="+id+"&selectName="+selectName;
        	
        	window.document.getElementById("updateForm").submit();
        	alert("修改成功");
        	
        }
        
        
        function remove(url){//在按钮中定义的点击事件函数remove

        	//console.log(url);//测试
          	window.location.href=url;//跳转
  			
              }

    	function tjAdd() {
    		//根据id获取html页面中的表单，并提交
    		window.document.getElementById("addForm").submit();
    	}

    	function tjUpdate() {
    		//根据id获取html页面中的表单，并提交
    		window.document.getElementById("updateForm").submit();
    	}
</script>

<!-- Jquery Core Js -->
<script src="<%=Data.URL%>/Manage/static/js/libscripts.bundle.js"></script>

<!-- Plugin Js-->
<script src="<%=Data.URL%>/Manage/static/js/main.min.js"></script>

<!-- Jquery Page Js -->
<script src="<%=Data.URL%>/Manage/static/js/template.js"></script>



</body>
</html>