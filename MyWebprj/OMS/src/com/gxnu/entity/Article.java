package com.gxnu.entity;


import java.io.Serializable;
import java.sql.Timestamp;




public class Article implements Serializable{
    
	//属性：标题，内容，图片，作者，时间，预留
	
	
	private int id;
	private String title;
	private String content;
	private String pic;
	private String author;
	private Timestamp time;

	
	
		
		//get/set方法
		
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public Timestamp getTime() {
			return time;
		}
		public void setTime(Timestamp time) {
			this.time = time;
		}
		
		
		
		
		
		//构造方法
		public Article(int id, String title, String content, String pic, String author, Timestamp time) {
			super();
			this.id = id;
			this.title = title;
			this.content = content;
			this.pic = pic;
			this.author = author;
			this.time = time;
			
		}
		
		public Article(String title, String content, String pic, String author, Timestamp time) {
			super();
			this.title = title;
			this.content = content;
			this.pic = pic;
			this.author = author;
			this.time = time;
			
		}
		public Article() {
			super();
			
		}
		
		@Override
		public String toString() {
			return "Article [id=" + id + ", title=" + title + ", content=" + content + ", pic=" + pic + ", author="
					+ author + ", time=" + time + "]";
		}
		
	
}
