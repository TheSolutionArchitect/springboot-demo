package com.awstechguide.cms.springjpah2.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.awstechguide.cms.springjpah2.entity.User;

public interface UserService {

	User joinUser(User user);
	ResponseEntity<Object> addUser(User user);
	ResponseEntity<Object> deleteUser(Long id);
	Optional<User> findUserByUserName(String userName);
	User findUserByEmail(String email);
	ResponseEntity<Object> saveUser(User user);

}
