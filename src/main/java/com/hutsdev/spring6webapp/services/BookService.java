package com.hutsdev.spring6webapp.services;

import com.hutsdev.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
