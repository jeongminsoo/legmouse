package com.lec.ch19.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;

public interface BookService {

	public List<Book> listNewest();
	
	public List<Book> listTitle(String pageNum);
	
	public Book contentBook(int bno);
	
	public int add(MultipartHttpServletRequest mr, Book book);
	
	public int update(MultipartHttpServletRequest mr, Book book);
	
	public int countBook();
}
