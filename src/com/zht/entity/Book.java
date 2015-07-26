package com.zht.entity;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public class Book {
	private int id;
	private String title;
	private String author;
	private float price;
	private String pubdate;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public Book(int id, String title, String author, float price, String pubdate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.pubdate = pubdate;
	}
	public Book() {
		super();
	}
	public interface Mapper{
		@Select("SELECT * FROM book")
		public List<Book> queryAll();
		
		@Insert("insert into book value('','','','')")
		public void insert(Book book);
	}
}
