package com.BookStore.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.model.Book;
import com.BookStore.service.BookService;

@RestController
@RequestMapping("/lms")
public class BookRestController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> allBooks(){
		return bookService.allBooks();
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id")int id){
		return bookService.getBook(id);
	}
	
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		return bookService.save(book);
	}
	
	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {
		return bookService.save(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public HashMap<String, String> deleteBook(@PathVariable("id")int id){
		HashMap<String, String> data = new HashMap<>();
		if(bookService.getBook(id).getId()==0) {
			data.put("msg", "Invalid id");
		
		}else {
			bookService.deleteBook(id);
			data.put("msg", "Book Deleted");
		}
		return data;
	}
}
