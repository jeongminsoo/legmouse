package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;
import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;

@Controller
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(params = "method=list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Model model) {
		Paging paging = new Paging(bookService.countBook(), pageNum, 3, 5);
		model.addAttribute("paging", paging);
		model.addAttribute("books", bookService.listTitle(pageNum));
		return "book/list";
	}
	
	@RequestMapping(params = "method=addForm", method = RequestMethod.GET)
	public String addForm() {
		return "book/add";
	}
	
	@RequestMapping(params = "method=add", method = RequestMethod.POST)
	public String add(Book book, MultipartHttpServletRequest mr, Model model) {
		model.addAttribute("addResult", bookService.add(mr, book));
		return "forward:book.do?method=list";
	}
	
	@RequestMapping(params = "method=detail", method = {RequestMethod.GET, RequestMethod.POST})
	public String detail(String pageNum, int bno, Model model) {
		model.addAttribute("book", bookService.contentBook(bno));
		return "book/detail";
	}
	
	@RequestMapping(params = "method=updateForm", method = RequestMethod.GET)
	public String updateForm(String pageNum, int bno, Model model) {
		model.addAttribute("book", bookService.contentBook(bno));
		return "book/update";
	}
	
	@RequestMapping(params = "method=update", method = RequestMethod.POST)
	public String update(String pageNum, Book book, MultipartHttpServletRequest mr, Model model) {
		model.addAttribute("updateResult", bookService.update(mr, book));
		return "redirect:book.do?method=detail&pageNum=" + pageNum + "&bno=" + book.getBno();
	}
}
