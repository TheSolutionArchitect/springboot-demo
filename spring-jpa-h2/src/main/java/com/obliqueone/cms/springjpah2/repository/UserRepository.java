package com.obliqueone.cms.springjpah2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obliqueone.cms.springjpah2.entity.UserEntity;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByUserName(String username);
}