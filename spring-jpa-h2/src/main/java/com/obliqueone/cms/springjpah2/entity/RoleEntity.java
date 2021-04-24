package com.obliqueone.cms.springjpah2.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ROLES")
public class RoleEntity {

	@Id
	//@Column(name = "role_id")
	@GeneratedValue
	private int id;
	private String roleName;
	private String roleCd;
	private String roleDesc;
	private boolean enabled;

}
