package com.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import  com.bookstore.domain.User;
import java.util.*;

/**
 * Created by DG on 6/25/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);



}
