package com.hutsdev.spring6webapp.repositories;

import com.hutsdev.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
