package com.example.testrestapplication.dao;

import com.example.testrestapplication.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findById(Long id);
}
