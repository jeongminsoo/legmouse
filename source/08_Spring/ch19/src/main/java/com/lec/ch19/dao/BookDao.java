package com.lec.ch19.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch19.dto.Book;

@Mapper
public interface BookDao {
	
	public List<Book> listNewest();
	
	public List<Book> listTitle(Book book);
	
	public Book contentBook(int bno);
	
	public int add(Book book);
	
	public int update(Book book);
	
	public int countBook();
}
