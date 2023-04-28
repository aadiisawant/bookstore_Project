package com.BookStore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BookStore.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
	
	//List<Book> getBookByTitle(String title);
	
	List<Book> getBookByTitleContains(String title);
}
