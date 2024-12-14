package com.example.user.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.user.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
