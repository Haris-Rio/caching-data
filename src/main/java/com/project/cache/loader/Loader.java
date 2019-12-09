package com.project.cache.loader;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.cache.model.Users;
import com.project.cache.repository.UsersRepository;

@Component
public class Loader {
	
	@Autowired
	UsersRepository userRepository;
	
	@PostConstruct
	public void load() {
		List<Users> usersList = getList();
		userRepository.saveAll(usersList);
	}
	
	public List<Users> getList(){
		List<Users> usersList = new ArrayList<>();
		usersList.add(new Users(10001L,"Rio","Art", 45000L));
		usersList.add(new Users(10002L,"Rin","Commerce", 40000L));
		usersList.add(new Users(10003L,"Haris","Physics", 42000L));
		return usersList;
	}
}
