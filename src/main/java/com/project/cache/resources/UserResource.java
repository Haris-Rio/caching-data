package com.project.cache.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cache.cache.UsersCache;
import com.project.cache.model.Users;

@RestController
@RequestMapping(value = "/rest/users")
public class UserResource {
	
	@Autowired
	UsersCache usersCache;
	
	@GetMapping(value = "/{name}")
	public Users getUser(@PathVariable final String name) {
		return usersCache.getUser(name);
	}
}
