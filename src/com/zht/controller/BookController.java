package com.zht.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.zht.entity.Book;
import com.zht.util.mybatis.M;

public class BookController {
	@Autowired
	private M m;
	public String queryAll(){
		m.getMapper(Book.Mapper.class).queryAll();
		return null;
	}
}
