package com.awstechguide.cms.springjpah2.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.awstechguide.cms.springjpah2.dto.UserProfile;
import com.awstechguide.cms.springjpah2.entity.User;

public interface UserService {

	User joinUser(User user);
	ResponseEntity<Object> deleteUser(Long id);
	Optional<User> findUserByUserName(String userName);
	Optional<User> findUserByEmail(String email);
	//ResponseEntity<Object> saveUser(User user);
	ResponseEntity<Object> saveUser(UserProfile profile);
	ResponseEntity<Object> updateUser(@Valid UserProfile profile);

}
