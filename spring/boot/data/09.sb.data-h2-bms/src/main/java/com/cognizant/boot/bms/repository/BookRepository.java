package com.cognizant.boot.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.boot.bms.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	//List<Book> findByOrderByTitleAsc();

}
