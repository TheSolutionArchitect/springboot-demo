package com.awstechguide.cms.springjpah2.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.awstechguide.cms.springjpah2.dto.UserProfile;
import com.awstechguide.cms.springjpah2.entity.Role;
import com.awstechguide.cms.springjpah2.entity.User;
import com.awstechguide.cms.springjpah2.repository.RoleRepository;
import com.awstechguide.cms.springjpah2.repository.UserRepository;
import com.awstechguide.cms.springjpah2.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

	@Override
	public User joinUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

	@Override
    public Optional<User> findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

	@Override
	public ResponseEntity<Object> saveUser(UserProfile profile) {
		User newUser = new User();
		newUser.setUserName(profile.getUser().getUserName().trim());
		newUser.setPassword(bCryptPasswordEncoder.encode(profile.getUser().getPassword()));
		newUser.setEmail(profile.getUser().getEmail());
		newUser.setActive(profile.getUser().isActive());
		
		Role userRole = roleRepository.findByRoleCd("ADMIN");
		newUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		User savedUser = userRepository.save(newUser);
		if (userRepository.findById(savedUser.getId()).isPresent()) {
			return ResponseEntity.accepted()
					.body("Successfully Created Role and User " + profile.getUser().getUserName());
		} else
			return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
	}

	/**
	 * Delete a specified user given the id
	 */
	@Override
	public ResponseEntity<Object> deleteUser(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			if (userRepository.findById(id).isPresent()) {
				return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
			} else
				return ResponseEntity.ok().body("Successfully deleted specified record");
		} else
			return ResponseEntity.unprocessableEntity().body("No Records Found");
	}

	@Override
	public ResponseEntity<Object> updateUser(@Valid UserProfile profile) {
        
    	Optional<User> user = userRepository.findById(profile.getUser().getId());
        if (!user.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        profile.getUser().setId(user.get().getId());
        profile.getUser().setPassword(bCryptPasswordEncoder.encode(profile.getUser().getPassword()));
        User updatedUser = userRepository.save(profile.getUser());
        if (userRepository.findById(updatedUser.getId()).isPresent()) {
			return ResponseEntity.accepted()
					.body("Successfully Updated User " + updatedUser.getUserName());
		} else
			return ResponseEntity.unprocessableEntity().body("Failed to Update specified user");
	}

	// Fix return type to DTO
    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(user.get());
    }
}
