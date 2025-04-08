package com.hutsdev.spring6webapp.services;

import com.hutsdev.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
