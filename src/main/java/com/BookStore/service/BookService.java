package com.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.model.Book;
import com.BookStore.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	BookRepo bookRepo;
	
	public Book save(Book book) {
		return bookRepo.save(book);
	}
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public Book getBook(int id) {
		return bookRepo.findById(id).orElse(new Book());
	}
	
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}
	
	public List<Book> searchBook(String title){
	    return	bookRepo.getBookByTitleContains(title);	
	}
}
