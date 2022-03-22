package com.bookrestapi.bookrestapi.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookrestapi.bookrestapi.dao.BookDao;
import com.bookrestapi.bookrestapi.entities.Books;



@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookdao;

	
	public BookServiceImpl() {

	}
	@Override
	public List<Books> getBooks() {
		return bookdao.findAll();
	}
	
	
	
	public Books getBook(String bookId) {
		List<Books> books = bookdao.findAll();
		for(Books b: books) {
			if(b.getId().equals(bookId)) {
				return b;
			}
		}
		return null;
	}
	public Books addBook(Books bo) {
		bookdao.save(bo);
		return bo;
	}
	
	public void deleteBook(String bookId) {
		Books entity = bookdao.getById(bookId);
		bookdao.delete(entity);
	}
	
	public ResponseEntity<Object> updateBook(Books bk,String bookId) {
		Optional<Books> studentOptional = bookdao.findById(bookId);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		bk.setId(bookId);
		
		bookdao.save(bk);

		return ResponseEntity.noContent().build();

	}
	

}
