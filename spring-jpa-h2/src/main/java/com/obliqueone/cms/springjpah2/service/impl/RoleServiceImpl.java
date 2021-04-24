package com.obliqueone.cms.springjpah2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obliqueone.cms.springjpah2.entity.RoleEntity;
import com.obliqueone.cms.springjpah2.repository.RoleRepository;
import com.obliqueone.cms.springjpah2.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository repository;
	
	@Override
	public RoleEntity saveRole(RoleEntity entity) {
		return repository.save(entity);
	}
}
