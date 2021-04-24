package com.obliqueone.cms.springjpah2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.obliqueone.cms.springjpah2.domain.Role;
import com.obliqueone.cms.springjpah2.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{
	
    public Role getRoleByName(@Param("username") String username);
}
