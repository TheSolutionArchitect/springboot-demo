package com.awstechguide.cms.springjpah2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awstechguide.cms.springjpah2.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRoleName(String name);
	Role findByRoleCd(String role);
}
