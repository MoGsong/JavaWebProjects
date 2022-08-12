<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">
    <title>信息管理</title>
     <link href="css/style.css?v=2.2.0" rel="stylesheet">
     
</head>
<body style="background-color: white">
		<div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>信息管理</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-user">
                                        <li><a href="table_data_tables.html#">选项1</a>
                                        </li>
                                        <li><a href="table_data_tables.html#">选项2</a>
                                        </li>
                                    </ul>
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content" >
                                <div class=""  >
                                    <a onclick="fnClickAddRow();" href="javascript:void(0);" class="btn btn-primary ">添加行</a>
                                </div></br>
                                
                                <table>
                                <table border="0">
                                <tr>
                               <td style="align:right"> 每页</td>
                               <td style="width:40%"><select name="editable_length" aria-controls="editable" class="form-control input-sm"  style="width:100px;margin: 0 auto">
                             				   <option value="10"  >10</option><option value="25">20</option><option value="50">50</option></select></td> 
                               <td style="margin:60%;">条记录</br></td>
                               </tr></table>
                                
                                <table border="0">
                                <tr>
                                <td id="editable_filter" class="dataTables_filter"> 查找：</td>
                                <td><input type="search" class="form-control input-sm" aria-controls="editable"  style="width:100px;margin: 0 auto"> </td>
                                </tr></table>
                                </table>
                                </br>
                                
                                <table class="table table-striped table-bordered table-hover  dataTable" id="editable" aria-describedby="editable_info"  width="100%">
                                    <thead>
                                        <tr role="row">
                                          </thead>
                                    <tbody>
                                        		<tr class="gradeA even">
                                            <td class="sorting_1">编号</td>
                                            <td class=" ">类型</td>
                                            <td class=" ">内容</td>
                                            <td class="center ">图片</td>
                                            <td class="center ">时间</td>
                                            <td class="center ">基本操作</td>
                                       </tr></tbody>
                                    </thead>
                                    <tbody>
                                        
											<tr class="gradeA even">
                                            <td class="sorting_1">1</td>
                                            <td class=" "></td>
                                            <td class=" "></td>
                                            <td class="center "></td>
                                            <td class="center "></td>
                                              <td class="center ">编辑  &nbsp;&nbsp;&nbsp;&nbsp;删除</td>
                                        </tr></tbody>
                                   
                                </table>
                                
                                
                               <table style="width:100%" border="0">
                                <tr><td class="dataTables_info" id="editable_info" role="alert" aria-live="polite" aria-relevant="all">显示 1 到 10 项，共 ? 项 </td>
                                <td ><div style="width:60%; margin:0 auto;align:right">
                               <table border="1" class="t" id="editable" aria-describedby="editable_info"  style="width:60%;align:right">
                                <tr class="gradeA even">
                               		<td class="sorting_1">首页</td>
                                    <td class=" ">上一页 </td>
                                    <td class=" ">下一页</td>
                                    <td class="center ">尾页</td>
                             	 </tr>
                               </table></div></td>
						</table>
                        
                    </div>
</body>
</html>