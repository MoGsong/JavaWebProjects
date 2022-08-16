package com.gxnu.excel;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;


//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * Servlet implementation class ExcelProcess
 */
@WebServlet("/excel")
@MultipartConfig
public class ExcelProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcelProcess() {
        super();
        // TODO Auto-generated constructor stub
    }
    //返回生成文件的名称列表

	protected void generate(File file,String sheetName,File template) throws IOException {
    	    String  fileName = file.getAbsolutePath();
    	    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
    	    System.out.println(fileName);
    	    String type = fileName.substring(fileName.lastIndexOf("."));
    	    //文件类型
    	    System.out.println(type);
    	  //读取项目文件信息作为输入流
            InputStream is = null;
             is = new FileInputStream(file);        
             //根据文件类型创建excel表     		 
//            HashMap<String,Double> pros = new HashMap<>();//存放数据 
            //存放项目名
            //List<String>  names = new ArrayList<>();           
     		String name = "";
     		//年初预算
     		Double firstPre = 0.0;
     		//预算指标
     		Double preStandard = 0.0;
     		//实际支出
     		Double realPay = 0.0;
             if (".xls".equals(type)) {
            	 HSSFWorkbook  xls = new HSSFWorkbook(is);
            	 //获取工作区
            	 HSSFSheet sheet = null;
            	 if(sheetName!=null) {
            		 sheet = xls.getSheet(sheetName); 
            	 }else {
            		 sheet = xls.getSheetAt(0); 
            	 }
            	 //获取第1行            	 
            	 int firstRowNum = sheet.getFirstRowNum();
            	 
                 //获取最后一行
                 int lastRowNum = sheet.getLastRowNum();
                 //项目列表索引
            	  //模板是在第二行开始读取
            	  for (int i = firstRowNum+1; i < lastRowNum; i++) {
            	    //获取当前行
            	    Row row = sheet.getRow(i);
            	    if (row != null) {
            	      //开始对cell进行处理。
            	    	//项目名
            	    	Cell  nameCell= row.getCell(1);
            	    	Cell  firstPreCell= row.getCell(2);
            	    	Cell  preStandardCell= row.getCell(3);
            	    	Cell  realPayCell= row.getCell(4);
            	    	//存储值 用list和map
            	    	name = nameCell.getStringCellValue();  
            	    	firstPre = firstPreCell.getNumericCellValue(); 
            	    	preStandard = preStandardCell.getNumericCellValue();
            	    	realPay = realPayCell.getNumericCellValue();
            	    	System.out.println("项目信息["+"name:"+name+" firstPre:"+firstPre+" preStandard:"+preStandard +" realPay:"+realPay+"]");
            	    	//names.add(name);
//            	    	pros.put("firstPre", firstPre);
//            	    	pros.put("preStandard", preStandard);
//            	    	pros.put("realPay", realPay);           	    	
            	    }
            	    //模板文件作为输入流然后将项目信息存储在模板工作簿中 .xlsx -> XSSFWorkbook           	    
            	    FileInputStream fileInputStream=new FileInputStream(template);
            	    //用XSSF读取模板内容
            	    XSSFWorkbook genxlsx = new XSSFWorkbook(fileInputStream);
            	    XSSFSheet xsheet = genxlsx.getSheetAt(0);
            	    //项目名行   
            	    Row pname =  xsheet.getRow(1);
            	    //项目名不为空
            	    if(pname!=null) {
            	    	//项目名
            	    	 pname.getCell(1).setCellValue(name);
                 	    //数据行
                 	    Row data =  xsheet.getRow(5);                	    
                 	    //数据单元赋值
                 	    data.getCell(2).setCellValue(firstPre);
                 	    data.getCell(3).setCellValue(preStandard);
                 	    data.getCell(4).setCellValue(realPay);
                 	    //生成时间
                 	    long d =  System.currentTimeMillis();
                 	    String time = new SimpleDateFormat("yyyy-MM-dd").format(d);
             	    	//生成文件夹下新建文件
                 	    FileOutputStream output = 
                 	    		new  FileOutputStream("D:\\eclipse\\spring eclipse\\sts-4.2.2.RELEASE\\MyWebprj\\excelpro\\WebContent\\generateExcel\\"+name+time+".xlsx");
                 	    //将设置好的文件写入生成的文件中
                 	    //模板工作簿关闭
                 	    genxlsx.write(output);
                 	    //
                 	    //刷新
                	    output.flush();
                	    //输出流关闭
                	    output.close();
            	    }
            	   
               	    //模板输入流关闭
               	    fileInputStream.close();
               	    //工作簿关闭
               	    genxlsx.close();
               	    //输入文件关闭           	    
            	  }
            	  //生成完毕，关闭文件
            	  xls.close();           	 
            	  is.close();

             } else if (".xlsx".equals(type)) {
//            	 XSSFWorkbook xlsx = new XSSFWorkbook(is);
//            	 XSSFSheet sheet = null;
            	 HSSFWorkbook  xlsx = new HSSFWorkbook(is);
            	 //获取工作区
            	 HSSFSheet sheet = null;
            	 if(sheetName!=null) {
            		 sheet = xlsx.getSheet(sheetName); 
            	 }else {
            		 sheet = xlsx.getSheetAt(0); 
            	 }
            	 //获取第1行
            	 int firstRowNum=sheet.getFirstRowNum();
                 //获取最后一行
                 int lastRowNum = sheet.getLastRowNum();
                 //项目列表索引
            	  //模板是在第二行开始读取
            	  for (int i = firstRowNum+1; i < lastRowNum; i++) {
            	    //获取当前行
            	    Row row = sheet.getRow(i);
            	    if (row != null) {
            	      //开始对cell进行处理。
            	    	//项目名
            	    	Cell  nameCell= row.getCell(1);
            	    	Cell  firstPreCell= row.getCell(2);
            	    	Cell  preStandardCell= row.getCell(3);
            	    	Cell  realPayCell= row.getCell(4);
            	    	//存储值 用list和map
            	    	name = nameCell.getStringCellValue();  
            	    	firstPre = firstPreCell.getNumericCellValue(); 
            	    	preStandard = preStandardCell.getNumericCellValue();
            	    	realPay = realPayCell.getNumericCellValue();
            	    	//names.add(name);
//            	    	pros.put("firstPre", firstPre);
//            	    	pros.put("preStandard", preStandard);
//            	    	pros.put("realPay", realPay);           	    	
            	    }
            	    //按项目名生成对应模板文件
            	    FileInputStream fileInputStream=new FileInputStream(template);
            	    //用XSSF读取模板内容
            	    XSSFWorkbook genxlsx = new XSSFWorkbook(fileInputStream);
            	    XSSFSheet xsheet = genxlsx.getSheetAt(0);
            	    //项目名行
            	    Row pname =  xsheet.getRow(1);
            	    if(pname!=null) {
            	    	 pname.getCell(1).setCellValue(name);
                  	    //数据行
                  	    Row data =  xsheet.getRow(5);                	    
                  	    //数据单元赋值
                  	    data.getCell(2).setCellValue(firstPre);
                  	    data.getCell(3).setCellValue(preStandard);
                  	    data.getCell(4).setCellValue(realPay);
                  	    //生成时间
                  	    long d =  System.currentTimeMillis();
                  	    String time = new SimpleDateFormat("yyyy-MM-dd").format(d);
              	    	//生成文件夹下新建文件
                  	    FileOutputStream output = 
                  	    		new  FileOutputStream("D:\\eclipse\\spring eclipse\\sts-4.2.2.RELEASE\\MyWebprj\\excelpro\\WebContent\\generateExcel\\"+name+time+".xlsx");
                 	    //将设置好的文件写入生成的文件中
                 	    //模板工作簿关闭
                 	    genxlsx.write(output);
                 	    //刷新
                	    output.flush();
                	    //输出流关闭
                	    output.close();
            	    }           	   
               	    //模板输入流关闭
               	    fileInputStream.close();
               	    //工作簿关闭
               	    genxlsx.close();
               	    //输入文件关闭           	    
            	  }
            	  //生成完毕，关闭文件
            	  xlsx.close();           	 
            	  is.close();
             } else {
                 System.out.println("该文件不是excel文件");
             }   
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//统一编码格式防止乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取参数
		//上传项目表
		String ProExcel = request.getParameter("proFile");
		//指定项目表名
//		String ProName = request.getParameter("ProName");
		//项目工作区名
		String ProSheet = request.getParameter("ProSheet");	
		/*
		 * //模板工作区名 String TempCell = request.getParameter("TempCell"); //指定模板标志参数
		 * String TempExcel = request.getParameter("temFile");
		 */
		System.out.println( ProSheet+ ProExcel);
		
		//有项目文件上传
		if(ProExcel!=null) {
//				if(ProSheet==null) {
//					
//				}
				//项目文件上传
				Part p =request.getPart("file1");	
				if(p==null) {return;}
				String msg = p.getHeader("Content-Disposition");
				//截取上传文件名
				String fileName = msg.substring(msg.lastIndexOf("=")+2,msg.length()-1);
				if(fileName==""||fileName==null) {
					 response.getWriter().write("<script>window.alert(\"上传文件为空\");"+"window.location.href=\"index.jsp\";</script>");
				}
				//fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
				System.out.println(fileName);
				//把上传的文件另存到磁盘上的某个位置
				//项目文件夹下新建一个项目文件来读取
				try {
					File file = new File("D:\\eclipse\\spring eclipse\\sts-4.2.2.RELEASE\\MyWebprj\\excelpro\\WebContent\\processExcel\\"+fileName);
					//判断是否成功下载上传的文件
					if(file.createNewFile()) {
						System.out.println("项目文件创建成功");
					}
					//把上传得文件内容写入新创建或覆盖已存在的目录文件中
					p.write("D:\\eclipse\\spring eclipse\\sts-4.2.2.RELEASE\\MyWebprj\\excelpro\\WebContent\\processExcel\\"+fileName);
					System.out.println("项目文件已写入服务器目录");	
					//启用模板
					File template = new File("D:\\eclipse\\spring eclipse\\sts-4.2.2.RELEASE\\MyWebprj\\excelpro\\WebContent\\templateExcel\\template.xlsx");
					if(file.createNewFile()) {
						System.out.println("模板文件创建成功");
					}
					//获取工作区名
					String sheetName = ProSheet;
					//开始生成
					 generate(file, sheetName, template);
					 
					//发回生成文件
					String realPath = "D:\\eclipse\\spring eclipse\\sts-4.2.2.RELEASE\\MyWebprj\\excelpro\\WebContent\\generateExcel\\";	
					File file1 = new File(realPath);
					File[] list = file1.listFiles();
					for (File f : list) {
						String name = f.getName();
						// 对内容使用url编码 编码之后的内容ie可以解析
						String encodeName = URLEncoder.encode(name, "utf-8");
						System.out.println(name);
						response.getWriter().write("<a href='http://192.168.1.167:8080/excelpro/generateExcel/" + encodeName + "'>" + name + "</a><br/>");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {

				}

		} /*
			 * else if(ProName!=null && ProExcel!=null){ //项目文件上传 Part p
			 * =request.getPart("file1"); if(p==null) {return;} String msg =
			 * p.getHeader("Content-Disposition"); //截取上传文件名 String fileName =
			 * msg.substring(msg.lastIndexOf("=")+2,msg.length()-1); //fileName =
			 * fileName.substring(fileName.lastIndexOf("\\")+1);
			 * System.out.println(fileName); //把上传的文件另存到磁盘上的某个位置 //项目文件夹下新建一个项目文件来读取 try {
			 * File file = new
			 * File("D:\\eclipse\\spring eclipse\\sts-4.2.2.RELEASE\\MyWebprj\\excelpro\\WebContent\\processExcel\\"
			 * +fileName); //判断是否成功下载上传的文件 if(file.createNewFile()) {
			 * System.out.println("项目文件创建成功"); } //把上传得文件内容写入新创建或覆盖已存在的目录文件中 p.
			 * write("D:\\eclipse\\spring eclipse\\sts-4.2.2.RELEASE\\MyWebprj\\excelpro\\WebContent\\processExcel\\"
			 * +fileName); System.out.println("项目文件已写入服务器目录"); //启用模板 File template = new
			 * File("D:\\eclipse\\spring eclipse\\sts-4.2.2.RELEASE\\MyWebprj\\excelpro\\WebContent\\templateExcel\\template.xlsx"
			 * ); if(file.createNewFile()) { System.out.println("模板文件创建成功"); } //获取工作区名
			 * String sheetName = ProSheet; //开始生成 generate(fileName, sheetName, template);
			 * 
			 * //发回生成文件 String realPath =
			 * "D:\\eclipse\\spring eclipse\\sts-4.2.2.RELEASE\\MyWebprj\\excelpro\\WebContent\\generateExcel\\"
			 * ; File file1 = new File(realPath); File[] list = file1.listFiles(); for (File
			 * f : list) { String name = f.getName(); // 对内容使用url编码 编码之后的内容ie可以解析 String
			 * encodeName = URLEncoder.encode(name, "utf-8"); System.out.println(name);
			 * response.getWriter().
			 * write("<a href='http://192.168.1.167:8080/excelpro/generateExcel/" +
			 * encodeName + "'>" + name + "</a><br/>"); } } catch (Exception e) {
			 * e.printStackTrace(); } }
			 */else {
			//没有要生成的excel项目文件
			 response.getWriter().write("<script>window.alert(\"未选择上传文件\");"+"window.location.href=\"index.jsp\";</script>");
		 }
		
	
	}
		
}

