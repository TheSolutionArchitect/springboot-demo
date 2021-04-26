package com.awstechguide.cms.springjpah2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awstechguide.cms.springjpah2.entity.Role;
import com.awstechguide.cms.springjpah2.repository.RoleRepository;
import com.awstechguide.cms.springjpah2.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository repository;
	
	@Override
	public Role saveRole(Role role) {
		return repository.save(role);
	}
}
