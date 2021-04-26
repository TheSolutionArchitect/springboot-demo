package com.awstechguide.cms.springjpah2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awstechguide.cms.springjpah2.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findByUserName(String username);
    User findByEmail(String email);
}