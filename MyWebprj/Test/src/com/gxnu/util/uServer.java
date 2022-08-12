package com.gxnu.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Properties;
public class uServer extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		new uServer();	
	}
	// 说明：一个类需要页面的显示，则那个类要继承JFrame。
	// 属性
	// 文本域
	private JTextArea jta;
	// 滚动条
	private JScrollPane jsp;
	// 面板里面是文本框和按钮
	private JPanel jp;
	private JTextField jtf;
	private JButton jb ;

	BufferedWriter bw  = null;
	private static int serverPort;
	static {
		Properties pro =new Properties();
		try {
			pro.load(new FileReader("chat.properties"));
			serverPort = Integer.parseInt(pro.getProperty("serverPort"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 构造器
	public uServer(){
		
		// 初始化上面的属性
		jta = new JTextArea();
		
		// 将文本域添加到滚动条中
		jsp = new JScrollPane(jta);
		jp = new JPanel();
		jtf =new JTextField(15);
		jb = new JButton("发送");

		// 把按钮和文本框添加到面板中
        jp.add(jtf);
		jp.add(jb);

		// 把滚动条和面板添加到JFrame中去
		this.add(jsp,BorderLayout.CENTER); //这个设置在中间
		this.add(jp,BorderLayout.SOUTH); //南

		this.setTitle(" 服务端");
		this.setSize(500,500);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

		/***********TCP协议*************/
		jb.addActionListener(this);  // 这是按钮点击使用
		// 回车键的监听事件 在接口KeyListener中
        //jtf.addKeyListener(this);


        jtf.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
		     if((char)e.getKeyChar()==KeyEvent.VK_ENTER) {
				 useVoid();
		     }
	       }
        });

		try{
		// 1.创建一个服务端的套接字
		//ServerSocket serverSocket = new ServerSocket(serverPort);
			ServerSocket serverSocket = new ServerSocket(8888);
		//2.等待客户端的连接
		Socket socket = serverSocket.accept();

		// 3.获取socket通道的输入流(输入流的读取方式为一行一行的读取方式 ----> readLine())
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		// 4.获取通道的输入流(也是一行一行的写出  BufferedWriter ->newLine())
        // 当用户点击“发送”按钮的时候才会，写出数据
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		String line = null;
		while((line = br.readLine()) !=null){
			// 将读取的数据拼接到文本域中显示
			jta.append(line + "\n");
		}

		
		// 5.关闭socket通道
		serverSocket.close();
        
		}catch(IOException e){
			e.printStackTrace();
		}

		/************************/


	}
	// 点击按钮所实现的方法
	public void actionPerformed(ActionEvent e){
		useVoid();
	}

	public void useVoid(){
		// 1.获取文本框中的内容
		String text = jtf.getText();
		text = "服务端对客户端说：" + text;
		// 自己显示
		jta.append(text + "\n");
		// 2.发送
		try{
			// 4.发送
			bw.write(text);
			bw.newLine(); // 换行 
			bw.flush();  // 刷新
			// 5.清空文本框
			jtf.setText("");
		}catch (IOException e1){
			e1.printStackTrace();
		}
	}

    
	/*public void KeyPressed(KeyEvent e){
		//回车键
		System.out.println("按钮数字");
	}
	
	public void KeyTyped(KeyEvent e){
	}
    
	public void KeyReleased(KeyEvent e){
	}*/
	//行为
}

