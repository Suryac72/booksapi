package com.bookrestapi.bookrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bookrestapi.bookrestapi.entities.Books;

public interface BookDao extends JpaRepository<Books,String>{
	
}
