package com.bookrestapi.bookrestapi.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bookrestapi.bookrestapi.entities.Books;




public interface BookService {
	public List<Books> getBooks();
	
	public Books getBook(String bookId);
	
	public Books addBook(Books book);
	
	public void deleteBook(String bookId);
	
	public ResponseEntity<Object> updateBook(Books bk,String bookId);
}
