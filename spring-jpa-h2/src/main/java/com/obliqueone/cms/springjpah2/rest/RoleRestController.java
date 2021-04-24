package com.obliqueone.cms.springjpah2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obliqueone.cms.springjpah2.entity.RoleEntity;
import com.obliqueone.cms.springjpah2.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleRestController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping("/")
	public RoleEntity save(@RequestBody RoleEntity entity) {
		return roleService.saveRole(entity);
	}
}
