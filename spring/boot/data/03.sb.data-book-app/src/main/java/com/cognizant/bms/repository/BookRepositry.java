package com.cognizant.bms.repository;

import java.awt.print.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositry extends CrudRepository<Book, Long> {

}
