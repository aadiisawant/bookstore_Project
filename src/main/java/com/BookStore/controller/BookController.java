package com.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BookStore.model.Book;
import com.BookStore.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("email","bookstore@gmail.com");
		model.addAttribute("mobile", "+91 9999888811");
		return "about";
	}
	
	@GetMapping("/add")
	public String addForm() {
		return "add_book";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book book,Model model) {
		if(bookService.save(book)!=null) {
			model.addAttribute("msg","one book added");
		}else {
			model.addAttribute("msg","ERROR!!!");
		}
		return "add_book";
	}
	@GetMapping("/display")
	public String allBooks(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books",books);
		return "display";
	}
	
	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable("id")int id, Model model) {
		model.addAttribute("book", bookService.getBook(id));
		return "update-book";
	}
	
	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute Book book) {
		bookService.save(book);
		return "redirect:/display";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		bookService.deleteBook(id);
		return "redirect:/display";
	}
	
	@PostMapping("/search")
	public String searchBook(@RequestParam("key") String key,Model model) {
		model.addAttribute("books", bookService.searchBook(key));
		return "display";
	}
	
	//Project Added to git
}
