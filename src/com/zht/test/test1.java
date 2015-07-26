package com.zht.test;

import java.util.List;

import org.junit.Test;

import com.zht.entity.Book;
import com.zht.util.mybatis.M;

public class test1 {
	@Test
	public void queryall(){
		M m=new M();
		List<Book> booklist=m.getMapper(Book.Mapper.class).queryAll();
		for (Book book : booklist) {
			System.out.println(book.getTitle());
		}
	}
}
