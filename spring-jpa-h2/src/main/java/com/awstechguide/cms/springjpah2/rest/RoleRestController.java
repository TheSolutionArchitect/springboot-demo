package com.awstechguide.cms.springjpah2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awstechguide.cms.springjpah2.entity.Role;
import com.awstechguide.cms.springjpah2.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleRestController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping("/")
	public Role save(@RequestBody Role entity) {
		return roleService.saveRole(entity);
	}
}
