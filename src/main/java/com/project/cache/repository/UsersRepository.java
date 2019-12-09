package com.project.cache.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.cache.model.Users;

public interface UsersRepository extends MongoRepository<Users, Long> {
	Users findByName(String name);

}
