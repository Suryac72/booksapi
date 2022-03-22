package com.bookrestapi.bookrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookrestapi.bookrestapi.entities.Books;
import com.bookrestapi.bookrestapi.services.BookService;

@RestController
//Representational State Transfer Controller

public class MyController {

	@Autowired
	private BookService bookservice;

	@GetMapping("/home")
	public String home() {
		return "this is Home Page";
	}

	// get the books
	@GetMapping("/books")
	public List<Books> getBooks() {
		return this.bookservice.getBooks();
	}

	@GetMapping("/books/{bookId}")
	public Books getBook(@PathVariable String bookId) {
		return this.bookservice.getBook(bookId);
	}

	@PostMapping(path = "/books", consumes = "application/json")
	public Books addBook(@RequestBody Books bk) {
		

		try {
			return this.bookservice.addBook(bk);
		} catch (Exception e) {
			return null;
		}
	}

	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable String bookId) {
		try {
			this.bookservice.deleteBook(bookId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/books/{bookId}")
	public void updateBook(@RequestBody Books bk, @PathVariable("bookId") String bookId) {
		try {
			this.bookservice.updateBook(bk,bookId);
		} catch (Exception e) {
			ResponseEntity<HttpStatus> res = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			System.out.println(res);
		}
	}
}
