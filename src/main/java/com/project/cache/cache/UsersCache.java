package com.project.cache.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.project.cache.model.Users;
import com.project.cache.repository.UsersRepository;

@Component
public class UsersCache {
	
	@Autowired
	UsersRepository usersRepository;
	
	@Cacheable(value = "usersCache" , key = "#name")
	public Users getUser(String name) {
		System.out.println("Retrieving from DB "+ name);
		return usersRepository.findByName(name);
	}
}
