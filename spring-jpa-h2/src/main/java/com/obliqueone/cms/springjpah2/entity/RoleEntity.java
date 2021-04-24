package com.obliqueone.cms.springjpah2.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ROLE")
public class RoleEntity {

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String roleName;
	private String roleCd;
	private String roleDesc;
	private boolean enabled;

	@ManyToMany(mappedBy = "roles")
	private Collection<UserEntity> users;

	@ManyToMany
	@JoinTable(name = "role_permission_assoc", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
	private Collection<PermissionEntity> permissions;

}
