package com.hutsdev.spring6webapp.repositories;

import com.hutsdev.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
