package com.obliqueone.cms.springjpah2.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.obliqueone.cms.springjpah2.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleProfile {

	@Id
	//@Column(name = "role_id")
	@GeneratedValue
	private int id;
	private String roleName;
	private String roleCd;
	private String roleDesc;
	private boolean enabled;

}
