package com.hutsdev.spring6webapp.repositories;

import com.hutsdev.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {



}
